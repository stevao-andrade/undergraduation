/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpi.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fj_informatica
 */
public class ConexaoMySQL {

    Connection conexao = null;
    private static ConexaoMySQL instance = null;

    public ConexaoMySQL() {
        inicio();
    }

    public void inicio() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Carregado");
        } catch (ClassNotFoundException e) {
            System.out.println("O driver do Mysql não pôde ser carregado!");
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/cpi", "root", "root");
                System.out.println("Conexão Estabelecida");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }

    public void destroy() {
        try {
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
