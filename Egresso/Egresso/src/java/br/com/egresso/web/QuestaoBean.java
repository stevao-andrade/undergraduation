/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.QuestaoRN;
import br.com.egresso.util.ContextoUtil;
import br.com.egresso.util.MensagemContexto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "questaoBean")
@RequestScoped
public class QuestaoBean {

    private Questao questao = new Questao();
    private List<Questao> listaDeQuestoes = null;

    public List<Questao> getLista() {
        if (this.listaDeQuestoes == null) {
            QuestaoRN questaoRN = new QuestaoRN();
            this.listaDeQuestoes = questaoRN.listar(ContextoUtil.getQuestionarioBean().getQuestionario().getCodigo_questionario());
        }
        return this.listaDeQuestoes;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public void salvarQuestao() {
        this.questao.setQuestionario(ContextoUtil.getQuestionarioBean().getQuestionario());

        QuestaoRN questaoRN = new QuestaoRN();
        questaoRN.salvar(questao);

        this.questao = new Questao();
        this.listaDeQuestoes = null;

        MensagemContexto.adicionarMensagem("Questão inserida com sucesso.");
    }

    public void excluirQuestao() {
        QuestaoRN questaoRN = new QuestaoRN();

        questaoRN.excluir(this.questao);

        MensagemContexto.adicionarMensagem("Questão excluida com sucesso.");

        this.questao = new Questao();
        this.listaDeQuestoes = null;
    }
}
