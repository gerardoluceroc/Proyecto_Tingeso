package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;
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
    



    public ArrayList<EmpleadoEntity> buscarEmpleadoPorId(Long valor_id){

        return empleadoRepository.buscarEmpleadoPorId(valor_id);


    }



    //Metodo para calcular el descuento por prevision social de un empleado
    public static double calcularDescuentoCotizacionPrevisional(EmpleadoEntity empleado){

        //Porcentaje que se descuento por cotizacion previsional
        double porcentajeCotizacionPrevisional = 0.1;

        //Se obtiene el sueldo fijo mensual del empleado de acuerdo a su categoría
        int sueldoFijoMensual = empleado.getCategoria().getSueldo_fijo_mensual();

        //descuento total del sueldo fijo mensual para cotizacion previsional
        double descuentoCotizacionPrevisional = sueldoFijoMensual * porcentajeCotizacionPrevisional;

        return descuentoCotizacionPrevisional;

    }//Fin calcularDescuentoCotizacionSocial()

     //Metodo para calcular el descuento por la cotizacion del plan de salud de un empleado
     public static double calcularDescuentoCotizacionPlanSalud(EmpleadoEntity empleado){

        //Porcentaje que se descuenta por cotización del plan de salud
        double porcentajeCotizacionPlanSalud = 0.08;

        //Se obtiene el sueldo fijo mensual del empleado de acuerdo a su categoría
        int sueldoFijoMensual = empleado.getCategoria().getSueldo_fijo_mensual();

        //descuento total del sueldo fijo mensual para cotizacion previsional
        double descuentoCotizacionPlanSalud = sueldoFijoMensual * porcentajeCotizacionPlanSalud;

        return descuentoCotizacionPlanSalud;

    }//Fin calcularDescuentoCotizacionPlanSalud()

    //Metodo que calcula el descuento de un empleado debido a inasistencias no justificadas
    //double calcularDescuentoInasistencias(EmpleadoEntity empleado){

        //Se consulta en la base de datos por las inasistencias del empleado
      //  ArrayList<InasistenciaEntity> 


//    }//fin calcularDescuentoInasistencias











//BORRAR
public ArrayList<EmpleadoEntity> prueba(Long id){

    return empleadoRepository.prueba(id);
} 
















    //Metodo para calcular el sueldo final de un empleado
    //Entrada: Entidad Empleado
    //Salida: Sueldo Final
    public double calcularSueldoFinal(EmpleadoEntity empleado){

        double sueldoFinal = 0;
        double descuentoCotizacionPlanSalud = 0;
        double descuentoCotizacionPrevisional = 0;
        double descuentoInasistencias = 0;
        double descuentoAtrasos = 0;

    
        //se calculan los descuentos
        descuentoCotizacionPlanSalud = calcularDescuentoCotizacionPlanSalud(empleado);
        descuentoCotizacionPrevisional = calcularDescuentoCotizacionPrevisional(empleado);

        return sueldoFinal;

    }//fin calcularSueldoFinal()





  
}