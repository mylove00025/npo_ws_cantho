package com.osp.npo.core.common;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osp.npo.core.AbstractWsManager;

/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17046 $
 */
public class SystemConfigManager extends AbstractWsManager {


    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public SystemConfigManager(Connection connection) {
        super(connection);
    }

    /**
     * <P>Get system config info by key</P>
     * 
     * @param  key Config key
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  SystemConfigInfo
     * @throws SQLException
     * @throws IOException
     */
    public SystemConfigInfo selectByKey(String key, boolean forUpdate) throws SQLException, IOException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nsc.id, ");
        sqlBuffer.append(" nsc.config_key, ");
        sqlBuffer.append(" nsc.config_value ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_system_config nsc ");
        sqlBuffer.append(" WHERE config_key = ?");
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        SystemConfigInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, key);
            rs = ps.executeQuery();

            while(rs.next()) {
                info = new SystemConfigInfo();
                rsSetInfo(rs, info);
                break;
            }
        } finally {
            close(ps, rs);
        }

        return info;
    }


    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countTotal() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_system_config");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }


    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,SystemConfigInfo info) throws SQLException {

        info.setId(rsGetLong(rs, "id"));
        info.setConfigKey(rsGetString(rs, "config_key"));
        info.setConfigValue(rsGetString(rs, "config_value"));
    }


    /**
     * <P>Base SQL</P>
     * 
     * @param  prmList  ArrayList
     * @throws SQLException
     */
    private StringBuffer getBaseSQL(ArrayList<Object> prmList) throws SQLException {
        StringBuffer sqlBuffer = new StringBuffer();
        String whereString = getWhereFilter(prmList);
        if(whereString.length() > 0) {
            sqlBuffer.append(" WHERE true ");
            sqlBuffer.append(whereString);
        }
        return sqlBuffer;
    }


    /**
     * <P>>Get where sql statement part.</P>
     * 
     * @param  prmList  ArrayList
     * @return where sql statement
     * @throws SQLException
     */
    private String getWhereFilter(ArrayList<Object> prmList) {
        StringBuffer filterBuffer = new StringBuffer();
        //if (this.cidFilter != null) {
        //    appendAnd(filterBuffer);
        //    filterBuffer.append("vog.cid = ?");
        //    prmList.add(this.cidFilter);
        //}
        return filterBuffer.toString();
    }
}
