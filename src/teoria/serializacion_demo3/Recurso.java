package teoria.serializacion_demo3;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Recurso implements Serializable {

    @Serial
    private static final long serialVersionUID = -331316989964838554L;
    int id;
    String nombre;
    double cantidad;

    public Recurso(int id, String nombre, double cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recurso{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recurso recurso = (Recurso) o;

        if (id != recurso.id) return false;
        if (Double.compare(cantidad, recurso.cantidad) != 0) return false;
        return Objects.equals(nombre, recurso.nombre);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        temp = Double.doubleToLongBits(cantidad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
