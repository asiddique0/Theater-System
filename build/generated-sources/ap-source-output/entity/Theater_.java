package entity;

import entity.Location;
import entity.Movie;
import entity.Timing;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T12:04:49")
@StaticMetamodel(Theater.class)
public class Theater_ { 

    public static volatile SingularAttribute<Theater, Location> zip;
    public static volatile CollectionAttribute<Theater, Movie> movieCollection;
    public static volatile SingularAttribute<Theater, String> theaterAddress;
    public static volatile SingularAttribute<Theater, String> theaterName;
    public static volatile CollectionAttribute<Theater, Timing> timingCollection;

}