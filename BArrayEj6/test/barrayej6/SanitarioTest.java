/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package barrayej6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dam
 */
public class SanitarioTest {
    
    public SanitarioTest() {
    }

    /**
     * Test of grabarInfo method, of class Sanitario.
     */
    @Test
    public void testGrabarInfo() {
        System.out.println("grabarInfo");
        String nombre = "";
        int categoria = 0;
        int proyectoAherido = 0;
        int situacionPersonal = 0;
        Sanitario instance = new Sanitario();
        instance.grabarInfo(nombre, categoria, proyectoAherido, situacionPersonal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grabarArticulos method, of class Sanitario.
     */
    @Test
    public void testGrabarArticulos() {
        System.out.println("grabarArticulos");
        Sanitario instance = new Sanitario();
        instance.grabarArticulos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
