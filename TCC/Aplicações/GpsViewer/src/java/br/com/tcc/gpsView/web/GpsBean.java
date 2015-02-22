/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.gpsView.web;

import br.com.tcc.gpsView.GPS.GPSDao;
import br.com.tcc.gpsView.GPS.Gps;
import br.com.tcc.gpsView.GPS.GpsSignal;
import br.com.tcc.gpsView.util.HibernateUtil;
import br.com.tcc.gpsView.util.MensagemContexto;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ValueChangeListener;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.*;

/**
 *
 * @author stevao
 */
@ManagedBean
@ViewScoped
public class GpsBean implements Serializable {

    private String centro = "-5.0885506,-42.801490";  //Centro do mapa
    private String centroMapa2;  //Centro do mapa da rota percorrida
    private boolean status;  //Status do gps
    private Long imei;
    private MapModel mapaDialog;
    private MapModel mapa;
    private Date dataCalendario;
    private List<GpsSignal> listaGpsDisponivel = new ArrayList<GpsSignal>();
    private HtmlSelectOneMenu selectOnMenu = new HtmlSelectOneMenu();
    private String titulo = "Inativo";
    private Marker pontoMarcado;

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCentroMapa2() {
        return centroMapa2;
    }

    public void setCentroMapa2(String centroMapa2) {
        this.centroMapa2 = centroMapa2;
    }

