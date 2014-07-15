package com.osp.npo.logger;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <p>
 * NpoLogMessage
 * </p>
 * 
 * @author Haint
 * @version $Revision: 17045 $
 */
public class NpoLogMessage {


    protected static String LOG_RESOURCES_PATH = "resources/LogMessage";


    private String path;


    private String msgId;


    private String message;


    private Long userId;


    private String sId;


    private Object[] values;


    public NpoLogMessage() {
        this.msgId = "WEB5999";
        this.message = "Message not found MsgId={0}";

    }


    public NpoLogMessage(HttpServletRequest request) {
        this.msgId = "WEB5999";
        this.message = "Message not found MsgId={0}";
        HttpSession session = request.getSession();
        this.sId = session.getId();
        this.path = request.getRequestURI();

    }


    
    public Object[] getValues() {
        return values;
    }


    
    public void setValues(Object[] values) {
        this.values = values;
    }


   
    public String getSId() {
        return sId;
    }


    
    public void setSId(String id) {
        sId = id;
    }


    
    public String getPath() {
        return path;
    }


    
    public void setPath(String path) {
        this.path = path;
    }


   
    public String getMsgId() {
        return msgId;
    }


    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public Long getUserId() {
        return userId;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getLevel() {
        String level = "";
        String msg = getMsgId();
        char index = msg.charAt(3);
        switch (index) {
        case '0':
            level = "INFO";
            break;
        case '5':
            level = "WARN";
            break;
        case '9':
            level = "ERROR";
            break;
        default:
            level = "WARN";
            break;
        }
        return level;
    }


    public void setMsg(String msgId) {
        String msg = "";
        try {
            ResourceBundle resource = ResourceBundle
                    .getBundle(LOG_RESOURCES_PATH);
            if (resource != null) {
                msg = resource.getString(msgId);
                if (msg == null || msg.equalsIgnoreCase("")) {
                    msg = getOriginalMessage();
                }
            } else {
                msg = getOriginalMessage();
            }
            setMessage(msg);
        } catch (MissingResourceException ex) {
            msg = getOriginalMessage();
            setMessage(msg);
            ex.printStackTrace();
        }
    }


    public void select(String s) {
        setMsg(s);
        setMsgId(s);
    }


    public void select(String s, Object[] values) {
        this.select(s);
        setValues(values);
    }


    public String getMessage() {
        Object[] object = getValues();
        String format = MessageFormat.format(this.message, object);
        String footer = "";

        if (getSId() == null || getSId().equalsIgnoreCase("")) {
            if (getPath() == null || getPath().equalsIgnoreCase("")) {
                footer = "(" + getUserId() + ")";
            } else {
                footer = getPath();
            }
        } else if (getUserId() == null) {
            footer = getPath() + "[" + getSId() + "]";
        } else {
            footer = "{0}[{1}({2,number})]";
            footer = MessageFormat.format(footer, getPath(), getSId(),
                    getUserId());
        }
        String msg = format + " " + footer;
        return msg;
    }


    public String getOriginalMessage() {
        return this.message;
    }
}
