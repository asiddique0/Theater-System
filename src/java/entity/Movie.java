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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieName", query = "SELECT m FROM Movie m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "Movie.findByMovieDescription", query = "SELECT m FROM Movie m WHERE m.movieDescription = :movieDescription"),
    @NamedQuery(name = "Movie.findByMovieType", query = "SELECT m FROM Movie m WHERE m.movieType = :movieType"),
    @NamedQuery(name = "Movie.findByMovieRating", query = "SELECT m FROM Movie m WHERE m.movieRating = :movieRating"),
    @NamedQuery(name = "Movie.findByMovieRuntime", query = "SELECT m FROM Movie m WHERE m.movieRuntime = :movieRuntime"),
    @NamedQuery(name = "Movie.findByMovieImage", query = "SELECT m FROM Movie m WHERE m.movieImage = :movieImage")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Size(max = 1000)
    @Column(name = "MOVIE_DESCRIPTION")
    private String movieDescription;
    @Size(max = 20)
    @Column(name = "MOVIE_TYPE")
    private String movieType;
    @Size(max = 20)
    @Column(name = "MOVIE_RATING")
    private String movieRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_RUNTIME")
    private int movieRuntime;
    @Size(max = 20)
    @Column(name = "MOVIE_IMAGE")
    private String movieImage;
    @JoinTable(name = "THEATER_MOVIE", joinColumns = {
        @JoinColumn(name = "MOVIE_NAME", referencedColumnName = "MOVIE_NAME")}, inverseJoinColumns = {
        @JoinColumn(name = "THEATER_NAME", referencedColumnName = "THEATER_NAME")})
    @ManyToMany
    private Collection<Theater> theaterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<Timing> timingCollection;

    public Movie() {
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName, int movieRuntime) {
        this.movieName = movieName;
        this.movieRuntime = movieRuntime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public Collection<Theater> getTheaterCollection() {
        return theaterCollection;
    }

    public void setTheaterCollection(Collection<Theater> theaterCollection) {
        this.theaterCollection = theaterCollection;
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
        hash += (movieName != null ? movieName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieName == null && other.movieName != null) || (this.movieName != null && !this.movieName.equals(other.movieName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieName=" + movieName + " ]";
    }
    
}
