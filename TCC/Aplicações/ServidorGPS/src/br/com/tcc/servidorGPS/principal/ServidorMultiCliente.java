package br.com.tcc.servidorGPS.principal;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorMultiCliente {

    public static void main(String[] args) throws IOException {
    
    
    ServerSocket serverSocket = null;
    boolean ouvindo;

    /*
     *Passa variavel "ouvindo" para true e inicia o laço para escutar a porta 4444
     */
    
   try {
        serverSocket = new ServerSocket(20157);
   }
   catch (IOException e) {
            System.out.println("Não pode escutar a porta: 20157.");
            System.exit(-1);
    }
   
    //coloca variavel para true para iniciar laço infinito 
    ouvindo  = true;

    System.out.println ("Escutando a porta: 20157.");
       
    while (ouvindo) {
            try {
            new ThreadAtendente(serverSocket.accept()).start();
        } catch (IOException ex) {
            System.out.println("Não foi possivel executar a thread atendente");
            Logger.getLogger(ServidorMultiCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    try {
          serverSocket.close();
        }
    catch (IOException ex) {
            System.out.println("Não foi possivel encerrar o socket.");
            Logger.getLogger(ServidorMultiCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
