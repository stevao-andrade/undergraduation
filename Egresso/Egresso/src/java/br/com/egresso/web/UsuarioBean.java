package br.com.egresso.web;

import br.com.egresso.usuario.Usuario;
import br.com.egresso.usuario.UsuarioRN;
import br.com.egresso.util.MensagemContexto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stevão Andrade
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable{

    private Usuario usuario = new Usuario();
    private String confirmaSenha;
    private String login = "";
    private String password = "";
    private boolean logado;
    private List<Usuario> lista = null;

    public List<Usuario> getLista() {
        if (this.lista == null) {

            UsuarioRN usuarioRN = new UsuarioRN();

            lista = usuarioRN.listar();
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

    public String salvar() {

        String senha = this.usuario.getSenha();

        if (!senha.equals(this.confirmaSenha)) {

            //Mensagem Contexto: "Classe padrão para adcionar mensagem ao contexto da tela"
            MensagemContexto.adicionarMensagem("A senha não foi confirmada corretamente");

            return null;
        }

        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(usuario);
        System.out.println("Usuario Cadastrado");

        return "/publico/usuarioCadastrado";
    }

    public String atualizar() {

        String senha = this.usuario.getSenha();

        if (!senha.equals(this.confirmaSenha)) {

            //Mensagem Contexto: "Classe padrão para adcionar mensagem ao contexto da tela"
            MensagemContexto.adicionarMensagem("A senha não foi confirmada corretamente");

            return null;
        }

        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(usuario);
        System.out.println("Dados Atualizados");

        return "/restrito/principal";
    }

    /*
     * Metodo para logar usuario no sistema.
     */
    public String logar() {

        if (login == null || login.equals("") && (password == null || password.equals(""))) {
            MensagemContexto.adicionarMensagem("Email e senha não podem ser vazios!");
        } else {
            if (login == null || login.equals("")) {
                MensagemContexto.adicionarMensagem("Email não pode ser vazio!");
            } else {
                if (password == null || password.equals("")) {
                    MensagemContexto.adicionarMensagem("Senha não pode ser vazio!");
                } else {
                    UsuarioRN usuarioRN = new UsuarioRN();
                    usuario = new Usuario();

                    usuario = usuarioRN.buscarPorLogin(login);

                    //Se usuario nulo então não existe no banco.
                    if (usuario != null && (usuario.getSenha().equals(password))) {
                        setLogado(true);
                        return "/restrito/principal";
                    } else {
                        setLogado(false);
                        MensagemContexto.adicionarMensagem("Email ou Senha inválidos");
                    }
                }
            }
        }
        return null;
    }

    public void excluir() {
        UsuarioRN usuarioRN = new UsuarioRN();
        this.usuario = usuarioRN.carregar(usuario.getCodigo_usuario());
        usuarioRN.excluir(usuario);
        this.usuario = new Usuario();
        this.lista = null;
    }
}
