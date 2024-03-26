package teoria.serializacion_demo2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Deserializar {

    public static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args){

        /***************************************************
        // TODO antes de ejecutar esta demo, modificar el serialVersionUID dela clase ObjetoEnJuego_demo2.
        *************************************************** */

        System.out.println("Intento recuperar el estado del juego");
        ObjetoEnJuego_demo2 checkPoint = recuperarEstado();
        if(checkPoint == null){
            System.out.println("No ha sido posible recuperar el estado del juego");
        } else {
            System.out.println(checkPoint);
        }

    }

    /**
     * Recupera de un fichero el estado del juego
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static ObjetoEnJuego_demo2 recuperarEstado(){

        ObjetoEnJuego_demo2 checkPoint = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion_demo2\\checkPoint_demo2.dat"))){

            checkPoint = (ObjetoEnJuego_demo2) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return checkPoint;
    }
}
