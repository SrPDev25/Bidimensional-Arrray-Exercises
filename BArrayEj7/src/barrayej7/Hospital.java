/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej7;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;
import objects.Fecha;

/**
 *
 * @author dam
 */
public class Hospital {
    Empleado[] empleados;
    Categoria[] categorias;
    int[][] irpf;
    int[] precioHorasExtra;

    public Hospital(int numEmpleados) {
        empleados=new Empleado[numEmpleados];
    }
    
    private void generateTables(){
        irpf=new int[][]{
            {10,8,6,4},
            {15,2,7,5},
            {20,18,12,7},
            {25,20,15,10}
        };
        
        precioHorasExtra=new int[]{1500,2000,3000,Integer.MAX_VALUE};
        
        categorias=new Categoria[]{
            new Categoria("Medico",2500,50),
            new Categoria("MIR",1100,30),
            new Categoria("Enfermero",1400,30),
            new Categoria("EIR",950,25),
            new Categoria("Otras categorias",1100,20)
        };
    }
    
    public void cargarInfo(){
        String nombre;
        int categoria, hijos,horasExtraRealizadas;
        Fecha fechaAlta;
        
        for (int i = 0; i < empleados.length; i++) {
            empleados[i]=new Empleado();
            System.out.println("Empleado"+(i));
            nombre=EntradaTextos.inputString("Nombre del empleado: ");
            categoria=EntradaNumeros.numIntBetween("Categoria: ", 1, categorias.length);
            
            
        }
        
    }
    
    
    //------Prints------
    
    public void printCategorias(){
        
    }
    
}
