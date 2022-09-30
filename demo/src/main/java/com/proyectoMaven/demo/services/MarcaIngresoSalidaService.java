package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.MarcaIngresoSalidaEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.repositories.MarcaIngresoSalidaRepository;


@Service
public class MarcaIngresoSalidaService {

    @Autowired
    MarcaIngresoSalidaRepository marcaIngresoSalidaRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    //Metodo para agregar una marca de ingreso-salida a la base de datos
    public MarcaIngresoSalidaEntity addMarcaIngresoSalida(MarcaIngresoSalidaEntity marcaIngresoSalida){

        String rutEmpleado = marcaIngresoSalida.getRut_empleado();
        EmpleadoEntity empleado = empleadoRepository.getEmpleadoByRut(rutEmpleado);
        marcaIngresoSalida.setEmpleado(empleado);

        
        return marcaIngresoSalidaRepository.save(marcaIngresoSalida);

    }
    
}
