/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.servidorGPS.GPS;

import br.com.tcc.servidorGPS.util.HibernateUtil;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author stevao
 */
public class GpsUtil {

    /**
     * Recebe o string com a mensagem e separa por virgula as informações em uma
     * lista que sera salvas no banco de dados
     *
     * @param mensagemModelo
     * @return lista
     */
    public static List<String> organizaString(String stringRecebida) {

        //Lista que recebe informações enviadas
        List<String> lista = new ArrayList<String>();
        //Define o separador
        StringTokenizer st = new StringTokenizer(stringRecebida, ",");

        //Enquanto houver token, adciona na lista, sem espaços.
        while (st.hasMoreTokens()) {
            lista.add(st.nextToken().trim());
        }
        return lista;
    }

    private static Double distanciaEntreDoisPontos(Gps anterior, Gps atual) {
        //Distancia entre o ponto atual e o anterior
        Double distancia = 0.0;

        //latitude do ponto atual
        Double latitudeInicial = Math.toRadians(anterior.getLatitude());

        //Latitude final é a latitude do ponto em questão no laço.
        Double latitudeFinal = Math.toRadians(atual.getLatitude());

        //Calcular a diferença da longitude de 2 pontos. Ponto atual e o anterior.
        Double diferencaLong = Math.toRadians(atual.getLongitude() - anterior.getLongitude());

        //Distancia percorrida entre os dois ponto em metros
        distancia = distancia + (Math.acos(Math.cos(latitudeFinal) * Math.cos(latitudeInicial) * Math.cos(diferencaLong) + Math.sin(latitudeFinal) * Math.sin(latitudeInicial)) * 6371);

        return distancia;
    }

    /**
     * Metodo para avaliar o desvio padrão. Caso a distancia entre o ponto atual
     * e o ponto anterior seja igual ou inferior ao desvio padrão, retorna falso
     * caso contrario retorna true.
     *
     * Desvio padrão é utilizado para saber se a informação deve ou não ser
     * salva no banco de dados.
     *
     * @return true ou false
     */
    public static boolean calcularDesvioPadrao(Gps atual) {
        Session sessao = HibernateUtil.getSession();
        Transaction transacao = sessao.beginTransaction();
        GPSDao dao = new GPSDao(sessao);

        Gps ultimoPonto = new Gps();
        ultimoPonto = dao.pegarUltimoRegistro(atual);

        //testa se existe algum registro no banco.
        if (ultimoPonto == null) {
            //se for nulo, não existem registros, então retorna true para inserir a primeira vez.
            return true;
        } 
        //Existe algum registro
        else {

            //distancia entre o ultimo ponto e o atual.
            Double distancia = GpsUtil.distanciaEntreDoisPontos(ultimoPonto, atual);

            /**
             * Se a distancia percorrida for menor que 10 metros, retorna falso.
             * Não ira inserir no banco de dados.
             */
            //Hora em que a informação será salva
            Long n2 = System.currentTimeMillis();
            Timestamp horaAtual = new Timestamp(n2);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            //hoje
            String dia1 = formato.format(new Date(n2)); 
            
            //dia do ultimo envio
            String dia2 = formato.format(new Date(ultimoPonto.getData().getTime()));
            
            /**
             * Se a distancia percorrida for menor que 15 metros, salva o sinal
             * do gps e retorna false para descartar a informação e mostrar no
             * log.
             * 
             * O dia precisa ser igual para descartar a informação.
             */
            if ((atual.getVelocidade() == 0.0 && ultimoPonto.getVelocidade() <= 0.0 && dia1.equals(dia2)) || (distancia <= 0.025 && dia1.equals(dia2))) {

                //salvando o sinal
                GpsSignal s = new GpsSignal();
                s = dao.carregarSinal(atual);
                s.setImei(atual.getImei());
                s.setUltimoEnvio(horaAtual);
                dao.salvaSinal(s);

                //fechando a conexão com o banco
                transacao.commit();
                sessao.close();

                System.out.println();
                System.out.println("------------------------------------------------------------");
                System.out.println("Sinal salvo.");
                System.out.println("Informação descartada: " + new Date(System.currentTimeMillis()));
                System.out.println("Velocidade: " + ultimoPonto.getVelocidade());
                System.out.println("Latitude: " + ultimoPonto.getLatitude());
                System.out.println("Longitude: " + ultimoPonto.getLongitude());
                System.out.println("------------------------------------------------------------");
                
                return false;
            } 
            //Se a distancia percorrida for maior que 15 metros, retorna true para inserir no banco.
            else {
            
                //salvando o sinal
                GpsSignal s = new GpsSignal();
                s = dao.carregarSinal(atual);
                s.setImei(atual.getImei());
                s.setUltimoEnvio(horaAtual);
                dao.salvaSinal(s);

                //fechando a conexão com o banco
                transacao.commit();
                sessao.close();
                
                return true;
            }
        }
    }

