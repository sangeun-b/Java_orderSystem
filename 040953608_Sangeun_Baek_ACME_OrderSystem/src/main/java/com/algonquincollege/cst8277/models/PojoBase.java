/*****************************************************************c******************o*******v******id********
 * File: PojoBase.java
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
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Abstract class that is base of (class) hierarchy for all c.a.cst8277.models @Entity classes
 */
@MappedSuperclass
@Access(AccessType.PROPERTY) // NOTE: by using this annotations, any annotation on a field is ignored without warning
@EntityListeners({PojoListener.class})
public abstract class PojoBase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected int id;
    protected int version;
    protected LocalDateTime created;
    protected LocalDateTime updated;
    // TODO - add audit properties
    
    /**
     * retrive the value of id
     * @return current value of id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    /**
     * save the value of id
     * @param id new value for id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * retrive the value of version
     * @return current value of version
     */
    @Version
    public int getVersion() {
        return version;
    }
    /**
     * save the value of version
     * @param version new value for version
     */
    public void setVersion(int version) {
        this.version = version;
    }
    /**
     * retrvie the value of created
     * @return current value of created
     */
    @Column(name="CREATED")
    public LocalDateTime getCreated() {
        return created;
    }
    /**
     * save the value of created
     * @param created new value for created
     */
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    /**
     * retrive the value of updated
     * @return current value of updated
     */
    @Column(name="UPDATED")
    public LocalDateTime getUpdated() {
        return updated;
    }
    /**
     * save the value of updated
     * @param created new value for updated
     */
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    // It is a good idea for hashCode() to use the @Id property
    // since it maps to table's PK and that is how Db determine's identity
    // (same for equals()
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PojoBase)) {
            return false;
        }
        PojoBase other = (PojoBase)obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
}