/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.RolUser;
import Modelo.UserRouserPK;

/**
 *
 * @author Towhi
 */
public interface IRolUser {
    UserRouserPK save(UserRouserPK userRPK);
    RolUser findvyId(int id);
}
