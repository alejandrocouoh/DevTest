/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.AccontsUsers;
import Modelo.AccontsUsersPK;
import Modelo.User;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public AccontsUsers save(AccontsUsers au) {
        try{
            emf.getTransaction().begin();
            emf.persist(au);
            emf.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Mensaje de error: "+e.getMessage());
        }
        return au;
    }

    @Override
    public List<AccontsUsers> users() {
        List<AccontsUsers> lista_relacinada = null;
        try {
            Query query = emf.createNamedQuery("AccontsUsers.findAll");
            lista_relacinada = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista_relacinada;
    }

    @Override
    public void delete(int i) {
        try {
            List<AccontsUsers> lista_cuenta_usuario = users();
            Iterator<AccontsUsers> iteracion = lista_cuenta_usuario.iterator();
            while(iteracion.hasNext()){
                AccontsUsers au = iteracion.next();
                if(au.getAccontsUsersPK().getUserId() == i){
                    emf.getTransaction().begin();
                    emf.remove(au);
                    emf.getTransaction().commit();
                } 
            }
//            AccontsUsers u = emf.find(AccontsUsers.class, i);
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    @Override
    public int findbyIdUser(int i) {
         List<AccontsUsers> lista_relacinada = users();
         Iterator<AccontsUsers> iterador = lista_relacinada.iterator();
         AccontsUsersPK cuentausuario;
         int id_usuario = 0;
         while(iterador.hasNext()){
             cuentausuario = iterador.next().getAccontsUsersPK();
             if(cuentausuario.getAccountId() == i)
                 id_usuario = cuentausuario.getUserId();
         }
        return id_usuario;
    }
}
