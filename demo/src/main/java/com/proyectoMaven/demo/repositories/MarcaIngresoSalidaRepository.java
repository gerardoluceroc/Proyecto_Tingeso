package com.proyectoMaven.demo.repositories;

import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;
import com.proyectoMaven.demo.entities.MarcaIngresoSalidaEntity;

@Repository
public interface MarcaIngresoSalidaRepository extends CrudRepository<MarcaIngresoSalidaEntity, Long> {

    



 

}