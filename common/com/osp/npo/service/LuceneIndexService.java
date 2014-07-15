package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.OrderField;
import com.osp.npo.core.luceneIndex.LuceneIndexManager;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;
import com.osp.npo.core.luceneIndex.LuceneIndexList;


/**
 * Generate by script
 * Generate date: 06/07/2011 5:56:05 PM
 * @version $Revision$ 
 */
public class LuceneIndexService extends AbstractService {


    /** LuceneIndex Manager Object */
    private LuceneIndexManager luceneIndexManager;




    /** <P> Service constructor </P>*/
    public LuceneIndexService(Connection connection) {
        super(connection);
        this.luceneIndexManager = new LuceneIndexManager (connection);
    }


    /**
     * <P> entry LuceneIndexInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryLuceneIndex(LuceneIndexInfo info) throws SQLException{
        return this.luceneIndexManager.insert(info);
    }


    /**
     * <P> modify LuceneIndexInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyLuceneIndex(LuceneIndexInfo info) throws SQLException, IOException{
        return this.luceneIndexManager.update(info);
    }


    /**
     * <P> remove LuceneIndex by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeLuceneIndex(Byte type, Long dataId, Byte action) throws SQLException{
        return this.luceneIndexManager.delete(type, dataId, action);
    }
    
    
    /**
     * <P> remove LuceneIndex by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeLuceneIndex(LuceneIndexInfo info) throws SQLException{
        return this.luceneIndexManager.delete(info.getType(), info.getDataId(), info.getAction());
    }


    /**
     * <P> query LuceneIndex list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public LuceneIndexList queryLuceneIndex(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.luceneIndexManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of LuceneIndex list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public LuceneIndexList queryAllLuceneIndex(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.luceneIndexManager.select(forUpdate, -1, -1);
    }
    
    
    /**
     * <P> query all of LuceneIndex list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public LuceneIndexList queryLuceneIndexByType(Byte type, boolean forUpdate)
            throws SQLException, IOException{
    	
    	this.luceneIndexManager.setTypeFilter(type);
    	
        /* if limit < 0 or offset < 0 then select all */
        return this.luceneIndexManager.select(forUpdate, -1, -1);
    }


    /**
     * <P> count total LuceneIndex </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalLuceneIndex()
            throws SQLException, IOException{
        return this.luceneIndexManager.countTotal();
    }
    
    /**
	 * Set typeFilter
	 * @param typeFilter the typeFilter to set
	 */
	public void setTypeFilter(Byte typeFilter) {
		this.luceneIndexManager.setTypeFilter(typeFilter);
	}
	
	/**
     * Add order field for table lucene index
     * @param orderField
     */
    public void addOrderFieldLuceneIndex(OrderField orderField) {
        this.luceneIndexManager.addOrderField(orderField);
    }
}
