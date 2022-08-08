/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Towhi
 */
@Entity
@Table(name = "user_rouser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRouser.findAll", query = "SELECT u FROM UserRouser u"),
    @NamedQuery(name = "UserRouser.findByIdUser", query = "SELECT u FROM UserRouser u WHERE u.userRouserPK.idUser = :idUser"),
    @NamedQuery(name = "UserRouser.findByIdRolUser", query = "SELECT u FROM UserRouser u WHERE u.userRouserPK.idRolUser = :idRolUser")})
public class UserRouser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserRouserPK userRouserPK;

    public UserRouser() {
    }

    public UserRouser(UserRouserPK userRouserPK) {
        this.userRouserPK = userRouserPK;
    }

    public UserRouser(int idUser, int idRolUser) {
        this.userRouserPK = new UserRouserPK(idUser, idRolUser);
    }

    public UserRouserPK getUserRouserPK() {
        return userRouserPK;
    }

    public void setUserRouserPK(UserRouserPK userRouserPK) {
        this.userRouserPK = userRouserPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRouserPK != null ? userRouserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRouser)) {
            return false;
        }
        UserRouser other = (UserRouser) object;
        if ((this.userRouserPK == null && other.userRouserPK != null) || (this.userRouserPK != null && !this.userRouserPK.equals(other.userRouserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UserRouser[ userRouserPK=" + userRouserPK + " ]";
    }
    
}
