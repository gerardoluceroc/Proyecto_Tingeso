package com.proyectoMaven.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "marcas_ingreso_salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaIngresoSalidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_marcaIngresoSalida;

    private String hora_entrada;
    private String hora_salida;
    private String fecha;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoEntity empleado;

    public Long getId_marcaIngresoSalida() {
        return this.id_marcaIngresoSalida;
    }

    public void setId_marcaIngresoSalida(Long id_marcaIngresoSalida) {
        this.id_marcaIngresoSalida = id_marcaIngresoSalida;
    }

    public String getHora_entrada() {
        return this.hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return this.hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EmpleadoEntity getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }


    //Getters y Setters de los atributos

    
    
}