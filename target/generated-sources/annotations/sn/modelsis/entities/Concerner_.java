package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Balise;
import sn.modelsis.entities.ConcernerPK;
import sn.modelsis.entities.Contrat;
import sn.modelsis.entities.Vehicule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Concerner.class)
public class Concerner_ { 

    public static volatile SingularAttribute<Concerner, Contrat> contrat;
    public static volatile SingularAttribute<Concerner, Vehicule> vehicule;
    public static volatile SingularAttribute<Concerner, ConcernerPK> concernerPK;
    public static volatile SingularAttribute<Concerner, Balise> balise;

}