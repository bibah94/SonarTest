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
import sn.modelsis.entities.Tracking;

/**
 *
 * @author SNNDIAYEH
 */
public class TrackingJpaControllerTest {

    public TrackingJpaControllerTest() {
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
    public void testgetHistory() {
        TrackingJpaController controller = new TrackingJpaController();
        Balise b = new Balise(1);
        List<Tracking> l = controller.getHistory(b.getIdbalise());
        if (!l.isEmpty()) {
            l.forEach((t) -> {
                System.out.println(t.getLatitude() + " | " + t.getLongitude() + " | " + t.getDateheure());
            });
            assert (true);
        } else {
            fail("Echec");
        }
    }

    @Ignore
    @Test
    public void testGetActualPosition() {
        TrackingJpaController controller = new TrackingJpaController();
        Balise b = new Balise(1);
        List<Tracking> t = controller.getActualPosition(b.getIdbalise());
        t.forEach((n) -> {
            System.out.println(n.getLatitude() + " " + n.getLongitude() + " " + n.getDateheure());
        });
    }
    
   
    @Test
    public void testGetContrat(){
        TrackingJpaController cjc = new TrackingJpaController();
        Client c = new Client(1);
        List<Tracking> concerners = cjc.getContrat(c.getIdclient());
        if(!concerners.isEmpty()){
            concerners.forEach((t) -> {
                System.out.println(t.getLatitude()+" "+t.getLongitude()+" "+t.getDateheure());
            });
            assert(true);
        }else{
            fail("Fail");
        }
    }

}
