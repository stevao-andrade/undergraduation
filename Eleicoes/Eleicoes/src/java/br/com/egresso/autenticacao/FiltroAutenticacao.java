package br.com.egresso.autenticacao;

import br.com.egresso.web.UsuarioBean;
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
 * Filtro que executa para toda requisição às paginas /restrito/* 
 * Verifica se existe uma instancia de UsuarioBean, se não existir, redireciona para pagina de login.
 * Caso exista, verifica a propriedade "Logado". Caso seja falso redireciona para pagina de login.
 * 
 * Propriedade Logado de UsuarioBean por padrão é FALSA somente fica VERDADEIRA após
 * executado o metodo logar().
 * 
*/  
public class FiltroAutenticacao implements Filter {  
  
    /**
     * Testa se existe uma instancia de usuarioBean, se não houver redireciona para Login.xhtml.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        HttpSession session = ((HttpServletRequest)request).getSession();  
        UsuarioBean usuarioBean = new UsuarioBean();  
        usuarioBean = (UsuarioBean)session.getAttribute("usuarioBean");  
          
        if(usuarioBean == null) {    
            RequestDispatcher rd = request.getRequestDispatcher("/publico/login.xhtml");      
            rd.forward(request, response);         
        }  
        else if (usuarioBean.isLogado()) {   
            chain.doFilter(request, response);  //OK, pode acessar as paginas            
        }  
        else {  
            RequestDispatcher rd = request.getRequestDispatcher("/publico/login.xhtml");      
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