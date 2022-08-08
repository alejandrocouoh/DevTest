/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;


import Modelo.AccontsUsersPK;
import Modelo.User;

/**
 *
 * @author Alejandro Couoh Haas
 */
public interface IAccontsUser {
    
    AccontsUsersPK save(AccontsUsersPK pk);
    User findbyId(int id);
    //List<Acconts> users();
    //void delete(int i);
    
}
