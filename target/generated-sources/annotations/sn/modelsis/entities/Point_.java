package sn.modelsis.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Perimetre;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Point.class)
public class Point_ { 

    public static volatile SingularAttribute<Point, Integer> idpoint;
    public static volatile SingularAttribute<Point, Integer> ordre;
    public static volatile ListAttribute<Point, Perimetre> perimetreList;
    public static volatile SingularAttribute<Point, BigDecimal> latitudepoint;
    public static volatile SingularAttribute<Point, BigDecimal> longitudepoint;

}