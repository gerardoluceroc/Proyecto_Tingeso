package com.proyectoMaven.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "empleados_marcasIngresoSalida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado_marcaIngresoSalidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_empleado_marcaIngresoSalida;

    private Long id_empleado;
    private Long id_marcaIngresoSalida;


    //Getters y Setters de los atributos

    public Long getId_empleado_marcaIngresoSalida() {
        return this.id_empleado_marcaIngresoSalida;
    }

    public void setId_empleado_marcaIngresoSalida(Long id_empleado_marcaIngresoSalida) {
        this.id_empleado_marcaIngresoSalida = id_empleado_marcaIngresoSalida;
    }

    public Long getId_empleado() {
        return this.id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Long getId_marcaIngresoSalida() {
        return this.id_marcaIngresoSalida;
    }

    public void setId_marcaIngresoSalida(Long id_marcaIngresoSalida) {
        this.id_marcaIngresoSalida = id_marcaIngresoSalida;
    }


    
}