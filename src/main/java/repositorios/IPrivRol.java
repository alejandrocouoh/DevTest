/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.PrivRol;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public interface IPrivRol {
    
    PrivRol save(PrivRol PR);
    PrivRol edit(PrivRol PR);
    List<PrivRol> findAll();
    PrivRol findbyIdRol(int id);
    List<PrivRol> findbyId(int id);
    void delete(int id);
    
}
