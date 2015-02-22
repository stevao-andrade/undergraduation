/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.formacaoProfissional;

import br.com.egresso.usuario.Usuario;
import java.util.List;
import javax.faces.model.DataModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author stevao.alves
 */
public class FormacaoProfissionalDAO {
    
    /*Sessão do Hibernate que será utilizada para realizar as transações com os 
    * objetos.
    */
    private Session session;
    
    public void setSession(Session session){
        this.session=session;
    }

    /*
     * salva
    */    
    public void salvar(FormacaoProfissional formacaoProfissional){
        session.saveOrUpdate(formacaoProfissional);
    }

    /*
     * exclui
    */    
    public void excluir(FormacaoProfissional formacaoProfissional){
        session.delete(formacaoProfissional);
    }

    /*
     * lista
    */    
    public List<FormacaoProfissional> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(FormacaoProfissional.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
