package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.DataPreventHistoryWsInfo;


/**
 * Generate by script
 * Generate date: 1/24/2011 2:41:43 PM
 * @version $Revision$ 
 */
public class DataPreventHistoryWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DataPreventHistoryWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DataPreventHistoryWsInfo get(int index) {
        return ((DataPreventHistoryWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DataPreventHistoryWsInfo info) {
        return this.list.add(info);
    }
}
