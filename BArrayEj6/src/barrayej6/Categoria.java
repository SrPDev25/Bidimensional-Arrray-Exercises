
package barrayej6;

/**
 *
 * @author dam
 */
public class Categoria {
    private String denominacion;
    private int suplemento;

    public Categoria(String determinacion, int suplemento) {
        this.denominacion = determinacion;
        this.suplemento = suplemento;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getSuplemento() {
        return suplemento;
    }
}