    public boolean isStatus() {
        return status;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Date getDataCalendario() {
        return dataCalendario;
    }

    public void setDataCalendario(Date dataCalendario) {
        this.dataCalendario = dataCalendario;
    }

    public HtmlSelectOneMenu getSelectOnMenu() {
        return selectOnMenu;
    }

    public void setSelectOnMenu(HtmlSelectOneMenu selectOnMenu) {
        this.selectOnMenu = selectOnMenu;
    }

    public MapModel getMapa() {
        return mapa;
    }

    public void setMapa(MapModel mapa) {
        this.mapa = mapa;
    }

    public MapModel getMapaDialog() {
        return mapaDialog;
    }

    public void setMapaDialog(MapModel mapaDialog) {
        this.mapaDialog = mapaDialog;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Marker getPontoMarcado() {
        return pontoMarcado;
    }

    public void setPontoMarcado(Marker pontoMarcado) {
        this.pontoMarcado = pontoMarcado;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        this.pontoMarcado = (Marker) event.getOverlay();
    }

    /*
     * Retorna Lista de numero de serie dos GPS que possuem informações no BD.
     * Util para definir qual GPS deseja-se obter as informações.
     */
    public List<GpsSignal> getListaGpsDisponivel() {
        List<GpsSignal> listaDeGps = new ArrayList<GpsSignal>();

        Session session = HibernateUtil.getSession();

        Transaction t = session.beginTransaction();
        GPSDao dao = new GPSDao(session);

        listaGpsDisponivel = dao.listarSinal();

        t.commit();
        session.close();

        return this.listaGpsDisponivel;
    }

    public void setListaGpsDisponivel(List<GpsSignal> listaGpsDisponivel) {
        this.listaGpsDisponivel = listaGpsDisponivel;
    }

    /*
     * Retorna valor do numero de serie selecionado no Componenete SelectOneMenu
     * Apresenta validação caso o valor não seja o esperado.
     */
    public Long pegarImei(ValueChangeListener v) {

        //Pega o valor do Select, Converte em String.
        String valor = (String) this.selectOnMenu.getValue();

        long imeiSelecionado = 0;

        try {
            imeiSelecionado = (Long.parseLong(valor));
        } catch (Exception e) {
            imeiSelecionado = 0;
        }


        if (imeiSelecionado != 0) {
            return imeiSelecionado;
        } else {
            MensagemContexto.adicionarMensagem("Informe o GPS corretamente");
            this.status = false;
            return imeiSelecionado;
        }
    }

    /*
     * Retorna objeto do tipo GPS que informa ultimo registro do GPS, Ou seja,
     * "Posição atual".
     */
    public Gps exibirPosicaoAtual(Long imei) {

        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        GPSDao dao = new GPSDao(session);
        Gps gpsAtual = new Gps();
        Timestamp ultimoRegistro;

        try {
            ultimoRegistro = dao.ultimaInformacaoHora(imei);
            gpsAtual = dao.carregarAtual(ultimoRegistro);
        } catch (StringIndexOutOfBoundsException n) {
            MensagemContexto.adicionarMensagem("Favor informar o GPS.");
        }
        t.commit();
        session.close();

        return gpsAtual;
    }

    /*
     * Atualiza status do GPS para Ativo ou inativo.
     *
     * Regra: Se a ultima informação recebida tiver horario até 5 minutos de
     * diferença da hora atual, o Status é considerado como ativo. Caso o
     * contrario o status do Gps é considerado inativo.
     */
    public boolean atualizarStatusGps() {

        //Pega hora atual.
        Timestamp horaAtual = new Timestamp(System.currentTimeMillis());

        //Hora atual menos 5 minutos:
        Long horaAtualMenos5MinMiliseg = horaAtual.getTime() - 300000;

        Gps gpsAtual = new Gps();

        ValueChangeListener e = null;
        Long imeiSelecionado = pegarImei(e);

        //Se for selecionado um GPS valido testa, se não, mantem status false
        if (imeiSelecionado != 0) {

            //gps selecionado
            gpsAtual = exibirPosicaoAtual(imeiSelecionado);

            //Carregando ultimo sinal do gps selecionado
            Session s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();

            GPSDao dao = new GPSDao(s);
            GpsSignal sinal = new GpsSignal();

            sinal = dao.carregarSinal(gpsAtual);
            t.commit();
            s.close();


            //Se ultima msg for maior ou igual a hora atual menos 5 minutos
            //status do GPS é TRUE
            if (sinal.getUltimoEnvio().getTime() >= horaAtualMenos5MinMiliseg) {
                this.titulo = "Ativo";
                return this.status = true;
            } else {
                this.titulo = "Inativo";
                return this.status = false;
            }
        } else {
            return false;
        }

    }

    /*
     * Metodo para exibir marcadores no mapa.
     *
     * Parametros: Mapa que serão adcionados os marcadores, objeto Gps para
     * obter informações de latitude e longitude.
     */
    public MapModel exibirNoMapa() {

        Gps gps = new Gps();

        MapModel mapaLocal = new DefaultMapModel();

        ValueChangeListener e = null;
        Long imeiSelecionado = pegarImei(e);

        //Se for selecionado gps valido, atualiza posição, se não redesenha mapa original.
        if (imeiSelecionado != 0) {
            gps = exibirPosicaoAtual(imeiSelecionado);

            Marker marco = new Marker(new LatLng(gps.getLatitude(), gps.getLongitude()), gps.getData().toString());

            mapaLocal = new DefaultMapModel(); //Cria instancia do Mapa
            mapaLocal.addOverlay(marco); //Adciona o marco criado ao desenho do mapa.

            this.centro = gps.getLatitude() + "," + gps.getLongitude();

            return mapaLocal;
        } else {
            MensagemContexto.adicionarMensagem("Informe um GPS valido.");
            return mapaLocal = new DefaultMapModel();
        }
    }

    /**
     * Metodo para listar o itinerario diario de um GPS apartir da data
     * informada.
     *
     * @param data
     * @return retorna uma lista com todos os pontos, ordenada de forma
     * crescente por horario.
     */
    public List<Gps> listaItinerario(Date data) {

        List<Gps> listaGps = new ArrayList<Gps>();

        if (data == null) {
            MensagemContexto.adicionarMensagem("Favor informar a Data corretamente");
        } else {
            //Converte o padrão da data e cria duas variaveis referentes ao horario de inicio e fim do dia
            SimpleDateFormat formataData = new SimpleDateFormat("yyyy-mm-dd");
            String inicio = formataData.format(data) + " 00:00:00";
            String fim = formataData.format(data) + " 23:59:59";

            //Pega lista de pontos do gps no banco referentes ao dia selecionado
            Session sessao = HibernateUtil.getSession();
            GPSDao dao = new GPSDao(sessao);
            Transaction t = sessao.beginTransaction();

            ValueChangeListener v = null;
            Long imeiSelecionado = pegarImei(v);
            listaGps = dao.itinerario(imeiSelecionado, Timestamp.valueOf(inicio), Timestamp.valueOf(fim));
        }
        return listaGps;
    }

    /*
     * Evento AJAX disparado ao selecionar GPS no componente SelectOneMenu
     * presente na view
     *
     * Renderiza novamente o mapa com posição atual.
     */
    public void exibirPosicaoAtual() {

        //Exibe a posição no mapa
        this.mapa = exibirNoMapa();

        //Define o status do GPS
        atualizarStatusGps();
    }

    /**
     * Determina a cor do ponto conforme a velocidade em que ele se encontrava.
     * Abaixo de 60km -> Verde
     * Entre  60~69Km -> Amarelo
     * Acima  de 70km -> Vermelho
     * @param g -> Objeto gps
     * @return  -> String da cor
     */
    private String determinarVelocidade(Gps g) {

        //Cor dos marcadores
        String verde = "http://maps.google.com/mapfiles/ms/micons/green-dot.png";
        String amarelo = "http://maps.google.com/mapfiles/ms/micons/yellow-dot.png";
        String vermelho = "http://maps.google.com/mapfiles/ms/micons/red-dot.png";

        String cor;

        //Seta a cor do ponto conforme a velocidade em que ele se estava.
        if (g.getVelocidade() <= 59.9) {
            cor = verde;
        } else if (g.getVelocidade() <= 69.9) {
            cor = amarelo;
        } else {
            cor = vermelho;
        }
        return cor;
    }

    /**
     * Exibe lista de pontos marcados pelo GPS durante um determinado dia.
     *
     * Paramentos da consulta: Dia escolhido e Numero de serie do GPS
     */
    public void exibirItinerario() {

        this.mapaDialog = new DefaultMapModel();

        List<Gps> listaGps = new ArrayList<Gps>();

        ValueChangeListener v = null;
        Long imeiSelecionado = pegarImei(v);

        //Pega lista de informações do GPS baseado na data informada.
        listaGps = listaItinerario(this.dataCalendario);

        //Cria modelo de mapa com os pontos do banco e depois atribui o modelo ao mapaDialog
        MapModel mapaLocal = new DefaultMapModel();
        Polyline linha = new Polyline();

        if (listaGps.isEmpty() && imeiSelecionado != 0) 
                MensagemContexto.adicionarMensagem("Não existem registros disponíveis");
        else {
                this.centroMapa2 = listaGps.get(0).getLatitude() + "," + listaGps.get(0).getLongitude(); //Ponto inicial do mapa

                String cor;

                for (Gps g : listaGps) {

                    //Seta a cor do ponto conforme a velocidade em que ele se estava.
                    cor = determinarVelocidade(g);

                    mapaLocal.addOverlay(new Marker(new LatLng(g.getLatitude(), g.getLongitude()), g.getData().toString(), "", cor)); //Adcionando o titulo ao ponto. Titulo = Data da msg
                    linha.getPaths().add(new LatLng(g.getLatitude(), g.getLongitude()));
                }

                linha.setStrokeColor("#FF0000");
                linha.setStrokeOpacity(1.0);
                linha.setStrokeWeight(2);

                mapaLocal.addOverlay(linha);
                this.mapaDialog = mapaLocal;

                //Requisição para exibir o dialog.
                RequestContext requisicao = RequestContext.getCurrentInstance();  //cria objeto com contexto da instancia atual dos componentes
                requisicao.execute("dlg.show()"); //executa o componente dialog
            }
        }

        
    
    /*
      * Evento AJAX disparado ao no POLL para ataulizar posição do gps no mapa
      * Caso o status do gps esteja positivo, atualizar a cada 10 segundos. Caso
      * o contrario, atualizar em 480 segundos e verificar novamente o status do
      * gps.
      *
      * Renderiza novamente o mapa com posição atual.
      */
    public void atualizarPosicaoAtual() {

        //Limpa o mapa e os marcadores antigos
        this.mapa = new DefaultMapModel();

        //Exibe a nova posição no mapa
        this.mapa = exibirNoMapa();

        //Define o status do GPS
        atualizarStatusGps();
    }

    
    /**
     * Metodos para iformar dados no GmapWindows
     *
     * Dados: Latitude, Longitude, Horario, Velocidade
     */
    public String informarLatitude() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado);

        String latitude = lista.get(posicao).getLatitude().toString();

        return latitude;
    }

