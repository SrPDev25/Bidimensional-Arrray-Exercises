/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barrayej7;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;

/**
 *
 * @author dam
 */
public class BArrMain7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numEmpleados=EntradaNumeros.numIntGrater("Introducir numero de empleados: ", 0);
        Hospital entrada=new Hospital(numEmpleados);
        entrada.cargarInfo();
        entrada.informe();
        
    }
    
}
