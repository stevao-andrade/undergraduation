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
public class QuestaoRN {
    
    private QuestaoDAO questaoDAO;

    public QuestaoRN() {
        this.questaoDAO = DAOFactory.criaquestaoDAO();
    }
    
    public void salvar(Questao questao){
        this.questaoDAO.salvar(questao);
    }
    
    public void excluir(Questao questao){
        this.questaoDAO.excluir(questao);
    }
    
    public List<Questao> listar(int questionarioID){
        return this.questaoDAO.listar(questionarioID);
    }
    
    public Questao carregar(int questaoID){
        return (Questao) this.questaoDAO.carregar(questaoID);
    }
    
    
}