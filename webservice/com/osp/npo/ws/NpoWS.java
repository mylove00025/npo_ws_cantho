package com.osp.npo.ws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebService;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.Crypter;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.AbstractWsInfo;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.announcement.AnnouncementWsInfo;
import com.osp.npo.core.announcement.AnnouncementWsList;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;
import com.osp.npo.core.diagnostic.DiagnosticInfo;
import com.osp.npo.core.office.NotaryOfficeInfo;
import com.osp.npo.core.prevent.DataPreventHistoryWsList;
import com.osp.npo.core.prevent.DataPreventWsInfo;
import com.osp.npo.core.prevent.DataPreventWsList;
import com.osp.npo.core.prevent.PropertyPreventWsList;
import com.osp.npo.core.prevent.TransactionPropertyWsInfo;
import com.osp.npo.core.prevent.TransactionPropertyWsList;
import com.osp.npo.core.synchronize.SynchronizeWsInfo;
import com.osp.npo.core.user.UserWsInfo;
import com.osp.npo.core.user.UserWsList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.AnnouncementWsService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ConnectionService;
import com.osp.npo.service.ContractHistoryService;
import com.osp.npo.service.DiagnosticService;
import com.osp.npo.service.OfficeService;
import com.osp.npo.service.PreventWsService;
import com.osp.npo.service.SynchronizeWsService;
import com.osp.npo.service.UserWsService;

@WebService
public class NpoWS {
    
    private static final Byte DATA_PREVENT = 1;
    private static final Byte TRANSACTION_PROPERTY = 2;
    private static final Byte ANNOUNCEMENT = 3;
    
    private static final Byte ACTION_ADD = 1;
    private static final Byte ACTION_EDIT = 2;
    private static final Byte ACTION_DELETE = 3;
    //private static final Byte ACTION_RELEASE = 4;
    private static final Byte FIRST_SYNCHRONIZE = 5;
    
    private static final Byte STATUS_SYNCHRONIZE = 0;
    //private static final Byte STATUS_ERROR = 1;
    
    //private static final String PREVENT_UPLOAD_FOLDER_KEY = "system_prevent_data_folder";
    private static final String ANNOUNCEMENT_UPLOAD_FOLDER_KEY = "system_announcement_folder";
    //private static final String PREVENT_FILE_NAME_PREFIX = "PRV_";
    private static final String ANNOUNCEMENT_FILE_NAME_PREFIX = "ANNT_";
    
    private static final String ORDER_FIELD = "entry_date_time";
    
    private Integer synchronizeRecord = 100;
    
