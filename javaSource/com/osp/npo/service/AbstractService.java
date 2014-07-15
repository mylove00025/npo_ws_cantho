package com.osp.npo.service;

import java.sql.Connection;


/**
 * <P>
 * Base Service Class
 * </P>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17045 $
 */
abstract public class AbstractService {


    /** Connection */
    private Connection connection;


    /**
     * <P>
     * Create Instance
     * </P>
     * 
     */
    public AbstractService() {
    }


    /**
     * <P>
     * Create Instance
     * </P>
     * 
     * @param connection
     *            Connection
     */
    public AbstractService(Connection connection) {

        this.setConnection(connection);
    }


    /**
     * Set connection
     * @param connection
     */
    public void setConnection(Connection connection) {

        this.connection = connection;
    }


    /**
     * Get connection
     * @return connection
     */
    public Connection getConnection() {

        return this.connection;
    }
}
