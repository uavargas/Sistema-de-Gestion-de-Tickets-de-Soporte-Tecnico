package com.alonsocode.gestiontickets.model.entity;

import com.alonsocode.gestiontickets.model.entity.enums.EstadoTicket;
import com.alonsocode.gestiontickets.model.entity.enums.PrioridadTicket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private Long id;
    private String titulo;
    private String descripcion;
    private PrioridadTicket prioridad;
    private EstadoTicket estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaCierre;

    public Ticket() {
    }

    public Ticket(Long id, String titulo, String descripcion, PrioridadTicket prioridad, EstadoTicket estado, LocalDateTime fechaCreacion, LocalDateTime fechaCierre) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PrioridadTicket getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTicket prioridad) {
        this.prioridad = prioridad;
    }

    public EstadoTicket getEstado() {
        return estado;
    }

    public void setEstado(EstadoTicket estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        fechaCreacion = LocalDateTime.parse(fechaCreacion.format(formatter), formatter);
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
