/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.Privilegios;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public interface IPrivilegios{
    
    Privilegios save(Privilegios p);
    Privilegios update(Privilegios p);
    Privilegios findbyId(int id);
    void delete(Privilegios p);
    public List<Privilegios> privilegios();
    void close();
    
}
