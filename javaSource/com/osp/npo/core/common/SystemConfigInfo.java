package com.osp.npo.core.common;


import com.osp.npo.core.AbstractWsInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 * @version $Revision: 17046 $
 */
public class SystemConfigInfo extends AbstractWsInfo {


    /** id t? tang */
    private Long id;

    /** Mã s?  */
    private String configKey;

    /** Giá tr? */
    private String configValue;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public SystemConfigInfo() {
        super();
    }


    /**
     * <P>Get id t? tang </P>
     *
     * @return id t? tang
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id t? tang. </P>
     *
     * @param id id t? tang
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the configKey
     *
     * @return the configKey
     */
    public String getConfigKey() {
        return configKey;
    }


    /**
     * Set the configKey
     *
     * @param configKey the configKey to set
     */
    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }


    /**
     * Get the configValue
     *
     * @return the configValue
     */
    public String getConfigValue() {
        return configValue;
    }


    /**
     * Set the configValue
     *
     * @param configValue the configValue to set
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
    
}
