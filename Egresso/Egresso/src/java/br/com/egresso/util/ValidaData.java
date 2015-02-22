/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.util;

import java.util.Date;

/**
 *
 * @author stevao.alves
 */
public class ValidaData {
    
    public static boolean validar(Date inicio,Date fim ){
        
        if(fim.before(inicio))
            MensagemContexto.adicionarMensagem("Favor informar data corretamente!");
        return fim.before(inicio);
    }
    
}
