package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Contrat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Typecontrat.class)
public class Typecontrat_ { 

    public static volatile SingularAttribute<Typecontrat, Short> idtypecontrat;
    public static volatile SingularAttribute<Typecontrat, String> libelletypecontrat;
    public static volatile SingularAttribute<Typecontrat, Boolean> notificationzone;
    public static volatile SingularAttribute<Typecontrat, Boolean> jaugecarburant;
    public static volatile SingularAttribute<Typecontrat, Boolean> gps;
    public static volatile ListAttribute<Typecontrat, Contrat> contratList;

}