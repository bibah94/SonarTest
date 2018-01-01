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
import org.junit.Test;
import sn.modelsis.entities.Contrat;

/**
 *
 * @author SNNDIAYEH
 */
public class ContratJpaControllerTest {
    
    public ContratJpaControllerTest() {
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

    @Test
    public void testGetContrat() {
        ContratJpaController controller = new ContratJpaController();
        List<Contrat> l = controller.getContrat("HQCVYNLSD38UFS");
        if (!l.isEmpty()) {
            l.forEach((t) -> {
                System.out.println(t.getDatedebutcontrat()+" "+t.getDatefincontrat()+" "+t.getFrequenceenvoi());
            });
            assert(true);
        } else {
            fail("Echec");
        }
    }
    
}
