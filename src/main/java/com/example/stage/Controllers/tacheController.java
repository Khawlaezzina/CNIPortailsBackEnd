package com.example.stage.Controllers;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.tache;
import com.example.stage.Services.tacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tache")
@CrossOrigin("http://localhost:4200")
public class tacheController {
    @Autowired
    private tacheServiceImpl tacheService;
    @PostMapping("/add")
    public tache createTache(@Valid @RequestBody tache ticket) {

        return tacheService.saveTache(ticket);
    }

    @GetMapping("/list")
    public List<tache> getAllTaches()
    {
        return tacheService.getAll();
    }

    @GetMapping("/{tacheId}")
    public java.util.Optional<tache> getTache(@PathVariable Long tacheId) {

        return  tacheService.findById(tacheId);
    }
    @PutMapping("/{tacheId}")
    public tache updateTache(@PathVariable Long tacheId, @Valid @RequestBody tache ticketRequest) {
        return tacheService.updateTache(tacheId,ticketRequest);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTache(@PathVariable Long ticketId) {
        return tacheService.deleteTache(ticketId);
    }

    @GetMapping("/findTacheByChangement/{idChangement}")
    public List<tache> findTacheByChangement(@PathVariable Long idChangement)
    {
        return tacheService.findtacheByChangement(idChangement);
    }
    @PutMapping("/updateTache/{idChangement}/{numero}")
    public tache updateTache(@PathVariable Long idChangement,@PathVariable int numero)
    {
       return tacheService.updateTache(idChangement, numero);
    }

    @GetMapping("/findNombreDeTache/{idChangement}")
    public int findNombreDeTache(@PathVariable Long idChangement)
    {
        return tacheService.findNombreDeTachePourChangement(idChangement);
    }

}
