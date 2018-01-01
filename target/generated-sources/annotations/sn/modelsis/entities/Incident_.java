package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Notification;
import sn.modelsis.entities.Typeincident;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:13")
@StaticMetamodel(Incident.class)
public class Incident_ { 

    public static volatile SingularAttribute<Incident, String> descriptionincident;
    public static volatile ListAttribute<Incident, Notification> notificationList;
    public static volatile SingularAttribute<Incident, Integer> idincident;
    public static volatile SingularAttribute<Incident, Typeincident> idtypeincident;
    public static volatile SingularAttribute<Incident, String> libelleincident;

}