package com.osp.npo.core.synchronize;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.synchronize.SynchronizeWsInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class SynchronizeWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public SynchronizeWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public SynchronizeWsInfo get(int index) {
        return ((SynchronizeWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(SynchronizeWsInfo info) {
        return this.list.add(info);
    }
}
