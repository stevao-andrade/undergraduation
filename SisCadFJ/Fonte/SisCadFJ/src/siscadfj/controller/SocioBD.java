/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siscadfj.controller;


import siscadfj.model.Socio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author fj_informatica
 */
public class SocioBD {

    Connection connection = null;

    public boolean inserirSocio(Socio socio) {
        System.out.println("inserirSocio");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            //Inserir dados na tabela SOCIO!
            String sql = "INSERT INTO socio (nomeSocio,cpfSocio,rgSocio,matSocio,sexoSocio,diaNascSocio,mesNascSocio,anoNascSocio"
                                             + ",enderecoSocio,numEndSocio,bairroSocio,cidadeSocio,estadoSocio"
                                             + ",foneSocio,celSocio,emailSocio,blocoSocio,funcaoSocio) VALUES ('"+ socio.getNome()+"','" + socio.getCpf()+"','" + socio.getRg()+"','" +
                                             socio.getMatricula()+"','" + socio.getSexo()+"','" + socio.getDia()+"','" + socio.getMes()+"','" + socio.getAno()+"','" +
                                             socio.getEndereco()+"','" + socio.getNumEndereco()+"','" + socio.getBairro()+"','" + socio.getCidade()+"','" + socio.getEstado()+"','" +
                                             socio.getFone()+"','" + socio.getCel()+"','" + socio.getEmail()+"','" + socio.getBloco()+"','" + socio.getFuncao()+"')";

            System.out.println("SQL: " + sql);
            System.out.println("Socio inserido com sucesso");
            stmt.executeUpdate(sql);
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
    } // fim do metodo InserirSocio


        public boolean atualizarSocio(Socio socio) {
        System.out.println("altualizarSocio");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            //Inserir dados na tabela SOCIO!
            String sql = "UPDATE socio SET  cpfSocio = '" + socio.getCpf() +"',rgSocio = '" + socio.getRg()
                    +"',matSocio = '" + socio.getMatricula() +"',sexoSocio = '" + socio.getSexo() +"',diaNascSocio = '" + socio.getDia()
                    +"',mesNascSocio = '" + socio.getMes() +"',anoNascSocio = '" + socio.getAno() +"',enderecoSocio = '" + socio.getEndereco()
                    +"',numEndSocio = '" + socio.getNumEndereco() +"',bairroSocio = '" + socio.getBairro() +"',cidadeSocio = '" + socio.getCidade()
                    +"',estadoSocio = '" + socio.getEstado() +"',foneSocio = '" + socio.getFone() +"',celSocio = '" + socio.getCel() +"',emailSocio = '" + socio.getEmail()
                    +"',blocoSocio = '" + socio.getBloco() +"',funcaoSocio = '" + socio.getFuncao() +"' WHERE nomeSocio = '" + socio.getNome() + "'";

            System.out.println("SQL: " + sql);
            System.out.println("Dados do Socio alterados com sucesso");
            stmt.executeUpdate(sql);

            String sql2 = "UPDATE socio SET  nomeSocio = '" + socio.getNome() +"' WHERE cpfSocio = '" + socio.getCpf() + "'";
            System.out.println("SQL: " + sql);
            System.out.println("Nome do socio alterado com sucesso");
            stmt.executeUpdate(sql2);

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
    } // fim do metodo atualizar


    

