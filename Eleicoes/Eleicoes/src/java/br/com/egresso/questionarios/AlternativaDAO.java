/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author stevao.alves
 */
public class AlternativaDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Alternativa alternativa) {
        this.session.save(alternativa);
    }

    public void excluir(Alternativa alternativa) {
        this.session.delete(alternativa);
    }

    public Alternativa carregar(String alternativaString) {
        return (Alternativa) this.session.load(Alternativa.class, alternativaString);
    }
    
    public Alternativa carregar(int alternativaID) {
        return (Alternativa) this.session.load(Alternativa.class, alternativaID);
    }

    public List<Alternativa> listar(int questaoID) {
        String hql = "SELECT a from Alternativa a WHERE a.questao.codigo_questao = :questaoID";
        Query consulta = this.session.createQuery(hql);
        consulta.setInteger("questaoID", questaoID);
        return consulta.list();
    }
}
