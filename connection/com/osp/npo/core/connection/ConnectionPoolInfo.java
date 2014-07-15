package com.osp.npo.core.connection;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/14/2011 9:26:39 AM
 * @version $Revision$ 
 */
public class ConnectionPoolInfo extends AbstractInfo {


    /** Ma van phong */
    private String authenticationId;

    /** Status:
 */
    private Byte status;

    /** Count of waiting */
    private Long waitingCount;

    /** Priority:
 */
    private Byte priority;

    /** Last update time */
    private Timestamp updateDateTime;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public ConnectionPoolInfo() {
        super();
    }


    /**
     * <P>Get Ma van phong </P>
     *
     * @return Ma van phong
     */
    public String getAuthenticationId() {
        return this.authenticationId;
    }

    /**
     * <P>Set Ma van phong. </P>
     *
     * @param authenticationId Ma van phong
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * <P>Get Status:
 </P>
     *
     * @return Status:

     */
    public Byte getStatus() {
        return this.status;
    }

    /**
     * <P>Set Status:
. </P>
     *
     * @param status Status:

     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * <P>Get Count of waiting </P>
     *
     * @return Count of waiting
     */
    public Long getWaitingCount() {
        return this.waitingCount;
    }

    /**
     * <P>Set Count of waiting. </P>
     *
     * @param waitingCount Count of waiting
     */
    public void setWaitingCount(Long waitingCount) {
        this.waitingCount = waitingCount;
    }

    /**
     * <P>Get Priority:
 </P>
     *
     * @return Priority:

     */
    public Byte getPriority() {
        return this.priority;
    }

    /**
     * <P>Set Priority:
. </P>
     *
     * @param priority Priority:

     */
    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    /**
     * <P>Get Last update time </P>
     *
     * @return Last update time
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Last update time. </P>
     *
     * @param updateDateTime Last update time
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
