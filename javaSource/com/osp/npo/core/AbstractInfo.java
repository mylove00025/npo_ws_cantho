package com.osp.npo.core;

import java.sql.Timestamp;

/**
 * <P>
 * Basic Info class
 * </P>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17041 $
 */
abstract public class AbstractInfo {

	/** Entry User Id */
    private Long entryUserId;

    /** Entry User Name */
    private String entryUserName;

    /** Entry date */
    private Timestamp entryDateTime;

    /** Update user id */
    private Long updateUserId;

    /** Update user name */
    private String updateUserName;

    /** Update date */
    private Timestamp updateDateTime;

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
	 * Get entryDateTime
	 * @return the entryDateTime
	 */
	public Timestamp getEntryDateTime() {
		return entryDateTime;
	}

	/**
	 * Set entryDateTime
	 * @param entryDateTime the entryDateTime to set
	 */
	public void setEntryDateTime(Timestamp entryDateTime) {
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
	 * Get updateDateTime
	 * @return the updateDateTime
	 */
	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	/**
	 * Set updateDateTime
	 * @param updateDateTime the updateDateTime to set
	 */
	public void setUpdateDateTime(Timestamp updateDateTime) {
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
