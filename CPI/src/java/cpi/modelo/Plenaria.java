/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author stevao
 */
@Entity
@Table(name = "plenarias")
public class Plenaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idplenarias;
    @Column(name = "plenaria")
    private String plenaria;

    public int getIdplenarias() {
        return idplenarias;
    }

    public void setIdplenarias(int idplenarias) {
        this.idplenarias = idplenarias;
    }
    
    public String getPlenaria() {
        return plenaria;
    }

    public void setPlenaria(String plenaria) {
        this.plenaria = plenaria;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plenaria other = (Plenaria) obj;
        if (this.idplenarias != other.idplenarias) {
            return false;
        }
        if ((this.plenaria == null) ? (other.plenaria != null) : !this.plenaria.equals(other.plenaria)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idplenarias;
        hash = 89 * hash + (this.plenaria != null ? this.plenaria.hashCode() : 0);
        return hash;
    }


}
