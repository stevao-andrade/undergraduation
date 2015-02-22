/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.questionarios.Questionario;
import br.com.egresso.questionarios.QuestionarioRN;
import br.com.egresso.util.MensagemContexto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author stevao.alves
 */

@ManagedBean
@SessionScoped
public class QuestionarioBean {
    
    private Questionario questionario = new Questionario();
    private List<Questionario> listaQuestionario = null;

    public List<Questionario> getListaQuestionario() {
        if (this.listaQuestionario == null) {

            QuestionarioRN questionarioRN = new QuestionarioRN();

            listaQuestionario = questionarioRN.listar();
        }
        return this.listaQuestionario;
    }

    public void setListaQuestionario(List<Questionario> listaQuestionario) {
        this.listaQuestionario = listaQuestionario;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
        
    public String salvarQuestionario(){
        
        QuestionarioRN questionarioRN = new QuestionarioRN();
        
        questionarioRN.salvar(questionario);
               
        return "criaQuestoes";
    }
    
    public void excluirQuestionario(){
        QuestionarioRN quetionarioRN = new QuestionarioRN();
        
        quetionarioRN.excluir(this.questionario);
        
        MensagemContexto.adicionarMensagem("Questionário excluido com sucesso.");
        
        this.listaQuestionario = null;
        this.questionario = new Questionario();
    }
}
