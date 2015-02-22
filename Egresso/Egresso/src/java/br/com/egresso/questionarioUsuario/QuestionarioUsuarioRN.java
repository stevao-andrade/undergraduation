/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarioUsuario;

import br.com.egresso.questionarios.Questionario;
import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Stevão Andrade
 */
public class QuestionarioUsuarioRN {

    private QuestionarioUsuarioDAO questionarioUsuarioDAO;

    public QuestionarioUsuarioRN() {
        this.questionarioUsuarioDAO = DAOFactory.criaQuestionarioUsuarioDAO();
    }

    public void salvar(QuestionarioUsuario questionarioUsuario) {
        this.questionarioUsuarioDAO.salvar(questionarioUsuario);
    }

    public List listar() {

        return this.questionarioUsuarioDAO.listar();
    }
    
}
