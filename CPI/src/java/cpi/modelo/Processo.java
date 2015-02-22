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
@Table(name = "processos")
public class Processo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String capitalSocial;
    private String plenaria;
    private String anoReferencia;
    private String requerente;
    private String registro;
    private String email;
    private String ies;
    private String dataSolicitacao;
    private String numeroProcesso;
    private String valor;
    private String dataPagamento;
    private String folhas;
    private String documento;
    private String lote;
    private String dataColacao;
    private String dataRegistro;
    private String observacoes;

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    public String getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(String anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public String getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getDataColacao() {
        return dataColacao;
    }

    public void setDataColacao(String dataColacao) {
        this.dataColacao = dataColacao;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFolhas() {
        return folhas;
    }

    public void setFolhas(String folhas) {
        this.folhas = folhas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIes() {
        return ies;
    }

    public void setIes(String ies) {
        this.ies = ies;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getPlenaria() {
        return plenaria;
    }

    public void setPlenaria(String plenaria) {
        this.plenaria = plenaria;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Processo other = (Processo) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo)) {
            return false;
        }
        if ((this.capitalSocial == null) ? (other.capitalSocial != null) : !this.capitalSocial.equals(other.capitalSocial)) {
            return false;
        }
        if ((this.plenaria == null) ? (other.plenaria != null) : !this.plenaria.equals(other.plenaria)) {
            return false;
        }
        if ((this.anoReferencia == null) ? (other.anoReferencia != null) : !this.anoReferencia.equals(other.anoReferencia)) {
            return false;
        }
        if ((this.requerente == null) ? (other.requerente != null) : !this.requerente.equals(other.requerente)) {
            return false;
        }
        if ((this.registro == null) ? (other.registro != null) : !this.registro.equals(other.registro)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.ies == null) ? (other.ies != null) : !this.ies.equals(other.ies)) {
            return false;
        }
        if ((this.dataSolicitacao == null) ? (other.dataSolicitacao != null) : !this.dataSolicitacao.equals(other.dataSolicitacao)) {
            return false;
        }
        if ((this.numeroProcesso == null) ? (other.numeroProcesso != null) : !this.numeroProcesso.equals(other.numeroProcesso)) {
            return false;
        }
        if ((this.valor == null) ? (other.valor != null) : !this.valor.equals(other.valor)) {
            return false;
        }
        if ((this.dataPagamento == null) ? (other.dataPagamento != null) : !this.dataPagamento.equals(other.dataPagamento)) {
            return false;
        }
        if ((this.folhas == null) ? (other.folhas != null) : !this.folhas.equals(other.folhas)) {
            return false;
        }
        if ((this.documento == null) ? (other.documento != null) : !this.documento.equals(other.documento)) {
            return false;
        }
        if ((this.lote == null) ? (other.lote != null) : !this.lote.equals(other.lote)) {
            return false;
        }
        if ((this.dataColacao == null) ? (other.dataColacao != null) : !this.dataColacao.equals(other.dataColacao)) {
            return false;
        }
        if ((this.dataRegistro == null) ? (other.dataRegistro != null) : !this.dataRegistro.equals(other.dataRegistro)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
        hash = 89 * hash + (this.capitalSocial != null ? this.capitalSocial.hashCode() : 0);
        hash = 89 * hash + (this.plenaria != null ? this.plenaria.hashCode() : 0);
        hash = 89 * hash + (this.anoReferencia != null ? this.anoReferencia.hashCode() : 0);
        hash = 89 * hash + (this.requerente != null ? this.requerente.hashCode() : 0);
        hash = 89 * hash + (this.registro != null ? this.registro.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.ies != null ? this.ies.hashCode() : 0);
        hash = 89 * hash + (this.dataSolicitacao != null ? this.dataSolicitacao.hashCode() : 0);
        hash = 89 * hash + (this.numeroProcesso != null ? this.numeroProcesso.hashCode() : 0);
        hash = 89 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 89 * hash + (this.dataPagamento != null ? this.dataPagamento.hashCode() : 0);
        hash = 89 * hash + (this.folhas != null ? this.folhas.hashCode() : 0);
        hash = 89 * hash + (this.documento != null ? this.documento.hashCode() : 0);
        hash = 89 * hash + (this.lote != null ? this.lote.hashCode() : 0);
        hash = 89 * hash + (this.dataColacao != null ? this.dataColacao.hashCode() : 0);
        hash = 89 * hash + (this.dataRegistro != null ? this.dataRegistro.hashCode() : 0);
        return hash;
    }
}
