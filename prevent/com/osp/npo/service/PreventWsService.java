package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;
import com.osp.npo.core.prevent.DataPreventHistoryWsInfo;
import com.osp.npo.core.prevent.DataPreventHistoryWsList;
import com.osp.npo.core.prevent.DataPreventHistoryWsManager;
import com.osp.npo.core.prevent.DataPreventWsManager;
import com.osp.npo.core.prevent.DataPreventWsInfo;
import com.osp.npo.core.prevent.DataPreventWsList;
import com.osp.npo.core.prevent.PropertyPreventWsManager;
import com.osp.npo.core.prevent.PropertyPreventWsInfo;
import com.osp.npo.core.prevent.PropertyPreventWsList;
import com.osp.npo.core.prevent.TransactionPropertyWsInfo;
import com.osp.npo.core.prevent.TransactionPropertyWsList;
import com.osp.npo.core.prevent.TransactionPropertyWsManager;


/**
 * Generate by script
 * Generate date: 12/05/2010 1:52:14 PM
 */
public class PreventWsService extends AbstractService {


    /** DataPrevent Manager Object */
    private DataPreventWsManager dataPreventManager;


    /** PropertyPrevent Manager Object */
    private PropertyPreventWsManager propertyPreventManager;


    /** History manager object */
    private DataPreventHistoryWsManager datapreventPreventHistoryManager;
    
    /** TransactionProperty Manager Object */
    private TransactionPropertyWsManager transactionPropertyManager;
    

    /** <P> Service constructor </P>*/
    public PreventWsService(Connection connection) {
        super(connection);
        this.dataPreventManager = new DataPreventWsManager (connection);
        this.propertyPreventManager = new PropertyPreventWsManager (connection);
        this.datapreventPreventHistoryManager = new DataPreventHistoryWsManager(connection);
        this.transactionPropertyManager = new TransactionPropertyWsManager (connection);
    }


    /**
     * <P> entry DataPreventInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDataPrevent(DataPreventWsInfo info) throws SQLException{
        int rs = this.dataPreventManager.insert(info);
        
        LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(info.getId());
    	liInfo.setAction(LuceneIndexInfo.ACTION_CREATE);
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
    	
    	return rs;
    }


    /**
     * <P> modify DataPreventInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDataPrevent(DataPreventWsInfo info) throws SQLException, IOException{
    	int rs = this.dataPreventManager.update(info);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(info.getId());
    	
    	if (info.getDeleteFlg()) {
    		liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	} else {
    		liInfo.setAction(LuceneIndexInfo.ACTION_MODIFY);
    	}
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> remove DataPrevent by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDataPrevent(Long id) throws SQLException{
    	int rs = this.dataPreventManager.delete(id);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_PREVENT_DATA);
    	liInfo.setDataId(id);
    	liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> query DataPrevent list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventWsList queryDataPrevent(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.dataPreventManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of DataPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventWsList queryAllDataPrevent(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.dataPreventManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of DataPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventWsList queryAllDataPreventWS(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.dataPreventManager.selectWS(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of DataPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public List<String> queryAllSynchronizeIdPrevent(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.dataPreventManager.selectFirstSynchronize(forUpdate, -1, -1);
    }


    /**
     * <P> count total DataPrevent </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDataPrevent()
            throws SQLException, IOException{
        return this.dataPreventManager.countTotal();
    }


    /**
     * <P> entry PropertyPreventInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryPropertyPrevent(PropertyPreventWsInfo info) throws SQLException{
        return this.propertyPreventManager.insert(info);
    }


    /**
     * <P> modify PropertyPreventInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyPropertyPrevent(PropertyPreventWsInfo info) throws SQLException, IOException{
        return this.propertyPreventManager.update(info);
    }


    /**
     * <P> remove PropertyPrevent by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removePropertyPrevent(Long id) throws SQLException{
        return this.propertyPreventManager.delete(id);
    }


    /**
     * <P> query PropertyPrevent list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public PropertyPreventWsList queryPropertyPreventWS(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.propertyPreventManager.selectWS(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of PropertyPrevent list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public PropertyPreventWsList queryAllPropertyPreventWS(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.propertyPreventManager.selectWS(forUpdate, -1, -1);
    }


    /**
     * <P> count total PropertyPrevent </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalPropertyPrevent()
            throws SQLException, IOException{
        return this.propertyPreventManager.countTotal();
    }

    /**
     * <P> count total DataPrevent by filter </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDataPreventByFilter()
            throws SQLException, IOException {
        return this.dataPreventManager.countTotalByFilter();
    }

    /**
     * <P> entry DataPreventHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDataPreventHistory(DataPreventHistoryWsInfo info) throws SQLException{
        return this.datapreventPreventHistoryManager.insert(info);
    }


    /**
     * <P> modify DataPreventHistoryInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDataPreventHistory(DataPreventHistoryWsInfo info) throws SQLException, IOException{
        return this.datapreventPreventHistoryManager.update(info);
    }


    /**
     * <P> remove DataPreventHistory by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDataPreventHistory(Long id) throws SQLException{
        return this.datapreventPreventHistoryManager.delete(id);
    }

    /**
     * <P> query all of DatPreventHistory list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DataPreventHistoryWsList queryAllDataPreventHistoryWs(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.datapreventPreventHistoryManager.selectWs(forUpdate, -1, -1);
    }

    /**
     * Add order field for table npo_data_prevent
     * @param orderField
     */
    public void addOrderFieldDataPrevent(OrderField orderField) {
        this.dataPreventManager.addOrderField(orderField);
    }

