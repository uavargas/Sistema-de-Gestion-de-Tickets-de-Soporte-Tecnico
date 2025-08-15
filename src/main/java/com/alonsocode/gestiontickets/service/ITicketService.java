package com.alonsocode.gestiontickets.service;


import com.alonsocode.gestiontickets.model.entity.Ticket;
import com.alonsocode.gestiontickets.model.entity.enums.EstadoTicket;

import java.util.List;

public interface ITicketService {
    Ticket crearTicket(Ticket ticket);
    Ticket actualizarEstadoTicket(Long ticketId, EstadoTicket nuevoEstado);
    void eliminarTicket(Long id);
    Ticket obtenerTicketId(Long id);
    List<Ticket> obtenerTickets();

}
