package sn.modelsis.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Balise;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Tracking.class)
public class Tracking_ { 

    public static volatile SingularAttribute<Tracking, Integer> altitude;
    public static volatile SingularAttribute<Tracking, String> libelletracking;
    public static volatile SingularAttribute<Tracking, Integer> idtracking;
    public static volatile SingularAttribute<Tracking, Balise> idbalise;
    public static volatile SingularAttribute<Tracking, BigDecimal> latitude;
    public static volatile SingularAttribute<Tracking, BigDecimal> longitude;
    public static volatile SingularAttribute<Tracking, Integer> vitesse;
    public static volatile SingularAttribute<Tracking, Date> dateheure;

}