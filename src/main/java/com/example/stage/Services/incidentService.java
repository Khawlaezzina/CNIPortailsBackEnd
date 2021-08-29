package com.example.stage.Services;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface incidentService {
    public incident saveIncident(incident incident);

    public incident updateIncident(Long ticketId,incident ticket);

    public ResponseEntity<Object> deleteIncident (Long incidentId);

    public Optional<incident> findById(Long id);

    public List<incident> getAll();
    public  List<incident> findIncidentByDepartementAndStatut(String departement, String statut);
    public List<incident> findIncidentByStatut(String statut);
    public List<incident>  findIncidentByUser(Long idUser);
    public List<incident> findIncidentByUserAndStatut(Long idUser, String statut);
    public List<incident> findIncidentByDate(String date);
    public List<incident> findIncidentByUrgenceDegree(String urgence);
    public List<incident> findIncidentByImpactDegree(String impact);
    public List<incident>  findIncidentByApprobateur(Long idApprobateur);
    public List<incident> findIncidentByApprobateurAndStatut(Long idApprobateur, String statut);
    public incident updatePriorite(Long idIncident,Long priorite);

    public List<incident> findIncidentByPrioritedecroissanteAndDepartementAndStatut(String departement,String statut);
    public List<incident> findIncidentBySujet(String sujet);
    public List<incident> findIncidentByDescription(String description);
    public List<incident> findIncidentByCause(String cause,String statut);
    public List<incident> findIncidentByMotCle(String motCle,String statut);
    incident updateIdProbleme(Long idProbleme,Long idIncident);
    public List<incident> findIncidentsByProbleme(Long idProbleme);
    public List<incident> getIncidentsByProblem(Long idProblem);
}
