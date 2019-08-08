/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "THEATER")
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterName", query = "SELECT t FROM Theater t WHERE t.theaterName = :theaterName"),
    @NamedQuery(name = "Theater.findByTheaterAddress", query = "SELECT t FROM Theater t WHERE t.theaterAddress = :theaterAddress"),
    @NamedQuery(name = "Theater.findByZip", query = "SELECT t FROM Theater t WHERE t.zip.zip = :zip") 
})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "THEATER_NAME")
    private String theaterName;
    @Size(max = 250)
    @Column(name = "THEATER_ADDRESS")
    private String theaterAddress;
    @ManyToMany(mappedBy = "theaterCollection")
    private Collection<Movie> movieCollection;
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP")
    @ManyToOne
    private Location zip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private Collection<Timing> timingCollection;

    public Theater() {
    }

    public Theater(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    public Collection<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(Collection<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    public Location getZip() {
        return zip;
    }

    public void setZip(Location zip) {
        this.zip = zip;
    }

    public Collection<Timing> getTimingCollection() {
        return timingCollection;
    }

    public void setTimingCollection(Collection<Timing> timingCollection) {
        this.timingCollection = timingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterName != null ? theaterName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterName == null && other.theaterName != null) || (this.theaterName != null && !this.theaterName.equals(other.theaterName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterName=" + theaterName + " ]";
    }
    
}
