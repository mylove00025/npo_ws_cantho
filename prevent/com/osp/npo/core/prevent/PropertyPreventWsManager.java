package com.osp.npo.core.prevent;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;


import com.osp.npo.core.AbstractWsManager;


/**
 * Generate by script
 * Generate date: 1/22/2011 8:59:06 AM
 * @version $Revision: 20548 $
 */
public class PropertyPreventWsManager extends AbstractWsManager {

    private Long idFilter;

    /**
     * <P>Generate instance</P>
     *
     * @param  connection  Connection
     */
    public PropertyPreventWsManager(Connection connection) {
        super(connection);
    }


    /**
     * <P>Add new infomation</P>
     *
     * @param  info  Infomation that need add
     * @return  PreparedStatement#executeUpdate Return's Value
     * @throws SQLException
     */
    public int insert(PropertyPreventWsInfo info) throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" INSERT INTO ");
        sqlBuffer.append("npo_property_prevent");
        sqlBuffer.append(" ( ");
        sqlBuffer.append("type,");
        sqlBuffer.append("property_info,");
        sqlBuffer.append("owner_info,");
        sqlBuffer.append("other_info,");
        sqlBuffer.append("land_certificate,");
        sqlBuffer.append("land_issue_place,");
        sqlBuffer.append("land_issue_date,");
        sqlBuffer.append("land_map_number,");
        sqlBuffer.append("land_number,");
        sqlBuffer.append("land_address,");
        sqlBuffer.append("land_area,");
        sqlBuffer.append("land_public_area,");
        sqlBuffer.append("land_private_area,");
        sqlBuffer.append("land_use_purpose,");
        sqlBuffer.append("land_use_period,");
        sqlBuffer.append("land_use_origin,");
        sqlBuffer.append("land_associate_property,");
        sqlBuffer.append("land_district,");
        sqlBuffer.append("land_street,");
        sqlBuffer.append("land_province,");
        sqlBuffer.append("car_license_number,");
        sqlBuffer.append("car_regist_number,");
        sqlBuffer.append("car_issue_place,");
        sqlBuffer.append("car_issue_date,");
        sqlBuffer.append("car_frame_number,");
        sqlBuffer.append("car_machine_number");
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
        sqlBuffer.append("?");
        sqlBuffer.append(" ) ");
        setSql(sqlBuffer.toString());

        PreparedStatement ps = null;
        int result = -1;
        try {
            Connection c = this.getConnection();
            ps = c.prepareStatement(getSql());

            int i = 1;
            psSetString(ps, i++, info.getType());
            psSetString(ps, i++, info.getPropertyInfo());
            psSetString(ps, i++, info.getOwnerInfo());
            psSetString(ps, i++, info.getOtherInfo());
            psSetString(ps, i++, info.getLandCertificate());
            psSetString(ps, i++, info.getLandIssuePlace());
            if (info.getLandIssueDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getLandIssueDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getLandMapNumber());
            psSetString(ps, i++, info.getLandNumber());
            psSetString(ps, i++, info.getLandAddress());
            psSetString(ps, i++, info.getLandArea());
            psSetString(ps, i++, info.getLandPublicArea());
            psSetString(ps, i++, info.getLandPrivateArea());
            psSetString(ps, i++, info.getLandUsePurpose());
            psSetString(ps, i++, info.getLandUsePeriod());
            psSetString(ps, i++, info.getLandUseOrigin());
            psSetString(ps, i++, info.getLandAssociateProperty());
            psSetString(ps, i++, info.getLandDistrict());
            psSetString(ps, i++, info.getLandStreet());
            psSetLong(ps, i++, info.getLandProvince());
            psSetString(ps, i++, info.getCarLicenseNumber());
            psSetString(ps, i++, info.getCarRegistNumber());
            psSetString(ps, i++, info.getCarIssuePlace());
            if (info.getCarIssueDate() != null) {
                psSetTimestamp(ps, i++, new Timestamp(info.getCarIssueDate().getTimeInMillis()));
            } else {
                psSetTimestamp(ps, i++, null);
            }
            psSetString(ps, i++, info.getCarFrameNumber());
            psSetString(ps, i++, info.getCarMachineNumber());

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
        sqlBuffer.append(" npo_property_prevent ");
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
    public int update(PropertyPreventWsInfo info) throws SQLException, IOException {

        ArrayList<String> sqlList = new ArrayList<String>();
        ArrayList<Object> prmList = new ArrayList<Object>();

        //Evaluate Null value, create parameter list for SQL Statement.
        makeUpdateList(info, sqlList, prmList);

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" UPDATE ");
        sqlBuffer.append("npo_property_prevent");
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
    public PropertyPreventWsList selectWS(boolean forUpdate, int offset, int limit) throws SQLException, IOException {

        ArrayList<Object> prmList = new ArrayList<Object>();
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" npp.type, ");
        sqlBuffer.append(" npp.property_info, ");
        sqlBuffer.append(" npp.owner_info, ");
        sqlBuffer.append(" npp.other_info, ");
        sqlBuffer.append(" npp.land_certificate, ");
        sqlBuffer.append(" npp.land_issue_place, ");
        sqlBuffer.append(" npp.land_issue_date, ");
        sqlBuffer.append(" npp.land_map_number, ");
        sqlBuffer.append(" npp.land_number, ");
        sqlBuffer.append(" npp.land_address, ");
        sqlBuffer.append(" npp.land_area, ");
        sqlBuffer.append(" npp.land_public_area, ");        
        sqlBuffer.append(" npp.land_private_area, ");
        sqlBuffer.append(" npp.land_use_purpose, ");
        sqlBuffer.append(" npp.land_use_period, ");
        sqlBuffer.append(" npp.land_use_origin, ");
        sqlBuffer.append(" npp.land_associate_property, ");
        sqlBuffer.append(" npp.land_district, ");
        sqlBuffer.append(" npp.land_street, ");
        sqlBuffer.append(" npp.land_province, ");
        sqlBuffer.append(" npp.car_license_number, ");
        sqlBuffer.append(" npp.car_regist_number, ");
        sqlBuffer.append(" npp.car_issue_place, ");
        sqlBuffer.append(" npp.car_issue_date, ");
        sqlBuffer.append(" npp.car_frame_number, ");
        sqlBuffer.append(" npp.car_machine_number ");
        
        sqlBuffer.append(" FROM ");
        sqlBuffer.append(" npo_property_prevent npp ");
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
        PropertyPreventWsList list = null;
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

            PropertyPreventWsInfo info = null;
            list = new PropertyPreventWsList();
            while(rs.next()) {
                info = new PropertyPreventWsInfo();
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
     */
    public int countTotal() throws SQLException {

        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append(" SELECT ");
        sqlBuffer.append(" COUNT(*) ");
        sqlBuffer.append(" FROM ");
        sqlBuffer.append("npo_property_prevent");

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
    private void rsSetInfoWS(ResultSet rs,PropertyPreventWsInfo info) throws SQLException {

        info.setType(rsGetString(rs, "type"));
        info.setPropertyInfo(rsGetString(rs, "property_info"));
        info.setOwnerInfo(rsGetString(rs, "owner_info"));
        info.setOtherInfo(rsGetString(rs, "other_info"));
        info.setLandCertificate(rsGetString(rs, "land_certificate"));
        info.setLandIssuePlace(rsGetString(rs, "land_issue_place"));
        if (rsGetTimestamp(rs, "land_issue_date") != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(rsGetTimestamp(rs, "land_issue_date").getTime());
            info.setLandIssueDate(cal1);
        } else {
            info.setLandIssueDate(null);
        }
        info.setLandMapNumber(rsGetString(rs, "land_map_number"));
        info.setLandNumber(rsGetString(rs, "land_number"));
        info.setLandAddress(rsGetString(rs, "land_address"));
        info.setLandArea(rsGetString(rs, "land_area"));
        info.setLandPublicArea(rsGetString(rs, "land_public_area"));
        info.setLandPrivateArea(rsGetString(rs, "land_private_area"));
        info.setLandUsePurpose(rsGetString(rs, "land_use_purpose"));
        info.setLandUsePeriod(rsGetString(rs, "land_use_period"));
        info.setLandUseOrigin(rsGetString(rs, "land_use_origin"));
        info.setLandAssociateProperty(rsGetString(rs, "land_associate_property"));
        info.setLandDistrict(rsGetString(rs, "land_district"));
        info.setLandStreet(rsGetString(rs, "land_street"));
        info.setLandProvince(rsGetLong(rs, "land_province"));
        info.setCarLicenseNumber(rsGetString(rs, "car_license_number"));
        info.setCarRegistNumber(rsGetString(rs, "car_regist_number"));
        info.setCarIssuePlace(rsGetString(rs, "car_issue_place"));
        if (rsGetTimestamp(rs, "car_issue_date") != null) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTimeInMillis(rsGetTimestamp(rs, "car_issue_date").getTime());
            info.setCarIssueDate(cal2);
        } else {
            info.setCarIssueDate(null);
        }
        info.setCarFrameNumber(rsGetString(rs, "car_frame_number"));
        info.setCarMachineNumber(rsGetString(rs, "car_machine_number"));
    }


    /**
     * <P>Create parameter</P>
     *
     * @param  info  Update Info
     * @param sqlList  SQL List
     * @param prmList  Parameter List
     */
    private void makeUpdateList(PropertyPreventWsInfo info, ArrayList<String> sqlList,ArrayList<Object> prmList){

        addUpdateList(info.getType(), ",type=?", sqlList, prmList);
        addUpdateList(info.getPropertyInfo(), ",property_info=?", sqlList, prmList);
        addUpdateList(info.getOwnerInfo(), ",owner_info=?", sqlList, prmList);
        addUpdateList(info.getOtherInfo(), ",other_info=?", sqlList, prmList);
        addUpdateList(info.getLandCertificate(), ",land_certificate=?", sqlList, prmList);
        addUpdateList(info.getLandAssociateProperty(), ",land_associate_property=?", sqlList, prmList);
        addUpdateList(info.getLandIssuePlace(), ",land_issue_place=?", sqlList, prmList);
        if (info.getLandIssueDate() != null) {
            addUpdateList(new Timestamp(info.getLandIssueDate().getTimeInMillis()), ",land_issue_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",land_issue_date=?", true, sqlList, prmList);
        }
        addUpdateList(info.getLandMapNumber(), ",land_map_number=?", sqlList, prmList);
        addUpdateList(info.getLandNumber(), ",land_number=?", sqlList, prmList);
        addUpdateList(info.getLandAddress(), ",land_address=?", sqlList, prmList);
        addUpdateList(info.getLandArea(), ",land_area=?", sqlList, prmList);
        addUpdateList(info.getLandPublicArea(), ",land_public_area=?", sqlList, prmList);
        addUpdateList(info.getLandPrivateArea(), ",land_private_area=?", sqlList, prmList);
        addUpdateList(info.getLandUsePurpose(), ",land_use_purpose=?", sqlList, prmList);
        addUpdateList(info.getLandUsePeriod(), ",land_use_period=?", sqlList, prmList);
        addUpdateList(info.getLandUseOrigin(), ",land_use_origin=?", sqlList, prmList);
        addUpdateList(info.getLandDistrict(), ",land_district=?", sqlList, prmList);
        addUpdateList(info.getLandStreet(), ",land_street=?", sqlList, prmList);
        addUpdateList(info.getLandProvince(), ",land_province=?", sqlList, prmList);
        addUpdateList(info.getCarLicenseNumber(), ",car_license_number=?", sqlList, prmList);
        addUpdateList(info.getCarRegistNumber(), ",car_regist_number=?", sqlList, prmList);
        addUpdateList(info.getCarIssuePlace(), ",car_issue_place=?", sqlList, prmList);
        if (info.getCarIssueDate() != null) {
            addUpdateList(new Timestamp(info.getCarIssueDate().getTimeInMillis()), ",car_issue_date=?", true, sqlList, prmList);
        } else {
            addUpdateList(null, ",car_issue_date=?", true, sqlList, prmList);
        }
        addUpdateList(info.getCarFrameNumber(), ",car_frame_number=?", sqlList, prmList);
        addUpdateList(info.getCarMachineNumber(), ",car_machine_number=?", sqlList, prmList);
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
        
        if (this.idFilter !=  null) {
            appendAnd(filterBuffer);
            filterBuffer.append(" npp.id = ? ");
            prmList.add(this.idFilter);
        }
        
        return filterBuffer.toString();
    }


    /**
     * Set the idFilter
     *
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.idFilter = idFilter;
    }
    
}
