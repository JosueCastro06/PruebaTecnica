package com.PruebaTecnica.PruebaTecnica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long idD;
    private String ip;
    private String mac;
    private String tipoD;

    private Long idC;
    private Integer tipoC;
    private String nombre;
    private String cifrado;

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public Long getIdD() {
        return idD;
    }

    public void setIdD( Long idD) {
        this.idD = idD;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac( String mac) {
        this.mac = mac;
    }

    public String getTipoD() {
        return tipoD;
    }

    public void setTipoD( String tipoD) {
        this.tipoD = tipoD;
    }

    public Long getIdC() {
        return idC;
    }

    public void setIdC( Long idC) {
        this.idC = idC;
    }

    public Integer getTipoC() {
        return tipoC;
    }

    public void setTipoC( Integer tipoC) {
        this.tipoC = tipoC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre) {
        this.nombre = nombre;
    }

    public String getCifrado() {
        return cifrado;
    }

    public void setCifrado( String cifrado) {
        this.cifrado = cifrado;
    }

}
