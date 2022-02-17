package com.PruebaTecnica.PruebaTecnica.services;

import java.util.List;

import com.PruebaTecnica.PruebaTecnica.dao.IConexionDao;
import com.PruebaTecnica.PruebaTecnica.dao.IDispositivoDao;
import com.PruebaTecnica.PruebaTecnica.models.Conexion;
import com.PruebaTecnica.PruebaTecnica.models.Dispositivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DispositivoServiceImpl implements IDispositivoService {

    @Autowired
    private IDispositivoDao dispositivoDao;

    @Autowired
    private IConexionDao conexionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Dispositivo> findAll(Sort sort) {
        return dispositivoDao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Dispositivo> findAll(Pageable pageable) {
        return dispositivoDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Dispositivo findById(long id) {
        return dispositivoDao.findById(id);
    }

    @Override
    @Transactional
    public Boolean delete(Long id) {
        try {
            dispositivoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public Dispositivo save(Dispositivo dispositivo) {

        Conexion conexion = conexionDao.findById(dispositivo.getConexion().getId()).orElse(new Conexion());

        dispositivo.setConexion(conexion);

        return dispositivoDao.save(dispositivo);

    }

}
