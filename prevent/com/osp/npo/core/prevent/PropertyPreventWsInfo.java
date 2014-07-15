package com.osp.npo.core.prevent;


import com.osp.npo.core.AbstractWsInfo;
import java.util.Calendar;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 20276 $
 */
public class PropertyPreventWsInfo extends AbstractWsInfo {

    /** id tài s?n b? ch?n */
    private Long id;

    /** Loai tài s?n ch?n:  */
    private String type;

    /** Thong tin tai san */
    private String propertyInfo;

    /** Thong tin chu so huu */
    private String ownerInfo;

    /** Thông tin khác */
    private String otherInfo;

    /** Nhà d?t - S? gi?y ch?ng nh?n */
    private String landCertificate;

    /** Nhà d?t - Noi c?p GCN */
    private String landIssuePlace;

    /** Nhà d?t - Ngày c?p GCN */
    private Calendar landIssueDate;

    /** Nhà d?t -S? t? b?n d? */
    private String landMapNumber;

    /** Nhà d?t -S? th?a d?t */
    private String landNumber;

    /** Nhà d?t -Ð?a ch? th?a d?t */
    private String landAddress;

    /** Nhà d?t - Di?n tích */
    private String landArea;

    /** Nhà d?t - Di?n tích s? d?ng chung */
    private String landPublicArea;

    /** Nhà d?t - Di?n tích s? d?ng riêng */
    private String landPrivateArea;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePurpose;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUsePeriod;

    /** Nhà d?t - M?c dích s? d?ng */
    private String landUseOrigin;

    /** Nhà d?t - Ð?a bàn T?nh/Thành */
    private String landDistrict;
    
    /** Nhà d?t - Ð?a bàn T?nh/Thành */
    private String landStreet;

    /** Nhà d?t - Ð?a bàn Qu?n/Huy?n  */
    private Long landProvince;

    /** Tai san gan lien voi dat */
    private String landAssociateProperty;

    /** Ô tô, Motor - Bi?n ki?m soát */
    private String carLicenseNumber;

    /** Ô tô, Motor - S? dang ký */
    private String carRegistNumber;

    /** Ô tô, Motor - Noi c?p GCN */
    private String carIssuePlace;

    /** Ô tô, Motor  - Ngày c?p GCN */
    private Calendar carIssueDate;

    /** Ô tô, Motor - S? khung  */
    private String carFrameNumber;

    /** Ô tô, Motor - S? máy */
    private String carMachineNumber;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public PropertyPreventWsInfo() {
        super();
    }


    /**
     * <P>Get id tài s?n b? ch?n </P>
     *
     * @return id tài s?n b? ch?n
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id tài s?n b? ch?n. </P>
     *
     * @param id id tài s?n b? ch?n
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Loai tài s?n ch?n:
 </P>
     *
     * @return Loai tài s?n ch?n:

     */
    public String getType() {
        return this.type;
    }

    /**
     * <P>Set Loai tài s?n ch?n:
. </P>
     *
     * @param type Loai tài s?n ch?n:

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <P>Get Thong tin tai san </P>
     *
     * @return Thong tin tai san
     */
    public String getPropertyInfo() {
        return this.propertyInfo;
    }

    /**
     * <P>Set Thong tin tai san. </P>
     *
     * @param propertyInfo Thong tin tai san
     */
    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    /**
     * <P>Get Thong tin chu so huu </P>
     *
     * @return Thong tin chu so huu
     */
    public String getOwnerInfo() {
        return this.ownerInfo;
    }

    /**
     * <P>Set Thong tin chu so huu. </P>
     *
     * @param ownerInfo Thong tin chu so huu
     */
    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    /**
     * <P>Get Thông tin khác </P>
     *
     * @return Thông tin khác
     */
    public String getOtherInfo() {
        return this.otherInfo;
    }

    /**
     * <P>Set Thông tin khác. </P>
     *
     * @param otherInfo Thông tin khác
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    /**
     * <P>Get Nhà d?t - S? gi?y ch?ng nh?n </P>
     *
     * @return Nhà d?t - S? gi?y ch?ng nh?n
     */
    public String getLandCertificate() {
        return this.landCertificate;
    }

    /**
     * <P>Set Nhà d?t - S? gi?y ch?ng nh?n. </P>
     *
     * @param landCertificate Nhà d?t - S? gi?y ch?ng nh?n
     */
    public void setLandCertificate(String landCertificate) {
        this.landCertificate = landCertificate;
    }

