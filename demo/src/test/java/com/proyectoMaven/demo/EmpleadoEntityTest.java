package com.proyectoMaven.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyectoMaven.demo.entities.CategoriaEmpleadoEntity;
import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.services.EmpleadoService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

class EmpleadoEntityTest {
    EmpleadoEntity empleado = new EmpleadoEntity();

    @Autowired
    EmpleadoService empleadoService;

    @Test
    void calcularDescuentoCotizacionPrevisional() {

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double descuentoCotizacionPrevisional = empleadoService.calcularDescuentoCotizacionPrevisional(empleado);
        assertEquals(170000, descuentoCotizacionPrevisional, 0.0);
    }

    @Test
    void calcularDescuentoCotizacionPlanSalud() {

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double descuentoCotizacionPlanSalud = empleadoService.calcularDescuentoCotizacionPlanSalud(empleado);
        assertEquals(136000, descuentoCotizacionPlanSalud, 0.0);
    }

    @Test
    void calcularDescuentoInasistencias() {

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double descuentoInasistencias = empleadoService.calcularDescuentoInasistenciasNoJustificadas(empleado);
        assertEquals(0, descuentoInasistencias, 0.0);
    }

    @Test
    void calcularYearsOfService() {

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        int yearsOfService = empleadoService.calcularYearsOfService(empleado);
        assertEquals(0, yearsOfService, 0.0);
    }
    @Test
    void calcularBonificacionTiempoServicio(){

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double bonificacionTiempoServicio = empleadoService.calcularBonificacionTiempoServicio(empleado);
        assertEquals(0, bonificacionTiempoServicio, 0.0);
    }
    @Test
    void getSueldo_fijo_mensual(){

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double sueldoFijoMensual = empleadoService.getSueldo_fijo_mensual(empleado);
        assertEquals(1700000, sueldoFijoMensual, 0.0);
    }

    @Test
    void calcularBonificacionHorasExtras(){

        CategoriaEmpleadoEntity categoria = new CategoriaEmpleadoEntity();
        categoria.setMonto_hora_extra(25000);
        categoria.setSueldo_fijo_mensual(1700000);
        categoria.setTipo_categoria("A");

        empleado.setRut("19.919.462-3");
        empleado.setNombres("Gerardo Antonio");
        empleado.setApellidos("Lucero Cordova");
        empleado.setFecha_ingreso(Date.valueOf("2010-01-01"));
        empleado.setFecha_nacimiento(Date.valueOf("1998-11-20"));
        empleado.setCategoria(categoria);

        double bonificacionHorasExtras = empleadoService.calcularBonificacionHorasExtras(empleado);
        assertEquals(0, bonificacionHorasExtras, 0.0);
    }


}