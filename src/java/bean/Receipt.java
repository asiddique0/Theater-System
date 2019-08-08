package bean;

import ejb.theaterEJB;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@Named(value = "receipt")
@RequestScoped
public class Receipt {

    @EJB
    private theaterEJB theaterEJB;
    String customerName, customerPhone, cardNumber, ticketCost,
           theaterName, movieName, movieTime, zip;
    
    public Receipt() { }
    
    @PostConstruct
    private void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        customerName = (String) flash.get("customerName");
        customerPhone = (String) flash.get("customerPhone");
        cardNumber = (String) flash.get("cardNumber");
        ticketCost = (String) "" + (int) flash.get("ticketCost");
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        theaterName = (String) sessionMap.get("theaterName");
        theaterName = theaterEJB.getTheaterInformation(theaterName);
        movieName = (String) sessionMap.get("movieName");
        movieTime = (String) sessionMap.get("time");
        flash.clear(); sessionMap.clear();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public String getZip() {
        return zip;
    }
    
    public String receipt() {
        return "Receipt: ";
    }

}
