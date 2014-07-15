package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;




import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.user.UserWsManager;
import com.osp.npo.core.user.UserWsInfo;
import com.osp.npo.core.user.UserWsList;

/**
 * Generate by script
 * Generate date: 10/13/2010 3:37:10 PM
 * @version $Revision: 17265 $
 */
public class UserWsService extends AbstractService {


    /** User Manager Object */
    private UserWsManager userManager;

    /** <P> Service constructor </P>*/
    public UserWsService(Connection connection) {
        super(connection);
        this.userManager = new UserWsManager(connection);
    }

    /**
     * <P> entry UserInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryUser(UserWsInfo info) throws SQLException {
        return this.userManager.insert(info);
    }


    /**
     * <P> modify UserInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyUser(UserWsInfo info) throws SQLException, IOException {
        return this.userManager.update(info);
    }


    /**
     * <P> remove User by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeUser(Long id) throws SQLException {
        return this.userManager.delete(id);
    }


    /**
     * <P> query User list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public UserWsList queryUser(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException {
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.userManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of User list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public UserWsList queryAllUser(boolean forUpdate)
            throws SQLException, IOException {
        /* if limit < 0 or offset < 0 then select all */
        return this.userManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total User </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalUser() throws SQLException, IOException {
        return this.userManager.countTotal();
    }
    
    public int countTotalUserByFilter() throws SQLException, IOException {
        return this.userManager.countTotalByFilter();
    }
    
    public int countTotalUserForAuthentication() throws SQLException, IOException {
        return this.userManager.countTotalForAuthentication();
    }

    /**
     * Set user id Filter
     * 
     * @param usidFilter     
     */
    public void setUsidFilter(Long usidFilter) {
    
        this.userManager.setUsidFilter(usidFilter);
    }
    
    /**
     * Set account id filter
     * 
     * @param accountIdFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setAccountIdFilter(String accountIdFilter, FilterKind kind) {
    
        this.userManager.setAccountIdFilter(accountIdFilter, kind);
    }
    
    /**
     * Set the passwordFilter
     *
     * @param passwordFilter the passwordFilter to set
     */
    public void setPasswordFilter(String passwordFilter) {
        this.userManager.setPasswordFilter(passwordFilter);
    }
    
    /**
     * Set first Name Filter
     * 
     * @param firstNameFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setFirstNameFilter(String firstNameFilter, FilterKind kind) {
    
        this.userManager.setFirstNameFilter(firstNameFilter, kind);
    }    
       
    /**
     * Set family Name Filter
     * 
     * @param familyNameFilter
     * @param kind  Filter kind (FULL, LEFT, MIDDLE)
     */
    public void setFamilyNameFilter(String familyNameFilter, FilterKind kind) {
    
        this.userManager.setFamilyNameFilter(familyNameFilter, kind);
    }
    
    /**
     * Set role Filter
     * 
     * @param roleFilter   
     */
    public void setRoleFilter(String[] roleFilter) {
    
        this.userManager.setRoleFilter(roleFilter);
    }
    
    /**
     * Set active Flag Filter
     * 
     * @param activeFlgFilter     
     */
    public void setActiveFlgFilter(Boolean activeFlgFilter) {
    
        this.userManager.setActiveFlgFilter(activeFlgFilter);
    }
    
    /**
     * Set hidden Flag Filter
     * 
     * @param hiddenFlgFilter     
     */
    public void setHiddenFlgFilter(Boolean hiddenFlgFilter) {
    
        this.userManager.setHiddenFlgFilter(hiddenFlgFilter);
    }
    
    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.userManager.setAuthenticationIdFilter(authenticationIdFilter);
    }

    /**
     * Set the authenticationCodeFilter
     *
     * @param authenticationCodeFilter the authenticationCodeFilter to set
     */
    public void setAuthenticationCodeFilter(String authenticationCodeFilter) {
        this.userManager.setAuthenticationCodeFilter(authenticationCodeFilter);
    }
    
    /**
     * Set the officeActiveFlgFilter
     *
     * @param officeActiveFlgFilter the officeActiveFlgFilter to set
     */
    public void setOfficeActiveFlgFilter(Boolean officeActiveFlgFilter) {
        this.userManager.setOfficeActiveFlgFilter(officeActiveFlgFilter);
    }
    
    /**
     * Set the officeHiddenFlgFilter
     *
     * @param officeHiddenFlgFilter the officeHiddenFlgFilter to set
     */
    public void setOfficeHiddenFlgFilter(Boolean officeHiddenFlgFilter) {
        this.userManager.setOfficeHiddenFlgFilter(officeHiddenFlgFilter);
    }
    
    /**
     * Add order field for table npo_user
     * @param orderField
     */
    public void addOrderFieldUser(OrderField orderField) {
        this.userManager.addOrderField(orderField);
    }
    
    /**
     * Determine record is existed in database based on attributes
     *
     * @param entity
     * @param nameKeyAndValueKey
     * @return TRUE if its was existed
     */
    public Boolean isExistInDB(String entity, Object[][] nameKeyAndValueKey) throws SQLException, IOException {
        return userManager.isExistInDB(entity, nameKeyAndValueKey);
    }
}
