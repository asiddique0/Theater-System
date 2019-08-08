package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-31T12:04:49")
@StaticMetamodel(Paymenttable.class)
public class Paymenttable_ { 

    public static volatile SingularAttribute<Paymenttable, String> customerPhone;
    public static volatile SingularAttribute<Paymenttable, String> cvv;
    public static volatile SingularAttribute<Paymenttable, Date> transactionDate;
    public static volatile SingularAttribute<Paymenttable, String> transactionId;
    public static volatile SingularAttribute<Paymenttable, String> customerName;
    public static volatile SingularAttribute<Paymenttable, String> cardNumber;

}