/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import siscadfj.model.Usuario;

/**
 *
 * @author fj_informatica
 */
public class UsuarioBD {

    Connection connection = null;

    public Usuario getUserPass() {
        Usuario user = new Usuario("" ,"");
        // iniciando a conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para pegar dados");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
            // Incluindo usuario e senha no objeto

            rs.next();
            user.setUser(rs.getString("nomeUsuario"));
            user.setPass(rs.getString("senhaUsuario"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            // este bloco finally sempre executa na instrução try para
            // fechar a conexão a cada conexão aberta
            try {
                stmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
        return user;
    } // final do metodo

}
