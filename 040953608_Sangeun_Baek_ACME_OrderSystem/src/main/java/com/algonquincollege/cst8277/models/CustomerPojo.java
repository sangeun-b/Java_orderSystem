/*****************************************************************c******************o*******v******id********
 * File: CustomerPojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
*
* Description: model for the Customer object
* The CustomerPojo class demonstrates several JPA features:
 * <ul>
 * <li>OneToOne relationship
 * <li>OneToMany relationship
 * </ul>
*/
@Entity(name = "Customer")
@Table(name = "CUSTOMER")
@AttributeOverride(name = "id", column = @Column(name="ID"))
public class CustomerPojo extends PojoBase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phoneNumber;
    protected ShippingAddressPojo shippingAddress;
    protected BillingAddressPojo billingAddress;
    
    protected List<OrderPojo> orders;
	
    // TODO - additional member fieds for 1:1, 1:M
	
    // JPA requires each @Entity class have a default constructor
	public CustomerPojo() {
	}
	/**
	 * retrive the value of firstName
	 * @return current value of firstName
	 */
    @Column(name = "FNAME")
    public String getFirstName() {
        return firstName;
    }
    /**
     * save the value of firstName
     * @param firstName new value for firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * retrive the value of lastName
     * @return current value of lastName
     */
    @Column(name = "LNAME")
    public String getLastName() {
        return lastName;
    }
    /**
     * save the value of lastName
     * @param lastName new value for lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * retrive the value of email
     * @return current value of email
     */
    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }
    /**
     * save the value of email
     * @param email new value for email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * retrive the value of phoneNumber
     * @return current value of phoneNumber
     */
    @Column(name="PHONENUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * save the value of phoneNumber
     * @param phoneNumber new value for phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
   
    // TODO - additional Mappings for 1:1, 1:M properties
    /**
     * retrive the value of shippingAddress
     * @return current value of the ShippingAddress
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="SHIPPING_ADDR")
    public ShippingAddressPojo getShippingAddress() {
        return shippingAddress;
    }
    /**
     * save the value of shippingAddress
     * @param shippingAddress new value for shippingAddress
     */
    public void setShippingAddress(ShippingAddressPojo shippingAddress) {
        this.shippingAddress=shippingAddress;
    }
    /**
     * retrive the value of billingAddress
     * @return current value of billingAddress
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="BILLING_ADDR")
    public BillingAddressPojo getBillingAddress() {
        return billingAddress;
    }
    /**
     * save the value of billingAddress
     * @param billingAddress new value for billingAddress
     */
    public void setBillingAddress(BillingAddressPojo billingAddress) {
        this.billingAddress=billingAddress;
    }
    /**
     * retrive the value of orders
     * @return current value of orders
     */ 
    @OneToMany(mappedBy="owningCustomer", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<OrderPojo> getOrders(){
        return orders;
       
    }
    /**
     * save the value of orders
     * @param orders new value for orders
     */
    public void setOrders(List<OrderPojo> orders) {
        this.orders = orders;
    }
     
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
            .append("Customer [id=")
            .append(id)
            .append(", ");
        if (firstName != null) {
            builder
                .append("firstName=")
                .append(firstName)
                .append(", ");
        }
        if (lastName != null) {
            builder
                .append("lastName=")
                .append(lastName)
                .append(", ");
        }
        if (phoneNumber != null) {
            builder
                .append("phoneNumber=")
                .append(phoneNumber)
                .append(", ");
        }
        if (email != null) {
            builder
                .append("email=")
                .append(email)
                .append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

}