package com.osp.npo.core.synchronize;


import com.osp.npo.core.AbstractWsInfo;
import java.util.Calendar;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class SynchronizeWsInfo extends AbstractWsInfo {


    /** Synchronize type:
 */
    private Byte type;

    /** Synchronize ID */
    private String dataId;

    /** Notary office authentication id */
    private String authenticationId;

    /** Synchronize action:
 */
    private Byte action;
    
    private Long historyId;

    /** Synchronize status:
 */
    private Byte status;

    /** Create date time */
    private Calendar entryDateTime;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public SynchronizeWsInfo() {
        super();
    }


    /**
     * <P>Get Synchronize type:
 </P>
     *
     * @return Synchronize type:

     */
    public Byte getType() {
        return this.type;
    }

    /**
     * <P>Set Synchronize type:
. </P>
     *
     * @param type Synchronize type:

     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * <P>Get Synchronize ID </P>
     *
     * @return Synchronize ID
     */
    public String getDataId() {
        return this.dataId;
    }

    /**
     * <P>Set Synchronize ID. </P>
     *
     * @param dataId Synchronize ID
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * <P>Get Notary office authentication id </P>
     *
     * @return Notary office authentication id
     */
    public String getAuthenticationId() {
        return this.authenticationId;
    }

    /**
     * <P>Set Notary office authentication id. </P>
     *
     * @param authenticationId Notary office authentication id
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * <P>Get Synchronize action:
 </P>
     *
     * @return Synchronize action:

     */
    public Byte getAction() {
        return this.action;
    }

    /**
     * <P>Set Synchronize action:
. </P>
     *
     * @param action Synchronize action:

     */
    public void setAction(Byte action) {
        this.action = action;
    }

    /**
     * <P>Get Synchronize status:
 </P>
     *
     * @return Synchronize status:

     */
    public Byte getStatus() {
        return this.status;
    }

    /**
     * <P>Set Synchronize status:
. </P>
     *
     * @param status Synchronize status:

     */
    public void setStatus(Byte status) {
        this.status = status;
    }


    /**
     * Get the entryDateTime
     *
     * @return the entryDateTime
     */
    public Calendar getEntryDateTime() {
        return entryDateTime;
    }


    /**
     * Set the entryDateTime
     *
     * @param entryDateTime the entryDateTime to set
     */
    public void setEntryDateTime(Calendar entryDateTime) {
        this.entryDateTime = entryDateTime;
    }


    /**
     * Get the historyId
     *
     * @return the historyId
     */
    public Long getHistoryId() {
        return historyId;
    }


    /**
     * Set the historyId
     *
     * @param historyId the historyId to set
     */
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
    
}
