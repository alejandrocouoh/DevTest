/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.devtest;

import Controlador.PrivRolController;
import Controlador.Privilegioscontroller;
import Modelo.Privilegios;
import Modelo.RolPrivilegio;
import java.util.List;
import repositorios.IPrivRol;
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
        
        IPrivRol lista_pr = new PrivRolController();
        List<RolPrivilegio> lista_priv_rol = lista_pr.findbyIdRol(1);
        
        if(lista_priv_rol.isEmpty()){
            System.out.println("La lista esta vacia.");
            //debo guardadar
            RolPrivilegio rp = new RolPrivilegio();
            rp.setIdRol(26);
            rp.setIdPrivilegio(1);
            lista_pr.save(rp);
        }else
            System.out.println("La lista contiene elementos.");
            //debo editar
            int identificador = 0;
            for(Privilegios privilegio : lprivilegios){//se recorre la lista de privilegios existente
                if(privilegio.getIdPrivilegio() != lista_priv_rol.get(identificador).getIdPrivilegio()){/*
                    Se compara si la lista de privilegios existente es diferente al privilegio del rol
                    */
                    System.out.print(privilegio.getIdPrivilegio()+" ");
                    System.out.print(privilegio.getPrivilegio()+" ");
                    System.out.print(lista_priv_rol.get(identificador).getId()+ " ");
                    System.out.print(lista_priv_rol.get(identificador).getIdRol()+" ");
                    System.out.println(lista_priv_rol.get(identificador).getIdPrivilegio()+" ");
                    lista_pr.edit(lista_priv_rol.get(identificador));/*
                    Se guarda el nuevo privilegio asignado
                    */
                    identificador++;
                }else{
                    lista_pr.delete(lista_priv_rol.get(identificador).getId());
                    System.out.print(privilegio.getIdPrivilegio()+" ");
                    System.out.print(privilegio.getPrivilegio()+" ");
                    System.out.print(lista_priv_rol.get(identificador).getId()+ " ");
                    System.out.print(lista_priv_rol.get(identificador).getIdRol()+" ");
                    System.out.println(lista_priv_rol.get(identificador).getIdPrivilegio()+" ");
                    lista_pr.save(lista_priv_rol.get(identificador));
                    lista_pr.closeSession();
                    /*
                    Se elimina el privilegio en caso de 
                    */
                    identificador++;
                }                
            }
            
            lista_pr.closeSession();
        //Privilegios permisos;
//        for (Privilegios p : lprivilegios) {
//            System.out.println(p.getIdPrivilegio());
//            System.out.println(p.getPrivilegio());
//        }
        
    }
    
}
