package com.example.stage.Controllers;

import com.example.stage.Entities.changement;
import com.example.stage.Entities.service;
import com.example.stage.Services.changementServiceImpl;
import com.example.stage.Services.serviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/changement")
@CrossOrigin(value = "http://localhost:4200")
public class changementController {
    @Autowired
    private changementServiceImpl changementService;

    @Autowired
    public changementController(changementServiceImpl changementService) {
        this.changementService = changementService;
    }
    @PostMapping("/add")
    public changement createService(@Valid @RequestBody changement changement) {

        return changementService.saveChangement(changement);
    }

    @GetMapping("/list")
    public List<changement> getAllServices()
    {
        return changementService.getAll();
    }

    @GetMapping("/listByStatut/{statut}")
    public List<changement> getServices(@PathVariable String statut)
    {
        return changementService.getChangementByStatut(statut);
    }

    @GetMapping("/{ticketId}")
    public java.util.Optional<changement> getTicket(@PathVariable Long ticketId) {

        return  changementService.findById(ticketId);
    }
    @PutMapping("/{ticketId}")
    public changement updateService(@PathVariable Long ticketId, @Valid @RequestBody changement ticketRequest) {
        return changementService.updateChangement(ticketId,ticketRequest);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteService(@PathVariable Long ticketId) {
        return changementService.deleteChangement(ticketId);
    }
}
