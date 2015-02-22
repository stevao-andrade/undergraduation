/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarioUsuario;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Stevão Andrade
 */
public class QuestionarioUsuarioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(QuestionarioUsuario questionarioUsuario) {
        this.session.saveOrUpdate(questionarioUsuario);
    }

    public List<QuestionarioUsuario> listar() {
        return this.session.createCriteria(QuestionarioUsuario.class).list();
    }

}
