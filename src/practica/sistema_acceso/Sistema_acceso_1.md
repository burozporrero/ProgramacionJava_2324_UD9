# Crear sistema de acceso mejorado

## Enunciado anterior
Crear un programa que valide que usuarios pueden entrar o no a nuestro sistema. Solicitaremos al usuario su
nick y su contraseña y le indicaremos si tiene permiso o no para acceder. En caso de permitirle el acceso, además le
indicaremos la fecha de su último acceso y las veces que ha accedido a nuestra plataforma.

Para resolver el ejercicio necesitaremos crear como mínimo dos clases, dejo al alumno la identificación de las mismas
y de los atributos necesarios para lograr el objetivo.

El usuario administrador del sistema es el que decide quienes son los usuarios que pueden acceder a nuestra
aplicación. Consideremos para una primera versión del ejercicio que el administrador ha dejado previamente esta
información cargada en el sistema, para que tengamos información contra la que validar a los primeros usuarios.

## Nuevo propósito

Cuando un usuario entre en nuestro programa, le pediremos que introduzca usuario y contraseña.
A partir de estos datos:
- Si el usuario está en el sistema, le dejaremos entrar. 
- En caso de no encontrarle en nuestro sistema:
  - Le indicaremos que no está en nuestro sistema, pero 
  - le preguntaremos si desea ser incorporado.
  - en caso de respuesta afirmativa, lo incorporamos y le damos la bienvenida. 
  - Ante respuesta negativa, le despediremos apropiadamente.
- __La información de qué usuarios pueden acceder, se almacena en un valioso fichero__.
- __Recordar la gestión de errores.__
