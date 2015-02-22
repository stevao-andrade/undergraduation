/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Processo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author stevao
 */
public class ProcessoDAO {

    Session session;

    public ProcessoDAO(Session session) {
        this.session = session;
    }

    public void salvar(Processo p) {
        this.session.saveOrUpdate(p);
    }

    public List<Processo> listar() {

        Criteria criterio = this.session.createCriteria(Processo.class).addOrder(Order.desc("numeroProcesso"));


        return criterio.list();
    }

    public void excluir(Processo p) {
        this.session.delete(p);
    }

    public List gerarDadosParaEspelho(int ano, String plenaria) {

        String sql = "SELECT p.tipo FROM processos p WHERE p.anoReferencia = '" + ano + "' AND p.plenaria = '" + plenaria + "'";

        return this.session.createSQLQuery(sql).list();

    }
}
