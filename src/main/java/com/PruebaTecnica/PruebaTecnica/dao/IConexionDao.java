package com.PruebaTecnica.PruebaTecnica.dao;

import com.PruebaTecnica.PruebaTecnica.models.Conexion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IConexionDao extends JpaRepository<Conexion, Long> {
    
}
