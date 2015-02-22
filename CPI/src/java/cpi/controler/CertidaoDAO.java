/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Certidao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author stevao
 */
public class CertidaoDAO {
    
    Session session;

    public CertidaoDAO(Session session) {
        this.session = session;
    }
    
    public void salvar(Certidao c){
        this.session.saveOrUpdate(c);
    }
    
    public List<Certidao> listar(){
        
        Criteria criterio = this.session.createCriteria(Certidao.class).addOrder(Order.desc("id")); 
        
        return criterio.list();
    }
    
    public void excluir(Certidao c){
        this.session.delete(c);
    }
    
}