    /*
     * Recebe lista com informações brutas e retorna objeto GPS
     */
    public static Gps traduzirLista(List<String> lista) {

        if (lista.size() == 25) {
            Gps gps = new Gps();

            //numero de serie
            gps.setNumeroSerie(Long.parseLong(lista.get(0)));

            //numero autorizado "celular"
            gps.setNumeroAutorizado(Long.parseLong(lista.get(1)));

            //latitude 
            String n1 = lista.get(5);
            if ("".equals(n1)) {
                System.out.println();
                System.out.println("------------------------------------------------------------");
                System.out.println("GPS sem sinal às: " + new Date(System.currentTimeMillis()));
                System.out.println("------------------------------------------------------------");
                System.exit(-1);
            } else {
                Double latitude = (int) (Double.parseDouble(n1) / 100) + ((Double.parseDouble(n1) - ((int) ((Double.parseDouble(n1) / 100)) * 100)) / 60);
                //Se orientação for Norte, o valor da coordenada é positivo, se não "Sul", é negativo.
                if ("N".equals(lista.get(6))) {
                    gps.setLatitude(latitude);
                } else {
                    gps.setLatitude(latitude * (-1));
                }
            }

            //Longitude
            String n2 = lista.get(7);
            if ("".equals(n2)) {
                System.out.println();
                System.out.println("------------------------------------------------------------");
                System.out.println("GPS sem sinal às: " + new Date(System.currentTimeMillis()));
                System.out.println("------------------------------------------------------------");
                System.exit(-1);
            } else {
                Double longitude = (int) (Double.parseDouble(n2) / 100) + ((Double.parseDouble(n2) - ((int) ((Double.parseDouble(n2) / 100)) * 100)) / 60);
                //Se orientação for Leste, o valor da coordenada é positivo, se não "Oeste" , é negativo.
                if ("E".equals(lista.get(8))) {
                    gps.setLongitude(longitude);
                } else {
                    gps.setLongitude(longitude * (-1));
                }
            }

            //Velocidade
            String n3 = lista.get(9);
            //Convertendo de nós para Kilometros. 1 no = 1.85 km/h
            gps.setVelocidade(1.85 * Double.parseDouble(n3));

            //Altitude
            String n4 = lista.get(19);
            gps.setAltitude(Double.parseDouble(n4));


            //Imei do GPS "Numero de fabrica"
            String n5 = lista.get(14).substring(5);
            gps.setImei(Long.parseLong(n5));

            //Por fim retorna objeto GPS com as informações.
            return gps;
        } //String incompleta.
        else {
            System.out.println();
            System.out.println("------------------------------------------------------------");
            System.out.println("String invalida: " + lista);
            System.out.println("Horario: " + new Date(System.currentTimeMillis()));
            System.out.println("------------------------------------------------------------");
            return null;
        }
    }
}
