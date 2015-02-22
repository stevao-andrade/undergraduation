/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.gpsView.GPS;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entidade que faz referencia à tabela gps_signal que ficará responsavel por 
 * manter o horario da ultima informação enviada pelo Gps.
 * 
 * @author stevao
 */
@Entity
@Table(name = "gps_signal")
public class GpsSignal implements Serializable {

    @Id
    @Column(name = "imei", nullable = false)
    private Long imei;
    @Column(name = "ultimo_envio")
    private Timestamp ultimoEnvio;
    
    @Column(name="label")
    private String label;

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Timestamp getUltimoEnvio() {
        return ultimoEnvio;
    }

    public void setUltimoEnvio(Timestamp ultimoEnvio) {
        this.ultimoEnvio = ultimoEnvio;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GpsSignal other = (GpsSignal) obj;
        if (this.imei != other.imei && (this.imei == null || !this.imei.equals(other.imei))) {
            return false;
        }
        if (this.ultimoEnvio != other.ultimoEnvio && (this.ultimoEnvio == null || !this.ultimoEnvio.equals(other.ultimoEnvio))) {
            return false;
        }
        if ((this.label == null) ? (other.label != null) : !this.label.equals(other.label)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.imei != null ? this.imei.hashCode() : 0);
        hash = 29 * hash + (this.ultimoEnvio != null ? this.ultimoEnvio.hashCode() : 0);
        hash = 29 * hash + (this.label != null ? this.label.hashCode() : 0);
        return hash;
    }
}
