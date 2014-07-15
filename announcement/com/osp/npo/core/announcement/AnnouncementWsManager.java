package com.osp.npo.core.announcement;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.AbstractWsManager;


/**
 * Generate by script
 * Generate date: 01/27/2011 2:53:52 PM
 * @version $Revision: 20554 $ 
 */
public class AnnouncementWsManager extends AbstractWsManager {

	private Long idFilter;
	private String titleFilter;
	private Long idCurentFilter;
	private String synchronizeIdFilter;
	
    /**
     * <P>Generate instance</P>
     * 
     * @param  connection  Connection
     */
    public AnnouncementWsManager(Connection connection) {
        super(connection);
    }
    
    /**
     * Set the idFilter
     *
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.idFilter = idFilter;
    }

    /**
     * Set the title filter
     * 
     * @param titleFilter
     * @param kind
     */
	public void setTitleFilter(String titleFilter, FilterKind kind) {
		this.titleFilter = this.buildFilterString(titleFilter, kind.getValue());
	}
	
	/**
     * Set the idCurentFilter
     *
     * @param idCurentFilter the idCurentFilter to set
     */
    public void setIdCurentFilter(Long idCurentFilter) {
        this.idCurentFilter = idCurentFilter;
    }
    
    /**
     * Set the synchronizeIdFilter
     *
     * @param synchronizeIdFilter the synchronizeIdFilter to set
     */
    public void setSynchronizeIdFilter(String synchronizeIdFilter) {
        this.synchronizeIdFilter = synchronizeIdFilter;
    }

