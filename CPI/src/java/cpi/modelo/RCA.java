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
@Table(name="rca")
public class RCA implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="valor")
    private String valor;
    
    @Column(name="data_pagamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPagamento;
    
    @Column(name="numero_empresa")
    private String numeroEmpresa;
    
    @Column(name="objeto")
    private  String objeto;

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroEmpresa() {
        return numeroEmpresa;
    }

    public void setNumeroEmpresa(String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RCA other = (RCA) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.valor == null) ? (other.valor != null) : !this.valor.equals(other.valor)) {
            return false;
        }
        if (this.dataPagamento != other.dataPagamento && (this.dataPagamento == null || !this.dataPagamento.equals(other.dataPagamento))) {
            return false;
        }
        
        if ((this.numeroEmpresa == null) ? (other.numeroEmpresa != null) : !this.numeroEmpresa.equals(other.numeroEmpresa)) {
            return false;
        }
        if ((this.objeto == null) ? (other.objeto != null) : !this.objeto.equals(other.objeto)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 23 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 23 * hash + (this.dataPagamento != null ? this.dataPagamento.hashCode() : 0);
        hash = 23 * hash + (this.numeroEmpresa != null ? this.numeroEmpresa.hashCode() : 0);
        hash = 23 * hash + (this.objeto != null ? this.objeto.hashCode() : 0);
        return hash;
    }
}
