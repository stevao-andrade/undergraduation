/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author stevao
 */
public class RespostaDAO {
    
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }


    public void salvar(Resposta resposta){
        this.session.save(resposta);
    }
    
}
