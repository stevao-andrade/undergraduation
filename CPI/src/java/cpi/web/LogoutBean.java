/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import java.io.IOException;
import java.io.Serializable;
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
public class LogoutBean implements Serializable {

    public LogoutBean() {
    }

    public String doLogout() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "/publico/index";
    }
}
