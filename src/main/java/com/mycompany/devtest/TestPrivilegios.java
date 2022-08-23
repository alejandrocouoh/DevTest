/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.Privilegioscontroller;
import repositorios.IPrivilegios;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class TestPrivilegios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IPrivilegios ip = new Privilegioscontroller();
        System.out.println(ip.findbyId(1).getPrivilegio());
        // TODO code application logic here
    }
    
}
