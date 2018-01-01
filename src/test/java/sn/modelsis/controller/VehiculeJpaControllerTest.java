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
import sn.modelsis.entities.Modele;
import sn.modelsis.entities.Typevehicule;
import sn.modelsis.entities.Vehicule;

/**
 *
 * @author SNNDIAYEH
 */
public class VehiculeJpaControllerTest {

    public VehiculeJpaControllerTest() {
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
    public void testGetVehiculeByMarque() {
        VehiculeJpaController controller = new VehiculeJpaController();
        List<Vehicule> list = controller.getVehiculeByMarque("Ford");
        if (!list.isEmpty()) {
            list.forEach((t) -> {
                System.out.println(t.getChassis() + " | " + t.getImmatriculation() + " | " + t.getEnergie() + " | " + t.getCouleur() + " | " + t.getReservoir());
            });
            assert (true);
        } else {
            fail("Echec");
        }
    }
    
    @Ignore
    @Test
    public void testGetVehiculeByModele(){
        VehiculeJpaController controller = new  VehiculeJpaController();
        List<Vehicule> l = controller.getVehiculeByModele("Ford Edge");
        if(!l.isEmpty()){
            l.forEach((t) -> {
                System.out.println(t.getImmatriculation()+" "+t.getChassis());
            });
            assert(true);
        }else{
            fail("Echec");
        }
    }

    @Ignore
    @Test
    public void testGetVehivuleByImmatriculation() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Vehicule v = controller.getVehiculeByImmatriculation("DK-2083-AB");
        System.out.println(v.getReservoir() + " | " + v.getCouleur());
    }

    @Ignore
    @Test
    public void testGetVehiculeByChassis() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Vehicule v = controller.getVehiculeByChassis("IUQJVJ2DVMGLOZ");
        System.out.println(v.getImmatriculation());
    }

    @Ignore
    @Test
    public void testUpdateVehicule() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Vehicule v = controller.read(3);
        System.out.println(v.getChassis());
        v.setChassis("IUQJVJ2DVMGLOZ");
        controller.update(v);
        System.out.println(controller.read(v.getIdvehicule()).getImmatriculation() + " " + controller.read(v.getIdvehicule()).getChassis());
    }

    @Ignore
    @Test
    public void testCreateVehicule() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Modele m = new Modele((short) 6);
        Typevehicule t = new Typevehicule((short) 2);
        Vehicule v = new Vehicule();
        v.setChassis("Test2");
        v.setEnergie("Test2");
        v.setCouleur("Test2");
        v.setIdmodele(m);
        v.setIdtypevehicule(t);
        v.setImmatriculation("KL-7357-BB");
        v.setReservoir((float) 35);
        controller.create(v);
        assert (true);
    }

    @Ignore
    @Test
    public void testDeleteId() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Vehicule v = controller.read(6);
        System.out.println(v.getImmatriculation() + " " + v.getChassis());
        controller.delete(v.getIdvehicule());
    }

    @Ignore
    @Test
    public void testDeleteEntity() {
        VehiculeJpaController controller = new VehiculeJpaController();
        Vehicule v = controller.read(5);
        System.out.println(v.getImmatriculation() + " " + v.getChassis());
        controller.delete(v);
    }
}
