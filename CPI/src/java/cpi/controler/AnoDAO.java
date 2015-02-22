/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Ano;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author stevao
 */


public class AnoDAO {

    private Session sessao;

    public AnoDAO(Session sessao) {
        this.sessao = sessao;
    }
    
    public List<Ano> listar(){
        
        return this.sessao.createCriteria(Ano.class).list();
    }
    
}
