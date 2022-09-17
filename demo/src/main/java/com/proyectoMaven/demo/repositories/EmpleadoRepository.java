package com.proyectoMaven.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.InasistenciaEntity;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {

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


}