    /**
     * <P>Add new infomation</P>
     * 
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(AnnouncementWsInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_announcement");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("synchronize_id,");
        sqlBuffer.append("kind,");
        sqlBuffer.append("confirm_request,");
        sqlBuffer.append("importance_type,");
        sqlBuffer.append("popup_display_flg,");
        sqlBuffer.append("popup_display_day,");
        sqlBuffer.append("title,");
        sqlBuffer.append("content,");
        sqlBuffer.append("sender_info,");
        sqlBuffer.append("send_date_time,");
        sqlBuffer.append("attach_file_name,");
        sqlBuffer.append("attach_file_path,");
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
            psSetByte(ps, i++, info.getKind());
            psSetByte(ps, i++, info.getConfirmRequest());
            psSetByte(ps, i++, info.getImportanceType());
            psSetBoolean(ps, i++, info.getPopupDisplayFlg());
            psSetLong(ps, i++, info.getPopupDisplayDay());
            psSetString(ps, i++, info.getTitle());
            psSetString(ps, i++, info.getContent());
            psSetString(ps, i++, info.getSenderInfo());
            if (info.getSendDateTime() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getSendDateTime().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getAttachFileName());
            psSetString(ps, i++, info.getAttachFilePath());
            
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
            info.setAid(new Long(generatedId));
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
        sqlBuffer.append(" npo_announcement ");
        sqlBuffer.append(" WHERE ");
        sqlBuffer.append(" aid = ? ");

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
    public int update(AnnouncementWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_announcement");
        sqlBuffer.append(" SET ");
        sqlBuffer.append("aid=?");

        //Result of SQL Statement
        for (int i = 0; i < sqlList.size(); i++) {
            sqlBuffer.append(sqlList.get(i));
        }

        sqlBuffer.append(" WHERE ");
        sqlBuffer.append("aid=?");
        this.setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result;

        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(this.getSql());

            int i = 1;

            psSetLong(ps, i++, info.getAid());
            
            for (int j = 0; j < prmList.size(); j++) {
                psSetObject(ps, i++, prmList.get(j));
            }
            psSetLong(ps, i++, info.getAid());

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
    public AnnouncementWsList select(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" * ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na ");
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
        AnnouncementWsList list = null;
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

            AnnouncementWsInfo info = null;
            list = new AnnouncementWsList();
            while(rs.next()) {
                info = new AnnouncementWsInfo();
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
    public List<String> selectFirstSynchoronize(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" na.synchronize_id ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_announcement na ");
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
     * <P>Get all infomation</P>
     * 
     * @param  forUpdate  Use FOR UPDATE (Yes or No)
     * @return  List of info that geted
     * @throws SQLException
     * @throws IOException
     */
    public AnnouncementWsList selectWS(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");        
        sqlBuffer.append(" na.synchronize_id, ");
        sqlBuffer.append(" na.kind, ");
        sqlBuffer.append(" na.confirm_request, ");
        sqlBuffer.append(" na.importance_type, ");
        sqlBuffer.append(" na.popup_display_flg, ");
        sqlBuffer.append(" na.popup_display_day, ");
        sqlBuffer.append(" na.title, ");
        sqlBuffer.append(" na.content, ");
        sqlBuffer.append(" na.sender_info, ");
        sqlBuffer.append(" na.send_date_time, ");
        sqlBuffer.append(" na.attach_file_name, ");
        sqlBuffer.append(" na.attach_file_path ");        
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append( "npo_announcement na" );
        
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
        AnnouncementWsList list = null;
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

            AnnouncementWsInfo info = null;
            list = new AnnouncementWsList();
            while(rs.next()) {
                info = new AnnouncementWsInfo();
                rsSetInfoWS(rs, info);
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
     * @throws IOException 
     */
    public int countTotal() throws SQLException, IOException {

    	ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_announcement na ");
        
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
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfo(ResultSet rs,AnnouncementWsInfo info) throws SQLException {

        info.setAid(rsGetLong(rs, "aid"));
        
    }
    
    /**
     * <P>Set ResultSet to Info instance </P>
     * 
     * @param  rs    ResultSet
     * @param  info  Info instance
     * @throws SQLException
     */
    private void rsSetInfoWS(ResultSet rs,AnnouncementWsInfo info) throws SQLException {

        info.setSynchronizeId(rsGetString(rs, "synchronize_id"));
        info.setKind(rsGetByte(rs, "kind"));
        info.setConfirmRequest(rsGetByte(rs, "confirm_request"));
        info.setImportanceType(rsGetByte(rs, "importance_type"));
        info.setPopupDisplayFlg(rsGetBoolean(rs, "popup_display_flg"));
        info.setPopupDisplayDay(rsGetLong(rs, "popup_display_day"));
        info.setTitle(rsGetString(rs, "title"));
        info.setContent(rsGetString(rs, "content"));
        info.setSenderInfo(rsGetString(rs, "sender_info"));
        if (rsGetTimestamp(rs, "send_date_time") != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(rsGetTimestamp(rs, "send_date_time").getTime());
            info.setSendDateTime(cal1);
        } else {
            info.setSendDateTime(null);
        }
        info.setAttachFileName(rsGetString(rs, "attach_file_name"));
        info.setAttachFilePath(rsGetString(rs, "attach_file_path"));
    }


    /**
     * <P>Create parameter</P>
     * 
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(AnnouncementWsInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

    	addUpdateList(info.getSynchronizeId(), ",synchronize_id=?", sqlList, prmList);
        addUpdateList(info.getKind(), ",kind=?", sqlList, prmList);
        addUpdateList(info.getConfirmRequest(), ",confirm_request=?", sqlList, prmList);
        addUpdateList(info.getImportanceType(), ",importance_type=?", sqlList, prmList);
        addUpdateList(info.getPopupDisplayFlg(), ",popup_display_flg=?", sqlList, prmList);
        addUpdateList(info.getPopupDisplayDay(), ",popup_display_day=?", sqlList, prmList);
        addUpdateList(info.getTitle(), ",title=?", sqlList, prmList);
        addUpdateList(info.getContent(), ",content=?", sqlList, prmList);
        addUpdateList(info.getSenderInfo(), ",sender_info=?", sqlList, prmList);
        if (info.getSendDateTime() != null) {
            addUpdateList(new Timestamp(info.getSendDateTime().getTimeInMillis()), ",send_date_time=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",send_date_time=?", true, sqlList, prmList);
        }
        addUpdateList(info.getAttachFileName(), ",attach_file_name=?", sqlList, prmList);
        addUpdateList(info.getAttachFilePath(), ",attach_file_path=?", sqlList, prmList);
        
        addUpdateList(info.getUpdateUserId(), ",update_user_id=?", sqlList, prmList);
        addUpdateList(info.getUpdateUserName(), ",update_user_name=?", sqlList, prmList);
        if (info.getUpdateDateTime() != null) {
            addUpdateList(new Timestamp(info.getUpdateDateTime().getTimeInMillis()), ",update_date_time=?", sqlList, prmList);
        } else {
            addUpdateList(null, ",update_date_time=?", sqlList, prmList);
        }
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
        
        if (this.idFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("na.id = ?");
            prmList.add(this.idFilter);
        }
        
        if(this.titleFilter !=null && this.titleFilter.length()>0){
        	appendAnd(filterBuffer);
        	filterBuffer.append("na.title LIKE ?");
        	prmList.add(this.titleFilter);
        }
        
        if (this.idCurentFilter != null) {
            appendAnd(filterBuffer);
            filterBuffer.append("na.aid < ?");
            prmList.add(this.idCurentFilter);
        }
        
        if (this.synchronizeIdFilter != null){
            appendAnd(filterBuffer);
            filterBuffer.append("na.synchronize_id LIKE ?");
            prmList.add(this.synchronizeIdFilter);
        }
        
        return filterBuffer.toString();
    }
}
