package teoria.serializacion_demo3.objetoSerializado;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que almacena el estado de un juego:
 *  - territorios que posee el jugador,
 *  - recursos que posee el jugador
 *
 */
public class ObjetosEnJuego_demo3 implements Serializable {

    @Serial
    private static final long serialVersionUID = 5126604979421916814L;

    private Territorio[] territorios;
    private Recurso[] recursos;

    public ObjetosEnJuego_demo3(Territorio[] territorios, Recurso[] recursos) {
        this.territorios = territorios;
        this.recursos = recursos;
    }

    public Recurso[] getRecursos() {
        return recursos;
    }

    public void setRecursos(Recurso[] recursos) {
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

        ObjetosEnJuego_demo3 that = (ObjetosEnJuego_demo3) o;

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
