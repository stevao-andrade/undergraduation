/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fj_informatica
 */
public class BandoDados {

    Connection conexao = null;
    private static BandoDados instance = null;

    public BandoDados() {
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

    public static BandoDados getInstance() {
        if (instance == null) {
            instance = new BandoDados();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/forcajr", "root", "admin");
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
