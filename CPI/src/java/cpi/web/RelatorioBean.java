/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import cpi.controler.RelatorioDAO;
import cpi.util.HibernateUtil;
import cpi.util.MensagemContexto;
import cpi.util.RelatorioUtil;
import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author stevao
 */
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable {

    private int anoPlenaria;
    private String plenariaReferente;
    private int tipoArquivo = 1;
    private StreamedContent arquivoRetorno;
    private String numero;
    private String numero1;
    private String numero2;
    private String tipoPessoa;
    private String tipoProcesso;

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }
    

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getAnoPlenaria() {
        return anoPlenaria;
    }

    public void setAnoPlenaria(int anoPlenaria) {
        this.anoPlenaria = anoPlenaria;
    }

    public String getPlenariaReferente() {
        return plenariaReferente;
    }

    public void setPlenariaReferente(String plenariaReferente) {
        this.plenariaReferente = plenariaReferente;
    }

    public int getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(int tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public void setArquivoRetorno(StreamedContent arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }

    public StreamedContent gerarEspelho() throws JRException, SQLException, FileNotFoundException {

        FacesContext context = FacesContext.getCurrentInstance();
        String nomeRelatorioJasper = "espelho";
        String nomeRelatorioSaida = "espelho_" + this.plenariaReferente + "_" + this.anoPlenaria;


        //Validando os campos do relatorio
        if ("0".equals(this.plenariaReferente) || this.anoPlenaria == 0) {

            MensagemContexto.adicionarMensagem("Por favor selecionar Plenária e Ano de referência corretamente");
            return null;

        } else {

            RelatorioUtil relatorioUtil = new RelatorioUtil();

            HashMap parametros = new HashMap();
            parametros.put("ano", this.anoPlenaria);
            parametros.put("plenaria", this.plenariaReferente);


            try {
                this.arquivoRetorno = relatorioUtil.geraRelatorio(parametros, nomeRelatorioJasper, nomeRelatorioSaida, this.tipoArquivo);
            } catch (JRException e) {
                throw new JRException("Não foi possivel gerar o relatorio", e);
            } catch (FileNotFoundException f) {
                throw new FileNotFoundException("Arquivo não encontrado");
            } catch (SQLException s) {
                throw new SQLException("Erro no SQL!", s);
            }

            return this.arquivoRetorno;
        }
    }

    public StreamedContent exportarXLS() throws FileNotFoundException, SQLException, Exception {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        RelatorioDAO dao = new RelatorioDAO(s);
        StreamedContent arquivoRetorno = null;
        File arquivoGerado = null;

        if ("0".equals(this.plenariaReferente) || this.anoPlenaria == 0) {

            MensagemContexto.adicionarMensagem("Por favor selecionar Plenária e Ano de referência corretamente");
            t.commit();
            s.close();

        } else {

            arquivoGerado = dao.gerarXLS(this.anoPlenaria, this.plenariaReferente);
            t.commit();
            s.close();
            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/xls", "processos_" + this.plenariaReferente + ".xls");
        }

        return arquivoRetorno;
    }

    public StreamedContent exportarRCAsXLS() throws FileNotFoundException, SQLException, Exception {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        RelatorioDAO dao = new RelatorioDAO(s);
        StreamedContent arquivoRetorno = null;
        File arquivoGerado = null;

        if (this.numero.equals("") || this.numero == null) {

            MensagemContexto.adicionarMensagem("Por favor numero de registro da empresa corretamente!");
            t.commit();
            s.close();

        } else {

            arquivoGerado = dao.gerarXLSRCA(this.numero);
            t.commit();
            s.close();
            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/xls", "rcas_Empresa_" + this.numero + ".xls");
        }

        return arquivoRetorno;
    }
    
        public StreamedContent exportarRCAsDataXLS() throws FileNotFoundException, SQLException, Exception {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        RelatorioDAO dao = new RelatorioDAO(s);
        StreamedContent arquivoRetorno = null;
        File arquivoGerado = null;

        if (this.numero1.equals("") || this.numero1 == null || this.numero2.equals("") || this.numero2 == null ){

            MensagemContexto.adicionarMensagem("Por favor informar um intervalo de RCAs valido");
            t.commit();
            s.close();

        } else {

            arquivoGerado = dao.gerarXLSRCAIntervalo(this.numero1, this.numero2);
            t.commit();
            s.close();
            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/xls", "rcas_intervalo_de_" + this.numero1 + "_a_"+this.numero2+".xls");
        }

        return arquivoRetorno;
    }
        
        public StreamedContent exportarXLSFiscalizacao() throws FileNotFoundException, SQLException, Exception {

        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        RelatorioDAO dao = new RelatorioDAO(s);
        StreamedContent arquivoRetorno = null;
        File arquivoGerado = null;

        if ("".equals(this.tipoProcesso) || "".equals(this.tipoPessoa)) {

            MensagemContexto.adicionarMensagem("Por favor informar os dados corretamente");
            t.commit();
            s.close();

        } else {

            arquivoGerado = dao.gerarXLSFiscalizacao(this.tipoProcesso, this.tipoPessoa);
            t.commit();
            s.close();
            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/xls", "fiscalizacao_" + this.tipoProcesso +"_"+tipoPessoa +".xls");
        }

        return arquivoRetorno;
    }
}
