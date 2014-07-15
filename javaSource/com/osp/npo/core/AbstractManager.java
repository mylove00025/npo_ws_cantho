package com.osp.npo.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


/**
 * <P>
 * Basic Manager Class
 * </P>
 * 
 * @author Nguyen Thanh Hai
 * @version $Revision: 17263 $
 */
abstract public class AbstractManager {


    /** DB connection */
    private Connection connection;


    /** SQL query */
    private String sql;
    
    
    /** Order field list */
    private List<OrderField> orderFieldList;


    /**
     * <P>
     * Default construction
     * </P>
     * 
     * @param connection
     *            Connection
     */
    public AbstractManager(Connection connection) {
        this.setConnection(connection);
    }


    /**
     * <P>
     * Set connection
     * </P>
     * 
     * @param connection
     *            DB connection
     */
    public void setConnection(Connection connection) {

        this.connection = connection;
    }


    /**
     * <P>
     * Get connection
     * </P>
     * 
     * @return DB connection
     */
    public Connection getConnection() {

        return this.connection;
    }


    /**
     * <P>
     * Set SQL query
     * </P>
     * 
     * @param sql
     *            SQL query
     */
    protected void setSql(String sql) {

        this.sql = sql;
    }


    /**
     * <P>
     * Get SQL query
     * </P>
     * 
     * @return SQL query
     */
    public String getSql() {

        return sql;
    }


    /**
     * <P>
     * 
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     * @throws IOException
     */
    protected void psSetObject(PreparedStatement ps, int parameterIndex,
            Object value) throws SQLException, IOException {

        if (value instanceof Integer) {
            psSetInt(ps, parameterIndex, (Integer) value);
        } else if (value instanceof Long) {
            psSetLong(ps, parameterIndex, (Long) value);
        } else if (value instanceof Timestamp) {
            psSetTimestamp(ps, parameterIndex, (Timestamp) value);
        } else if (value instanceof String) {
            psSetString(ps, parameterIndex, (String) value);
        } else if (value instanceof BlobInfo) {
            psSetBlobInfo(ps, parameterIndex, (BlobInfo) value);
        } else {
            ps.setObject(parameterIndex, value);
        }

    }


    /**
     * <P>
     * Set java.lang.Byte
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetByte(PreparedStatement ps, int parameterIndex,
            Byte value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.TINYINT);
        } else {
            ps.setInt(parameterIndex, value.byteValue());
        }
    }


    /**
     * <P>
     * Set java.lang.Integer
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetInt(PreparedStatement ps, int parameterIndex,
            Integer value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.INTEGER);
        } else {
            ps.setInt(parameterIndex, value.intValue());
        }
    }


    /**
     * <P>
     * Set java.lang.Long
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetLong(PreparedStatement ps, int parameterIndex,
            Long value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.BIGINT);
        } else {
            ps.setLong(parameterIndex, value.longValue());
        }
    }


    /**
     * <P>
     * Set java.lang.Double
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetDouble(PreparedStatement ps, int parameterIndex,
            Double value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.DOUBLE);
        } else {
            ps.setDouble(parameterIndex, value.doubleValue());
        }
    }


    /**
     * <P>
     * PreparedStatement, Set java.sql.Timestamp
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetTimestamp(PreparedStatement ps, int parameterIndex,
            Timestamp value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.TIMESTAMP);
        } else {
            ps.setTimestamp(parameterIndex, value);
        }
    }


    /**
     * <P>
     * Set java.lang.String
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetString(PreparedStatement ps, int parameterIndex,
            String value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.VARCHAR);
        } else {
            ps.setString(parameterIndex, value);
        }
    }


    /**
     * <P>
     * Set java.lang.Boolean
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetBoolean(PreparedStatement ps, int parameterIndex,
            Boolean value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.BOOLEAN);
        } else {
            ps.setBoolean(parameterIndex, value);
        }
    }


    /**
     * <P>
     * Set java.sql.Blob
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetBlob(PreparedStatement ps, int parameterIndex,
            Blob value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.BLOB);
        } else {
            ps.setBlob(parameterIndex, value);
        }
    }


    /**
     * <P>
     * java.sql.Blob 
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetBlob(PreparedStatement ps, int parameterIndex,
            BlobInfo value) throws SQLException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.BLOB);
        } else {
            psSetBlob(ps, parameterIndex, value.getBlob());
        }
    }


    /**
     * <P>
     * Set com.osp.npo.core.BlobInfo
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param parameterIndex
     *            Index of parameter
     * @param value
     *            Value
     */
    protected void psSetBlobInfo(PreparedStatement ps, int parameterIndex,
            BlobInfo value) throws SQLException, IOException {

        if (value == null) {
            ps.setNull(parameterIndex, Types.BLOB);
            return;
        }

        Blob b = value.getBlob();
        if (b != null) {
            ps.setBlob(parameterIndex, b);
            return;
        }

        if (value.getInputStream() == null) {
            ps.setNull(parameterIndex, Types.BLOB);
            return;
        }

        byte[] bytes = value.getBinary();
        if (bytes == null) {
            InputStream is = value.getInputStream();
            byte buf[] = new byte[256];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int n = -1;
            while ((n = is.read(buf, 0, buf.length)) != -1) {
                out.write(buf, 0, n);
            }
            bytes = out.toByteArray();
        }
        ps.setBytes(parameterIndex, bytes);
        return;
    }


