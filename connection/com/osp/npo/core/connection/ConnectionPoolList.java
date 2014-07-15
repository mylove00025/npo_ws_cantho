package com.osp.npo.core.connection;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.connection.ConnectionPoolInfo;


/**
 * Generate by script
 * Generate date: 10/14/2011 9:26:39 AM
 * @version $Revision$ 
 */
public class ConnectionPoolList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ConnectionPoolList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public ConnectionPoolInfo get(int index) {
        return ((ConnectionPoolInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(ConnectionPoolInfo info) {
        return this.list.add(info);
    }
}
