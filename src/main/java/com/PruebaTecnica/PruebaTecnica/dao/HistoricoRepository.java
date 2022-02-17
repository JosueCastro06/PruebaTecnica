package com.PruebaTecnica.PruebaTecnica.dao;

import com.PruebaTecnica.PruebaTecnica.models.Historico;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends CrudRepository<Historico, Long> {
    
}
