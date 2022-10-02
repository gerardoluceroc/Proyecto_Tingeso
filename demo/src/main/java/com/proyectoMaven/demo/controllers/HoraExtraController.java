package com.proyectoMaven.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoMaven.demo.entities.HoraExtraEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;
import com.proyectoMaven.demo.services.HoraExtraService;
import com.proyectoMaven.demo.services.InansistenciaService;

@Controller
@RequestMapping()
public class HoraExtraController {
    @Autowired
	HoraExtraService horaExtraService;

    //Controlador para recibir una autorización de horas extras e ingresarlas en la base datos
    @RequestMapping(value= "/horas_extras/enviarautorizacion", method = RequestMethod.POST)
    public String agregarHoraExtra(HoraExtraEntity horaExtra){

        horaExtraService.saveHoraExtra(horaExtra);

        return "index";
    }

}    
