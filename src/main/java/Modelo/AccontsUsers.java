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

/**
 *
 * @author Alejandro Couoh Haas
 */
@Entity
@Table(name = "acconts_users")
@NamedQueries({
    @NamedQuery(name = "AccontsUsers.findAll", query = "SELECT a FROM AccontsUsers a")})
public class AccontsUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccontsUsersPK accontsUsersPK;

    public AccontsUsers() {
    }

    public AccontsUsers(AccontsUsersPK accontsUsersPK) {
        this.accontsUsersPK = accontsUsersPK;
    }

    public AccontsUsers(int userId, int accountId) {
        this.accontsUsersPK = new AccontsUsersPK(userId, accountId);
    }

    public AccontsUsersPK getAccontsUsersPK() {
        return accontsUsersPK;
    }

    public void setAccontsUsersPK(AccontsUsersPK accontsUsersPK) {
        this.accontsUsersPK = accontsUsersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accontsUsersPK != null ? accontsUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccontsUsers)) {
            return false;
        }
        AccontsUsers other = (AccontsUsers) object;
        if ((this.accontsUsersPK == null && other.accontsUsersPK != null) || (this.accontsUsersPK != null && !this.accontsUsersPK.equals(other.accontsUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.AccontsUsers[ accontsUsersPK=" + accontsUsersPK + " ]";
    }
    
}
