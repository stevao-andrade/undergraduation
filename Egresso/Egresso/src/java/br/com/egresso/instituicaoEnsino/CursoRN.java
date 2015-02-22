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
public class CursoRN {
    
    private CursoDAO cursoDAO;

    public CursoRN() {
        this.cursoDAO = DAOFactory.criaCursoDAO();
    }
    
    public List listar(){
        return cursoDAO.listar();
    }
    
}
