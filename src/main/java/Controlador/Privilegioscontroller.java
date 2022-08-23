/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.Privilegios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repositorios.IPrivilegios;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class Privilegioscontroller implements IPrivilegios{
    
    private EntityManager emf;
    
    public Privilegioscontroller(){
        emf = Connectiondb.conection();
    }

    @Override
    public Privilegios save(Privilegios p) {
        try {
            emf.getTransaction().begin();
            emf.persist(p);
            emf.getTransaction().commit();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return p;
    }

    @Override
    public Privilegios update(Privilegios p) {
        try {
            Privilegios permisos = emf.find(Privilegios.class, p.getIdPrivilegio());
            emf.getTransaction().begin();
            if (emf.contains(permisos)) {
                emf.merge(p);
                emf.getTransaction().commit();
                System.out.println("Datos Actualizados");
            } else {
                    System.out.println("No se pudo actualizar");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return p;
    }

    @Override
    public Privilegios findbyId(int id) {
        Privilegios p = null;
        try{
            p = emf.find(Privilegios.class, id);
        }catch(Exception error){
            System.out.println("Mensaje: "+ error.getMessage());
        }    
        return p;
    }

    @Override
    public void delete(Privilegios p) {
        try {
            Privilegios permisos = emf.find(Privilegios.class, p);
            emf.getTransaction().begin();
            emf.remove(permisos);
            emf.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    @Override
    public List<Privilegios> privilegios() {
        List<Privilegios> listusers = null;
        try{
            Query query = emf.createNamedQuery("Privilegios.findAll");
            listusers = query.getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return listusers;
    }

    @Override
    public void close() {
        emf.close();
    }
}
