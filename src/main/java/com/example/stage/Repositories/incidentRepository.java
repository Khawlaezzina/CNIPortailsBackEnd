package com.example.stage.Repositories;

import com.example.stage.Entities.incident;

import com.example.stage.Entities.probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface incidentRepository extends JpaRepository<incident,Long> {


    @Query("SELECT incident from incident incident WHERE incident.idUtilisateur.departement=?1 and incident.ticketStatut=?2")
    List<incident> findIncidentByDepartementAndStatut(String departement, String statut);

    @Query("SELECT i from incident i WHERE i.ticketStatut=?1 order by i.priorite desc ")
    List<incident> findIncidentByStatut(String statut);

    @Query("SELECT i from incident i WHERE i.idUtilisateur.id=?1")
    List<incident>  findIncidentByUser(Long idUser);

    @Query("SELECT incident from incident incident WHERE incident.idUtilisateur.id=?1 and incident.ticketStatut=?2 order by incident.priorite desc ")
    List<incident> findIncidentByUserAndStatut(Long idUser, String statut);

    @Query("SELECT incident from incident incident where incident.dateOuverture=?1")
    List<incident> findIncidentByDate(String date);

    @Query("SELECT incident from incident incident where incident.urgence=?1")
    List<incident> findIncidentByUrgenceDegree(String urgence);

    @Query("SELECT incident from incident incident where incident.impact=?1")
    List<incident> findIncidentByImpactDegree(String impact);

    @Query("SELECT i from incident i WHERE i.idApprobateur.id=?1 and i.idUtilisateur.id is NULL ")
    List<incident>  findIncidentByApprobateur(Long idApprobateur);

    @Query("SELECT incident from incident incident WHERE incident.idApprobateur.id=?1 and incident.ticketStatut=?2 ")
    List<incident> findIncidentByApprobateurAndStatut(Long idApprobateur, String statut);

    @Query("UPDATE incident SET priorite=?2 WHERE id=?1")
    incident updatePriorite(Long idIncident,Long priorite);





    @Query("SELECT i from incident i where i.idUtilisateur.departement=?1 and i.ticketStatut=?2 order by i.priorite DESC ")
    List<incident> findIncidentByPrioritedecroissanteAndDepartementAndStatut(String departement,String statut);

    @Query("SELECT incident from incident incident where incident.motCle like ?1 and incident.ticketStatut=?2")
    List<incident> findIncidentByMotCle(String motCle,String statut);

    @Query("SELECT incident from incident incident where incident.sujet like ?1 and incident.ticketStatut='Resolu'")
    List<incident> findIncidentBySujet(String sujet);

    @Query("SELECT incident from incident incident where incident.description like ?1 and incident.ticketStatut='Resolu'")
    List<incident> findIncidentByDescription(String description);

    @Query("SELECT incident from incident incident where incident.cause like ?1 and incident.ticketStatut=?2")
    List<incident> findIncidentByCause(String cause,String statut);

    @Query("UPDATE incident c set c.idProbleme=?1 where c.id=?2")
    incident updateIdProbleme(Long idProbleme,Long idIncident);

    @Query("select i from incident i where i.idProbleme.id=?1")
    List<incident> findIncidentsByProbleme(Long idProbleme);

    @Query("SELECT count(i) from incident i ")
    public int countUsers();

    @Query("select i from incident i where i.idProbleme.id=?1")
    public List<incident> getIncidentsByProblem(Long idProblem);



}
