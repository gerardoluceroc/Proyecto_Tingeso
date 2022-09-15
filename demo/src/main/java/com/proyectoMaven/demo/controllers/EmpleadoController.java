package com.proyectoMaven.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.services.EmpleadoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class EmpleadoController {
    @Autowired
	EmpleadoService empleadoService;

    @GetMapping("/empleados/")
    public List<EmpleadoEntity> obtenerUsuarios(){
        return empleadoService.obtenerUsuarios();
    }

    @GetMapping("/hola/")
    public String retornar(){
        return "index";
    }

    //meetodo profe
    @GetMapping("/listar")
	public String listar(Model modelo) {
    	ArrayList<EmpleadoEntity> empleados=empleadoService.obtenerUsuarios();
    	modelo.addAttribute("empleados",empleados);
        //System.out.println("Hola usuario bienvenido empleado"+ modelo +"KKKKK");
		return "index";
	}
}