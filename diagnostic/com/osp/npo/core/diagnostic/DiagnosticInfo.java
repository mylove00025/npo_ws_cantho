package com.osp.npo.core.diagnostic;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:58 PM
 * @version $Revision$ 
 */
public class DiagnosticInfo extends AbstractInfo {


    /** Office code */
    private String officeCode;

    /** Command code */
    private String commandCode;

    /** Result by number */
    private Long numberResult;

    /** Result by string */
    private String stringResult;

    /** Last update time */
    private Timestamp updateDateTime;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public DiagnosticInfo() {
        super();
    }


    /**
     * <P>Get Office code </P>
     *
     * @return Office code
     */
    public String getOfficeCode() {
        return this.officeCode;
    }

    /**
     * <P>Set Office code. </P>
     *
     * @param officeCode Office code
     */
    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    /**
     * <P>Get Command code </P>
     *
     * @return Command code
     */
    public String getCommandCode() {
        return this.commandCode;
    }

    /**
     * <P>Set Command code. </P>
     *
     * @param commandCode Command code
     */
    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }

    /**
     * <P>Get Result by number </P>
     *
     * @return Result by number
     */
    public Long getNumberResult() {
        return this.numberResult;
    }

    /**
     * <P>Set Result by number. </P>
     *
     * @param numberResult Result by number
     */
    public void setNumberResult(Long numberResult) {
        this.numberResult = numberResult;
    }

    /**
     * <P>Get Result by string </P>
     *
     * @return Result by string
     */
    public String getStringResult() {
        return this.stringResult;
    }

    /**
     * <P>Set Result by string. </P>
     *
     * @param stringResult Result by string
     */
    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
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
