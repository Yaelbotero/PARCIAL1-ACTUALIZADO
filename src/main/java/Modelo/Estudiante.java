/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Estudiante extends Persona {
    private double notaDesarrollo;
    private double notaMatematica;

    public Estudiante(String nombre, int codigo, double notaDesarrollo, double notaMatematica) {
        super(nombre, codigo);
        this.notaDesarrollo = notaDesarrollo;
        this.notaMatematica = notaMatematica;
    }

    // Sobrecarga: sin notas (inicia en 0)
    public Estudiante(String nombre, int codigo) {
        this(nombre, codigo, 0.0, 0.0);
    }

    public double calcularDefinitiva() {
        return (notaDesarrollo * 0.55) + (notaMatematica * 0.45);
    }

    public String obtenerEstado() {
        return (calcularDefinitiva() >= 3.5) ? "SI APRUEBA" : "NO APRUEBA";
    }

    public double getNotaDesarrollo() { return notaDesarrollo; }
    public void setNotaDesarrollo(double n) { this.notaDesarrollo = n; }
    public double getNotaMatematica() { return notaMatematica; }
    public void setNotaMatematica(double n) { this.notaMatematica = n; }

    // Polimorfismo
    @Override
    public String obtenerInfo() {
        return super.obtenerInfo() +
               " | Des: " + String.format("%.2f", notaDesarrollo) +
               " | Mat: " + String.format("%.2f", notaMatematica) +
               " | Def: " + String.format("%.2f", calcularDefinitiva()) +
               " | " + obtenerEstado();
    }
}