    /**
     * Add order field for table npo_data_prevent
     * @param orderField
     */
    public void addOrderFieldDataPreventHistory(OrderField orderField) {
        this.datapreventPreventHistoryManager.addOrderField(orderField);
    }

    /**
     * Set the synchronizeIdFilter
     *
     * @param synchronizeIdFilter the synchronizeIdFilter to set
     */
    public void setPreventSynchronizeIdFilter(String synchronizeIdFilter) {
        this.dataPreventManager.setSynchronizeIdFilter(synchronizeIdFilter);
    }
    
    /**
     * Set the synchronizeIdFilter
     *
     * @param synchronizeIdFilter the synchronizeIdFilter to set
     */
    public void setPropertySynchronizeIdFilter(String synchronizeIdFilter) {
        this.transactionPropertyManager.setSynchronizeIdFilter(synchronizeIdFilter);
    }
    
    /**
     * <P> entry TransactionPropertyInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryTransactionProperty(TransactionPropertyWsInfo info) throws SQLException{
        int rs = this.transactionPropertyManager.insert(info);
        
        LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(info.getTpid());
    	liInfo.setAction(LuceneIndexInfo.ACTION_CREATE);
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);
        
        return rs;
    }


    /**
     * <P> modify TransactionPropertyInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyTransactionProperty(TransactionPropertyWsInfo info) throws SQLException, IOException{
    	int rs = this.transactionPropertyManager.update(info);
    	
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(info.getTpid());
    	liInfo.setAction(LuceneIndexInfo.ACTION_MODIFY);
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);

		return rs;
    }


    /**
     * <P> remove TransactionProperty by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeTransactionProperty(Long tpid) throws SQLException{
        int rs = this.transactionPropertyManager.delete(tpid);
        
		LuceneIndexService luceneIndexService = new LuceneIndexService(getConnection());
        
    	LuceneIndexInfo liInfo = new LuceneIndexInfo();
    	liInfo.setType(LuceneIndexInfo.TYPE_TRANSACTION);
    	liInfo.setDataId(tpid);
    	liInfo.setAction(LuceneIndexInfo.ACTION_REMOVE);
    	liInfo.setEntryDateTime2(RelateDateTime.getTimeNow());
    	
    	luceneIndexService.entryLuceneIndex(liInfo);

		return rs;
    }


    /**
     * <P> query TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyWsList queryTransactionProperty(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.transactionPropertyManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyWsList queryAllTransactionProperty(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.transactionPropertyManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public TransactionPropertyWsList queryAllTransactionPropertyWS(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.transactionPropertyManager.selectWS(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of TransactionProperty list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public List<String> queryAllSynchronizeIdTransaction(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.transactionPropertyManager.selectFirstSynchonize(forUpdate, -1, -1);
    }


    /**
     * <P> count total TransactionProperty </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalTransactionProperty()
            throws SQLException, IOException{
        return this.transactionPropertyManager.countTotal();
    }
    
    /**
     * Set the idFilter
     *
     * @param idFilter the idFilter to set
     */
    public void setPropertyPreventIdFilter(Long idFilter) {
        this.propertyPreventManager.setIdFilter(idFilter);
    }
    
    /**
     * Set the historyIdFilter
     *
     * @param historyIdFilter the historyIdFilter to set
     */
    public void setHistoryIdFilter(Long historyIdFilter) {
        this.datapreventPreventHistoryManager.setHistoryIdFilter(historyIdFilter);
    }
}
