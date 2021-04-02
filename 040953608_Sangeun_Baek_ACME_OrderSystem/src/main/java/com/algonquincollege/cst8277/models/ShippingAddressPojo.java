/*****************************************************************c******************o*******v******id********
 * File: ShippingAddressPojo.java
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
 * Description: model for the ShippingAddress object
 */
@Entity(name="ShippingAddress")
public class ShippingAddressPojo extends AddressPojo implements Serializable {

    // JPA requires each @Entity class have a default constructor
    public ShippingAddressPojo() {
    }

}