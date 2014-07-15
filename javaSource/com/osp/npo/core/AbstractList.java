package com.osp.npo.core;

import java.util.ArrayList;


/**
 * <P>
 * Basic List Class
 * </P>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17041 $
 */
abstract public class AbstractList {


    /** List */
    protected ArrayList<Object> list;


    /**
     * <P>
     * Default construction
     * </P>
     * 
     */
    public AbstractList() {

        this.list = new ArrayList<Object>(0);
    }


    /**
     * <P>
     * Get size of list
     * </P>
     * 
     * @return size of list
     */
    public int size() {

        return this.list.size();
    }


    /**
     * <P>
     * Get list
     * </P>
     * 
     * @return ArrayList
     */
    public ArrayList getList() {
        return this.list;
    }
}
