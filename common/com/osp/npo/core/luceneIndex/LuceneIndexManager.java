package com.osp.npo.core.luceneIndex;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.osp.npo.core.AbstractWsManager;


/**
 * Generate by script
 * Generate date: 06/07/2011 5:56:04 PM
 * @version $Revision$ 
 */
public class LuceneIndexManager extends AbstractWsManager {

	private Byte typeFilter;
	
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public LuceneIndexManager(Connection connection) {
        super(connection);
    }

    

    /**
	 * Set typeFilter
	 * @param typeFilter the typeFilter to set
	 */
	public void setTypeFilter(Byte typeFilter) {
		this.typeFilter = typeFilter;
	}



	/**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(LuceneIndexInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_lucene_index");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
        sqlBuffer.append("data_id,");
        sqlBuffer.append("action,");
        sqlBuffer.append("status,");
        sqlBuffer.append("entry_date_time");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?");
        sqlBuffer.append(" ) ");
        setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result = -1;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(getSql());

            int i = 1;
            psSetByte(ps, i++, info.getType());
            psSetLong(ps, i++, info.getDataId());
            psSetByte(ps, i++, info.getAction());
            psSetByte(ps, i++, info.getStatus());
            psSetTimestamp(ps, i++, info.getEntryDateTime2());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Delete a record</P>
     * 
     * @param  id
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int delete(Byte type, Long dataId, Byte action) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_lucene_index ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" type = ? ");
        sqlBuffer.append(" AND data_id = ? ");
        sqlBuffer.append(" AND action = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetByte(ps, 1, type);
            psSetLong(ps, 2, dataId);
            psSetByte(ps, 3, action);

            result = ps.executeUpdate();

        } finally{
            close(ps);
        }

        return result;
    }


    /**
     * <P>Update infomation</P>
     * 
     * @param  info  Infomation that need update
     * @return  PreparedStatement#executeUpdate return's value
     * @throws SQLException
     * @throws IOException
     */
    public int update(LuceneIndexInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_lucene_index");
        sqlBuffer.append(" SET ");


        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" type = ? ");
        sqlBuffer.append(" AND data_id = ? ");
        sqlBuffer.append(" AND action = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }

            psSetByte(ps, 1, info.getType());
            psSetLong(ps, 2, info.getDataId());
            psSetByte(ps, 3, info.getAction());

            result = ps.executeUpdate();
        } finally {
            close(ps);
        }

        return result;
    }


    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public LuceneIndexList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_lucene_index nli" );
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append(" LIMIT ? ");
            sqlBuffer.append(" OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        LuceneIndexList list = null;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i ++, prmList.get(j));
            }
            if ((offset >= 0) && (limit >= 0)){
                psSetObject(ps, i ++, limit);
                psSetObject(ps, i ++, offset);
            }
            rs = ps.executeQuery();

            LuceneIndexInfo info = null;
            list = new LuceneIndexList();
            while(rs.next()) {
                info = new LuceneIndexInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }


    /**
     * <P>Get count record result. </P>
     * 
     * @return  Count of record that geted
     * @throws SQLException
     */
    public int countTotal() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_lucene_index nli");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);

        } finally {
            close(ps, rs);
        }

        return result;
    }


    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,LuceneIndexInfo info) throws SQLException {

        info.setType(rsGetByte(rs, "type"));
        info.setDataId(rsGetLong(rs, "data_id"));
        info.setAction(rsGetByte(rs, "action"));
        info.setStatus(rsGetByte(rs, "status"));
        info.setEntryDateTime2(rsGetTimestamp(rs, "entry_date_time"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(LuceneIndexInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getDataId(), ",data_id=?", sqlList, prmList);
        addUpdateList(info.getAction(), ",action=?", sqlList, prmList);
        addUpdateList(info.getStatus(), ",status=?", sqlList, prmList);
        addUpdateList(info.getEntryDateTime2(), ",entry_date_time=?", sqlList, prmList);
    }


    /**
     * <P>Base SQL</P>
     * 
     * @param  prmList  ArrayList
     * @throws SQLException
     */
    private StringBuffer getBaseSQL(ArrayList<Object> prmList) throws SQLException {
        StringBuffer sqlBuffer = new StringBuffer();
        String whereString = getWhereFilter(prmList);
        if(whereString.length() > 0) {
            sqlBuffer.append(" WHERE true ");
            sqlBuffer.append(whereString);
        }
        return sqlBuffer;
    }


    /**
     * <P>>Get where sql statement part.</P>
     * 
     * @param  prmList  ArrayList
     * @return where sql statement
     * @throws SQLException
     */
    private String getWhereFilter(ArrayList<Object> prmList) {
        StringBuffer filterBuffer = new StringBuffer();
        if (this.typeFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("nli.type = ?");
            prmList.add(this.typeFilter);
        }
        return filterBuffer.toString();
    }
}
