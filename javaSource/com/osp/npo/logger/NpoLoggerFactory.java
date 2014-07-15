package com.osp.npo.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;


/**
 * <p>
 * NpoLoggerFactory
 * </p>
 * 
 * @author Haint
 * @version $Revision: 17045 $
 */
public class NpoLoggerFactory implements LoggerFactory {


    public Logger makeNewLoggerInstance(String name) {
        return new NpoLogger(name);
    }
}
