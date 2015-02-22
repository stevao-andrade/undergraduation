package cpi.usuario;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Stevão Andrade
 */
public class UsuarioDAO {

    /*Sessão do Hibernate que será utilizada para realizar as transações com os 
    * objetos.
    */
    private Session session;

    public UsuarioDAO(Session session) {
        this.session = session;
    }
    
    public void setSession(Session session){
        this.session=session;
    }
    

    public void salvar(Usuario usuario) {
        this.session.save(usuario);
    }


    public void atualizar(Usuario usuario) {
        this.session.update(usuario);
    }


    public void excluir(Usuario usuario) {
        this.session.delete(usuario);
    }


    public Usuario carregar(Integer codigo) {
        return (Usuario) this.session.get(Usuario.class, codigo);
    }


    public Usuario buscaPorLogin(String login) {
        //Faz select de um usuario com base no mapeamento da classe Usuario.
        String hql = "select u from Usuario u where u.login = :login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);
        return (Usuario) consulta.uniqueResult();
    }


    public List<Usuario> listar() {
        return this.session.createCriteria(Usuario.class).list();
    }
    
}