package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.osp.npo.core.common.SystemConfigManager;
import com.osp.npo.core.common.SystemConfigInfo;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:37:10 PM
 * @version $Revision: 17050 $
 */
public class CommonService extends AbstractService {

    /** SystemConfig Manager Object */
    private SystemConfigManager systemConfigManager;




    /** <P> Service constructor </P>*/
    public CommonService(Connection connection) {
        super(connection);
        this.systemConfigManager = new SystemConfigManager (connection);
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
    public SystemConfigInfo querySystemConfigByKey(String key, boolean forUpdate)
            throws SQLException, IOException{
        return this.systemConfigManager.selectByKey(key, forUpdate);
    }

    /**
     * <P> count total SystemConfig </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalSystemConfig()
            throws SQLException, IOException{
        return this.systemConfigManager.countTotal();
    }
   
}
