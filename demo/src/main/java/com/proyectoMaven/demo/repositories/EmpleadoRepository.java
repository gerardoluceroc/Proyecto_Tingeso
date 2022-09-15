package com.proyectoMaven.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectoMaven.demo.entities.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {

   

}