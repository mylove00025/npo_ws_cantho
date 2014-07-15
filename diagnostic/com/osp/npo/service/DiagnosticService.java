package com.osp.npo.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import com.osp.npo.core.diagnostic.DiagnosticManager;
import com.osp.npo.core.diagnostic.DiagnosticInfo;
import com.osp.npo.core.diagnostic.DiagnosticList;


/**
 * Generate by script
 * Generate date: 1/2/2012 9:54:59 PM
 * @version $Revision$ 
 */
public class DiagnosticService extends AbstractService {


    /** Diagnostic Manager Object */
    private DiagnosticManager diagnosticManager;




    /** <P> Service constructor </P>*/
    public DiagnosticService(Connection connection) {
        super(connection);
        this.diagnosticManager = new DiagnosticManager (connection);
    }


    /**
     * <P> entry DiagnosticInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryDiagnostic(DiagnosticInfo info) throws SQLException{
        return this.diagnosticManager.insert(info);
    }


    /**
     * <P> modify DiagnosticInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyDiagnostic(DiagnosticInfo info) throws SQLException, IOException{
        return this.diagnosticManager.update(info);
    }


    /**
     * <P> remove Diagnostic by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeDiagnostic(Long id) throws SQLException{
        return this.diagnosticManager.delete(id);
    }


    /**
     * <P> query Diagnostic list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DiagnosticList queryDiagnostic(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.diagnosticManager.select(forUpdate, offset, maxLine);
    }


    /**
     * <P> query all of Diagnostic list from database </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public DiagnosticList queryAllDiagnostic(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.diagnosticManager.select(forUpdate, -1, -1);
    }

    /**
     * Query by PK
     * 
     * @param forUpdate
     * @param officeCode
     * @param commandCode
     * @return
     * @throws SQLException
     */
    public DiagnosticInfo queryDiagnosticByPK(boolean forUpdate, String officeCode, String commandCode) throws SQLException {
    	return this.diagnosticManager.selectByPK(forUpdate, officeCode, commandCode);
    }

    /**
     * <P> count total Diagnostic </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalDiagnostic()
            throws SQLException, IOException{
        return this.diagnosticManager.countTotal();
    }
}
