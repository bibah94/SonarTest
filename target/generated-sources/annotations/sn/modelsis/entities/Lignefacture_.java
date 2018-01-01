package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Facture;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Lignefacture.class)
public class Lignefacture_ { 

    public static volatile SingularAttribute<Lignefacture, Float> total;
    public static volatile SingularAttribute<Lignefacture, Facture> idfacture;
    public static volatile SingularAttribute<Lignefacture, Float> prixunitaire;
    public static volatile SingularAttribute<Lignefacture, String> libelle;
    public static volatile SingularAttribute<Lignefacture, Short> idlignefacture;
    public static volatile SingularAttribute<Lignefacture, Integer> quantite;

}