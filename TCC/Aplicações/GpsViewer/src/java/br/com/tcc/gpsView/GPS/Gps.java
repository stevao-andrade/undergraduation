/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.gpsView.GPS;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 *
 * @author stevao
 */
@Entity
@Table(name = "gps_info")
public class Gps implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "numero_serie")
    private Long numeroSerie;
    @Column(name = "numero_autorizado")
    private Long numeroAutorizado;
    //Salvo automaticamente pelo banco 
    @Column(name = "horario")
    private Timestamp data;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "altitude")
    private Double altitude;
    @Column(name = "velocidade")
    private Double velocidade;
    @Column(name = "imei")
    private Long imei;

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getNumeroAutorizado() {
        return numeroAutorizado;
    }

    public void setNumeroAutorizado(Long numeroAutorizado) {
        this.numeroAutorizado = numeroAutorizado;
    }

    public Long getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(Long numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gps other = (Gps) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.numeroSerie != other.numeroSerie && (this.numeroSerie == null || !this.numeroSerie.equals(other.numeroSerie))) {
            return false;
        }
        if (this.numeroAutorizado != other.numeroAutorizado && (this.numeroAutorizado == null || !this.numeroAutorizado.equals(other.numeroAutorizado))) {
            return false;
        }
        if (this.data != other.data && (this.data == null || !this.data.equals(other.data))) {
            return false;
        }
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        if (this.altitude != other.altitude && (this.altitude == null || !this.altitude.equals(other.altitude))) {
            return false;
        }
        if (this.velocidade != other.velocidade && (this.velocidade == null || !this.velocidade.equals(other.velocidade))) {
            return false;
        }
        if (this.imei != other.imei && (this.imei == null || !this.imei.equals(other.imei))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 71 * hash + (this.numeroSerie != null ? this.numeroSerie.hashCode() : 0);
        hash = 71 * hash + (this.numeroAutorizado != null ? this.numeroAutorizado.hashCode() : 0);
        hash = 71 * hash + (this.data != null ? this.data.hashCode() : 0);
        hash = 71 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 71 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
        hash = 71 * hash + (this.altitude != null ? this.altitude.hashCode() : 0);
        hash = 71 * hash + (this.velocidade != null ? this.velocidade.hashCode() : 0);
        hash = 71 * hash + (this.imei != null ? this.imei.hashCode() : 0);
        return hash;
    }
}
