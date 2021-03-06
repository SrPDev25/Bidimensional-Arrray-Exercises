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
    private String denominacion;
    private Fecha fechaComienzo;
    private int importeAnual;
    private int participantes;
    
    public Proyecto(String denominacion, String fechaComienzo, int importeAnual) {
        this.denominacion = denominacion;
        this.fechaComienzo = new Fecha(fechaComienzo);
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
    
    public int getParticipantes() {
        return participantes;
    }

    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }
    
    
}
