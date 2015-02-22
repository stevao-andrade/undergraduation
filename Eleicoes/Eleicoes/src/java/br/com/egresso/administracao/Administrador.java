/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.administracao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Stevão Andrade
 * 
 * CLASSE MODELO
 */
@Entity
@Table(name="administrador")
public class Administrador implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codigo_administrador")
    private int codigo_administrador;
    @Column(name="login")
    private String login;
    @Column(name="senha")
    private String senha;

    public int getCodigo_administrador() {
        return codigo_administrador;
    }

    public void setCodigo_administrador(int codigo_administrador) {
        this.codigo_administrador = codigo_administrador;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrador other = (Administrador) obj;
        if (this.codigo_administrador != other.codigo_administrador) {
            return false;
        }
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo_administrador;
        hash = 89 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 89 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        return hash;
    }
    
    
}
