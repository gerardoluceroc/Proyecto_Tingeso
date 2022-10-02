package com.proyectoMaven.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoMaven.demo.entities.InasistenciaEntity;
import com.proyectoMaven.demo.services.InansistenciaService;

@Controller
@RequestMapping()
public class InasitenciaController {
    @Autowired
	InansistenciaService inasistenciaService;


    //Controlador para recibir las marcas de ingreso salida e ingresarlas en la base datos
    @RequestMapping(value= "/inasistencia/enviarjustificativo", method = RequestMethod.POST)
    public String agregarJustificativo(InasistenciaEntity justificativo){

        System.out.println("El justificativo recibido es");
        System.out.println(justificativo);

        inasistenciaService.updateInasistencia(justificativo);



        

        return "index";
    }

}    


    