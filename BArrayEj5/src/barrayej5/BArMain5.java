
package barrayej5;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;

/**
 *
 * @author dam
 */
public class BArMain5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numEmpleados;
        numEmpleados=EntradaNumeros.numIntGrater("Introduce el número de empleados: ", 0);
        Empresa empresa=new Empresa(numEmpleados);
        empresa.pedirEmpleados();
        empresa.printInforme();
    }
    
}
