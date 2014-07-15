package com.osp.npo.core.announcement;


import com.osp.npo.core.AbstractWsInfo;
import java.util.Calendar;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20465 $ 
 */
public class AnnouncementWsInfo extends AbstractWsInfo {


    /** Announcement ID */
    private Long aid;
    
    /** Synchronize ID */
    private String synchronizeId;

    /** Announcement kind */
    private Byte kind;

    /** Confirm request */
    private Byte confirmRequest;

    /** Importance type */
    private Byte importanceType;

    /** Popup display flag */
    private Boolean popupDisplayFlg;

    /** Popup display  days */
    private Long popupDisplayDay;

    /** Title */
    private String title;

    /** Content */
    private String content;

    /** Sender information */
    private String senderInfo;

    /** Send date time */
    private Calendar sendDateTime;

    /** Attach file name */
    private String attachFileName;

    /** Attach file path */
    private String attachFilePath;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public AnnouncementWsInfo() {
        super();
    }


    /**
     * <P>Get Announcement ID </P>
     *
     * @return Announcement ID
     */
    public Long getAid() {
        return this.aid;
    }

    /**
     * <P>Set Announcement ID. </P>
     *
     * @param aid Announcement ID
     */
    public void setAid(Long aid) {
        this.aid = aid;
    }
    
    /**
     * <P>Get Synchronize ID </P>
     *
     * @return Synchronize ID
     */
    public String getSynchronizeId() {
        return this.synchronizeId;
    }

    /**
     * <P>Set Synchronize ID. </P>
     *
     * @param synchronizeId Synchronize ID
     */
    public void setSynchronizeId(String synchronizeId) {
        this.synchronizeId = synchronizeId;
    }

    /**
     * <P>Get Announcement kind </P>
     *
     * @return Announcement kind

     */
    public Byte getKind() {
        return this.kind;
    }

    /**
     * <P>Set Announcement kind. </P>
     *
     * @param kind Announcement kind

     */
    public void setKind(Byte kind) {
        this.kind = kind;
    }

    /**
     * <P>Get Confirm request </P>
     *
     * @return Confirm request

     */
    public Byte getConfirmRequest() {
        return this.confirmRequest;
    }

    /**
     * <P>Set Confirm request. </P>
     *
     * @param confirmRequest Confirm request

     */
    public void setConfirmRequest(Byte confirmRequest) {
        this.confirmRequest = confirmRequest;
    }

    /**
     * <P>Get Importance type </P>
     *
     * @return Importance type

     */
    public Byte getImportanceType() {
        return this.importanceType;
    }

    /**
     * <P>Set Importance type. </P>
     *
     * @param importanceType Importance type

     */
    public void setImportanceType(Byte importanceType) {
        this.importanceType = importanceType;
    }

    /**
     * <P>Get Popup display flag </P>
     *
     * @return Popup display flag

     */
    public Boolean getPopupDisplayFlg() {
        return this.popupDisplayFlg;
    }

    /**
     * <P>Set Popup display flag. </P>
     *
     * @param popupDisplayFlg Popup display flag

     */
    public void setPopupDisplayFlg(Boolean popupDisplayFlg) {
        this.popupDisplayFlg = popupDisplayFlg;
    }

    /**
     * <P>Get Popup display  days </P>
     *
     * @return Popup display  days
     */
    public Long getPopupDisplayDay() {
        return this.popupDisplayDay;
    }

    /**
     * <P>Set Popup display  days. </P>
     *
     * @param popupDisplayDay Popup display  days
     */
    public void setPopupDisplayDay(Long popupDisplayDay) {
        this.popupDisplayDay = popupDisplayDay;
    }

    /**
     * <P>Get Title </P>
     *
     * @return Title
     */
    public String getTitle() {
    	return this.title;
    }
    
    /**
     * 
     * @return
     */
    public String getTitleDisp() {
    	int count = 42;
    	if (title.length() > count ) {    		
    		int index = count;
    		while (index > 0 && this.title.charAt(index) != ' ') {
    			index--;
    		}
    		String  titleReturn = (index == 0) ? this.title.substring(0, count) : this.title.substring(0, index);
    		titleReturn += " ...";
    		return titleReturn;
    	}
    	return this.title;
    }


    /**
     * <P>Set Title. </P>
     *
     * @param title Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <P>Get Content </P>
     *
     * @return Content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <P>Set Content. </P>
     *
     * @param content Content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * <P>Get Sender information </P>
     *
     * @return Sender information
     */
    public String getSenderInfo() {
        return this.senderInfo;
    }

    /**
     * <P>Set Sender information. </P>
     *
     * @param senderInfo Sender information
     */
    public void setSenderInfo(String senderInfo) {
        this.senderInfo = senderInfo;
    }

    /**
     * Get the sendDateTime
     *
     * @return the sendDateTime
     */
    public Calendar getSendDateTime() {
        return sendDateTime;
    }


    /**
     * Set the sendDateTime
     *
     * @param sendDateTime the sendDateTime to set
     */
    public void setSendDateTime(Calendar sendDateTime) {
        this.sendDateTime = sendDateTime;
    }


    /**
     * <P>Get Attach file name </P>
     *
     * @return Attach file name
     */
    public String getAttachFileName() {
        return this.attachFileName;
    }

    /**
     * <P>Set Attach file name. </P>
     *
     * @param attachFileName Attach file name
     */
    public void setAttachFileName(String attachFileName) {
        this.attachFileName = attachFileName;
    }

    /**
     * <P>Get Attach file path </P>
     *
     * @return Attach file path
     */
    public String getAttachFilePath() {
        return this.attachFilePath;
    }

    /**
     * <P>Set Attach file path. </P>
     *
     * @param attachFilePath Attach file path
     */
    public void setAttachFilePath(String attachFilePath) {
        this.attachFilePath = attachFilePath;
    }
    
}
