/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.AccontsUsercontroller;
import Controlador.Accontscotroller;
import Controlador.Usercontroller;
import Modelo.Acconts;
import Modelo.AccontsUsers;
import Modelo.User;
import java.util.Iterator;
import java.util.List;
import repositorios.IAccontsUser;
import repositorios.IAconts;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class CuentaUsuario {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User ref_user;
        Acconts ref_acconts;
        AccontsUsers ref_accontsUsser;

        IAconts cuentas = new Accontscotroller();
        IUser usuarios = new Usercontroller();
        IAccontsUser relacion = new AccontsUsercontroller();

        List<User> lista_usuarios = usuarios.users();
        Iterator<User> iterador_lista_usuarios = lista_usuarios.iterator();

        List<AccontsUsers> lista_relaciones = relacion.users();
        Iterator<AccontsUsers> iterador_lista_tablas = lista_relaciones.iterator();
        
        while(iterador_lista_tablas.hasNext()){
                                    ref_accontsUsser = iterador_lista_tablas.next();
//                                    System.out.print(ref_accontsUsser.getAccontsUsersPK().getUserId()+" ");
//                                    System.out.println(ref_accontsUsser.getAccontsUsersPK().getAccountId()+" ");
                                    ref_user = usuarios.findbyId(ref_accontsUsser.getAccontsUsersPK().getUserId());
                                    ref_acconts = cuentas.findbyId(ref_accontsUsser.getAccontsUsersPK().getAccountId());
                                    System.out.print(ref_user.getName());
                                    System.out.print(ref_user.getLname());
                                    System.out.print(ref_user.getSlastname());
                                    System.out.print(ref_user.getBdate());
                                    System.out.print(ref_acconts.getEmail());
                                    System.out.print(ref_acconts.getPhone());
        }
        // TODO code application logic here
    }
    
}
