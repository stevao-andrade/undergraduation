/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author stevao.alves
 */
public class FaculdadeRN {
    
    private FaculdadeDAO faculdadeDAO;

    public FaculdadeRN() {
        this.faculdadeDAO = DAOFactory.criaFaculdadeDAO();
    }
    
    public List listar(){
        return faculdadeDAO.listar();
    }
}
