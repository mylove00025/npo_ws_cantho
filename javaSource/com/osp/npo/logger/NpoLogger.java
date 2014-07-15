package com.osp.npo.logger;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * <p>
 * NpoLogger
 * </p>
 * 
 * @author Haint
 * @version $Revision: 17045 $
 */
public class NpoLogger extends Logger {


    /* NpoLogger*/
    public static final String FQCN = NpoLogger.class.getName() + ".";


    /* NpoLoggerFactory */
    private static NpoLoggerFactory myFactory = new NpoLoggerFactory();


    
    protected NpoLogger(String name) {
        super(name);

    }


    
    public static Category getInstance(String name) {
        return Logger.getLogger(name, myFactory);
    }


    
    public static Logger getLogger(String name) {
        return Logger.getLogger(name, myFactory);
    }


    public void logging(NpoLogMessage msg, Throwable e) {
        String level = msg.getLevel();
        if (level.equalsIgnoreCase("INFO")) {
            super.log(FQCN, Level.INFO, msg.getMessage(), e);
            // this.info(msg.getMessage());
        } else if (level.equalsIgnoreCase("ERROR")) {
            super.log(FQCN, Level.ERROR, msg.getMessage(), e);
            // this.error(msg.getMessage());
        } else {
            super.log(FQCN, Level.WARN, msg.getMessage(), e);
            // this.warn(msg.getMessage());
        }
    }


    
    public void logging(NpoLogMessage msg) {
        String level = msg.getLevel();

        if (level.equalsIgnoreCase("INFO")) {

            super.log(FQCN, Level.INFO, msg.getMessage(), null);
            // info(msg.getMessage());
        } else if (level.equalsIgnoreCase("ERROR")) {
            super.log(FQCN, Level.ERROR, msg.getMessage(), null);
            // error(msg.getMessage());
        } else {
            super.log(FQCN, Level.WARN, msg.getMessage(), null);
            // warn(msg.getMessage());
        }
    }


    
    public void logging(String message) {
        this.logging(message, null);
    }


    
    public void logging(String message, Throwable t) {
        if (message != null) {
            this.debug(message);
        }
        if (t != null) {
            this.debug(t);
        }
    }

}
