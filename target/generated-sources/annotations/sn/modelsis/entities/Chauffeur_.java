package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Conduire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Chauffeur.class)
public class Chauffeur_ { 

    public static volatile SingularAttribute<Chauffeur, Integer> idchauffeur;
    public static volatile SingularAttribute<Chauffeur, String> cnichauffeur;
    public static volatile SingularAttribute<Chauffeur, String> telephonechauffeur;
    public static volatile SingularAttribute<Chauffeur, String> nomchauffeur;
    public static volatile SingularAttribute<Chauffeur, String> prenomchauffeur;
    public static volatile SingularAttribute<Chauffeur, String> numeropermis;
    public static volatile ListAttribute<Chauffeur, Conduire> conduireList;
    public static volatile SingularAttribute<Chauffeur, String> adressechauffeur;

}