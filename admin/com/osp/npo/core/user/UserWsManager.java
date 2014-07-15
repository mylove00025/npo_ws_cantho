package com.osp.npo.core.user;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractWsManager;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 17236 $
 */
public class UserWsManager extends AbstractWsManager {


    /** Usid filter */
    private Long usidFilter;
    
    
    /** Account ID filter */
    private String accountIdFilter;
    
    /** Password filter */
    private String passwordFilter;
    
    
    /** Employee_code filter */
    private String firstNameFilter;
    
    
    /** Name filter */
    private String familyNameFilter;   
    
    /** Role filter */
    private String[] roleFilter;
    
    /** active Flag Filter */
    private Boolean activeFlgFilter;
    
    /** hidden Flag Filter */
    private Boolean hiddenFlgFilter;   
    
    private String authenticationIdFilter;
    
    private String authenticationCodeFilter;
    
    private Boolean officeActiveFlgFilter;
    
    private Boolean officeHiddenFlgFilter;
    
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public UserWsManager(Connection connection) {
        super(connection);
    }

    /**
     * Set user id Filter
     * 
     * @param usidFilter     
     */
    public void setUsidFilter(Long usidFilter) {
    
        this.usidFilter = usidFilter;
    }
    
    /**
     * Set account id filter
     * 
     * @param accountIdFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setAccountIdFilter(String accountIdFilter, FilterKind kind) {
    
        this.accountIdFilter = this.buildFilterString(accountIdFilter, kind.getValue());
    }
    
    /**
     * Set the passwordFilter
     *
     * @param passwordFilter the passwordFilter to set
     */
    public void setPasswordFilter(String passwordFilter) {
        this.passwordFilter = passwordFilter;
    }

    /**
     * Set first Name Filter
     * 
     * @param firstNameFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setFirstNameFilter(String firstNameFilter, FilterKind kind) {
    
        this.firstNameFilter = this.buildFilterString(firstNameFilter, kind.getValue());
    }    
       
    /**
     * Set family Name Filter
     * 
     * @param familyNameFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setFamilyNameFilter(String familyNameFilter, FilterKind kind) {
    
        this.familyNameFilter = this.buildFilterString(familyNameFilter, kind.getValue());
    }
    
    /**
     * Set role Filter
     * 
     * @param roleFilter   
     */
    public void setRoleFilter(String[] roleFilter) {
    
        this.roleFilter = roleFilter;
    }
    
    /**
     * Set active Flag Filter
     * 
     * @param activeFlgFilter     
     */
    public void setActiveFlgFilter(Boolean activeFlgFilter) {
    
        this.activeFlgFilter = activeFlgFilter;
    }
    
