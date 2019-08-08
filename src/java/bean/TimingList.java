package bean;

import ejb.theaterEJB;
import entity.Movie;
import entity.Timing;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "timingList")
@ViewScoped
public class TimingList implements Serializable {

    @EJB
    private theaterEJB theaterEJB;
    
    private String movieName;
    private Movie movie;
    private List<Timing> list;
    private String theaterName;
    private String time;
    
    public TimingList() { }
    
    @PostConstruct
    private void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        theaterName = (String) sessionMap.get("theaterName");
        movieName = (String) sessionMap.get("movieName");
        movie = theaterEJB.getMovieInformation(movieName);
        list = theaterEJB.getTimings(theaterName, movieName);
    }
    
    public String getMovieName() {
        return movieName;
    }
    
    public String getTheaterName() {
        return theaterName;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public String setTime(String time) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("time", time);
        return "form.xhtml";
    }
    
    public String formatTiming(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        return sdf.format(date);
    }
    
    public List<Timing> getTimings() {
        return list;
    }
    
}
