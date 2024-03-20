package teoria.serializacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class GestionEstado {

    public static final Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args){

        String[] territorios = {"España tiene 6 provincias", "Rusia tiene 10 provincias", "Francia tiene 8 provincias"};
        String[] recursos = {"España tiene 100 de oro", "Rusia tiene 80 de oro", "Francia tiene 90 de oro"};

        ObjetosEnJuego checkPoint = new ObjetosEnJuego(territorios, recursos);

        System.out.println("Intento guardar el estado del juego");
        if(!guardarEstado(checkPoint)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }

        System.out.println("Intento recuperar el estado del juego");
        checkPoint = recuperarEstado();
        if(checkPoint == null){
            System.out.println("No ha sido posible recuperar el estado del juego");
        } else {
            System.out.println(checkPoint);
        }

    }

    /**
     * Guarda en un fichero el estado del juego
     * @param checkPoint
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstado(ObjetosEnJuego checkPoint){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\teoria\\serializacion\\checkPoint.dat"))){

            objectOutputStream.writeObject(checkPoint);

        } catch (IOException e) {
            LOGGER.error(e);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * Recupera de un fichero el estado del juego
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static ObjetosEnJuego recuperarEstado(){

        ObjetosEnJuego checkPoint = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))){

            checkPoint = (ObjetosEnJuego) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return checkPoint;
    }
}
