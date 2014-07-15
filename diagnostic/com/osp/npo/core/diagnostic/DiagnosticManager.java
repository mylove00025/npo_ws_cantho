package com.osp.npo.core.diagnostic;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:58 PM
 * @version $Revision$ 
 */
public class DiagnosticManager extends AbstractManager {


    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public DiagnosticManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(DiagnosticInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_diagnostic");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("office_code,");
        sqlBuffer.append("command_code,");
        sqlBuffer.append("number_result,");
        sqlBuffer.append("string_result,");
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
            psSetString(ps, i++, info.getOfficeCode());
            psSetString(ps, i++, info.getCommandCode());
            psSetLong(ps, i++, info.getNumberResult());
            psSetString(ps, i++, info.getStringResult());
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
        sqlBuffer.append(" npo_diagnostic ");
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
    public int update(DiagnosticInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_diagnostic");
        sqlBuffer.append(" SET ");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" office_code=? ");
        sqlBuffer.append(" AND command_code=? ");
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }

            psSetString(ps, i++, info.getOfficeCode());
            psSetString(ps, i++, info.getCommandCode());

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
    public DiagnosticList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_diagnostic" );
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
        DiagnosticList list = null;
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

            DiagnosticInfo info = null;
            list = new DiagnosticList();
            while(rs.next()) {
                info = new DiagnosticInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     */
    public DiagnosticInfo selectByPK(boolean forUpdate, String officeCode, String commandCode) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_diagnostic ");
        sqlBuffer.append(" WHERE office_code=? ");
        sqlBuffer.append(" AND command_code=? ");
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        DiagnosticInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            psSetString(ps, i++, officeCode);
            psSetString(ps, i++, commandCode);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                info = new DiagnosticInfo();
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
        sqlBuffer.append("npo_diagnostic");

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
    private void rsSetInfo(ResultSet rs,DiagnosticInfo info) throws SQLException {

        info.setOfficeCode(rsGetString(rs, "office_code"));
        info.setCommandCode(rsGetString(rs, "command_code"));
        info.setNumberResult(rsGetLong(rs, "number_result"));
        info.setStringResult(rsGetString(rs, "string_result"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(DiagnosticInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getOfficeCode(), "office_code=?", sqlList, prmList);
        addUpdateList(info.getCommandCode(), ",command_code=?", sqlList, prmList);
        addUpdateList(info.getNumberResult(), ",number_result=?", sqlList, prmList);
        addUpdateList(info.getStringResult(), ",string_result=?", sqlList, prmList);
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
