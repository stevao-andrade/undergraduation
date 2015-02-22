/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.util;




import cpi.controler.ConexaoMySQL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author stevao
 */
public class RelatorioUtil {

    public static final int RELATORIO_PDF = 1;
    public static final int RELATORIO_EXCEL = 2;
    public static final int RELATORIO_HTML = 3;
    public static final int RELATORIO_OPEN_OFFICE = 4;
    
    public StreamedContent geraRelatorio(HashMap parametroRelatorio, String nomeRelatorioJasper, String nomeRelatorioSaida, int tipoRelatorio) throws JRException, FileNotFoundException, SQLException {
        
        
        StreamedContent arquivoRetorno = null;
        
        try{
            FacesContext contexto = FacesContext.getCurrentInstance();
            String caminhoRelatorio = contexto.getExternalContext().getRealPath(File.separator + "WEB-INF"+ File.separator +"classes"+ File.separator +"cpi"+ File.separator +"relatorios");
            //String caminhoRelatorio = contexto.getExternalContext().getRealPath("relatorios");
            String caminhoArquivoJasper = caminhoRelatorio + File.separator + nomeRelatorioJasper + ".jasper";
            String caminhoArquivoRelatorio = null;
            
            Connection conexao = ConexaoMySQL.getInstance().getConnection();
            
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject(caminhoArquivoJasper);
             
            
            JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parametroRelatorio, conexao);
         
            JRExporter tipoArquivoExportado = null;
            String extensaoArquivoExportado = "";
            File arquivoGerado = null;
            
            switch(tipoRelatorio){
                
                case RelatorioUtil.RELATORIO_PDF:
                    tipoArquivoExportado = new JRPdfExporter();
                    extensaoArquivoExportado = "pdf";
                    break;
                    
                case RelatorioUtil.RELATORIO_EXCEL:
                    tipoArquivoExportado = new JRXlsxExporter();
                    extensaoArquivoExportado = "xlsx";
                    break;
                
                case RelatorioUtil.RELATORIO_HTML:
                    tipoArquivoExportado = new JRHtmlExporter();
                    extensaoArquivoExportado = "html";
                    break;
                
                case RelatorioUtil.RELATORIO_OPEN_OFFICE:
                    tipoArquivoExportado = new JROdtExporter();
                    extensaoArquivoExportado = "odt";
                    break;
                    
                default:
                    tipoArquivoExportado = new JRPdfExporter();
                    extensaoArquivoExportado = "pdf";
                    break;
            }
            
            caminhoArquivoRelatorio = caminhoRelatorio + File.separator + nomeRelatorioSaida + "." + extensaoArquivoExportado;
            arquivoGerado = new File(caminhoArquivoRelatorio);
            
            tipoArquivoExportado.setParameter(JRExporterParameter.JASPER_PRINT, impressoraJasper);
            tipoArquivoExportado.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
            tipoArquivoExportado.exportReport();
            arquivoGerado.deleteOnExit();
            
            InputStream conteudoRelatorio = new FileInputStream(arquivoGerado);
            arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio, "application/"+ extensaoArquivoExportado, nomeRelatorioSaida +"."+ extensaoArquivoExportado);
        }catch(JRException e){
            throw new JRException("Não foi possivel gerar o relatorio", e);
        }catch(FileNotFoundException f){
            throw new FileNotFoundException("Arquivo não encontrado");
        }
        return arquivoRetorno;
                
    }
}
