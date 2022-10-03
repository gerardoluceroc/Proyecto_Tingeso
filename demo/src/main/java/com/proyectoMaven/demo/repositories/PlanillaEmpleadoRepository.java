package com.proyectoMaven.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectoMaven.demo.entities.PlanillaEmpleadoEntity;

@Repository
public interface PlanillaEmpleadoRepository extends CrudRepository<PlanillaEmpleadoEntity, Long> {

    



}