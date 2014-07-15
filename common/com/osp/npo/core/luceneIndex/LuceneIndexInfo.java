package com.osp.npo.core.luceneIndex;

import com.osp.npo.core.AbstractWsInfo;
import java.sql.Timestamp;

/**
 * Generate by script Generate date: 06/07/2011 5:56:04 PM
 * 
 * @version $Revision$
 */
public class LuceneIndexInfo extends AbstractWsInfo {

	public static final Byte TYPE_CONTRACT = 1;
	public static final Byte TYPE_PREVENT_DATA = 2;
	public static final Byte TYPE_TRANSACTION = 3;
	
	public static final Byte ACTION_CREATE = 1;
	public static final Byte ACTION_MODIFY = 2;
	public static final Byte ACTION_REMOVE = 3;
	
	public static final Byte STATUS_RUNNING = 0;
	public static final Byte STATUS_ERROR = 1;
	
	/**
	 * Index type:
	 */
	private Byte type;

	/** Data ID */
	private Long dataId;

	/**
	 * Index action:
	 */
	private Byte action;

	/**
	 * Process status:
	 */
	private Byte status;

	/** Create date time */
	private Timestamp entryDateTime;

	/**
	 * <P>
	 * Generate Instance.
	 * </P>
	 * 
	 */
	public LuceneIndexInfo() {
		super();
	}

	/**
	 * <P>
	 * Get Index type:
	 * </P>
	 * 
	 * @return Index type:
	 */
	public Byte getType() {
		return this.type;
	}

	/**
	 * <P>
	 * Set Index type: .
	 * </P>
	 * 
	 * @param type
	 *            Index type:
	 */
	public void setType(Byte type) {
		this.type = type;
	}

	/**
	 * <P>
	 * Get Data ID
	 * </P>
	 * 
	 * @return Data ID
	 */
	public Long getDataId() {
		return this.dataId;
	}

	/**
	 * <P>
	 * Set Data ID.
	 * </P>
	 * 
	 * @param dataId
	 *            Data ID
	 */
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	/**
	 * <P>
	 * Get Index action:
	 * </P>
	 * 
	 * @return Index action:
	 */
	public Byte getAction() {
		return this.action;
	}

	/**
	 * <P>
	 * Set Index action: .
	 * </P>
	 * 
	 * @param action
	 *            Index action:
	 */
	public void setAction(Byte action) {
		this.action = action;
	}

	/**
	 * <P>
	 * Get Process status:
	 * </P>
	 * 
	 * @return Process status:
	 */
	public Byte getStatus() {
		return this.status;
	}

	/**
	 * <P>
	 * Set Process status: .
	 * </P>
	 * 
	 * @param status
	 *            Process status:
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * <P>
	 * Get Create date time
	 * </P>
	 * 
	 * @return Create date time
	 */
	public Timestamp getEntryDateTime2() {
		return this.entryDateTime;
	}

	/**
	 * <P>
	 * Set Create date time.
	 * </P>
	 * 
	 * @param entryDateTime
	 *            Create date time
	 */
	public void setEntryDateTime2(Timestamp entryDateTime) {
		this.entryDateTime = entryDateTime;
	}
}
