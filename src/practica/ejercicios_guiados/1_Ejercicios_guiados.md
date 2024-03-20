# FILE

## Trabajando con ficheros

Sigue las instrucciones y recuerda gestionar los errores en el código:
1. Abre un proyecto: puede ser tu proyecto de trabajo habitual o uno nuevo.
2. Es necesario que tenga la estructura mínima de un proyecto en Java: nombre de proyecto/carpeta src/package
3. Crea un fichero con la extensión .txt dentro del package
4. Crea una clase que contenga al método main y desde este main, utiliza la clase File para acceder a él de dos 
   formas diferentes: Por ruta relativa y por ruta absoluta.
5. Ahora crea otro fichero .txt en C:/miarchivo.txt y utiliza otra instancia para acceder a él.
6. Crea dos nuevas instancias a estas clases utilizando otro constructor o el mismo de forma diferente.
7. Crea un String builder para ir imprimiendo las operaciones que vayas realizando y que vamos a indicar a continuación. 
8. Ahora crea una instancia File, apuntando a un directorio, en lugar de a un fichero. 
9. Utiliza el método mkdir()
10. Utiliza al menos 10 métodos de la clase File e imprime los resultados en el StringBuilder creado, gestionando las 
   excepciones, simplemente con la finalidad de que nos fijemos en que tipos de excepciones devuelve. Entre dichos 
    métodos incluye: exists, getAbsolutePath, isFile y delete.

## Creando ficheros

Sobre el main anterior: Vamos a buscar un fichero creaFichero.txt en el directorio de trabajo actual. Si no lo 
encuentro,
lo creo. Si lo encuentro, lo borro y lo creo de nuevo. Recordemos la gestión de excepciones.   

## Creando ficheros múltiples

Sobre el main anterior: añadimos una nueva funcionalidad. A través de la clase File, vamos a crear un directorio hijo del 
actual. Le creamos 10 ficheros dentro. 
Ahora, con ayuda de la clase File, obtén los 10 ficheros creados y los recorres sin hacer nada dentro de ellos.

# EMPEZANDO A LEER Y ESCRIBIR (FileWriter y FileReader)

## Escribiendo 

Sigue las instrucciones y recuerda gestionar los errores en el código:
- Crea un método nuevo al que vamos a llamar desde el main que haga todo lo que se indica en los siguientes pasos.
- Utiliza el fichero vacío "creaFichero.txt" y escribe tu primer apellido dentro, utilizando el constructor FileWriter(File file).
- Vuelve a conectar con el fichero a través del mismo constructor y escribe tu nombre dentro del fichero. ¿Qué ocurre? 
- Ahora, sin borrar lo anterior, utiliza el constructor FileWriter(File file, boolean append), con un true como 
  valor para append, y escribe en el mismo fichero, el nombre de uno de tus compañeros.
- Ahora, lo mismo, probando otro constructor, esta vez el que tú quieras.

## Leyendo

Sigue las instrucciones y recuerda gestionar los errores en el código:
- Crea un método nuevo al que vamos a llamar desde el main que haga todo lo que se indica en los siguientes pasos.
- Lee la información del fichero del punto anterior en bytes
- Lee la información del fichero del punto anterior en caracteres

## Escribiendo en fichero que no existe

Sigue las instrucciones y recuerda gestionar los errores en el código:
- Crea un método nuevo al que vamos a llamar desde el main que haga todo lo que se indica en los siguientes pasos.
- Utiliza un nueva nueva instancia de File apuntando a "ficheroNoExiste.txt", no crees el fichero.
- Intenta escribir en él cualquier texto ¿Qué ocurre? El fichero se crea "sólo".

# LEER Y ESCRIBIR (PrintWriter y Scanner)

## Escribiendo

Sigue las instrucciones y recuerda gestionar los errores en el código:
- Crea un método nuevo al que vamos a llamar desde el main que haga todo lo que se indica en los siguientes pasos.
- Utiliza un nueva nueva instancia de File apuntando a "ficheroPrint.txt", no crees el fichero.
- Utiliza la clase PrintWriter para escribir en el fichero usando tres métodos distintos: print, println y printf.
- Imprime datos en diferentes formatos, int, double, cadenas,...

## Leyendo

Sigue las instrucciones y recuerda gestionar los errores en el código:
- Crea un método nuevo al que vamos a llamar desde el main que haga todo lo que se indica en los siguientes pasos.
- Lee la información del fichero del punto anterior con ayuda de la clase Scanner.
- Si en el ejercicio anterior has leído todo como cadena, asa a utilizar la lectura de ints y doubles.
