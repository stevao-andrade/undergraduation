/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.servidorGPS.principal;

/**
 *
 * @author stevao
 */
import br.com.tcc.servidorGPS.GPS.GPSDao;
import br.com.tcc.servidorGPS.GPS.Gps;
import br.com.tcc.servidorGPS.GPS.GpsUtil;
import br.com.tcc.servidorGPS.util.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ThreadAtendente extends Thread {

    private Socket socket = null;

    public ThreadAtendente(Socket socket) {
        super("ThreadAtendente");
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream()));


            String linhaDoBuffer = entrada.readLine();
            
            
            /**
             * Salvando no banco
             */
            //Lista com os dados
            List<String> lista = new ArrayList<String>();
            lista = GpsUtil.organizaString(linhaDoBuffer);

            //Objeto padrão a ser salvo
            Gps gps = new Gps();

            //Recebe os dados "traduzidos"
            gps = GpsUtil.traduzirLista(lista);

            if (gps != null) {

                //Se o desvio padrão for aceito, salva as informações no banco.
                if (GpsUtil.calcularDesvioPadrao(gps)) {
                    //Salvando no banco
                    Session session = HibernateUtil.getSession();
                    Transaction trasacao = session.beginTransaction();
                    
                    GPSDao dao = new GPSDao(session);
                    dao.salvar(gps);
                    
                    //fechando a conexão
                    trasacao.commit();
                    session.close();
                    
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Sinal salvo.");
                    System.out.println("Dados salvos às: " + new Date(System.currentTimeMillis()));
                    System.out.println("Imei: " + gps.getImei());
                    System.out.println("Latitude: " + gps.getLatitude());
                    System.out.println("Longitude: " + gps.getLongitude());
                    System.out.println("Velocidade: " + gps.getVelocidade());
                    System.out.println("------------------------------------------------------------");
                }
            }
            
            //Fechando o socket
            saida.close();
            entrada.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