    /**
     * Este metodo conecta no banco e retorna uma ArrayList dos socios
     
     */
    public ArrayList<Socio> getListaSocio() {
        ArrayList<Socio> listaSocio = new ArrayList<Socio>();
        // iniciando a conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando listagem de socio");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM socio ORDER BY nomeSocio");

            // Incluindo Socios na listaSocios que vai ser retornada
            while (rs.next()) {
                Socio socio = new Socio(rs.getString("nomeSocio"), rs.getString("matSocio"), rs.getString("blocoSocio"), rs.getString("funcaoSocio"),rs.getInt("idSocio"));
                listaSocio.add(socio);
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
        return listaSocio;
    } // final do metodo

    // deleta socio
    public boolean excluirSocio(Socio socio) {
        System.out.println("excluirSocio");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
       
        try {
            stmt = connection.createStatement();

            String sql = "DELETE FROM socio WHERE nomeSocio = '" + socio.getNome() + "'";
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            
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


    //Pega ultimo socio inserido em socios
       public Socio getSocioInfo() {

        ArrayList<Socio> listaSocio = new ArrayList<Socio>();
        // iniciando a conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando listagem para pegar Socio");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM socio");

            // Incluindo Socios na listaSocios que vai ser retornada
            while (rs.next()) {
                Socio socio = new Socio(rs.getString("nomeSocio"), rs.getString("matSocio"), rs.getString("blocoSocio"), rs.getString("funcaoSocio"),rs.getInt("idSocio"));
                listaSocio.add(socio);
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

        Socio socioMax = new Socio();

        socioMax = listaSocio.get(0);

        //Se houver mais de um socio na lista vai procurar o de maior ID
        if(listaSocio.size()-1 > 0){

            for(int i=0; i<= listaSocio.size()-1; i++){

                Socio socio = new Socio();
                socio = listaSocio.get(i);

                if(socio.getId()>= socioMax.getId() ){
                    socioMax = socio;
                }

            }

        }
        //Se não pega o primeiro
        else {
                socioMax = listaSocio.get(0);

            }

        System.out.println(socioMax.getId());

        //Retorna o socio de maior ID, logo o ultimo inserido.
        return socioMax;
    } // final do metodo


        //Pega ultimo socio inserido em alterados
       public Socio getSocioInfoAtualizar() {

        ArrayList<Socio> listaSocio = new ArrayList<Socio>();
        // iniciando a conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado e preparando listagem para pegar Socio"); 
        Statement stmt = null;


        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alterados");

            // Incluindo Socios na listaSocios que vai ser retornada
            while (rs.next()) {
                Socio socio = new Socio (rs.getString("nomeSocio"),rs.getString("cpfSocio"),rs.getString("rgSocio"),
                                        rs.getString("matSocio"),rs.getString("sexoSocio"),rs.getString("diaNascSocio"),
                                        rs.getString("mesNascSocio"),rs.getString("anoNascSocio"),rs.getString("enderecoSocio"),
                                        rs.getString("numEndSocio"),rs.getString("bairroSocio"),rs.getString("cidadeSocio"),
                                        rs.getString("estadoSocio"),rs.getString("foneSocio"),rs.getString("celSocio"),
                                        rs.getString("emailSocio"),rs.getString("blocoSocio"), rs.getString("funcaoSocio"),rs.getInt("idSocio"), rs.getInt("idSocioPK"));
                listaSocio.add(socio);
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

               
        Socio socioMax = new Socio();

        socioMax = listaSocio.get(0);

        //Se houver mais de um socio na lista vai procurar o de maior ID
        if(listaSocio.size()-1 > 0){

            for(int i=0; i<= listaSocio.size()-1; i++){

                Socio socio = new Socio();
                socio = listaSocio.get(i);

                if(socio.getIdAlterado()>= socioMax.getIdAlterado() ){
                    socioMax = socio;
                }

            }

        }
        //Se não pega o primeiro
        else {
                socioMax = listaSocio.get(0);
                
            }

        System.out.println(socioMax.getIdAlterado());

        //Retorna o socio de maior ID, logo o ultimo inserido.
        return socioMax;
    } // final do metodo



    public boolean inserirSocioAlterado(Socio socio) {
        System.out.println("Socio Alterado!");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;

        try {
            stmt = connection.createStatement();

           //Inserir dados na tabela SOCIO!
            String sql = "INSERT INTO alterados (idSocio,nomeSocio,cpfSocio,rgSocio,matSocio,sexoSocio,diaNascSocio,mesNascSocio,anoNascSocio"
                                             + ",enderecoSocio,numEndSocio,bairroSocio,cidadeSocio,estadoSocio"
                                             + ",foneSocio,celSocio,emailSocio,blocoSocio,funcaoSocio) SELECT idSocio,nomeSocio,cpfSocio,rgSocio"
                                             + ",matSocio,sexoSocio,diaNascSocio,mesNascSocio,anoNascSocio"
                                             + ",enderecoSocio,numEndSocio,bairroSocio,cidadeSocio,estadoSocio"
                                             + ",foneSocio,celSocio,emailSocio,blocoSocio,funcaoSocio FROM socio WHERE nomeSocio = '" + socio.getNome() + "'";
                                           
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);

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
                System.out.println("Banco fechado, socio coiado com sucesso");
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }


    public Socio selecionaSocio(Socio socio) {
        System.out.println("selecionando nome atualizado do socio");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        connection = BancoDados.getInstance().getConnection();
        System.out.println("conectado. Preparando para exibir");
        Statement stmt = null;

        Socio socio2 = new Socio();

        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM socio WHERE idSocio = '" + socio.getId() + "'");

            rs.next();

            socio2 = new Socio (rs.getString("nomeSocio"),rs.getString("cpfSocio"),rs.getString("rgSocio"),
                                        rs.getString("matSocio"),rs.getString("sexoSocio"),rs.getString("diaNascSocio"),
                                        rs.getString("mesNascSocio"),rs.getString("anoNascSocio"),rs.getString("enderecoSocio"),
                                        rs.getString("numEndSocio"),rs.getString("bairroSocio"),rs.getString("cidadeSocio"),
                                        rs.getString("estadoSocio"),rs.getString("foneSocio"),rs.getString("celSocio"),
                                        rs.getString("emailSocio"),rs.getString("blocoSocio"), rs.getString("funcaoSocio"),rs.getInt("idSocio"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            // este bloco finally sempre executa na instrução try para
            // fechar a conexão a cada conexão aberta
            try {
                stmt.close();
                connection.close();
                System.out.println("Banco fechado, exibido corretamente");
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
        return socio2;
    }


   }
