package com.example.stage.Repositories;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.service;
import com.example.stage.Entities.ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface serviceRepository extends JpaRepository<service,Long> {

    @Query("SELECT s from service s WHERE s.idUtilisateur.departement=?1 and s.ticketStatut=?2")
    List<service> findServiceByDepartementAndStatut(String departement, String statut);

    @Query("SELECT service from service service WHERE service.ticketStatut=?1")
    List<service> findServiceByStatut(String statut);

    @Query("SELECT service from service service WHERE service.idUtilisateur.id=?1")
    List<service>  findServiceByUser(Long idUser);

    @Query("SELECT service from service service WHERE service.idUtilisateur.id=?1 and service.ticketStatut=?2 ")
    List<service> findServiceByUserAndStatut(Long idUser, String statut);

    @Query("SELECT service from service service where service.dateOuverture=?1")
    List<service> findServiceByDate(String date);

    @Query("SELECT service from service service where service.urgence=?1")
    List<service> findServiceByUrgenceDegree(String urgence);

    @Query("SELECT service from service service where service.impact=?1")
    List<service> findServiceByImpactDegree(String impact);

    @Query("SELECT s from service s WHERE s.idApprobateur.id=?1 and s.idUtilisateur.id is NULL ")
    List<service>  findServiceByApprobateur(Long idApprobateur);

    @Query("SELECT service from service service WHERE service.idApprobateur.id=?1 and service.ticketStatut=?2 ")
    List<service> findServiceByApprobateurAndStatut(Long idApprobateur, String statut);
    @Query("UPDATE service SET priorite=?2 WHERE id=?1")
    service updatePriorite(Long idService,Long priorite);

    @Query("SELECT distinct(sujet) from service ")
    List<String> findAllSujets();
    @Query("SELECT count(s) from service s ")
    public int countServices();
}
