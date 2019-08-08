package bean;

import ejb.theaterEJB;
import entity.Theater;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "theaterList")
@ViewScoped
public class TheaterList implements Serializable {

    @EJB
    private theaterEJB theaterEJB;
    
    
    private List<Theater> list;
    private String theaterName;
    private String zip;
    public TheaterList() { }
    
    @PostConstruct
    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        zip = (String) sessionMap.get("zip");
        list = theaterEJB.getTheaterLocations(zip);
    }
    public String getTheaterName() {
        return theaterName;
    }

    public String setTheaterName(String theaterName) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("theaterName", theaterName);
        this.theaterName = theaterName;
        return "movieList.xhtml";
    }

    public List<Theater> getTheaterByZip() {
          return list;
    }
    
    public String zipCode() {
        return zip;
    }
}
