/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej6;

/**
 *
 * @author dam
 */
public class Hospital {

    Proyecto[] proyectos;
    Sanitario[] sanitarios;
    int[][] importeArticulos;
    Categoria[] categorias;
    float[][] irpf;
    int[] hastaImporteB;

    public Hospital(int numSanitarios) {
        sanitarios = new Sanitario[numSanitarios];
    }

    private void generateTables() {
        proyectos = new Proyecto[]{
            new Proyecto("COVID-19", "20/2/2020", 10000),
            new Proyecto("ENFERMEDADES RARAS", "15/4/2017", 4500),
            new Proyecto("SIFILIS", "30/2/2019", 5500),
            new Proyecto("BIOQUIMICA", "15/8/2020", 6000)
        };
        
        importeArticulos = new int[][]{
            {20, 1500},
            {40, 1800},
            {50, 3000},
            {Integer.MAX_VALUE, 4300}
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

        hastaImporteB=new int[]{3000,5000,10000,Integer.MAX_VALUE};
    }

}
