package com.proyectoMaven.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_empleado;

    private String rut;
    private String nombres;
    private String apellidos;
    private Date fecha_nacimiento;
    private Date fecha_ingreso;
    private Long id_categoria;



    //Getters
    public Long getId_empleado() {
        return id_empleado;
    }

    public String getRut() {
        return rut;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public Long getId_categoria() {
        return id_categoria;
    }


    //Setters

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }


   
}