    /**
     * <P>
     * Get java.lang.Byte
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Byte rsGetByte(ResultSet rs, String columnName)
            throws SQLException {

        byte value = rs.getByte(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Byte(value);
        }
    }


    /**
     * <P>
     * Get java.lang.Integer
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Integer rsGetInt(ResultSet rs, String columnName)
            throws SQLException {

        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Integer(value);
        }
    }


    /**
     * <P>
     * Get java.lang.Long
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Long rsGetLong(ResultSet rs, String columnName)
            throws SQLException {

        long value = rs.getLong(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Long(value);
        }
    }


    /**
     * <P>
     * Get java.lang.Double
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Double rsGetDouble(ResultSet rs, String columnName)
            throws SQLException {

        double value = rs.getDouble(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Double(value);
        }
    }


    /**
     * <P>
     * Get java.sql.Timestamp
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Timestamp rsGetTimestamp(ResultSet rs, String columnName)
            throws SQLException {

        return rs.getTimestamp(columnName);
    }


    /**
     * <P>
     * Get java.lang.String
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected String rsGetString(ResultSet rs, String columnName)
            throws SQLException {

        return rs.getString(columnName);
    }


    /**
     * <P>
     * Get java.lang.Boolean
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Boolean rsGetBoolean(ResultSet rs, String columnName)
            throws SQLException {

        return rs.getBoolean(columnName);
    }


    /**
     * <P>
     * Get java.sql.Blob
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected Blob rsGetBlob(ResultSet rs, String columnName)
            throws SQLException {

        return rs.getBlob(columnName);
    }


    /**
     * <P>
     * Get vips.tms.core.BlobInfo
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnName
     *            Column name
     */
    protected BlobInfo rsGetBlobInfo(ResultSet rs, String columnName)
            throws SQLException {

        return new BlobInfo(rsGetBlob(rs, columnName));
    }


    /**
     * <P>
     * Get java.lang.Integer
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected Integer rsGetInt(ResultSet rs, int columnIndex)
            throws SQLException {

        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Integer(value);
        }
    }


    /**
     * <P>
     * Get java.lang.Long
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected Long rsGetLong(ResultSet rs, int columnIndex) throws SQLException {

        long value = rs.getLong(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return new Long(value);
        }
    }


    /**
     * <P>
     * Get java.sql.Timestamp
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected Timestamp rsGetTimestamp(ResultSet rs, int columnIndex)
            throws SQLException {

        return rs.getTimestamp(columnIndex);
    }


    /**
     * <P>
     * Get java.lang.String
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected String rsGetString(ResultSet rs, int columnIndex)
            throws SQLException {

        return rs.getString(columnIndex);
    }


    /**
     * <P>
     * Get java.lang.Boolean
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected Boolean rsGetBoolean(ResultSet rs, int columnIndex)
            throws SQLException {

        return rs.getBoolean(columnIndex);
    }


    /**
     * <P>
     * Get java.sql.Blob
     * </P>
     * 
     * @param rs
     *            ResultSet
     * @param columnIndex
     *            Column Index
     */
    protected Blob rsGetBlob(ResultSet rs, int columnIndex) throws SQLException {

        return rs.getBlob(columnIndex);
    }


    /**
     * <P>
     * Build filter string
     * </P>
     * 
     * @param filterSource
     *            Filter source
     * @param kind
     *            Kind of filter
     * @return Filter string
     */
    protected String buildFilterString(String filterSource, int kind) {

        if (filterSource == null) {
            return null;
        }

        filterSource = escapeForLike(filterSource);

        switch (kind) {
        case 0:
            return filterSource;
        case 1:
            return filterSource + "%";
        case 2:
            return "%" + filterSource + "%";
        case 3:
            return filterSource + "____";
        default:
            return filterSource;
        }
    }


    /**
     * <p>
     * Escape for LIKE 
     * </p>
     * When build SQL query
     * 
     * @param strSearch
     *            Search string
     * @return Escaped String
     */
    private String escapeForLike(String strSearch) {
        if (strSearch == null || strSearch.equals("")) {
            return strSearch;
        } else {
            String temp = new String(strSearch);

            temp = temp.replaceAll("%", "\\\\%");
            temp = temp.replaceAll("_", "\\\\_");
            return temp;
        }
    }


