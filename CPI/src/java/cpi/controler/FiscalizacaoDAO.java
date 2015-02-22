/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Fiscalizacao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author stevao
 */
public class FiscalizacaoDAO {

    Session session;

    public FiscalizacaoDAO(Session session) {
        this.session = session;
    }

    public void salvar(Fiscalizacao f) {
        this.session.saveOrUpdate(f);
    }

    public void excluir(Fiscalizacao f) {
        this.session.delete(f);
    }
    
    public List<Fiscalizacao> listar() {

        Criteria c = this.session.createCriteria(Fiscalizacao.class)
                .addOrder(Order.desc("anoReferencia"))
                .addOrder(Order.desc("processo"));
            
        
        return c.list();
    }
}
