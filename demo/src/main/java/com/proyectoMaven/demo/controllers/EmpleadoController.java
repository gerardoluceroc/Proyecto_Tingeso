package com.proyectoMaven.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.services.EmpleadoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping()
public class EmpleadoController {
    @Autowired
	EmpleadoService empleadoService;

///* 
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
        System.out.println("Hola usuario bienvenido empleado"+ modelo +"KKKKK");
		return "index";
	}

    //consultar por empleado por id
    @GetMapping("/empleados/{id}")
    public String buscarEmpleadoPorId(@PathVariable Long id, Model modelo){

        ArrayList<EmpleadoEntity> empleado = empleadoService.buscarEmpleadoPorId(id);
        modelo.addAttribute("empleados",empleado);

        return "index";
    }

    //prueba controller
    @GetMapping("/prueba")
    public String prueba(Model modelo){

      //  int cantidadInasistencias = empleadoService.prueba(id);
       // System.out.println("Las inasistencias del empleado con id "+id+" es "+cantidadInasistencias);
        //modelo.addAttribute("empleados",empleado);
        ArrayList<EmpleadoEntity> empleados = empleadoService.obtenerUsuarios(); 
        EmpleadoEntity empleadoPrueba = empleados.get(0);
        //double fechaIngreso = empleadoService.calcularBonificacionTiempoServicio(empleadoPrueba);
        empleadoService.calcularSueldoFinal(empleadoPrueba);
        return "index";


    }

  //  */
}