    /** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
        .getLogger(NpoWS.class.getName());
    
    /**
     * Process synchronize request from client
     * 
     * @param clientInfo
     * @return
     */
    public WebserviceInfo synchronizeDB(WebserviceInfo clientInfo) {
        
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
        WebserviceInfo serverInfo = new WebserviceInfo();
        List<String> idList = new ArrayList<String>();
        List<ContentInfo> contentList = new ArrayList<ContentInfo>();
        
        Connection connection = null;
        
        try {
            
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.openConnection();
          
            UserWsService userService = new UserWsService(connection);
          
            if (clientInfo != null) {
              
                //authentication
                userService.setActiveFlgFilter(Boolean.TRUE);
                userService.setHiddenFlgFilter(Boolean.FALSE);
                userService.setOfficeActiveFlgFilter(Boolean.TRUE);
                userService.setOfficeHiddenFlgFilter(Boolean.FALSE);
                userService.setAccountIdFilter(clientInfo.getAccount(), FilterKind.FULL);
                //userService.setAuthenticationIdFilter(clientInfo.getAuthenticationId());
              
                UserWsInfo userWsInfo = authenticate(clientInfo.getAccount(), clientInfo.getPassword(), 
                        clientInfo.getAuthenticationId(), clientInfo.getAuthenticationCode(), userService);
                
                if (userWsInfo != null) {
                	
                	ConnectionService poolService = new ConnectionService(connection);
                	
                	if(poolService.getPoolToken(clientInfo.getAuthenticationId())) {
                	
                		connection.commit();
                		
	                	// Get data from client
	                	getDataFromClient(clientInfo, userWsInfo, connection, idList, logMessage);
	                  
	                    // Put data to server
	                    putDataToClient(clientInfo, connection, contentList, logMessage);
	                    
	                    OfficeService officeService = new OfficeService(connection);
	                    updateLastConnectionTime(clientInfo.getAuthenticationId(), officeService);
	                    
	                    poolService.closePool(clientInfo.getAuthenticationId());
                	}
                    connection.commit();
                    
                } else {
                	writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] - Account [" + clientInfo.getAccount() + "]: authentication failed");
                }
              
            }
          
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
            /** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
        }
        
        serverInfo.setContentInfoList(contentList);
        serverInfo.setDataIdList(idList);
        
        return serverInfo;
    }
    
    /**
     * Cap nhat ket qua dong bo tu client
     * 
     * @param clientInfo
     * @return
     */
    public String synchronize(WebserviceInfo clientInfo) {
        
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
        Connection connection = null;
        
        try {
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.openConnection();
            
            UserWsService userService = new UserWsService(connection);
            SynchronizeWsService synchronizeService = new SynchronizeWsService(connection);
            
            if (clientInfo != null) {
                UserWsInfo userWsInfo = authenticate(clientInfo.getAccount(), clientInfo.getPassword(), 
                        clientInfo.getAuthenticationId(), clientInfo.getAuthenticationCode(), userService);
                if (userWsInfo != null) {
                    
                	ConnectionService poolService = new ConnectionService(connection);
                	
                	//Check connection pool
                	if(poolService.getPoolToken(clientInfo.getAuthenticationId())) {
                	
                		connection.commit();
                		
	                    if (clientInfo.getDataIdList() != null && clientInfo.getDataIdList().size() > 0) {
	                    	//Toi uu code (HaiNT 2011.03.18)
	                    	synchronizeService.removeSynchronize(clientInfo.getDataIdList(), clientInfo.getAuthenticationId());
	                        connection.commit();
	                    }
	                    
	                    if (synchronizeService.changeErrorStatus(clientInfo.getAuthenticationId()) > 0) {
	                    	connection.commit();
	                    }
	                    
	                    OfficeService officeService = new OfficeService(connection);
	                    updateLastConnectionTime(clientInfo.getAuthenticationId(), officeService);
                    
	                    poolService.closePool(clientInfo.getAuthenticationId());
                	}
                    connection.commit();
                    
                } else {
                	writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] - Account [" + clientInfo.getAccount() + "]: authentication failed");
                }
            }
            
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
            /** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
        }
        
        return null;
    }
    
    /**
     * Dong bo tat ca du lieu
     * 
     * @param clientInfo
     * @return
     */
    public Boolean synchronizeFirstTime(WebserviceInfo clientInfo) {
        
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
        Boolean result = Boolean.FALSE;
        
        Connection connection = null;
        
        try {
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.openConnection();
          
            UserWsService userService = new UserWsService(connection);
            SynchronizeWsService synchronizeService = new SynchronizeWsService(connection);
          
            if (clientInfo != null) {
              
                UserWsInfo userWsInfo = authenticate(clientInfo.getAccount(), clientInfo.getPassword(), 
                        clientInfo.getAuthenticationId(), clientInfo.getAuthenticationCode(), userService);
                if (userWsInfo != null) {
                	
                	OfficeService officeService = new OfficeService(connection);
                	NotaryOfficeInfo noInfo = officeService.queryByAuthenticationId(clientInfo.getAuthenticationId(), Boolean.FALSE);
                	
                	synchronizeService.removeSynchByAuthId(clientInfo.getAuthenticationId());
                	
                	if (noInfo.getSynchronizeType().intValue() == 2) {
                		synchronizeService.entryAllSyncPreventData(clientInfo.getAuthenticationId());
                		synchronizeService.entryAllSyncTransProperty(clientInfo.getAuthenticationId());
                	}
                	
                    synchronizeService.entryAllSyncAnnouncement(clientInfo.getAuthenticationId());
                    
                    connection.commit();
                    result = Boolean.TRUE;
                    
                    
                    updateLastConnectionTime(clientInfo.getAuthenticationId(), officeService);
                    connection.commit();
                    
                } else {
                    writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] - Account [" + clientInfo.getAccount() + "]: authentication failed");
                }
            }
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
            /** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
        }
        return result;
    }
    
    /**
     * Dong bo tat ca du lieu
     * 
     * @param clientInfo
     * @return
     */
    public Boolean checkData(WebserviceInfo clientInfo) {
        
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
        Boolean result = Boolean.FALSE;
        
        Connection connection = null;
        
        try {
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.openConnection();
          
            UserWsService userService = new UserWsService(connection);
          
            if (clientInfo != null) {
              
                UserWsInfo userWsInfo = authenticate(clientInfo.getAccount(), clientInfo.getPassword(), 
                        clientInfo.getAuthenticationId(), null, userService);
                if (userWsInfo != null) {
                	
                    if (clientInfo.getDiagnosticInfoList() != null) {
                    	DiagnosticService diagnosticSrv = new DiagnosticService(connection);
                    	
                    	for (DiagnosticWsInfo dwsInfo : clientInfo.getDiagnosticInfoList()) {
                    		DiagnosticInfo dInfo = diagnosticSrv.queryDiagnosticByPK(false, clientInfo.getAuthenticationId(),
                    				dwsInfo.getCommandCode());
                    		
                    		boolean isEntry = false;
                    		if (dInfo == null) {
                    			dInfo = new DiagnosticInfo();
                    			isEntry = true;
                    		}
                    		
                    		dInfo.setOfficeCode(clientInfo.getAuthenticationId());
                    		dInfo.setCommandCode(dwsInfo.getCommandCode());
                    		dInfo.setNumberResult(dwsInfo.getNumberResult());
                    		dInfo.setStringResult(dwsInfo.getStringResult());
                    		dInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
                    		
                    		if (isEntry) {
                    			diagnosticSrv.entryDiagnostic(dInfo);
                    		} else {
                    			diagnosticSrv.modifyDiagnostic(dInfo);
                    		}
                    	}
                    	
                    	connection.commit();
                    }
                	
                    result = Boolean.TRUE;
                } else {
                    writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] - Account [" + clientInfo.getAccount() + "]: authentication failed");
                }
            }
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
            /** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
        }
        return result;
    }
    
    /**
     * Get data from client
     * 
     * @param clientInfo
     * @param userWsInfo
     * @param connection
     * @param idList
     * @param logMessage
     */
    private void getDataFromClient(WebserviceInfo clientInfo, UserWsInfo userWsInfo, Connection connection, 
    		List<String> idList, NpoLogMessage logMessage) {
    	if (clientInfo.getContentInfoList() != null) {
    		
    		PreventWsService preventService = new PreventWsService(connection);
    		AnnouncementWsService announcementService = new AnnouncementWsService(connection);
    		SynchronizeWsService synchronizeService = new SynchronizeWsService(connection);
    		
            for (ContentInfo contentInfo : clientInfo.getContentInfoList()) {
                
                try {
                    
                    SynchronizeWsInfo synchronizeWsInfo = contentInfo.getSynchronizeWsInfo();
                    
                    File clientAttackFile = null;
                    //File clientReleaseFile = null;
                    
                    //synchronize data prevent
                    //TODO Khong dong bo DLNC (STPHN 12/6/2012)
                    /*
                    if (contentInfo.getDataPreventWsInfo() != null && contentInfo.getPropertyPreventWsInfo() != null
                            && DATA_PREVENT.equals(synchronizeWsInfo.getType()) ) {
                        
                        if (contentInfo.getFileAttachment() != null) {
                            clientAttackFile = FileUtil.createNewFile(
                                    SystemProperties.getProperty(PREVENT_UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
                            try {
                                FileOutputStream outputStream = new FileOutputStream(clientAttackFile);
                                outputStream.write(contentInfo.getFileAttachment());
                                outputStream.close();
                                
                            } catch (IOException exception) {
                                writeLog("fromclient:" + clientInfo.getAuthenticationId() 
                                        + " type:" + contentInfo.getSynchronizeWsInfo().getType() 
                                        + " synid=" + contentInfo.getSynchronizeWsInfo().getDataId());
                                logger.logging(logMessage, exception);
                            }
                        }
                        
                        if (contentInfo.getReleaseFile() != null) {
                            clientReleaseFile = FileUtil.createNewFile(
                                    SystemProperties.getProperty(PREVENT_UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
                            try {
                                FileOutputStream outputStream = new FileOutputStream(clientReleaseFile);
                                outputStream.write(contentInfo.getReleaseFile());
                                outputStream.close();
                                
                            } catch (IOException exception) {
                                writeLog("fromclient:" + clientInfo.getAuthenticationId() 
                                        + " type:" + contentInfo.getSynchronizeWsInfo().getType() 
                                        + " synid=" + contentInfo.getSynchronizeWsInfo().getDataId());
                                logger.logging(logMessage, exception);
                            }
                        }
                        
                        DataPreventHistoryWsInfo dataPreventHistoryInfo = new DataPreventHistoryWsInfo();
                        dataPreventHistoryInfo.setClientInfo(SystemMessageProperties.getSystemProperty("item_ws_history"));
                        dataPreventHistoryInfo.setExecuteDateTime(Calendar.getInstance());
                        dataPreventHistoryInfo.setExecutePerson(userWsInfo.getFullName()
                              + Constants.SPACE + "(" +  userWsInfo.getAccount() + ")");
                      
                        if (ACTION_EDIT.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
                            DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
                            if (dataPreventList.size() > 0) {
                                DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
                                dataPreventWsInfo.setId(dataPreventList.get(0).getId());
                                if (dataPreventWsInfo.getPreventFileName() != null && clientAttackFile != null) {
                                    dataPreventWsInfo.setPreventFilePath(clientAttackFile.getAbsolutePath());
                                }
                                if (dataPreventWsInfo.getReleaseFileName() != null && clientReleaseFile != null) {
                                    dataPreventWsInfo.setReleaseFilePath(clientReleaseFile.getAbsolutePath());
                                }
                                
                                createUpdateUserInfo(clientInfo.getAccount(), dataPreventWsInfo);
                                
                                preventService.modifyDataPrevent(dataPreventWsInfo);
                                
                                PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
                                propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
                                preventService.modifyPropertyPrevent(propertyPreventWsInfo);
                                dataPreventHistoryInfo.setPreventId(dataPreventList.get(0).getId());
                                dataPreventHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_edit"));
                              
                                preventService.entryDataPreventHistory(dataPreventHistoryInfo);
                            }
                        }
                        if (ACTION_DELETE.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
                            DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
                            if (dataPreventList.size() > 0) {
                                DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
                                dataPreventWsInfo.setId(dataPreventList.get(0).getId());
                                if (dataPreventWsInfo.getPreventFileName() != null && clientAttackFile != null) {
                                    dataPreventWsInfo.setPreventFilePath(clientAttackFile.getAbsolutePath());
                                }
                                if (dataPreventWsInfo.getReleaseFileName() != null && clientReleaseFile != null) {
                                    dataPreventWsInfo.setReleaseFilePath(clientReleaseFile.getAbsolutePath());
                                }
                                
                                createUpdateUserInfo(clientInfo.getAccount(), dataPreventWsInfo);
                                
                                preventService.modifyDataPrevent(dataPreventWsInfo);
                                PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
                                propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
                                preventService.modifyPropertyPrevent(propertyPreventWsInfo);
                                dataPreventHistoryInfo.setPreventId(dataPreventList.get(0).getId());
                                dataPreventHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_delete"));
                              
                                preventService.entryDataPreventHistory(dataPreventHistoryInfo);
                            }
                        }
                        if (ACTION_RELEASE.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
                            DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
                            if (dataPreventList.size() > 0) {
                                DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
                                dataPreventWsInfo.setId(dataPreventList.get(0).getId());
                                if (dataPreventWsInfo.getPreventFileName() != null && clientAttackFile != null) {
                                    dataPreventWsInfo.setPreventFilePath(clientAttackFile.getAbsolutePath());
                                }
                                if (dataPreventWsInfo.getReleaseFileName() != null && clientReleaseFile != null) {
                                    dataPreventWsInfo.setReleaseFilePath(clientReleaseFile.getAbsolutePath());
                                }
                                
                                createUpdateUserInfo(clientInfo.getAccount(), dataPreventWsInfo);
                                
                                preventService.modifyDataPrevent(dataPreventWsInfo);
                                PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
                                propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
                                preventService.modifyPropertyPrevent(propertyPreventWsInfo);
                                
                                dataPreventHistoryInfo.setPreventId(dataPreventList.get(0).getId());
                                dataPreventHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_release"));
                              
                                preventService.entryDataPreventHistory(dataPreventHistoryInfo);
                            }
                        }
                        
                        if (ACTION_ADD.equals(synchronizeWsInfo.getAction()) ||
                        		FIRST_SYNCHRONIZE.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
                            DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
                            
                            dataPreventHistoryInfo.setExecuteContent(
                                    SystemMessageProperties.getSystemProperty("item_synchronize_from_client") 
                                    + Constants.SPACE + clientInfo.getAuthenticationId());
                            
                            if (dataPreventList.size() > 0) {
                                DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
                                dataPreventWsInfo.setId(dataPreventList.get(0).getId());
                                if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && clientAttackFile != null) {
                                    dataPreventWsInfo.setPreventFilePath(clientAttackFile.getAbsolutePath());
                                }
                                if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && clientReleaseFile != null) {
                                    dataPreventWsInfo.setReleaseFilePath(clientReleaseFile.getAbsolutePath());
                                }
                                
                                createUpdateUserInfo(clientInfo.getAccount(), dataPreventWsInfo);
                                
                                preventService.modifyDataPrevent(dataPreventWsInfo);
                                
                                PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
                                propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
                                preventService.modifyPropertyPrevent(propertyPreventWsInfo);
                                
                                dataPreventHistoryInfo.setPreventId(dataPreventList.get(0).getId());
                              
                                preventService.entryDataPreventHistory(dataPreventHistoryInfo);
                                
                            } else {
                                PropertyPreventWsInfo propertyPreventInfo = contentInfo.getPropertyPreventWsInfo();
                                if (propertyPreventInfo != null) {
                                    preventService.entryPropertyPrevent(propertyPreventInfo);
                                }
                              
                                DataPreventWsInfo dataPreventInfo = contentInfo.getDataPreventWsInfo();
                                dataPreventInfo.setPropertyId(propertyPreventInfo.getId());
                                if (!EditString.isNull(dataPreventInfo.getPreventFileName()) && clientAttackFile != null) {
                                    dataPreventInfo.setPreventFilePath(clientAttackFile.getAbsolutePath());
                                }
                                if (!EditString.isNull(dataPreventInfo.getReleaseFileName()) && clientReleaseFile != null) {
                                    dataPreventInfo.setReleaseFilePath(clientReleaseFile.getAbsolutePath());
                                }
                                
                                createEntryUserInfo(clientInfo.getAccount(), dataPreventInfo);
                                preventService.entryDataPrevent(dataPreventInfo);
                              
                                dataPreventHistoryInfo.setPreventId(dataPreventInfo.getId());
                              
                                preventService.entryDataPreventHistory(dataPreventHistoryInfo);
                            }
                        }
                        
                        //update history for synchronize object
                        synchronizeWsInfo.setHistoryId(dataPreventHistoryInfo.getHid());
                        
                    }
                    */
                  
                    //synchronize transaction property
                    if (TRANSACTION_PROPERTY.equals(synchronizeWsInfo.getType()) ) {
                      
                        if (contentInfo.getTransactionPropertyWsInfo() != null
                                && ACTION_EDIT.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPropertySynchronizeIdFilter(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
                            if (transactionPropertyList.size() > 0) {
                                TransactionPropertyWsInfo transactionPropertyInfo = contentInfo.getTransactionPropertyWsInfo();
                                transactionPropertyInfo.setTpid(transactionPropertyList.get(0).getTpid());
                                
                                createUpdateUserInfo(clientInfo.getAccount(), contentInfo.getTransactionPropertyWsInfo());
                                preventService.modifyTransactionProperty(transactionPropertyInfo);
                                
                                //Entry history
                                ContractHistoryInfo historyInfo = new ContractHistoryInfo();
                            	historyInfo.setTpid(contentInfo.getTransactionPropertyWsInfo().getTpid());
                            	historyInfo.setSynchronizeId(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            	historyInfo.setContractNumber(contentInfo.getTransactionPropertyWsInfo().getContractNumber());
                            	historyInfo.setClientInfo(clientInfo.getAuthenticationId());
                            	historyInfo.setExecuteDateTime(RelateDateTime.getTimeNow());
                            	historyInfo.setExecutePerson(userWsInfo.getAccount());
                            	historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_edit"));
                            	historyInfo.setContractContent(getContractContent(contentInfo.getTransactionPropertyWsInfo()));
                            	
                            	ContractHistoryService historyService = new ContractHistoryService(connection);
                            	historyService.entryContractHistory(historyInfo);
                            }
                        }
                        if (ACTION_DELETE.equals(synchronizeWsInfo.getAction())) {
                            preventService.setPropertySynchronizeIdFilter(contentInfo.getSynchronizeWsInfo().getDataId());
                            TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionPropertyWS(Boolean.FALSE);
                            if (transactionPropertyList.size() > 0) {
                                preventService.removeTransactionProperty(transactionPropertyList.get(0).getTpid());
                                
                                TransactionPropertyWsInfo tpInfo = transactionPropertyList.get(0);
                                //Entry history
                                ContractHistoryInfo historyInfo = new ContractHistoryInfo();
                            	historyInfo.setTpid(tpInfo.getTpid());
                            	historyInfo.setSynchronizeId(tpInfo.getSynchronizeId());
                            	historyInfo.setContractNumber(tpInfo.getContractNumber());
                            	historyInfo.setClientInfo(clientInfo.getAuthenticationId());
                            	historyInfo.setExecuteDateTime(RelateDateTime.getTimeNow());
                            	historyInfo.setExecutePerson(userWsInfo.getAccount());
                            	historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_delete"));
                            	historyInfo.setContractContent(getContractContent(tpInfo));
                            	
                            	ContractHistoryService historyService = new ContractHistoryService(connection);
                            	historyService.entryContractHistory(historyInfo);
                            }
                        }
                        if (contentInfo.getTransactionPropertyWsInfo() != null && (ACTION_ADD.equals(synchronizeWsInfo.getAction()) ||
                        		FIRST_SYNCHRONIZE.equals(synchronizeWsInfo.getAction()))) {
                            //writeLog("synid=" + contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            preventService.setPropertySynchronizeIdFilter(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
                            //writeLog("size=" + transactionPropertyList.size());
                            if (transactionPropertyList.size() > 0) {
                                TransactionPropertyWsInfo transactionPropertyInfo = contentInfo.getTransactionPropertyWsInfo();
                                transactionPropertyInfo.setTpid(transactionPropertyList.get(0).getTpid());
                                
                                createUpdateUserInfo(clientInfo.getAccount(), contentInfo.getTransactionPropertyWsInfo());
                                preventService.modifyTransactionProperty(transactionPropertyInfo);
                                
                                //Entry history
                                ContractHistoryInfo historyInfo = new ContractHistoryInfo();
                            	historyInfo.setTpid(contentInfo.getTransactionPropertyWsInfo().getTpid());
                            	historyInfo.setSynchronizeId(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            	historyInfo.setContractNumber(contentInfo.getTransactionPropertyWsInfo().getContractNumber());
                            	historyInfo.setClientInfo(clientInfo.getAuthenticationId());
                            	historyInfo.setExecuteDateTime(RelateDateTime.getTimeNow());
                            	historyInfo.setExecutePerson(userWsInfo.getAccount());
                            	historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_edit"));
                            	historyInfo.setContractContent(getContractContent(contentInfo.getTransactionPropertyWsInfo()));
                            	
                            	ContractHistoryService historyService = new ContractHistoryService(connection);
                            	historyService.entryContractHistory(historyInfo);
                            } else {
                            	createEntryUserInfo(clientInfo.getAccount(), contentInfo.getTransactionPropertyWsInfo());
                                preventService.entryTransactionProperty(contentInfo.getTransactionPropertyWsInfo());
                                
                                
                                //Entry history
                                ContractHistoryInfo historyInfo = new ContractHistoryInfo();
                            	historyInfo.setTpid(contentInfo.getTransactionPropertyWsInfo().getTpid());
                            	historyInfo.setSynchronizeId(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
                            	historyInfo.setContractNumber(contentInfo.getTransactionPropertyWsInfo().getContractNumber());
                            	historyInfo.setClientInfo(clientInfo.getAuthenticationId());
                            	historyInfo.setExecuteDateTime(RelateDateTime.getTimeNow());
                            	historyInfo.setExecutePerson(userWsInfo.getAccount());
                            	historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("item_action_add"));
                            	historyInfo.setContractContent(getContractContent(contentInfo.getTransactionPropertyWsInfo()));
                            	
                            	ContractHistoryService historyService = new ContractHistoryService(connection);
                            	historyService.entryContractHistory(historyInfo);
                            }
                        }
                    }
                  
                    //synchronize announcement
                    if (ANNOUNCEMENT.equals(synchronizeWsInfo.getType()) ) {
                        
                        if (contentInfo.getFileAttachment() != null) {
                            clientAttackFile = FileUtil.createNewFile(
                                    SystemProperties.getProperty(ANNOUNCEMENT_UPLOAD_FOLDER_KEY), ANNOUNCEMENT_FILE_NAME_PREFIX);
                            try {
                                FileOutputStream outputStream = new FileOutputStream(clientAttackFile);
                                outputStream.write(contentInfo.getFileAttachment());
                                outputStream.close();
                                
                            } catch (IOException exception) {
                                writeLog("fromclient:" + clientInfo.getAuthenticationId() 
                                        + " type:" + contentInfo.getSynchronizeWsInfo().getType() 
                                        + " synid=" + contentInfo.getSynchronizeWsInfo().getDataId());
                                logger.logging(logMessage, exception);
                            }
                        }
                        
                        if (contentInfo.getAnnouncementWsInfo() != null && ACTION_ADD.equals(synchronizeWsInfo.getAction())) {
                            AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
                            if (announcementWsInfo.getAttachFileName() != null && clientAttackFile != null) {
                                announcementWsInfo.setAttachFilePath(clientAttackFile.getAbsolutePath());
                            }
                            
                            createEntryUserInfo(clientInfo.getAccount(), announcementWsInfo);
                            announcementService.entryAnnouncement(announcementWsInfo);
                        }
                        if (contentInfo.getAnnouncementWsInfo() != null && ACTION_EDIT.equals(synchronizeWsInfo.getAction())) {
                            announcementService.setSynchronizeIdFilter(contentInfo.getAnnouncementWsInfo().getSynchronizeId());
                            AnnouncementWsList announcementList = announcementService.queryAllAnnouncement(Boolean.FALSE);
                            if (announcementList.size() > 0) {
                                AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
                                announcementWsInfo.setAid(announcementList.get(0).getAid());
                                if (announcementWsInfo.getAttachFileName() != null && clientAttackFile != null) {
                                    announcementWsInfo.setAttachFilePath(clientAttackFile.getAbsolutePath());
                                }
                                
                                createUpdateUserInfo(clientInfo.getAccount(), announcementWsInfo);
                                announcementService.modifyAnnouncement(announcementWsInfo);
                            }
                        }
                        if (ACTION_DELETE.equals(synchronizeWsInfo.getAction())) {
                            announcementService.setSynchronizeIdFilter(contentInfo.getSynchronizeWsInfo().getDataId());
                            AnnouncementWsList announcementList = announcementService.queryAllAnnouncement(Boolean.FALSE);
                            if (announcementList.size() > 0) {
                                AnnouncementWsInfo announcementWsInfo = announcementList.get(0);
                                if (announcementWsInfo.getAttachFileName() != null && announcementWsInfo.getAttachFilePath() != null) {
                                    File removeFile = new File(announcementWsInfo.getAttachFilePath());
                                    removeFile.delete();
                                }
                                announcementService.removeAnnouncement(announcementList.get(0).getAid());
                            }
                        }
                        
                    }
                    
                    //add to synchronize table
                    synchronizeService.entrySyncDataServer(synchronizeWsInfo.getType(), synchronizeWsInfo.getDataId(),
                            synchronizeWsInfo.getAction(), synchronizeWsInfo.getHistoryId(), Calendar.getInstance(),
                            clientInfo.getAuthenticationId());
                    
                    connection.commit();
                    idList.add(contentInfo.getSynchronizeWsInfo().getDataId());
                    
                } catch (SQLException sqlError) {
                	
                    /** Write log */
                    writeLog("fromclient:" + clientInfo.getAuthenticationId() 
                            + " type:" + contentInfo.getSynchronizeWsInfo().getType() 
                            + " synid:" + contentInfo.getSynchronizeWsInfo().getDataId());
                    logger.logging(logMessage, sqlError);

                } catch (Exception exception) {
                	
                    /** Write log */
                    writeLog("fromclient:" + clientInfo.getAuthenticationId() 
                            + " type:" + contentInfo.getSynchronizeWsInfo().getType() 
                            + " synid:" + contentInfo.getSynchronizeWsInfo().getDataId());
                    logger.logging(logMessage, exception);
                } finally {

                    try {
                        if (connection != null) {
                            /** Rollback connection */
                            connection.rollback();
                        }
                    } catch (Exception ex) {
                        logger.logging(logMessage, ex);
                    }
                }
                
            }
        }
    }
    
    /**
     * Put data to client
     * 
     * @param clientInfo
     * @param connection
     * @param contentList
     * @param logMessage
     * @throws SQLException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
	private void putDataToClient(WebserviceInfo clientInfo, Connection connection, 
    		List<ContentInfo> contentList, NpoLogMessage logMessage) throws SQLException, IOException {
    	
    	CommonService commonService = new CommonService(connection);
        SynchronizeWsService synchronizeService = new SynchronizeWsService(connection);
        PreventWsService preventService = new PreventWsService(connection);
        AnnouncementWsService announcementService = new AnnouncementWsService(connection);
        
    	//get server data
        String record = "";
        SystemConfigInfo systemConfigInfo = commonService.querySystemConfigByKey("synchronize_record", Boolean.FALSE);
        if (systemConfigInfo != null) {
            record = systemConfigInfo.getConfigValue();
        }
        
        synchronizeService.addOrderField(new OrderField(ORDER_FIELD));
        synchronizeService.setAuthenticationIdFilter(clientInfo.getAuthenticationId());
        
        if (!EditString.isNull(record) && EditString.isNumber(record)) {
            synchronizeRecord = Integer.parseInt(record);
        }
        
        //Kiem tra dong bo theo lo
//        boolean isBatchSynchronize = false;
//        int totalCount = synchronizeService.countByOffice(clientInfo.getAuthenticationId(), TRANSACTION_PROPERTY);
//        if (totalCount > 1000) {
//        	isBatchSynchronize = true;
//        }
        
        List<SynchronizeWsInfo> synchronizeList = synchronizeService.querySynchronize(Boolean.FALSE, 1, synchronizeRecord).getList();
        
        for (SynchronizeWsInfo synchronizeInfo : synchronizeList) {
            
            try {
                File serverAttackFile = null;
                File serverReleaseFile = null;
                
                //HaiNT 2011.03.18
                //Neu action la ADD thi coi nhu la FIRST_SYNCHRONIZE
                if (ACTION_ADD.equals(synchronizeInfo.getAction())) {
                	synchronizeInfo.setAction(FIRST_SYNCHRONIZE);
                }
                
                ContentInfo contentInfo = new ContentInfo();
                contentInfo.setSynchronizeWsInfo(synchronizeInfo);
                
                boolean dataNotExist = false;
                
                if (DATA_PREVENT.equals(synchronizeInfo.getType())) {
                    preventService.setPreventSynchronizeIdFilter(synchronizeInfo.getDataId());
                    DataPreventWsList dataPreventList = preventService.queryAllDataPreventWS(Boolean.FALSE);
                    if (dataPreventList.size() > 0) {
                        DataPreventWsInfo dataPreventWsInfo = dataPreventList.get(0);                        
                        if (dataPreventList.get(0).getPropertyId() != null) {
                            preventService.setPropertyPreventIdFilter(dataPreventWsInfo.getPropertyId());
                            PropertyPreventWsList propertyPreventList = preventService.queryAllPropertyPreventWS(Boolean.FALSE);
                            if (propertyPreventList.size() > 0) {
                                contentInfo.setPropertyPreventWsInfo(propertyPreventList.get(0));
                                dataPreventWsInfo.setPropertyId(null);
                                
                                preventService.setHistoryIdFilter(synchronizeInfo.getHistoryId());
                                DataPreventHistoryWsList dataPreventHistoryWsList = preventService.queryAllDataPreventHistoryWs(Boolean.FALSE);
                                if (dataPreventHistoryWsList.size() > 0) {
                                    contentInfo.setDataPreventHistoryWsInfo(dataPreventHistoryWsList.get(0));
                                    contentInfo.setDataPreventWsInfo(dataPreventWsInfo);
                                    contentList.add(contentInfo);
                                }
                                
                                if (dataPreventWsInfo.getPreventFileName() != null && dataPreventWsInfo.getPreventFilePath() != null) {
                                    try {
                                        serverAttackFile = new File(dataPreventWsInfo.getPreventFilePath());
                                    } catch (Exception exception) {
                                        writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] type:" + synchronizeInfo.getType() 
                                        		+ " synid=" + synchronizeInfo.getDataId());
                                        logger.logging(logMessage, exception);
                                    }
                                    
                                }
                                if (dataPreventWsInfo.getReleaseFileName() != null && dataPreventWsInfo.getReleaseFilePath() != null) {
                                    try {
                                        serverReleaseFile = new File(dataPreventWsInfo.getReleaseFilePath());
                                    } catch (Exception exception) {
                                        writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] type:" + synchronizeInfo.getType() 
                                        		+ " synid=" + synchronizeInfo.getDataId());
                                        logger.logging(logMessage, exception);
                                    }
                                }
                            }
                            
                        }
                    } else {
                    	dataNotExist = true;
                    }
                }
              
                if (TRANSACTION_PROPERTY.equals(synchronizeInfo.getType())) {
                    if (!ACTION_DELETE.equals(synchronizeInfo.getAction())) {
                        preventService.setPropertySynchronizeIdFilter(synchronizeInfo.getDataId());
                        TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionPropertyWS(Boolean.FALSE);
                        if (transactionPropertyList.size() > 0) {
                            contentInfo.setTransactionPropertyWsInfo(transactionPropertyList.get(0));
                            
                            contentList.add(contentInfo);
                        } else {
                        	dataNotExist = true;
                        }
                    } else {
                    	contentList.add(contentInfo);
                    }
                }
              
                if (ANNOUNCEMENT.equals(synchronizeInfo.getType())) {
                    if (!ACTION_DELETE.equals(synchronizeInfo.getAction())) {
                        announcementService.setSynchronizeIdFilter(synchronizeInfo.getDataId());
                        AnnouncementWsList announcementList = announcementService.queryAllAnnouncementWS(Boolean.FALSE);
                        if (announcementList.size() > 0) {
                            contentInfo.setAnnouncementWsInfo(announcementList.get(0));
                            if (announcementList.get(0).getAttachFileName() != null 
                                    && announcementList.get(0).getAttachFilePath() != null) {
                                try {
                                    serverAttackFile = new File(announcementList.get(0).getAttachFilePath());
                                } catch (Exception exception) {
                                    writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] type:" + synchronizeInfo.getType() 
                                    		+ " synid:" + synchronizeInfo.getDataId());
                                    logger.logging(logMessage, exception);
                                }
                            }
                            
                            contentList.add(contentInfo);
                        } else {
                        	dataNotExist = true;
                        }
                    } else {
                    	contentList.add(contentInfo);
                    }
                }
                
                int len;
                int size = 1024;
                if (serverAttackFile != null && serverAttackFile.exists() && serverAttackFile.canRead()) {
                    InputStream in = new FileInputStream(serverAttackFile);
                    ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                    byte[] buf1 = new byte[size];
                    while ((len = in.read(buf1, 0, size)) != -1) {
                        out1.write(buf1, 0, len);
                    }
                    contentInfo.setFileAttachment(out1.toByteArray());

                }
                if (serverReleaseFile != null && serverReleaseFile.exists() && serverReleaseFile.canRead()) {
                    InputStream in = new FileInputStream(serverReleaseFile);
                    ByteArrayOutputStream out2 = new ByteArrayOutputStream();
                    byte[] buf2 = new byte[size];
                    while ((len = in.read(buf2, 0, size)) != -1) {
                        out2.write(buf2, 0, len);
                    }
                    contentInfo.setReleaseFile(out2.toByteArray());

                }
                
                if (dataNotExist) {
                	//Xoa ban ghi khong ton tai
                	synchronizeService.removeSynchByDataId(synchronizeInfo.getDataId());
                } else {
	                //update status npo_synchronize when server response service
	                synchronizeInfo.setStatus(STATUS_SYNCHRONIZE);
	                synchronizeService.modifySynchronize(synchronizeInfo);
                }
                
                connection.commit();
            } catch (SQLException sqlError) {
            	
                /** Write log */
                writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] type:" + synchronizeInfo.getType() 
                		+ " synid=" + synchronizeInfo.getDataId());
                logger.logging(logMessage, sqlError);

            } catch (Exception exception) {
           	
                /** Write log */
                writeLog("VPCC [" + clientInfo.getAuthenticationId() + "] type:" + synchronizeInfo.getType() 
                		+ " synid=" + synchronizeInfo.getDataId());
                logger.logging(logMessage, exception);
            } finally {

                try {
                    if (connection != null) {
                        /** Rollback connection */
                        connection.rollback();
                    }
                } catch (Exception ex) {
                    logger.logging(logMessage, ex);
                }
            }
        }
    }
    
    
    private void writeLog(String message) {
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB0013");
        logMessage.setValues(new String[]{message});
        
        logger.logging(logMessage);
    }
    
    private UserWsInfo authenticate(String account, String password, String authenId, String authenCode, UserWsService userService)
        throws SQLException, IOException {
        
        if (EditString.isNull(account) || EditString.isNull(password)) {
            return null;
        }
        
        userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.setOfficeActiveFlgFilter(Boolean.TRUE);
        userService.setOfficeHiddenFlgFilter(Boolean.FALSE);
        userService.setAccountIdFilter(account, FilterKind.FULL);
        //userService.setAuthenticationIdFilter(authenId);
      
        UserWsList userList = userService.queryAllUser(Boolean.FALSE);
        if (userList.size() > 0 && Crypter.matches(userList.get(0).getPassword(), password )) {
            return userList.get(0);
        }
        
        return null;
    }
    
    /**
     * Create entry user information
     * 
     * @param info
     */
    private void createEntryUserInfo(String account, AbstractWsInfo info) {
    	/* Entry user */
    	info.setEntryUserName(account);
    	info.setEntryDateTime(Calendar.getInstance());
    	
    	/* Update user */
    	info.setUpdateUserName(account);
    	info.setUpdateDateTime(Calendar.getInstance());
    }
    
    /**
     * Create update user information
     * 
     * @param info
     */
    private void createUpdateUserInfo(String account, AbstractWsInfo info) {
    	/* Update user */
    	info.setUpdateUserName(account);
    	info.setUpdateDateTime(Calendar.getInstance());
    }
    
    
    /**
     * Update last connection time
     * 
     * @param authenticationId
     * @param userService
     * @throws SQLException
     * @throws IOException
     */
    private void updateLastConnectionTime(String authenticationId, OfficeService officeService) throws SQLException, IOException {
    	
    	if (EditString.isNull(authenticationId)) {
            return;
        }
        
        NotaryOfficeInfo info = officeService.queryByAuthenticationId(authenticationId, Boolean.FALSE);
        
        if (info != null) {
            info.setLastConnectionTime(RelateDateTime.getTimeNow());
            officeService.modifyNotaryOffice(info);
        }
        
        return; 
    }
    
    /**
     * Return contract info
     * @param tpInfo
     * @return
     */
	private String getContractContent(TransactionPropertyWsInfo tpInfo) {
		String contractContent = "";
		if (!EditString.isNull(tpInfo.getContractKind())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_kind") + Constants.SPACE
			        + Constants.COLON + Constants.SPACE + tpInfo.getContractKind() + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getContractName())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_template")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getContractName() + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getContractNumber())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_number_contract")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getContractNumber() + Constants.ENTER;
		}

		if (tpInfo.getNotaryDate() != null) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_notary_date") + Constants.SPACE
			        + Constants.COLON + Constants.SPACE + RelateDateTime.toDayMonthYear(tpInfo.getNotaryDate().getTime()) + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getRelationObject())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_relation_object")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getRelationObject() + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getTransactionContent())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_transaction_content")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getTransactionContent() + Constants.ENTER;
		}

