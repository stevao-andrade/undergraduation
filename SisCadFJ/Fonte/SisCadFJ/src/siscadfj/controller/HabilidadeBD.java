/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.controller;

import siscadfj.model.Socio;
import siscadfj.model.HabilidadeValor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import siscadfj.model.HabilidadeNome;

/**
 *
 * @author fj_informatica
 */
public class HabilidadeBD {

    Connection connection = null;


    public boolean inserirHabilidade(HabilidadeValor habilidade) {

//Iniciar e fechar as conexões dos objetos antes de iniciar a conexão para inserir.//
        //Objeto para pegar Info do socio
        SocioBD socioBD = new SocioBD();

        //Objeto para receber as informações
        Socio socio = new Socio();

        socio = socioBD.getSocioInfo();

        int id = socio.getId();

        //Lista que contem o ID de todas as habilidades
        ArrayList<HabilidadeNome> listaHabilidade = new ArrayList<HabilidadeNome>();
        listaHabilidade = getHabIdNome();


        System.out.println("inserirHabilidade");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir habilidades");
        Statement stmt = null;
        try {

            stmt = connection.createStatement();

            //Inserir dados na tabela habilidade_socio!

            // Se banco de dados estiver marcado, insere o ID do socio e o Id da Habilidade Banco de dados
            if(habilidade.isBancoDeDados()){
                
                HabilidadeNome habNumber = listaHabilidade.get(0);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isCss()){

                HabilidadeNome habNumber = listaHabilidade.get(1);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isC()){

                HabilidadeNome habNumber = listaHabilidade.get(2);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isIa()){

                HabilidadeNome habNumber = listaHabilidade.get(3);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isJava()){

                HabilidadeNome habNumber = listaHabilidade.get(4);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isSuporte()){

                HabilidadeNome habNumber = listaHabilidade.get(5);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isDelphi()){

                HabilidadeNome habNumber = listaHabilidade.get(6);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isDesign()){

                HabilidadeNome habNumber = listaHabilidade.get(7);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isHtml()){

                HabilidadeNome habNumber = listaHabilidade.get(8);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isPhp()){

                HabilidadeNome habNumber = listaHabilidade.get(9);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isRedes()){

                HabilidadeNome habNumber = listaHabilidade.get(10);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isRuby()){

                HabilidadeNome habNumber = listaHabilidade.get(11);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }


            String sql = "INSERT INTO outros (FkIdSocio,outros) VALUES ('"+ id +"','" + habilidade.getOutros()+"')";
            stmt.executeUpdate(sql);

            System.out.println("Habilidades inseridas com sucesso");
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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
    } // fim do metodo InserirHabilidade


    public ArrayList<HabilidadeNome> getHabIdNome() {
        ArrayList<HabilidadeNome> listaHabilidade = new ArrayList<HabilidadeNome>();
        // iniciando a conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando listagem da tabela habilidades");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM habilidades");

            // Incluindo habilidades na listaHabilidades que vai ser retornada
            while (rs.next()) {
                HabilidadeNome hab = new HabilidadeNome(rs.getInt("idHab"),rs.getString("nomeHabilidade"));
                listaHabilidade.add(hab);
            }
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
   
        return listaHabilidade;
    } // final do metodo



        public boolean excluirSocioHab(Socio socio) {

        System.out.println("excluirHabilidade");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT idSocio FROM socio WHERE nomeSocio = '"+ socio.getNome() +"'");

            //Iniciando o result set.
            rs.next();

            //Armazena id do socio pego na variavel
            int id = rs.getInt("idSocio");
            
            String sql = "DELETE FROM sociohab WHERE FkIdSocio = '" + id + "'";
            stmt.executeUpdate(sql);
            System.out.println("SQL: " + sql);
            
            String sql2 = "DELETE FROM outros WHERE fkIdSocio = '" + id + "'";
            stmt.executeUpdate(sql2);

            System.out.println("SQL:2 " + sql+sql2);

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            // este bloco finally sempre executa na instrução try para
            // fechar a conexão a cada conexão aberta
            try {
                stmt.close();
                connection.close();
                System.out.println("Banco fechado, excluido com sucesso");
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }


        public HabilidadeValor getInfoHab(Socio socio) {

        //Array que recebe as habilidades consultadas do socio
        ArrayList<HabilidadeNome> listaHabilidade = new ArrayList<HabilidadeNome>();

        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para pegar habilidades do Socio a ser alterado");
        Statement stmt = null;
        try {

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sociohab Where FkIdSocio = '" + socio.getId() +"'");

            String sql = "SELECT * FROM sociohab Where FkIdSocio = '" + socio.getId() + "'";
            System.out.println("SQL: " + sql);
            
            // Incluindo Habilidades existentes na lista vai ser retornada
            while (rs.next()) {
                HabilidadeNome hab = new HabilidadeNome(rs.getInt("FkIdHab"),rs.getString("nomeHabilidade"));
                listaHabilidade.add(hab);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

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
       
        // Objeto com valor de cada habilidade iniciaalmente falsas. "Desemarcadas no checkbox"
        HabilidadeValor habilidadeNome = new HabilidadeValor();

        //Colocando as "outras informaçoes" no objeto
        habilidadeNome.setOutros(getInfoOutros(socio));

        //Objeto para rodar a lista e pegar o nome das Habilidades que o usuario possui no banco
        HabilidadeNome loop = new HabilidadeNome();

        
        //Laço para fazer teste e verificar quais habilidades ele possui.
        for(int i=0; i<= listaHabilidade.size()-1;i++){

            
            loop = listaHabilidade.get(i);
           
            if (loop.getNomeHab().equals("Banco de Dados")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                habilidadeNome.setBancoDeDados(true);
            }
                    

            if (loop.getNomeHab().equals("CSS")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setCss(true);
            }

            if (loop.getNomeHab().equals("C")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setC(true);
            }

            if (loop.getNomeHab().equals("IA")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setIa(true);
            }

            if (loop.getNomeHab().equals("Java")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setJava(true);
            }

            if (loop.getNomeHab().equals("Suporte")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setSuporte(true);
            }

            if (loop.getNomeHab().equals("Delphi")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setDelphi(true);
            }

            if (loop.getNomeHab().equals("Design")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setDesign(true);
            }

            if (loop.getNomeHab().equals("HTML")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setHtml(true);
            }

            if (loop.getNomeHab().equals("PHP")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setPhp(true);
            }

            if (loop.getNomeHab().equals("Redes")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setRedes(true);
            }

            if (loop.getNomeHab().equals("Ruby")){
                System.out.println("Socio possui habilidade "+ loop.getNomeHab() +"");
                    habilidadeNome.setRuby(true);
            }
            
        }
         
         //Retorna objeto com as habilidades do socio que estavam no banco. 
        return habilidadeNome;
    } // final do metodo



   public String getInfoOutros(Socio socio) {
       
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para pegar Outras habilidades do Socio a ser alterado");
        Statement stmt = null;

        HabilidadeValor hab = new HabilidadeValor();

        try {

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM outros Where fkIdSocio = '" + socio.getId() +"'");

            

            // Incluindo Outras Habilidades existentes no objeto que vai ser retornado
            rs.next();
            hab.setOutros(rs.getString("outros"));

            

            
            ResultSet rs2 = stmt.executeQuery("SELECT idSocio FROM socio WHERE nomeSocio = '"+ socio.getNome() +"'");

            

            //Iniciando o result set.
            rs2.next();

            //Armazena id do socio pego na variavel
            int id = rs2.getInt("idSocio");

            
            //Deleta as habilidades antigas para colocar novas.
            String sql2 = "DELETE FROM sociohab WHERE FkIdSocio = '" + id + "'";
            stmt.executeUpdate(sql2);
            System.out.println("SQL: " + sql2);

            //Deleta as habilidades antigas para colocar novas.
            String sql3 = "DELETE FROM outros WHERE fkIdSocio = '" + id + "'";
            stmt.executeUpdate(sql3);
            System.out.println("SQL: " + sql3);

            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());

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

         //Retorna string com outras habilidades do socio que estavam no banco.
        return hab.getOutros();
    } // final do metodo



    public boolean atualuzarHabilidade(HabilidadeValor habilidade) {

        //Iniciar e fechar as conexões dos objetos antes de iniciar a conexão do banco para inserir.//
        //Objeto para pegar Info do socio
        SocioBD socioBD = new SocioBD();

        //Objeto para receber as informações
        Socio socio = new Socio();

        socio = socioBD.getSocioInfoAtualizar();

        int id = socio.getId();

        //Lista que contem o ID de todas as habilidades
        ArrayList<HabilidadeNome> listaHabilidade = new ArrayList<HabilidadeNome>();
        listaHabilidade = getHabIdNome();


        System.out.println("atualizarHabilidade");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir habilidades");
        Statement stmt = null;
        try {

            stmt = connection.createStatement();

            //Atualizar dados na tabela habilidade_socio!

            // Se habilidade banco de dados estiver marcado, insere o ID do socio e o Id da Habilidade Banco de dados
            if(habilidade.isBancoDeDados()){

                HabilidadeNome habNumber = listaHabilidade.get(0);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isCss()){

                HabilidadeNome habNumber = listaHabilidade.get(1);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isC()){

                HabilidadeNome habNumber = listaHabilidade.get(2);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isIa()){

                HabilidadeNome habNumber = listaHabilidade.get(3);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isJava()){

                HabilidadeNome habNumber = listaHabilidade.get(4);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isSuporte()){

                HabilidadeNome habNumber = listaHabilidade.get(5);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isDelphi()){

                HabilidadeNome habNumber = listaHabilidade.get(6);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isDesign()){

                HabilidadeNome habNumber = listaHabilidade.get(7);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isHtml()){

                HabilidadeNome habNumber = listaHabilidade.get(8);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isPhp()){

                HabilidadeNome habNumber = listaHabilidade.get(9);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isRedes()){

                HabilidadeNome habNumber = listaHabilidade.get(10);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }

            if(habilidade.isRuby()){

                HabilidadeNome habNumber = listaHabilidade.get(11);
                String sql = "INSERT INTO sociohab (FkIdSocio,FkIdHab, nomeHabilidade) VALUES ('"+ id +"','" + habNumber.getIdHab()+"','"+ habNumber.getNomeHab() +"')";
                stmt.executeUpdate(sql);
            }


            String sql = "INSERT INTO outros (FkIdSocio,outros) VALUES ('"+ id +"','" + habilidade.getOutros()+"')";
            stmt.executeUpdate(sql);

            System.out.println("Habilidades inseridas com sucesso");

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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
    } // fim do metodo Atualizar Habilidades

}
