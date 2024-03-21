# EJERCICIO: Crear sistema de encriptación

Crea una aplicación que permita:

- Preguntar si queremos encriptar o desencriptar un fichero
- Si encriptamos el fichero: leemos de teclado el nombre del fichero (un fichero de tipo texto), lee de teclado la 
palabra de encriptación, y crea un fichero encriptado con el mismo nombre y la extensión “crip”
- Si desencriptamos el fichero: leemos de teclado el nombre del fichero (un fichero de tipo "crip"), leemos de 
teclado la palabra de encriptación y visualizamos el contenido del fichero.

La encriptación o desencriptación se tiene que realizar de tres formas diferentes, la dificultad se incrementa en cada 
una de ellas:

1. Encriptación/Desencriptación sumando/restando los valores de las letras de la palabra de encriptación al texto del fichero.
2. Utilizando la clase de Java Base64
3. Utilizando la clas Cypher
