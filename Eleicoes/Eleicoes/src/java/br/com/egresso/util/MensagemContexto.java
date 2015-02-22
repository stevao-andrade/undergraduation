/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author stevao.alves
 */
public class MensagemContexto {

    public static void adicionarMensagem(String detalhe) {
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        FacesMessage mensagem = new FacesMessage(detalhe);
        
        contexto.addMessage(null, mensagem);
    }
}
