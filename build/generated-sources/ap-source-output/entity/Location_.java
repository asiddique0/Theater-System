package entity;

import entity.Theater;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T12:04:49")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> zip;
    public static volatile SingularAttribute<Location, String> country;
    public static volatile SingularAttribute<Location, String> stateabr;
    public static volatile CollectionAttribute<Location, Theater> theaterCollection;

}