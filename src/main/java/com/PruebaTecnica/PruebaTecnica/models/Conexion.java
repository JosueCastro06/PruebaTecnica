package com.PruebaTecnica.PruebaTecnica.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Conexion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "El campo no debe estar vacio")
    private Integer tipo;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String nombre;

    private String cifrado;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String conexion;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String contraseña;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "conexion")
    private List<Dispositivo> dispositivos;

    public Long getId() {
        return id;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo( Integer tipo) {
        this.tipo = tipo;
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

    public String getConexion() {
        return conexion;
    }

    public void setConexion( String conexion) {
        this.conexion = conexion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña( String contraseña) {
        this.contraseña = contraseña;
    }


}
