/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

public String pedirTipoEstudiante() {
    String input = JOptionPane.showInputDialog("¿El estudiante tiene beca? (s/n):");
    return (input == null) ? "n" : input.trim();
}

public double pedirPorcentajeBeca() {
    try {
        String input = JOptionPane.showInputDialog("Ingrese el porcentaje de beca (ej: 50.0):");
        return (input == null) ? 0.0 : Double.parseDouble(input);
    } catch (NumberFormatException e) {
        return 0.0;
    }
}
