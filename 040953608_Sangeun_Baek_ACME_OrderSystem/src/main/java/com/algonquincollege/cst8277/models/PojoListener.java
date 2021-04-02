/*****************************************************************c******************o*******v******id********
 * File: PojoListener.java
 * Course materials (20F) CST 8277
 * (Original Author) Mike Norman
 * 
 * (Modified) @author Sangeun Baek 040953608
 */
package com.algonquincollege.cst8277.models;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class PojoListener {
    
    @PrePersist
    public void setCreatedOnDate(PojoBase pojo) {
        LocalDateTime now = LocalDateTime.now();
        pojo.setCreated(now);
        pojo.setUpdated(now);
    }
    @PreUpdate
    public void setUpdtedDate(PojoBase pojo) {
        pojo.setUpdated(LocalDateTime.now());
    }


}