/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej7;

import objects.Fecha;

/**
 *
 * @author dam
 */
public class Empleado {
    private String nombre;
    private int categoria;
    private Fecha fechaAlta;
    private int numHijos;
    private int horasExtraRealizadas;// menos de 80

    public Empleado() {
    }

    /**
     * Introduce todos los datos del empleado
     * @param nombre
     * @param categoria
     * @param fechaAlta
     * @param numHijos
     * @param horasExtraRealizadas 
     */
    public void grabar(String nombre, int categoria, Fecha fechaAlta, int numHijos, int horasExtraRealizadas) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaAlta = fechaAlta;
        this.numHijos = numHijos;
        this.horasExtraRealizadas = horasExtraRealizadas;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public int getHorasExtraRealizadas() {
        return horasExtraRealizadas;
    }
    
    
    
    
    
}
