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
public class Sanitario {

    private String nombre;
    private int categoria;
    private int[] articulos;
    private int proyectoAherido;
    private int situacionPersonal;

    public Sanitario(int proyectoAherido) {
        this.proyectoAherido = proyectoAherido;
    }

    /**
     * Introduce todos los datos del sanitario
     *
     * @param nombre
     * @param categoria
     * @param articulos
     * @param proyectoAdherido
     * @param situacionPersonal
     */
    public void grabarInfo(String nombre, int categoria, int situacionPersonal) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.situacionPersonal = situacionPersonal;
    }

    public void setProyectoAherido(int proyectoAherido) {
        this.proyectoAherido = proyectoAherido;
    }

    public void grabarArticulos(int mesProyecto) {
        Fecha hoy = new Fecha();
        hoy.setToday();
        int anno = hoy.getAnno();
        this.articulos = new int[12];
        for (int i = 0; i < this.articulos.length; i++) {
            if (mesProyecto <= hoy.getMes()) {
                this.articulos[i] = EntradaNumeros.numIntGrater("Numero de articulos en " + Fecha.monthName(i + 1) + " de " + anno, 0);
            }else
                this.articulos[i] = EntradaNumeros.numIntGrater("Numero de articulos en " + Fecha.monthName(i + 1) + " de " + (anno-1), 0);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public int[] getArticulos() {
        return articulos;
    }

    public int getProyectoAherido() {
        return proyectoAherido;
    }

    public int getSituacionPersonal() {
        return situacionPersonal;
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
