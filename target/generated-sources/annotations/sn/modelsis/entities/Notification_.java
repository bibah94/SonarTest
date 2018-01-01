package sn.modelsis.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Incident;
import sn.modelsis.entities.NotificationPK;
import sn.modelsis.entities.Perimetre;
import sn.modelsis.entities.Vehicule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Notification.class)
public class Notification_ { 

    public static volatile SingularAttribute<Notification, Date> datenotification;
    public static volatile SingularAttribute<Notification, Vehicule> vehicule;
    public static volatile SingularAttribute<Notification, Perimetre> perimetre;
    public static volatile SingularAttribute<Notification, NotificationPK> notificationPK;
    public static volatile SingularAttribute<Notification, Incident> incident;

}