package teoria.serializacion_demo3.objetoSerializado;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Territorio implements Serializable {
    @Serial
    private static final long serialVersionUID = -7995451023913394390L;
    String nombre;
    String[] provincias;

    public Territorio(String nombre, String[] provincias) {
        this.nombre = nombre;
        this.provincias = provincias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getProvincias() {
        return provincias;
    }

    public void setProvincias(String[] provincias) {
        this.provincias = provincias;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Territorio{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", provincias=").append(Arrays.toString(provincias));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Territorio that = (Territorio) o;

        if (!Objects.equals(nombre, that.nombre)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(provincias, that.provincias);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(provincias);
        return result;
    }
}
