package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.common.SystemConfigManager;
import com.osp.npo.core.connection.ConnectionPoolManager;
import com.osp.npo.core.connection.ConnectionPoolInfo;
import com.osp.npo.core.connection.ConnectionPoolList;


/**
 * Generate by script
 * Generate date: 10/14/2011 9:26:39 AM
 * @version $Revision$ 
 */
public class ConnectionService extends AbstractService {

	private final static String SYSTEM_POOL_TIMEOUT = "system_pool_timeout";
	private final static String SYSTEM_POOL_MAX_NORMAL = "system_pool_max_normal";
	private final static String SYSTEM_POOL_MAX_PRIORITY = "system_pool_max_priority";
	
	private final static Byte STATUS_WAITING = 0;
	private final static Byte STATUS_NORMAL_PROCESSING = 1;
	private final static Byte STATUS_PRIORITY_PROCESSING = 2;

    /** ConnectionPool Manager Object */
    private ConnectionPoolManager connectionPoolManager;


    /** SystemConfig Manager Object */
    private SystemConfigManager systemConfigManager;


    /** <P> Service constructor </P>*/
    public ConnectionService(Connection connection) {
        super(connection);
        this.connectionPoolManager = new ConnectionPoolManager (connection);
        this.systemConfigManager = new SystemConfigManager (connection);
    }


    /**
     * <P> entry ConnectionPoolInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryConnectionPool(ConnectionPoolInfo info) throws SQLException{
        return this.connectionPoolManager.insert(info);
    }


    /**
     * <P> modify ConnectionPoolInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyConnectionPool(ConnectionPoolInfo info) throws SQLException, IOException{
        return this.connectionPoolManager.update(info);
    }


    /**
     * <P> remove ConnectionPool by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeConnectionPool(Long id) throws SQLException{
        return this.connectionPoolManager.delete(id);
    }


    /**
     * <P> query ConnectionPool list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ConnectionPoolList queryConnectionPool(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.connectionPoolManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of ConnectionPool list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ConnectionPoolList queryAllConnectionPool(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.connectionPoolManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total ConnectionPool </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalConnectionPool()
            throws SQLException, IOException{
        return this.connectionPoolManager.countTotal();
    }
    
    /**
     * <P>Get record by authentication id</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  ConnectionPoolInfo
     * @throws SQLException
     */
    public ConnectionPoolInfo queryPoolByAuthenticationId(String authenticationId, boolean forUpdate) throws SQLException {
    	return this.connectionPoolManager.selectByAuthenticationId(authenticationId, forUpdate);
    }
    
    /**
     * <P>Check timeout</P>
     * 
     * @param  timeoutValue  Value of timeout (in Minutes)
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int checkTimeout() throws SQLException, IOException {
    	int timeoutValue = 15;
    	try {
    		timeoutValue = Integer.parseInt(querySystemConfigByKey(SYSTEM_POOL_TIMEOUT, false).getConfigValue());
    	} catch (Exception ex) {}
    	
        return this.connectionPoolManager.updateTimeout(timeoutValue);
    }
    
    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countByStatus(byte status, String ignoreAuthenticationId) throws SQLException {
    	return this.connectionPoolManager.countByStatus(status, ignoreAuthenticationId);
    }
    
    /**
     * Get token of pool
     * @param authenticationId
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public boolean getPoolToken(String authenticationId) throws SQLException, IOException {
    	
    	ConnectionPoolInfo poolInfo = queryPoolByAuthenticationId(authenticationId, false);
    	
    	if (poolInfo == null) {
    		poolInfo = new ConnectionPoolInfo();
    		poolInfo.setAuthenticationId(authenticationId);
    		poolInfo.setStatus(STATUS_WAITING);
    		poolInfo.setWaitingCount(0L);
    		byte defaultPriority = 0;
    		poolInfo.setPriority(defaultPriority);
    		poolInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
    		
    		entryConnectionPool(poolInfo);
    	}
    	
    	if (poolInfo.getPriority() > 0) {
    		return getPoolTokenPriority(authenticationId);
    	}
    	
    	checkTimeout();
    	
    	int maxNormalPool = 10;
    	try {
    		maxNormalPool = Integer.parseInt(querySystemConfigByKey(SYSTEM_POOL_MAX_NORMAL, false).getConfigValue());
    	} catch (Exception ex) {}
    	
    	if (countByStatus(STATUS_NORMAL_PROCESSING, poolInfo.getAuthenticationId()) < maxNormalPool) {
    		poolInfo.setStatus(STATUS_NORMAL_PROCESSING);
    		poolInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
    		poolInfo.setWaitingCount(0L);
    		modifyConnectionPool(poolInfo);
    		
    		return true;
    	} else {
    		if (poolInfo.getWaitingCount() >= 5) {
    			return getPoolTokenPriority(authenticationId);
    		} else {
    			poolInfo.setStatus(STATUS_WAITING);
    			poolInfo.setWaitingCount(poolInfo.getWaitingCount() + 1);
    			poolInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
    			modifyConnectionPool(poolInfo);
    			return false;
    		}
    	}
    	
    }
    
    /**
     * Get token of pool priority
     * @param authenticationId
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public boolean getPoolTokenPriority(String authenticationId) throws SQLException, IOException {
    	
    	ConnectionPoolInfo poolInfo = queryPoolByAuthenticationId(authenticationId, false);
    	
    	checkTimeout();
    	
    	int maxPriorityPool = 5;
    	try {
    		maxPriorityPool = Integer.parseInt(querySystemConfigByKey(SYSTEM_POOL_MAX_PRIORITY, false).getConfigValue());
    	} catch (Exception ex) {}
    	
    	if (countByStatus(STATUS_PRIORITY_PROCESSING, poolInfo.getAuthenticationId()) < maxPriorityPool) {
    		poolInfo.setStatus(STATUS_PRIORITY_PROCESSING);
    		poolInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
    		poolInfo.setWaitingCount(0L);
    		modifyConnectionPool(poolInfo);
    		return true;
    	} else {
    		poolInfo.setStatus(STATUS_WAITING);
    		poolInfo.setWaitingCount(poolInfo.getWaitingCount() + 1);
			poolInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
			modifyConnectionPool(poolInfo);
			return false;
    	}
    }
    
    
    /**
     * Close pool
     * 
     * @param authenticationId
     * @return
     * @throws SQLException
     */
    public int closePool(String authenticationId) throws SQLException {
    	return this.connectionPoolManager.updateClosePool(authenticationId);
    }
    
    /**
     * <P> Query SystemConfigInfo from database by config key </P>
     *
     * @param key Configkey
     * @param forUpdate
     * @return SystemConfigInfo
     * @throws SQLException
     * @throws IOException
    */
    private SystemConfigInfo querySystemConfigByKey(String key, boolean forUpdate)
            throws SQLException, IOException{
        return this.systemConfigManager.selectByKey(key, forUpdate);
    }
}
