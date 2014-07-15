package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.contractHistory.ContractHistoryManager;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;
import com.osp.npo.core.contractHistory.ContractHistoryList;


/**
 * Generate by script
 * Generate date: 10/14/2011 9:26:39 AM
 * @version $Revision$ 
 */
public class ContractHistoryService extends AbstractService {


    /** ContractHistory Manager Object */
    private ContractHistoryManager contractHistoryManager;




    /** <P> Service constructor </P>*/
    public ContractHistoryService(Connection connection) {
        super(connection);
        this.contractHistoryManager = new ContractHistoryManager (connection);
    }


    /**
     * <P> entry ContractHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContractHistory(ContractHistoryInfo info) throws SQLException{
        return this.contractHistoryManager.insert(info);
    }


    /**
     * <P> modify ContractHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContractHistory(ContractHistoryInfo info) throws SQLException, IOException{
        return this.contractHistoryManager.update(info);
    }


    /**
     * <P> remove ContractHistory by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractHistory(Long id) throws SQLException{
        return this.contractHistoryManager.delete(id);
    }


    /**
     * <P> query ContractHistory list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractHistoryList queryContractHistory(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractHistoryManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of ContractHistory list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractHistoryList queryAllContractHistory(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.contractHistoryManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total ContractHistory </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalContractHistory()
            throws SQLException, IOException{
        return this.contractHistoryManager.countTotal();
    }
}
