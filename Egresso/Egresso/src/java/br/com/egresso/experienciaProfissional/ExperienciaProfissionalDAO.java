/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.experienciaProfissional;

import br.com.egresso.usuario.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author stevao.alves
 */
public class ExperienciaProfissionalDAO {
    
    /*Sessão do Hibernate que será utilizada para realizar as transações com os 
    * objetos.
    */
    private Session session;
    
    /* 
    * setter de sessão para usar no RN.
    */
    public void setSession(Session session){
        this.session=session;
    }
    
    /* 
    * salva.
    */
    public void salvar(ExperienciaProfissional experienciaProfissional){
        session.saveOrUpdate(experienciaProfissional);
    }
    
    /*
    * exclui.
    */
    public void excluir(ExperienciaProfissional experienciaProfissional){
        session.delete(experienciaProfissional);
    }

    /*Lista todas as experiencias por usuario 
    * 
    */    
    public List<ExperienciaProfissional> listar(Usuario usuario) {
        Criteria criteria = this.session.createCriteria(ExperienciaProfissional.class);
        criteria.add(Restrictions.eq("usuario", usuario));
        return criteria.list();
    }
}
