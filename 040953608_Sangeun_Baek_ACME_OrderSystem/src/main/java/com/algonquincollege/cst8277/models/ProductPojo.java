/*****************************************************************c******************o*******v******id********
 * File: ProductPojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

/**
*
* Description: model for the Product object
*/
@Entity(name="Product")
@Table(name="PRODUCT")
@AttributeOverride(name="id", column= @Column(name="PRODUCT_ID"))
public class ProductPojo extends PojoBase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String description;
    protected String serialNo;
  
    protected Set<StorePojo> store = new HashSet();
    protected List<OrderLinePojo> orderLines = new ArrayList<>();
    
    // TODO - additional member fieds for M:N

    // JPA requires each @Entity class have a default constructor
    public ProductPojo() {
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
     * retrive the value of serialNo
     * @return current value of serialNo
     */
    @Column(name="SERIALNUMBER")
    public String getSerialNo() {
        return serialNo;
    }
    /**
     * save the value of serialNo
     * @param serialNo new value for serialNo
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
    
    // TODO - additional Mapping for M:N properties
    /**@ManyToMany
    @JoinTable(name="STORES_PRODUCTS", joinColumns=@JoinColumn(name="STORE_ID",referencedColumnName="STORE_ID"),
    inverseJoinColumns=@JoinColumn(name="PRODUCTS_ID", referencedColumnName="PRODUCTS_ID"))**/
    
    /**
     * retrive the value of store
     * @return current value of store
     */
    @ManyToMany(mappedBy="products")
    public Set<StorePojo> getStore(){
        return store;
    }
    /**
     * save the value of store
     * @param store new value for store
     */
    public void setStore(Set<StorePojo> store) {
        this.store = store;
    }
    public void addStore(StorePojo s) {
        if(s !=null) {
            getStore().add(s);
            s.addProduct(this);
        }
    }
    
}