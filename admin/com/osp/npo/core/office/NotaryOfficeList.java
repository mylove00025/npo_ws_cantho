package com.osp.npo.core.office;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.office.NotaryOfficeInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class NotaryOfficeList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public NotaryOfficeList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public NotaryOfficeInfo get(int index) {
        return ((NotaryOfficeInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(NotaryOfficeInfo info) {
        return this.list.add(info);
    }
}
