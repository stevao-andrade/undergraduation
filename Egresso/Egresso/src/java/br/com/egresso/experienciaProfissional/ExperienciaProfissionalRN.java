/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.egresso.experienciaProfissional;

import br.com.egresso.usuario.Usuario;
import br.com.egresso.util.DAOFactory;
import java.util.List;

/**
 *
 * @author stevao.alves
 * 
 * Execução dos metodos da classe DAO feitos por essa classe
 * 
 */
public class ExperienciaProfissionalRN {
    
    /* 
    * Pega instancia da classe DAO para poder usar a sessão do hibernate
    */
    private ExperienciaProfissionalDAO experienciaProfissional = DAOFactory.criaExperienciaProfissionalDAO();
    
    
    /* 
    * salva.
    */
    public void salvar(ExperienciaProfissional experienciaProfissional){
        this.experienciaProfissional.salvar(experienciaProfissional);
    }
    
    /* 
    * exclui.
    */
    public void excluir(ExperienciaProfissional experienciaProfissional){
        this.experienciaProfissional.excluir(experienciaProfissional);
    }
    
    /* 
    * lista.
    */
    public List<ExperienciaProfissional> listar(Usuario usuario){
        return (List)this.experienciaProfissional.listar(usuario);
    }
}
