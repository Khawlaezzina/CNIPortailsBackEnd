package com.example.stage.Services;

import com.example.stage.Entities.ticket;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ticketService {

    public ticket saveTicket(ticket ticket);

    public ticket updateTicket(Long ticketId,ticket ticket);

    public ResponseEntity<Object> deleteTicket (Long adminId);

    public Optional<ticket> findById(Long id);

    public List<ticket> getAll();

    List<ticket> findTicketByDepartementAndStatut(String departement,String statut);

    List<ticket> findTicketByStatut(String statut);

    List<ticket>  findTicketByUser(Long idUser);

    List<ticket> findTicketByUserAndStatut(Long idUser, String statut);

    List<ticket> findTicketByDate(Date date);

    List<ticket> findTicketByUrgenceDegree(String urgence);

    List<ticket> findTicketByImpactDegree(String impact);

    List<ticket>  findTicketByApprobateur(Long idApprobateur);

    List<ticket> findTicketByApprobateurAndStatut(Long idApprobateur, String statut);

}
