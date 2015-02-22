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
@Table(name = "certidao")
public class Certidao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="numero")
    private String numero;
    private String requerente;
    private String tipoInscricao;
    private String valor;
    private String ano;
    private String registro;
    private String dataPagamento;
    private String prazoValidade;
    private String dataSolicitacao;
    private String selo;

    public String getSelo() {
        return selo;
    }

    public void setSelo(String selo) {
        this.selo = selo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(String prazoValidade) {
        this.prazoValidade = prazoValidade;
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

    public String getTipoInscricao() {
        return tipoInscricao;
    }

    public void setTipoInscricao(String tipoInscricao) {
        this.tipoInscricao = tipoInscricao;
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
        final Certidao other = (Certidao) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.requerente == null) ? (other.requerente != null) : !this.requerente.equals(other.requerente)) {
            return false;
        }
        if ((this.tipoInscricao == null) ? (other.tipoInscricao != null) : !this.tipoInscricao.equals(other.tipoInscricao)) {
            return false;
        }
        if ((this.valor == null) ? (other.valor != null) : !this.valor.equals(other.valor)) {
            return false;
        }
        if ((this.ano == null) ? (other.ano != null) : !this.ano.equals(other.ano)) {
            return false;
        }
        if ((this.registro == null) ? (other.registro != null) : !this.registro.equals(other.registro)) {
            return false;
        }
        if ((this.dataPagamento == null) ? (other.dataPagamento != null) : !this.dataPagamento.equals(other.dataPagamento)) {
            return false;
        }
        if ((this.prazoValidade == null) ? (other.prazoValidade != null) : !this.prazoValidade.equals(other.prazoValidade)) {
            return false;
        }
        if ((this.dataSolicitacao == null) ? (other.dataSolicitacao != null) : !this.dataSolicitacao.equals(other.dataSolicitacao)) {
            return false;
        }
        if ((this.selo == null) ? (other.selo != null) : !this.selo.equals(other.selo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 97 * hash + (this.requerente != null ? this.requerente.hashCode() : 0);
        hash = 97 * hash + (this.tipoInscricao != null ? this.tipoInscricao.hashCode() : 0);
        hash = 97 * hash + (this.valor != null ? this.valor.hashCode() : 0);
        hash = 97 * hash + (this.ano != null ? this.ano.hashCode() : 0);
        hash = 97 * hash + (this.registro != null ? this.registro.hashCode() : 0);
        hash = 97 * hash + (this.dataPagamento != null ? this.dataPagamento.hashCode() : 0);
        hash = 97 * hash + (this.prazoValidade != null ? this.prazoValidade.hashCode() : 0);
        hash = 97 * hash + (this.dataSolicitacao != null ? this.dataSolicitacao.hashCode() : 0);
        hash = 97 * hash + (this.selo != null ? this.selo.hashCode() : 0);
        return hash;
    }
}
