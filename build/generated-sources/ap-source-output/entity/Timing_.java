package entity;

import entity.Movie;
import entity.Theater;
import entity.TimingPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T12:04:49")
@StaticMetamodel(Timing.class)
public class Timing_ { 

    public static volatile SingularAttribute<Timing, Movie> movie;
    public static volatile SingularAttribute<Timing, Theater> theater;
    public static volatile SingularAttribute<Timing, TimingPK> timingPK;

}