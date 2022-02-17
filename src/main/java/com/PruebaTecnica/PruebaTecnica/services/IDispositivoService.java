package com.PruebaTecnica.PruebaTecnica.services;

import java.util.List;

import com.PruebaTecnica.PruebaTecnica.models.Dispositivo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IDispositivoService {

    public List<Dispositivo> findAll(Sort sort);

    public Page<Dispositivo> findAll(Pageable pageable);

    public Dispositivo findById(long id);

    public Boolean delete(Long id);

    public Dispositivo save(Dispositivo dispositivo);
    
}
