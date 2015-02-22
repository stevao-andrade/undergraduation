/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.administracao;

import br.com.egresso.util.DAOFactory;

/**
 *
 * @author Stevão Andrade
 * 
 * Separa DAO da regra de negocio. Para efetuar as alterações no banco sempre utilizar
 * objetos da regra de negocio
 */
public class AdministradorRN {

    AdministradorDAO admDAO = new AdministradorDAO();

     /**
     * No momento de construção do objeto *RN instancia o DAO atraves de uma classe estatica. 
     * Assim o objeto RN possui a sessão do DAO
     */
    public AdministradorRN() {
        admDAO = DAOFactory.criaAdministradorDAO();
    }
    
    /**
     * Busca por login.
     */    
    public Administrador buscaPorLogin(String login){
        return admDAO.buscaPorLogin(login);
    }
    
    /**
     * atualiza os dados do objeto.
     */    
    public void atualizar (Administrador adm){
        admDAO.atualizar(adm);
    }
    
}
