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
 * @author Alejandro Couoh Haas <your.name at your.org>
 */


@Entity
@Table(name = "rol_privilegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrivRol.findAll", query = "SELECT p FROM PrivRol p"),
    @NamedQuery(name = "PriviRol.findByIdRol", query = "SELECT p FROM PrivRol p WHERE p.idRol = :idRol"),
    @NamedQuery(name = "PriviRol.findByIdPrivilegio", query = "SELECT p FROM Privilegios p WHERE p.privilegio = :privilegio")})
public class PrivRol implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_privilegio")
    
    private Integer idRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_rol")
    private Integer idprivilegio;
    
    public PrivRol(){
        
    }
    
    public PrivRol(Integer idRol) {
        this.idRol = idRol;
    }

    public PrivRol(Integer idRol, Integer idPriv) {
        this.idRol = idRol;
        this.idprivilegio = idPriv;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the idprivilegio
     */
    public Integer getIdprivilegio() {
        return idprivilegio;
    }

    /**
     * @param idprivilegio the idprivilegio to set
     */
    public void setIdprivilegio(Integer idprivilegio) {
        this.idprivilegio = idprivilegio;
    }
    
    
}
