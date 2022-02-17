package com.PruebaTecnica.PruebaTecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import com.PruebaTecnica.PruebaTecnica.dao.ConexionRepository;
import com.PruebaTecnica.PruebaTecnica.models.Conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexionService {
    
    @Autowired
    private ConexionRepository conexionRepository;

    public ArrayList<Conexion> obtenerConexiones() {
        return (ArrayList<Conexion>) conexionRepository.findAll();
    }

    public Conexion guardarConexion(Conexion conexion) {
        return conexionRepository.save(conexion);
    }

    public Optional<Conexion> obtenerPorId(Long id){
        return conexionRepository.findById(id);
    }

    public ArrayList<Conexion> obtenerPorNombre(String nombre) {
        return conexionRepository.findByNombre(nombre);
    } 

    public Boolean eliminarConexion(Long id) {
        try {
            conexionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