    /**
     * <P>Get Nhà d?t - Noi c?p GCN </P>
     *
     * @return Nhà d?t - Noi c?p GCN
     */
    public String getLandIssuePlace() {
        return this.landIssuePlace;
    }

    /**
     * <P>Set Nhà d?t - Noi c?p GCN. </P>
     *
     * @param landIssuePlace Nhà d?t - Noi c?p GCN
     */
    public void setLandIssuePlace(String landIssuePlace) {
        this.landIssuePlace = landIssuePlace;
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
     * <P>Get Nhà d?t -S? t? b?n d? </P>
     *
     * @return Nhà d?t -S? t? b?n d?
     */
    public String getLandMapNumber() {
        return this.landMapNumber;
    }

    /**
     * <P>Set Nhà d?t -S? t? b?n d?. </P>
     *
     * @param landMapNumber Nhà d?t -S? t? b?n d?
     */
    public void setLandMapNumber(String landMapNumber) {
        this.landMapNumber = landMapNumber;
    }

    /**
     * <P>Get Nhà d?t -S? th?a d?t </P>
     *
     * @return Nhà d?t -S? th?a d?t
     */
    public String getLandNumber() {
        return this.landNumber;
    }

    /**
     * <P>Set Nhà d?t -S? th?a d?t. </P>
     *
     * @param landNumber Nhà d?t -S? th?a d?t
     */
    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    /**
     * <P>Get Nhà d?t -Ð?a ch? th?a d?t </P>
     *
     * @return Nhà d?t -Ð?a ch? th?a d?t
     */
    public String getLandAddress() {
        return this.landAddress;
    }

    /**
     * <P>Set Nhà d?t -Ð?a ch? th?a d?t. </P>
     *
     * @param landAddress Nhà d?t -Ð?a ch? th?a d?t
     */
    public void setLandAddress(String landAddress) {
        this.landAddress = landAddress;
    }

    /**
     * <P>Get Nhà d?t - Di?n tích </P>
     *
     * @return Nhà d?t - Di?n tích
     */
    public String getLandArea() {
        return this.landArea;
    }

    /**
     * <P>Set Nhà d?t - Di?n tích. </P>
     *
     * @param landArea Nhà d?t - Di?n tích
     */
    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    /**
     * <P>Get Nhà d?t - Di?n tích s? d?ng chung </P>
     *
     * @return Nhà d?t - Di?n tích s? d?ng chung
     */
    public String getLandPublicArea() {
        return this.landPublicArea;
    }

    /**
     * <P>Set Nhà d?t - Di?n tích s? d?ng chung. </P>
     *
     * @param landPublicArea Nhà d?t - Di?n tích s? d?ng chung
     */
    public void setLandPublicArea(String landPublicArea) {
        this.landPublicArea = landPublicArea;
    }

    /**
     * <P>Get Nhà d?t - Di?n tích s? d?ng riêng </P>
     *
     * @return Nhà d?t - Di?n tích s? d?ng riêng
     */
    public String getLandPrivateArea() {
        return this.landPrivateArea;
    }

    /**
     * <P>Set Nhà d?t - Di?n tích s? d?ng riêng. </P>
     *
     * @param landPrivateArea Nhà d?t - Di?n tích s? d?ng riêng
     */
    public void setLandPrivateArea(String landPrivateArea) {
        this.landPrivateArea = landPrivateArea;
    }

    /**
     * <P>Get Nhà d?t - M?c dích s? d?ng </P>
     *
     * @return Nhà d?t - M?c dích s? d?ng
     */
    public String getLandUsePurpose() {
        return this.landUsePurpose;
    }

    /**
     * <P>Set Nhà d?t - M?c dích s? d?ng. </P>
     *
     * @param landUsePurpose Nhà d?t - M?c dích s? d?ng
     */
    public void setLandUsePurpose(String landUsePurpose) {
        this.landUsePurpose = landUsePurpose;
    }

    /**
     * <P>Get Nhà d?t - M?c dích s? d?ng </P>
     *
     * @return Nhà d?t - M?c dích s? d?ng
     */
    public String getLandUsePeriod() {
        return this.landUsePeriod;
    }

    /**
     * <P>Set Nhà d?t - M?c dích s? d?ng. </P>
     *
     * @param landUsePeriod Nhà d?t - M?c dích s? d?ng
     */
    public void setLandUsePeriod(String landUsePeriod) {
        this.landUsePeriod = landUsePeriod;
    }

    /**
     * <P>Get Nhà d?t - M?c dích s? d?ng </P>
     *
     * @return Nhà d?t - M?c dích s? d?ng
     */
    public String getLandUseOrigin() {
        return this.landUseOrigin;
    }

    /**
     * <P>Set Nhà d?t - M?c dích s? d?ng. </P>
     *
     * @param landUseOrigin Nhà d?t - M?c dích s? d?ng
     */
    public void setLandUseOrigin(String landUseOrigin) {
        this.landUseOrigin = landUseOrigin;
    }

    /**
     * <P>Get Nhà d?t - Ð?a bàn T?nh/Thành </P>
     *
     * @return Nhà d?t - Ð?a bàn T?nh/Thành
     */
    public String getLandDistrict() {
        return this.landDistrict;
    }

    /**
     * <P>Set Nhà d?t - Ð?a bàn T?nh/Thành. </P>
     *
     * @param landDistrict Nhà d?t - Ð?a bàn T?nh/Thành
     */
    public void setLandDistrict(String landDistrict) {
        this.landDistrict = landDistrict;
    }

    public String getLandStreet() {
		return landStreet;
	}


	public void setLandStreet(String landStreet) {
		this.landStreet = landStreet;
	}


	/**
     * <P>Get Nhà d?t - Ð?a bàn Qu?n/Huy?n  </P>
     *
     * @return Nhà d?t - Ð?a bàn Qu?n/Huy?n
     */
    public Long getLandProvince() {
        return this.landProvince;
    }

    /**
     * <P>Set Nhà d?t - Ð?a bàn Qu?n/Huy?n . </P>
     *
     * @param landProvince Nhà d?t - Ð?a bàn Qu?n/Huy?n
     */
    public void setLandProvince(Long landProvince) {
        this.landProvince = landProvince;
    }

    /**
     * <P>Get tai san gan lien voi dat. </P>
     *
     * @return the landAssociateProperty
     */
    public String getLandAssociateProperty() {
        return landAssociateProperty;
    }


    /**
     * <P>Set tai san gan lien voi dat. </P>
     *
     * @param landAssociateProperty the landAssociateProperty to set
     */
    public void setLandAssociateProperty(String landAssociateProperty) {
        this.landAssociateProperty = landAssociateProperty;
    }


    /**
     * <P>Get Ô tô, Motor - Bi?n ki?m soát </P>
     *
     * @return Ô tô, Motor - Bi?n ki?m soát
     */
    public String getCarLicenseNumber() {
        return this.carLicenseNumber;
    }

    /**
     * <P>Set Ô tô, Motor - Bi?n ki?m soát. </P>
     *
     * @param carLicenseNumber Ô tô, Motor - Bi?n ki?m soát
     */
    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    /**
     * <P>Get Ô tô, Motor - S? dang ký </P>
     *
     * @return Ô tô, Motor - S? dang ký
     */
    public String getCarRegistNumber() {
        return this.carRegistNumber;
    }

    /**
     * <P>Set Ô tô, Motor - S? dang ký. </P>
     *
     * @param carRegistNumber Ô tô, Motor - S? dang ký
     */
    public void setCarRegistNumber(String carRegistNumber) {
        this.carRegistNumber = carRegistNumber;
    }

    /**
     * <P>Get Ô tô, Motor - Noi c?p GCN </P>
     *
     * @return Ô tô, Motor - Noi c?p GCN
     */
    public String getCarIssuePlace() {
        return this.carIssuePlace;
    }

    /**
     * <P>Set Ô tô, Motor - Noi c?p GCN. </P>
     *
     * @param carIssuePlace Ô tô, Motor - Noi c?p GCN
     */
    public void setCarIssuePlace(String carIssuePlace) {
        this.carIssuePlace = carIssuePlace;
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


    /**
     * <P>Get Ô tô, Motor - S? khung  </P>
     *
     * @return Ô tô, Motor - S? khung
     */
    public String getCarFrameNumber() {
        return this.carFrameNumber;
    }

    /**
     * <P>Set Ô tô, Motor - S? khung . </P>
     *
     * @param carFrameNumber Ô tô, Motor - S? khung
     */
    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    /**
     * <P>Get Ô tô, Motor - S? máy </P>
     *
     * @return Ô tô, Motor - S? máy
     */
    public String getCarMachineNumber() {
        return this.carMachineNumber;
    }

    /**
     * <P>Set Ô tô, Motor - S? máy. </P>
     *
     * @param carMachineNumber Ô tô, Motor - S? máy
     */
    public void setCarMachineNumber(String carMachineNumber) {
        this.carMachineNumber = carMachineNumber;
    }
    
}
