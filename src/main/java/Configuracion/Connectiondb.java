/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alejandro Couoh Haas
 */
public class Connectiondb {
    
    private static EntityManagerFactory emf = null;
    
    
    /*Metodo para crear la conexion a la base de datos.*/
    public static EntityManager conection(){
        try{
            if(emf == null){
                emf = Persistence.createEntityManagerFactory("com.mycompany_DevTest_war_1.0-SNAPSHOTPU");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return emf.createEntityManager();
    }
    
    //Metodo para desconectase a la base de datos
    public static void close(EntityManager em){
        if(em !=null){
            em.close();
        }
    }
}
