/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.questionarioUsuario.QuestionarioUsuario;
import br.com.egresso.questionarioUsuario.QuestionarioUsuarioRN;
import br.com.egresso.questionarios.Alternativa;
import br.com.egresso.questionarios.AlternativaRN;
import br.com.egresso.questionarios.Questionario;
import br.com.egresso.questionarios.QuestionarioRN;
import br.com.egresso.questionarios.Resposta;
import br.com.egresso.questionarios.RespostaRN;
import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.ContextoUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.event.ValueChangeListener;
import org.primefaces.component.datagrid.DataGrid;

/**
 *
 * @author stevao.alves
 */
@ManagedBean(name = "usuarioQuestionarioBean")
@SessionScoped
public class UsuarioQuestionarioBean {

    private Questionario questionario = new Questionario();
    private List<Questionario> questionariosDisponiveis;
    private DataGrid dataGrid = new DataGrid();
    private HtmlSelectOneRadio radio = new HtmlSelectOneRadio();
    private String respostaEscolhida;
    private List<Integer> alternativas = new ArrayList<Integer>();
    private Resposta resposta = new Resposta();

    public HtmlSelectOneRadio getRadio() {
        return radio;
    }

    public void setRadio(HtmlSelectOneRadio radio) {
        this.radio = radio;
    }

    public DataGrid getDataGrid() {
        return dataGrid;
    }

    public void setDataGrid(DataGrid dataGrid) {
        this.dataGrid = dataGrid;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public void execute(ValueChangeListener evt) {

        respostaEscolhida = (String) radio.getValue();
        int temp = Integer.parseInt(respostaEscolhida);
        this.alternativas.add(temp);
    }

    public List<Questionario> getQuestionariosDisponiveis() throws ClassNotFoundException, SQLException, Exception {

        Usuario usuario = new Usuario();
        usuario = ContextoUtil.getUsuarioBean().getUsuarioLogado();

        this.questionariosDisponiveis = new ArrayList<Questionario>();
        
        QuestionarioRN questionarioRN = new QuestionarioRN();
        this.questionariosDisponiveis = questionarioRN.questionariosDisponiveis(usuario);
        
        
        return questionariosDisponiveis;
    }

    public String salvar() throws IOException {

        AlternativaRN daoAlternativa = new AlternativaRN();
        RespostaRN daoResposta = new RespostaRN();

        for (int i = 0; i <= alternativas.size() - 1; i++) {
            //Alternativa para receber os valores do vetor de alternativas.
            Alternativa alternativa = new Alternativa();
            alternativa = daoAlternativa.carregar(alternativas.get(i)); //carrega alternativa do banco referente à opção do usuario armazenada na lista

            this.resposta.setAlternativa(alternativa);
            this.resposta.setQuestao(alternativa.getQuestao());
            this.resposta.setQuestionario(this.questionario);
            this.resposta.setUsuario(ContextoUtil.getUsuarioBean().getUsuarioLogado());

            daoResposta.salvar(resposta);

            this.resposta = new Resposta();
        }
        ///Salvar na tabela de controle UsuarioQUestionario
        QuestionarioUsuarioRN qUsuarioDAO = new QuestionarioUsuarioRN();
        QuestionarioUsuario qUsuario = new QuestionarioUsuario();
        qUsuario.setCodigo_questionario(this.questionario.getCodigo_questionario());
        qUsuario.setCodigo_usuario(ContextoUtil.getUsuarioBean().getUsuarioLogado().getCodigo_usuario());

        qUsuarioDAO.salvar(qUsuario);

        //Encerrar Bean para possibilitar responder novos questionarios
        LogoutBean logOut = new LogoutBean();
        logOut.encerraUsuarioQuestionario();

        return "principal";
    }
}
