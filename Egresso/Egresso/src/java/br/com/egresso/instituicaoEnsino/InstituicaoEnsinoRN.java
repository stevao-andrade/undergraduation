/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.instituicaoEnsino;

import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author stevao.alves
 */
public class InstituicaoEnsinoRN {
    
    private InstituicaoEnsinoDAO instituicaoEnsinoDAO;

    public InstituicaoEnsinoRN() {
        this.instituicaoEnsinoDAO = DAOFactory.criaInstituicaoEnsinoDAO();
    }
    
    public void salvar(InstituicaoEnsino instituicao){
        this.instituicaoEnsinoDAO.salvar(instituicao);
    }
    
    public void excluir(InstituicaoEnsino instituicao){
        this.instituicaoEnsinoDAO.excluir(instituicao);
    }
    
    public List<InstituicaoEnsino> listar(Usuario usuario){
        return (List) this.instituicaoEnsinoDAO.listar(usuario);
    }
    
    
}
