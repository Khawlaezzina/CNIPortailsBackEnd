package com.example.stage.Controllers;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.ticket;
import com.example.stage.Services.CIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/CI")
@CrossOrigin("http://localhost:4200")
public class CIController {

    @Autowired
    private CIServiceImpl ciService;
    @PostMapping("/add")
    public CI createCI(@Valid @RequestBody CI ticket) {

        return ciService.saveCI(ticket);
    }

    @GetMapping("/list")
    public List<CI> getAllCIs()
    {
        return ciService.getAll();
    }

    @GetMapping("/{CIId}")
    public java.util.Optional<CI> getCI(@PathVariable Long CIId) {

        return  ciService.findById(CIId);
    }
    @PutMapping("/{ticketId}")
    public CI updateCI(@PathVariable Long ticketId, @Valid @RequestBody CI ticketRequest) {
        return ciService.updateCI(ticketId,ticketRequest);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long ticketId) {
        return ciService.deleteCI(ticketId);
    }

    @GetMapping("/findAllEmplacement/")
    public List<String> findAllEmplacement()
    {
        return ciService.findAllEmplacement();
    }
    @GetMapping("/findByEmplacement/{emplacement}")
    public List<CI> findByEmplacement(@PathVariable String emplacement)
    {
        return ciService.findByEmplacement(emplacement);
    }
    @GetMapping("/countCIByEmplacement/{emplacement}")
    public int countCIByEmplacement(@PathVariable String emplacement)
    {
        return ciService.countCIByEmplacement(emplacement);
    }

    @GetMapping("/findByEmplacementAndName/{emplacement}/{name}")
    public List<CI> findByEmplacementAndName(@PathVariable String emplacement,@PathVariable String nom)
    {
        return ciService.findByEmplacementAndName(emplacement, nom);
    }
    @GetMapping("/findByEmplacement/{organisation}")
    public List<CI> findByOrganisation(@PathVariable String organisation)
    {
        return ciService.findByOrganisation(organisation);
    }

    public CIController() {
    }
}
