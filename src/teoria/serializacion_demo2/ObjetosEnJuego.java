package teoria.serializacion_demo2;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que almacena el estado de un juego:
 *  - territorios que posee el jugador,
 *  - recursos que posee el jugador
 *
 */
public class ObjetosEnJuego implements Serializable {

    @Serial
    private static final long serialVersionUID = -8390986946490139145L;
    private String[] territorios;
    private String[] recursos;
    private String[] aliados;

    public ObjetosEnJuego(String[] territorios, String[] recursos, String[] aliados) {
        this.territorios = territorios;
        this.recursos = recursos;
        this.aliados = aliados;
    }

    public String[] getTerritorios() {
        return territorios;
    }

    public void setTerritorios(String[] territorios) {
        this.territorios = territorios;
    }

    public String[] getRecursos() {
        return recursos;
    }

    public void setRecursos(String[] recursos) {
        this.recursos = recursos;
    }

    public String[] getAliados() {
        return aliados;
    }

    public void setAliados(String[] aliados) {
        this.aliados = aliados;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjetosEnJuego{");
        sb.append("territorios=").append(Arrays.toString(territorios));
        sb.append(", recursos=").append(Arrays.toString(recursos));
        sb.append(", aliados=").append(Arrays.toString(aliados));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjetosEnJuego that = (ObjetosEnJuego) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(territorios, that.territorios)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(recursos, that.recursos)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(aliados, that.aliados);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(territorios);
        result = 31 * result + Arrays.hashCode(recursos);
        result = 31 * result + Arrays.hashCode(aliados);
        return result;
    }
}
