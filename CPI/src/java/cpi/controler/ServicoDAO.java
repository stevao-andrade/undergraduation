/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Servico;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author stevao
 */
public class ServicoDAO {
    
    private Session sesssion;

    public ServicoDAO(Session sesssion) {
        this.sesssion = sesssion;
    }
    
    public List<Servico> listar(){
        
        return this.sesssion.createCriteria(Servico.class).list();
    }
}
