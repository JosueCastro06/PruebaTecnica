package com.PruebaTecnica.PruebaTecnica.controllers;

import java.util.ArrayList;

import com.PruebaTecnica.PruebaTecnica.models.Historico;
import com.PruebaTecnica.PruebaTecnica.services.HistoricoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/historico")
public class HistoricoController {
    
    @Autowired
    private HistoricoService historicoService;

    @GetMapping()
    public ArrayList<Historico> obtenerHistorico() {
        return historicoService.obtenerHistorico();
    }

    @PostMapping()
    public Historico guardarHistorico(@RequestBody Historico historico) {
        return this.historicoService.guardarHistorico(historico);
    }

}
