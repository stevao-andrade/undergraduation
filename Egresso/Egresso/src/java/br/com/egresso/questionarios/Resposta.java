/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.usuario.Usuario;
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
 * @author stevao.alves
 * 
 */
@Entity
@Table(name = "respostas")
public class Resposta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_resposta")
    private int codigo_resposta;
    @OneToOne
    @JoinColumn(name = "codigo_questao")
    private Questao questao;
    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Usuario usuario;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "codigo_questionario")
    private Questionario questionario;
    @OneToOne
    @JoinColumn(name = "codigo_alternativa")
    private Alternativa alternativa;

    public Resposta() {
    }
    
    public Resposta(Questao q,Alternativa a){
        
    }
    
    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public int getCodigo_resposta() {
        return codigo_resposta;
    }

    public void setCodigo_resposta(int codigo_resposta) {
        this.codigo_resposta = codigo_resposta;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resposta other = (Resposta) obj;
        if (this.codigo_resposta != other.codigo_resposta) {
            return false;
        }
        if (this.questao != other.questao && (this.questao == null || !this.questao.equals(other.questao))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        if (this.questionario != other.questionario && (this.questionario == null || !this.questionario.equals(other.questionario))) {
            return false;
        }
        if (this.alternativa != other.alternativa && (this.alternativa == null || !this.alternativa.equals(other.alternativa))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo_resposta;
        hash = 89 * hash + (this.questao != null ? this.questao.hashCode() : 0);
        hash = 89 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 89 * hash + (this.questionario != null ? this.questionario.hashCode() : 0);
        hash = 89 * hash + (this.alternativa != null ? this.alternativa.hashCode() : 0);
        return hash;
    }
}
