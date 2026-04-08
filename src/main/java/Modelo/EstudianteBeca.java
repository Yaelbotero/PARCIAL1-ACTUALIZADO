/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class EstudianteBeca extends Estudiante {
    private double porcentajeBeca; 

    public EstudianteBeca(String nombre, int codigo, double notaDes, double notaMat, double porcentajeBeca) {
        super(nombre, codigo, notaDes, notaMat);
        this.porcentajeBeca = porcentajeBeca;
    }

    // Sobrecarga: beca por defecto del 50%
    public EstudianteBeca(String nombre, int codigo, double notaDes, double notaMat) {
        this(nombre, codigo, notaDes, notaMat, 50.0);
    }

    public double getPorcentajeBeca() { return porcentajeBeca; }
    public void setPorcentajeBeca(double p) { this.porcentajeBeca = p; }

    // Polimorfismo: debe mantener definitiva >= 3.5 Y tener beca > 0
    @Override
    public String obtenerEstado() {
        if (calcularDefinitiva() >= 3.5 && porcentajeBeca > 0)
            return "SI APRUEBA (Becado " + porcentajeBeca + "%)";
        else if (calcularDefinitiva() < 3.5)
            return "NO APRUEBA - Beca en riesgo";
        else
            return "SI APRUEBA";
    }

    @Override
    public String obtenerInfo() {
        return super.obtenerInfo() + " | Beca: " + porcentajeBeca + "%";
    }
}
