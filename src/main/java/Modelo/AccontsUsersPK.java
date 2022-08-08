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
 * @author Alejandro Couoh Haas
 */
@Embeddable
public class AccontsUsersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_id")
    private int accountId;

    public AccontsUsersPK() {
    }

    public AccontsUsersPK(int userId, int accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) accountId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccontsUsersPK)) {
            return false;
        }
        AccontsUsersPK other = (AccontsUsersPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.accountId != other.accountId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.AccontsUsersPK[ userId=" + userId + ", accountId=" + accountId + " ]";
    }
    
}
