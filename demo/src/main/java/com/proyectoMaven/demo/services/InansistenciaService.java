package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.repositories.InasistenciaRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InansistenciaService {
    @Autowired
    InasistenciaRepository inasistenciaRepository; 


    //Metodo para guardar una inasistencia
    public void saveInasistencia(InasistenciaEntity inasistencia){

        inasistenciaRepository.save(inasistencia);
    }

    //Metodo para actualizar una inasistencia, ingresando el justificativo, osea se cambian
    //lo valores de los atributos "justificativoAprobado" y "motivoInasistencia"
    public void updateInasistencia (InasistenciaEntity inasistenciaActualizada){

        InasistenciaEntity inasistenciaOriginal = inasistenciaRepository.consultarInasistenciaByRutFecha(inasistenciaActualizada.getRutEmpleado(),inasistenciaActualizada.getFecha());

        //Se copian los valores de la inasistencia original a la nueva que será la versión actualizada
        inasistenciaActualizada.setId_inasistencia(inasistenciaOriginal.getId_inasistencia());
        inasistenciaActualizada.setJustificativoAprobado(true);
        inasistenciaActualizada.setEmpleado(inasistenciaOriginal.getEmpleado());

        //se actualiza el registro
        inasistenciaRepository.save(inasistenciaActualizada);

    }//fin updateInasistencia


    


    




    




  
}