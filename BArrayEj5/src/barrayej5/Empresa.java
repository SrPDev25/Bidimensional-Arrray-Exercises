package barrayej5;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;
import objects.Fecha;

/**
 *
 * @author dam
 */
public class Empresa {

    private Empleado[] empleados;
    private int[] hastaAnnos;
    private int[] hastaHijos;
    private float[][] incentivo;

    public Empresa(int numEmpleados) {
        empleados = new Empleado[numEmpleados];
        generateTables();
    }

    public void generateTables() {
        hastaAnnos = new int[]{5, 10, 20, Integer.MAX_VALUE};
        hastaHijos = new int[]{1, 2, Integer.MAX_VALUE};
        incentivo = new float[][]{
            {100, 250, 500},
            {200, 400, 800},
            {400, 800, 1600},
            {600, 1200, 2400}
        };
    }

    /**
     * Se introduce la información del empleado
     */
    public void pedirEmpleados() {
        String nombre;
        Fecha fechaAlta;
        int numHijos;
        for (int i = 0; i < empleados.length; i++) {
            empleados[i] = new Empleado();
            nombre = EntradaTextos.inputString("Introduzca el nombre del empleado: ");
            fechaAlta = EntradaTextos.inputFechaPasada("Introduzca su fecha de alta en la empresa: ");
            numHijos = EntradaNumeros.numIntGrater("Introduzca el número de hijos", 0);
            empleados[i].setHijos(numHijos);
            empleados[i].setInfo(nombre, fechaAlta);
        }
    }

    public void printInforme() {
        System.out.println("\t\tINFORME ANUAL"
                + "\nNombre\tNºde hijos\tFecha nacimiento hijos\tIncentivo\tObservaciones"
                + "\n--------------------------------------------------------------------------------");
        for (Empleado i : this.empleados) {
            System.out.println(i.getNombre() + "\t" + i.numHijos() + "\t\t" + i.fechaHijoZero() + "\t\t" + calcIncentivo(i) + "€\t\t" + i.numHijosGreat18() + i.fechaHijosResto());
        }
    }

    private float calcIncentivo(Empleado empleadoC) {
        float incentivoR = 0;

        int x = 0, y = 0;
        if (empleadoC.numHijos() != 0) {
            for (int nH = 0; nH < hastaHijos.length; nH++) {
                if (this.hastaHijos[nH] >= empleadoC.numHijos()) {
                    x = nH;
                    break;
                }
            }
            y = Fecha.calcularEnios(empleadoC.getFechaAlta(), 1);
            for (int aH = 0; aH < this.hastaAnnos.length; aH++) {
                if (this.hastaAnnos[aH] >= y) {
                    y = aH;
                }
            }
            incentivoR = this.incentivo[y][x];
        }

        return incentivoR;

    }
}
