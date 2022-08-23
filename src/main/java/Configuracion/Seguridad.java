/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class Seguridad {
    
    public Seguridad(){
        
    }
    
    public String encriptarMD5(String cadena){
        String encriptar_cadena = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encriptar_Bytes = md.digest(cadena.getBytes());
            BigInteger numero = new BigInteger(1, encriptar_Bytes);
            encriptar_cadena = numero.toString(16);
            while(encriptar_cadena.length()<32){
                encriptar_cadena = "0" + encriptar_cadena;
            }
        }catch(Exception e){
            System.out.println("Mesaje de error: "+ e.getMessage());
        }
                    return encriptar_cadena;
    }
}
