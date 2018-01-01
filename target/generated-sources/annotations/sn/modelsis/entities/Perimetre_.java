package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Notification;
import sn.modelsis.entities.Point;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Perimetre.class)
public class Perimetre_ { 

    public static volatile ListAttribute<Perimetre, Point> pointList;
    public static volatile ListAttribute<Perimetre, Notification> notificationList;
    public static volatile SingularAttribute<Perimetre, String> nomperimetre;
    public static volatile SingularAttribute<Perimetre, Integer> idperimetre;

}