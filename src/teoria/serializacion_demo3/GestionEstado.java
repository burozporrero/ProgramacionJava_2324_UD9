package teoria.serializacion_demo3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teoria.serializacion_demo2.ObjetoEnJuego_demo2;
import teoria.serializacion_demo3.objetoNoSerializado.ObjetoNoSerializado;
import teoria.serializacion_demo3.objetoNoSerializado.RecursoNoSerializado;
import teoria.serializacion_demo3.objetoNoSerializado.TerritorioNoSerializado;
import teoria.serializacion_demo3.objetoSerializado.ObjetosEnJuego_demo3;
import teoria.serializacion_demo3.objetoSerializado.Recurso;
import teoria.serializacion_demo3.objetoSerializado.Territorio;

import java.io.*;

public class GestionEstado {

    public static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args){

        // TODO Creo objeto que va a fallará al deserializarse
        System.out.println("** Objeto que fallará al deserializarse **");
        ObjetoNoSerializado checkPoint_KO = createObjetoNoSerializado();

        System.out.println("Intento guardar el estado del juego");
        if(!guardarEstado(checkPoint_KO)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }

        System.out.println("Intento recuperar el estado del juego");
        checkPoint_KO = recuperarEstado();
        if(checkPoint_KO == null){
            System.out.println("No ha sido posible recuperar el estado del juego");
        } else {
            System.out.println(checkPoint_KO);
        }



        // TODO Creo objeto que funcionará al deserializarse
        System.out.println("\n** Objeto que funcionará al deserializarse **");
        ObjetosEnJuego_demo3 checkPoint_OK = createObjetoSerializado();

        System.out.println("Intento guardar el estado del juego");
        if(!guardarEstado(checkPoint_OK)){
            System.out.println("No ha sido posible guardar el estado del juego");
        }

        System.out.println("Intento recuperar el estado del juego");
        checkPoint_OK = recuperarEstado_demo3();
        if(checkPoint_OK == null){
            System.out.println("No ha sido posible recuperar el estado del juego");
        } else {
            System.out.println(checkPoint_OK);
        }
    }

    /**
     * Guarda en un fichero el estado del juego
     * @param checkPoint
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstado(ObjetoNoSerializado checkPoint){

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
    public static ObjetoNoSerializado recuperarEstado(){

        ObjetoNoSerializado checkPoint = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))){

            checkPoint = (ObjetoNoSerializado) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return checkPoint;
    }

    /**
     * Guarda en un fichero el estado del juego
     * @param checkPoint
     * @return true si el guardado ha ido correctamente, false en caso contrario.
     */
    public static boolean guardarEstado(ObjetosEnJuego_demo3 checkPoint){

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
    public static ObjetosEnJuego_demo3 recuperarEstado_demo3(){

        ObjetosEnJuego_demo3 checkPoint = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\teoria" +
                "\\serializacion\\checkPoint.dat"))){

            checkPoint = (ObjetosEnJuego_demo3) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e);
        }

        return checkPoint;
    }

    private static ObjetoNoSerializado createObjetoNoSerializado() {

        String[] provincias = new String[]{"Navarra","Aragón"};
        TerritorioNoSerializado tns1 =  new TerritorioNoSerializado("España", provincias);
        provincias = new String[]{"Moscú","San Petersburgo"};
        TerritorioNoSerializado tns2 =  new TerritorioNoSerializado("Rusia", provincias);
        provincias = new String[]{"París","Lyon"};
        TerritorioNoSerializado tns3 =  new TerritorioNoSerializado("Francia", provincias);

        TerritorioNoSerializado[] territorios = new TerritorioNoSerializado[]{tns1, tns2, tns3};

        RecursoNoSerializado rns1 = new RecursoNoSerializado(1,"España", 100);
        RecursoNoSerializado rns2 = new RecursoNoSerializado(2,"Rusia", 80);
        RecursoNoSerializado rns3 = new RecursoNoSerializado(3,"Francia", 90);

        RecursoNoSerializado[] recursos = new RecursoNoSerializado[]{rns1, rns2, rns3};
/*
        String[] territorios = {"España tiene 6 provincias", "Rusia tiene 10 provincias", "Francia tiene 8 provincias"};
        String[] recursos = {"España tiene 100 de oro", "Rusia tiene 80 de oro", "Francia tiene 90 de oro"};
        String[] aliados = {"Francia"};

 */
        return new ObjetoNoSerializado(territorios,recursos);
    }

    private static ObjetosEnJuego_demo3 createObjetoSerializado() {

        String[] provincias = new String[]{"Navarra","Aragón"};
        Territorio tns1 =  new Territorio("España", provincias);
        provincias = new String[]{"Moscú","San Petersburgo"};
        Territorio tns2 =  new Territorio("Rusia", provincias);
        provincias = new String[]{"París","Lyon"};
        Territorio tns3 =  new Territorio("Francia", provincias);

        Territorio[] territorios = new Territorio[]{tns1, tns2, tns3};

        Recurso rns1 = new Recurso(1,"España", 100);
        Recurso rns2 = new Recurso(2,"Rusia", 80);
        Recurso rns3 = new Recurso(3,"Francia", 90);

        Recurso[] recursos = new Recurso[]{rns1, rns2, rns3};
/*
        String[] territorios = {"España tiene 6 provincias", "Rusia tiene 10 provincias", "Francia tiene 8 provincias"};
        String[] recursos = {"España tiene 100 de oro", "Rusia tiene 80 de oro", "Francia tiene 90 de oro"};
        String[] aliados = {"Francia"};

 */
        return new ObjetosEnJuego_demo3(territorios,recursos);
    }

}
