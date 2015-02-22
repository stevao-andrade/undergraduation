/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.administracao;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Stevão Andrade
 * 
 * Regras de acesso ao BD para a tabela administrador
 * 
 */
public class AdministradorDAO {

    private Session session;

    /**
     * Inicia sessão do Hibernate.
     */
    public void setSession(Session session) {
        this.session = session;
    }

     /**
     * Busca objeto administrador por Login.
     */
    public Administrador buscaPorLogin(String login) {
        String hql = "select a from Administrador a where a.login = :login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);
        return (Administrador) consulta.uniqueResult();
    }
    
     /**
     * Atualiza os dados do objeto administrador
     */
    public void atualizar(Administrador adm) {
        this.session.update(adm);
    }
}
