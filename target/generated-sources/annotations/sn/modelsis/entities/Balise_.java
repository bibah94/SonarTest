package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Concerner;
import sn.modelsis.entities.Tracking;
import sn.modelsis.entities.Typebalise;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Balise.class)
public class Balise_ { 

    public static volatile SingularAttribute<Balise, Integer> idbalise;
    public static volatile SingularAttribute<Balise, String> telephonebalise;
    public static volatile ListAttribute<Balise, Tracking> trackingList;
    public static volatile SingularAttribute<Balise, String> imeibalise;
    public static volatile SingularAttribute<Balise, String> couleurbalise;
    public static volatile SingularAttribute<Balise, Typebalise> idtypebalise;
    public static volatile SingularAttribute<Balise, String> etat;
    public static volatile SingularAttribute<Balise, String> statut;
    public static volatile ListAttribute<Balise, Concerner> concernerList;

}