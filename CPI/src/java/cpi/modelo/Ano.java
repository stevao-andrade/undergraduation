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
@Table(name = "ano")
public class Ano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ano;

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ano other = (Ano) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.ano == null) ? (other.ano != null) : !this.ano.equals(other.ano)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + (this.ano != null ? this.ano.hashCode() : 0);
        return hash;
    }
}
