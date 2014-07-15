package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;


import com.osp.npo.core.OrderField;
import com.osp.npo.core.synchronize.SynchronizeWsManager;
import com.osp.npo.core.synchronize.SynchronizeWsInfo;
import com.osp.npo.core.synchronize.SynchronizeWsList;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:08:27 AM
 */
public class SynchronizeWsService extends AbstractService {


    /** Synchronize Manager Object */
    private SynchronizeWsManager synchronizeManager;




    /** <P> Service constructor </P>*/
    public SynchronizeWsService(Connection connection) {
        super(connection);
        this.synchronizeManager = new SynchronizeWsManager (connection);
    }


    /**
     * <P> entry SynchronizeInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entrySynchronize(SynchronizeWsInfo info) throws SQLException{
        return this.synchronizeManager.insert(info);
    }
    
    /**
     * <P> entry one SynchronizeInfo for one notary office to database automatically</P>
     * @param type
     * @param dataId
     * @param action
     * @param entryDateTime
     *
     * @return number of record insert.
     * @throws SQLException
     */
    public int entrySyncDataServer(Byte type, String dataId, Byte action, Long historyId, Calendar entryDateTime, String authenId) throws SQLException {
        return this.synchronizeManager.insertSyncDataServer(type, dataId, action, historyId, entryDateTime, authenId);
    }
    
    /**
     * <P>Entry all synchronize prevent data</P>
     *
     * @param  authenticationId  Authentication Id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int entryAllSyncPreventData(String authenticationId) throws SQLException {
    	return this.synchronizeManager.insertAllSyncPreventData(authenticationId);
    }
    
    /**
     * <P>Entry all synchronize transaction property</P>
     *
     * @param  authenticationId  Authentication Id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int entryAllSyncTransProperty(String authenticationId) throws SQLException {
    	return this.synchronizeManager.insertAllSyncTransProperty(authenticationId);
    }
    
    /**
     * <P>Entry all synchronize announcement</P>
     *
     * @param  authenticationId  Authentication Id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int entryAllSyncAnnouncement(String authenticationId) throws SQLException {
    	return this.synchronizeManager.insertAllSyncAnnouncement(authenticationId);
    }


    /**
     * <P> modify SynchronizeInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifySynchronize(SynchronizeWsInfo info) throws SQLException, IOException{
        return this.synchronizeManager.update(info);
    }
    
    
    /**
     * <P> Change error status </P>
     *
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int changeErrorStatus(String authenticationId) throws SQLException, IOException{
        return this.synchronizeManager.updateErrorStatus(authenticationId);
    }


    /**
     * <P> remove Synchronize by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchronize(String dataId, String authenticationId) throws SQLException{
        return this.synchronizeManager.delete(dataId, authenticationId);
    }
    
    
    /**
     * <P> remove Synchronize by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchronize(List<String> dataId, String authenticationId) throws SQLException{
        return this.synchronizeManager.delete(dataId, authenticationId);
    }
    
    
    /**
     * <P> remove Synchronize by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchByAuthId(String authenticationId) throws SQLException{
        return this.synchronizeManager.deleteByAuthenticationId(authenticationId);
    }

    /**
     * <P> remove Synchronize by data id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeSynchByDataId(String dataId) throws SQLException{
        return this.synchronizeManager.deleteByDataId(dataId);
    }

    /**
     * <P> query Synchronize list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public SynchronizeWsList querySynchronize(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.synchronizeManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Synchronize list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public SynchronizeWsList queryAllSynchronize(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.synchronizeManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total Synchronize </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalSynchronize()
            throws SQLException, IOException{
        return this.synchronizeManager.countTotal();
    }
    
    /**
     * <P>Get count record by office and type. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countByOffice(String officeCode, Byte type) throws SQLException {
    	return this.synchronizeManager.countByOffice(officeCode, type);
    }
    
    /**
     * Set the dataId
     *
     * @param dataId the dataId to set
     */
    public void setDataId(String dataId) {
        this.synchronizeManager.setDataId(dataId);
    }
    
    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.synchronizeManager.setAuthenticationIdFilter(authenticationIdFilter);
    }
    
    /**
     * Set the statusFilter
     *
     * @param statusFilter the statusFilter to set
     */
    public void setStatusFilter(Byte statusFilter) {
        this.synchronizeManager.setStatusFilter(statusFilter);
    }
    
    /**
     * Add order field
     *
     * @param orderField
     */
    public void addOrderField(OrderField orderField) {
        this.synchronizeManager.addOrderField(orderField);
    }
}
