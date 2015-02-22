/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import br.com.egresso.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author stevao.alves
 */
@Entity
@Table(name = "instituicao_ensino")
public class InstituicaoEnsino implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_instituicao")
    private int codigo_instituicao;
    @Column(name = "nome_instituicao")
    private String nome_instituicao;
    @Column(name = "curso")
    private String curso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_final;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "codigo_usuario", nullable = false)
    private Usuario usuario;

    
    
    public int getCodigo_instituicao() {
        return codigo_instituicao;
    }

    public void setCodigo_instituicao(int codigo_instituicao) {
        this.codigo_instituicao = codigo_instituicao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InstituicaoEnsino other = (InstituicaoEnsino) obj;
        if (this.codigo_instituicao != other.codigo_instituicao) {
            return false;
        }
        if ((this.nome_instituicao == null) ? (other.nome_instituicao != null) : !this.nome_instituicao.equals(other.nome_instituicao)) {
            return false;
        }
        if ((this.curso == null) ? (other.curso != null) : !this.curso.equals(other.curso)) {
            return false;
        }
        if (this.data_inicio != other.data_inicio && (this.data_inicio == null || !this.data_inicio.equals(other.data_inicio))) {
            return false;
        }
        if (this.data_final != other.data_final && (this.data_final == null || !this.data_final.equals(other.data_final))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo_instituicao;
        hash = 89 * hash + (this.nome_instituicao != null ? this.nome_instituicao.hashCode() : 0);
        hash = 89 * hash + (this.curso != null ? this.curso.hashCode() : 0);
        hash = 89 * hash + (this.data_inicio != null ? this.data_inicio.hashCode() : 0);
        hash = 89 * hash + (this.data_final != null ? this.data_final.hashCode() : 0);
        hash = 89 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }
}
