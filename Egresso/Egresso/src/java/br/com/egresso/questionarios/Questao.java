/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Stevão Andrade
 */
@Entity
@Table(name = "questoes")
public class Questao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_questao")
    private int codigo_questao;
    @Column(name = "enunciadoQuestao")
    private String enunciadoQuestao;
   
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="codigo_questionario")
    private Questionario questionario;
    
    @OneToMany(mappedBy="questao")
    private List<Alternativa> alternativas;
    
    public List<Alternativa> getAlternativas() {
        return alternativas;
    }
    
    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
    public int getCodigo_questao() {
        return codigo_questao;
    }
    
    public void setCodigo_questao(int codigo_questao) {
        this.codigo_questao = codigo_questao;
    }
    
    public String getEnunciadoQuestao() {
        return enunciadoQuestao;
    }
    
    public void setEnunciadoQuestao(String enunciadoQuestao) {
        this.enunciadoQuestao = enunciadoQuestao;
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
        final Questao other = (Questao) obj;
        if (this.codigo_questao != other.codigo_questao) {
            return false;
        }
        if ((this.enunciadoQuestao == null) ? (other.enunciadoQuestao != null) : !this.enunciadoQuestao.equals(other.enunciadoQuestao)) {
            return false;
        }
        if (this.questionario != other.questionario && (this.questionario == null || !this.questionario.equals(other.questionario))) {
            return false;
        }
        if (this.alternativas != other.alternativas && (this.alternativas == null || !this.alternativas.equals(other.alternativas))) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigo_questao;
        hash = 79 * hash + (this.enunciadoQuestao != null ? this.enunciadoQuestao.hashCode() : 0);
        hash = 79 * hash + (this.questionario != null ? this.questionario.hashCode() : 0);
        hash = 79 * hash + (this.alternativas != null ? this.alternativas.hashCode() : 0);
        return hash;
    }
}
