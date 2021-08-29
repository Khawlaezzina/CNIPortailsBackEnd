package com.example.stage.Repositories;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface problemeRepository extends JpaRepository<probleme,Long> {

    @Query("SELECT p from probleme p WHERE p.ticketStatut=?2 and p.idUtilisateur in (select user.id from utilisateurSimple user where user.departement=?1 )")
    List<probleme> findProblemeByDepartementAndStatut(String departement, String statut);

    @Query("SELECT probleme from probleme probleme WHERE probleme.ticketStatut=?1 order by probleme.priorite desc ")
    List<probleme> findProblemeByStatut(String statut);

    @Query("SELECT probleme from probleme probleme WHERE probleme.idUtilisateur=?1")
    List<probleme>  findProblemeByUser(Long idUser);

    @Query("SELECT probleme from probleme probleme WHERE probleme.idUtilisateur=?1 and probleme.ticketStatut=?2 order by probleme.priorite desc ")
    List<probleme> findProblemeByUserAndStatut(Long idUser, String statut);

    @Query("SELECT probleme from probleme probleme where probleme.dateOuverture=?1")
    List<probleme> findProblemeByDate(String date);

    @Query("SELECT probleme from probleme probleme where probleme.urgence=?1")
    List<probleme> findProblemeByUrgenceDegree(String urgence);

    @Query("SELECT probleme from probleme probleme where probleme.impact=?1")
    List<probleme> findProblemeByImpactDegree(String impact);

    @Query("SELECT probleme from probleme probleme WHERE probleme.idApprobateur=?1")
    List<probleme>  findProblemeByApprobateur(Long idApprobateur);

    @Query("SELECT probleme from probleme probleme WHERE probleme.idApprobateur=?1 and probleme.ticketStatut=?2 ")
    List<probleme> findProblemeByApprobateurAndStatut(Long idApprobateur, String statut);

    @Query("UPDATE probleme SET priorite=?2 WHERE id=?1")
    probleme updatePriorite(Long idIncident,Long priorite);

    @Query("UPDATE probleme SET ticketStatut='EN ATTENTE' WHERE id=?1 AND idApprobateur is NOT null")
    probleme updateStatutEnAttente(Long idProbleme);

    @Query("UPDATE probleme SET ticketStatut='Resolu' WHERE id=?1 AND solution is NOT null AND typeDeSolution is not null")
    probleme updateStatutResolu(Long idIncident);

    @Query("select p from probleme p")
    List<probleme> findProblemeByPrioritedecroissanteAndDepartementAndStatut(String departement,String statut);

    @Query("SELECT probleme from probleme probleme where probleme.motCle like ?1 and probleme.ticketStatut='CLOS'")
    List<probleme> findProblemeByMotCle(String motCle);

    @Query("SELECT probleme from probleme probleme where probleme.sujet like ?1 and probleme.ticketStatut='CLOS' ")
    List<probleme> findProblemeBySujet(String sujet);



    @Query("SELECT p from probleme p where p.cause like ?1 and p.ticketStatut='CLOS'")
    List<probleme> findProblemeByCause(String cause);
    @Query("SELECT count(p) from probleme p")
    public int countProblems();
}
