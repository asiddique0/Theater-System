/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TIMING")
@NamedQueries({
    @NamedQuery(name = "Timing.findAll", query = "SELECT t FROM Timing t"),
    @NamedQuery(name = "Timing.findByTheaterName", query = "SELECT t FROM Timing t WHERE t.timingPK.theaterName = :theaterName"),
    @NamedQuery(name = "Timing.findByMovieName", query = "SELECT t FROM Timing t WHERE t.timingPK.movieName = :movieName"),
    @NamedQuery(name = "Timing.findByMovieTime", query = "SELECT t FROM Timing t WHERE t.timingPK.movieTime = :movieTime"),
    @NamedQuery(name = "Timing.findByMovieAndTheaterName",  
                query = "SELECT t FROM Timing t WHERE t.timingPK.movieName = :movieName AND t.timingPK.theaterName = :theaterName")
})
public class Timing implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimingPK timingPK;
    @JoinColumn(name = "MOVIE_NAME", referencedColumnName = "MOVIE_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "THEATER_NAME", referencedColumnName = "THEATER_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theater theater;

    public Timing() {
    }

    public Timing(TimingPK timingPK) {
        this.timingPK = timingPK;
    }

    public Timing(String theaterName, String movieName, Date movieTime) {
        this.timingPK = new TimingPK(theaterName, movieName, movieTime);
    }

    public TimingPK getTimingPK() {
        return timingPK;
    }

    public void setTimingPK(TimingPK timingPK) {
        this.timingPK = timingPK;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timingPK != null ? timingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timing)) {
            return false;
        }
        Timing other = (Timing) object;
        if ((this.timingPK == null && other.timingPK != null) || (this.timingPK != null && !this.timingPK.equals(other.timingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Timing[ timingPK=" + timingPK + " ]";
    }
    
}
