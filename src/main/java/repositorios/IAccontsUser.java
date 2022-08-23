/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;


import Modelo.AccontsUsers;
import Modelo.AccontsUsersPK;
import Modelo.User;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas
 */
public interface IAccontsUser {
    
    AccontsUsersPK save(AccontsUsersPK pk);
    User findbyId(int id);
    int findbyIdUser(int id);
    List<AccontsUsers> users();
    void delete(int i);
    AccontsUsers save(AccontsUsers AU);
    void close();
    
}
