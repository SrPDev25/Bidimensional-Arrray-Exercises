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
public class Sanitario {
    String nombre;
    int categoria;
    int[] articulos;
    int proyectoAherido;
    int situacionPersonal;
    static String[] situaciones=new String[]{"Soltero","Casado"};

    public Sanitario() {
    }

    /**
     * Introduce todos los datos del sanitario
     * @param nombre
     * @param categoria
     * @param articulos
     * @param proyectoAherido
     * @param situacionPersonal 
     */
    public void grabarInfo(String nombre, int categoria, int proyectoAherido, int situacionPersonal) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.proyectoAherido = proyectoAherido;
        this.situacionPersonal = situacionPersonal;
    }
    
    public void grabarArticulos(){
        Fecha hoy=new Fecha();
        hoy.setToday();
        
        
    }
    
    
    
    
    
}
/*
Sanitario(String nombre, int categoría, int[] articulos, int proyectoAdherido, int situacionPersonal, static String[] situaciones)
	Sanitario()
	grabar(String nombre, int categoria, int proyectoAdherido, int situacionPersonal)
	articulosPorMes()
		<hay que añadir todos los meses o hasta el que estamos????>
	getters()
Proyecto(String denominacion, Fecha fechaInicio, float importeAnual, int personal)
	Proyecto(........ALL)
	numPersonal(int personal) 	<min 1 max 100>
	getters()
ImporteArticulo(int cantArt[], float importe)
	ImporteArticulo(---ALL)
	getters()
Categoria(String denominacion, float sumplemento)
	Categoria(----ALL)
	getters()
Hospital(Proyecto[] proyectos,Sanitario[] sanitarios, ImporteArticulo[] impArticulos, Categoria[] categorias,  float[][] irpf, int[] hastaImporte)
	Hospital(numSanitarios)
	personalEnProyectos()
	private printProyectos()
	introducirSanitarios()
	
	informe()
 

*/