package com.proyectoMaven.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "inasistencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InasistenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_inasistencia;

    private Date fecha;
    private boolean justificativoAprobado;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntity empleado;

    //Getters y Setters de los atributos

    public Long getId_inasistencia() {
        return this.id_inasistencia;
    }

    public void setId_inasistencia(Long id_inasistencia) {
        this.id_inasistencia = id_inasistencia;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isJustificativoAprobado() {
        return this.justificativoAprobado;
    }

    public boolean getJustificativoAprobado() {
        return this.justificativoAprobado;
    }

    public void setJustificativoAprobado(boolean justificativoAprobado) {
        this.justificativoAprobado = justificativoAprobado;
    }

    public EmpleadoEntity getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }


    //Getters y Setters de los atributos

    
    
}