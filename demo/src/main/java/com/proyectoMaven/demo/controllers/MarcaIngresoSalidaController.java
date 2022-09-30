package com.proyectoMaven.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoMaven.demo.entities.MarcaIngresoSalidaEntity;
import com.proyectoMaven.demo.services.MarcaIngresoSalidaService;

@Controller
@RequestMapping()
public class MarcaIngresoSalidaController {
    @Autowired
	MarcaIngresoSalidaService marcaIngresoSalidaService;


    //prueba de envío post
    @RequestMapping(value= "/empleados/enviarmarcas", method = RequestMethod.POST)
    public String agregarMarcasIngresoSalida(@RequestBody ArrayList<MarcaIngresoSalidaEntity> marcasIngresoSalida){

        int i=0;
        int cantidadMarcas = marcasIngresoSalida.size();
        System.out.println("cantidad de marcas es"+cantidadMarcas);
        while(i < cantidadMarcas){

            System.out.println("Las marcas son:");
            System.out.println(marcasIngresoSalida.get(i));
            marcaIngresoSalidaService.addMarcaIngresoSalida(marcasIngresoSalida.get(i));
            i=i+1;


        }
        System.out.println("ahora retornaré index");

        return "index";
    }


    
}