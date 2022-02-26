/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej6;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;
import objects.Fecha;

/**
 *
 * @author dam
 */
public class Universidad {

    Proyecto[] proyectos;
    Sanitario[] sanitarios;
    int[][] importeArticulos;
    Categoria[] categorias;
    float[][] irpf;
    int[] hastaImporteB;
    String[] situaciones;

    public Universidad() {
        generateTables();
    }

    private void generateTables() {
        proyectos = new Proyecto[]{
            new Proyecto("COVID-19          ", "20/2/2020", 10000),
            new Proyecto("ENFERMEDADES RARAS", "15/4/2017", 4500),
            new Proyecto("SIFILIS           ", "28/2/2019", 5500),//30/2/2019 no existe
            new Proyecto("BIOQUIMICA        ", "15/8/2020", 6000)
        };

        situaciones = new String[]{"Soltero", "Casado", "Otros", "Es complicado"};

        importeArticulos = new int[][]{
            {20,40,50,Integer.MAX_VALUE},
            {1500,1800,3000,4300}
        };

        categorias = new Categoria[]{
            new Categoria("Medico", 1500),
            new Categoria("Enfermero", 1000),
            new Categoria("Auxiliar Clinico", 500)
        };

        irpf = new float[][]{
            {12, 15, 20, 25},
            {10, 14, 16, 18},
            {5, 7, 10, 15}
        };

        hastaImporteB = new int[]{3000, 5000, 10000, Integer.MAX_VALUE};
    }
    /**
     * Pide los datos de los sanitarios para cargar
     */
    public void dataInput() {
        int totalPersonal = 0, personalProyecto;
        int categoria, situacionPersonal;
        String nombre;

        printProyectos();
        for (int i = 0; i < proyectos.length; i++) {
            personalProyecto = EntradaNumeros.numIntBetween("Sanitarios en el proyecto " + proyectos[i].getDenominacion() + ": ", 0, 100);
            totalPersonal += personalProyecto;
            proyectos[i].setParticipantes(personalProyecto);
        }
        if (totalPersonal != 0) {
            sanitarios = new Sanitario[totalPersonal];
            int posSanitario = 0;
            for (int i = 0; i < proyectos.length; i++) {
                if (proyectos[i].getParticipantes() != 0) {
                    System.out.println("\nProyecto " + proyectos[i].getDenominacion());
                }
                for (int j = 0; j < proyectos[i].getParticipantes(); j++) {
                    sanitarios[posSanitario] = new Sanitario(i);
                    System.out.println("Sanitario " + (posSanitario + 1));
                    nombre=EntradaTextos.inputString("Nombre del sanitario: ");
                    printCategorias();
                    categoria = (EntradaNumeros.numIntBetween("Categoria del sanitario: ", 1, categorias.length) - 1);
                    printSituacionPersonal();
                    situacionPersonal=(EntradaNumeros.numIntBetween("Situacion personal: ", 1, situaciones.length)-1);
                    sanitarios[posSanitario].grabarInfo(nombre, categoria, situacionPersonal);
                    sanitarios[posSanitario].grabarArticulos(proyectos[sanitarios[posSanitario].getProyectoAherido()].getFechaComienzo().getMes());
                    posSanitario++;
                }
            }
        }
    }
    
    /**
     * calcula el importe neto 
     * @param posSanitario se pide la posicion del empleado
     * @return 
     */
    private float calculateimporteNeto(int posSanitario){
        float importeNeto=0,irpf;
        int importeBruto=calculateImporteBruto(posSanitario);
        importeNeto=importeBruto -(importeBruto*(takeIRPF(posSanitario, importeBruto)/100));
        return importeNeto;
        
    }
    
    
    private float takeIRPF(int posSanitario, int importeBruto){
        int pos=0;
        while(importeBruto>hastaImporteB[pos]){
            pos++;
        }
        return irpf[this.sanitarios[posSanitario].getSituacionPersonal()][pos];
    }
    
    /**
     * Calcula el importe bruto de un sanitario
     * @param posSanitario
     * @return 
     */
    private int calculateImporteBruto(int posSanitario){
        int importeBruto,importeAnual,importeArticulos,suplemento;
        importeAnual=proyectos[(sanitarios[posSanitario].getProyectoAherido())].getImporteAnual();
        importeArticulos=takeImporteArticulos(posSanitario);
        suplemento=categorias[(sanitarios[posSanitario].getCategoria())].getSuplemento();
        
        importeBruto=importeAnual+importeArticulos+suplemento;
        return importeBruto;
    }
    
    /**
     * Obtiene el importe por la cantidad de articulos del un sanitario
     * @param posSanitario se indica al sanitario al que referimos
     * @return devuelve el importe
     */
    private int takeImporteArticulos(int posSanitario){
        int pos=0;
        int totArticulos=sanitarios[posSanitario].getTotArticulos();
        while(importeArticulos[0][pos]<totArticulos){
            pos++;
        }
        return importeArticulos[1][pos];
    }


    //"INTERFAZ" PRINTS
    public void informe(){
        Fecha hoy=new Fecha();
        hoy.setToday();
        System.out.println("\n\t\t\tINFORME PERSONAL"
                + "\n\t\t\tMES:"+Fecha.monthName(hoy.getMes())
        +"\nFecha: "+hoy.stringFecha()
        +"\nNOMBRE\tDENOMINACION\t\t\tARTICULOS PUBLICADOS\tIMPORTE NETO");
        
        for(int i=0;i<sanitarios.length;i++){
            if (proyectos[sanitarios[i].getProyectoAherido()].getFechaComienzo().getMes()==hoy.getMes()) {
                
            System.out.println(sanitarios[i].getNombre()+"\t"+proyectos[ sanitarios[i].getProyectoAherido()].getDenominacion()+"\t\t"+stringArticuloZero(i)+"\t\t"+calculateimporteNeto(i)+stringArticuloNoZero(i));
            }
        }
    }
    
    
    private String stringArticuloZero(int posSanitario){
        String zero="Enero: "+sanitarios[posSanitario].getArticulos(0);
        return zero;
    }
    
    private String stringArticuloNoZero(int posSanitario){
        String articulos="";
        for (int mes = 1; mes < 12; mes++) {
            articulos= articulos+"\n\t\t\t\t"+Fecha.monthName(mes+1)+": "+sanitarios[posSanitario].getArticulos(mes);
        }
        return articulos;
    }
    
    private void printProyectos() {
        System.out.println("\n\tPROYECTOS EN CURSO\n");
        for (Proyecto i : proyectos) {
            System.out.println(i.getDenominacion());
        }
    }

    private void printSituacionPersonal() {
        System.out.println("\nSituaciones personal:");
        for (int i = 0; i < this.situaciones.length; i++) {
            System.out.println((i + 1) + ". " + this.situaciones[i]);
        }
    }

    private void printCategorias() {
        System.out.println("\nCategorias");
        for (int i = 0; i < this.categorias.length; i++) {
            System.out.println((i + 1) + ". " + this.categorias[i].getDenominacion());
        }
    }

}
