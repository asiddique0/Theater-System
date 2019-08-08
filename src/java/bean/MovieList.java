package bean;

import ejb.theaterEJB;
import entity.Movie;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "movieList")
@ViewScoped
public class MovieList implements Serializable {

    @EJB
    private theaterEJB theaterEJB;
    
    private String movieName;
    private List<Movie> list;
    private String theaterName;
    
    public MovieList() { }
    
    @PostConstruct
    private void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        theaterName = (String) sessionMap.get("theaterName");
        list = theaterEJB.getMovies(theaterName);
    }
    public String getMovieName() {
        return movieName;
    }

    public String setMovieName(String movieName) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("movieName", movieName);
        this.movieName = movieName;
        return "timingList.xhtml";
    }
   
    public List<Movie> getMoviesbyTheaterName() {
        return list;
    }
    
    public String theaterInformation() {
        return theaterEJB.getTheaterInformation(theaterName);
    }
    
    
}
