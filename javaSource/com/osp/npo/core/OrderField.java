package com.osp.npo.core;


/**
 * Order field class
 * 
 * @author HaiNT
 * @version $Revision$
 */
public class OrderField {
	
	/** Field name */
	private String fieldName;
	
	/** Order Type */
	private OrderType orderType = OrderType.ASC;
	
	/** Order Value */
	private static final String ORDER_TYPE_DESC		= "DESC";
    private static final String ORDER_TYPE_ASC		= "ASC";
	
	
	/** Order Type */
    public enum OrderType {
        /** DESC */
        DESC
        /** ASC */
        , ASC
        ;

        public String getValue() {
            switch (this) {
            case DESC:
                return ORDER_TYPE_DESC;
            case ASC:
                return ORDER_TYPE_ASC;
            default:
                return ORDER_TYPE_ASC;
            }
        }
        
        public static OrderType changeValue(String value) {
            if (ORDER_TYPE_DESC.equals(ORDER_TYPE_DESC)) {
                return DESC;
            } else {
            	return ASC;
            }
        }
    };
    
    
    /**
     * Default Constructor
     */
    public OrderField() {
    	this.orderType = OrderType.ASC;
    }

    /**
     * Constructor method with field name
     * 
     * @param fieldName
     */
    public OrderField(String fieldName) {
    	this.fieldName = fieldName;
    	this.orderType = OrderType.ASC;
    }
    
    /**
     * Constructor method with field name and order type
     * 
     * @param fieldName
     * @param orderType
     */
    public OrderField(String fieldName, OrderType orderType) {
    	this.fieldName = fieldName;
    	this.orderType = orderType;
    }
    

	/**
	 * Get fieldName
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}


	/**
	 * Set fieldName
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	/**
	 * Get orderType
	 * @return the orderType
	 */
	public OrderType getOrderType() {
		return orderType;
	}


	/**
	 * Set orderType
	 * @param orderType the orderType to set
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
    
}
