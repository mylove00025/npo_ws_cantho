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
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 20649 $
 */
public class DataPreventWsManager extends AbstractWsManager {

    private String synchronizeIdFilter;

    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public DataPreventWsManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(DataPreventWsInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_data_prevent");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("property_id,");
        sqlBuffer.append("origin_kind,");
        sqlBuffer.append("delete_flg,");
        sqlBuffer.append("prevent_regist_agency,");
        sqlBuffer.append("prevent_in_book_number,");
        sqlBuffer.append("prevent_person_info,");
        sqlBuffer.append("prevent_doc_number,");
        sqlBuffer.append("prevent_doc_date,");
        sqlBuffer.append("prevent_doc_receive_date,");
        sqlBuffer.append("prevent_input_date,");
        sqlBuffer.append("prevent_doc_summary,");
        sqlBuffer.append("prevent_file_name,");
        sqlBuffer.append("prevent_file_path,");
        sqlBuffer.append("prevent_note,");
        sqlBuffer.append("release_flg,");
        sqlBuffer.append("release_regist_agency,");
        sqlBuffer.append("release_in_book_number,");
        sqlBuffer.append("release_person_info,");
        sqlBuffer.append("release_doc_number,");
        sqlBuffer.append("release_doc_date,");
        sqlBuffer.append("release_doc_receive_date,");
        sqlBuffer.append("release_input_date,");
        sqlBuffer.append("release_doc_summary,");
        sqlBuffer.append("release_file_name,");
        sqlBuffer.append("release_file_path,");
        sqlBuffer.append("release_note, ");
        sqlBuffer.append("entry_user_id, ");
        sqlBuffer.append("entry_user_name, ");
        sqlBuffer.append("entry_date_time, ");
        sqlBuffer.append("update_user_id, ");
        sqlBuffer.append("update_user_name, ");
        sqlBuffer.append("update_date_time ");
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
            psSetLong(ps, i++, info.getPropertyId());
            psSetString(ps, i++, info.getOriginKind());
            psSetBoolean(ps, i++, info.getDeleteFlg());
            psSetString(ps, i++, info.getPreventRegistAgency());
            psSetString(ps, i++, info.getPreventInBookNumber());
            psSetString(ps, i++, info.getPreventPersonInfo());
            psSetString(ps, i++, info.getPreventDocNumber());
            if (info.getPreventDocDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getPreventDocDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            if (info.getPreventDocReceiveDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getPreventDocReceiveDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            if (info.getPreventInputDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getPreventInputDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getPreventDocSummary());
            psSetString(ps, i++, info.getPreventFileName());
            psSetString(ps, i++, info.getPreventFilePath());
            psSetString(ps, i++, info.getPreventNote());
            psSetBoolean(ps, i++, info.getReleaseFlg());
            psSetString(ps, i++, info.getReleaseRegistAgency());
            psSetString(ps, i++, info.getReleaseInBookNumber());
            psSetString(ps, i++, info.getReleasePersonInfo());
            psSetString(ps, i++, info.getReleaseDocNumber());
            if (info.getReleaseDocDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getReleaseDocDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            if (info.getReleaseDocReceiveDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getReleaseDocReceiveDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            if (info.getReleaseInputDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getReleaseInputDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getReleaseDocSummary());
            psSetString(ps, i++, info.getReleaseFileName());
            psSetString(ps, i++, info.getReleaseFilePath());
            psSetString(ps, i++, info.getReleaseNote());

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
            
            result = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Integer generatedId = new Integer(rs.getInt(1));
            info.setId(new Long(generatedId));
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
        sqlBuffer.append(" npo_data_prevent ");
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
    public int update(DataPreventWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_data_prevent");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("id=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("id=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getId());

            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getId());

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
    public DataPreventWsList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        // data prevent info
        sqlBuffer.append(" ndp.id, ");
        sqlBuffer.append(" ndp.property_id ");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        
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
        DataPreventWsList list = null;
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

            DataPreventWsInfo info = null;
            list = new DataPreventWsList();
            while(rs.next()) {
                info = new DataPreventWsInfo();
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
    public DataPreventWsList selectWS(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        // data prevent info
        sqlBuffer.append(" ndp.synchronize_id , ");
        sqlBuffer.append(" ndp.property_id , ");
        sqlBuffer.append(" ndp.origin_kind as origin_kind , ");
        sqlBuffer.append(" ndp.delete_flg as delete_flg , ");
        sqlBuffer.append(" ndp.prevent_regist_agency as prevent_regist_agency , ");
        sqlBuffer.append(" ndp.prevent_in_book_number as prevent_in_book_number , ");
        sqlBuffer.append(" ndp.prevent_person_info as prevent_person_info , ");
        sqlBuffer.append(" ndp.prevent_doc_number as prevent_doc_number , ");
        sqlBuffer.append(" ndp.prevent_doc_date as prevent_doc_date , ");
        sqlBuffer.append(" ndp.prevent_doc_receive_date as prevent_doc_receive_date , ");
        sqlBuffer.append(" ndp.prevent_input_date as prevent_input_date , ");
        sqlBuffer.append(" ndp.prevent_doc_summary as prevent_doc_summary , ");
        sqlBuffer.append(" ndp.prevent_file_name as prevent_file_name , ");
        sqlBuffer.append(" ndp.prevent_file_path as prevent_file_path , ");
        sqlBuffer.append(" ndp.prevent_note as prevent_note , ");
        sqlBuffer.append(" ndp.release_flg as release_flg , ");
        sqlBuffer.append(" ndp.release_regist_agency as release_regist_agency , ");
        sqlBuffer.append(" ndp.release_in_book_number as release_in_book_number , ");
        sqlBuffer.append(" ndp.release_person_info as release_person_info , ");
        sqlBuffer.append(" ndp.release_doc_number as release_doc_number , ");
        sqlBuffer.append(" ndp.release_doc_date as release_doc_date , ");
        sqlBuffer.append(" ndp.release_doc_receive_date as release_doc_receive_date , ");
        sqlBuffer.append(" ndp.release_input_date as release_input_date , ");
        sqlBuffer.append(" ndp.release_doc_summary as release_doc_summary , ");
        sqlBuffer.append(" ndp.release_file_name as release_file_name , ");
        sqlBuffer.append(" ndp.release_file_path as release_file_path , ");
        sqlBuffer.append(" ndp.release_note as release_note ");        

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        
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
        DataPreventWsList list = null;
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

            DataPreventWsInfo info = null;
            list = new DataPreventWsList();
            while(rs.next()) {
                info = new DataPreventWsInfo();
                rsSetInfoWS(rs, info);
                list.add(info);
            }
        } finally {
            close(ps, rs);
        }

        return list;
    }

    public List<String> selectFirstSynchronize(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        // data prevent info
        sqlBuffer.append(" ndp.synchronize_id ");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        
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
        sqlBuffer.append("npo_data_prevent");

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
    private void rsSetInfo(ResultSet rs,DataPreventWsInfo info) throws SQLException {
        
        info.setId(rsGetLong(rs, "id"));
        info.setPropertyId(rsGetLong(rs, "property_id"));

    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     *
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoWS(ResultSet rs,DataPreventWsInfo info) throws SQLException {
        
        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setPropertyId(rsGetLong(rs, "property_id"));
        info.setOriginKind(rsGetString(rs, "origin_kind"));
        info.setDeleteFlg(rsGetBoolean(rs, "delete_flg"));
        info.setPreventRegistAgency(rsGetString(rs, "prevent_regist_agency"));
        info.setPreventInBookNumber(rsGetString(rs, "prevent_in_book_number"));
        info.setPreventPersonInfo(rsGetString(rs, "prevent_person_info"));
        info.setPreventDocNumber(rsGetString(rs, "prevent_doc_number"));
        if (rsGetTimestamp(rs, "prevent_doc_date") != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(rsGetTimestamp(rs, "prevent_doc_date").getTime());
            info.setPreventDocDate(cal1);
        } else {
            info.setPreventDocDate(null);
        }
        if (rsGetTimestamp(rs, "prevent_doc_receive_date") != null) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTimeInMillis(rsGetTimestamp(rs, "prevent_doc_receive_date").getTime());
            info.setPreventDocReceiveDate(cal2);
        } else {
            info.setPreventDocReceiveDate(null);
        }
        if (rsGetTimestamp(rs, "prevent_input_date") != null) {
            Calendar cal3 = Calendar.getInstance();
            cal3.setTimeInMillis(rsGetTimestamp(rs, "prevent_input_date").getTime());
            info.setPreventInputDate(cal3);
        } else {
            info.setPreventInputDate(null);
        }
        info.setPreventDocSummary(rsGetString(rs, "prevent_doc_summary"));
        info.setPreventFileName(rsGetString(rs, "prevent_file_name"));
        info.setPreventFilePath(rsGetString(rs, "prevent_file_path"));
        info.setPreventNote(rsGetString(rs, "prevent_note"));
        info.setReleaseFlg(rsGetBoolean(rs, "release_flg"));
        info.setReleaseRegistAgency(rsGetString(rs, "release_regist_agency"));
        info.setReleaseInBookNumber(rsGetString(rs, "release_in_book_number"));
        info.setReleasePersonInfo(rsGetString(rs, "release_person_info"));
        info.setReleaseDocNumber(rsGetString(rs, "release_doc_number"));
        if (rsGetTimestamp(rs, "release_doc_date") != null) {
            Calendar cal4 = Calendar.getInstance();
            cal4.setTimeInMillis(rsGetTimestamp(rs, "release_doc_date").getTime());
            info.setReleaseDocDate(cal4);
        } else {
            info.setReleaseDocDate(null);
        }
        if (rsGetTimestamp(rs, "release_doc_receive_date") != null) {
            Calendar cal5 = Calendar.getInstance();
            cal5.setTimeInMillis(rsGetTimestamp(rs, "release_doc_receive_date").getTime());
            info.setReleaseDocReceiveDate(cal5);
        } else {
            info.setReleaseDocReceiveDate(null);
        }
        if (rsGetTimestamp(rs, "release_input_date") != null) {
            Calendar cal6 = Calendar.getInstance();
            cal6.setTimeInMillis(rsGetTimestamp(rs, "release_input_date").getTime());
            info.setReleaseInputDate(cal6);
        } else {
            info.setReleaseInputDate(null);
        }
        info.setReleaseDocSummary(rsGetString(rs, "release_doc_summary"));
        info.setReleaseFileName(rsGetString(rs, "release_file_name"));
        info.setReleaseFilePath(rsGetString(rs, "release_file_path"));
        info.setReleaseNote(rsGetString(rs, "release_note"));

    }


    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(DataPreventWsInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

    	addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getPropertyId(), ",property_id=?", sqlList, prmList);
        addUpdateList(info.getOriginKind(), ",origin_kind=?", sqlList, prmList);
        addUpdateList(info.getDeleteFlg(), ",delete_flg=?", sqlList, prmList);
        addUpdateList(info.getPreventRegistAgency(), ",prevent_regist_agency=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventInBookNumber(), ",prevent_in_book_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventPersonInfo(), ",prevent_person_info=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventDocNumber(), ",prevent_doc_number=?", Boolean.TRUE, sqlList, prmList);
        if (info.getPreventDocDate() != null) {
            addUpdateList(new Timestamp(info.getPreventDocDate().getTimeInMillis()), ",prevent_doc_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",prevent_doc_date=?", true, sqlList, prmList);
        }
        if (info.getPreventDocReceiveDate() != null) {
            addUpdateList(new Timestamp(info.getPreventDocReceiveDate().getTimeInMillis()), ",prevent_doc_receive_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",prevent_doc_receive_date=?", true, sqlList, prmList);
        }
        if (info.getPreventInputDate() != null) {
            addUpdateList(new Timestamp(info.getPreventInputDate().getTimeInMillis()), ",prevent_input_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",prevent_input_date=?", true, sqlList, prmList);
        }
        addUpdateList(info.getPreventDocSummary(), ",prevent_doc_summary=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventFileName(), ",prevent_file_name=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventFilePath(), ",prevent_file_path=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getPreventNote(), ",prevent_note=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFlg(), ",release_flg=?", sqlList, prmList);
        addUpdateList(info.getReleaseRegistAgency(), ",release_regist_agency=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseInBookNumber(), ",release_in_book_number=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleasePersonInfo(), ",release_person_info=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseDocNumber(), ",release_doc_number=?", Boolean.TRUE, sqlList, prmList);
        if (info.getReleaseDocDate() != null) {
            addUpdateList(new Timestamp(info.getReleaseDocDate().getTimeInMillis()), ",release_doc_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",release_doc_date=?", true, sqlList, prmList);
        }
        if (info.getReleaseDocReceiveDate() != null) {
            addUpdateList(new Timestamp(info.getReleaseDocReceiveDate().getTimeInMillis()), ",release_doc_receive_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",release_doc_receive_date=?", true, sqlList, prmList);
        }
        if (info.getReleaseInputDate() != null) {
            addUpdateList(new Timestamp(info.getReleaseInputDate().getTimeInMillis()), ",release_input_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",release_input_date=?", true, sqlList, prmList);
        }
        addUpdateList(info.getReleaseDocSummary(), ",release_doc_summary=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFileName(), ",release_file_name=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseFilePath(), ",release_file_path=?", Boolean.TRUE, sqlList, prmList);
        addUpdateList(info.getReleaseNote(), ",release_note=?", Boolean.TRUE, sqlList, prmList);
        
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        if (info.getUpdateDateTime() != null) {
            addUpdateList(new Timestamp(info.getUpdateDateTime().getTimeInMillis()), ",update_date_time=?", sqlList, prmList);
        } else {
            addUpdateList(null, ",update_date_time=?", sqlList, prmList);
        }
    }

    /**
     * Get count record result by filter
     *
     * @return Count of record
     * @throws SQLException
     */
    public int countTotalByFilter() throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");

        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_data_prevent ndp ");
        sqlBuffer.append(" INNER JOIN ");

        sqlBuffer.append(" npo_property_prevent npp ");
        sqlBuffer.append(" ON ");
        sqlBuffer.append(" ndp.property_id = npp.id ");

        sqlBuffer.append(getBaseSQL(prmList));

        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        ResultSet rs = null;
        int result;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());
            int i = 1;
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } finally {
            close(ps, rs);
        }

        return result;
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
            filterBuffer.append(" ndp.synchronize_id LIKE ? ");
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
