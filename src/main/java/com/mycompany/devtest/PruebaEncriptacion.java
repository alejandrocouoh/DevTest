/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Configuracion.Seguridad;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class PruebaEncriptacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena = "prueba";
        Seguridad encriptar = new Seguridad();
        String cadena_encriptada = encriptar.encriptarMD5(cadena);
        System.out.println(cadena_encriptada);
        // TODO code application logic here
    }
    
}
