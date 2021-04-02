/***************************************************************************f******************u************zz*******y**
 * File: Assignment3Driver.java
 * Course materials (20W) CST 8277
 * @author Mike Norman
 * @date 2020 04
 *
 * Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Assignment3Driver {

    public static final String ASSIGNMENT3_PU_NAME = "assignment3-orderSystem-PU";
  
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ASSIGNMENT3_PU_NAME);
        emf.close();
    }

}
