package com.PruebaTecnica.PruebaTecnica.dao;

import java.util.List;

import com.PruebaTecnica.PruebaTecnica.models.Dispositivo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IDispositivoDao extends JpaRepository<Dispositivo, Long> {

    @Query(value = "select d from Dispositivo d left join fetch d.conexion")
    public List<Dispositivo> findAll( Sort sort);

    @Query(value = "select d from Dispositivo d left join fetch d.conexion", countQuery = "select count(d) from Dispositivo d left join d.conexion")
    public Page<Dispositivo> findAll(Pageable pageable);

    @Query(value = "select d from Dispositivo d left join fetch d.conexion where d.id = :id")
    public Dispositivo findById(long id);
    
}
