/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.formacaoProfissional;

import br.com.egresso.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author stevao.alves
 * 
 ******************************************************************************
 * Classe entidade do Hibernate, representação da tabela Formacao Profissional no banco.
 * 
 * Propriedade da classe FormacaoProfissionalBean. Os campos da tela serão apontados para 
 * as propriedades desta classe.
 * *****************************************************************************
 */

@Entity
@Table(name="formacaoProfissional")
public class FormacaoProfissional implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int codigo_formacao;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    private String instituicaoFormacao;
    private String titulacao;
    
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="codigo_usuario", nullable= false)
    private Usuario usuario;

    public int getCodigo_formacao() {
        return codigo_formacao;
    }

    public void setCodigo_formacao(int codigo_formacao) {
        this.codigo_formacao = codigo_formacao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInstituicaoFormacao() {
        return instituicaoFormacao;
    }

    public void setInstituicaoFormacao(String instituicaoFormacao) {
        this.instituicaoFormacao = instituicaoFormacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
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
        final FormacaoProfissional other = (FormacaoProfissional) obj;
        if (this.codigo_formacao != other.codigo_formacao) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.dataInicio != other.dataInicio && (this.dataInicio == null || !this.dataInicio.equals(other.dataInicio))) {
            return false;
        }
        if (this.dataFim != other.dataFim && (this.dataFim == null || !this.dataFim.equals(other.dataFim))) {
            return false;
        }
        if ((this.instituicaoFormacao == null) ? (other.instituicaoFormacao != null) : !this.instituicaoFormacao.equals(other.instituicaoFormacao)) {
            return false;
        }
        if ((this.titulacao == null) ? (other.titulacao != null) : !this.titulacao.equals(other.titulacao)) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo_formacao;
        hash = 67 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 67 * hash + (this.dataInicio != null ? this.dataInicio.hashCode() : 0);
        hash = 67 * hash + (this.dataFim != null ? this.dataFim.hashCode() : 0);
        hash = 67 * hash + (this.instituicaoFormacao != null ? this.instituicaoFormacao.hashCode() : 0);
        hash = 67 * hash + (this.titulacao != null ? this.titulacao.hashCode() : 0);
        hash = 67 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }
        
    



}
