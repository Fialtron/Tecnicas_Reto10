package com.company;

public class Estudiante {
    
    private String nombre;
    private String apellido;
    private double promedio;

    public Estudiante(String nombre, String apellido, double promedio){
        this.nombre =nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

}
