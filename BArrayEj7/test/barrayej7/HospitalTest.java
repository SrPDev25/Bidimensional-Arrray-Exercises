/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package barrayej7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dam
 */
public class HospitalTest {
    
    public HospitalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCargarInfo() {
        System.out.println("cargarInfo");
        Hospital instance = null;
        instance.cargarInfo();
        fail("The test case is a prototype.");
    }

    @Test
    public void testInforme() {
        System.out.println("informe");
        Hospital instance = null;
        instance.informe();
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintCategorias() {
        System.out.println("printCategorias");
        Hospital instance = null;
        instance.printCategorias();
        fail("The test case is a prototype.");
    }
    
}
