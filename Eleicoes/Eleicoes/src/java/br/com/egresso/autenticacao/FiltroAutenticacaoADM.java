package br.com.egresso.autenticacao;

import br.com.egresso.web.AdministradorBean;
import java.io.*;  
import javax.servlet.http.*;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
  
  
/** 
* 
* @author Stevão Andrade 
 * 
 * Mesmo esquema do filtro para usuarios, adaptado para area de administração 
 * e para AdministradorBean.
*/  
public class FiltroAutenticacaoADM implements Filter {  
  
     /**
     * Testa se existe uma instancia de administradorBean, caso não exista redireciona para pagina de login de administrador.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        HttpSession session = ((HttpServletRequest)request).getSession();  
        AdministradorBean administradorBean = new AdministradorBean();  
        administradorBean = (AdministradorBean)session.getAttribute("administradorBean");  
          
        if(administradorBean == null) {    
            RequestDispatcher rd = request.getRequestDispatcher("/publico/adm.xhtml");      
            rd.forward(request, response);         
        }  
        else if (administradorBean.isLogado()) {   
            chain.doFilter(request, response);  //OK             
        }  
        else {  
            RequestDispatcher rd = request.getRequestDispatcher("/publico/adm.xhtml");      
            rd.forward(request, response);                          
        }  
    }  
    
     /**
     * implementar a classe filter obriga implementar esse metodo.
     */  
    public void init(FilterConfig arg0) throws ServletException {  
          
    }  
    
     /**
     * implementar a classe filter obriga implementar esse metodo.
     */  
    public void destroy() {  
          
    }  
  
}  