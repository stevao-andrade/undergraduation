/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.DAOFactory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author stevao.alves
 */
public class QuestionarioRN {

    private QuestionarioDAO questionarioDAO;

    public QuestionarioRN() {
        this.questionarioDAO = DAOFactory.criaQuestionarioDAO();
    }

    public void salvar(Questionario questionario) {
        this.questionarioDAO.salvar(questionario);
    }

    public void excluir(Questionario questionario) {
        this.questionarioDAO.excluir(questionario);
    }

    public List<Questionario> listar() {
        return this.questionarioDAO.listar();
    }

    public Questionario carregar(int questionarioID) {
        return this.questionarioDAO.carregar(questionarioID);
    }

    public Questionario buscaPorNomeQuestionario(String nomeQuestionario) {
        return this.questionarioDAO.buscaPorNomeQuestionario(nomeQuestionario);
    }

    public List<Questionario> questionariosDisponiveis(Usuario usuario) throws ClassNotFoundException, SQLException, Exception {
        return this.questionarioDAO.questionariosDisponiveis(usuario);
    }
}
