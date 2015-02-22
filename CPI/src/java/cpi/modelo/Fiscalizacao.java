/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author stevao
 */

@Entity
@Table
public class Fiscalizacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String fiscalizado;
    private String tipoFiscalizado;
    private String processo;
    private String anoReferencia;
    private String tipoProcesso;
    private String statusProcesso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFiscalizacao;
    private String observacao;

    public String getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }
    
    public Date getDataFiscalizacao() {
        return dataFiscalizacao;
    }

    public void setDataFiscalizacao(Date dataFiscalizacao) {
        this.dataFiscalizacao = dataFiscalizacao;
    }
    
    public String getFiscalizado() {
        return fiscalizado;
    }

    public void setFiscalizado(String fiscalizado) {
        this.fiscalizado = fiscalizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getStatusProcesso() {
        return statusProcesso;
    }

    public void setStatusProcesso(String statusProcesso) {
        this.statusProcesso = statusProcesso;
    }

    public String getTipoFiscalizado() {
        return tipoFiscalizado;
    }

    public void setTipoFiscalizado(String tipoFiscalizado) {
        this.tipoFiscalizado = tipoFiscalizado;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fiscalizacao other = (Fiscalizacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.fiscalizado == null) ? (other.fiscalizado != null) : !this.fiscalizado.equals(other.fiscalizado)) {
            return false;
        }
        if ((this.tipoFiscalizado == null) ? (other.tipoFiscalizado != null) : !this.tipoFiscalizado.equals(other.tipoFiscalizado)) {
            return false;
        }
        if ((this.processo == null) ? (other.processo != null) : !this.processo.equals(other.processo)) {
            return false;
        }
        if ((this.anoReferencia == null) ? (other.anoReferencia != null) : !this.anoReferencia.equals(other.anoReferencia)) {
            return false;
        }
        if ((this.tipoProcesso == null) ? (other.tipoProcesso != null) : !this.tipoProcesso.equals(other.tipoProcesso)) {
            return false;
        }
        if ((this.statusProcesso == null) ? (other.statusProcesso != null) : !this.statusProcesso.equals(other.statusProcesso)) {
            return false;
        }
        if (this.dataFiscalizacao != other.dataFiscalizacao && (this.dataFiscalizacao == null || !this.dataFiscalizacao.equals(other.dataFiscalizacao))) {
            return false;
        }
        if ((this.observacao == null) ? (other.observacao != null) : !this.observacao.equals(other.observacao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + (this.fiscalizado != null ? this.fiscalizado.hashCode() : 0);
        hash = 83 * hash + (this.tipoFiscalizado != null ? this.tipoFiscalizado.hashCode() : 0);
        hash = 83 * hash + (this.processo != null ? this.processo.hashCode() : 0);
        hash = 83 * hash + (this.anoReferencia != null ? this.anoReferencia.hashCode() : 0);
        hash = 83 * hash + (this.tipoProcesso != null ? this.tipoProcesso.hashCode() : 0);
        hash = 83 * hash + (this.statusProcesso != null ? this.statusProcesso.hashCode() : 0);
        hash = 83 * hash + (this.dataFiscalizacao != null ? this.dataFiscalizacao.hashCode() : 0);
        hash = 83 * hash + (this.observacao != null ? this.observacao.hashCode() : 0);
        return hash;
    }
}
