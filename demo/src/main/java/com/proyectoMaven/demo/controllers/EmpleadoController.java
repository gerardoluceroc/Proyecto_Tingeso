package com.proyectoMaven.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoMaven.demo.entities.CategoriaEmpleadoEntity;
import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.MarcaIngresoSalidaEntity;
import com.proyectoMaven.demo.entities.PlanillaEmpleadoEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;
import com.proyectoMaven.demo.services.EmpleadoService;
import com.proyectoMaven.demo.services.PlanillaEmpleadoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping()
public class EmpleadoController {
    @Autowired
	EmpleadoService empleadoService;

    @Autowired
    PlanillaEmpleadoService planillaEmpleadoService;

///* 
    @GetMapping("/empleados/")
    public List<EmpleadoEntity> obtenerUsuarios(){
        return empleadoService.obtenerUsuarios();
    }

    //metodo para recibir una petición get y calcular la planilla de sueldos de los empleados
    //VERSION DE PRUEBA, FUNCIONA BIEN
    @GetMapping("/empleados/planillassssssssssss")
	public String calcularPlanilla(Model modelo) {
    	ArrayList<EmpleadoEntity> empleados=empleadoService.obtenerUsuarios();
    	modelo.addAttribute("empleados",empleados);
		return "index";
	}

    //Metodo para recibir una petición get y calcular la planilla de sueldos de los empleados
    //METODO FINAL, MODO BETA
    @GetMapping("empleados/planillas")
    public String obtenerPlanilla(Model modelo){

        //Se obtienen todos los empleados
        ArrayList<EmpleadoEntity> empleados = empleadoService.obtenerUsuarios();

        ArrayList<PlanillaEmpleadoEntity> planillaSueldos = new ArrayList<PlanillaEmpleadoEntity>();

        int i = 0;
        int cantidadEmpleados = empleados.size();

        //Se evalua cada empleado y se obtiene su planilla de sueldo
        while (i<cantidadEmpleados){
            
            PlanillaEmpleadoEntity planilla = planillaEmpleadoService.obtenerPlanilla(empleados.get(i));
            planillaSueldos.add(planilla);
            i = i+1;
        }

        //Se agrega al modelo la planilla con todos los sueldos
        modelo.addAttribute("planillaSueldos",planillaSueldos);

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


    public String recibe(@RequestBody EmpleadoEntity empleado){

        System.out.println("Post recibido de pana");
        System.out.println("rut : "+empleado.getRut());
        System.out.println("nombres : "+empleado.getNombres());
        System.out.println("apellidos : "+empleado.getApellidos());
        System.out.println("fecha_nacimiento : "+empleado.getFecha_nacimiento());
        System.out.println("fecha_ingreso : "+empleado.getFecha_ingreso());
        System.out.println("id_categoria : "+empleado.getCategoria());
        System.out.println("id : "+empleado.getId_empleado());

        System.out.println("Ahora printearé el objeto entero\n"+empleado);
        
        return "index";
    }

    
}