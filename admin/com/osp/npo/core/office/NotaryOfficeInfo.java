package com.osp.npo.core.office;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 02/17/2011 3:31:16 PM
 * @version $Revision: 20812 $ 
 */
public class NotaryOfficeInfo extends AbstractInfo {


    /** Notary office ID */
    private Long noid;
    
    /** Office type */
    private Byte officeType;

    /** Notary office name */
    private String name;

    /** Address */
    private String address;

    /** Telephone */
    private String phone;

    /** Fax number */
    private String fax;

    /** Email address */
    private String email;

    /** Website address */
    private String website;

    /** Other information */
    private String otherInfo;

    /** MAC address */
    private String macAddress;

    /** Authentication ID */
    private String authenticationId;

    /** Authentication code */
    private String authenticationCode;

    /** Active status:
 */
    private Boolean activeFlg;

    /** Hidden status
 */
    private Boolean hiddenFlg;

    /** Entry user id */
    private Long entryUserId;

    /** Entry user name */
    private String entryUserName;

    /** Entry date time */
    private Timestamp entryDateTime;

    /** Update user id */
    private Long updateUserId;

    /** Update user name */
    private String updateUserName;

    /** Update user date time */
    private Timestamp updateDateTime;

    /** last_connection_time */
    private Timestamp lastConnectionTime;
    
    /** Office type */
    private Byte synchronizeType;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public NotaryOfficeInfo() {
        super();
    }


    /**
     * <P>Get Notary office ID </P>
     *
     * @return Notary office ID
     */
    public Long getNoid() {
        return this.noid;
    }
    
    /**
     * <P>Get Office type </P>
     *
     * @return Office type:

     */
    public Byte getOfficeType() {
        return this.officeType;
    }

    /**
     * <P>Set Office type</P>
     *
     * @param officeType Office type:

     */
    public void setOfficeType(Byte officeType) {
        this.officeType = officeType;
    }

    /**
     * <P>Set Notary office ID. </P>
     *
     * @param noid Notary office ID
     */
    public void setNoid(Long noid) {
        this.noid = noid;
    }

    /**
     * <P>Get Notary office name </P>
     *
     * @return Notary office name
     */
    public String getName() {
        return this.name;
    }

    /**
     * <P>Set Notary office name. </P>
     *
     * @param name Notary office name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <P>Get Address </P>
     *
     * @return Address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * <P>Set Address. </P>
     *
     * @param address Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <P>Get Telephone </P>
     *
     * @return Telephone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * <P>Set Telephone. </P>
     *
     * @param phone Telephone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * <P>Get Fax number </P>
     *
     * @return Fax number
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * <P>Set Fax number. </P>
     *
     * @param fax Fax number
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * <P>Get Email address </P>
     *
     * @return Email address
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * <P>Set Email address. </P>
     *
     * @param email Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <P>Get Website address </P>
     *
     * @return Website address
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     * <P>Set Website address. </P>
     *
     * @param website Website address
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * <P>Get Other information </P>
     *
     * @return Other information
     */
    public String getOtherInfo() {
        return this.otherInfo;
    }

    /**
     * <P>Set Other information. </P>
     *
     * @param otherInfo Other information
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * <P>Get MAC address </P>
     *
     * @return MAC address
     */
    public String getMacAddress() {
        return this.macAddress;
    }

    /**
     * <P>Set MAC address. </P>
     *
     * @param macAddress MAC address
     */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * <P>Get Authentication ID </P>
     *
     * @return Authentication ID
     */
    public String getAuthenticationId() {
        return this.authenticationId;
    }

    /**
     * <P>Set Authentication ID. </P>
     *
     * @param authenticationId Authentication ID
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * <P>Get Authentication code </P>
     *
     * @return Authentication code
     */
    public String getAuthenticationCode() {
        return this.authenticationCode;
    }

    /**
     * <P>Set Authentication code. </P>
     *
     * @param authenticationCode Authentication code
     */
    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    /**
     * <P>Get Active status:
 </P>
     *
     * @return Active status:

     */
    public Boolean getActiveFlg() {
        return this.activeFlg;
    }

    /**
     * <P>Set Active status:
. </P>
     *
     * @param activeFlg Active status:

     */
    public void setActiveFlg(Boolean activeFlg) {
        this.activeFlg = activeFlg;
    }

    /**
     * <P>Get Hidden status
 </P>
     *
     * @return Hidden status

     */
    public Boolean getHiddenFlg() {
        return this.hiddenFlg;
    }

    /**
     * <P>Set Hidden status
. </P>
     *
     * @param hiddenFlg Hidden status

     */
    public void setHiddenFlg(Boolean hiddenFlg) {
        this.hiddenFlg = hiddenFlg;
    }

    /**
     * <P>Get Entry user id </P>
     *
     * @return Entry user id
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set Entry user id. </P>
     *
     * @param entryUserId Entry user id
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Entry user name </P>
     *
     * @return Entry user name
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Entry user name. </P>
     *
     * @param entryUserName Entry user name
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Entry date time </P>
     *
     * @return Entry date time
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Entry date time. </P>
     *
     * @param entryDateTime Entry date time
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get Update user id </P>
     *
     * @return Update user id
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set Update user id. </P>
     *
     * @param updateUserId Update user id
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Update user name </P>
     *
     * @return Update user name
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Update user name. </P>
     *
     * @param updateUserName Update user name
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Update user date time </P>
     *
     * @return Update user date time
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Update user date time. </P>
     *
     * @param updateDateTime Update user date time
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


	/**
	 * Get lastConnectionTime
	 * @return the lastConnectionTime
	 */
	public Timestamp getLastConnectionTime() {
		return lastConnectionTime;
	}


	/**
	 * Set lastConnectionTime
	 * @param lastConnectionTime the lastConnectionTime to set
	 */
	public void setLastConnectionTime(Timestamp lastConnectionTime) {
		this.lastConnectionTime = lastConnectionTime;
	}


	/**
	 * Get synchronizeType
	 * @return the synchronizeType
	 */
	public Byte getSynchronizeType() {
		return synchronizeType;
	}


	/**
	 * Set synchronizeType
	 * @param synchronizeType the synchronizeType to set
	 */
	public void setSynchronizeType(Byte synchronizeType) {
		this.synchronizeType = synchronizeType;
	}
    
}
