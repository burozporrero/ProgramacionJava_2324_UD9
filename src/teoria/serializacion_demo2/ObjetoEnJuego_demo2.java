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
public class ObjetoEnJuego_demo2 implements Serializable {


    @Serial
    private static final long serialVersionUID = -4529249669721645668L;
    private String[] territorios;
    private String[] recursos;


    public ObjetoEnJuego_demo2(String[] territorios, String[] recursos) {
        this.territorios = territorios;
        this.recursos = recursos;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjetosEnJuego{");
        sb.append("territorios=").append(Arrays.toString(territorios));
        sb.append(", recursos=").append(Arrays.toString(recursos));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjetoEnJuego_demo2 that = (ObjetoEnJuego_demo2) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(territorios, that.territorios)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(recursos, that.recursos);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(territorios);
        result = 31 * result + Arrays.hashCode(recursos);
        return result;
    }
}
