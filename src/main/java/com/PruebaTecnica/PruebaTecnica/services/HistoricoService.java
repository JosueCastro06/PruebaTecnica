package com.PruebaTecnica.PruebaTecnica.services;

import java.util.ArrayList;

import com.PruebaTecnica.PruebaTecnica.dao.HistoricoRepository;
import com.PruebaTecnica.PruebaTecnica.models.Historico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {
    
    @Autowired
    private HistoricoRepository historicoRepository;

    public ArrayList<Historico> obtenerHistorico() {
        return (ArrayList<Historico>) historicoRepository.findAll();
    }

    public Historico guardarHistorico(Historico historico) {
        return historicoRepository.save(historico);
    }

}
