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

 

    //Se consulta a la base de datos la cantidad de inasistencias no justificadas que tiene un empleado
    @Query(value = "select count(*) from inasistencias i where i.id_empleado = :valor_id and i.justificativo_aprobado = false", nativeQuery = true)
    int calcularInasistenciasNoJustificadas(@Param("valor_id") Long valor_id);


    //Se consulta a la base de datos por el sueldo fijo mensual de un empleado de acuerdo a su id
    @Query(value = "select c.sueldo_fijo_mensual from categorias_empleados c, empleados e where e.id_categoria = c.id_categoria and e.id_empleado = :id", nativeQuery = true)
    int consultarSueldoFijoMensual(@Param("id") Long id);





















































    //BORRAR
    //@Query(value = "SELECT * FROM empleados e WHERE e.id_categoria = :valor_id", nativeQuery = true)
    //@Query(value = "select count(*) from inasistencias i where i.id_empleado = :valor_id and i.justificativo_aprobado = false", nativeQuery = true)
    //int prueba(@Param("valor_id") Long valor_id);

    //Se








     //PRUEBA DE QUERY (BORRAR DPS)
     @Query(value = "SELECT * FROM empleados e WHERE e.id_categoria = :valor_id", nativeQuery = true)
     //@Query(value = "select e from Empleado where e.id_categoria = :valor_id")
     public ArrayList<EmpleadoEntity> buscarEmpleadoPorId(@Param("valor_id") Long valor_id);
 


}