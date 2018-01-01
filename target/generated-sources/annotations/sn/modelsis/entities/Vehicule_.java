package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Concerner;
import sn.modelsis.entities.Conduire;
import sn.modelsis.entities.Modele;
import sn.modelsis.entities.Notification;
import sn.modelsis.entities.Typevehicule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Vehicule.class)
public class Vehicule_ { 

    public static volatile SingularAttribute<Vehicule, String> energie;
    public static volatile SingularAttribute<Vehicule, Modele> idmodele;
    public static volatile ListAttribute<Vehicule, Notification> notificationList;
    public static volatile SingularAttribute<Vehicule, String> couleur;
    public static volatile SingularAttribute<Vehicule, String> chassis;
    public static volatile SingularAttribute<Vehicule, Float> reservoir;
    public static volatile SingularAttribute<Vehicule, String> immatriculation;
    public static volatile SingularAttribute<Vehicule, Typevehicule> idtypevehicule;
    public static volatile ListAttribute<Vehicule, Conduire> conduireList;
    public static volatile ListAttribute<Vehicule, Concerner> concernerList;
    public static volatile SingularAttribute<Vehicule, Integer> idvehicule;

}