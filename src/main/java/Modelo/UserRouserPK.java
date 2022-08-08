/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Towhi
 */
@Embeddable
public class UserRouserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol_user")
    private int idRolUser;

    public UserRouserPK() {
    }

    public UserRouserPK(int idUser, int idRolUser) {
        this.idUser = idUser;
        this.idRolUser = idRolUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRolUser() {
        return idRolUser;
    }

    public void setIdRolUser(int idRolUser) {
        this.idRolUser = idRolUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idRolUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRouserPK)) {
            return false;
        }
        UserRouserPK other = (UserRouserPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idRolUser != other.idRolUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UserRouserPK[ idUser=" + idUser + ", idRolUser=" + idRolUser + " ]";
    }
    
}
