/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author stevao.alves
 */
public class AutenticaUsuario extends Authenticator {
    
    private String usuario;
    private String senha;

    public AutenticaUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public PasswordAuthentication getPasswordAuthenticatio(){
        return new PasswordAuthentication(this.usuario, this.senha);
    }
}
