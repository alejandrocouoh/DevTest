/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.RolUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repositorios.IRolUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class RolUsercontroller implements IRolUser{
    
    private EntityManager emf;

    public RolUsercontroller() {
        emf = Connectiondb.conection();
    }

    @Override
    public RolUser save(RolUser u) {
        try {
            emf.getTransaction().begin();
            emf.persist(u);
            emf.getTransaction().commit();
            emf.close();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return u;
    }

    @Override
    public RolUser edit(RolUser u) {
        try {
            RolUser acconts2 = emf.find(RolUser.class, u.getIdRoll());
            emf.getTransaction().begin();
            if (emf.contains(acconts2)) {
                emf.merge(u);
                emf.getTransaction().commit();
                emf.close();
                System.out.println("Datos Actualizados");
            } else {
                System.out.println("No se pudo actualizar");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return u;
    }

    @Override
    public RolUser findbyId(int id) {
        RolUser rol = null;
        try {
            rol = emf.find(RolUser.class, id);
            emf.close();
        } catch (Exception error) {
            System.out.println("Mensaje: " + error.getMessage());
        }
        return rol;
    }

    @Override
    public List<RolUser> rol_users() {
        List<RolUser> listarolusers = null;
        try {
            Query query = emf.createNamedQuery("RolUser.findAll");
            listarolusers = query.getResultList();
            emf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listarolusers;
    }

    @Override
    public boolean delete(int id) {
        try {
            RolUser acconts = emf.find(RolUser.class, id);
            emf.getTransaction().begin();
            emf.remove(acconts);
            emf.getTransaction().commit();
            emf.close();
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
        return true;
    }
    
}
