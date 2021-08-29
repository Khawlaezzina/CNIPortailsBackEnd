package com.example.stage.Repositories;

import com.example.stage.Entities.ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ticketRepository extends JpaRepository<ticket,Long> {

    @Query("SELECT ticket from ticket ticket WHERE ticket.idUtilisateur.departement=?1 and ticket.ticketStatut=?2")
    List<ticket> findTicketByDepartementAndStatut(String departement,String statut);

    @Query("SELECT ticket from ticket ticket WHERE ticket.ticketStatut=?1")
    List<ticket> findTicketByStatut(String statut);

    @Query("SELECT ticket from ticket ticket WHERE ticket.idUtilisateur.id=?1")
    List<ticket>  findTicketByUser(Long idUser);

    @Query("SELECT ticket from ticket ticket WHERE ticket.idUtilisateur.id=?1 and ticket.ticketStatut=?2 ")
    List<ticket> findTicketByUserAndStatut(Long idUser, String statut);

    @Query("SELECT ticket from ticket ticket where ticket.dateOuverture=?1")
    List<ticket> findTicketByDate(Date date);

    @Query("SELECT ticket from ticket ticket where ticket.urgence=?1")
    List<ticket> findTicketByUrgenceDegree(String urgence);

    @Query("SELECT ticket from ticket ticket where ticket.impact=?1")
    List<ticket> findTicketByImpactDegree(String impact);

    @Query("SELECT ticket from ticket ticket WHERE ticket.idApprobateur.id=?1")
    List<ticket>  findTicketByApprobateur(Long idApprobateur);

    @Query("SELECT ticket from ticket ticket WHERE ticket.idApprobateur.id=?1 and ticket.ticketStatut=?2 ")
    List<ticket> findTicketByApprobateurAndStatut(Long idApprobateur, String statut);






}
