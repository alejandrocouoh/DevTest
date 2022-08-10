/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.Privilegioscontroller;
import Modelo.Privilegios;
import java.util.List;
import repositorios.IPrivilegios;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class PruebaPrivilegios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IPrivilegios ipermisos = new Privilegioscontroller();
        List<Privilegios> lprivilegios = ipermisos.privilegios();
        //Privilegios permisos;
        for (Privilegios p : lprivilegios) {
            System.out.println(p.getIdPrivilegio());
            System.out.println(p.getPrivilegio());
        }

    }
    
}