    public String informarLongitude() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado);

        String longitude = lista.get(posicao).getLongitude().toString();

        return longitude;
    }

    public String informarVelocidade() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado);

        String velocidade = lista.get(posicao).getVelocidade().toString();

        return velocidade + "Km/h";
    }

    public String informarHorario() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado);

        Timestamp data = lista.get(posicao).getData();
        SimpleDateFormat formato = new SimpleDateFormat("HH:MM:ss");

        String horario = formato.format(data);

        return horario;
    }

    public String informaPosicao() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado) + 1;

        String pos = Integer.toString(posicao) + "º ponto";

        return pos;
    }

    public String distanciaPercorrida() {
        List<Gps> lista = new ArrayList<Gps>();
        lista = listaItinerario(this.dataCalendario);

        List<Marker> listaDePontos = new ArrayList<Marker>();
        listaDePontos = this.mapaDialog.getMarkers();

        int posicao = listaDePontos.indexOf(this.pontoMarcado);

        Gps primeiroPonto = lista.get(0); //primeiro ponto do dia

        Gps pontoAtual = lista.get(posicao);

        Double distancia = 0.0;

        /**
         * Metodo para a distancia percorrida ate o ponto selecionado.
         *
         * Laço do primeiro ponto ate o ponto selecionado.
         */
        for (int i = 0; i <= lista.indexOf(pontoAtual); i++) {

            //Latitude inicial
            Double latitudeInicial;


            //Se for a primeira iteração, pega dados da latitude do primeiro ponto, 
            //Se não, pega dados do ponto anterior à iteração
            if (i == 0) {
                latitudeInicial = Math.toRadians(lista.get(0).getLatitude());
            } else {
                latitudeInicial = Math.toRadians(lista.get(i - 1).getLatitude());
            }

            //Latitude final é a latitude do ponto em questão no laço.
            Double latitudeFinal = Math.toRadians(lista.get(i).getLatitude());

            //Calcular a diferença da longitude de 2 pontos. Ponto atual e o anterior.
            Double diferencaLong;

            //Se for o primeiro ponto, diferença da logitude = 0
            //Se não, diferença da longitude = longitude do ponto atual - longitude do ponto anterior
            if (i == 0) {
                diferencaLong = Math.toRadians(lista.get(i).getLongitude() - lista.get(i).getLongitude());
            } else {
                diferencaLong = Math.toRadians(lista.get(i).getLongitude() - lista.get(i - 1).getLongitude());
            }
            //A cada iteração vai somando a distancia percorrida entre cada ponto
            distancia = distancia + (Math.acos(Math.cos(latitudeFinal) * Math.cos(latitudeInicial) * Math.cos(diferencaLong) + Math.sin(latitudeFinal) * Math.sin(latitudeInicial)) * 6371);
        }

        //Padrão com 3 casas apos a virgula.
        DecimalFormat formato = new DecimalFormat("0.000");

        //Insere o padrão à distancia, retornando uma string
        return formato.format(distancia) + "Km";
    }
}