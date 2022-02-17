package com.PruebaTecnica.PruebaTecnica.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.PruebaTecnica.PruebaTecnica.models.Conexion;
import com.PruebaTecnica.PruebaTecnica.services.ConexionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/conexion")
public class ConexionController {
    
    @Autowired
    private ConexionService conexionService;

    @GetMapping()
    public ArrayList<Conexion> obtenerConexiones() {
        return conexionService.obtenerConexiones();
    }

    @PostMapping()
    public Conexion guardarConexion(@RequestBody Conexion conexion) {
        return this.conexionService.guardarConexion(conexion);
    }

    @GetMapping(path = "/{id}")
    public Optional<Conexion> obtenerConexionPorId(@PathVariable("id") Long id) {
        return this.conexionService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}") 
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.conexionService.eliminarConexion(id);
        if (ok) {
            return "Se elimino el usuario con id " + id;
        } else {
            return "No se pudo eliminar el usuario con id " + id;
        }
    }
    

}
