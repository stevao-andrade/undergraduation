/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteteste;

/**
 *
 * @author stevao
 */
import java.io.*;
import java.net.*;

public class ClienteTeste {

    double latitude = 2232.1829;
    double longitude = 11356.3278;
        
    
    public static void main(String[] args) throws Exception {

        ClienteTeste cliente = new ClienteTeste();
        cliente.enviaLocalizacao(); 

    }

    /*Envia modelo de mensagem do GPS para o servidor na porta 4444 
     *no endereço localhost
     *
    */
    public void enviaLocalizacao() throws Exception {

        //Loop infinito
        while (true) {

            Socket socket = new Socket("localhost", 20157); //Cria socket, define endereço e porta a ser enviado. 
            PrintStream printStream = new PrintStream(socket.getOutputStream());

            //Informação que será enviada através do socket
            //Serial number + authorized number + GPRMC + GPS signal indicator + command 
            //+IMEI number + CRC16 checksum

            printStream.println("120509202240,	94325144,	2012-05-09 09:23:20,1,4,	-5.09075,S,	-42.8019216666667,W, 2.368,7354779035626002344234434,3547790356260023442344343,3547790356260023442344344,354779035626002344234434,3547790356260023442344346,7354779035626002344234434,8354779035626002344234434,5354779035626002344234434,	134,20,21,22,23,24,25");

            BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String temp = buffer.readLine(); //Lê a linha que esta no buffer
            System.out.println(temp);
            wait(10); //Espera 10 segundo para fazer o loop e reenviar a msg
        }
    }
    
     public void wait(int n) {
            long tempo0, tempo1;
            tempo0 = System.currentTimeMillis(); 
            this.latitude = this.latitude + tempo0;
            this.longitude = this.longitude + tempo0;
            do {
                tempo1 = System.currentTimeMillis();
            } while ((tempo1 - tempo0) < (n * 1000)); //intervalo em segundos
     }
}
