/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.questionarios.Questao;
import br.com.egresso.questionarios.QuestaoRN;
import br.com.egresso.questionarios.Questionario;
import br.com.egresso.questionarios.QuestionarioRN;
import br.com.egresso.relatorios.ConsultasRN;
import br.com.egresso.relatorios.Cursos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeListener;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "relatorioBean")
@SessionScoped
public class RelatorioBean {

    private SelectOneMenu menuQuestionarios = new SelectOneMenu(); //Binding para usar o valueChangeListner no questionario
    private SelectOneMenu menuQuestao = new SelectOneMenu(); //Binding para usar o valueChangeListner nas questoes
    private List<SelectItem> questoes = new ArrayList<SelectItem>(); //Lista de questoes que aparece no SelectMenu de questoes
    private Questionario questionario = new Questionario(); //Recebe o valor selecionado no SelectMenu de questionario
    private Questao questao = new Questao(); //Recebe o valor selecionado no SelectMenu de questoes
    private String curso;
    private List cursos = new ArrayList();
    
    public SelectOneMenu getMenuQuestionarios() {
        return menuQuestionarios;
    }

    public void setMenuQuestionarios(SelectOneMenu menuQuestionarios) {
        this.menuQuestionarios = menuQuestionarios;
    }

    public SelectOneMenu getMenuQuestao() {
        return menuQuestao;
    }

    public void setMenuQuestao(SelectOneMenu menuQuestao) {
        this.menuQuestao = menuQuestao;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<SelectItem> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<SelectItem> questoes) {
        this.questoes = questoes;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List getCursos() {
        for (Cursos o : Cursos.values())
            cursos.add(o.toString());
        return cursos;
    }

    public void setCursos(List cursos) {
        this.cursos = cursos;
    }
    
    public void execute(ValueChangeListener evt) {
        String a = (String) this.menuQuestionarios.getValue();
        if (!a.equals("")) {
            int b = Integer.parseInt(a);
            QuestionarioRN q = new QuestionarioRN();
            this.questionario = q.carregar(b);
        }
    }

    public void executeQuestao(ValueChangeListener evt2) {
        String a = (String) this.menuQuestao.getValue();
        if (!a.equals("")) {
            int b = Integer.parseInt(a);
            QuestaoRN q = new QuestaoRN();
            this.questao = q.carregar(b);
        }
    }

    public List<SelectItem> getListaDeQuestionario() {
        QuestionarioRN questionarioRN = new QuestionarioRN();
        List<Questionario> questionarios = new ArrayList<Questionario>();
        questionarios = questionarioRN.listar();

        List lista = new ArrayList();

        for (Questionario q : questionarios) {
            SelectItem item = new SelectItem(q.getCodigo_questionario(), q.getNomeQuestionario());
            lista.add(item);
        }
        return lista;
    }

    public List<SelectItem> atualizandoSelect() {
        this.questoes = new ArrayList<SelectItem>();
        if (questionario != null) {
            QuestaoRN questaoRN = new QuestaoRN();
            List<Questao> questoesDoQuestionario = new ArrayList<Questao>();
            questoesDoQuestionario = questaoRN.listar(this.questionario.getCodigo_questionario());

            for (Questao q : questoesDoQuestionario) {
                SelectItem itens = new SelectItem(q.getCodigo_questao(), q.getEnunciadoQuestao());
                this.questoes.add(itens);
            }
            return questoes;
        } else {
            this.questoes = new ArrayList<SelectItem>();
            return this.questoes;
        }
    }

    /*
     * alternativaGraficoPizza é uma consulta SQL que uma matriz para representar a consulta.
     * para acessar os dados cria um iterador para rodar a matriz e acessar os objetos.
     */
    public PieChartModel geraGraficoPizza() {

        List<Object> alternativasGraficoPizza = new ArrayList<Object>();
        ConsultasRN consultas = new ConsultasRN();
        alternativasGraficoPizza = consultas.consultaQuestionario(this.questao);
        PieChartModel pizza = new PieChartModel();
        if (!alternativasGraficoPizza.isEmpty()) {
            Iterator pares = alternativasGraficoPizza.iterator(); //Iterator para rodar a lista e capturar os objetos
            while (pares.hasNext()) {
                Object[] par = (Object[]) pares.next();
                String resposta = (String) par[0];
                BigInteger quantidade = (BigInteger) par[1];
                pizza.set(resposta, quantidade);
            }
        }
        return pizza;
    }

    public StreamedContent gerarEmails() throws FileNotFoundException, SQLException, Exception {
        ConsultasRN consulta = new ConsultasRN();
        StreamedContent arquivoRetorno = null;
        File arquivoGerado = null;

        arquivoGerado = consulta.gerarEmail(this.curso);
        InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
        arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/xls", "emails.xls");

        return arquivoRetorno;
    }
}
