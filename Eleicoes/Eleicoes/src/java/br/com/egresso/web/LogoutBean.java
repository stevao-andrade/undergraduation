/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stevao.alves
 */
@ManagedBean
@RequestScoped
public class LogoutBean {

    public LogoutBean() {
    }

    public String doLogout() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/publico/login";
    }

    public String doLogoutADM() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/publico/adm";
    }

    public String encerraQuestionario() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("questionarioBean");

        return "/admin/administracao";
    }

    public void encerraUsuarioQuestionario() {

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuarioQuestionarioBean");

    }
}
