package teoria.serializacion_demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Serializar {

    public static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args){

        String[] territorios = {"España tiene 6 provincias", "Rusia tiene 10 provincias", "Francia tiene 8 provincias"};
        String[] recursos = {"España tiene 100 de oro", "Rusia tiene 80 de oro", "Francia tiene 90 de oro"};

        ObjetoEnJuego_demo2 checkPoint = new ObjetoEnJuego_demo2(territorios, recursos);

        System.out.println("Intento guardar el estado del juego");
        if(!guardarEstado(checkPoint)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }
    }

    /**
     * Guarda en un fichero el estado del juego
     * @param checkPoint
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstado(ObjetoEnJuego_demo2 checkPoint){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\teoria" +
                "\\serializacion_demo2\\checkPoint_demo2.dat"))){

            objectOutputStream.writeObject(checkPoint);

        } catch (IOException e) {
            LOGGER.error(e);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
