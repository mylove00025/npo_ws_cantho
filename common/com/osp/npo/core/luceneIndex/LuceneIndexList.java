package com.osp.npo.core.luceneIndex;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;


/**
 * Generate by script
 * Generate date: 06/07/2011 5:56:04 PM
 * @version $Revision$ 
 */
public class LuceneIndexList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public LuceneIndexList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public LuceneIndexInfo get(int index) {
        return ((LuceneIndexInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(LuceneIndexInfo info) {
        return this.list.add(info);
    }
}
