package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.announcement.AnnouncementWsManager;
import com.osp.npo.core.announcement.AnnouncementWsInfo;
import com.osp.npo.core.announcement.AnnouncementWsList;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:53 PM
 * @version $Revision: 20599 $ 
 */
public class AnnouncementWsService extends AbstractService {


    /** Announcement Manager Object */
    private AnnouncementWsManager announcementManager;

    /** <P> Service constructor </P>*/
    public AnnouncementWsService(Connection connection) {
        super(connection);
        this.announcementManager = new AnnouncementWsManager (connection);
    }


    /**
     * <P> entry AnnouncementInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryAnnouncement(AnnouncementWsInfo info) throws SQLException{
        return this.announcementManager.insert(info);
    }


    /**
     * <P> modify AnnouncementInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyAnnouncement(AnnouncementWsInfo info) throws SQLException, IOException{
        return this.announcementManager.update(info);
    }


    /**
     * <P> remove Announcement by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeAnnouncement(Long id) throws SQLException{
        return this.announcementManager.delete(id);
    }


    /**
     * <P> query Announcement list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementWsList queryAnnouncement(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.announcementManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementWsList queryAllAnnouncement(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public AnnouncementWsList queryAllAnnouncementWS(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.selectWS(forUpdate, -1, -1);
    }
    
    /**
     * <P> query all of Announcement list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public List<String> queryAllSynchonizeId(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.announcementManager.selectFirstSynchoronize(forUpdate, -1, -1);
    }

    /**
     * <P> count total Announcement </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalAnnouncement()
            throws SQLException, IOException{
        return this.announcementManager.countTotal();
    }

    /**
     * Add order field for table announcement
     * @param orderField
     */
    public void addOrderFieldAnnouncement(OrderField orderField) {
        this.announcementManager.addOrderField(orderField);
    }
    
    public void setTitleFilter(String titleFilter, FilterKind kind) {
        this.announcementManager.setTitleFilter(titleFilter, kind);
    }
    
    public void setIdFilter(Long idFilter) {
        this.announcementManager.setIdFilter(idFilter);
    }
    
    /**
     * Set current open announcement id
     * @param idCurentFilter
     */
    public void setIdCurentFilter(Long idCurentFilter) {
        this.announcementManager.setIdCurentFilter(idCurentFilter);
    }
    
    /**
     * Set the synchronizeIdFilter
     *
     * @param synchronizeIdFilter the synchronizeIdFilter to set
     */
    public void setSynchronizeIdFilter(String synchronizeIdFilter) {
        this.announcementManager.setSynchronizeIdFilter(synchronizeIdFilter);
    }
}
