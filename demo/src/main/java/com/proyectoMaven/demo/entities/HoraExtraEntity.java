package com.proyectoMaven.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "horas_extras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoraExtraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_horaExtra;

    private String fecha;
    private String rutEmpleado;
    private String cantidadHorasAprobadas;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntity empleado;


    //Getters y Setters de los atributos


    public Long getId_horaExtra() {
        return this.id_horaExtra;
    }

    public void setId_horaExtra(Long id_horaExtra) {
        this.id_horaExtra = id_horaExtra;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRutEmpleado() {
        return this.rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getCantidadHorasAprobadas() {
        return this.cantidadHorasAprobadas;
    }

    public void setCantidadHorasAprobadas(String cantidadHorasAprobadas) {
        this.cantidadHorasAprobadas = cantidadHorasAprobadas;
    }


    public EmpleadoEntity getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

}