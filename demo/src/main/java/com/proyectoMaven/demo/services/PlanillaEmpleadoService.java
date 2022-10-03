package com.proyectoMaven.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoMaven.demo.entities.EmpleadoEntity;
import com.proyectoMaven.demo.entities.PlanillaEmpleadoEntity;
import com.proyectoMaven.demo.repositories.CategoriaEmpleadoRepository;
import com.proyectoMaven.demo.repositories.PlanillaEmpleadoRepository;



@Service
public class PlanillaEmpleadoService {

    @Autowired
    PlanillaEmpleadoRepository planillaEmpleadoRepository;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired 
    CategoriaEmpleadoRepository categoriaEmpleadoRepository;

    //Método que calcula la planilla de sueldo de un empleado
    public PlanillaEmpleadoEntity obtenerPlanilla(EmpleadoEntity empleado){

        PlanillaEmpleadoEntity planilla = new PlanillaEmpleadoEntity();

        planilla.setRut(empleado.getRut());
        planilla.setNombres(empleado.getApellidos()+" "+empleado.getNombres());
        planilla.setTiempoDeServicio(empleadoService.calcularYearsOfService(empleado));
        planilla.setSueldoFijoMensual(empleadoService.getSueldo_fijo_mensual(empleado));
        planilla.setMontoBonificacionTiempoServicio(empleadoService.calcularBonificacionTiempoServicio(empleado));
        planilla.setMontoPagoHorasExtras(empleadoService.calcularBonificacionHorasExtras(empleado));
        planilla.setMontoDescuentos(empleadoService.calcularDescuentosTotales(empleado));
        planilla.setSueldoBruto(empleadoService.calcularSueldoBruto(empleado));
        planilla.setCotizacionPrevisional(empleadoService.calcularDescuentoCotizacionPrevisional(empleado));
        planilla.setCotizacionSalud(empleadoService.calcularDescuentoCotizacionPlanSalud(empleado));
        planilla.setSueldoFinal(empleadoService.calcularSueldoFinal(empleado));
        planilla.setCategoria(empleadoService.consultarCategoriaEmpleado(empleado));

        planillaEmpleadoRepository.save(planilla);
        return planilla;
    }

    
    
}
