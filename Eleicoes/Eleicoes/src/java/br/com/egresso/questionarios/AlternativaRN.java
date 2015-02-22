/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.questionarios;

import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author stevao.alves
 */
public class AlternativaRN {

    private AlternativaDAO alternativaDAO;

    public AlternativaRN() {
        this.alternativaDAO = DAOFactory.criaAlternativaDAO();
    }

    public void salvar(Alternativa alternativa) {
        this.alternativaDAO.salvar(alternativa);
    }

    public void excluir(Alternativa alternativa) {
        this.alternativaDAO.excluir(alternativa);
    }
    
    public Alternativa carregar(String alternativaString){
        return this.alternativaDAO.carregar(alternativaString);
    }
    
    public Alternativa carregar(int alternativaID){
        return this.alternativaDAO.carregar(alternativaID);
    }
    
    public List<Alternativa> listar (int questaoID){
        return this.alternativaDAO.listar(questaoID);
    }
    
}
