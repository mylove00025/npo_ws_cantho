package com.osp.npo.core.announcement;


import com.osp.npo.core.AbstractList;
import com.osp.npo.core.announcement.AnnouncementWsInfo;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20134 $ 
 */
public class AnnouncementWsList extends AbstractList {


    /**
     * <P>Generate Instance.</P>
     *
     */
    public AnnouncementWsList() {
        super();
    }


    /**
     * <P>Get object Info from List</P>
     *
     * @param index Index
     * @return object Info
     */
    public AnnouncementWsInfo get(int index) {
        return ((AnnouncementWsInfo) this.list.get(index));
    }


    /**
     * <P>Add object Info to List.</P>
     *
     * @param info object Info
     * @return List of ojbect after add object Info
     */
    public boolean add(AnnouncementWsInfo info) {
        return this.list.add(info);
    }
}
