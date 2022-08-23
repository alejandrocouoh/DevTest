/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.RolPrivilegio;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public interface IPrivRol {
    
    RolPrivilegio save(RolPrivilegio PR);
    RolPrivilegio edit(RolPrivilegio PR);
    List<RolPrivilegio> findAll();
    List<RolPrivilegio> findbyIdRol(int id);
    List<RolPrivilegio> findbyId(int id);
    void delete(int id);
    void closeSession();
    
}
