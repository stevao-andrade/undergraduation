/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.usuario.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author stevao.alves
 */
public class QuestionarioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Questionario questionario) {
        this.session.save(questionario);
    }

    public void excluir(Questionario questionario) {
        this.session.delete(questionario);
    }

    public List<Questionario> listar() {
        return this.session.createCriteria(Questionario.class).list();
    }

    public Questionario carregar(int questionarioID) {
        return (Questionario) this.session.get(Questionario.class, questionarioID);
    }
    
    public Questionario buscaPorNomeQuestionario(String nomeQuestionario) {
        String hql = "select q from Questionario q where q.nomeQuestionario = :nomeQuestionario";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("nomeQuestionario", nomeQuestionario);
        return (Questionario) consulta.uniqueResult();
    }

    public List<Questionario> questionariosDisponiveis(Usuario usuario) {
        String sql = "SELECT * FROM questionarios q"
                + "  WHERE q.codigo_questionario NOT IN"
                + " (SELECT qu.codigo_questionario FROM usuario_questionario qu where qu.codigo_usuario = " + usuario.getCodigo_usuario() + ")";

        List<Questionario> listaBruta = this.session.createSQLQuery(sql)
                .addEntity(Questionario.class)
                .list();
        return listaBruta;
    }
}
