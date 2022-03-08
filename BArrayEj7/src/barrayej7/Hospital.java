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
    int[] hastaSueldo;

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
        
        hastaSueldo=new int[]{0,1500,2000,3000};
        
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
            System.out.println("Empleado"+(i+1));
            nombre=EntradaTextos.inputString("Nombre del empleado: ");
            categoria=EntradaNumeros.numIntBetween("Categoria: ", 1, categorias.length)-1;
            hijos=EntradaNumeros.numIntGrater("Hijos a su cargo: ", 0);
            horasExtraRealizadas=EntradaNumeros.numIntBetween("Horas extra realizadas: ", 0, 80);
        }
    }
    
    public void informe(){
        float media=mediaSueldo();
        if(empleados.length!=0){
            System.out.println("\t\tINFORME DE empleados ALTOS\n"
                    + "Sueldo medio de los empleados: "+media
                    + "\nFecha: "+Fecha.fechaCompleta()
                    + "\nCATEGORIA\tNOMBRE EMPLEADO\tSUELDO");
            
        }
        
        
    }

    private float mediaSueldo(){
        float media=0;
        int totalSueldo=0;
        
        for(Empleado i: empleados){
            totalSueldo+=sueldo(i);
        }
        
        media=totalSueldo/empleados.length;
        
        return media;
    }
    
    private float sueldo(Empleado empleado){
        float sueldo=0;
        int x,y;
        sueldo=categorias[empleado.getCategoria()].getSueldoBase()
                +(categorias[empleado.getCategoria()].getPrecioHorasExtra()*empleado.getHorasExtraRealizadas());
        if((empleado.getNumHijos()+1)<irpf[0].length){
            x=empleado.getNumHijos();
        }else{
            x=3;
        }
        y=0;
        while(sueldo<hastaSueldo[y]){
            y++;
        }
        
        sueldo=sueldo-(sueldo*(irpf[y][x]/100));
        
        return sueldo;
    }
    
    //------Prints------
    
    public void printCategorias(){
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i+1)+". "+categorias[i].getDenominacion());
        }
    }
    
}