    /**
     * <P>
     * Close PreparedStatement & ResultSet
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @param rs
     *            ResultSet
     * @throws SQLException
     */
    protected void close(PreparedStatement ps, ResultSet rs)
            throws SQLException {

        if (rs != null) {
            rs.close();
        }

        if (ps != null) {
            ps.close();
        }
    }


    /**
     * <P>
     * Close PreparedStatement
     * </P>
     * 
     * @param ps
     *            PreparedStatement
     * @throws SQLException
     */
    protected void close(PreparedStatement ps) throws SQLException {
        close(ps, null);
    }


    /**
     * 
     * @param obj
     *            
     * @param sqlStr
     *            
     * @param sqlList
     *            
     * @param prmList
     *            
     */
    protected void addUpdateList(Object obj, String sqlStr,
            ArrayList<String> sqlList, ArrayList<Object> prmList) {
        if (obj != null) {
            sqlList.add(sqlStr);
            prmList.add(obj);
        }

    }


    /**
     * 
     * @param obj
     *            
     * @param sqlStr
     *            
     * @param nullFlg
     *            
     * @param sqlList
     *            
     * @param prmList
     *            
     */
    protected void addUpdateList(Object obj, String sqlStr, boolean nullFlg,
            ArrayList<String> sqlList, ArrayList<Object> prmList) {
        if (nullFlg == true || obj != null) {
            sqlList.add(sqlStr);
            prmList.add(obj);
        }

    }


    /**
     * 
     * @param column
     * @param marker
     * @return 
     */
    protected String buildIn(String column, int marker) {

        StringBuffer inBuffer = new StringBuffer();

        inBuffer.append(column);
        inBuffer.append(" IN ");
        inBuffer.append("(");
        inBuffer.append("?");
        for (int i = 1; i < marker; i++) {
            inBuffer.append(",?");
        }
        inBuffer.append(")");

        return inBuffer.toString();
    }
    
    
    /**
     * @param column
     * @param marker
     * @return
     */
    protected String buildNotIn(String column, int marker) {

        StringBuffer inBuffer = new StringBuffer();

        inBuffer.append(column);
        inBuffer.append(" NOT IN ");
        inBuffer.append("(");
        inBuffer.append("?");
        for (int i = 1; i < marker; i++) {
            inBuffer.append(",?");
        }
        inBuffer.append(")");

        return inBuffer.toString();
    }


    /**
     * @param strBuffer
     *            
     */
    protected void appendAnd(StringBuffer strBuffer) {
        strBuffer.append(" AND ");
    }


    /**
     * 
     * @param strBuffer
     */
    protected void appendOr(StringBuffer strBuffer) {
        strBuffer.append(" OR ");
    }


	/**
	 * Get orderFieldList
	 * @return the orderFieldList
	 */
    public List<OrderField> getOrderFieldList() {
		return orderFieldList;
	}


	/**
	 * Set orderFieldList
	 * @param orderFieldList the orderFieldList to set
	 */
    public void setOrderFieldList(List<OrderField> orderFieldList) {
		this.orderFieldList = orderFieldList;
	}

    /**
     * Add order field
     * @param orderField
     */
    public void addOrderField(OrderField orderField) {
    	if (this.orderFieldList == null) {
    		this.orderFieldList = new ArrayList<OrderField>();
    	}
    	this.orderFieldList.add(orderField);
    }
    
    /**
     * Append order field
     * @param strBuffer SQL
     */
    protected void appendOrderField(StringBuffer strBuffer) {
    	if (orderFieldList == null || orderFieldList.isEmpty()) {
    		return;
    	}
    	
    	strBuffer.append(" ORDER BY ");
    	for (int i = 0; i < orderFieldList.size(); i++) {
    		OrderField orderField = orderFieldList.get(i);
    		strBuffer.append(orderField.getFieldName() + " " + orderField.getOrderType());
    		if (i < orderFieldList.size() - 1) {
    			strBuffer.append(", ");
    		}
		}
    }
    
    /**
     * Determine record is existed in database based on attributes
     *
     * @param entity
     * @param nameKeyAndValueKey
     * @return TRUE if its was existed
     */
    public Boolean isExistInDB(String entity, Object[][] nameKeyAndValueKey) throws SQLException, IOException {
        
        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append(" SELECT ");
        sqlBuilder.append(" COUNT(*) ");
        sqlBuilder.append("FROM ").append(entity);
        int length = nameKeyAndValueKey.length;

        if (nameKeyAndValueKey.length >= 1) {
            sqlBuilder.append(" WHERE ");
        }
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sqlBuilder.append(" AND ");
            }
            if (nameKeyAndValueKey[i][1] == null) {
                sqlBuilder.append(nameKeyAndValueKey[i][0].toString()).append(" IS NULL ");
            } else {
                sqlBuilder.append(nameKeyAndValueKey[i][0].toString()).append("=?");
                prmList.add(nameKeyAndValueKey[i][1]);
            }
        }

        this.setSql(sqlBuilder.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());
            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }  
        if (result <= 0) {
            return false;
        }
        return true;
    }
}
