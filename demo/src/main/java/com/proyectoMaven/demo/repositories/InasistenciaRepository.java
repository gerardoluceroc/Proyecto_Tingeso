package com.proyectoMaven.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;

@Repository
public interface InasistenciaRepository extends JpaRepository<InasistenciaEntity, Long> {


    //Metodo para obtener las inasistencias de un empleado
    //El metodo consulta la base de datos de acuerdo al ID del empleado

    //@Query(value = "SELECT e FROM empleados WHERE e.id_categoria = 3", nativeQuery = true)
    //public ArrayList<InasistenciaEntity> obtenerInasistenciasEmpleado(EmpleadoEntity empleado);

        //Listado de salida
        //ArrayList<InasistenciaEntity> listaInasistencias = new ArrayList<InasistenciaEntity>();

        //@Query("Select * FROM inasistencias")
        //ArrayList<InasistenciaEntity> obtenerInasistencias(EmpleadoEntity)

        //@Query("Select * FROM inasistencias")
    // fin obtenerInasistenciasEmpleado


   

}