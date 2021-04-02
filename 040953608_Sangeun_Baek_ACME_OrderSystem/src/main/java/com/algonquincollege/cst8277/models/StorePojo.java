/*****************************************************************c******************o*******v******id********
 * File: StorePojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * Description: model for the Store object
 */

@Entity(name="Store")
@Table(name="STORES")
@AttributeOverride(name="id", column = @Column(name="STORE_ID"))
public class StorePojo extends PojoBase {

    protected String storeName;
    protected Set<ProductPojo> products = new HashSet<>();
    
    // TODO - additional member fieds for M:N
   
    // JPA requires each @Entity class have a default constructor
    public StorePojo() {
    }
    /**
     * retrive the value of storeName
     * @return current value of storeName
     */
    public String getStoreName() {
        return storeName;
    }
    /**
     * save the value of storeName
     * @param storeName new value for storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
 // TODO - additional Mapping for M:N properties
    /**
     * retrive the value of products
     * @return current value of products
     */
    @ManyToMany
    @JoinTable(name="STORES_PRODUCTS", joinColumns=@JoinColumn(name="STORE_ID",referencedColumnName="STORE_ID"),
    inverseJoinColumns=@JoinColumn(name="PRODUCT_ID",referencedColumnName="PRODUCT_ID"))
    public Set<ProductPojo> getProducts(){
        return products;
    }
    /**
     * save the value of products
     * @param products new value for products
     */
    public void setProducts(Set<ProductPojo> products) {
        this.products=products;
    }
 
    public void addProduct(ProductPojo product) {
        if(product != null) {
            getProducts().add(product);
            product.getStore().add(this);
        }
    }
    
}
    
