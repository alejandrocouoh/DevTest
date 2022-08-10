/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.RolUser;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public interface IRolUser {
    RolUser save(RolUser u);
    RolUser edit(RolUser u);
    RolUser findbyId(int id);
    List<RolUser> rol_users();
    boolean delete(int id);
}
