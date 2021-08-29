package com.example.stage.Services;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.probleme;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface problemeService {
    public probleme saveProbleme(probleme probleme);

    public probleme updateProbleme(Long ticketId,probleme probleme);

    public ResponseEntity<Object> deleteProbleme (Long problemeId);

    public Optional<probleme> findById(Long id);

    public List<probleme> getAll();
    public  List<probleme> findProblemeByDepartementAndStatut(String departement, String statut);
    public List<probleme> findProblemeByStatut(String statut);
    public List<probleme>  findProblemeByUser(Long idUser);
    public List<probleme> findProblemeByUserAndStatut(Long idUser, String statut);
    public List<probleme> findProblemeByDate(String date);
    public List<probleme> findProblemeByUrgenceDegree(String urgence);
    public List<probleme> findProblemeByImpactDegree(String impact);
    public List<probleme>  findProblemeByApprobateur(Long idApprobateur);
    public List<probleme> findProblemeByApprobateurAndStatut(Long idApprobateur, String statut);
    public probleme updatePriorite(Long idProbleme,Long priorite);
    public probleme updateStatutEnAttente(Long idProbleme);
    public  probleme updateStatutResolu(Long idProbleme);

    public List<probleme> findProblemeByPrioritedecroissanteAndDepartementAndStatut(String departement,String statut);
    public List<probleme> findProblemeBySujet(String sujet);

    public List<probleme> findProblemeByCause(String cause);
    public List<probleme> findProblemeByMotCle(String motCle);
}
