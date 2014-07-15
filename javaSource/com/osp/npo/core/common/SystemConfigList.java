package com.osp.npo.core.common;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.common.SystemConfigInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 17046 $
 */
public class SystemConfigList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public SystemConfigList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public SystemConfigInfo get(int index) {
        return ((SystemConfigInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(SystemConfigInfo info) {
        return this.list.add(info);
    }
}
