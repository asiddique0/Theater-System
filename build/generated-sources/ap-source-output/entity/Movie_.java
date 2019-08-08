package entity;

import entity.Theater;
import entity.Timing;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T12:04:49")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> movieDescription;
    public static volatile SingularAttribute<Movie, String> movieImage;
    public static volatile SingularAttribute<Movie, Integer> movieRuntime;
    public static volatile SingularAttribute<Movie, String> movieType;
    public static volatile SingularAttribute<Movie, String> movieRating;
    public static volatile CollectionAttribute<Movie, Theater> theaterCollection;
    public static volatile CollectionAttribute<Movie, Timing> timingCollection;
    public static volatile SingularAttribute<Movie, String> movieName;

}