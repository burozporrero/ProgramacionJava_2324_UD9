# Sistema de acceso con alta

Vamos a añadir la posibilidad de alta de una forma más controlada.
Cuando un usuario entre en nuestro programa, le preguntaremos si quiere entrar o darse de alta.

### Dar de alta
Implicará pedir al usuario una serie de datos relevante para nuestro aplicativo, que almacenaremos en un fichero.
Los datos a pedir al usuario los decide el desarrollador.

En caso de completar toda la información correctamente, le preguntaremos si está seguro de ser almacenado en nuestro 
sistema y en caso afirmativo, procedemos a guardar su usuario.
Ante respuesta negativa, le despediremos apropiadamente.

### Entrar

- Implicará introducir un usuario y una contraseña válidos.
- En caso de no encontrarle en nuestro sistema:
  - Le indicaremos que no está en nuestro sistema, pero
  - le preguntaremos si desea ser incorporado,
  - ante respuesta negativa, le despediremos apropiadamente.
  - En caso de respuesta afirmativa, le mandaremos al apartado "darse de alta".
