/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.User;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas
 */
public interface IUser {
    
    User save(User user);
    User edit(User user);
    User findbyId(int id);
    List<User> users();
    void delete(int i);
    
}
