/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.Usercontroller;
import Modelo.User;
import java.util.Date;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas
 */
public class Test {
    
    public static void main(String[] args) {
        IUser user = new Usercontroller();
        Date fecha = new Date();
        fecha.setDate(19);
        fecha.setMonth(7);
        fecha.setYear(1988);
        User u = new User();
        u.setName("Alejandro");
        u.setLname("Couoh");
        u.setSlastname("Haas");
        u.setBdate(fecha);
        u.setAddress("Av. Colosio");
        u.setCity("Campche");
        u.setState("Campeche");
        u.setContry("Mexico");
        user.save(u);
    }
}
