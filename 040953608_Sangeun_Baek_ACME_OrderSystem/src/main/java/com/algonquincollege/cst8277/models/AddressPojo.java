/*****************************************************************c******************o*******v******id********
 * File: AddressPojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
*
* Description: model for the Address object
 */


//JPA Annotations here (hint!)
@Entity(name="Address")
@Table(name="CUST_ADDR")
@AttributeOverride(name="id", column=@Column(name="ADDR_ID"))
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="ADDR_TYPE")
public abstract class AddressPojo extends PojoBase implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    public static final String ALL_ADDRESS_QUERY_NAME = "allAddress";

    protected String type;
    protected String city;
    protected String country;
    protected String postalCode;
    protected String state;
    protected String street;

    protected CustomerPojo owningCustomer;
    // TODO - additional properties needed to match ADDRESS table

    /**
     * JPA requires each @Entity class have a default constructor
     */
    public AddressPojo() {
        super();
    }
    /**
     * retrive the value of type 
     * 
     * @return current value of type
     */
    @Column(name="ADDR_TYPE")
    public String getType() {
        return type;
    }
    /**
     * save the valud of the address type
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * retrive value of city 
     * @return current value of city
     */
    @Column(name="CITY")   
    public String getCity() {
        return city;
    }
    /**
     * save the value of the city
     * @param city new value of city
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * retrive the value of country
     * @return current value of country
     */
    @Column(name="COUNTRY")
    public String getCountry() {
        return country;
    }
    /**
     * save the value of the country
     * @param country new value for country
     */
    public void setCountry(String country) {
        this.country=country;
    }

    /**
     * retirve the value of the postalCode
     * @return current value of postalCode
     */
    @Column(name="POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * save the value of the postalCode
     * @param postalCode new value for postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode=postalCode;
    }
    /**
     * retrive the value of state
     * @return current value of state
     */
    @Column(name="STATE")
    public String getState() {
        return state;
    }
    /**
     * save the value of the state
     * @param state new value for state
     */
    public void setState(String state) {
        this.state=state;
    }
    /**
     * retrive the value of the street
     * @return current value of the street
     */
    @Column(name="STREET")
    public String getStreet() {
        return street;
    }
    /**
     * save the value of the street
     * @param street new value for street
     */
    public void setStreet(String street) {
        this.street=street;
    }
    
    /**
     * retrive the value of owningCustomer
     * @return current value of the owningCustomer
     */
    @ManyToOne
    @JoinColumn(name="OWING_CUST_ID")
    public CustomerPojo getOwningCustomer() {
        return owningCustomer;
    }
    /**
     * save the value of the owningCustomer
     * @param owningCustomer new value for owningCustomer
     */
    public void setOwningCustomer(CustomerPojo owningCustomer) {
        this.owningCustomer=owningCustomer;
    }

}