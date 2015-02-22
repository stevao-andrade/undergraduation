/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author stevao.alves
 */
@Entity
@Table(name = "faculdade")
public class Faculdade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_faculdade")
    private int codigo_faculdade;
    @Column(name = "nome")
    private String nome;

    public int getCodigo_faculdade() {
        return codigo_faculdade;
    }

    public void setCodigo_faculdade(int codigo_faculdade) {
        this.codigo_faculdade = codigo_faculdade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Faculdade other = (Faculdade) obj;
        if (this.codigo_faculdade != other.codigo_faculdade) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo_faculdade;
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
}
