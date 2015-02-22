/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.util.ResultSetToExcel;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author stevao
 */
public class RelatorioDAO {

    Session session;

    public RelatorioDAO(Session session) {
        this.session = session;
    }

    public File gerarXLS(int ano, String plenaria) throws SQLException, Exception {

        File arquivoGerado = null;
        ResultSet rs;

        String sql = "SELECT * FROM `cpi`.`processos` WHERE `processos`.`plenaria` = '" + plenaria + "' "
                + "AND `processos`.`anoReferencia` = '" + ano + "'";

        rs = this.session.connection().createStatement().executeQuery(sql);

        ResultSetToExcel resultSetToExcel = new ResultSetToExcel(rs, "RelatorioEmails");
        arquivoGerado = new File("..\\processos_" + plenaria + ".xls");
        resultSetToExcel.generate(arquivoGerado);

        return arquivoGerado;
    }
    
    public File gerarXLSRCA(String numero) throws SQLException, Exception {

        File arquivoGerado = null;
        ResultSet rs;

        String sql = "SELECT numero as 'Numero da RCA',data_pagamento as 'Data de Pagamento',objeto as 'Objeto',numero_empresa as 'Numero de Registro' "
                + "FROM cpi.rca WHERE numero_empresa = '"+  numero +"' ORDER BY id;";

        rs = this.session.connection().createStatement().executeQuery(sql);

        ResultSetToExcel resultSetToExcel = new ResultSetToExcel(rs, "RelatorioIndividual");
        arquivoGerado = new File("..\\rcas_empresa_" + numero + ".xls");
        resultSetToExcel.generate(arquivoGerado);

        return arquivoGerado;
    }
    
        public File gerarXLSRCAIntervalo(String numero1, String numero2) throws SQLException, Exception {

        File arquivoGerado = null;
        ResultSet rs;

        String sql = "SELECT numero as 'Numero da RCA',data_pagamento as 'Data de Pagamento',objeto as 'Objeto',numero_empresa as 'Numero de Registro' "
                + "FROM cpi.rca WHERE numero >= '"+numero1+"' and numero <= '"+numero2+"'  ORDER BY id";

        rs = this.session.connection().createStatement().executeQuery(sql);

        ResultSetToExcel resultSetToExcel = new ResultSetToExcel(rs, "RelatorioIndividual");
        arquivoGerado = new File("..\\intervalo_de_RCAs.xls");
        resultSetToExcel.generate(arquivoGerado);

        return arquivoGerado;
    }
        
        public File gerarXLSFiscalizacao(String tipoDeProcesso, String tipoPessoa) throws SQLException, Exception {

        File arquivoGerado = null;
        ResultSet rs;

        String sql = "SELECT statusProcesso as 'Status',Count(*) as 'Quantidade' FROM cpi.fiscalizacao "
                + "WHERE tipoProcesso = '"+ tipoDeProcesso +"' and tipoFiscalizado = '"+ tipoPessoa +"' group by statusProcesso";

        rs = this.session.connection().createStatement().executeQuery(sql);

        ResultSetToExcel resultSetToExcel = new ResultSetToExcel(rs, "RelatorioIndividual");
        arquivoGerado = new File("..\\relatorioFiscalizacao.xls");
        resultSetToExcel.generate(arquivoGerado);

        return arquivoGerado;
    }
}
