/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.relatorios;


import br.com.egresso.questionarios.Questao;
import br.com.egresso.util.DAOFactory;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author stevao.alves
 */
public class ConsultasRN {
    
    private ConsultasDAO consulta;

    public ConsultasRN() {
        this.consulta = DAOFactory.criaConsultaDAO();
    }
    
    public List<Object> consultaQuestionario(Questao questao){
        return consulta.consultaQuestionarios(questao);        
    }
    
    public List<Object> consultaAreaDeFormacao(String curso){
        return this.consulta.consultaAreaDeFormacao(curso);
    }
    
    public File gerarEmail(String curso) throws SQLException, Exception{
        return this.consulta.gerarEmails(curso);
    }
}
