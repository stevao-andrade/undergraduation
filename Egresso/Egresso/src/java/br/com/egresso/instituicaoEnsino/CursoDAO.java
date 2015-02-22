/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author stevao.alves
 */
public class CursoDAO {
    
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }
    
    public List listar(){
        return this.session.createCriteria(Curso.class).list();
    }
}
