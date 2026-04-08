/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaEstudiante;
import Modelo.Estudiante;
import Modelo.EstudianteBeca;

public class ControladorEstudiante {
    private VistaEstudiante vista;
    private Estudiante[] estudiantes;
    private int contador;

    public ControladorEstudiante(VistaEstudiante vista) {
        this.vista = vista;
        this.estudiantes = new Estudiante[3];
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1: definirTamaño();             break;
                case 2: agregarEstudiante();          break;
                case 3: listarEstudiantes();          break;
                case 4: filtrarPorNota();             break;
                case 5: incrementarNotaDesarrollo();  break;
                case 6: modificarNota();              break;
                case 7: vista.mostrarMensaje("Saliendo del sistema..."); break;
                default: vista.mostrarMensaje("Opción no reconocida."); break;
            }
        } while (opcion != 7);
    }

    private void definirTamaño() {
        int cantidad = vista.pedirCantidadTotal();
        if (cantidad <= 0) {
            vista.mostrarMensaje("Error: La cantidad debe ser mayor a cero.");
            return;
        }
        estudiantes = new Estudiante[cantidad];
        contador = 0;
        vista.mostrarMensaje("Sistema configurado para " + cantidad + " estudiantes.");
    }

    private void agregarEstudiante() {
        if (estudiantes == null) {
            vista.mostrarMensaje("Primero defina la cantidad de estudiantes (opción 1).");
            return;
        }
        if (contador >= estudiantes.length) {
            vista.mostrarMensaje("Capacidad máxima alcanzada.");
            return;
        }

        String nombre = vista.pedirNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            vista.mostrarMensaje("Operación cancelada.");
            return;
        }

        int codigo;
        do {
            codigo = vista.pedirCodigo();
            if (codigo <= 21000) vista.mostrarMensaje("Error: El código debe ser mayor a 21000.");
        } while (codigo <= 21000);

        double notaDes;
        do {
            notaDes = vista.pedirNota("Desarrollo");
            if (notaDes < 0 || notaDes > 5.0) vista.mostrarMensaje("Error: nota entre 0.0 y 5.0");
        } while (notaDes < 0 || notaDes > 5.0);

        double notaMat;
        do {
            notaMat = vista.pedirNota("Matematica");
            if (notaMat < 0 || notaMat > 5.0) vista.mostrarMensaje("Error: nota entre 0.0 y 5.0");
        } while (notaMat < 0 || notaMat > 5.0);

        // ── Nuevo: preguntar si tiene beca ─── Añadido en baase a lo solicitado en la actividad
        Estudiante nuevo;
        String esBecado = vista.pedirTipoEstudiante();
        if (esBecado.equalsIgnoreCase("s")) {
            double beca = vista.pedirPorcentajeBeca();
            nuevo = new EstudianteBeca(nombre, codigo, notaDes, notaMat, beca);
        } else {
            nuevo = new Estudiante(nombre, codigo, notaDes, notaMat);
        }

        estudiantes[contador] = nuevo;
        contador++;
        vista.mostrarMensaje("Estudiante agregado con éxito.");
    }

    private void listarEstudiantes() {
        if (estudiantes == null || contador == 0) {
            vista.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }
        // Ordenar por definitiva ascendente (burbuja)
        for (int i = 0; i < contador - 1; i++)
            for (int j = 0; j < contador - i - 1; j++)
                if (estudiantes[j].calcularDefinitiva() > estudiantes[j + 1].calcularDefinitiva()) {
                    Estudiante temp = estudiantes[j];
                    estudiantes[j] = estudiantes[j + 1];
                    estudiantes[j + 1] = temp;
                }

        String lista = " LISTA DE ESTUDIANTES (ORDEN ASCENDENTE)\n\n";
        for (int i = 0; i < contador; i++)
            lista += estudiantes[i].obtenerInfo() + "\n"; // polimorfismo aquí (Como especifica el profesor)

        vista.mostrarMensaje(lista);
    }

    private void filtrarPorNota() {
        if (estudiantes == null || contador == 0) {
            vista.mostrarMensaje("No hay estudiantes.");
            return;
        }
        double limite = vista.pedirNotaLimite();
        String reporte = "--- ESTUDIANTES SOBRE " + limite + " ---\n";
        for (int i = 0; i < contador; i++)
            if (estudiantes[i].calcularDefinitiva() > limite)
                reporte += estudiantes[i].obtenerInfo() + "\n";
        vista.mostrarMensaje(reporte);
    }

    private void incrementarNotaDesarrollo() {
        if (estudiantes == null || contador == 0) {
            vista.mostrarMensaje("No hay estudiantes para modificar.");
            return;
        }
        double incremento = vista.pedirCifraIncremento();
        if (incremento < 0.0 || incremento > 0.5) {
            vista.mostrarMensaje("El incremento debe estar entre 0.0 y 0.5");
            return;
        }
        for (int i = 0; i < contador; i++) {
            double nueva = estudiantes[i].getNotaDesarrollo() + incremento;
            estudiantes[i].setNotaDesarrollo(nueva > 5.0 ? 5.0 : nueva);
        }
        vista.mostrarMensaje("Incremento aplicado a todos los estudiantes.");
    }

    private void modificarNota() {
        if (estudiantes == null || contador == 0) {
            vista.mostrarMensaje("No hay estudiantes registrados.");
            return;
        }
        int codBusqueda = vista.pedirCodigo();
        for (int i = 0; i < contador; i++) {
            if (estudiantes[i].getCodigo() == codBusqueda) {
                double nuevaDes;
                do {
                    nuevaDes = vista.pedirNota("Nueva nota Desarrollo");
                    if (nuevaDes < 0 || nuevaDes > 5.0) vista.mostrarMensaje("Error: nota entre 0.0 y 5.0");
                } while (nuevaDes < 0 || nuevaDes > 5.0);

                double nuevaMat;
                do {
                    nuevaMat = vista.pedirNota("Nueva nota Matematica");
                    if (nuevaMat < 0 || nuevaMat > 5.0) vista.mostrarMensaje("Error: nota entre 0.0 y 5.0");
                } while (nuevaMat < 0 || nuevaMat > 5.0);

                estudiantes[i].setNotaDesarrollo(nuevaDes);
                estudiantes[i].setNotaMatematica(nuevaMat);
                vista.mostrarMensaje("Notas actualizadas para: " + estudiantes[i].getNombre());
                return;
            }
        }
        vista.mostrarMensaje("Estudiante con código " + codBusqueda + " no encontrado.");
    }
}
