/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.RCA;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author stevao
 */
public class RcaDAO {
    

    Session session;

    public RcaDAO(Session session) {
        this.session = session;
    }

    public void salvar(RCA r) {
        this.session.saveOrUpdate(r);
    }

    public void excluir(RCA r) {
        this.session.delete(r);
    }
    
    public List<RCA> listar() {

        Criteria criterio = this.session.createCriteria(RCA.class).addOrder(Order.desc("id"));

        return criterio.list();
    }
}
