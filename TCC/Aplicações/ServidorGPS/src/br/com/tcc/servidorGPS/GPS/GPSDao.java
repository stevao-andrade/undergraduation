/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.servidorGPS.GPS;

import java.sql.Timestamp;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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

    //Salvar informacoes do gps
    public void salvar(Gps gps) {
        this.session.save(gps);
    }

    //Salvar e atualizar o sinal do gps
    public void salvaSinal(GpsSignal s) {
        this.session.saveOrUpdate(s);
    }

    //Carregar sinal de um gps
    public GpsSignal carregarSinal(Gps g) {
        Long imei = g.getImei();

        String hql = "select s from GpsSignal s where s.imei = :imei";
        Query consulta = this.session.createQuery(hql);
        consulta.setLong("imei", imei);

        return (GpsSignal) consulta.uniqueResult();
    }
    
    //pega ultimo registro do gps selecionado
    public Gps pegarUltimoRegistro(Gps g) {

        Criteria criteria = this.session.createCriteria(Gps.class);
        criteria.add(Restrictions.eq("imei", g.getImei()));
        criteria.setProjection(Projections.max("data"));

        Timestamp ultimoRegistro = (Timestamp) criteria.uniqueResult();

        String hql = "select g from Gps g where g.data = :ultimoRegistro";
        Query consulta = this.session.createQuery(hql);
        consulta.setTimestamp("ultimoRegistro", ultimoRegistro);

        return (Gps) consulta.uniqueResult();
    }
}
