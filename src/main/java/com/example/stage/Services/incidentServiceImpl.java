package com.example.stage.Services;

import com.example.stage.Entities.incident;
import com.example.stage.Repositories.incidentRepository;
import com.example.stage.Repositories.ticketRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("incidentService")
@Transactional
public class incidentServiceImpl implements incidentService{
    @Autowired
    private incidentRepository incidentRepository;

    @Override
    public incident saveIncident(incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public incident updateIncident(Long ticketId, incident incidentRequest) {
        return incidentRepository.findById(ticketId).map(incident -> {
            incident.setTicketStatut(incidentRequest.getTicketStatut());
            incident.setImpact(incidentRequest.getImpact());
            incident.setUrgence(incidentRequest.getUrgence());
            incident.setIdApprobateur(incidentRequest.getIdApprobateur());
            incident.setDescription(incidentRequest.getDescription());
            incident.setSujet(incidentRequest.getSujet());
            incident.setPriorite(incidentRequest.getPriorite());
            incident.setCause(incidentRequest.getCause());
            incident.setMotCle(incidentRequest.getMotCle());
            incident.setSolution(incidentRequest.getSolution());
            incident.setTypeDeSolution(incidentRequest.getTypeDeSolution());
            return incidentRepository.save(incident);
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " + ticketId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteIncident(Long incidentId) {
        return incidentRepository.findById(incidentId).map(incident -> {
            incidentRepository.delete(incident);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("incidentId " +
                incidentId + " not found"));
    }

    @Override
    public Optional<incident> findById(Long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public List<incident> getAll() {
        return incidentRepository.findAll();
    }

    @Override
    public List<incident> findIncidentByDepartementAndStatut(String departement, String statut) {
        return incidentRepository.findIncidentByDepartementAndStatut(departement, statut);
    }

    @Override
    public List<incident> findIncidentByStatut(String statut) {
        return incidentRepository.findIncidentByStatut(statut);
    }

    @Override
    public List<incident> findIncidentByUser(Long idUser) {
        return incidentRepository.findIncidentByUser(idUser);
    }

    @Override
    public List<incident> findIncidentByUserAndStatut(Long idUser, String statut) {
        return incidentRepository.findIncidentByUserAndStatut(idUser, statut);
    }

    @Override
    public List<incident> findIncidentByDate(String date) {
        return incidentRepository.findIncidentByDate(date);
    }

    @Override
    public List<incident> findIncidentByUrgenceDegree(String urgence) {
        return incidentRepository.findIncidentByUrgenceDegree(urgence);
    }

    @Override
    public List<incident> findIncidentByImpactDegree(String impact) {
        return incidentRepository.findIncidentByImpactDegree(impact);
    }

    @Override
    public List<incident> findIncidentByApprobateur(Long idApprobateur) {
        return incidentRepository.findIncidentByApprobateur(idApprobateur);
    }

    @Override
    public List<incident> findIncidentByApprobateurAndStatut(Long idApprobateur, String statut) {
        return incidentRepository.findIncidentByApprobateurAndStatut(idApprobateur, statut);
    }

    @Override
    public incident updatePriorite(Long idIncident, Long priorite) {
        return incidentRepository.updatePriorite(idIncident, priorite);
    }



    @Override
    public List<incident> findIncidentByPrioritedecroissanteAndDepartementAndStatut(String departement,String statut) {
        return incidentRepository.findIncidentByPrioritedecroissanteAndDepartementAndStatut(departement,statut);
    }

    @Override
    public List<incident> findIncidentBySujet(String sujet) {
        return incidentRepository.findIncidentBySujet(sujet);
    }

    @Override
    public List<incident> findIncidentByDescription(String description) {
        return incidentRepository.findIncidentByDescription(description);
    }

    @Override
    public List<incident> findIncidentByCause(String cause,String statut) {
        return incidentRepository.findIncidentByCause(cause,statut);
    }

    @Override
    public List<incident> findIncidentByMotCle(String motCle,String statut) {
        return incidentRepository.findIncidentByMotCle(motCle,statut);
    }

    @Override
    public incident updateIdProbleme(Long idProbleme, Long idIncident) {
        return incidentRepository.updateIdProbleme(idProbleme, idIncident);
    }

    @Override
    public List<incident> findIncidentsByProbleme(Long idProbleme) {
        return incidentRepository.findIncidentsByProbleme(idProbleme);
    }

    @Override
    public List<incident> getIncidentsByProblem(Long idProblem) {
        return incidentRepository.getIncidentsByProblem(idProblem);
    }
}
