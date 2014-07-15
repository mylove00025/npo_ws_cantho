package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.osp.npo.core.office.NotaryOfficeManager;
import com.osp.npo.core.office.NotaryOfficeInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:08:27 AM
 */
public class OfficeService extends AbstractService {


    /** NotaryOffice Manager Object */
    private NotaryOfficeManager notaryOfficeManager;




    /** <P> Service constructor </P>*/
    public OfficeService(Connection connection) {
        super(connection);
        this.notaryOfficeManager = new NotaryOfficeManager (connection);
    }


    /**
     * <P> entry NotaryOfficeInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryNotaryOffice(NotaryOfficeInfo info) throws SQLException{
        return this.notaryOfficeManager.insert(info);
    }


    /**
     * <P> modify NotaryOfficeInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyNotaryOffice(NotaryOfficeInfo info) throws SQLException, IOException{
        return this.notaryOfficeManager.update(info);
    }


    /**
     * <P> remove NotaryOffice by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeNotaryOffice(Long id) throws SQLException{
        return this.notaryOfficeManager.delete(id);
    }


    /**
     * <P> query all Authentication Id of All NotaryOffice from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public List<String> queryAllAuthenticationId(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.notaryOfficeManager.selectAuthenticationIds(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all Authentication Id of All NotaryOffice from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public NotaryOfficeInfo queryByAuthenticationId(String authenId, boolean forUpdate)
            throws SQLException {
        /* if limit < 0 or offset < 0 then select all */
        return this.notaryOfficeManager.selectByAuthenticationId(authenId, forUpdate);
    }


    /**
     * <P> count total NotaryOffice </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalNotaryOffice()
            throws SQLException, IOException{
        return this.notaryOfficeManager.countTotal();
    }
    
    /**
     * Set the authenticationIdFilter
     *
     * @param authenticationIdFilter the authenticationIdFilter to set
     */
    public void setAuthenticationIdFilter(String authenticationIdFilter) {
        this.notaryOfficeManager.setAuthenticationIdFilter(authenticationIdFilter);
    }
}
