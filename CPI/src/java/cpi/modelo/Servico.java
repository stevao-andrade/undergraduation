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
@Table(name = "servicos")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idServicos;
    @Column(name = "servico")
    private String servico;

    public int getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (this.idServicos != other.idServicos) {
            return false;
        }
        if ((this.servico == null) ? (other.servico != null) : !this.servico.equals(other.servico)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idServicos;
        hash = 73 * hash + (this.servico != null ? this.servico.hashCode() : 0);
        return hash;
    }
}
