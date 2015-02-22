/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Stevão Andrade
 */
@Entity
@Table(name = "alternativas")
public class Alternativa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_alternativa")
    private int codigo_alternativa;
    @Column(name = "enunciadoAlternativa")
    private String enunciadoAlternativa;
    @ManyToOne
    @JoinColumn(name = "codigo_questao")
    private Questao questao;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "codigo_questionario")
    private Questionario questionario;
    
    public int getCodigo_alternativa() {
        return codigo_alternativa;
    }

    public void setCodigo_alternativa(int codigo_alternativa) {
        this.codigo_alternativa = codigo_alternativa;
    }

    public String getEnunciadoAlternativa() {
        return enunciadoAlternativa;
    }

    public void setEnunciadoAlternativa(String enunciadoAlternativa) {
        this.enunciadoAlternativa = enunciadoAlternativa;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alternativa other = (Alternativa) obj;
        if (this.codigo_alternativa != other.codigo_alternativa) {
            return false;
        }
        if ((this.enunciadoAlternativa == null) ? (other.enunciadoAlternativa != null) : !this.enunciadoAlternativa.equals(other.enunciadoAlternativa)) {
            return false;
        }
        if (this.questao != other.questao && (this.questao == null || !this.questao.equals(other.questao))) {
            return false;
        }
        if (this.questionario != other.questionario && (this.questionario == null || !this.questionario.equals(other.questionario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo_alternativa;
        hash = 67 * hash + (this.enunciadoAlternativa != null ? this.enunciadoAlternativa.hashCode() : 0);
        hash = 67 * hash + (this.questao != null ? this.questao.hashCode() : 0);
        hash = 67 * hash + (this.questionario != null ? this.questionario.hashCode() : 0);
        return hash;
    }
}
