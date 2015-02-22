/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.util;

import br.com.egresso.web.QuestaoBean;
import br.com.egresso.web.QuestionarioBean;
import br.com.egresso.web.UsuarioBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stevao.alves
 */
public class ContextoUtil {
    
    public static UsuarioBean getUsuarioBean(){
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        ExternalContext contextoExterno = contexto.getExternalContext();
        HttpSession session = (HttpSession) contextoExterno.getSession(true);
        UsuarioBean usuarioBean = (UsuarioBean) session.getAttribute("usuarioBean");
        
        return usuarioBean;
    }
    
    public static QuestionarioBean getQuestionarioBean(){
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        ExternalContext contextoExterno = contexto.getExternalContext();
        HttpSession session = (HttpSession) contextoExterno.getSession(true);
        QuestionarioBean questionarioBean = (QuestionarioBean) session.getAttribute("questionarioBean");
        
        return questionarioBean;
    }
    
        public static QuestaoBean getQuestaoBean(){
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        ExternalContext contextoExterno = contexto.getExternalContext();
        HttpSession session = (HttpSession) contextoExterno.getSession(true);
        QuestaoBean questaoBean = (QuestaoBean) session.getAttribute("questaoBean");
        
        return questaoBean;
    }
    
}
