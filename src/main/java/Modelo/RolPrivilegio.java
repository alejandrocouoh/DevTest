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

/**
 *
 * @author Alejandro Couoh Haas <your.name at your.org>
 */
@Entity
@Table(name = "rol_privilegio")
@NamedQueries({
    @NamedQuery(name = "RolPrivilegio.findAll", query = "SELECT r FROM RolPrivilegio r")})
public class RolPrivilegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rol")
    private int idRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_privilegio")
    private int idPrivilegio;

    public RolPrivilegio() {
    }

    public RolPrivilegio(Integer id) {
        this.id = id;
    }

    public RolPrivilegio(Integer id, int idRol, int idPrivilegio) {
        this.id = id;
        this.idRol = idRol;
        this.idPrivilegio = idPrivilegio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPrivilegio)) {
            return false;
        }
        RolPrivilegio other = (RolPrivilegio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RolPrivilegio[ id=" + id + " ]";
    }
    
}
