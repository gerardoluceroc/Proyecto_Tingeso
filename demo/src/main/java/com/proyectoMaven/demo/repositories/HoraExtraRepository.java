package com.proyectoMaven.demo.repositories;

import java.util.ArrayList;

import javax.persistence.PostUpdate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.HoraExtraEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;

@Repository
public interface HoraExtraRepository extends CrudRepository<HoraExtraEntity, Long> {
    

    //Se obtiene una hora extra de acuerdo al rut de un empleado y la fecha
    @Query(value = "select * from horas_extras h where h.rut_empleado = :rut and h.fecha = :fecha", nativeQuery = true)
    HoraExtraEntity consultarHoraExtraByRutFecha(@Param("rut") String rut, @Param("fecha") String fecha);


}