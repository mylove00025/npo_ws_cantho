package com.osp.npo.core.connection;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 10/14/2011 9:26:39 AM
 * @version $Revision$ 
 */
public class ConnectionPoolManager extends AbstractManager {


    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ConnectionPoolManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ConnectionPoolInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_connection_pool");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("authentication_id,");
        sqlBuffer.append("status,");
        sqlBuffer.append("waiting_count,");
        sqlBuffer.append("priority,");
        sqlBuffer.append("update_date_time");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?");
        sqlBuffer.append(" ) ");
        setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result = -1;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(getSql());

            int i = 1;
            psSetString(ps, i++, info.getAuthenticationId());
            psSetByte(ps, i++, info.getStatus());
            psSetLong(ps, i++, info.getWaitingCount());
            psSetByte(ps, i++, info.getPriority());
            psSetTimestamp(ps, i++, info.getUpdateDateTime());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Delete a record</P>
     * 
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int delete(Long id) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_connection_pool ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

            result = ps.executeUpdate();

        } finally{
            close(ps);
        }

        return result;
    }


    /**
     * <P>Update infomation</P>
     * 
     * @param  info  Infomation that need update
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int update(ConnectionPoolInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_connection_pool");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("authentication_id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("authentication_id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetString(ps, i++, info.getAuthenticationId());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetString(ps, i++, info.getAuthenticationId());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }

    /**
     * <P>Update timeout record</P>
     * 
     * @param  timeoutValue  Value of timeout (in Minutes)
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     */
    public int updateTimeout(int timeoutValue) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append(" npo_connection_pool ");
        sqlBuffer.append(" SET ");
        sqlBuffer.append(" status=5, ");
        sqlBuffer.append(" waiting_count=0, ");
        sqlBuffer.append(" update_date_time=now() ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" (status=1 OR status=2) ");
        sqlBuffer.append(" AND DATE_SUB(now(), Interval ? MINUTE) > update_date_time ");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetInt(ps, 1, timeoutValue);
            
            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }
    
    /**
     * <P>Update close pool</P>
     * 
     * @param  authenticationId
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     */
    public int updateClosePool(String authenticationId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append(" npo_connection_pool ");
        sqlBuffer.append(" SET ");
        sqlBuffer.append(" status=9, ");
        sqlBuffer.append(" waiting_count=0, ");
        sqlBuffer.append(" update_date_time=now() ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" authentication_id=? ");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, authenticationId);
            
            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }
    
    
    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public ConnectionPoolList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_connection_pool" );
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append("LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ConnectionPoolList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            ConnectionPoolInfo info = null;
            list = new ConnectionPoolList();
            while(rs.next()) {
                info = new ConnectionPoolInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    
    /**
     * <P>Get record by authentication id</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public ConnectionPoolInfo selectByAuthenticationId(String authenticationId, boolean forUpdate) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_connection_pool ");
        sqlBuffer.append(" WHERE authentication_id=? ");

        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ConnectionPoolInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, authenticationId);
            
            rs = ps.executeQuery();

            while(rs.next()) {
                info = new ConnectionPoolInfo();
                rsSetInfo(rs, info);
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
        sqlBuffer.append("npo_connection_pool");

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
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countByStatus(byte status, String ignoreAuthenticationId) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_connection_pool ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" status=? ");
        sqlBuffer.append(" AND authentication_id <> ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetByte(ps, 1, status);
            psSetString(ps, 2, ignoreAuthenticationId);
            
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
    private void rsSetInfo(ResultSet rs,ConnectionPoolInfo info) throws SQLException {

        info.setAuthenticationId(rsGetString(rs, "authentication_id"));
        info.setStatus(rsGetByte(rs, "status"));
        info.setWaitingCount(rsGetLong(rs, "waiting_count"));
        info.setPriority(rsGetByte(rs, "priority"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ConnectionPoolInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getStatus(), ",status=?", sqlList, prmList);
        addUpdateList(info.getWaitingCount(), ",waiting_count=?", sqlList, prmList);
        addUpdateList(info.getPriority(), ",priority=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
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
