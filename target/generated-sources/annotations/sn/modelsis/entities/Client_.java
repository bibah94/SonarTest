package sn.modelsis.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sn.modelsis.entities.Contrat;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T14:31:12")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> ninea;
    public static volatile SingularAttribute<Client, String> adresseclient;
    public static volatile SingularAttribute<Client, String> nomclient;
    public static volatile SingularAttribute<Client, String> pswd;
    public static volatile SingularAttribute<Client, String> prenomclient;
    public static volatile SingularAttribute<Client, String> emailclient;
    public static volatile SingularAttribute<Client, Integer> idclient;
    public static volatile SingularAttribute<Client, String> raisonsociale;
    public static volatile SingularAttribute<Client, String> telephoneclient;
    public static volatile ListAttribute<Client, Contrat> contratList;
    public static volatile SingularAttribute<Client, String> username;
    public static volatile SingularAttribute<Client, String> cni;

}