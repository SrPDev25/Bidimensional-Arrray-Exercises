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
    private float[][] incentivo;

    public Empresa(int numEmpleados) {
        empleados = new Empleado[numEmpleados];
        generateTables();
    }

    private void generateTables() {
        hastaAnnos = new int[]{5, 10, 20, Integer.MAX_VALUE};
        incentivo = new float[][]{
            {100, 250, 500},
            {200, 400, 800},
            {400, 800, 1600},
            {600, 1200, 2400}
        };
    }

    /**
     * Se pide la información del empleado
     */
    public void pedirEmpleados() {
        String nombre;
        Fecha fechaAlta;
        int numHijos;
        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Empleado " + (i + 1) + "\n----------");
            empleados[i] = new Empleado();
            nombre = EntradaTextos.inputString("Introduzca el nombre del empleado: ");
            fechaAlta = EntradaTextos.inputFechaPasada("Introduzca su fecha de alta en la empresa: ");
            numHijos = EntradaNumeros.numIntGrater("Introduzca el número de hijos: ", 0);
            empleados[i].setHijos(numHijos);
            empleados[i].setInfo(nombre, fechaAlta);
        }
    }

    /**
     * Crea un informe con los datos de los empleados introducidos
     */
    public void printInforme() {
        System.out.println("\t\tINFORME ANUAL"
                + "\nNombre\tNºde hijos\tFecha nacimiento hijos\tIncentivo\tObservaciones"
                + "\n--------------------------------------------------------------------------------");
        for (Empleado i : this.empleados) {
            System.out.println(i.getNombre() + "\t" + i.numHijos() + "\t\t" + i.fechaHijoZero() + "\t\t" + calcIncentivo(i) + "€\t\t" + i.numHijosGreat18() + i.fechaHijosResto());
        }
    }

    /**
     * Calcula el incentivo
     *
     * @param empleadoC recoge el empleado al que calcularselo
     * @return devuelve un float con el resultado
     */
    private float calcIncentivo(Empleado empleadoC) {
        float incentivoR = 0;
        int annosTrabajando;
        int x = 0, y = 0;
        if (empleadoC.numHijos() != 0) {
            if (empleadoC.numHijos() < 3) {
                x = empleadoC.numHijos() - 1;
            } else {
                x = 2;
            }
            annosTrabajando = Fecha.calcularEnios(empleadoC.getFechaAlta(), 1);
            for (int aH = 0; aH < this.hastaAnnos.length; aH++) {
                if (this.hastaAnnos[aH] >= annosTrabajando) {
                    y = aH;
                    break;
                }
            }
            incentivoR = this.incentivo[y][x];
        }

        return incentivoR;

    }
}
