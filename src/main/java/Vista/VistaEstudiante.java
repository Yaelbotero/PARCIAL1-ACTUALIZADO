/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;

public class VistaEstudiante {

    public int mostrarMenu() {
        String menu = "---- Menú Principal ----\n"
                + "1. Definir la cantidad de estudiantes\n"
                + "2. Agregar estudiante\n"
                + "3. Lista estudiante\n"
                + "4. Filtrar por nota\n"
                + "5. Incrementar nota de Desarrollo\n"
                + "6. Modificar nota\n"
                + "7. Salir\n\n"
                + "Seleccione una opción: ";
        try {
            String opc = JOptionPane.showInputDialog(menu);
            return (opc == null) ? 7 : Integer.parseInt(opc);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String pedirNombre() {
        return JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
    }

    public int pedirCodigo() {
        try {
            String input = JOptionPane.showInputDialog("Ingrese el codigo (>21000) del estudiante: ");
            return (input == null) ? -1 : Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double pedirNota(String materia) {
        try {
            String input = JOptionPane.showInputDialog("Ingrese la nota de " + materia + " (0.0 a 5.0):");
            return (input == null) ? -1.0 : Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }

    public int pedirCantidadTotal() {
        try {
            String input = JOptionPane.showInputDialog("¿Cuantos estudiantes manejara?: ");
            return (input == null) ? 0 : Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double pedirNotaLimite() {
        try {
            String input = JOptionPane.showInputDialog("Ingrese la nota limite (0.0 - 5.0):");
            return (input == null) ? -1.0 : Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }

    public double pedirCifraIncremento() {
        try {
            String input = JOptionPane.showInputDialog("Ingrese valor a incrementar (0.0 a 0.5):");
            return (input == null) ? -1.0 : Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return -1.0;
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // ── Métodos nuevos ───Añadir con respecto a lo solicitado en la actividad────────
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
}
