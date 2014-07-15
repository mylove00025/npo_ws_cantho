package com.osp.npo.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

import javax.xml.parsers.SAXParserFactory;  
import javax.xml.parsers.SAXParser;  

/**
 * <P>Parse Xml</P>
 *
 * @author HungPT
 * @version $Revision$
 */
public class DBConnection extends DefaultHandler {
    
    private static final String RESOURCE = "Resource";
    private static final String DRIVER = "driverClassName";
    private static final String URL = "url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String CONFIG_FILE_PATH = "/home/npo/conf/db.xml";
    
    private Connection connection;
    
    private static String mDriver;
    
    private static String mUrl;
    
    private static String mUser;
    
    private static String mPassword;
    
    private static Boolean mAutoCommit = Boolean.FALSE;
    
    /** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
        .getLogger(NpoWS.class.getName());
    
    public Connection openConnection() {
        
        NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.setMsgId("WEB9001");
        logMessage.setMessage("WEB9001");
        
        // Use the default (non-validating) parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
        try {
            // Parse the input
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new DBConnection());
            InputSource inputSource = new InputSource(CONFIG_FILE_PATH);
            xmlReader.parse(inputSource);
            
            Class.forName(mDriver).newInstance();
            connection = DriverManager.getConnection(mUrl, mUser, mPassword);
            connection.setAutoCommit(mAutoCommit);
            
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
            /** Write log */
            logger.logging(logMessage, exception);

        } 
        
        return connection;
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if (RESOURCE.equals(qName)) {
            if (atts != null) {
                for (int i = 0; i < atts.getLength(); i++) {
                    if (DRIVER.equals(atts.getQName(i))) {
                        mDriver = atts.getValue(i);
                    } else if (URL.equals(atts.getQName(i))) {
                        mUrl = atts.getValue(i);
                    } else if (USER.equals(atts.getQName(i))) {
                        mUser = atts.getValue(i);
                    } else if (PASSWORD.equals(atts.getQName(i))) {
                        mPassword = atts.getValue(i);
                    }
                }
            }
        }
    }

}
