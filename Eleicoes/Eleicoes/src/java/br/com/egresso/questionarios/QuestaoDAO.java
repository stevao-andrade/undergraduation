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
public class QuestaoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Questao questao) {
        this.session.save(questao);
    }

    public void excluir(Questao questao) {
        this.session.delete(questao);
    }

    public List<Questao> listar(int questionarioID) {
        String hql = "SELECT q from Questao q WHERE q.questionario.codigo_questionario = :questionarioID";
        Query consulta = this.session.createQuery(hql);
        consulta.setInteger("questionarioID", questionarioID);
        return consulta.list();
    }

    public Questao carregar(int questaoID) {
        return (Questao) this.session.get(Questao.class, questaoID);
    }
}