/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import sn.modelsis.entities.Balise;
import sn.modelsis.entities.Client;
import sn.modelsis.entities.Concerner;
import sn.modelsis.entities.ConcernerPK;
import sn.modelsis.entities.Contrat;
import sn.modelsis.entities.Vehicule;

/**
 *
 * @author SNNDIAYEH
 */
public class ConcernerJpaControllerTest {

    public ConcernerJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Ignore
    @Test
    public void testConcernerContrat(){
        ConcernerJpaController cjc = new ConcernerJpaController();
        Contrat c = new Contrat(2);
        List<Concerner> concerners = cjc.getConcernerContrat(c.getIdcontrat());
        if(!concerners.isEmpty()){
            concerners.forEach((t) -> {
                System.out.println(t.getContrat().getIdclient().getPrenomclient()+" "+t.getBalise().getImeibalise()+" "+t.getVehicule().getImmatriculation());
            });
            assert(true);
        }else{
            fail("Fail");
        }
    }
    
    @Ignore
    @Test
    public void testCreate(){
        ConcernerJpaController controller = new ConcernerJpaController();
        Contrat c = new Contrat(3);
        Balise b = new Balise(3);
        Vehicule v = new Vehicule(4);
        Concerner c1 = new Concerner();
        ConcernerPK cpk = new ConcernerPK(v.getIdvehicule(), c.getIdcontrat(), b.getIdbalise());
        c1.setConcernerPK(cpk);
        c1.setBalise(b);
        c1.setContrat(c);
        c1.setVehicule(v);
        controller.create(c1);
    }
    
    @Test
    public void testGetContrat(){
        ConcernerJpaController cjc = new ConcernerJpaController();
        Client c = new Client(2);
        List<Concerner> concerners = cjc.getContrat(c.getIdclient());
        if(!concerners.isEmpty()){
            concerners.forEach((t) -> {
                System.out.println(t.getContrat().getIdclient().getPrenomclient()+" "+t.getBalise().getImeibalise()+" "+t.getVehicule().getImmatriculation()+" "+t.getBalise().getIdbalise());
            });
            assert(true);
        }else{
            fail("Fail");
        }
    }

}
