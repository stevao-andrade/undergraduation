/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.util.DAOFactory;

/**
 *
 * @author stevao
 */
public class RespostaRN {
    
    private RespostaDAO respostaDAO;

    public RespostaRN() {
        this.respostaDAO = DAOFactory.criaRespostaDAO();
    }
    
    public void salvar(Resposta resposta){
        this.respostaDAO.salvar(resposta);
    }
    
}
