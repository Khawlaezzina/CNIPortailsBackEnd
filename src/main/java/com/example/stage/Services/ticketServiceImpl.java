package com.example.stage.Services;

import com.example.stage.Entities.ticket;
import com.example.stage.Repositories.administrateurRepository;
import com.example.stage.Repositories.ticketRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("TicketService")
@Transactional
public class ticketServiceImpl implements ticketService{

    @Autowired
    private ticketRepository ticketRepository;
    @Override
    public ticket saveTicket(ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public ticket updateTicket(Long ticketId, ticket ticketRequest) {
       return ticketRepository.findById(ticketId).map(ticket -> {
            ticket.setTicketStatut(ticketRequest.getTicketStatut());
            ticket.setImpact(ticketRequest.getImpact());
            ticket.setUrgence(ticketRequest.getUrgence());
            ticket.setIdApprobateur(ticketRequest.getIdApprobateur());
            ticket.setDescription(ticketRequest.getDescription());
            ticket.setSujet(ticketRequest.getSujet());
            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " + ticketId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).map(ticket -> {
            ticketRepository.delete(ticket);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " +
                ticketId + " not found"));
    }

    @Override
    public Optional<ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<ticket> findTicketByDepartementAndStatut(String departement, String statut) {
        return ticketRepository.findTicketByDepartementAndStatut(departement, statut);
    }

    @Override
    public List<ticket> findTicketByStatut(String statut) {
        return ticketRepository.findTicketByStatut(statut);
    }

    @Override
    public List<ticket> findTicketByUser(Long idUser) {
        return ticketRepository.findTicketByUser(idUser);
    }

    @Override
    public List<ticket> findTicketByUserAndStatut(Long idUser, String statut) {
        return ticketRepository.findTicketByUserAndStatut(idUser, statut);
    }

    @Override
    public List<ticket> findTicketByDate(Date date) {
        return ticketRepository.findTicketByDate(date);
    }

    @Override
    public List<ticket> findTicketByUrgenceDegree(String urgence) {
        return ticketRepository.findTicketByUrgenceDegree(urgence);
    }

    @Override
    public List<ticket> findTicketByImpactDegree(String impact) {
        return ticketRepository.findTicketByImpactDegree(impact);
    }

    @Override
    public List<ticket> findTicketByApprobateur(Long idApprobateur) {
        return ticketRepository.findTicketByApprobateur(idApprobateur);
    }

    @Override
    public List<ticket> findTicketByApprobateurAndStatut(Long idApprobateur, String statut) {
        return ticketRepository.findTicketByApprobateurAndStatut(idApprobateur, statut);
    }
}
