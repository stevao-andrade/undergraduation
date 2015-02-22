/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.util;

import br.com.egresso.administracao.AdministradorDAO;
import br.com.egresso.questionarioUsuario.QuestionarioUsuarioDAO;
import br.com.egresso.questionarios.AlternativaDAO;
import br.com.egresso.questionarios.QuestaoDAO;
import br.com.egresso.questionarios.QuestionarioDAO;
import br.com.egresso.questionarios.RespostaDAO;
import br.com.egresso.relatorios.ConsultasDAO;
import br.com.egresso.usuario.UsuarioDAO;

/**
 *
 * @author Stevão Andrade
 */
public class DAOFactory {

    public static UsuarioDAO criaUsuarioDAO() {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDao;
    }


    public static AdministradorDAO criaAdministradorDAO() {
        AdministradorDAO admDAO = new AdministradorDAO();
        admDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return admDAO;
    }

    public static QuestionarioDAO criaQuestionarioDAO() {
        QuestionarioDAO questionarioDAO = new QuestionarioDAO();
        questionarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return questionarioDAO;
    }

    public static QuestaoDAO criaquestaoDAO() {
        QuestaoDAO questaoDAO = new QuestaoDAO();
        questaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return questaoDAO;
    }

    public static AlternativaDAO criaAlternativaDAO() {
        AlternativaDAO alternativaDAO = new AlternativaDAO();
        alternativaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return alternativaDAO;
    }

    public static RespostaDAO criaRespostaDAO() {
        RespostaDAO respostaDAO = new RespostaDAO();
        respostaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return respostaDAO;
    }

    public static QuestionarioUsuarioDAO criaQuestionarioUsuarioDAO() {
        QuestionarioUsuarioDAO questionarioUsuarioDAO = new QuestionarioUsuarioDAO();
        questionarioUsuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return questionarioUsuarioDAO;
    }
    
    
    public static ConsultasDAO criaConsultaDAO(){
        ConsultasDAO consultaDAO = new ConsultasDAO();
        consultaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return consultaDAO;
    }
}