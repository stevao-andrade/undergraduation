/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import cpi.modelo.Plenaria;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author stevao
 */
public class PlenariaDAO {
    
    private Session sesssion;

    public PlenariaDAO(Session sesssion) {
        this.sesssion = sesssion;
    }
    
    public List<Plenaria> listar(){
        
        return this.sesssion.createCriteria(Plenaria.class).list();
    }
}
