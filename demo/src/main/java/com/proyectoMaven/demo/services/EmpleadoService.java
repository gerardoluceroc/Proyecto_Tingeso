package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;
import com.proyectoMaven.demo.repositories.EmpleadoRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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



    //Metodo para calcular el descuento por inasistencias de un empleado
    public double calcularDescuentoInasistenciasNoJustificadas(EmpleadoEntity empleado){

        int cantidadInasistencias = empleadoRepository.calcularInasistenciasNoJustificadas(empleado.getId_empleado());
        double porcentajeDescuentoPorDia = 0.15;
        double porcentajeDescuentoTotal = porcentajeDescuentoPorDia * cantidadInasistencias;

        int sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());
        double descuentoTotal = sueldoFijo * porcentajeDescuentoTotal;

        //System.out.println("Cantidad de inasistencias: "+cantidadInasistencias);
        //System.out.println("Sueldo Fijo: "+sueldoFijo);


        return descuentoTotal;
    }//fin calcularDescuentoInasistencias





    //Metodo para calcular la bonificacion de un empleado por años de servicio
    public double calcularBonificacionTiempoServicio(EmpleadoEntity empleado){

        double BonificationLessThanFive = 0.0;
        double BonificationMoreThanFive = 0.05;
        double BonificationMoreThanTen = 0.08;
        double BonificationMoreThanFiveteen = 0.11;
        double BonificationMoreThanTwenty = 0.14;
        double BonificationMoreThanTwentyfive = 0.17;

        //salida
        double bonificacionTotal = 0;

        //se guarda la fecha de ingreso del empleado
        Date fechaIngreso = empleado.getFecha_ingreso();

        //Se guarda la cantidad de dias que contiene un año
        double daysPerYear = 365.25;

        Date fechaHoy = new Date();

        //Se calculan los milisegundos transcurridos entre la fecha actual y la fecha de ingreso del empleado
        long tiempoTranscurrido = fechaHoy.getTime() - fechaIngreso.getTime();

        //Se obtienen los dias transcurridos
        TimeUnit unidadMedida = TimeUnit.DAYS;
        long diasTranscurridos = unidadMedida.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        
        //Se calculan los años de servicio (int)
        Double calculoYears = diasTranscurridos / daysPerYear;
        int yearsService = calculoYears.intValue();


        //Se calcula la bonificación de acuerdo a los años de servicio y se retorna su resultado
        double sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());

        if(yearsService < 5 ){
            bonificacionTotal = sueldoFijo * BonificationLessThanFive;
            return bonificacionTotal;

        }else if((yearsService >= 5) && (yearsService < 10)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanFive;
            return bonificacionTotal;

        }else if((yearsService >= 10) && (yearsService < 15)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTen; 
            return bonificacionTotal;          

        }else if((yearsService >= 15) && (yearsService < 20)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanFiveteen;
            return bonificacionTotal;

        }else if((yearsService >= 20) && (yearsService < 25)){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTwenty;
            return bonificacionTotal;

        }else if(yearsService >= 25){
            bonificacionTotal = sueldoFijo * BonificationMoreThanTwentyfive;
            return bonificacionTotal;
        }else {
            return bonificacionTotal;
        }

        //Si lleva menos de 5 años
        //Date tiempoTranscurrido = fechaIngreso.from(Instant.now());
        //System.out.println("Fecha de ingreso: "+fechaIngreso);
        //System.out.println("Fecha de hoy: " +fechaHoy);
        //System.out.println("Tiempo transcurrido: " + tiempoTranscurrido);
        //System.out.println("Dias transcurridos: " + diasTranscurridos);
        //System.out.println("Años de servicio double: " + calculoYears);
        //System.out.println("Años de servicio int: " + yearsService);
        //System.out.println("Sueldo Fijo: " + sueldoFijo);
        //System.out.println("Beneficio por años: " + bonificacionTotal);

        
    }// fin calcular bonificacion por tiempo de servicio

    
    //Metodo para calcular la bonificacion por horas extras de un empleado
    public double calcularBonificacionHorasExtras(EmpleadoEntity empleado){

        int cantidadHorasExtras = empleadoRepository.consultarCantidadHorasExtras(empleado.getId_empleado());
        int montoHoraExtra = empleadoRepository.consultarMontoHorasExtras(empleado.getId_empleado());

        //se retorna la bonificacion por horas extras del empleado
        double bonificacionHorasExtras = montoHoraExtra * cantidadHorasExtras;
        return bonificacionHorasExtras;

    }//fin calcularBOnificacionHorasExtras























    //Metodo para calcular el sueldo final de un empleado
    //Entrada: Entidad Empleado
    //Salida: Sueldo Final
    public double calcularSueldoFinal(EmpleadoEntity empleado){

        double sueldoFinal = 0.0;
        double descuentoCotizacionPlanSalud = 0.0;
        double descuentoCotizacionPrevisional = 0.0;
        double descuentoInasistencias = 0.0;
        double descuentoAtrasos = 0.0;
        double bonificacionTiempoServicio = 0.0;
        double bonificacionHorasExtras = 0.0;

        double sueldoFijo = empleadoRepository.consultarSueldoFijoMensual(empleado.getId_empleado());

    
        //se calculan los descuentos
        descuentoCotizacionPlanSalud = calcularDescuentoCotizacionPlanSalud(empleado);
        descuentoCotizacionPrevisional = calcularDescuentoCotizacionPrevisional(empleado);
        descuentoInasistencias = calcularDescuentoInasistenciasNoJustificadas(empleado);
        //FALTAN LOS DESCUENTOS POR ATRASOS

        //Se calcula la bonificacion por horas extras
        bonificacionHorasExtras = calcularBonificacionHorasExtras(empleado);

        //Se calcula la bonificacion por años de servicio
        bonificacionTiempoServicio = calcularBonificacionTiempoServicio(empleado);

        //Finalmente, se obtiene el sueldo final
        sueldoFinal = sueldoFijo + bonificacionHorasExtras + bonificacionTiempoServicio - descuentoCotizacionPlanSalud - descuentoCotizacionPrevisional - descuentoInasistencias - descuentoAtrasos;

        return sueldoFinal;

    }








  
}