package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.prevent.PropertyPreventWsInfo;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 19880 $ 
 */
public class PropertyPreventWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyPreventWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public PropertyPreventWsInfo get(int index) {
        return ((PropertyPreventWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(PropertyPreventWsInfo info) {
        return this.list.add(info);
    }
}
