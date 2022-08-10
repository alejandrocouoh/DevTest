/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.AccontsUsersPK;
import Modelo.User;
import javax.persistence.EntityManager;
import repositorios.IAccontsUser;

/**
 *
 * @author Alejandro Couoh Haas
 */
public class AccontsUsercontroller implements IAccontsUser{

    private final EntityManager emf;
    
    public AccontsUsercontroller(){
        emf = Connectiondb.conection();
    }

    @Override
    public AccontsUsersPK save(AccontsUsersPK aupk) {
        try {
            emf.getTransaction().begin();
            emf.persist(aupk);
            emf.getTransaction().commit();
            emf.close();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return aupk;
    }

    @Override
    public User findbyId(int id) {
        User user = null;
        try{
            user = emf.find(User.class, id);
        }catch(Exception e){
            System.out.println("Mensaje de error: "+e.getMessage());
        }
        return user;
    }
    
   
    
}
