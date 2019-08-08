/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "LOCATION")
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByZip", query = "SELECT l FROM Location l WHERE l.zip = :zip"),
    @NamedQuery(name = "Location.findByStateabr", query = "SELECT l FROM Location l WHERE l.stateabr = :stateabr"),
    @NamedQuery(name = "Location.findByCountry", query = "SELECT l FROM Location l WHERE l.country = :country")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ZIP")
    private String zip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "STATEABR")
    private String stateabr;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(mappedBy = "zip")
    private Collection<Theater> theaterCollection;

    public Location() {
    }

    public Location(String zip) {
        this.zip = zip;
    }

    public Location(String zip, String stateabr) {
        this.zip = zip;
        this.stateabr = stateabr;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStateabr() {
        return stateabr;
    }

    public void setStateabr(String stateabr) {
        this.stateabr = stateabr;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Theater> getTheaterCollection() {
        return theaterCollection;
    }

    public void setTheaterCollection(Collection<Theater> theaterCollection) {
        this.theaterCollection = theaterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zip != null ? zip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Location[ zip=" + zip + " ]";
    }
    
}
