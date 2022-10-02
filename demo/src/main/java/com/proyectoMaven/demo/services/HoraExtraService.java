package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.HoraExtraEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.repositories.HoraExtraRepository;

@Service
public class HoraExtraService {

    @Autowired
    HoraExtraRepository horaExtraRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void saveHoraExtra(HoraExtraEntity horaExtra){

        EmpleadoEntity empleado = empleadoRepository.getEmpleadoByRut(horaExtra.getRutEmpleado());
        horaExtra.setEmpleado(empleado);


        horaExtraRepository.save(horaExtra);

    }

    
    
}
