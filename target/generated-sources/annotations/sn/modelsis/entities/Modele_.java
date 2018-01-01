package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Categorie;
import sn.modelsis.entities.Marque;
import sn.modelsis.entities.Vehicule;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Modele.class)
public class Modele_ { 

    public static volatile SingularAttribute<Modele, Short> idmodele;
    public static volatile ListAttribute<Modele, Categorie> categorieList;
    public static volatile SingularAttribute<Modele, String> libellemodele;
    public static volatile ListAttribute<Modele, Vehicule> vehiculeList;
    public static volatile SingularAttribute<Modele, Marque> idmarque;
    public static volatile SingularAttribute<Modele, String> descriptionmodele;

}