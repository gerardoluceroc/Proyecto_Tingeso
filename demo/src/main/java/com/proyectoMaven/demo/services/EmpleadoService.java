package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;


    
    //Metodo para obtener todos los usuarios en la base de datos
    public ArrayList<EmpleadoEntity> obtenerUsuarios(){

        return ((ArrayList<EmpleadoEntity>) empleadoRepository.findAll());
    }
    





    //Metodo para calcular el sueldo final de un empleado
    //Entrada: Entidad Empleado
    //Salida: Sueldo Final
    public int calcularSueldoFinal(){

        return 1;




    }//fin calcularSueldoFinal()





  
}