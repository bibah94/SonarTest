package sn.modelsis.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Client;
import sn.modelsis.entities.Concerner;
import sn.modelsis.entities.Facture;
import sn.modelsis.entities.Typecontrat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Contrat.class)
public class Contrat_ { 

    public static volatile SingularAttribute<Contrat, Date> datedebutcontrat;
    public static volatile SingularAttribute<Contrat, Integer> idcontrat;
    public static volatile SingularAttribute<Contrat, Integer> baliseapporte;
    public static volatile SingularAttribute<Contrat, Typecontrat> idtypecontrat;
    public static volatile SingularAttribute<Contrat, Date> datefincontrat;
    public static volatile SingularAttribute<Contrat, Integer> frequenceenvoi;
    public static volatile SingularAttribute<Contrat, Client> idclient;
    public static volatile ListAttribute<Contrat, Facture> factureList;
    public static volatile ListAttribute<Contrat, Concerner> concernerList;

}