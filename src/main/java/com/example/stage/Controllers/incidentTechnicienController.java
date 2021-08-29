package com.example.stage.Controllers;

import com.example.stage.Entities.*;
import com.example.stage.Services.administrateurServiceImpl;
import com.example.stage.Services.incidentTechnicienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/incidentTechnicien")
@CrossOrigin("http://localhost:4200")
public class incidentTechnicienController {
    @Autowired
    private incidentTechnicienServiceImpl incidentTechService;

    @PostMapping("/add")
    public incidentTechnicien createIncidentTechnicien(@Valid @RequestBody incidentTechnicien incidentTechnicien) {
        return incidentTechService.saveIncidentTechnicienService(incidentTechnicien);
    }

    @GetMapping("/list")
    public List<incidentTechnicien> getAllIncidentTechnicien()
    {
        return incidentTechService.getAll();
    }

    @GetMapping("/{idIncident}/{idTechnicien}")
    public incidentTechnicien getIncidentTechnicien(@PathVariable Long idIncident,@PathVariable Long idTechnicien) {

        return  incidentTechService.findById(new incidentTechnicienId(idIncident,idTechnicien)).get();
    }

    @GetMapping("/getByIdIncidentAndIdTechnicien/{idIncident}/{idTechnicien}")
    public incidentTechnicien getByIdIncidentAndIdTechnicien(@PathVariable Long idIncident,@PathVariable Long idTechnicien) {
        return incidentTechService.findByIdIncidentAndIdTechnicien(idIncident, idTechnicien).get();
    }
    @GetMapping("/getAllIncidentsByTechnicien/{idTechnicien}")
    public List<incident> getAllIncidentsByTechnicien(@PathVariable Long idTechnicien) {
        return incidentTechService.findAllIncidentByTechnicien(idTechnicien);
    }
    @GetMapping("/getAllTechniciensByIncident/{idIncident}")
    public List<technicien> getAllTechniciensByIncident(@PathVariable Long idIncident) {
        return incidentTechService.findAllTechniciensByIncident(idIncident);
    }

    @DeleteMapping("/{idIncident}/{idTechnicien}")
    public ResponseEntity<?> deleteIncidentTechnicien(@PathVariable Long idIncident, @PathVariable Long idTechnicien) {
        return incidentTechService.deleteIncidentTechnicien(idIncident,idTechnicien);
    }

    public incidentTechnicienController(incidentTechnicienServiceImpl incidentTechService) {
        this.incidentTechService = incidentTechService;
    }
}
