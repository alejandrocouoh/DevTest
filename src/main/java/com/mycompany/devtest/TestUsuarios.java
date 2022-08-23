/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.Usercontroller;
import Modelo.User;
import java.util.Iterator;
import java.util.List;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class TestUsuarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IUser iusuario = new Usercontroller();
//        List<User> usuarios = iusuario.users();
//        Iterator<User> u = usuarios.iterator();
//        
//        while(u.hasNext()){
//            User usuario = u.next();
//            System.out.print(usuario.getIdUser()+" ");
//            System.out.print(usuario.getName()+" ");
//            System.out.print(usuario.getLname()+" ");
//            System.out.print(usuario.getSlastname()+" ");
//            System.out.print(usuario.getBdate()+" ");
//            System.out.print(usuario.getCity()+" ");
//            System.out.print(usuario.getState()+" ");
//            System.out.print(usuario.getContry()+" ");
//            System.out.println(usuario.getAddress()+" "); 
//        }
        User u = iusuario.findbyId(1);
        System.out.println(u.getName());
        // TODO code application logic here
    }
    
}
