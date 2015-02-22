package cpi.usuario;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Table;

/**
 *
 * @author Stevão Andrade
 *
 * *****************************************************************************
 * Classe entidade do Hibernate, representação da tabela usuario no banco.
 *
 * Propriedade da classe UsuarioBean. Os campos da tela serão apontados para as
 * propriedades desta classe.
 * *****************************************************************************
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo_usuario;
    private String login;
    private String senha;

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
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
        final Usuario other = (Usuario) obj;
        if (this.codigo_usuario != other.codigo_usuario && (this.codigo_usuario == null || !this.codigo_usuario.equals(other.codigo_usuario))) {
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
        int hash = 3;
        hash = 11 * hash + (this.codigo_usuario != null ? this.codigo_usuario.hashCode() : 0);
        hash = 11 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 11 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        return hash;
    }
}
