/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.mail;


import br.com.egresso.util.ContextoUtil;
import java.util.Date;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author stevao.alves
 * 
 *Implementação padrão PAG 478~479
 * 
 */

@ManagedBean
@RequestScoped

public class GmailBean {
    public static final String SERVIDOR_SMTP = "smtp.gmail.com";
    public static final int  PORTA_SERVIDOR_SMTP = 465;
    public static final String CONTA_GMAIL = "egresso.facid@gmail.com";
    public static final String SENHA_GMAIL = "admegressofacid";
    
    private String de = ContextoUtil.getUsuarioBean().getUsuarioLogado().getEmail();
    private String para = "egresso.facid@gmail.com";
    private String assunto = ContextoUtil.getUsuarioBean().getUsuarioLogado().getNome();
    private String conteudo;
    
    public void enviarEmail(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        AutenticaUsuario usuario = new AutenticaUsuario(GmailBean.CONTA_GMAIL, GmailBean.SENHA_GMAIL);
        Session session = Session.getInstance(this.configuracaoEmail(), usuario);
        session.setDebug(true);
        
        try{
            Transport envio = null;
            MimeMessage email = new MimeMessage(session);
            email.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para));
            email.setFrom(new InternetAddress(this.de));
            email.setSubject(this.assunto);
            email.setContent(this.conteudo,"text/plain");
            email.setSentDate(new Date());
            envio = session.getTransport("smtp");
            envio.connect(GmailBean.SERVIDOR_SMTP, GmailBean.PORTA_SERVIDOR_SMTP, GmailBean.CONTA_GMAIL, GmailBean.SENHA_GMAIL);
            email.saveChanges();
            envio.sendMessage(email, email.getAllRecipients());
            envio.close();
            
            contexto.addMessage(null, new FacesMessage("Email enviado com sucesso"));
        }catch(AddressException e){
            FacesMessage mg = new FacesMessage("Erro ao montar mensagem de e-mail! Erro: "+ e.getMessage());
            contexto.addMessage(null,mg);
            return;
        }catch(MessagingException e){
            FacesMessage mg = new FacesMessage("Erro ao enviar e-mail! Erro: "+ e.getMessage());
            contexto.addMessage(null,mg);
            return;
        }
    }
    
    public Properties configuracaoEmail(){
        Properties config = new Properties();
        
        config.put("mail.transport.protocol","smtp");
        config.put ("mail.smtp.starttls.enable", "true"); 
        config.put("mail.smtp.host",SERVIDOR_SMTP);
        config.put("mail.smtp.auth","true");
        config.put("mail.smtp.user",GmailBean.CONTA_GMAIL);
        config.put("mail.debug","true");
        config.put("mail.smtp.debug","true");
        config.put("mail.smtp.starttls.enable","true");
        config.put("mail.smtp.port","465");
        config.put("mail.mime.charset", "ISO-8859-1"); 
        config.put("mail.smtp.socketFactory.port",PORTA_SERVIDOR_SMTP);
        config.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        config.put("mail.smtp.socketFactory.fallback","false");
        
        return config;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
    
    
}
