package com.osp.npo.common.util;

import java.io.IOException;
import java.util.Properties;


/**
 * SystemProperties
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17051 $
 */
public class SystemProperties {

    private static final Properties SYSTEM_PROPERTIES = new Properties();

    static {

        ClassLoader loader = SystemProperties.class.getClassLoader();
        try {
            SYSTEM_PROPERTIES.load(loader.getResourceAsStream("resources/system.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * getProperty
     * 
     * @param key
     * @return value
     */
    public static String getProperty(String key) {

        String ret = key;
        if (SYSTEM_PROPERTIES.containsKey(key)) {
            ret = SYSTEM_PROPERTIES.getProperty(key);
        }

        return ret;
    }

}