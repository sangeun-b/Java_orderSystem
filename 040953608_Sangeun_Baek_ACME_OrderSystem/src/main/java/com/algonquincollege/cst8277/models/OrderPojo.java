/*****************************************************************c******************o*******v******id********
 * File: OrderPojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
*
* Description: model for the Order object
*/
@Entity(name="order")
@Table(name="ORDER_TBL")
@AttributeOverride(name="id",column=@Column(name="ORDER_ID"))
public class OrderPojo extends PojoBase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String description;
    protected List<OrderLinePojo> orderLines;
    protected CustomerPojo owningCustomer;
    
    // JPA requires each @Entity class have a default constructor
	public OrderPojo() {
	}
	/**
	 * retrive the value of description
	 * @return current value of description
	 */
	@Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }
	/**
	 * save the value of description
	 * @param description new value for description
	 */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * retrive the value of orderLines
     * @return current value of orderLines
     */
    @OneToMany(mappedBy="owningOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<OrderLinePojo> getOrderLines() {
		return orderLines;
	}
    /**
     * save the value of orderLines
     * @param orderLines new value for orderLines
     */
	public void setOrderLines(List<OrderLinePojo> orderLines) {
		this.orderLines = orderLines;
	}
	
	public OrderLinePojo addOrderline(OrderLinePojo orderLine) {
        getOrderLines().add(orderLine);
        orderLine.setOwningOrder(this);
        return orderLine;
    }
    public OrderLinePojo removeOrderline(OrderLinePojo orderLine) {
        getOrderLines().remove(orderLine);
        orderLine.setOwningOrder(null);
        return orderLine;
    }
    /**
     * retrive the value of owningCustomer
     * @return current value of owningCustomer
     */
	@ManyToOne @JoinColumn(name="OWNING_CUST_ID")
	public CustomerPojo getOwningCustomer() {
		return owningCustomer;
	}
	/**
	 * save the value of owningCustomer
	 * @param owningCustomer new value for owningCustomer
	 */
	public void setOwningCustomer(CustomerPojo owningCustomer) {
		this.owningCustomer = owningCustomer;
	}
	

}