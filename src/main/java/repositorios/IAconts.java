/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositorios;

import Modelo.Acconts;
import java.util.List;

/**
 *
 * @author Alejandro Couoh Haas
 */
public interface IAconts {
    
    Acconts save(Acconts acconts);
    Acconts edit(Acconts acconts);
    Acconts findbyId(int id);
    Acconts findbyEmail(String email);
    List<Acconts> users();
    void delete(int i);
    void closeSesion();
}
