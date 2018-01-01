package sn.modelsis.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Chauffeur;
import sn.modelsis.entities.ConduirePK;
import sn.modelsis.entities.Vehicule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Conduire.class)
public class Conduire_ { 

    public static volatile SingularAttribute<Conduire, ConduirePK> conduirePK;
    public static volatile SingularAttribute<Conduire, Vehicule> vehicule;
    public static volatile SingularAttribute<Conduire, Date> datedebut;
    public static volatile SingularAttribute<Conduire, Chauffeur> chauffeur;
    public static volatile SingularAttribute<Conduire, Date> datefin;

}