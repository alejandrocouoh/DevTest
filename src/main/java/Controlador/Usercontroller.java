/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas
 */
public class Usercontroller implements IUser {

    private EntityManager emf;

    public Usercontroller() {
        emf = Connectiondb.conection();
    }

    @Override
    public User save(User user) {
        try {
            emf.getTransaction().begin();
            emf.persist(user);
            emf.getTransaction().commit();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return user;
    }

    @Override
    public User edit(User user) {
        try {
            User user2 = emf.find(User.class, user.getIdUser());
            emf.getTransaction().begin();
            if (emf.contains(user2)) {
                emf.merge(user);
                emf.getTransaction().commit();
                System.out.println("Datos Actualizados");
            } else {
                    System.out.println("No se pudo actualizar");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return user;
    }

    @Override
    public User findbyId(int id) {
        User u = null;
        try{
            u = emf.find(User.class, id);
        }catch(Exception error){
            System.out.println("Mensaje: "+ error.getMessage());
        }    
        return u;
    }

    @Override
    public List<User> users() {
        List<User> listusers = null;
        try{
            Query query = emf.createNamedQuery("User.findAll");
            listusers = query.getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listusers;
    }

    @Override
    public void delete(int i) {
        try{
            User u = emf.find(User.class, i);
            emf.getTransaction().begin();
            emf.remove(u);
            emf.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Mensaje de error: "+e.getMessage());
        }
    }

    @Override
    public void closeSession() {
        emf.close();
    }

    
}
