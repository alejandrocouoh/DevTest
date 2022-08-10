/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.RolUsercontroller;
import Modelo.RolUser;
import repositorios.IRolUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class TestRoles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         IRolUser acconts = new RolUsercontroller();
        RolUser accont = acconts.findbyId(30);
        System.out.println(accont.getIdRoll());
        System.out.println(accont.getRolName());
//        System.out.println(accont.getPassword());
//        System.out.println(accont.getPhone());
//        System.out.println(accont.getRol());
//        System.out.println(accont.getSession());  
        // TODO code application logic here
    }
    
}
