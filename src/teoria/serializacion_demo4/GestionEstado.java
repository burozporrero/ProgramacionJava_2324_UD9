package teoria.serializacion_demo4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionEstado {

    public static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args){

        // Hasta ahora solo tenia un objeto, pero ¿y si tengo una lista de objetos que guardar?
        List<ObjetosEnJuego> listaObjetos = crearObjetosEnJuego();

        System.out.println("Intento guardar el estado del juego");
        if(!guardarEstado(listaObjetos)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }

        System.out.println("Intento guardar el estado del juego (opción mejorada)");
        if(!guardarEstadoMejorada(listaObjetos)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }

        System.out.println("Intento recuperar el estado del juego (solución no viable)");
        listaObjetos = recuperarEstado();

        System.out.println("Intento recuperar el estado del juego (solución fea)");
        listaObjetos = recuperarEstadoFeo();

        System.out.println("Intento recuperar el estado del juego (opción mejorada)");
        listaObjetos = recuperarEstadoMejorada();

        if(listaObjetos == null){
            System.out.println("No ha sido posible recuperar el estado del juego");
        } else {
            System.out.println(listaObjetos);
        }

    }

    public static List<ObjetosEnJuego> crearObjetosEnJuego(){

        List<ObjetosEnJuego> listaObjetos = new ArrayList<>();
        String[] territorios = {"España tiene 6 provincias", "Rusia tiene 10 provincias", "Francia tiene 8 provincias"};
        String[] recursos = {"España tiene 100 de oro", "Rusia tiene 80 de oro", "Francia tiene 90 de oro"};
        String[] aliados = {"Francia"};

        for(int i = 1 ; i <= 10 ; i++){
            listaObjetos.add(new ObjetosEnJuego(territorios, recursos, aliados));
        }
        return listaObjetos;
    }

    /**
     * Guarda en un fichero el estado del juego
     * @param listaObjetos
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstado(List<ObjetosEnJuego> listaObjetos){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\teoria\\serializacion\\checkPoint.dat"))){

            for (ObjetosEnJuego objetosEnJuego : listaObjetos) {
                objectOutputStream.writeObject(objetosEnJuego);
            }

        } catch (IOException e) {
            LOGGER.error(e);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * Guarda en un fichero el estado del juego
     * @param listaObjetos
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstadoMejorada(List<ObjetosEnJuego> listaObjetos){

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\teoria\\serializacion\\checkPoint.dat"))){

            objectOutputStream.writeObject(listaObjetos);

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
    public static List<ObjetosEnJuego> recuperarEstado(){

        List<ObjetosEnJuego> listaObjetos = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))) {

            while (true) {
                listaObjetos.add((ObjetosEnJuego) objectInputStream.readObject());
            }
        }catch (EOFException e){
            // dejar en blanco??
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return listaObjetos;
    }

    /**
     * Recupera de un fichero el estado del juego
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static List<ObjetosEnJuego> recuperarEstadoFeo(){

        List<ObjetosEnJuego> listaObjetos = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))) {

            while (objectInputStream.available() > 0) {
                listaObjetos.add((ObjetosEnJuego) objectInputStream.readObject());
            }
        }catch (EOFException e){
            // dejar en blanco??
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return listaObjetos;
    }

    /**
     * Recupera de un fichero el estado del juego
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static List<ObjetosEnJuego> recuperarEstadoMejorada(){

        List<ObjetosEnJuego> listaObjetos = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))){

            listaObjetos = (List<ObjetosEnJuego>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return listaObjetos;
    }


}
