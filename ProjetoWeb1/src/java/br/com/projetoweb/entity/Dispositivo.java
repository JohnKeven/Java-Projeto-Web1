/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arena
 */
@Entity
@Table(name = "Dispositivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dispositivo.findAll", query = "SELECT d FROM Dispositivo d"),
    @NamedQuery(name = "Dispositivo.findByIdDispositivo", query = "SELECT d FROM Dispositivo d WHERE d.idDispositivo = :idDispositivo"),
    @NamedQuery(name = "Dispositivo.findByNomeDispositivo", query = "SELECT d FROM Dispositivo d WHERE d.nomeDispositivo = :nomeDispositivo"),
    @NamedQuery(name = "Dispositivo.findByAltitude", query = "SELECT d FROM Dispositivo d WHERE d.altitude = :altitude"),
    @NamedQuery(name = "Dispositivo.findByLatitude", query = "SELECT d FROM Dispositivo d WHERE d.latitude = :latitude"),
    @NamedQuery(name = "Dispositivo.findByLongitude", query = "SELECT d FROM Dispositivo d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "Dispositivo.findByVelocidade", query = "SELECT d FROM Dispositivo d WHERE d.velocidade = :velocidade")})
public class Dispositivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dispositivo")
    private Integer idDispositivo;
    @Basic(optional = false)
    @Column(name = "nome_dispositivo")
    private String nomeDispositivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "altitude")
    private Float altitude;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "velocidade")
    private Float velocidade;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;

    public Dispositivo() {
    }

    public Dispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Dispositivo(Integer idDispositivo, String nomeDispositivo) {
        this.idDispositivo = idDispositivo;
        this.nomeDispositivo = nomeDispositivo;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public Float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Float velocidade) {
        this.velocidade = velocidade;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDispositivo != null ? idDispositivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dispositivo)) {
            return false;
        }
        Dispositivo other = (Dispositivo) object;
        if ((this.idDispositivo == null && other.idDispositivo != null) || (this.idDispositivo != null && !this.idDispositivo.equals(other.idDispositivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.projetoweb.entity.Dispositivo[ idDispositivo=" + idDispositivo + " ]";
    }
    
}
