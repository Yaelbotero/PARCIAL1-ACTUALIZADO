/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.VistaEstudiante;
import Modelo.Estudiante;
import Modelo.EstudianteBeca; 

public class ControladorEstudiante {
   

    private void agregarEstudiante() {
      

  
        String esBecado = vista.pedirTipoEstudiante(); 
        Estudiante nuevo;

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

}
