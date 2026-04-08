/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actvidadenbaseparcial1;


import Controlador.ControladorEstudiante;
import Vista.VistaEstudiante;

public class ActvidadEnBaseParcial1 {
    public static void main(String[] args) {
        VistaEstudiante vista = new VistaEstudiante();
        ControladorEstudiante controlador = new ControladorEstudiante(vista);
        controlador.iniciar();
    }
}
