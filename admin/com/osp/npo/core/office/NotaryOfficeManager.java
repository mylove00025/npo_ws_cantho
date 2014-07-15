package com.osp.npo.core.office;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 02/17/2011 11:55:51 AM
 * @version $Revision$ 
 */
public class NotaryOfficeManager extends AbstractManager {

    private String authenticationIdFilter;

    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public NotaryOfficeManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(NotaryOfficeInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_notary_office");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("name,");
        sqlBuffer.append("address,");
        sqlBuffer.append("phone,");
        sqlBuffer.append("fax,");
        sqlBuffer.append("email,");
        sqlBuffer.append("website,");
        sqlBuffer.append("other_info,");
        sqlBuffer.append("mac_address,");
        sqlBuffer.append("authentication_id,");
        sqlBuffer.append("authentication_code,");
        sqlBuffer.append("active_flg,");
        sqlBuffer.append("entry_user_id,");
        sqlBuffer.append("entry_user_name,");
        sqlBuffer.append("entry_date_time,");
        sqlBuffer.append("update_user_id,");
        sqlBuffer.append("update_user_name,");
        sqlBuffer.append("update_date_time");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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
            psSetString(ps, i++, info.getName());
            psSetString(ps, i++, info.getAddress());
            psSetString(ps, i++, info.getPhone());
            psSetString(ps, i++, info.getFax());
            psSetString(ps, i++, info.getEmail());
            psSetString(ps, i++, info.getWebsite());
            psSetString(ps, i++, info.getOtherInfo());
            psSetString(ps, i++, info.getMacAddress());
            psSetString(ps, i++, info.getAuthenticationId());
            psSetString(ps, i++, info.getAuthenticationCode());
            psSetBoolean(ps, i++, info.getActiveFlg());            

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setNoid(new Long(generatedId));
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
        sqlBuffer.append(" npo_notary_office ");
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
    public int update(NotaryOfficeInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_notary_office");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("noid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("noid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getNoid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getNoid());

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
    public List<String> selectAuthenticationIds(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" authentication_id ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_notary_office nno ");
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
        List<String> list = null;
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

            list = new ArrayList<String>();
            while(rs.next()) {
                list.add(rsGetString(rs, "authentication_id"));
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
     * @throws IOException
     */
    public NotaryOfficeInfo selectByAuthenticationId(String authenId, boolean forUpdate) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_notary_office " );
        sqlBuffer.append(" WHERE authentication_id = ? ");
        
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        
        NotaryOfficeInfo info = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetString(ps, 1, authenId);
            
            rs = ps.executeQuery();

            if(rs.next()) {
                info = new NotaryOfficeInfo();
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
        sqlBuffer.append("npo_notary_office");

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
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(NotaryOfficeInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getName(), ",name=?", sqlList, prmList);
        addUpdateList(info.getAddress(), ",address=?", sqlList, prmList);
        addUpdateList(info.getPhone(), ",phone=?", sqlList, prmList);
        addUpdateList(info.getFax(), ",fax=?", sqlList, prmList);
        addUpdateList(info.getEmail(), ",email=?", sqlList, prmList);
        addUpdateList(info.getWebsite(), ",website=?", sqlList, prmList);
        addUpdateList(info.getOtherInfo(), ",other_info=?", sqlList, prmList);
        addUpdateList(info.getMacAddress(), ",mac_address=?", sqlList, prmList);
        addUpdateList(info.getAuthenticationId(), ",authentication_id=?", sqlList, prmList);
        addUpdateList(info.getAuthenticationCode(), ",authentication_code=?", sqlList, prmList);
        addUpdateList(info.getActiveFlg(), ",active_flg=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        addUpdateList(info.getUpdateDateTime(), ",update_date_time=?", sqlList, prmList);
        addUpdateList(info.getLastConnectionTime(), ",last_connection_time=?", sqlList, prmList);
        addUpdateList(info.getSynchronizeType(), ",synchronize_type=?", sqlList, prmList);
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
        if (this.authenticationIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nno.authentication_id NOT LIKE ?");
            prmList.add(this.authenticationIdFilter);
        }
        return filterBuffer.toString();
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs, NotaryOfficeInfo info) throws SQLException {

        info.setNoid(rsGetLong(rs, "noid"));
        info.setOfficeType(rsGetByte(rs, "office_type"));
        info.setName(rsGetString(rs, "name"));
        info.setAddress(rsGetString(rs, "address"));
        info.setPhone(rsGetString(rs, "phone"));
        info.setFax(rsGetString(rs, "fax"));
        info.setEmail(rsGetString(rs, "email"));
        info.setWebsite(rsGetString(rs, "website"));
        info.setOtherInfo(rsGetString(rs, "other_info"));
        info.setMacAddress(rsGetString(rs, "mac_address"));
        info.setAuthenticationId(rsGetString(rs, "authentication_id"));
        info.setAuthenticationCode(rsGetString(rs, "authentication_code"));
        info.setActiveFlg(rsGetBoolean(rs, "active_flg"));
        info.setHiddenFlg(rsGetBoolean(rs, "hidden_flg"));
        info.setEntryUserId(rsGetLong(rs, "entry_user_id"));
        info.setEntryUserName(rsGetString(rs, "entry_user_name"));
        info.setEntryDateTime(rsGetTimestamp(rs, "entry_date_time"));
        info.setUpdateUserId(rsGetLong(rs, "update_user_id"));
        info.setUpdateUserName(rsGetString(rs, "update_user_name"));
        info.setUpdateDateTime(rsGetTimestamp(rs, "update_date_time"));
        info.setLastConnectionTime(rsGetTimestamp(rs, "last_connection_time"));
        info.setSynchronizeType(rsGetByte(rs, "synchronize_type"));
    }


    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.authenticationIdFilter = authenticationIdFilter;
    }
    
}
