package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.TransactionPropertyWsInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public TransactionPropertyWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public TransactionPropertyWsInfo get(int index) {
        return ((TransactionPropertyWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(TransactionPropertyWsInfo info) {
        return this.list.add(info);
    }
}
