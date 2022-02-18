/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej6;

import objects.Fecha;

/**
 *
 * @author dam
 */
public class Proyecto {
    String denominacion;
    Fecha fechaComienzo;
    int importeAnual;
    
    public Proyecto(String denominacion, Fecha fechaComienzo, int importeAnual) {
        this.denominacion = denominacion;
        this.fechaComienzo = fechaComienzo;
        this.importeAnual = importeAnual;
    }
    
    public String getDenominacion() {
        return denominacion;
    }

    public Fecha getFechaComienzo() {
        return fechaComienzo;
    }

    public int getImporteAnual() {
        return importeAnual;
    }
    
    
}
