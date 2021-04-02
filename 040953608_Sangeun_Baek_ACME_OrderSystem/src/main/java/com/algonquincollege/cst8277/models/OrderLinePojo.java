/*****************************************************************c******************o*******v******id********
 * File: OrderLinePojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*
* Description: model for the OrderLine object
*/
@Entity(name="OrderLine")
@Table(name="ORDERLINE")
public class OrderLinePojo implements Serializable {
    private static final long serialVersionUID = 1L;

    protected OrderLinePk primaryKey;
    protected OrderPojo owningOrder;
    protected Double amount;
    protected Double price;
    protected ProductPojo product;

    // JPA requires each @Entity class have a default constructor
    public OrderLinePojo() {
    }
    /**
     * retrive the value of primaryKey
     * @return current value of primaryKey
     */
    @EmbeddedId
    public OrderLinePk getPk() {
        return primaryKey;
    }
    /**
     * save the value of primaryKey
     * @param primaryKey new value for primaryKey
     */
    public void setPk(OrderLinePk primaryKey) {
        this.primaryKey = primaryKey;
    }
    /**
     * retrive the value of amount
     * @return current value of amount
     */
    @Column(name="AMOUNT")
    public Double getAmount() {
        return amount;
    }
    /**
     * save the value of amount
     * @param amount new value of amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    /**
     * retrive the value of price
     * @return current value of price
     */
    @Column(name="PRICE")
    public Double getPrice() {
        return price;
    }
    /**
     * save the value of price
     * @param price new value of price
     */
    public void setPrice(Double price) {
        this.price=price;
    }
    /**
     * retrive the value of owningOrder
     * @return current value of owningOrder
     */
    @ManyToOne
    @JoinColumn(name="OWNING_ORDER_ID")
    public OrderPojo getOwningOrder() {
        return owningOrder;
    }
    /**
     * save the value of owningOrder
     * @param owningOrder new value for owningOrder
     */
    public void setOwningOrder(OrderPojo owningOrder) {
        this.owningOrder = owningOrder;
    }
    /**
     * retrive the value of project
     * @return current value of project
     */
    @OneToOne 
    @JoinColumn(name="PRODUCT_ID")
    public ProductPojo getProduct() {
        return product;
    }
    /**
     * save the value of project
     * @param product new value for project
     */
    public void setProduct(ProductPojo product) {
        this.product = product;
    }

}