/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.formacaoProfissional;

import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author stevao.alves
 * 
 * Conterá as regras de negocio para o Formacão Profissional. Todas as classe *RN.java fazem 
 * parte da camada Controler, unica camada que se comunica com o Banco de dados.
 */

public class FormacaoProfissionalRN {
    
    private FormacaoProfissionalDAO formacaoProficionalDAO;

    /* 
    * Pega instancia da classe DAO para poder usar a sessão do hibernate
    */
    public FormacaoProfissionalRN() {
        this.formacaoProficionalDAO = DAOFactory.criaFormacaoProfissionalDAO();
    }
    
    /*
     * salva
    */        
    public void salvar(FormacaoProfissional formacaoProfissional){
        this.formacaoProficionalDAO.salvar(formacaoProfissional);
    }

    /*
     * exclui
    */        
    public void excluir(FormacaoProfissional formacaoProfissional){
        this.formacaoProficionalDAO.excluir(formacaoProfissional);
    }

    /*
     * lista
    */        
    public List<FormacaoProfissional> listar(Usuario usuario){
        return (List) this.formacaoProficionalDAO.listar(usuario);
    }
}
