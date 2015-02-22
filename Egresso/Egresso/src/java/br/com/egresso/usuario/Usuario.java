package br.com.egresso.usuario;

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
 * Propriedade da classe UsuarioBean. Os campos da tela serão apontados para 
 * as propriedades desta classe.
 * *****************************************************************************
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo_usuario;
    private String nome;
    private String senha;
    private String email;
    private String rg;
    private String cpf;
    private String matricula;
    private String sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    private String telefone;
    private String celular;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.rg == null) ? (other.rg != null) : !this.rg.equals(other.rg)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.sexo == null) ? (other.sexo != null) : !this.sexo.equals(other.sexo)) {
            return false;
        }
        if (this.nascimento != other.nascimento && (this.nascimento == null || !this.nascimento.equals(other.nascimento))) {
            return false;
        }
        if ((this.telefone == null) ? (other.telefone != null) : !this.telefone.equals(other.telefone)) {
            return false;
        }
        if ((this.celular == null) ? (other.celular != null) : !this.celular.equals(other.celular)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.codigo_usuario != null ? this.codigo_usuario.hashCode() : 0);
        hash = 11 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 11 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 11 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 11 * hash + (this.rg != null ? this.rg.hashCode() : 0);
        hash = 11 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 11 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 11 * hash + (this.sexo != null ? this.sexo.hashCode() : 0);
        hash = 11 * hash + (this.nascimento != null ? this.nascimento.hashCode() : 0);
        hash = 11 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 11 * hash + (this.celular != null ? this.celular.hashCode() : 0);
        return hash;
    }

    
}
