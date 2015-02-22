/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import br.com.egresso.usuario.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author stevao.alves
 */
public class InstituicaoEnsinoDAO {
    
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }
    
    public void salvar(InstituicaoEnsino instituicao){
        this.session.save(instituicao);
    }
    
    public void excluir(InstituicaoEnsino instituicao){
        this.session.delete(instituicao);
    }
    
    public List<InstituicaoEnsino> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(InstituicaoEnsino.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
