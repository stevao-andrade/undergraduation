/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.questionarios.Alternativa;
import br.com.egresso.questionarios.AlternativaRN;
import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.QuestaoRN;
import br.com.egresso.questionarios.Questionario;
import br.com.egresso.util.ContextoUtil;
import br.com.egresso.util.MensagemContexto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "alternativaBean")
@ViewScoped
public class AlternativaBean {

    private Alternativa alternativa = new Alternativa();
    private Questionario questionario = ContextoUtil.getQuestionarioBean().getQuestionario();
    private List<SelectItem> listaEnunciadoQuestoes;
    private List<Alternativa> listaAlternativas = null;
    private int questaoSelecionada;

    public List<Alternativa> getListaAlternativas() {

        if (this.listaAlternativas == null) {
            AlternativaRN alternativaRN = new AlternativaRN();
            this.listaAlternativas = alternativaRN.listar(questaoSelecionada);
        }

        return listaAlternativas;
    }

    public void setListaAlternativas(List<Alternativa> listaAlternativas) {
        this.listaAlternativas = listaAlternativas;
    }

    public List<SelectItem> getListaEnunciadoQuestoes() {

        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();

        QuestaoRN questaoRN = new QuestaoRN();
        List<Questao> questoes = questaoRN.listar(this.questionario.getCodigo_questionario());

        for (Questao teste : questoes) {
            SelectItem item = new SelectItem(teste.getCodigo_questao(), teste.getEnunciadoQuestao());
            lista.add(item);
        }

        return lista;
    }

    public void setListaEnunciadoQuestoes(List<SelectItem> listaEnunciadoQuestoes) {
        this.listaEnunciadoQuestoes = listaEnunciadoQuestoes;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public int getQuestaoSelecionada() {
        return questaoSelecionada;
    }

    public void setQuestaoSelecionada(int questaoSelecionada) {
        this.questaoSelecionada = questaoSelecionada;
    }

    public void salvarAlternativa() {

        this.alternativa.setQuestionario(this.questionario);

        QuestaoRN questaoRN = new QuestaoRN();
        this.alternativa.setQuestao(questaoRN.carregar(questaoSelecionada));

        AlternativaRN alternativaRN = new AlternativaRN();
        alternativaRN.salvar(this.alternativa);

        MensagemContexto.adicionarMensagem("Alternativa inserida com sucesso.");

        this.alternativa = new Alternativa();
        this.listaAlternativas = null;
    }
    
    public void excluirAlternativa(){
        AlternativaRN alternativaRN = new AlternativaRN();
        
        alternativaRN.excluir(alternativa);
        
        this.alternativa = new Alternativa();
        this.listaAlternativas = null;
    }
}
