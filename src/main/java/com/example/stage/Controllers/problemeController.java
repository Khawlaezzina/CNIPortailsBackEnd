package com.example.stage.Controllers;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.probleme;
import com.example.stage.Services.problemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/probleme")
@CrossOrigin("http://localhost:4200")
public class problemeController {

    @Autowired
    private problemeServiceImpl problemeService;

    @Autowired
    public problemeController(problemeServiceImpl problemeService) {
        this.problemeService = problemeService;
    }

    @PostMapping("/add")
    public probleme createProbleme(@Valid @RequestBody probleme probleme) {

        return problemeService.saveProbleme(probleme);
    }

    @GetMapping("/list")
    public List<probleme> getAllProblemes()
    {
        return problemeService.getAll();
    }

    @GetMapping("/{problemeId}")
    public java.util.Optional<probleme> getProbleme(@PathVariable Long problemeId) {

        return  problemeService.findById(problemeId);
    }
    @PutMapping("/{incidentId}")
    public probleme updateProbleme(@PathVariable Long incidentId, @Valid @RequestBody probleme problemeRequest) {
        return problemeService.updateProbleme(incidentId,problemeRequest);
    }

    @DeleteMapping("/{problemeId}")
    public ResponseEntity<?> deleteProbleme(@PathVariable Long problemeId) {
        return problemeService.deleteProbleme(problemeId);
    }
    @GetMapping("/listProblemesByDepartement/{departement}/{statut}")
    public List<probleme> getProblemesByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return problemeService.findProblemeByDepartementAndStatut(departement,statut);
    }
    @GetMapping("/listProblemesByStatut/{statut}")
    public List<probleme> getProblemeByStatut(@PathVariable String statut)
    {
        return problemeService.findProblemeByStatut(statut);
    }
    @GetMapping("listProblemeByDate/{date}")
    public List<probleme> getProblemeByDate(@PathVariable String date)
    {
        return problemeService.findProblemeByDate(date);
    }
    @GetMapping("/listProblemesByUser/{idUser}")
    public List<probleme> getProblemeByUser(@PathVariable Long idUser)
    {
        return problemeService.findProblemeByUser(idUser);
    }
    @GetMapping("/listProblemesByUserAndStatut/{idUser}/{statut}")
    public List<probleme> getProblemeByUserAndStatut(@PathVariable Long idUser,@PathVariable String statut)
    {
        return problemeService.findProblemeByUserAndStatut(idUser, statut);
    }

    @GetMapping("/listProblemeByImpact/{impact}")
    public List<probleme> getProblemeByImpactDegree(@PathVariable String impact)
    {
        return problemeService.findProblemeByImpactDegree(impact);
    }

    @GetMapping("/listProblemeByUrgence/{impact}")
    public List<probleme> getProblemeByUrgenceDegree(@PathVariable String urgence)
    {
        return problemeService.findProblemeByUrgenceDegree(urgence);
    }

    @GetMapping("/listProblemesByApprobateur/{idApprobateur}")
    public List<probleme> getIncidentByApprobateur(@PathVariable Long idApprobateur)
    {
        return problemeService.findProblemeByApprobateur(idApprobateur);
    }

    @GetMapping("/listProblemesByApprobateurAndStatut/{idApprobateur}/{statut}")
    public List<probleme> getProblemeByApprobateurAndStatut(@PathVariable Long idApprobateur,@PathVariable String statut)
    {
        return problemeService.findProblemeByApprobateurAndStatut(idApprobateur, statut);
    }
    @PutMapping("/updatePriority/{idIncident}/{priorite}")
    public probleme upadateProblemePriority(@PathVariable Long idIncident,@PathVariable Long priorite)
    {
        return problemeService.updatePriorite(idIncident,priorite);
    }
    @PutMapping("/updateStatutEnAttente/{idIncident}")
    public probleme updateStatutEnAttente(@PathVariable Long idIncident)
    {
        return problemeService.updateStatutEnAttente(idIncident);
    }

    @PutMapping("/updateStatutResolu/{idIncident}")
    public probleme updateStatutResolu(@PathVariable Long idIncident)
    {
        return problemeService.updateStatutResolu(idIncident);
    }

    @GetMapping("/listProblemeByDepartementAndStatut/{dapartement}/{statut}")
    public List<probleme> findProblemeByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return problemeService.findProblemeByPrioritedecroissanteAndDepartementAndStatut(departement,statut);
    }

    @GetMapping("/listProblemeByMotCle/{motCle}")
    public List<probleme> findProblemeByMotCle(@PathVariable String motCle)
    {
        return problemeService.findProblemeByMotCle(motCle);
    }

    @GetMapping("/listProblemeBySujet/{sujet}")
    public List<probleme> findProblemeBySujet(@PathVariable String sujet)
    {
        return problemeService.findProblemeBySujet(sujet);
    }
    @GetMapping("/listProblemeByCause/{cause}")
    public List<probleme> findProblemeByCause(@PathVariable String cause)
    {
        return problemeService.findProblemeByCause(cause);
    }

    public problemeController() {
    }
}
