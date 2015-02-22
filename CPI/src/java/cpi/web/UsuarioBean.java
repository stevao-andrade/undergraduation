package cpi.web;

import cpi.usuario.Usuario;
import cpi.usuario.UsuarioDAO;
import cpi.util.HibernateUtil;
import cpi.util.MensagemContexto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Stevão Andrade
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private String confirmaSenha;
    private String login = "";
    private String password = "";
    private boolean logado;
    private List<Usuario> lista = null;
    private Usuario userView = new Usuario();
    private Usuario userNew = new Usuario();

    public Usuario getUserNew() {
        return userNew;
    }

    public void setUserNew(Usuario userNew) {
        this.userNew = userNew;
    }

    public Usuario getUserView() {
        return userView;
    }

    public void setUserView(Usuario userView) {
        this.userView = userView;
    }

    public List<Usuario> getLista() {
        if (this.lista == null) {

            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            UsuarioDAO usuario = new UsuarioDAO(s);

            lista = usuario.listar();

            t.commit();
            s.close();
        }
        return this.lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuarioLogado() {
        return this.usuario;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuario = usuarioLogado;
    }

    public String novo() {

        usuario = new Usuario();

        return "/publico/usuario";
    }


    /*
     * Metodo para logar usuario no sistema.
     */
    public String logar() {

        if (login == null || login.equals("") && (password == null || password.equals(""))) {
            MensagemContexto.adicionarMensagem("Nome e Senha não podem ser vazios!");
        } else {
            if (login == null || login.equals("")) {
                MensagemContexto.adicionarMensagem("Nome não pode ser vazio!");
            } else {
                if (password == null || password.equals("")) {
                    MensagemContexto.adicionarMensagem("Senha não pode ser vazio!");
                } else {

                    Session s = HibernateUtil.getSession();
                    Transaction t = s.beginTransaction();

                    UsuarioDAO usuarioDAO = new UsuarioDAO(s);
                    usuario = new Usuario();

                    usuario = usuarioDAO.buscaPorLogin(login);

                    t.commit();
                    s.close();

                    //Se usuario nulo então não existe no banco.
                    if (usuario != null && (usuario.getSenha().equals(password))) {
                        setLogado(true);
                        return "/restrito/principal";
                    } else {
                        setLogado(false);
                        MensagemContexto.adicionarMensagem("Nome ou Senha inválidos");
                    }
                }
            }
        }
        return null;
    }

    public void excluir() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        UsuarioDAO usuarioDAO = new UsuarioDAO(s);
        this.usuario = usuarioDAO.carregar(usuario.getCodigo_usuario());
        usuarioDAO.excluir(usuario);

        t.commit();
        s.close();

        if (!"".equals(this.usuario.getLogin())) {
            MensagemContexto.adicionarMensagem("Usuario " + this.usuario.getLogin() + " excluido com sucesso!");
        }

        this.usuario = new Usuario();
        this.lista = null;
    }

    public void exibirDialogDetalhes() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("detalhes.show()"); //executa o componente dialog
    }

    public void exibirDialogExcluir() {
        RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
        requisicao.execute("confirmacao.show()"); //executa o componente dialog
    }

    public void criarUsuario() {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();

        UsuarioDAO dao = new UsuarioDAO(s);

        dao.salvar(this.userNew);

        t.commit();
        s.close();

        MensagemContexto.adicionarMensagem("Usuario criado com sucesso.");

        this.userNew = new Usuario();
        this.lista = null;
    }
}
