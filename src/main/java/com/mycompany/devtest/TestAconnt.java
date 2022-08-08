/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.Accontscotroller;
import Modelo.Acconts;
import repositorios.IAconts;

/**
 *
 * @author Towhi
 */
public class TestAconnt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IAconts acconts = new Accontscotroller();
        Acconts accont = acconts.findbyEmail("alejandro.couoh@gmail.com");
        System.out.println(accont.getIdAccont());
        System.out.println(accont.getEmail());
        System.out.println(accont.getPassword());
        System.out.println(accont.getPhone());
        System.out.println(accont.getRol());
        System.out.println(accont.getSession());        
        // TODO code application logic here
    }

}
