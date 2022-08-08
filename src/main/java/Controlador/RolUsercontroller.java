/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.RolUser;
import Modelo.UserRouserPK;
import javax.persistence.EntityManager;
import repositorios.IRolUser;

/**
 *
 * @author Towhi
 */
public class RolUsercontroller implements IRolUser{

    private EntityManager emf;
    
    public RolUsercontroller() {
        emf = Connectiondb.conection();
    }

    @Override
    public UserRouserPK save(UserRouserPK userRPK) {
        try {
            emf.getTransaction().begin();
            emf.persist(userRPK);
            emf.getTransaction().commit();
            emf.close();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return userRPK;
    }

    @Override
    public RolUser findvyId(int id) {
        RolUser user = null;
        try{
            user = emf.find(RolUser.class, id);
        }catch(Exception e){
            System.out.println("Mensaje de error: "+e.getMessage());
        }
        return user;
    }
    
}
