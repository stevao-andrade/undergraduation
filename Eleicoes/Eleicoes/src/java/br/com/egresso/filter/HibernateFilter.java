package br.com.egresso.filter;


import org.hibernate.SessionFactory;
import br.com.egresso.util.HibernateUtil;
import javax.servlet.*;


/**
 * @author Stevão Andrade
 * 
 * Classe para implementar Open Session In View. Tecnica utilizada para iniciar 
 * a sessão do Hibernate no inicio do processamento da requisição no servidor e 
 * finalizar no final do processamento.
 * 
 * Evita que se crie uma nova conexão ao banco a cada operação que se deseja ser 
 * realizada. Garante ganhos de performasse no banco de dados e no carregamento 
 * das paginas.
 * 
 */
public class HibernateFilter implements Filter{
   
    private SessionFactory sf;

    /**
     * É executado somento quando o aplicativo web em questão pe colocado no ar.
     * 
     * Para iniciar é criado um objeto SessionFactory para poder criar as sessões
     * do Hibernate a cada requisição.
     */
    @Override
    public void init(FilterConfig Config) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    /**
     * Onde é realizada a filtragem da requisição.
     * 
     * Basicamente, inicia-se uma transação, é realizada a filtragem da requisição
     * e da resposta, as ações são comitadas no banco de dados e a conexão é encerrada
     * 
     * Caso ocorra algum erro, é realizado um Rollback e a exceção é disparada.
     * "Implementação da documentação do Hibernate."
     */    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
        try{
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        }catch(Throwable ex){
            try{
                if (this.sf.getCurrentSession().getTransaction().isActive()){
                		this.sf.getCurrentSession().getTransaction().rollback();
             }                   
            }catch(Throwable t){
                t.printStackTrace();
            }
        throw new ServletException(ex);
        }
    }

    /**
     *É executado quando éo aplicativo web é desativado. 
    */
    @Override
    public void destroy() {}
    
}
