package com.osp.npo.core.contractHistory;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.osp.npo.core.AbstractManager;


/**
 * Generate by script
 * Generate date: 6/12/2012 3:18:21 PM
 * @version $Revision$ 
 */
public class ContractHistoryManager extends AbstractManager {


    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public ContractHistoryManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(ContractHistoryInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_contract_history");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("tpid,");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("contract_number,");
        sqlBuffer.append("client_info,");
        sqlBuffer.append("office_id,");
        sqlBuffer.append("execute_date_time,");
        sqlBuffer.append("execute_person,");
        sqlBuffer.append("execute_content,");
        sqlBuffer.append("contract_content");
        sqlBuffer.append(" ) ");
        sqlBuffer.append(" VALUES ");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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
            psSetLong(ps, i++, info.getTpid());
            psSetString(ps, i++, info.getSynchronizeId());
            psSetString(ps, i++, info.getContractNumber());
            psSetString(ps, i++, info.getClientInfo());
            psSetLong(ps, i++, info.getOfficeId());
            psSetTimestamp(ps, i++, info.getExecuteDateTime());
            psSetString(ps, i++, info.getExecutePerson());
            psSetString(ps, i++, info.getExecuteContent());
            psSetString(ps, i++, info.getContractContent());

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setHid(new Long(generatedId));
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
    public int delete(Long id) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" DELETE FROM ");
        sqlBuffer.append(" npo_contract_history ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" id = ? ");

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try{
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            psSetLong(ps, 1, id);

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
    public int update(ContractHistoryInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_contract_history");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("hid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("hid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getHid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getHid());

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
    public ContractHistoryList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_contract_history" );
        sqlBuffer.append(getBaseSQL(prmList));
        appendOrderField(sqlBuffer);
        if ((offset >= 0) && (limit >= 0)){
            sqlBuffer.append("LIMIT ? ");
            sqlBuffer.append("OFFSET ? ");
        }
        if(forUpdate) {
            sqlBuffer.append(" FOR UPDATE ");
        }
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        ContractHistoryList list = null;
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

            ContractHistoryInfo info = null;
            list = new ContractHistoryList();
            while(rs.next()) {
                info = new ContractHistoryInfo();
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
        sqlBuffer.append("npo_contract_history");

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
    private void rsSetInfo(ResultSet rs,ContractHistoryInfo info) throws SQLException {

        info.setHid(rsGetLong(rs, "hid"));
        info.setTpid(rsGetLong(rs, "tpid"));
        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setClientInfo(rsGetString(rs, "client_info"));
        info.setOfficeId(rsGetLong(rs, "office_id"));
        info.setExecuteDateTime(rsGetTimestamp(rs, "execute_date_time"));
        info.setExecutePerson(rsGetString(rs, "execute_person"));
        info.setExecuteContent(rsGetString(rs, "execute_content"));
        info.setContractContent(rsGetString(rs, "contract_content"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(ContractHistoryInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getTpid(), ",tpid=?", sqlList, prmList);
        addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
        addUpdateList(info.getClientInfo(), ",client_info=?", sqlList, prmList);
        addUpdateList(info.getOfficeId(), ",office_id=?", sqlList, prmList);
        addUpdateList(info.getExecuteDateTime(), ",execute_date_time=?", sqlList, prmList);
        addUpdateList(info.getExecutePerson(), ",execute_person=?", sqlList, prmList);
        addUpdateList(info.getExecuteContent(), ",execute_content=?", sqlList, prmList);
        addUpdateList(info.getContractContent(), ",contract_content=?", sqlList, prmList);
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
        //if (this.cidFilter != null) {
        //    appendAnd(filterBuffer);
        //    filterBuffer.append("vog.cid = ?");
        //    prmList.add(this.cidFilter);
        //}
        return filterBuffer.toString();
    }
}
