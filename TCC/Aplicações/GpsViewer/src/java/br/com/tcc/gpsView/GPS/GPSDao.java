/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.gpsView.GPS;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author stevao
 * 
 * Implementa os metodos de Salvar, Carregar
 * 
 */
public class GPSDao {

    private Session session;

    public GPSDao(Session session) {
        this.session = session;
    }

    /*
     *Metodo para carregar ultimo registro de um "gps" com informações de latitude e longitude
     * para ser exibida no mapa como localização mais atualizada
     */
    public Gps carregarAtual(Timestamp ultimoRegistro) {
        String hql = "select g from Gps g where g.data = :ultimoRegistro";
        Query consulta = this.session.createQuery(hql);
        consulta.setTimestamp("ultimoRegistro", ultimoRegistro);
        return (Gps) consulta.uniqueResult();
    }

    /*
     *Metodos para listar todas informações do banco de dados gps em uma lista 
     */
    public List<Gps> listar() {
        return this.session.createCriteria(Gps.class).list();
    }

    //Listar sinais de gps existentes
    public List<GpsSignal> listarSinal() {
        return this.session.createCriteria(GpsSignal.class).list();
    }

    //Carregar sinal de um gps
    public GpsSignal carregarSinal(Gps g) {
        Long imei = g.getImei();

        String hql = "select s from GpsSignal s where s.imei = :imei";
        Query consulta = this.session.createQuery(hql);
        consulta.setLong("imei", imei);

        return (GpsSignal) consulta.uniqueResult();
    }

    /*
     * Metodo que retorna o ultimo horario inserido no banco, ou seja, posição mais atual.
     * 
     * Paramentro: Numero de serie "imei" do GPS que se deseja obter a posição atual.
     */
    public Timestamp ultimaInformacaoHora(Long imei) {

        Criteria criteria = this.session.createCriteria(Gps.class).add(Restrictions.eq("imei", imei));
        criteria.setProjection(Projections.max("data"));

        return (Timestamp) criteria.uniqueResult();
    }

    public List<Gps> itinerario(Long imei, Timestamp data_inicio, Timestamp data_final) {

        List<Gps> listaItinerario = new ArrayList<Gps>();

        Criteria criterio = this.session.createCriteria(Gps.class).add(Restrictions.eq("imei", imei)) //Restrição, selecionar valores onde haja o numero de serie
                .add(Restrictions.between("data", data_inicio, data_final)) //Restrição, selecionar valores que existirem entre as datas
                .addOrder(Order.asc("data")); //Ordenar

        listaItinerario = criterio.list();

        return listaItinerario;
    }
}
