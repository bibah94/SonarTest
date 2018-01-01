/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.modelsis.controller;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import sn.modelsis.entities.Client;
import sn.modelsis.entities.Tracking;

/**
 *
 * @author SNNDIAYEH
 */
public class ClientJpaControllerTest {

    public ClientJpaControllerTest() {
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
    public void testLogin() {
        ClientJpaController cjc = new ClientJpaController();
        Client c = cjc.login("bib", "passer");
        System.out.println(c.getCni() + " " + c.getTelephoneclient() + " " + c.getNomclient()+ " " + c.getPrenomclient());
    }
    
    @Test
    public void testActual(){
        ClientJpaController controller = new ClientJpaController();
        Client c = new Client(2);
        List<Tracking> l = controller.getActual(c.getIdclient());
        if (!l.isEmpty()) {
            l.forEach((t) -> {
                System.out.println(t.getLatitude()+" "+t.getLongitude()+" "+t.getDateheure());
            });
            assert(true);
        } else {
            fail("Fail");
        }
    }

}
