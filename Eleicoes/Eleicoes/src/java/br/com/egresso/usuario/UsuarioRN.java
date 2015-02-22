package br.com.egresso.usuario;

import br.com.egresso.util.DAOFactory;
import java.util.List;


/**
 * @author Stevão Andrade
 * 
 * Conterá as regras de negocio para o Usuario. Todas as classe *RN.java fazem 
 * parte da camada Controler, unica camada que se comunica com o Banco de dados.
 */
public class UsuarioRN {
    
    private UsuarioDAO usuarioDAO;
    
    public UsuarioRN(){
        this.usuarioDAO = DAOFactory.criaUsuarioDAO();
    }
    
    public Usuario carregar(Integer codigo){
        return this.usuarioDAO.carregar(codigo);
    }
    
    public Usuario buscarPorLogin (String login){
        return this.usuarioDAO.buscaPorLogin(login);
    }
    
    public void salvar (Usuario usuario){
        Integer codigo = usuario.getCodigo_usuario();
        
        if(codigo == null || codigo == 0){
            this.usuarioDAO.salvar(usuario);   
        }else{
            this.usuarioDAO.atualizar(usuario);
        }
    }
    
    public void excluir(Usuario usuario){
        this.usuarioDAO.excluir(usuario);
    }
    
    public List<Usuario> listar(){
        return this.usuarioDAO.listar();
    }
}