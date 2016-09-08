/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "NEW_HIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewHire.findAll", query = "SELECT n FROM NewHire n"),
    @NamedQuery(name = "NewHire.findByName", query = "SELECT n FROM NewHire n WHERE n.name = :name"),
    @NamedQuery(name = "NewHire.findByHiredate", query = "SELECT n FROM NewHire n WHERE n.hiredate = :hiredate")})
public class NewHire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "HIREDATE")
    private String hiredate;

    public NewHire() {
    }

    public NewHire(String name) {
        this.name = name;
    }

    public NewHire(String name, String hiredate) {
        this.name = name;
        this.hiredate = hiredate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewHire)) {
            return false;
        }
        NewHire other = (NewHire) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.entity.NewHire[ name=" + name + " ]";
    }
    
}
