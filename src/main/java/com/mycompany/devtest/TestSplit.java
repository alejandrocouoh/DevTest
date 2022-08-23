/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class TestSplit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String strMain = "Bienvenido a Guru99";
        String[] arrSplit_3 = strMain.split(" ");   
//        for (int i = 0; i < arrSplit_3.length; i++) {     
            System.out.println(arrSplit_3[0]); 
            System.out.println(arrSplit_3[1]); 
            System.out.println(arrSplit_3[2]);
//        }
        // TODO code application logic here
    }
    
}
