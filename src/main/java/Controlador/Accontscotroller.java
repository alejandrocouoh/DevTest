/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.Acconts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repositorios.IAconts;

/**
 *
 * @author Alejandro Couoh Haas
 */
public class Accontscotroller implements IAconts{

    private EntityManager emf;
    
    public Accontscotroller(){
        emf = Connectiondb.conection();
    }
    
    @Override
    public Acconts save(Acconts acconts) {
        try {
            emf.getTransaction().begin();
            emf.persist(acconts);
            emf.getTransaction().commit();
            emf.close();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return acconts;
    }

    @Override
    public Acconts edit(Acconts acconts) {
        try {
            Acconts acconts2 = emf.find(Acconts.class, acconts.getIdAccont());
            emf.getTransaction().begin();
            if (emf.contains(acconts2)) {
                emf.merge(acconts);
                emf.getTransaction().commit();
                emf.close();
                System.out.println("Datos Actualizados");
            } else {
                    System.out.println("No se pudo actualizar");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return acconts;
    }

    @Override
    public Acconts findbyId(int id) {
        Acconts accont = null;
        try{
            accont = emf.find(Acconts.class, id);
            emf.close();
        }catch(Exception error){
            System.out.println("Mensaje: "+ error.getMessage());
        }    
        return accont;
    }

    @Override
    public Acconts findbyEmail(String string) {
        Acconts accont = null;
        List<Acconts> listaccont = null;
        try{
            Query query = emf.createNamedQuery("Acconts.findAll");
            listaccont = query.getResultList();
            for (Acconts index : listaccont) {
//               if(listaccont.get(index.getIdAccont()).getEmail().equals(string)) accont = listaccont.get(index.getIdAccont());
                 if(index.getEmail().equals(string))accont = index;
            }
        }catch(Exception error){
            System.out.println("Mensaje: "+ error.getMessage());
        }    
        return accont;
    }
    
    

    @Override
    public List<Acconts> users() {
        List<Acconts> listaccont = null;
        try{
            Query query = emf.createNamedQuery("Acconts.findAll");
            listaccont = query.getResultList();
            emf.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listaccont;
    }

    @Override
    public void delete(int i) {
        try{
            Acconts acconts = emf.find(Acconts.class, i);
            emf.getTransaction().begin();
            emf.remove(acconts);
            emf.getTransaction().commit();
            emf.close();
        }catch(Exception e){
            System.out.println("Mensaje de error: "+e.getMessage());
        }
    }
    
}
