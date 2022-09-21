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

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {

 
    //BORRAR
    @Query(value = "SELECT * FROM empleados e WHERE e.id_categoria = :valor_id", nativeQuery = true)
    ArrayList<EmpleadoEntity> prueba(@Param("valor_id") Long valor_id);








     //PRUEBA DE QUERY (BORRAR DPS)
     @Query(value = "SELECT * FROM empleados e WHERE e.id_categoria = :valor_id", nativeQuery = true)
     //@Query(value = "select e from Empleado where e.id_categoria = :valor_id")
     public ArrayList<EmpleadoEntity> buscarEmpleadoPorId(@Param("valor_id") Long valor_id);
 


}