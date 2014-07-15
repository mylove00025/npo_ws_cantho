package com.osp.npo.core.prevent;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.osp.npo.core.AbstractWsManager;

/**
 * Generate by script
 * Generate date: 02/17/2011 10:15:26 AM
 */
public class TransactionPropertyWsManager extends AbstractWsManager {


    private String synchronizeIdFilter;
    
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public TransactionPropertyWsManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(TransactionPropertyWsInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_transaction_property");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("type,");
        sqlBuffer.append("property_info,");
        sqlBuffer.append("transaction_content,");
        sqlBuffer.append("notary_date,");
        sqlBuffer.append("notary_office_name,");
        sqlBuffer.append("contract_id, ");
        sqlBuffer.append("contract_number,");
        sqlBuffer.append("contract_name,");
        sqlBuffer.append("contract_value,");
        sqlBuffer.append("relation_object,");
        sqlBuffer.append("notary_person,");
        sqlBuffer.append("notary_place,");
        sqlBuffer.append("notary_fee,");
        sqlBuffer.append("note,");
        sqlBuffer.append("cancel_status,");
        sqlBuffer.append("cancel_description,");
        sqlBuffer.append("entry_user_id, ");
        sqlBuffer.append("entry_user_name, ");
        sqlBuffer.append("entry_date_time, ");
        sqlBuffer.append("update_user_id, ");
        sqlBuffer.append("update_user_name, ");
        sqlBuffer.append("update_date_time, ");
        sqlBuffer.append("contract_period, ");
        sqlBuffer.append("land_district, ");
        sqlBuffer.append("land_street, ");
        sqlBuffer.append("mortage_cancel_flag, ");
        sqlBuffer.append("mortage_cancel_date, ");
        sqlBuffer.append("mortage_cancel_note, ");
        sqlBuffer.append("contract_kind ");
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
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
        sqlBuffer.append("?,");
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
            psSetString(ps, i++, info.getSynchronizeId());
            psSetString(ps, i++, info.getType());
            psSetString(ps, i++, info.getPropertyInfo());
            psSetString(ps, i++, info.getTransactionContent());
            if (info.getNotaryDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getNotaryDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getNotaryOfficeName());
            psSetLong(ps, i++, info.getContractId());
            psSetString(ps, i++, info.getContractNumber());
            psSetString(ps, i++, info.getContractName());
            psSetString(ps, i++, info.getContractValue());
            psSetString(ps, i++, info.getRelationObject());
            psSetString(ps, i++, info.getNotaryPerson());
            psSetString(ps, i++, info.getNotaryPlace());
            psSetString(ps, i++, info.getNotaryFee());
            psSetString(ps, i++, info.getNote());
            psSetBoolean(ps, i++, info.getCancelStatus());
            psSetString(ps, i++, info.getCancelDescription());
            
            psSetLong(ps, i++, info.getEntryUserId());
            psSetString(ps, i++, info.getEntryUserName());
            if (info.getEntryDateTime() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getEntryDateTime().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetLong(ps, i++, info.getUpdateUserId());
            psSetString(ps, i++, info.getUpdateUserName());
            if (info.getUpdateDateTime() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getUpdateDateTime().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            
            psSetString(ps, i++, info.getContractPeriod());
            psSetString(ps, i++, info.getLandDistrict());
            psSetString(ps, i++, info.getLandStreet());
            psSetBoolean(ps, i++, info.getMortageCancelFlag());
            psSetString(ps, i++, info.getMortageCancelDate());
            psSetString(ps, i++, info.getMortageCancelNote());
            psSetString(ps, i++, info.getContractKind());

            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setTpid(new Long(generatedId));
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
        sqlBuffer.append(" npo_transaction_property ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" tpid = ? ");

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
    public int update(TransactionPropertyWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_transaction_property");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("tpid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("tpid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getTpid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getTpid());

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
    public TransactionPropertyWsList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntp.tpid ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
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
        TransactionPropertyWsList list = null;
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

            TransactionPropertyWsInfo info = null;
            list = new TransactionPropertyWsList();
            while(rs.next()) {
                info = new TransactionPropertyWsInfo();
                rsSetInfo(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }
    
    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public TransactionPropertyWsList selectWS(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntp.tpid, ");
        sqlBuffer.append(" ntp.synchronize_id, ");
        sqlBuffer.append(" ntp.type, ");
        sqlBuffer.append(" ntp.property_info, ");
        sqlBuffer.append(" ntp.transaction_content, ");
        sqlBuffer.append(" ntp.notary_date, ");
        sqlBuffer.append(" ntp.notary_office_name, ");
        sqlBuffer.append(" ntp.contract_number, ");
        sqlBuffer.append(" ntp.contract_name, ");
        sqlBuffer.append(" ntp.contract_value, ");
        sqlBuffer.append(" ntp.relation_object, ");
        sqlBuffer.append(" ntp.notary_person, ");
        sqlBuffer.append(" ntp.notary_place, ");
        sqlBuffer.append(" ntp.notary_fee, ");
        sqlBuffer.append(" ntp.note, ");
        sqlBuffer.append(" ntp.cancel_status, ");
        sqlBuffer.append(" ntp.cancel_description, ");
        sqlBuffer.append(" ntp.contract_period, ");
        sqlBuffer.append(" ntp.land_district, ");
        sqlBuffer.append(" ntp.land_street, ");
        sqlBuffer.append(" ntp.mortage_cancel_flag, ");
        sqlBuffer.append(" ntp.mortage_cancel_date, ");
        sqlBuffer.append(" ntp.mortage_cancel_note, ");
        sqlBuffer.append(" ntp.contract_kind ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
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
        TransactionPropertyWsList list = null;
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

            TransactionPropertyWsInfo info = null;
            list = new TransactionPropertyWsList();
            while(rs.next()) {
                info = new TransactionPropertyWsInfo();
                rsSetInfoWS(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    /**
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public List<String> selectFirstSynchonize(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" ntp.synchronize_id ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_transaction_property ntp ");
        
        sqlBuffer.append(getBaseSQL(prmList));
        
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
        List<String> list = null;
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

            list = new ArrayList<String>();
            while(rs.next()) {
                list.add(rsGetString(rs, "synchronize_id"));
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
        sqlBuffer.append("npo_transaction_property");

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
    private void rsSetInfo(ResultSet rs,TransactionPropertyWsInfo info) throws SQLException {

        info.setTpid(rsGetLong(rs, "tpid"));       
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoWS(ResultSet rs,TransactionPropertyWsInfo info) throws SQLException {
    	info.setTpid(rsGetLong(rs, "tpid"));
        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setType(rsGetString(rs, "type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setTransactionContent(rsGetString(rs, "transaction_content"));
        if (rsGetTimestamp(rs, "notary_date") != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(rsGetTimestamp(rs, "notary_date").getTime());
            info.setNotaryDate(cal1);
        } else {
            info.setNotaryDate(null);
        }
        info.setNotaryOfficeName(rsGetString(rs, "notary_office_name"));
        info.setContractNumber(rsGetString(rs, "contract_number"));
        info.setContractName(rsGetString(rs, "contract_name"));
        info.setContractValue(rsGetString(rs, "contract_value"));
        info.setRelationObject(rsGetString(rs, "relation_object"));
        info.setNotaryPerson(rsGetString(rs, "notary_person"));
        info.setNotaryPlace(rsGetString(rs, "notary_place"));
        info.setNotaryFee(rsGetString(rs, "notary_fee"));
        info.setNote(rsGetString(rs, "note"));
        info.setCancelStatus(rsGetBoolean(rs, "cancel_status"));
        info.setCancelDescription(rsGetString(rs, "cancel_description"));
        info.setContractPeriod(rsGetString(rs, "contract_period"));
        info.setLandDistrict(rsGetString(rs, "land_district"));
        info.setLandStreet(rsGetString(rs, "land_street"));
        info.setMortageCancelFlag(rsGetBoolean(rs, "mortage_cancel_flag"));
        info.setMortageCancelDate(rsGetString(rs, "mortage_cancel_date"));
        info.setMortageCancelNote(rsGetString(rs, "mortage_cancel_note"));
        info.setContractKind(rsGetString(rs, "contract_kind"));




    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(TransactionPropertyWsInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getPropertyInfo(), ",property_info=?", sqlList, prmList);
        addUpdateList(info.getTransactionContent(), ",transaction_content=?", sqlList, prmList);
        if (info.getNotaryDate() != null) {
            addUpdateList(new Timestamp(info.getNotaryDate().getTimeInMillis()), ",notary_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",notary_date=?", true, sqlList, prmList);
        }
        addUpdateList(info.getNotaryOfficeName(), ",notary_office_name=?", sqlList, prmList);
        addUpdateList(info.getContractId(), ",contract_id=?", sqlList, prmList);
        addUpdateList(info.getContractNumber(), ",contract_number=?", sqlList, prmList);
        addUpdateList(info.getContractName(), ",contract_name=?", sqlList, prmList);
        addUpdateList(info.getContractValue(), ",contract_value=?", sqlList, prmList);
        addUpdateList(info.getRelationObject(), ",relation_object=?", sqlList, prmList);
        addUpdateList(info.getNotaryPerson(), ",notary_person=?", sqlList, prmList);
        addUpdateList(info.getNotaryPlace(), ",notary_place=?", sqlList, prmList);
        addUpdateList(info.getNotaryFee(), ",notary_fee=?", sqlList, prmList);
        addUpdateList(info.getNote(), ",note=?", sqlList, prmList);
        addUpdateList(info.getCancelStatus(), ",cancel_status=?", sqlList, prmList);
        addUpdateList(info.getCancelDescription(), ",cancel_description=?", sqlList, prmList);
        
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        if (info.getUpdateDateTime() != null) {
            addUpdateList(new Timestamp(info.getUpdateDateTime().getTimeInMillis()), ",update_date_time=?", sqlList, prmList);
        } else {
            addUpdateList(null, ",update_date_time=?", sqlList, prmList);
        }
        
        addUpdateList(info.getContractPeriod(), ",contract_period=?", sqlList, prmList);
        addUpdateList(info.getLandDistrict(), ",land_district=?", sqlList, prmList);
        addUpdateList(info.getLandStreet(), ",land_street=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelFlag(), ",mortage_cancel_flag=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelDate(), ",mortage_cancel_date=?", sqlList, prmList);
        addUpdateList(info.getMortageCancelNote(), ",mortage_cancel_note=?", sqlList, prmList);
        addUpdateList(info.getContractKind(), ",contract_kind=?", sqlList, prmList);
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
        
        if (this.synchronizeIdFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" ntp.synchronize_id LIKE ? ");
            prmList.add(this.synchronizeIdFilter);
        }
        
        return filterBuffer.toString();
    }


    /**
     * Set the synchronizeIdFilter
     *
     * @param synchronizeIdFilter the synchronizeIdFilter to set
     */
    public void setSynchronizeIdFilter(String synchronizeIdFilter) {
        this.synchronizeIdFilter = synchronizeIdFilter;
    }
    
}
