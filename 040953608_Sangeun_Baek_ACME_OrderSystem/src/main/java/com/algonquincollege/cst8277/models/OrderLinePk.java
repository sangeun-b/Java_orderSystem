/*****************************************************************c******************o*******v******id********
 * File: OrderLinePk.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 *
 * JPA helper class: Composite Primary Key class for OrderLine - two columns
 * ORDERLINE_NO identifies which orderLine within an Order (i.e. line 1, line 2, line 3)
 * OWNING_ORDER_ID identifies which Order this orderLine belongs to
 * 
*/
@Embeddable
public class OrderLinePk implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected int owningOrderId;
    protected int orderLineNo;
    
    /**
     * retrive the value of owningOrderId
     * @return current value of owningOrderId
     */
    public int getOwningOrderId() {
        return owningOrderId;
    }
    /**
     * save the value of owningOrderId
     * @param owningOrderId new value of owningOrderId
     */
    public void setOwningOrderId(int owningOrderId) {
        this.owningOrderId = owningOrderId;
    }
    /**
     * retrive the value of OrderLineNo
     * @return current value of OrderLineNo
     */

    public int getOrderLineNo() {
        return orderLineNo;
    }
    /**
     * save the value of orderLineNo
     * @param orderLineNo new value for orderLineNo
     */
    public void setOrderLineNo(int orderLineNo) {
        this.orderLineNo = orderLineNo;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(orderLineNo, owningOrderId);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderLinePk)) {
            return false;
        }
        OrderLinePk other = (OrderLinePk) obj;
        return orderLineNo == other.orderLineNo && owningOrderId == other.owningOrderId;
    }

}