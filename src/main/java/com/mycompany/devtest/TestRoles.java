/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.RolUsercontroller;
import Modelo.RolUser;
import java.util.Iterator;
import java.util.List;
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
        RolUser accont = acconts.findbyId(12);
        System.out.println(accont.getIdRoll());
        System.out.println(accont.getRolName());
        
        accont.setRolName("Super usuario");
        
        
        acconts.edit(accont);

        System.out.println(accont.getIdRoll());
        System.out.println(accont.getRolName());
        
        
        
//        System.out.println(accont.getPassword());
//        System.out.println(accont.getPhone());
//        System.out.println(accont.getRol());
//        System.out.println(accont.getSession());  

//          IRolUser acconts = new RolUsercontroller();
//          List<RolUser> lista_roluser = acconts.rol_users();
//          Iterator<RolUser> iterador = lista_roluser.iterator();
//          while(iterador.hasNext()){
//              RolUser rol_u = iterador.next();
//              System.out.print(rol_u.getIdRoll()+ " ");
//              System.out.println(rol_u.getRolName());
//          }
//            acconts.delete(26);

            
        // TODO code application logic here
    }
    
}
