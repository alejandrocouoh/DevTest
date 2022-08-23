/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Configuracion.Connectiondb;
import Modelo.RolPrivilegio;
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
    
    private static EntityManager emf;
        
    public PrivRolController(){
        emf = Connectiondb.conection();
    }
    
    @Override
    public RolPrivilegio save(RolPrivilegio pr) {
                try {
            emf.getTransaction().begin();
            emf.persist(pr);
            emf.getTransaction().commit();
            System.out.println("Guardado");
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return pr;
    }

    @Override
    public RolPrivilegio edit(RolPrivilegio PR) {
        try {
            RolPrivilegio pr = emf.find(RolPrivilegio.class, PR.getIdRol());
            emf.getTransaction().begin();
            if (emf.contains(pr)) {
                emf.merge(pr);
                emf.getTransaction().commit();
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
    public List<RolPrivilegio> findAll() {
        List<RolPrivilegio> listar = null;
        try {
            Query query = emf.createNamedQuery("RolPrivilegio.findAll");
            listar = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listar;
    }

    @Override
    public List<RolPrivilegio> findbyId(int id) {
        List<RolPrivilegio> pr = new ArrayList<>();
        try{
            Query query = emf.createNamedQuery("PriviRol.findByIdRol");
            pr = query.getResultList();
        }catch(Exception e){
            System.out.println("Mensaje de error: " + e.getMessage());
        }
//        PrivRol pr = null;
//        try {
//            pr = emf.find(PrivRol.class, id);
//            emf.close();
//        } catch (Exception error) {
//            System.out.println("Mensaje: " + error.getMessage());
//        }
        return pr;
    }

    @Override
    public void delete(int id) {
        try {
            RolPrivilegio pr = emf.find(RolPrivilegio.class, id);
            emf.getTransaction().begin();
            emf.remove(pr);
            emf.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    @Override
    public List<RolPrivilegio> findbyIdRol(int i) {
        /* Esta funcion busca la lista de privilegios o modulos que estan asigandos
        al rol de usuario*/
        List<RolPrivilegio> listar = findAll();//Se listan todos los privilegios asignados al rol de usuario
        List<RolPrivilegio> consulta = new ArrayList<>();// se crea una nueva lista
        for(RolPrivilegio p : listar){//se recorre la lista
            if(p.getIdRol() == i)consulta.add(p);/*Se compara si el id que se paso como párametro
            con  el id de la posicion en la que se encuentra al recorrer la lista, si  son iguales 
            se crea una nueva lista con esos elementos que son los que se van a retornar.
            */ 
        }
        
        return consulta;
    }
    
    @Override
    public void closeSession(){
        emf.close();
    }
    
}
