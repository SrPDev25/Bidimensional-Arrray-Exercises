/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej7;

import inputs.EntradaTextos;
import objects.Fecha;

/**
 *
 * @author dam
 */
public class Categoria {
    private String denominacion;
    private int sueldoBase;
    private int precioHorasExtra;

    public Categoria(String denominacion, int sueldoBase, int precioHorasExtra) {
        this.denominacion = denominacion;
        this.sueldoBase = sueldoBase;
        this.precioHorasExtra = precioHorasExtra;
    }

    
    
    public String getDenominacion() {
        return denominacion;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public int getPrecioHorasExtra() {
        return precioHorasExtra;
    }
    
    
}
