package com.osp.npo.ws;

import com.osp.npo.core.announcement.AnnouncementWsInfo;
import com.osp.npo.core.prevent.DataPreventHistoryWsInfo;
import com.osp.npo.core.prevent.DataPreventWsInfo;
import com.osp.npo.core.prevent.PropertyPreventWsInfo;
import com.osp.npo.core.prevent.TransactionPropertyWsInfo;
import com.osp.npo.core.synchronize.SynchronizeWsInfo;

/**
 * 
 * @author Administrator
 *
 */
public class ContentInfo {

    private SynchronizeWsInfo synchronizeWsInfo;
    
    private PropertyPreventWsInfo propertyPreventWsInfo;
    
    private DataPreventWsInfo dataPreventWsInfo;
    
    private TransactionPropertyWsInfo transactionPropertyWsInfo;
    
    private AnnouncementWsInfo announcementWsInfo;
    
    private DataPreventHistoryWsInfo dataPreventHistoryWsInfo;
    
    //prevent file or announcement attachment file
    private byte[] fileAttachment;
    
    //release prevent file
    private byte[] releaseFile;
    

    /**
     * Get the synchronizeWsInfo
     *
     * @return the synchronizeWsInfo
     */
    public SynchronizeWsInfo getSynchronizeWsInfo() {
        return synchronizeWsInfo;
    }

    /**
     * Set the synchronizeWsInfo
     *
     * @param synchronizeWsInfo the synchronizeWsInfo to set
     */
    public void setSynchronizeWsInfo(SynchronizeWsInfo synchronizeWsInfo) {
        this.synchronizeWsInfo = synchronizeWsInfo;
    }

    /**
     * Get the propertyPreventWsInfo
     *
     * @return the propertyPreventWsInfo
     */
    public PropertyPreventWsInfo getPropertyPreventWsInfo() {
        return propertyPreventWsInfo;
    }

    /**
     * Set the propertyPreventWsInfo
     *
     * @param propertyPreventWsInfo the propertyPreventWsInfo to set
     */
    public void setPropertyPreventWsInfo(PropertyPreventWsInfo propertyPreventWsInfo) {
        this.propertyPreventWsInfo = propertyPreventWsInfo;
    }

    /**
     * Get the dataPreventWsInfo
     *
     * @return the dataPreventWsInfo
     */
    public DataPreventWsInfo getDataPreventWsInfo() {
        return dataPreventWsInfo;
    }

    /**
     * Set the dataPreventWsInfo
     *
     * @param dataPreventWsInfo the dataPreventWsInfo to set
     */
    public void setDataPreventWsInfo(DataPreventWsInfo dataPreventWsInfo) {
        this.dataPreventWsInfo = dataPreventWsInfo;
    }

    /**
     * Get the transactionPropertyWsInfo
     *
     * @return the transactionPropertyWsInfo
     */
    public TransactionPropertyWsInfo getTransactionPropertyWsInfo() {
        return transactionPropertyWsInfo;
    }

    /**
     * Set the transactionPropertyWsInfo
     *
     * @param transactionPropertyWsInfo the transactionPropertyWsInfo to set
     */
    public void setTransactionPropertyWsInfo(TransactionPropertyWsInfo transactionPropertyWsInfo) {
        this.transactionPropertyWsInfo = transactionPropertyWsInfo;
    }

    /**
     * Get the announcementWsInfo
     *
     * @return the announcementWsInfo
     */
    public AnnouncementWsInfo getAnnouncementWsInfo() {
        return announcementWsInfo;
    }

    /**
     * Set the announcementWsInfo
     *
     * @param announcementWsInfo the announcementWsInfo to set
     */
    public void setAnnouncementWsInfo(AnnouncementWsInfo announcementWsInfo) {
        this.announcementWsInfo = announcementWsInfo;
    }

    /**
     * Get the fileAttachment
     *
     * @return the fileAttachment
     */
    public byte[] getFileAttachment() {
        return fileAttachment;
    }

    /**
     * Set the fileAttachment
     *
     * @param fileAttachment the fileAttachment to set
     */
    public void setFileAttachment(byte[] fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    /**
     * Get the releaseFile
     *
     * @return the releaseFile
     */
    public byte[] getReleaseFile() {
        return releaseFile;
    }

    /**
     * Set the releaseFile
     *
     * @param releaseFile the releaseFile to set
     */
    public void setReleaseFile(byte[] releaseFile) {
        this.releaseFile = releaseFile;
    }

    /**
     * Get the dataPreventHistoryWsInfo
     *
     * @return the dataPreventHistoryWsInfo
     */
    public DataPreventHistoryWsInfo getDataPreventHistoryWsInfo() {
        return dataPreventHistoryWsInfo;
    }

    /**
     * Set the dataPreventHistoryWsInfo
     *
     * @param dataPreventHistoryWsInfo the dataPreventHistoryWsInfo to set
     */
    public void setDataPreventHistoryWsInfo(DataPreventHistoryWsInfo dataPreventHistoryWsInfo) {
        this.dataPreventHistoryWsInfo = dataPreventHistoryWsInfo;
    }
    
}
