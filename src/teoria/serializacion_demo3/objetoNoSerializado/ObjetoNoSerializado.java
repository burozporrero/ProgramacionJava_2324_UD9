package teoria.serializacion_demo3.objetoNoSerializado;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Clase que almacena el estado de un juego:
 *  - territorios que posee el jugador,
 *  - recursos que posee el jugador
 *
 */
public class ObjetoNoSerializado implements Serializable {

    @Serial
    private static final long serialVersionUID = 5126604979421916814L;

    private TerritorioNoSerializado[] territorios;
    private RecursoNoSerializado[] recursos;

    public ObjetoNoSerializado(TerritorioNoSerializado[] territorios, RecursoNoSerializado[] recursos) {
        this.territorios = territorios;
        this.recursos = recursos;
    }

    public RecursoNoSerializado[] getRecursos() {
        return recursos;
    }

    public void setRecursos(RecursoNoSerializado[] recursos) {
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

        ObjetoNoSerializado that = (ObjetoNoSerializado) o;

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
