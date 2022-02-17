package com.PruebaTecnica.PruebaTecnica.dao;

import java.util.ArrayList;

import com.PruebaTecnica.PruebaTecnica.models.Conexion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConexionRepository extends CrudRepository<Conexion, Long>{
    public abstract ArrayList<Conexion> findByNombre(String nombre);
}
