package com.PruebaTecnica.PruebaTecnica.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Dispositivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String mac;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String tipo;

    private Boolean conectado;
    
    @NotEmpty(message = "El campo no debe estar vacio")
    private String ip;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull
    private Conexion conexion;

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion( Conexion conexion) {
        this.conexion = conexion;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac( String mac) {
        this.mac = mac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo( String tipo) {
        this.tipo = tipo;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado( Boolean conectado) {
        this.conectado = conectado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp( String ip) {
        this.ip = ip;
    }

}
