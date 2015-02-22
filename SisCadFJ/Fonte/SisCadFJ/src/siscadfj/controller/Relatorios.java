/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.controller;

import com.mysql.jdbc.Statement;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import siscadfj.model.Socio;
import siscadfj.view.JDialogRelatorio;

/**
 *
 * @author Stevao
 */
public class Relatorios {

public void geraRelatorio(String nomeRelatorio){

        try{

         //Cria Dialog para receber o relatorio e não ficar sobreposto pelo Dialog Relatorio
         JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
         viewer.setSize(1024,728);
         viewer.setLocationRelativeTo(null);

         //Inicia conexão com BD
        Connection conexao = new BancoDados().getConnection();

        HashMap map = new HashMap();

        //MILAGRE DO CAMINHO RELATIVO
        InputStream is = null;

        is = getClass().getResourceAsStream("/siscadfj/relatorios/"+nomeRelatorio+".jasper");
        JasperReport relat = (JasperReport) JRLoader.loadObject( is );
        JasperPrint jp = JasperFillManager.fillReport(relat, map, conexao);
        //MILAGRE DO CAMINHO RELATIVO

        //CAMINHO ABSOLUTO ABORTADO
        //Cria objeto print com o nome do relatorio "Parametro de conxão para pegar dados do banco"
        //JasperPrint  jp = JasperFillManager.fillReport("./src/siscadfj/relatorios/"+nomeRelatorio+".jasper", map, conexao);
        //CAMINHO ABSOLUTO ABORTADO

        //Objeto para Visualizar o objeto JP
        JasperViewer visualizador = new JasperViewer(jp, false);

        //Seta a visibilidade
        //visualizador.setVisible(true);

        //Adciona o relatorio ao contexto do dialog
        viewer.getContentPane().add(visualizador.getContentPane());
        viewer.setVisible(true);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void gerarComboSocio(JComboBox combo){

        //Cria uma lista para armazenar os socios do banco.
        ArrayList<Socio> lista = new ArrayList<Socio>();

        //Objeto socio para referenciar o nome no combobox
        Socio socio = new Socio();

        //Lista recebe todos os socios cadastrados no banco
        lista = new SocioBD().getListaSocio();

        //Preenche o combobox passado por parametro com todos os nomes dos socios do banco
        for (int i = 0; i <= lista.size() - 1; i++) {

            socio = lista.get(i);
            combo.addItem(socio.getNome());
        }
    }

    public void geraRelatorioIndividual(Socio socio){

        Statement stm = null;
        ResultSet rs = null;

        //Realizando a consulta dinamica que levará em consideração nome do socio pego no combobox
        String sql = "SELECT nomeSocio,cpfSocio,rgSocio,matSocio,sexoSocio,diaNascSocio,mesNascSocio,anoNascSocio"
                + ",enderecoSocio,numEndSocio,bairroSocio,cidadeSocio,estadoSocio,foneSocio,celSocio,emailSocio,blocoSocio"
                + ",funcaoSocio,data,outros FROM socio,outros WHERE nomeSocio = '" + socio.getNome()+ "' AND idSocio = fkIdSocio";
        try{
            stm = (Statement) new BancoDados().getConnection().createStatement();
            rs = stm.executeQuery(sql);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        JRResultSetDataSource jrr = new JRResultSetDataSource(rs);

        //Montando o relatorio
        try {

            //Dialog para inserir o relatorio e evitar sobreposição de Forms
            JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização do Relatório", true);
            viewer.setSize(1024,728);
            viewer.setLocationRelativeTo(null);

            //Inicia conexão com BD
            //Connection conexao = new BancoDados().getConnection();


            //MILAGRE DO CAMINHO RELATIVO
            HashMap map = new HashMap();

            InputStream is = null;

            is = getClass().getResourceAsStream("/siscadfj/relatorios/relatorioIndividual.jasper");
            JasperReport relat = (JasperReport) JRLoader.loadObject( is );
            JasperPrint jp = JasperFillManager.fillReport(relat, map, jrr);
            //MILAGRE DO CAMINHO RELATIVO


            //CAMINHO ABSOLUTO ABORTADO
            //Cria objeto print com o nome do relatorio "Parametro de conxão para pegar dados do banco"
            //JasperPrint jp = JasperFillManager.fillReport("./src/siscadfj/relatorios/relatorioIndividual.jasper", map, jrr/*conexao*/);
            //CAMINHO ABSOLUTO ABORTADO

            //Objeto para Visualizar o objeto JP
            JasperViewer visualizador = new JasperViewer(jp, false);

            //Seta a visibilidade
            //visualizador.setVisible(true);

            //Adciona o relatorio ao contexto do dialog
            viewer.getContentPane().add(visualizador.getContentPane());
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }



}
