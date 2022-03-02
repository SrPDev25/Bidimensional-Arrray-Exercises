/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej7;

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
    
    
    
    
}
