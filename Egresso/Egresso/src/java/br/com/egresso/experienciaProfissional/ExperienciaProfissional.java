/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.experienciaProfissional;

import br.com.egresso.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * 
 * CLASSE MODELO
 */

@Entity
@Table(name="experienciaProfissional")
public class ExperienciaProfissional implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="codigo_experiencia",nullable=false)
    private int codigo_experiencia;
    @Column(name="empresa")
    private String empresa;
    @Column(name="cargo")
    private String cargo;
    @Column(name="areaFormacao")
    private String areaDeFormacao;
    @Column(name="dataInicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Column(name="dataFim")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    
    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="codigo_usuario",nullable=false)
    private Usuario usuario;

    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void setAreaDeFormacao(String areaDeFormacao) {
        this.areaDeFormacao = areaDeFormacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCodigo_experiencia() {
        return codigo_experiencia;
    }

    public void setCodigo_experiencia(int codigo_experiencia) {
        this.codigo_experiencia = codigo_experiencia;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
        final ExperienciaProfissional other = (ExperienciaProfissional) obj;
        if (this.codigo_experiencia != other.codigo_experiencia) {
            return false;
        }
        if ((this.empresa == null) ? (other.empresa != null) : !this.empresa.equals(other.empresa)) {
            return false;
        }
        if ((this.cargo == null) ? (other.cargo != null) : !this.cargo.equals(other.cargo)) {
            return false;
        }
        if ((this.areaDeFormacao == null) ? (other.areaDeFormacao != null) : !this.areaDeFormacao.equals(other.areaDeFormacao)) {
            return false;
        }
        if (this.dataInicio != other.dataInicio && (this.dataInicio == null || !this.dataInicio.equals(other.dataInicio))) {
            return false;
        }
        if (this.dataFim != other.dataFim && (this.dataFim == null || !this.dataFim.equals(other.dataFim))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo_experiencia;
        hash = 97 * hash + (this.empresa != null ? this.empresa.hashCode() : 0);
        hash = 97 * hash + (this.areaDeFormacao != null ? this.areaDeFormacao.hashCode() : 0);
        hash = 97 * hash + (this.dataInicio != null ? this.dataInicio.hashCode() : 0);
        hash = 97 * hash + (this.dataFim != null ? this.dataFim.hashCode() : 0);
        hash = 97 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }
    
     
}
