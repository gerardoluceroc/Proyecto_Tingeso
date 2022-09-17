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

    private Date fecha;
    private boolean horaExtraAprobada;
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

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isHoraExtraAprobada() {
        return this.horaExtraAprobada;
    }

    public boolean getHoraExtraAprobada() {
        return this.horaExtraAprobada;
    }

    public void setHoraExtraAprobada(boolean horaExtraAprobada) {
        this.horaExtraAprobada = horaExtraAprobada;
    }

    public EmpleadoEntity getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
    
}