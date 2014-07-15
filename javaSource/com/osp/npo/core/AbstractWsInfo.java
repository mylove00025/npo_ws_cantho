package com.osp.npo.core;

import java.util.Calendar;

/**
 * <P>
 * Basic Info class
 * </P>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17041 $
 */
abstract public class AbstractWsInfo {

	/** Entry User Id */
    private Long entryUserId;

    /** Entry User Name */
    private String entryUserName;

    /** Entry date */
    private Calendar entryDateTime;

    /** Update user id */
    private Long updateUserId;

    /** Update user name */
    private String updateUserName;

    /** Update date */
    private Calendar updateDateTime;

    /**
     * <P>
     * 
     * </P>
     * 
     * @param disp_string
     * @return 
     */
    public String regularizeDisp(String disp_string) {

        // null
        if (null == disp_string) {
            return "";
        }

        return disp_string;

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
	 * Get entryUserId
	 * @return the entryUserId
	 */
	public Long getEntryUserId() {
		return entryUserId;
	}

	/**
	 * Set entryUserId
	 * @param entryUserId the entryUserId to set
	 */
	public void setEntryUserId(Long entryUserId) {
		this.entryUserId = entryUserId;
	}

	/**
	 * Get entryUserName
	 * @return the entryUserName
	 */
	public String getEntryUserName() {
		return entryUserName;
	}

	/**
	 * Set entryUserName
	 * @param entryUserName the entryUserName to set
	 */
	public void setEntryUserName(String entryUserName) {
		this.entryUserName = entryUserName;
	}

	/**
     * Get the updateDateTime
     *
     * @return the updateDateTime
     */
    public Calendar getUpdateDateTime() {
        return updateDateTime;
    }

    /**
     * Set the updateDateTime
     *
     * @param updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(Calendar updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    /**
	 * Get updateUserId
	 * @return the updateUserId
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * Set updateUserId
	 * @param updateUserId the updateUserId to set
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * Get updateUserName
	 * @return the updateUserName
	 */
	public String getUpdateUserName() {
		return updateUserName;
	}

	/**
	 * Set updateUserName
	 * @param updateUserName the updateUserName to set
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
