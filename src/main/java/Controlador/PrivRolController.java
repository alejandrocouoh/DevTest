/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.PrivRol;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import repositorios.IPrivRol;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class PrivRolController implements IPrivRol{
    
    private EntityManager emf;
        
    public PrivRolController(){
        emf = Connectiondb.conection();
    }
    
    @Override
    public PrivRol save(PrivRol pr) {
                try {
            emf.getTransaction().begin();
            emf.persist(pr);
            emf.getTransaction().commit();
            emf.close();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return pr;
    }

    @Override
    public PrivRol edit(PrivRol PR) {
        try {
            PrivRol pr = emf.find(PrivRol.class, PR.getIdRol());
            emf.getTransaction().begin();
            if (emf.contains(pr)) {
                emf.merge(pr);
                emf.getTransaction().commit();
                emf.close();
                System.out.println("Datos Actualizados");
            } else {
                System.out.println("No se pudo actualizar");
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return PR;
    }

    @Override
    public List<PrivRol> findAll() {
        List<PrivRol> listar = null;
        try {
            Query query = emf.createNamedQuery("PrivRol.findAll");
            listar = query.getResultList();
            emf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listar;
    }

    @Override
    public PrivRol findbyIdRol(int id) {
        PrivRol pr = null;
        try {
            pr = emf.find(PrivRol.class, id);
            emf.close();
        } catch (Exception error) {
            System.out.println("Mensaje: " + error.getMessage());
        }
        return pr;
    }

    @Override
    public void delete(int id) {
        try {
            PrivRol pr = emf.find(PrivRol.class, id);
            emf.getTransaction().begin();
            emf.remove(pr);
            emf.getTransaction().commit();
            emf.close();
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    @Override
    public List<PrivRol> findbyId(int i) {
        List<PrivRol> listar = findAll();
        List<PrivRol> consulta = new ArrayList<>();
        for(PrivRol p : listar){
            if(p.getIdRol()==i)consulta.add(p);
        }
        
        return consulta;
    }
    
}
