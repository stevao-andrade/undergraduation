/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.relatorios;

import br.com.egresso.questionarios.Questao;
import br.com.egresso.util.ResultSetToExcel;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author stevao.
 */
public class ConsultasDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Object> consultaQuestionarios(Questao questao) {

        String sql2 = "select a.enunciadoAlternativa, count(r.codigo_alternativa) as numero"
                + " from respostas r,alternativas a"
                + " where r.codigo_questao = " + questao.getCodigo_questao() + ""
                + " and a.codigo_alternativa = r.codigo_alternativa group by r.codigo_alternativa";

            return this.session.createSQLQuery(sql2).list();
        
    }

    public List<Object> consultaAreaDeFormacao(String curso) {

        String sql = "select e.areaFormacao, count(e.areaFormacao) as numero"
                + " from experienciaprofissional e  group by e.areaFormacao";
        String sql2 = "select e.areaFormacao, count(e.areaFormacao) as numero"
                + " from experienciaprofissional e, instituicao_ensino i "
                + " where i.curso = '" + curso + "'  group by e.`areaFormacao`";
        if (curso.equals("Todos")) {
            return this.session.createSQLQuery(sql).list();
        } else
            return this.session.createSQLQuery(sql2).list();
    }
    
    public File gerarEmails(String curso) throws SQLException, Exception{
        File arquivoGerado = null;
        ResultSet rs;
        
        String sql = "SELECT  u.nome,u.email FROM usuario u";
        
        String sql2= "SELECT  u.nome,u.email FROM usuario u,instituicao_ensino i" 
        +" WHERE u.codigo_usuario = i.codigo_usuario and i.curso = '"+ curso +"'";
        
        if (curso == null)
            rs = this.session.connection().createStatement().executeQuery(sql);
        else 
            rs = this.session.connection().createStatement().executeQuery(sql2);
        
       ResultSetToExcel resultSetToExcel = new ResultSetToExcel(rs, "RelatorioEmails");
       arquivoGerado = new File("..\\emails.xls");
       resultSetToExcel.generate(arquivoGerado); 
        
        return arquivoGerado;
    }
}


