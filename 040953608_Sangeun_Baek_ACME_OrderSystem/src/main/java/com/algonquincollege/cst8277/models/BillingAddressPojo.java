/*****************************************************************c******************o*******v******id********
 * File: BillingAddressPojo.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * Description: model for the BillingAddress object
 */
@Entity(name="BillingAddress")

public class BillingAddressPojo extends AddressPojo implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected boolean isAlsoShipping;

    // JPA requires each @Entity class have a default constructor
    public BillingAddressPojo() {
    }
    /**
     * check the value of alsoShipping is true or false
     * @return current value of alsoShipping
     */
    public boolean isAlsoShipping() {
        return isAlsoShipping;
    }
    /**
     * save the value of alsoShipping
     * @param isAlsoShipping new value for alsoShinpping (true or false)
     */
    public void setAlsoShipping(boolean isAlsoShipping) {
        this.isAlsoShipping = isAlsoShipping;
    }
    
}