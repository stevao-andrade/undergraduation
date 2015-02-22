/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarioUsuario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author stevao
 */
@Entity
@Table(name = "usuario_questionario")
public class QuestionarioUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codigo_usuario_questionario")
    private int codigo_usuario_questionario;
    @Column(name = "codigo_usuario")
    private int codigo_usuario;
    @Column(name = "codigo_questionario")
    private int codigo_questionario;

    public int getCodigo_questionario() {
        return codigo_questionario;
    }

    public void setCodigo_questionario(int codigo_questionario) {
        this.codigo_questionario = codigo_questionario;
    }

    public int getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(int codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuestionarioUsuario other = (QuestionarioUsuario) obj;
        if (this.codigo_usuario != other.codigo_usuario) {
            return false;
        }
        if (this.codigo_questionario != other.codigo_questionario) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo_usuario;
        hash = 83 * hash + this.codigo_questionario;
        return hash;
    }
}
