package com.osp.npo.core.diagnostic;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.diagnostic.DiagnosticInfo;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:58 PM
 * @version $Revision$ 
 */
public class DiagnosticList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DiagnosticList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public DiagnosticInfo get(int index) {
        return ((DiagnosticInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(DiagnosticInfo info) {
        return this.list.add(info);
    }
}
