/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Embeddable
public class TimingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "THEATER_NAME")
    private String theaterName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_TIME")
    @Temporal(TemporalType.TIME)
    private Date movieTime;

    public TimingPK() {
    }

    public TimingPK(String theaterName, String movieName, Date movieTime) {
        this.theaterName = theaterName;
        this.movieName = movieName;
        this.movieTime = movieTime;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Date movieTime) {
        this.movieTime = movieTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theaterName != null ? theaterName.hashCode() : 0);
        hash += (movieName != null ? movieName.hashCode() : 0);
        hash += (movieTime != null ? movieTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimingPK)) {
            return false;
        }
        TimingPK other = (TimingPK) object;
        if ((this.theaterName == null && other.theaterName != null) || (this.theaterName != null && !this.theaterName.equals(other.theaterName))) {
            return false;
        }
        if ((this.movieName == null && other.movieName != null) || (this.movieName != null && !this.movieName.equals(other.movieName))) {
            return false;
        }
        if ((this.movieTime == null && other.movieTime != null) || (this.movieTime != null && !this.movieTime.equals(other.movieTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TimingPK[ theaterName=" + theaterName + ", movieName=" + movieName + ", movieTime=" + movieTime + " ]";
    }
    
}
