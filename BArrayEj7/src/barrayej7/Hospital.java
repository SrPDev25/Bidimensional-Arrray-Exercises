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
    float[][] irpf;
    int[] hastaSueldo;

    public Hospital(int numEmpleados) {
        empleados = new Empleado[numEmpleados];
        generateTables();
    }

    private void generateTables() {
        irpf = new float[][]{
            {10, 8, 6, 4},
            {15, 2, 7, 5},
            {20, 18, 12, 7},
            {25, 20, 15, 10}
        };

        hastaSueldo = new int[]{0, 1500, 2000, 3000};

        categorias = new Categoria[]{
            new Categoria("Medico", 2500, 50),
            new Categoria("MIR", 1100, 30),
            new Categoria("Enfermero", 1400, 30),
            new Categoria("EIR", 950, 25),
            new Categoria("Otras categorias", 1100, 20)
        };
    }

    /**
     * pide la información de los empleados y la carga
     */
    public void cargarInfo() {
        String nombre;
        int categoria, hijos, horasExtraRealizadas;
        Fecha fechaAlta;

        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Empleado();
            System.out.println("Empleado" + (i + 1));
            nombre = EntradaTextos.inputString("Nombre del empleado: ");
            printCategorias();
            categoria = EntradaNumeros.numIntBetween("Categoria: ", 1, categorias.length) - 1;
            fechaAlta = EntradaTextos.inputFechaPasada("Fecha de alta del empelado: ");
            hijos = EntradaNumeros.numIntGrater("Hijos a su cargo: ", 0);
            horasExtraRealizadas = EntradaNumeros.numIntBetween("Horas extra realizadas: ", 0, 80);
            empleados[i].grabar(nombre, categoria, fechaAlta, hijos, horasExtraRealizadas);
        }
    }

    /**
     * Crea un informe de los salarios de los empleados (antes tienen que ser
     * cargados sus datos)
     */
    public void informe() {
        if (empleados.length != 0) {
            float media = mediaSueldo();
            System.out.println("\t\tINFORME DE empleados ALTOS\n"
                    + "Sueldo medio de los empleados: " + media
                    + "\nFecha: " + Fecha.fechaCompleta()
                    + "\nCATEGORIA\tNOMBRE EMPLEADO\t\tSUELDO");
            for (Empleado i : empleados) {
                if (sueldo(i) >= media) {
                    System.out.println(categorias[i.getCategoria()].getDenominacion() + "\t\t\t" + i.getNombre() + "\t\t" + sueldo(i));
                }
            }

        }
    }

    /**
     * calcula la media de todos los empleados
     *
     * @return
     */
    private float mediaSueldo() {
        float media = 0;
        int totalSueldo = 0;

        for (Empleado i : empleados) {
            totalSueldo += sueldo(i);
        }

        media = totalSueldo / empleados.length;

        return media;
    }

    /**
     * calcula el sueldo de un empleado
     *
     * @param empleado
     * @return
     */
    private float sueldo(Empleado empleado) {
        float sueldo = 0;
        int x, y;
        sueldo = categorias[empleado.getCategoria()].getSueldoBase()
                + (categorias[empleado.getCategoria()].getPrecioHorasExtra() * empleado.getHorasExtraRealizadas());
        sueldo += Fecha.calcularEnios(empleado.getFechaAlta(), 5) * 50;

        if ((empleado.getNumHijos() + 1) < irpf[0].length) {
            x = empleado.getNumHijos();
        } else {
            x = 3;
        }

        y = 0;
        while (sueldo < hastaSueldo[y]) {
            y++;
        }

        sueldo = sueldo - (sueldo * (irpf[y][x] / 100));

        return sueldo;
    }

    //------Prints------
    public void printCategorias() {
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i].getDenominacion());
        }
    }

}
