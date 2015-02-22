/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpi.controler;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author stevao
 */
public class ConexaoFireBird {

    Connection conexao = null;
    private static ConexaoFireBird instance = null;

    public static ConexaoFireBird getInstance() {
        if (instance == null) {
            instance = new ConexaoFireBird();
        }
        return instance;
    }

     public Connection getConnection() {

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            //diretório do Banco de Dados Firebird
             this.conexao = DriverManager.getConnection("jdbc:firebirdsql:localhost:C:" + File.separator + "Fortes" + File.separator + "AG" + File.separator + "ag.fdb", "SYSDBA", "masterkey");

            System.out.println("Conectado!");

            conexao.close();

        } catch (Exception e) {

            System.out.println("nao conectado!");

        }
        return this.conexao;
    }

    public void destroy() {
        try {
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
