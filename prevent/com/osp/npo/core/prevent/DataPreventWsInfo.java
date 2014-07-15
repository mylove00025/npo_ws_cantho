package com.osp.npo.core.prevent;


import java.util.Calendar;

import com.osp.npo.core.AbstractWsInfo;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 20586 $
 */
public class DataPreventWsInfo extends AbstractWsInfo {

    /** id DLNC */
    private Long id;
    
    /** Synchronize ID */
    private String synchronizeId;

    /** T�i s?n b? ch?n */
    private Long propertyId;

    /** Ph�n lo?i d? li?u ngan ch?n: */
    private String originKind;

    /** C? x�a d? li?u */
    private Boolean deleteFlg;

    /** �on v? dang k� CV ngan ch?n */
    private String preventRegistAgency;

    /** S? v�o s? c�ng van y�u c?u */
    private String preventInBookNumber;

    /** Th�ng tin ngu?i (don v?) g?i y�u c?u ngan ch?n */
    private String preventPersonInfo;

    /** S? c�ng van y�u c?u ngan ch?n */
    private String preventDocNumber;

    /** Ng�y c�ng van y�u c?u ngan ch?n */
    private Calendar preventDocDate;

    /** Ng�y nh?n c�ng van y�u c?u ngan ch?n */
    private Calendar preventDocReceiveDate;

    /** Ng�y nh?p c�ng van y�u c?u ngan ch?n */
    private Calendar preventInputDate;

    /** Tr�ch y?u n?i dung c�ng van y�u c?u ngan ch?n */
    private String preventDocSummary;

    /** T�n file d�nh k�m CV ngan ch?n */
    private String preventFileName;

    /** Luu du?ng d?n ch?a file d�nh k�m CV ngan ch?n */
    private String preventFilePath;

    /** Ghi ch� ngan ch?n */
    private String preventNote;

    /** T�nh tr?ng gi?i t?a:  */
    private Boolean releaseFlg;

    /** �on v? dang k� CV gi?i t?a */
    private String releaseRegistAgency;

    /** S? v�o s? c�ng van gi?i t?a */
    private String releaseInBookNumber;

    /** Th�ng tin ngu?i (don v?) g?i y�u c?u gi?i t?a */
    private String releasePersonInfo;

    /** S? c�ng van y�u c?u gi?i t?a */
    private String releaseDocNumber;

    /** Ng�y c�ng van y�u c?u gi?i t?a */
    private Calendar releaseDocDate;

    /** Ng�y nh?n c�ng van y�u c?u gi?i t?a */
    private Calendar releaseDocReceiveDate;

    /** Ng�y nh?p c�ng van y�u c?u gi?i t?a */
    private Calendar releaseInputDate;

    /** Tr�ch y?u n?i dung c�ng van y�u c?u gi?i t?a */
    private String releaseDocSummary;

    /** T�n file d�nh k�m CV gi?i t?a */
    private String releaseFileName;

    /** Luu du?ng d?n ch?a file d�nh k�m CV gi?i t?a */
    private String releaseFilePath;

    /** Ghi ch� gi?i t?a */
    private String releaseNote;

    // info from property prevent info

    /** Loai t�i s?n ch?n:  */
    private String type;

    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Th�ng tin kh�c */
    private String otherInfo;

    /** Nh� d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nh� d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nh� d?t - Ng�y c?p GCN */
    private Calendar landIssueDate;

    /** Nh� d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nh� d?t -S? th?a d?t */
    private String landNumber;

    /** Nh� d?t -�?a ch? th?a d?t */
    private String landAddress;

    /** Nh� d?t - Di?n t�ch */
    private String landArea;

    /** Nh� d?t - Di?n t�ch s? d?ng chung */
    private String landPublicArea;

    /** Nh� d?t - Di?n t�ch s? d?ng ri�ng */
    private String landPrivateArea;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUsePurpose;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUsePeriod;

