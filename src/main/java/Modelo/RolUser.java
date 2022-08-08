/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Towhi
 */
@Entity
@Table(name = "rol_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolUser.findAll", query = "SELECT r FROM RolUser r"),
    @NamedQuery(name = "RolUser.findByIdRoll", query = "SELECT r FROM RolUser r WHERE r.idRoll = :idRoll"),
    @NamedQuery(name = "RolUser.findByRolName", query = "SELECT r FROM RolUser r WHERE r.rolName = :rolName")})
public class RolUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roll")
    private Integer idRoll;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rol_name")
    private String rolName;

    public RolUser() {
    }

    public RolUser(Integer idRoll) {
        this.idRoll = idRoll;
    }

    public RolUser(Integer idRoll, String rolName) {
        this.idRoll = idRoll;
        this.rolName = rolName;
    }

    public Integer getIdRoll() {
        return idRoll;
    }

    public void setIdRoll(Integer idRoll) {
        this.idRoll = idRoll;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoll != null ? idRoll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolUser)) {
            return false;
        }
        RolUser other = (RolUser) object;
        if ((this.idRoll == null && other.idRoll != null) || (this.idRoll != null && !this.idRoll.equals(other.idRoll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RolUser[ idRoll=" + idRoll + " ]";
    }
    
}
