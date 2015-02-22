/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.web;

import br.com.egresso.administracao.Administrador;
import br.com.egresso.administracao.AdministradorRN;
import br.com.egresso.util.MensagemContexto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stevão Andrade
 */
@ManagedBean(name="administradorBean")
@SessionScoped
public class AdministradorBean {

    private String campoLogin = "";
    private String campoSenha = "";
    private Administrador admin = new Administrador();
    private String confirmaSenha;
    private boolean logado;

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getCampoLogin() {
        return campoLogin;
    }

    public void setCampoLogin(String campoLogin) {
        this.campoLogin = campoLogin;
    }

    public String getCampoSenha() {
        return campoSenha;
    }

    public void setCampoSenha(String campoSenha) {
        this.campoSenha = campoSenha;
    }

    public String logar() {

        if (campoLogin == null || campoLogin.equals("") && (campoSenha == null || campoSenha.equals(""))) {
            MensagemContexto.adicionarMensagem("Login e senha não podem ser vazios!");
        } else {
            if (campoLogin == null || campoLogin.equals("")) {
                MensagemContexto.adicionarMensagem("Login não pode ser vazio!");
            } else {
                if (campoSenha == null || campoSenha.equals("")) {
                    MensagemContexto.adicionarMensagem("Senha não pode ser vazio!");
                } else {
                    AdministradorRN admRN = new AdministradorRN();
                    admin = new Administrador();

                    admin = admRN.buscaPorLogin(campoLogin);

                    //Se usuario nulo então não existe no banco.
                    if (admin != null && (admin.getSenha().equals(campoSenha))) {
                        setLogado(true);
                        return "/admin/administracao";
                    } else {
                        setLogado(false);
                        MensagemContexto.adicionarMensagem("Login ou Senha inválidos");
                    }
                }
            }
        }
        return null;
    }

    public String atualizar() {

        String senha = this.admin.getSenha();

        if (!senha.equals(this.confirmaSenha)) {

            //Mensagem Contexto: "Classe padrão para adcionar mensagem ao contexto da tela"
            MensagemContexto.adicionarMensagem("A senha não foi confirmada corretamente");

            return null;
        }

        AdministradorRN admRN = new AdministradorRN();
        admRN.atualizar(admin);
        System.out.println("Dados Atualizados");

        return "/admin/administracao";
    }
}
