/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author stevao.alves
 */
@Entity
@Table(name = "questionarios")
public class Questionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo_questionario;
    @Column(name = "nomeQuestionario")
    private String nomeQuestionario;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataCriacao")
    private Date dataCriacao;
    @Column(name = "dataDisponibilidadeFinal")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDisponibilidadeFinal;
   
    @OneToMany(mappedBy="questionario")
    private List<Questao> questoes;
    
    @OneToMany(mappedBy="questionario")
    private List<Resposta> listaDeRespostas;
    
    public int getCodigo_questionario() {
        return codigo_questionario;
    }

    public void setCodigo_questionario(int codigo_questionario) {
        this.codigo_questionario = codigo_questionario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNomeQuestionario() {
        return nomeQuestionario;
    }

    public void setNomeQuestionario(String nomeQuestionario) {
        this.nomeQuestionario = nomeQuestionario;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Date getDataDisponibilidadeFinal() {
        return dataDisponibilidadeFinal;
    }

    public void setDataDisponibilidadeFinal(Date dataDisponibilidadeFinal) {
        this.dataDisponibilidadeFinal = dataDisponibilidadeFinal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questionario other = (Questionario) obj;
        if (this.codigo_questionario != other.codigo_questionario) {
            return false;
        }
        if ((this.nomeQuestionario == null) ? (other.nomeQuestionario != null) : !this.nomeQuestionario.equals(other.nomeQuestionario)) {
            return false;
        }
        if (this.dataCriacao != other.dataCriacao && (this.dataCriacao == null || !this.dataCriacao.equals(other.dataCriacao))) {
            return false;
        }
        if (this.dataDisponibilidadeFinal != other.dataDisponibilidadeFinal && (this.dataDisponibilidadeFinal == null || !this.dataDisponibilidadeFinal.equals(other.dataDisponibilidadeFinal))) {
            return false;
        }
        if (this.questoes != other.questoes && (this.questoes == null || !this.questoes.equals(other.questoes))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo_questionario;
        hash = 97 * hash + (this.nomeQuestionario != null ? this.nomeQuestionario.hashCode() : 0);
        hash = 97 * hash + (this.dataCriacao != null ? this.dataCriacao.hashCode() : 0);
        hash = 97 * hash + (this.dataDisponibilidadeFinal != null ? this.dataDisponibilidadeFinal.hashCode() : 0);
        hash = 97 * hash + (this.questoes != null ? this.questoes.hashCode() : 0);
        return hash;
    }
}