    /**
     * Set hidden Flag Filter
     * 
     * @param hiddenFlgFilter     
     */
    public void setHiddenFlgFilter(Boolean hiddenFlgFilter) {
    
        this.hiddenFlgFilter = hiddenFlgFilter;
    }
    

    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.authenticationIdFilter = authenticationIdFilter;
    }

    /**
     * Set the authenticationCodeFilter
     *
     * @param authenticationCodeFilter the authenticationCodeFilter to set
     */
    public void setAuthenticationCodeFilter(String authenticationCodeFilter) {
        this.authenticationCodeFilter = authenticationCodeFilter;
    }
    
    /**
     * Set the officeActiveFlgFilter
     *
     * @param officeActiveFlgFilter the officeActiveFlgFilter to set
     */
    public void setOfficeActiveFlgFilter(Boolean officeActiveFlgFilter) {
        this.officeActiveFlgFilter = officeActiveFlgFilter;
    }
    
    /**
     * Set the officeHiddenFlgFilter
     *
     * @param officeHiddenFlgFilter the officeHiddenFlgFilter to set
     */
    public void setOfficeHiddenFlgFilter(Boolean officeHiddenFlgFilter) {
        this.officeHiddenFlgFilter = officeHiddenFlgFilter;
    }

    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(UserWsInfo info) throws SQLException {

    	StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_user");
        sqlBuffer.append(" ( ");
        //sqlBuffer.append("id,");
        sqlBuffer.append("account,");
        sqlBuffer.append("password,");
        sqlBuffer.append("family_name,");
        sqlBuffer.append("first_name,");
        sqlBuffer.append("sex,");
        sqlBuffer.append("active_flg,");
        sqlBuffer.append("hidden_flg,");
        sqlBuffer.append("role,");
        sqlBuffer.append("birthday,");
        sqlBuffer.append("telephone,");
        sqlBuffer.append("mobile,");
        sqlBuffer.append("email,");
        sqlBuffer.append("address,");
        sqlBuffer.append("last_login_date");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        //sqlBuffer.append("?,");
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

            //psSetLong(ps, 1, info.getId());
            int i = 1;
            psSetString(ps, i++, info.getAccount());
            psSetString(ps, i++, info.getPassword());
            psSetString(ps, i++, info.getFamilyName());
            psSetString(ps, i++, info.getFirstName());
            psSetBoolean(ps, i++, info.getSex());
            psSetBoolean(ps, i++, info.getActiveFlg());
            psSetBoolean(ps, i++, info.getHiddenFlg());
            psSetString(ps, i++, info.getRole());
            psSetString(ps, i++, info.getBirthday());
            psSetString(ps, i++, info.getTelephone());
            psSetString(ps, i++, info.getMobile());
            psSetString(ps, i++, info.getEmail());
            psSetString(ps, i++, info.getAddress());
            psSetTimestamp(ps, i++, info.getLastLoginDate());            

            result = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();                                   
            Integer generatedId = new Integer(rs.getInt(1));
            info.setId(new Long(generatedId));
            
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
        sqlBuffer.append(" npo_user ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

            result = ps.executeUpdate();

        } finally {
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
    public int update(UserWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_user");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getId());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getId());

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
    public UserWsList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" nu.account, ");
        sqlBuffer.append(" nu.password, ");
        sqlBuffer.append(" nu.family_name, ");
        sqlBuffer.append(" nu.first_name, ");
        sqlBuffer.append(" nno.name as office_name, ");
        sqlBuffer.append(" nno.mac_address ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_user nu ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_notary_office nno ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nu.office_id= nno.noid ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
        //Append order field
        appendOrderField(sqlBuffer);
        
        if ((offset >= 0) && (limit >= 0)) {
            sqlBuffer.append(" LIMIT ? ");
            sqlBuffer.append(" OFFSET ? ");
        }
        if (forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        UserWsList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)) {
                psSetObject(ps, i++, limit);
                psSetObject(ps, i++, offset);
            }
            rs = ps.executeQuery();

            UserWsInfo info = null;
            list = new UserWsList();
            while (rs.next()) {
                info = new UserWsInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
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
        sqlBuffer.append("npo_user");

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
     * Get count record result by filter
     * 
     * @return Count of record
     * @throws SQLException
     */
    public int countTotalByFilter() 
        throws SQLException, IOException {
        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_user nu ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_role nr ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nu.role = nr.code ");
        
        sqlBuffer.append(getBaseSQL(prmList));        
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } finally {
            close(ps, rs);
        }

        return result;
    }
    
    /**
     * Get count record result by filter
     * 
     * @return Count of record
     * @throws SQLException
     */
    public int countTotalForAuthentication() throws SQLException, IOException {
        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_user nu ");
        
        sqlBuffer.append(" INNER JOIN ");
        sqlBuffer.append(" npo_notary_office nno ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" nu.office_id= nno.noid ");
        
        sqlBuffer.append(getBaseSQL(prmList));        
        
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }            
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
    private void rsSetInfo(ResultSet rs, UserWsInfo info) throws SQLException {

    	info.setAccount(rsGetString(rs, "account"));
        info.setPassword(rsGetString(rs, "password"));
        info.setFamilyName(rsGetString(rs, "family_name"));
        info.setFirstName(rsGetString(rs, "first_name"));
        info.setOfficeName(rsGetString(rs, "office_name"));
        info.setMacAddress(rsGetString(rs, "mac_address"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(UserWsInfo info, ArrayList<String> sqlList, ArrayList<Object> prmList) {

        addUpdateList(info.getAccount(), ",account=?", sqlList, prmList);
        addUpdateList(info.getPassword(), ",password=?", sqlList, prmList);
        addUpdateList(info.getFamilyName(), ",family_name=?", sqlList, prmList);
        addUpdateList(info.getFirstName(), ",first_name=?", sqlList, prmList);
        addUpdateList(info.getSex(), ",sex=?", sqlList, prmList);
        addUpdateList(info.getActiveFlg(), ",active_flg=?", sqlList, prmList);
        addUpdateList(info.getHiddenFlg(), ",hidden_flg=?", sqlList, prmList);
        addUpdateList(info.getRole(), ",role=?", sqlList, prmList);
        addUpdateList(info.getBirthday(), ",birthday=?", sqlList, prmList);
        addUpdateList(info.getTelephone(), ",telephone=?", sqlList, prmList);
        addUpdateList(info.getMobile(), ",mobile=?", sqlList, prmList);
        addUpdateList(info.getEmail(), ",email=?", sqlList, prmList);
        addUpdateList(info.getAddress(), ",address=?", sqlList, prmList);
        addUpdateList(info.getLastLoginDate(), ",last_login_date=?", sqlList, prmList);
        addUpdateList(info.getEntryUserId(), ",entry_user_id=?", sqlList, prmList);
        addUpdateList(info.getEntryUserName(), ",entry_user_name=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime(), ",entry_date_time=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
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
        if (whereString.length() > 0) {
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
        
        /* Set usid filter */
        if (this.usidFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.id = ?");
            prmList.add(this.usidFilter);
        }
        
        /* Set account filter */
        if (this.accountIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.account LIKE ?");
            prmList.add(this.accountIdFilter);
        }
        
        /* Set password filter */
        if (this.passwordFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.password LIKE ?");
            prmList.add(this.passwordFilter);
        }
        
        /* Set employee code filter */
        if (this.familyNameFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.family_name LIKE ?");
            prmList.add(this.familyNameFilter);
        }
        
        /* Set name filter */
        if (this.firstNameFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.first_name LIKE ?");
            prmList.add(this.firstNameFilter);
        }
        
        /* Set role filter */
        if (this.roleFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append(buildIn("nu.role", roleFilter.length));
            for (int i = 0; i < roleFilter.length; i++) {
                prmList.add(roleFilter[i]);
            }
        }
        
        /* Set active Flag Filter */        
        if (this.activeFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.active_flg = ?");
            prmList.add(this.activeFlgFilter);
        }
        
        /* Set hidden Flag Filter */
        if (this.hiddenFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nu.hidden_flg = ?");
            prmList.add(this.hiddenFlgFilter);
        }
        
        if (this.authenticationIdFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nno.authentication_id LIKE ?");
            prmList.add(this.authenticationIdFilter);
        }
        
        if (this.authenticationCodeFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nno.authentication_code LIKE ?");
            prmList.add(this.authenticationCodeFilter);
        }
        
        if (this.officeActiveFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nno.active_flg = ?");
            prmList.add(this.officeActiveFlgFilter);
        }
        
        if (this.officeHiddenFlgFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nno.hidden_flg = ?");
            prmList.add(this.officeHiddenFlgFilter);
        }
        
        return filterBuffer.toString();
    }
}
