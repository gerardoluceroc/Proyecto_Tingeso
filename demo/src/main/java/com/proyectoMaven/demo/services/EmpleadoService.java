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
    
    public ArrayList<EmpleadoEntity> obtenerUsuarios(){

        return ((ArrayList<EmpleadoEntity>) empleadoRepository.findAll());
    }

  
}