package com.osp.npo.ws;

import java.util.List;

public class WebserviceInfo {

    private List<ContentInfo> contentInfoList;
    
    private List<String> dataIdList;
    
    private String authenticationId;
    
    private String authenticationCode;
    
    private String account;
    
    private String password;
    
    private byte[] tpAddNewFile;
    private byte[] tpUpdateFile;
    private byte[] tpFirstSynFile;
    
    //Diagnostic info from client
    private List<DiagnosticWsInfo> diagnosticInfoList;

    /**
     * Get the contentInfoList
     *
     * @return the contentInfoList
     */
    public List<ContentInfo> getContentInfoList() {
        return contentInfoList;
    }

    /**
     * Set the contentInfoList
     *
     * @param contentInfoList the contentInfoList to set
     */
    public void setContentInfoList(List<ContentInfo> contentInfoList) {
        this.contentInfoList = contentInfoList;
    }

    /**
     * Get the dataIdList
     *
     * @return the dataIdList
     */
    public List<String> getDataIdList() {
        return dataIdList;
    }

    /**
     * Set the dataIdList
     *
     * @param dataIdList the dataIdList to set
     */
    public void setDataIdList(List<String> dataIdList) {
        this.dataIdList = dataIdList;
    }

    /**
     * Get the authenticationId
     *
     * @return the authenticationId
     */
    public String getAuthenticationId() {
        return authenticationId;
    }

    /**
     * Set the authenticationId
     *
     * @param authenticationId the authenticationId to set
     */
    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    /**
     * Get the authenticationCode
     *
     * @return the authenticationCode
     */
    public String getAuthenticationCode() {
        return authenticationCode;
    }

    /**
     * Set the authenticationCode
     *
     * @param authenticationCode the authenticationCode to set
     */
    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    /**
     * Get the account
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Set the account
     *
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Get the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

	/**
	 * Get tpAddNewFile
	 * @return the tpAddNewFile
	 */
	public byte[] getTpAddNewFile() {
		return tpAddNewFile;
	}

	/**
	 * Set tpAddNewFile
	 * @param tpAddNewFile the tpAddNewFile to set
	 */
	public void setTpAddNewFile(byte[] tpAddNewFile) {
		this.tpAddNewFile = tpAddNewFile;
	}

	/**
	 * Get tpUpdateFile
	 * @return the tpUpdateFile
	 */
	public byte[] getTpUpdateFile() {
		return tpUpdateFile;
	}

	/**
	 * Set tpUpdateFile
	 * @param tpUpdateFile the tpUpdateFile to set
	 */
	public void setTpUpdateFile(byte[] tpUpdateFile) {
		this.tpUpdateFile = tpUpdateFile;
	}

	/**
	 * Get tpFirstSynFile
	 * @return the tpFirstSynFile
	 */
	public byte[] getTpFirstSynFile() {
		return tpFirstSynFile;
	}

	/**
	 * Set tpFirstSynFile
	 * @param tpFirstSynFile the tpFirstSynFile to set
	 */
	public void setTpFirstSynFile(byte[] tpFirstSynFile) {
		this.tpFirstSynFile = tpFirstSynFile;
	}

	/**
	 * Get diagnosticInfoList
	 * @return the diagnosticInfoList
	 */
	public List<DiagnosticWsInfo> getDiagnosticInfoList() {
		return diagnosticInfoList;
	}

	/**
	 * Set diagnosticInfoList
	 * @param diagnosticInfoList the diagnosticInfoList to set
	 */
	public void setDiagnosticInfoList(List<DiagnosticWsInfo> diagnosticInfoList) {
		this.diagnosticInfoList = diagnosticInfoList;
	}

}
