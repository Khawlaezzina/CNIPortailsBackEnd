package com.example.stage.Controllers;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.ticket;
import com.example.stage.Services.incidentServiceImpl;
import com.example.stage.Services.ticketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/incident")
@CrossOrigin(origins="http://localhost:4200")
public class incidentController {
    @Autowired
    private incidentServiceImpl incidentService;

    @PostMapping("/add")
    public incident createIncident(@Valid @RequestBody incident incident) {

        return incidentService.saveIncident(incident);
    }

    @GetMapping("/list")
    public List<incident> getAllIncidents()
    {
        return incidentService.getAll();
    }

    @GetMapping("/{incidentId}")
    public java.util.Optional<incident> getIncident(@PathVariable Long incidentId) {

        return  incidentService.findById(incidentId);
    }
    @PutMapping("/{incidentId}")
    public incident updateIncident(@PathVariable Long incidentId, @Valid @RequestBody incident incidentRequest) {
        return incidentService.updateIncident(incidentId,incidentRequest);
    }

    @DeleteMapping("/{incidentId}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long incidentId) {
        return incidentService.deleteIncident(incidentId);
    }
    @GetMapping("/listIncidentsByDepartement/{departement}/{statut}")
    public List<incident> getIncidentsByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return incidentService.findIncidentByDepartementAndStatut(departement,statut);
    }
    @GetMapping("/listIncidentsByStatut/{statut}")
    public List<incident> getIncidentByStatut(@PathVariable String statut)
    {
        return incidentService.findIncidentByStatut(statut);
    }
    @GetMapping("listIncidentsByDate/{date}")
    public List<incident> getIncidentByDate(@PathVariable String date)
    {
        return incidentService.findIncidentByDate(date);
    }
    @GetMapping("/listIncidentsByUser/{idUser}")
    public List<incident> getIncidentByUser(@PathVariable Long idUser)
    {
        return incidentService.findIncidentByUser(idUser);
    }
    @GetMapping("/listIncidentsByProblem/{idUser}")
    public List<incident> getIncidentByProblem(@PathVariable Long idUser)
    {
        return incidentService.findIncidentsByProbleme(idUser);
    }
    @GetMapping("/listIncidentsByUserAndStatut/{idUser}/{statut}")
    public List<incident> getIncidentByUserAndStatut(@PathVariable Long idUser,@PathVariable String statut)
    {
        return incidentService.findIncidentByUserAndStatut(idUser, statut);
    }

    @GetMapping("/listIncidentByImpact/{impact}")
    public List<incident> getIncidentByImpactDegree(@PathVariable String impact)
    {
        return incidentService.findIncidentByImpactDegree(impact);
    }

    @GetMapping("/listIncidentByUrgence/{impact}")
    public List<incident> getIncidentByUrgenceDegree(@PathVariable String urgence)
    {
        return incidentService.findIncidentByUrgenceDegree(urgence);
    }

    @GetMapping("/listIncidentsByApprobateur/{idApprobateur}")
    public List<incident> getIncidentByApprobateur(@PathVariable Long idApprobateur)
    {
        return incidentService.findIncidentByApprobateur(idApprobateur);
    }

    @GetMapping("/listIncidentsByApprobateurAndStatut/{idApprobateur}/{statut}")
    public List<incident> getIncidentByApprobateurAndStatut(@PathVariable Long idApprobateur,@PathVariable String statut)
    {
        return incidentService.findIncidentByApprobateurAndStatut(idApprobateur, statut);
    }
    @PutMapping("/updatePriority/{idIncident}/{priorite}")
    public incident updateIncidentPriority(@PathVariable Long idIncident,@PathVariable Long priorite)
    {
        return incidentService.updatePriorite(idIncident,priorite);
    }

    @GetMapping("/listIncidentByDepartementAndStatut/{departement}/{statut}")
    public List<incident> findIncidentByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return incidentService.findIncidentByPrioritedecroissanteAndDepartementAndStatut(departement,statut);
    }

    @GetMapping("/listIncidentByMotCle/{motCle}/{statut}")
    public List<incident> findIncidentByMotCle(@PathVariable String motCle,@PathVariable String statut)
    {
        return incidentService.findIncidentByMotCle("%"+motCle,statut);
    }
    @GetMapping("/listIncidentByDescription/{description}")
    public List<incident> findIncidentByDescription(@PathVariable String description)
    {
        return incidentService.findIncidentByDescription(description);
    }
    @GetMapping("/listIncidentBySujet/{sujet}")
    public List<incident> findIncidentBySujet(@PathVariable String sujet)
    {
        return incidentService.findIncidentBySujet(sujet);
    }
    @GetMapping("/listIncidentByCause/{cause}/{statut}")
    public List<incident> findIncidentByCause(@PathVariable String cause,@PathVariable String statut)
    {
        return incidentService.findIncidentByCause("%"+cause,statut);
    }
    @PutMapping("/updateIdProbleme/{idIncident}/{idProbleme}")
    public incident updateIdProbleme(@PathVariable Long idIncident,@PathVariable Long idProbleme)
    {
        return incidentService.updateIdProbleme(idProbleme, idIncident);
    }
    @GetMapping("listIncidentByProbleme/{idProbleme}")
    public List<incident> findIncidentsByProbleme(@PathVariable Long idProbleme)
    {
        return incidentService.findIncidentsByProbleme(idProbleme);
    }
}
