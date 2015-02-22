/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.util;

import cpi.web.UsuarioBean;
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
        
}
