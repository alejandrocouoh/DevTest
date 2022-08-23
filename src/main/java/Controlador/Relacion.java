/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Acconts;
import Modelo.AccontsUsers;
import Modelo.AccontsUsersPK;
import Modelo.User;
import java.util.Iterator;
import java.util.List;
import repositorios.IAccontsUser;
import repositorios.IAconts;
import repositorios.IUser;

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
public class Relacion {
    
    private String correo;
    private User user;
    private IUser control_usuarios;
    private IAconts control_cuentas;
    private AccontsUsersPK cuenta_usuario;
    private AccontsUsers relacion;
    private IAccontsUser control_cuenta_usuario;
    
    public Relacion(){
        
    }
    
    public Relacion(String email, User usuario){
        this.correo = email;
        this.user = usuario;
    }
    
    public void establecer_relacion(String correo, User user){
        int id_usuario = encontrar_IdUsuario(user);
        int id_cuenta = encontrar_IdCuenta(correo);
//        cuenta_usuario = new AccontsUsersPK(id_usuario, id_cuenta);
        relacion = new AccontsUsers(id_usuario, id_cuenta);
        control_cuenta_usuario = new AccontsUsercontroller();
        control_cuenta_usuario.save(relacion);
    }
    
    public int encontrar_IdUsuario(User u){
        control_usuarios = new Usercontroller();
        List<User> lista_usuarios = control_usuarios.users();
        Iterator<User> iterador  = lista_usuarios.iterator();
        int Id = 0;
        while(iterador.hasNext()){
            User referencia = iterador.next();
            if(referencia.getName().equals(u.getName())& referencia.getLname().equals(u.getLname()) &
                    referencia.getSlastname().equals(u.getSlastname())) Id = referencia.getIdUser();
        }
        return Id;
    }
    
    public int encontrar_IdCuenta(String e){
        control_cuentas = new Accontscotroller();
        List<Acconts> lista_cuentas = control_cuentas.users();
        Iterator<Acconts> iterador = lista_cuentas.iterator();
        int id = 0;
        while(iterador.hasNext()){
            Acconts referencia_cuenta = iterador.next();
            if(referencia_cuenta.getEmail().equals(e)) id = referencia_cuenta.getIdAccont();
        }
        return id;
    }
    
}
