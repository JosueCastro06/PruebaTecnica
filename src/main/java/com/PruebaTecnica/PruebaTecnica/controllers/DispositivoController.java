package com.PruebaTecnica.PruebaTecnica.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.PruebaTecnica.PruebaTecnica.models.Dispositivo;
import com.PruebaTecnica.PruebaTecnica.services.IDispositivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/dispositivos")
public class DispositivoController {

    @Autowired
    private IDispositivoService dispositivoService;

    @GetMapping
    public ResponseEntity<List<Dispositivo>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {

        Sort sortByName = Sort.by("tipo");
        ResponseEntity<List<Dispositivo>> responseEntity = null;
        List<Dispositivo> dispositivos = null;

        if( page != null && size != null) {
            //Agregando paginación
            Pageable pageable = PageRequest.of(page, size, sortByName);

            dispositivos = dispositivoService.findAll(pageable).getContent();

        } else {
            //Sin Paginación
            dispositivos = dispositivoService.findAll(sortByName);
        }
        if( dispositivos.size() > 0) {
            responseEntity = new ResponseEntity<List<Dispositivo>>(dispositivos, HttpStatus.OK);
        } else  {
            responseEntity = new ResponseEntity<List<Dispositivo>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dispositivo> findById(@PathVariable Long id) {

        Dispositivo dispositivo = dispositivoService.findById(id);

        ResponseEntity<Dispositivo> responseEntity = null;

        if( dispositivo != null ) {
            responseEntity = new ResponseEntity<Dispositivo>(dispositivo, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<Dispositivo>(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Dispositivo dispositivo, BindingResult result) {

        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;

        if (result.hasErrors()) {
            errores = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }

            responseAsMap.put("errors", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);

            return responseEntity;
        }
        
        try {
            Dispositivo dispositivoDB = dispositivoService.save(dispositivo);
            
            if( dispositivoDB != null) {
                responseAsMap.put("dispositivo", dispositivo);
                responseAsMap.put("mensaje", "el dispositivo con id " + dispositivo.getId() + "se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseAsMap.put("mensaje", "El producto no se ha creado exitosamente: " + e);
            responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return responseEntity;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Dispositivo dispositivo, BindingResult result) {

        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;

        if (result.hasErrors()) {
            errores = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }

            responseAsMap.put("errors", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);

            return responseEntity;
        }
        
        try {
            dispositivo.setId(id);
            Dispositivo dispositivoDB = dispositivoService.save(dispositivo);
            
            if( dispositivoDB != null) {
                responseAsMap.put("dispositivo", dispositivo);
                responseAsMap.put("mensaje", "el dispositivo con id " + dispositivo.getId() + "se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            } else {
                responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            responseAsMap.put("mensaje", "El producto no se ha actualizado exitosamente: " + e);
            responseEntity = new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return responseEntity;
    }

    @DeleteMapping(value = "/{id}") 
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.dispositivoService.delete(id);
        if (ok) {
            return "Se elimino el dispositivo con id " + id;
        } else {
            return "No se pudo eliminar el dispositivo con id " + id;
        }
    }
    
    
}
