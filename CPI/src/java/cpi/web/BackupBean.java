/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Stevao
 */
@ManagedBean
@ViewScoped
public class BackupBean implements Serializable {

    private int numerodobackup;

    public StreamedContent backup() throws IOException {
        File diretorio = new File("C:/Backup");
        File bck = new File("..\\cpi000000.sql");
        StreamedContent arquivoRetorno = null;
        InputStream conteudoRelatorio = null;

        // Cria diretório  
        if (!diretorio.isDirectory()) {
            new File("C:/Backup").mkdir();
        } else {

            // Cria Arquivo de Backup  
            try {
                if (!bck.isFile()) {
                    Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -u root -proot cpi > C:/Backup/cpi000000.sql");
                } else {
                    while (bck.isFile()) {
                        this.numerodobackup++;
                        bck = new File("C:/Backup/cpi000000" + numerodobackup + ".sql");
                    }

                    Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump -u root -proot cpi > " + bck);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        conteudoRelatorio = new FileInputStream(bck);
        arquivoRetorno = new DefaultStreamedContent(conteudoRelatorio);
        return arquivoRetorno;
    }
}