    /** Nh� d?t - M?c d�ch s? d?ng */
    private String landUseOrigin;

    /** Nh� d?t - �?a b�n T?nh/Th�nh */
    private Long landDistrict;

    /** Nh� d?t - �?a b�n Qu?n/Huy?n  */
    private Long landProvince;

    /** Tai san gan lien voi dat */
    private String landAssociateProperty;

    /** � t�, Motor - Bi?n ki?m so�t */
    private String carLicenseNumber;

    /** � t�, Motor - S? dang k� */
    private String carRegistNumber;

    /** � t�, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** � t�, Motor  - Ng�y c?p GCN */
    private Calendar carIssueDate;

    /** � t�, Motor - S? khung  */
    private String carFrameNumber;

    /** � t�, Motor - S? m�y */
    private String carMachineNumber;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public DataPreventWsInfo() {
        super();
    }


    /**
     * <P>Get id DLNC </P>
     *
     * @return id DLNC
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id DLNC. </P>
     *
     * @param id id DLNC
     */
    public void setId(Long id) {
        this.id = id;
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
     * <P>Get T�i s?n b? ch?n </P>
     *
     * @return T�i s?n b? ch?n
     */
    public Long getPropertyId() {
        return this.propertyId;
    }

    /**
     * <P>Set T�i s?n b? ch?n. </P>
     *
     * @param propertyId T�i s?n b? ch?n
     */
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * <P>Get Ph�n lo?i d? li?u ngan ch?n:
 </P>
     *
     * @return Ph�n lo?i d? li?u ngan ch?n:

     */
    public String getOriginKind() {
        return this.originKind;
    }

    /**
     * <P>Set Ph�n lo?i d? li?u ngan ch?n:
. </P>
     *
     * @param originKind Ph�n lo?i d? li?u ngan ch?n:

     */
    public void setOriginKind(String originKind) {
        this.originKind = originKind;
    }

    /**
     * <P>Get C? x�a d? li?u </P>
     *
     * @return C? x�a d? li?u
     */
    public Boolean getDeleteFlg() {
        return this.deleteFlg;
    }

    /**
     * <P>Set C? x�a d? li?u. </P>
     *
     * @param deleteFlg C? x�a d? li?u
     */
    public void setDeleteFlg(Boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * <P>Get �on v? dang k� CV ngan ch?n </P>
     *
     * @return �on v? dang k� CV ngan ch?n
     */
    public String getPreventRegistAgency() {
        return this.preventRegistAgency;
    }

    /**
     * <P>Set �on v? dang k� CV ngan ch?n. </P>
     *
     * @param preventRegistAgency �on v? dang k� CV ngan ch?n
     */
    public void setPreventRegistAgency(String preventRegistAgency) {
        this.preventRegistAgency = preventRegistAgency;
    }

    /**
     * <P>Get S? v�o s? c�ng van y�u c?u </P>
     *
     * @return S? v�o s? c�ng van y�u c?u
     */
    public String getPreventInBookNumber() {
        return this.preventInBookNumber;
    }

    /**
     * <P>Set S? v�o s? c�ng van y�u c?u. </P>
     *
     * @param preventInBookNumber S? v�o s? c�ng van y�u c?u
     */
    public void setPreventInBookNumber(String preventInBookNumber) {
        this.preventInBookNumber = preventInBookNumber;
    }

    /**
     * <P>Get Th�ng tin ngu?i (don v?) g?i y�u c?u ngan ch?n </P>
     *
     * @return Th�ng tin ngu?i (don v?) g?i y�u c?u ngan ch?n
     */
    public String getPreventPersonInfo() {
        return this.preventPersonInfo;
    }

    /**
     * <P>Set Th�ng tin ngu?i (don v?) g?i y�u c?u ngan ch?n. </P>
     *
     * @param preventPersonInfo Th�ng tin ngu?i (don v?) g?i y�u c?u ngan ch?n
     */
    public void setPreventPersonInfo(String preventPersonInfo) {
        this.preventPersonInfo = preventPersonInfo;
    }

    /**
     * <P>Get S? c�ng van y�u c?u ngan ch?n </P>
     *
     * @return S? c�ng van y�u c?u ngan ch?n
     */
    public String getPreventDocNumber() {
        return this.preventDocNumber;
    }

    /**
     * <P>Set S? c�ng van y�u c?u ngan ch?n. </P>
     *
     * @param preventDocNumber S? c�ng van y�u c?u ngan ch?n
     */
    public void setPreventDocNumber(String preventDocNumber) {
        this.preventDocNumber = preventDocNumber;
    }

    /**
     * <P>Get Tr�ch y?u n?i dung c�ng van y�u c?u ngan ch?n </P>
     *
     * @return Tr�ch y?u n?i dung c�ng van y�u c?u ngan ch?n
     */
    public String getPreventDocSummary() {
        return this.preventDocSummary;
    }

    /**
     * <P>Set Tr�ch y?u n?i dung c�ng van y�u c?u ngan ch?n. </P>
     *
     * @param preventDocSummary Tr�ch y?u n?i dung c�ng van y�u c?u ngan ch?n
     */
    public void setPreventDocSummary(String preventDocSummary) {
        this.preventDocSummary = preventDocSummary;
    }

    /**
     * <P>Get T�n file d�nh k�m CV ngan ch?n </P>
     *
     * @return T�n file d�nh k�m CV ngan ch?n
     */
    public String getPreventFileName() {
        return this.preventFileName;
    }

    /**
     * <P>Set T�n file d�nh k�m CV ngan ch?n. </P>
     *
     * @param preventFileName T�n file d�nh k�m CV ngan ch?n
     */
    public void setPreventFileName(String preventFileName) {
        this.preventFileName = preventFileName;
    }

    /**
     * <P>Get Luu du?ng d?n ch?a file d�nh k�m CV ngan ch?n </P>
     *
     * @return Luu du?ng d?n ch?a file d�nh k�m CV ngan ch?n
     */
    public String getPreventFilePath() {
        return this.preventFilePath;
    }

    /**
     * <P>Set Luu du?ng d?n ch?a file d�nh k�m CV ngan ch?n. </P>
     *
     * @param preventFilePath Luu du?ng d?n ch?a file d�nh k�m CV ngan ch?n
     */
    public void setPreventFilePath(String preventFilePath) {
        this.preventFilePath = preventFilePath;
    }

    /**
     * <P>Get Ghi ch� ngan ch?n </P>
     *
     * @return Ghi ch� ngan ch?n
     */
    public String getPreventNote() {
        return this.preventNote;
    }

    /**
     * <P>Set Ghi ch� ngan ch?n. </P>
     *
     * @param preventNote Ghi ch� ngan ch?n
     */
    public void setPreventNote(String preventNote) {
        this.preventNote = preventNote;
    }

    /**
     * <P>Get T�nh tr?ng gi?i t?a:
 </P>
     *
     * @return T�nh tr?ng gi?i t?a:

     */
    public Boolean getReleaseFlg() {
        return this.releaseFlg;
    }

    /**
     * <P>Set T�nh tr?ng gi?i t?a:
. </P>
     *
     * @param releaseFlg T�nh tr?ng gi?i t?a:

     */
    public void setReleaseFlg(Boolean releaseFlg) {
        this.releaseFlg = releaseFlg;
    }

    /**
     * <P>Get �on v? dang k� CV gi?i t?a </P>
     *
     * @return �on v? dang k� CV gi?i t?a
     */
    public String getReleaseRegistAgency() {
        return this.releaseRegistAgency;
    }

    /**
     * <P>Set �on v? dang k� CV gi?i t?a. </P>
     *
     * @param releaseRegistAgency �on v? dang k� CV gi?i t?a
     */
    public void setReleaseRegistAgency(String releaseRegistAgency) {
        this.releaseRegistAgency = releaseRegistAgency;
    }

    /**
     * <P>Get S? v�o s? c�ng van gi?i t?a </P>
     *
     * @return S? v�o s? c�ng van gi?i t?a
     */
    public String getReleaseInBookNumber() {
        return this.releaseInBookNumber;
    }

    /**
     * <P>Set S? v�o s? c�ng van gi?i t?a. </P>
     *
     * @param releaseInBookNumber S? v�o s? c�ng van gi?i t?a
     */
    public void setReleaseInBookNumber(String releaseInBookNumber) {
        this.releaseInBookNumber = releaseInBookNumber;
    }

    /**
     * <P>Get Th�ng tin ngu?i (don v?) g?i y�u c?u gi?i t?a </P>
     *
     * @return Th�ng tin ngu?i (don v?) g?i y�u c?u gi?i t?a
     */
    public String getReleasePersonInfo() {
        return this.releasePersonInfo;
    }

    /**
     * <P>Set Th�ng tin ngu?i (don v?) g?i y�u c?u gi?i t?a. </P>
     *
     * @param releasePersonInfo Th�ng tin ngu?i (don v?) g?i y�u c?u gi?i t?a
     */
    public void setReleasePersonInfo(String releasePersonInfo) {
        this.releasePersonInfo = releasePersonInfo;
    }

    /**
     * <P>Get S? c�ng van y�u c?u gi?i t?a </P>
     *
     * @return S? c�ng van y�u c?u gi?i t?a
     */
    public String getReleaseDocNumber() {
        return this.releaseDocNumber;
    }

    /**
     * <P>Set S? c�ng van y�u c?u gi?i t?a. </P>
     *
     * @param releaseDocNumber S? c�ng van y�u c?u gi?i t?a
     */
    public void setReleaseDocNumber(String releaseDocNumber) {
        this.releaseDocNumber = releaseDocNumber;
    }

    /**
     * <P>Get Tr�ch y?u n?i dung c�ng van y�u c?u gi?i t?a </P>
     *
     * @return Tr�ch y?u n?i dung c�ng van y�u c?u gi?i t?a
     */
    public String getReleaseDocSummary() {
        return this.releaseDocSummary;
    }

    /**
     * <P>Set Tr�ch y?u n?i dung c�ng van y�u c?u gi?i t?a. </P>
     *
     * @param releaseDocSummary Tr�ch y?u n?i dung c�ng van y�u c?u gi?i t?a
     */
    public void setReleaseDocSummary(String releaseDocSummary) {
        this.releaseDocSummary = releaseDocSummary;
    }

    /**
     * <P>Get T�n file d�nh k�m CV gi?i t?a </P>
     *
     * @return T�n file d�nh k�m CV gi?i t?a
     */
    public String getReleaseFileName() {
        return this.releaseFileName;
    }

    /**
     * <P>Set T�n file d�nh k�m CV gi?i t?a. </P>
     *
     * @param releaseFileName T�n file d�nh k�m CV gi?i t?a
     */
    public void setReleaseFileName(String releaseFileName) {
        this.releaseFileName = releaseFileName;
    }

    /**
     * <P>Get Luu du?ng d?n ch?a file d�nh k�m CV gi?i t?a </P>
     *
     * @return Luu du?ng d?n ch?a file d�nh k�m CV gi?i t?a
     */
    public String getReleaseFilePath() {
        return this.releaseFilePath;
    }

    /**
     * <P>Set Luu du?ng d?n ch?a file d�nh k�m CV gi?i t?a. </P>
     *
     * @param releaseFilePath Luu du?ng d?n ch?a file d�nh k�m CV gi?i t?a
     */
    public void setReleaseFilePath(String releaseFilePath) {
        this.releaseFilePath = releaseFilePath;
    }

    /**
     * <P>Get Ghi ch� gi?i t?a </P>
     *
     * @return Ghi ch� gi?i t?a
     */
    public String getReleaseNote() {
        return this.releaseNote;
    }

    /**
     * <P>Set Ghi ch� gi?i t?a. </P>
     *
     * @param releaseNote Ghi ch� gi?i t?a
     */
    public void setReleaseNote(String releaseNote) {
        this.releaseNote = releaseNote;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }


    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * @return the propertyInfo
     */
    public String getPropertyInfo() {
        return propertyInfo;
    }


    /**
     * @param propertyInfo the propertyInfo to set
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }


    /**
     * @return the ownerInfo
     */
    public String getOwnerInfo() {
        return ownerInfo;
    }


    /**
     * @param ownerInfo the ownerInfo to set
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }


    /**
     * @return the otherInfo
     */
    public String getOtherInfo() {
        return otherInfo;
    }


    /**
     * @param otherInfo the otherInfo to set
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }


    /**
     * @return the landCertificate
     */
    public String getLandCertificate() {
        return landCertificate;
    }


    /**
     * @param landCertificate the landCertificate to set
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }


    /**
     * @return the landIssuePlace
     */
    public String getLandIssuePlace() {
        return landIssuePlace;
    }


    /**
     * @param landIssuePlace the landIssuePlace to set
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
    }


    /**
     * @return the landMapNumber
     */
    public String getLandMapNumber() {
        return landMapNumber;
    }


    /**
     * @param landMapNumber the landMapNumber to set
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }


    /**
     * @return the landNumber
     */
    public String getLandNumber() {
        return landNumber;
    }


    /**
     * @param landNumber the landNumber to set
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }


    /**
     * @return the landAddress
     */
    public String getLandAddress() {
        return landAddress;
    }


    /**
     * @param landAddress the landAddress to set
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }


    /**
     * @return the landArea
     */
    public String getLandArea() {
        return landArea;
    }


    /**
     * @param landArea the landArea to set
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }


    /**
     * @return the landPublicArea
     */
    public String getLandPublicArea() {
        return landPublicArea;
    }


    /**
     * @param landPublicArea the landPublicArea to set
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }


    /**
     * @return the landPrivateArea
     */
    public String getLandPrivateArea() {
        return landPrivateArea;
    }


    /**
     * @param landPrivateArea the landPrivateArea to set
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }


    /**
     * @return the landUsePurpose
     */
    public String getLandUsePurpose() {
        return landUsePurpose;
    }


    /**
     * @param landUsePurpose the landUsePurpose to set
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }


    /**
     * @return the landUsePeriod
     */
    public String getLandUsePeriod() {
        return landUsePeriod;
    }


    /**
     * @param landUsePeriod the landUsePeriod to set
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }


    /**
     * @return the landUseOrigin
     */
    public String getLandUseOrigin() {
        return landUseOrigin;
    }


    /**
     * @param landUseOrigin the landUseOrigin to set
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }


    /**
     * @return the landDistrict
     */
    public Long getLandDistrict() {
        return landDistrict;
    }


    /**
     * @param landDistrict the landDistrict to set
     */
    public void setLandDistrict(Long landDistrict) {
        this.landDistrict = landDistrict;
    }


    /**
     * @return the landProvince
     */
    public Long getLandProvince() {
        return landProvince;
    }


    /**
     * @param landProvince the landProvince to set
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }


    /**
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }


    /**
     * @return the carLicenseNumber
     */
    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }


    /**
     * @param carLicenseNumber the carLicenseNumber to set
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }


    /**
     * @return the carRegistNumber
     */
    public String getCarRegistNumber() {
        return carRegistNumber;
    }


    /**
     * @param carRegistNumber the carRegistNumber to set
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }


    /**
     * @return the carIssuePlace
     */
    public String getCarIssuePlace() {
        return carIssuePlace;
    }


    /**
     * @param carIssuePlace the carIssuePlace to set
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
    }

    /**
     * @return the carFrameNumber
     */
    public String getCarFrameNumber() {
        return carFrameNumber;
    }


    /**
     * @param carFrameNumber the carFrameNumber to set
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }


    /**
     * @return the carMachineNumber
     */
    public String getCarMachineNumber() {
        return carMachineNumber;
    }


    /**
     * @param carMachineNumber the carMachineNumber to set
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }


    /**
     * Get the preventDocDate
     *
     * @return the preventDocDate
     */
    public Calendar getPreventDocDate() {
        return preventDocDate;
    }


    /**
     * Set the preventDocDate
     *
     * @param preventDocDate the preventDocDate to set
     */
    public void setPreventDocDate(Calendar preventDocDate) {
        this.preventDocDate = preventDocDate;
    }


    /**
     * Get the preventDocReceiveDate
     *
     * @return the preventDocReceiveDate
     */
    public Calendar getPreventDocReceiveDate() {
        return preventDocReceiveDate;
    }


    /**
     * Set the preventDocReceiveDate
     *
     * @param preventDocReceiveDate the preventDocReceiveDate to set
     */
    public void setPreventDocReceiveDate(Calendar preventDocReceiveDate) {
        this.preventDocReceiveDate = preventDocReceiveDate;
    }


    /**
     * Get the preventInputDate
     *
     * @return the preventInputDate
     */
    public Calendar getPreventInputDate() {
        return preventInputDate;
    }


    /**
     * Set the preventInputDate
     *
     * @param preventInputDate the preventInputDate to set
     */
    public void setPreventInputDate(Calendar preventInputDate) {
        this.preventInputDate = preventInputDate;
    }


    /**
     * Get the releaseDocDate
     *
     * @return the releaseDocDate
     */
    public Calendar getReleaseDocDate() {
        return releaseDocDate;
    }


    /**
     * Set the releaseDocDate
     *
     * @param releaseDocDate the releaseDocDate to set
     */
    public void setReleaseDocDate(Calendar releaseDocDate) {
        this.releaseDocDate = releaseDocDate;
    }


    /**
     * Get the releaseDocReceiveDate
     *
     * @return the releaseDocReceiveDate
     */
    public Calendar getReleaseDocReceiveDate() {
        return releaseDocReceiveDate;
    }


    /**
     * Set the releaseDocReceiveDate
     *
     * @param releaseDocReceiveDate the releaseDocReceiveDate to set
     */
    public void setReleaseDocReceiveDate(Calendar releaseDocReceiveDate) {
        this.releaseDocReceiveDate = releaseDocReceiveDate;
    }


    /**
     * Get the releaseInputDate
     *
     * @return the releaseInputDate
     */
    public Calendar getReleaseInputDate() {
        return releaseInputDate;
    }


    /**
     * Set the releaseInputDate
     *
     * @param releaseInputDate the releaseInputDate to set
     */
    public void setReleaseInputDate(Calendar releaseInputDate) {
        this.releaseInputDate = releaseInputDate;
    }


    /**
     * Get the landIssueDate
     *
     * @return the landIssueDate
     */
    public Calendar getLandIssueDate() {
        return landIssueDate;
    }


    /**
     * Set the landIssueDate
     *
     * @param landIssueDate the landIssueDate to set
     */
    public void setLandIssueDate(Calendar landIssueDate) {
        this.landIssueDate = landIssueDate;
    }


    /**
     * Get the carIssueDate
     *
     * @return the carIssueDate
     */
    public Calendar getCarIssueDate() {
        return carIssueDate;
    }


    /**
     * Set the carIssueDate
     *
     * @param carIssueDate the carIssueDate to set
     */
    public void setCarIssueDate(Calendar carIssueDate) {
        this.carIssueDate = carIssueDate;
    }       

}