//		if (!EditString.isNull(tpInfo.getContractValue())) {
//			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_value")
//			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getContractValue() + Constants.ENTER;
//		}

		if (!EditString.isNull(tpInfo.getNotaryPlace())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_notary_place") + Constants.SPACE
			        + Constants.COLON + Constants.SPACE + tpInfo.getNotaryPlace() + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getPropertyInfo())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_property_contract")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getPropertyInfo() + Constants.ENTER;
		}

		if (!EditString.isNull(tpInfo.getContractPeriod())) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_contract_period")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getContractPeriod() + Constants.ENTER;
		}

		if (tpInfo.getMortageCancelFlag() != null && tpInfo.getMortageCancelFlag()) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_mortage_cancel")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_mortage_date")
			        + Constants.SPACE + tpInfo.getMortageCancelDate() + " " + tpInfo.getMortageCancelNote() + Constants.ENTER;
		}

		if (tpInfo.getCancelStatus() != null && tpInfo.getCancelStatus()) {
			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_cancel_contract")
			        + Constants.SPACE + Constants.COLON + Constants.SPACE + tpInfo.getCancelDescription() + Constants.ENTER;
		}

//		if (!EditString.isNull(tpInfo.getNote())) {
//			contractContent += Constants.BULLET + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_note") + Constants.SPACE
//			        + Constants.COLON + Constants.SPACE + tpInfo.getNote();
//		}

		return contractContent;
	}
}
