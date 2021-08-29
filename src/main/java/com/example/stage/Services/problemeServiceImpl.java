package com.example.stage.Services;

import com.example.stage.Entities.probleme;
import com.example.stage.Repositories.problemeRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("problemeService")
@Transactional
public class problemeServiceImpl implements problemeService{
    @Autowired
    private final com.example.stage.Repositories.problemeRepository problemeRepository;

    @Override
    public probleme saveProbleme(probleme probleme) {
        return problemeRepository.save(probleme);
    }

    @Override
    public probleme updateProbleme(Long ticketId, probleme problemeRequest) {
        return problemeRepository.findById(ticketId).map(incident -> {
            incident.setTicketStatut(problemeRequest.getTicketStatut());
            incident.setImpact(problemeRequest.getImpact());
            incident.setUrgence(problemeRequest.getUrgence());
            incident.setIdApprobateur(problemeRequest.getIdApprobateur());
            incident.setDescription(problemeRequest.getDescription());
            incident.setSujet(problemeRequest.getSujet());
            incident.setPriorite(problemeRequest.getPriorite());
            incident.setCause(problemeRequest.getCause());
            incident.setMotCle(problemeRequest.getMotCle());
            incident.setSolution(problemeRequest.getSolution());
            incident.setTypeDeSolution(problemeRequest.getTypeDeSolution());
            return problemeRepository.save(incident);
        }).orElseThrow(() -> new ResourceNotFoundException("problemId " + ticketId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteProbleme(Long incidentId) {
        return problemeRepository.findById(incidentId).map(incident -> {
            problemeRepository.delete(incident);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("incidentId " +
                incidentId + " not found"));
    }

    @Override
    public Optional<probleme> findById(Long id) {
        return problemeRepository.findById(id);
    }

    @Override
    public List<probleme> getAll() {
        return problemeRepository.findAll();
    }

    @Override
    public List<probleme> findProblemeByDepartementAndStatut(String departement, String statut) {
        return problemeRepository.findProblemeByDepartementAndStatut(departement, statut);
    }


    @Override
    public List<probleme> findProblemeByStatut(String statut) {
        return problemeRepository.findProblemeByStatut(statut);
    }

    @Override
    public List<probleme> findProblemeByUser(Long idUser) {
        return problemeRepository.findProblemeByUser(idUser);
    }


    @Override
    public List<probleme> findProblemeByUserAndStatut(Long idUser, String statut) {
        return problemeRepository.findProblemeByUserAndStatut(idUser, statut);
    }

    @Override
    public List<probleme> findProblemeByDate(String date) {
        return problemeRepository.findProblemeByDate(date);
    }

    @Override
    public List<probleme> findProblemeByUrgenceDegree(String urgence) {
        return problemeRepository.findProblemeByUrgenceDegree(urgence);
    }

    @Override
    public List<probleme> findProblemeByImpactDegree(String impact) {
        return problemeRepository.findProblemeByImpactDegree(impact);
    }

    @Override
    public List<probleme> findProblemeByApprobateur(Long idApprobateur) {
        return problemeRepository.findProblemeByApprobateur(idApprobateur);
    }

    @Override
    public List<probleme> findProblemeByApprobateurAndStatut(Long idApprobateur, String statut) {
        return problemeRepository.findProblemeByApprobateurAndStatut(idApprobateur, statut);
    }

    @Override
    public probleme updatePriorite(Long idIncident, Long priorite) {
        return problemeRepository.updatePriorite(idIncident, priorite);
    }

    @Override
    public probleme updateStatutEnAttente(Long idIncident) {
        return problemeRepository.updateStatutEnAttente(idIncident);
    }

    @Override
    public probleme updateStatutResolu(Long idIncident) {
        return problemeRepository.updateStatutResolu(idIncident);
    }

    @Override
    public List<probleme> findProblemeByPrioritedecroissanteAndDepartementAndStatut(String departement, String statut) {
        return problemeRepository.findProblemeByPrioritedecroissanteAndDepartementAndStatut(departement, statut);
    }

    @Override
    public List<probleme> findProblemeBySujet(String sujet) {
        return problemeRepository.findProblemeBySujet(sujet);
    }


    @Override
    public List<probleme> findProblemeByCause(String cause) {
        return problemeRepository.findProblemeByCause(cause);
    }

    @Override
    public List<probleme> findProblemeByMotCle(String motCle) {
        return problemeRepository.findProblemeByMotCle(motCle);
    }

    @Autowired
    public problemeServiceImpl(com.example.stage.Repositories.problemeRepository problemeRepository) {
        this.problemeRepository = problemeRepository;
    }
}
