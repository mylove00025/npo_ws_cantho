package com.osp.npo.core.prevent;


import java.util.Calendar;

import com.osp.npo.core.AbstractWsInfo;


/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyWsInfo extends AbstractWsInfo {


    /** Transaction property */
    private Long tpid;

    /** Synchronize ID */
    private String synchronizeId;

    /** Property type:
 */
    private String type;

    /** Property information */
    private String propertyInfo;

    /** Transaction content */
    private String transactionContent;

    /** Notary date */
    private Calendar notaryDate;

    /** Notary office name */
    private String notaryOfficeName;

    /** Contract ID */
    private Long contractId;
    
    /** Contract number */
    private String contractNumber;
    
    private String contractName;

    /** Contract value */
    private String contractValue;

    /** Relation object */
    private String relationObject;

    /** Ho ten Cong chung vien */
    private String notaryPerson;

    /** Notary place */
    private String notaryPlace;

    /** Notary fee */
    private String notaryFee;

    /** Note */
    private String note;

    /** Trang thai huy cua hop dong */
    private Boolean cancelStatus;

    /** Mo ta chi tiet huy */
    private String cancelDescription;
    
    /** Quan */
    private String landDistrict;
    
    /** Phuong xa */
    private String landStreet;
    
    /** Thoi han hop dong */
    private String contractPeriod;
    
    /** Tinh trang giai chap */
    private Boolean mortageCancelFlag;
    
    /** Ngay giai chap */
    private String mortageCancelDate;
    
    /** Ghi chu giai chap */
    private String mortageCancelNote;
    
    /** Nhom hop dong */
    private String contractKind;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public TransactionPropertyWsInfo() {
        super();
    }


    /**
     * <P>Get Transaction property </P>
     *
     * @return Transaction property
     */
    public Long getTpid() {
        return this.tpid;
    }

    /**
     * <P>Set Transaction property. </P>
     *
     * @param tpid Transaction property
     */
    public void setTpid(Long tpid) {
        this.tpid = tpid;
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
     * <P>Get Property type:
 </P>
     *
     * @return Property type:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Property type:
. </P>
     *
     * @param type Property type:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get Property information </P>
     *
     * @return Property information
     */
    public String getPropertyInfo() {
        return this.propertyInfo;
    }

    /**
     * <P>Set Property information. </P>
     *
     * @param propertyInfo Property information
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * <P>Get Transaction content </P>
     *
     * @return Transaction content
     */
    public String getTransactionContent() {
        return this.transactionContent;
    }

    /**
     * <P>Set Transaction content. </P>
     *
     * @param transactionContent Transaction content
     */
    public void setTransactionContent(String transactionContent) {
        this.transactionContent = transactionContent;
    }

    /**
     * Get the notaryDate
     *
     * @return the notaryDate
     */
    public Calendar getNotaryDate() {
        return notaryDate;
    }

    /**
     * Set the notaryDate
     *
     * @param notaryDate the notaryDate to set
     */
    public void setNotaryDate(Calendar notaryDate) {
        this.notaryDate = notaryDate;
    }


    /**
     * <P>Get Notary office name </P>
     *
     * @return Notary office name
     */
    public String getNotaryOfficeName() {
        return this.notaryOfficeName;
    }

    /**
     * <P>Set Notary office name. </P>
     *
     * @param notaryOfficeName Notary office name
     */
    public void setNotaryOfficeName(String notaryOfficeName) {
        this.notaryOfficeName = notaryOfficeName;
    }

    /**
     * <P>Get Contract ID </P>
     *
     * @return Contract ID
     */
    public Long getContractId() {
        return this.contractId;
    }

    /**
     * <P>Set Contract ID. </P>
     *
     * @param contractId Contract ID
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }


    /**
     * Get the contractNumber
     *
     * @return the contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }


    /**
     * Set the contractNumber
     *
     * @param contractNumber the contractNumber to set
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }


    /**
     * Get the contractValue
     *
     * @return the contractValue
     */
    public String getContractValue() {
        return contractValue;
    }


    /**
     * Set the contractValue
     *
     * @param contractValue the contractValue to set
     */
    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }


    /**
     * Get the relationObject
     *
     * @return the relationObject
     */
    public String getRelationObject() {
        return relationObject;
    }


    /**
     * Set the relationObject
     *
     * @param relationObject the relationObject to set
     */
    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }


    /**
     * Get the notaryPerson
     *
     * @return the notaryPerson
     */
    public String getNotaryPerson() {
        return notaryPerson;
    }


    /**
     * Set the notaryPerson
     *
     * @param notaryPerson the notaryPerson to set
     */
    public void setNotaryPerson(String notaryPerson) {
        this.notaryPerson = notaryPerson;
    }


    /**
     * Get the notaryPlace
     *
     * @return the notaryPlace
     */
    public String getNotaryPlace() {
        return notaryPlace;
    }


    /**
     * Set the notaryPlace
     *
     * @param notaryPlace the notaryPlace to set
     */
    public void setNotaryPlace(String notaryPlace) {
        this.notaryPlace = notaryPlace;
    }


    /**
     * Get the notaryFee
     *
     * @return the notaryFee
     */
    public String getNotaryFee() {
        return notaryFee;
    }


    /**
     * Set the notaryFee
     *
     * @param notaryFee the notaryFee to set
     */
    public void setNotaryFee(String notaryFee) {
        this.notaryFee = notaryFee;
    }


    /**
     * Get the note
     *
     * @return the note
     */
    public String getNote() {
        return note;
    }


    /**
     * Set the note
     *
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }


    /**
     * Get the cancelStatus
     *
     * @return the cancelStatus
     */
    public Boolean getCancelStatus() {
        return cancelStatus;
    }


    /**
     * Set the cancelStatus
     *
     * @param cancelStatus the cancelStatus to set
     */
    public void setCancelStatus(Boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }


    /**
     * Get the cancelDescription
     *
     * @return the cancelDescription
     */
    public String getCancelDescription() {
        return cancelDescription;
    }


    /**
     * Set the cancelDescription
     *
     * @param cancelDescription the cancelDescription to set
     */
    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }


    /**
     * Get the contractName
     *
     * @return the contractName
     */
    public String getContractName() {
        return contractName;
    }


    /**
     * Set the contractName
     *
     * @param contractName the contractName to set
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }


	public void setLandDistrict(String landDistrict) {
		this.landDistrict = landDistrict;
	}


	public String getLandDistrict() {
		return landDistrict;
	}


	public void setLandStreet(String landStreet) {
		this.landStreet = landStreet;
	}


	public String getLandStreet() {
		return landStreet;
	}


	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}


	public String getContractPeriod() {
		return contractPeriod;
	}


	public void setMortageCancelFlag(Boolean mortageCancelFlag) {
		this.mortageCancelFlag = mortageCancelFlag;
	}


	public Boolean getMortageCancelFlag() {
		return mortageCancelFlag;
	}


	public void setMortageCancelDate(String mortageCancelDate) {
		this.mortageCancelDate = mortageCancelDate;
	}


	public String getMortageCancelDate() {
		return mortageCancelDate;
	}


	public void setMortageCancelNote(String mortageCancelNote) {
		this.mortageCancelNote = mortageCancelNote;
	}


	public String getMortageCancelNote() {
		return mortageCancelNote;
	}


	public void setContractKind(String contractKind) {
		this.contractKind = contractKind;
	}


	public String getContractKind() {
		return contractKind;
	}
    
}
