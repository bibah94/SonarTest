package sn.modelsis.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Contrat;
import sn.modelsis.entities.Lignefacture;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, String> modepaiement;
    public static volatile SingularAttribute<Facture, Integer> idfacture;
    public static volatile SingularAttribute<Facture, Float> montanttotal;
    public static volatile SingularAttribute<Facture, Contrat> idcontrat;
    public static volatile ListAttribute<Facture, Lignefacture> lignefactureList;
    public static volatile SingularAttribute<Facture, Date> datepaiement;
    public static volatile SingularAttribute<Facture, Float> remise;
    public static volatile SingularAttribute<Facture, Float> tva;

}