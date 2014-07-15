package com.osp.npo.ws;

/**
 * 
 * @author HaiNT
 *
 */
public class DiagnosticWsInfo {
	/** Command code */
    private String commandCode;

    /** Result by number */
    private Long numberResult;

    /** Result by string */
    private String stringResult;

	/**
	 * Get commandCode
	 * @return the commandCode
	 */
	public String getCommandCode() {
		return commandCode;
	}

	/**
	 * Set commandCode
	 * @param commandCode the commandCode to set
	 */
	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	/**
	 * Get numberResult
	 * @return the numberResult
	 */
	public Long getNumberResult() {
		return numberResult;
	}

	/**
	 * Set numberResult
	 * @param numberResult the numberResult to set
	 */
	public void setNumberResult(Long numberResult) {
		this.numberResult = numberResult;
	}

	/**
	 * Get stringResult
	 * @return the stringResult
	 */
	public String getStringResult() {
		return stringResult;
	}

	/**
	 * Set stringResult
	 * @param stringResult the stringResult to set
	 */
	public void setStringResult(String stringResult) {
		this.stringResult = stringResult;
	}
    
}
