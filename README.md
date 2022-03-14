# Tecnicas_Reto10

Dina Marcela Reales\
Juan Moreno


Respuesta punto 2: Como se vio en clase, para que una funcion sea de orden superior debe cumplir con almenos una de 2 condiciones 
  1. Recibir como parámetro o entrada una o más funciones.
  2. Devuelve como salida (o resultado) una función.
 
Flatmap permite entregar varias salidas por cada entrada a la funcion, en este sentido podemos entregarle a flatmap otra funcion que me de n numero de entradas, como la construccion de stream. Ejemplo:  elemento.flatMap(viajes -> viajes.stream()). De esta forma cumple con la condicion 1 de las mencionadas anteriormente y por ello es una funcion de orden superior. 
