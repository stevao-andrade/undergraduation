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
    private String matricula;
    private String curso;

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.curso == null) ? (other.curso != null) : !this.curso.equals(other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.codigo_usuario != null ? this.codigo_usuario.hashCode() : 0);
        hash = 71 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 71 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 71 * hash + (this.curso != null ? this.curso.hashCode() : 0);
        return hash;
    }
}
