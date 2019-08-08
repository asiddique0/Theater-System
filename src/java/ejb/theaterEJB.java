package ejb;

import entity.Location;
import entity.Movie;
import entity.Paymenttable;
import entity.Theater;
import entity.Timing;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class theaterEJB {

    @PersistenceContext(unitName = "TheaterSystemPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }

    public String getState(String zip) {
        String state = em.createNamedQuery("Location.findByZip", Location.class)
                .setParameter("zip", zip)
                .getSingleResult()
                .getStateabr();
        return state;
    }
    
    public String getCountry(String zip) {
        String country = em.createNamedQuery("Location.findByZip", Location.class)
                .setParameter("zip", zip)
                .getSingleResult()
                .getCountry();
        return country;
    }
    
    public List<Theater> getTheaterLocations(String zip) {
        return em.createNamedQuery("Theater.findByZip", Theater.class)
                .setParameter("zip", zip)
                .getResultList();
    }
    
    public String getTheaterInformation(String theaterName) {
        Theater theater = em.createNamedQuery("Theater.findByTheaterName", Theater.class)
                           .setParameter("theaterName", theaterName)
                           .getSingleResult();
        String theaterInfo = theaterName + ", " + theater.getTheaterAddress() 
                              + ", " + theater.getZip().getZip();
        return theaterInfo;
    }
    
    public List<Movie> getMovies(String theaterName) {
        Theater theater = em.createNamedQuery("Theater.findByTheaterName", Theater.class)
                           .setParameter("theaterName", theaterName)
                           .getSingleResult();
        
        List<Movie> movies = new ArrayList<>(theater.getMovieCollection());
        return movies;   
    }
    
    public Movie getMovieInformation(String movieName) {
        Movie movie = em.createNamedQuery("Movie.findByMovieName", Movie.class)
                       .setParameter("movieName", movieName)
                       .getSingleResult();
        return movie;
    }
    
    public List<Timing> getTimings(String theaterName, String movieName) {
        return em.createNamedQuery("Timing.findByMovieAndTheaterName", Timing.class)
                .setParameter("theaterName", theaterName)
                .setParameter("movieName", movieName)
                .getResultList();
    }
    
    public void saveCustomerInformation(String customerName, 
                                        String customerPhone,
                                        String customerEmail,
                                        String cardNumber,
                                        String cvv) {
        Paymenttable table = new Paymenttable();
        table.setCustomerName(customerName);
        table.setCustomerPhone(customerPhone);
        table.setCardNumber(cardNumber);
        table.setCvv(cvv);
        table.setTransactionDate(new Date());
        Random random = new Random();
        String id = random.nextInt(9999 - 111 + 1) + 111 + 
                    customerName.hashCode() + ""
                    + customerPhone.hashCode() + ""
                    + cardNumber.hashCode();
        table.setTransactionId(id);
        em.persist(table);
    } 
}
