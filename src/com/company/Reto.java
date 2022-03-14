package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Reto {
    
    public Reto() {

        System.out.print("\n Este codigo realizara los ejercicios propuestos en el reto 10 en el siguiente orden: "+
        "\n 1. Suma de los digitos de un numero \n " +
        "2. Raiz cuadrada de un conjuento de numeros \n " +
        "3. Factorial de un numero \n " +
        "4. Cadenas con mas de 5 caracteres\n " +
        "5. Promedios de un grupo de estudiantes \n");

        try {
            System.out.print("\nEsta funcion evaluara el numero 12689 y entregara la suma de sus digitos \n");
            System.out.print("La suma de los numeros es:" + suma(12689));
            System.out.print("\n --------------------------------------------------------------------------\n");
            Thread.sleep(5*1000);
            System.out.print("\nEsta funcion evaluara una lista de numeros y entregara como lista la raiz cuarada de cada uno de ellos\n");
            List<Double> numeros = new ArrayList<>();
            numeros.add(49.0);
            numeros.add(25.0);
            numeros.add(810.0);
            numeros.add(Math.PI);
            numeros.add(7.0);
            System.out.print("\nLa lista de numeros es: \n");
            for (Double numeroActual : numeros) {
                System.out.println(numeroActual);
            }
            List<Double> raices = raices(numeros);
            System.out.print("\nLa lista de raices es: \n");
            for (Double raizActual : raices) {
                System.out.println(raizActual);
            }
            System.out.print("\n --------------------------------------------------------------------------\n");
            Thread.sleep(5*1000);
            System.out.print("\nEsta funcion entregara el factorial del numero 9 \n");
            System.out.print("El factorial es: "+ factorial(9) +"\n");
            System.out.print("\n --------------------------------------------------------------------------\n");
            Thread.sleep(5*1000);
            System.out.print("\nEsta funcion entregara las palabras con 5 caracteres o mas de una lista \n");
            Set<String> listaPalabras = new HashSet<>(Arrays.asList("electrocutar",
                                                                    "pepe",
                                                                    "consignar",
                                                                    "ban",
                                                                    "hala",
                                                                    "car",
                                                                    "rebotar",
                                                                    "ojo",
                                                                    "perico"));
            System.out.print("\nLa lista de palabras a verificar es  \n");
            for (String palabraActual : listaPalabras) {
                System.out.print("\n"+palabraActual);
            }
            List<String> listaPalabrasCondicion = mayorACinco(listaPalabras);
            System.out.print("\nLa lista de palabras que cumplen con la condicion son \n");
            for (String palabraActual : listaPalabrasCondicion) {
                System.out.print("\n"+palabraActual);
            }
            System.out.print("\n --------------------------------------------------------------------------\n");
            Thread.sleep(5*1000);
            System.out.print("\nEsta funcion evalua el promedio de un grupo de estudiantes y entrega varios datos\n");
            List<Estudiante> estudiantes = new ArrayList<>();
            estudiantes.add(new Estudiante("Juan", "Carmona", 4.5));
            estudiantes.add(new Estudiante("Daniel", "Triana", 3.5));
            estudiantes.add(new Estudiante("Felipe", "Reyes", 4.8));
            estudiantes.add(new Estudiante("Andrea", "Moreno", 3.95));
            estudiantes.add(new Estudiante("Jose", "Guzman", 2.5));
            estudiantes.add(new Estudiante("Karen", "Rodriguez", 3.2));
            estudiantes.add(new Estudiante("Esteban", "Parra", 4.1));
            estudiantes.add(new Estudiante("Juan", "Bustos", 4.3));
            estudiantes.add(new Estudiante("Ivan", "Marroquin", 4.0));

            System.out.print("\nLa lista de estudiantes es: \n");
            for (Estudiante estudianteActual : estudiantes) {
                System.out.print("\n Nombre: "+estudianteActual.getNombre()+" Apellido: "+ estudianteActual.getApellido()+" Promedio: "+ estudianteActual.getPromedio());
            }

            System.out.print("\n\nEl promedio de todos los estudiantes es: "+ estudiantes.stream().map( estudiante -> estudiante.getPromedio() )
                                                                            .reduce((double) 0, (sum , prom) -> sum + prom )/estudiantes.stream().count() 
            );

            double maximoPromedio = estudiantes.stream().map( estudiante -> estudiante.getPromedio()).max(Double::compare).get();
            List<Estudiante> estudianteMaximoPromedio = estudiantes.stream().filter( estudiante -> estudiante.getPromedio() == maximoPromedio).collect(Collectors.toList());
            System.out.print("\nEl nombre del estudiante con mayor promedio es: "+ estudianteMaximoPromedio.get(0).getNombre()+" el apellido es: " + estudianteMaximoPromedio.get(0).getApellido());

            System.out.print("\nEl menor promedio es: "+ estudiantes.stream().map( estudiante -> estudiante.getPromedio()).min(Double::compare).get());

            System.out.print("\n\nMuchas gracias\n");
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    static int suma(int numero){
        if (numero < 10) {
            return numero%10;
        }
        return numero%10 + suma(numero/10);   
    }

    static List<Double> raices(List<Double> lista){

        List<Double> raices =  lista.stream()
                                    .map( actual -> Math.sqrt(actual) )
                                    .collect(Collectors.toList());
        return raices;

    }

    
    static int factorial(double numero) {
        return IntStream.rangeClosed(1, (int)numero).reduce(1, (acumulador, siguienteElemento) -> acumulador * siguienteElemento);
    }

    static List<String> mayorACinco(Set<String> lista){

        List<String> condicion =  lista.stream()
                                    .filter(palabra -> palabra.length() >= 5).collect(Collectors.toList());
        return condicion;

    }
    



    

}
