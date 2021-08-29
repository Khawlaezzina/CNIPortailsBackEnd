package com.example.stage.Controllers;

import com.example.stage.Entities.*;
import com.example.stage.Services.changementTechnicienImpl;
import com.example.stage.Services.problemeTechnicienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/changementTechnicien")
@CrossOrigin("http://localhost:4200")
public class changementTechnicienController {
    @Autowired
    private changementTechnicienImpl changementTechService;
    @PostMapping("/add")
    public changementTechnicien createServiceTechnicien(@Valid @RequestBody changementTechnicien problemeTechnicien) {
        return changementTechService.saveChangementTechnicienService(problemeTechnicien);
    }

    @GetMapping("/list")
    public List<changementTechnicien> getAllProblemeTechnicien()
    {
        return changementTechService.getAll();
    }

    @GetMapping("/{idProbleme}/{idTechnicien}")
    public changementTechnicien getProblemeTechnicien(@PathVariable Long idProbleme,@PathVariable Long idTechnicien) {

        return  changementTechService.findById(new changementTechnicienId(idProbleme,idTechnicien)).get();
    }

    @GetMapping("/getByIdProblemeAndIdTechnicien/{idProbleme}/{idTechnicien}")
    public changementTechnicien getByIdProblemeAndIdTechnicien(@PathVariable Long idProbleme,@PathVariable Long idTechnicien) {
        return changementTechService.findByIdChangementAndIdTechnicien(idProbleme, idTechnicien).get();
    }
    @GetMapping("/getAllProblemesByTechnicien/{idTechnicien}")
    public List<changement> getAllProblemesByTechnicien(@PathVariable Long idTechnicien) {
        return changementTechService.findAllChangementByTechnicien(idTechnicien);
    }
    @GetMapping("/getAllTechniciensByProbleme/{idProbleme}")
    public List<technicien> getAllTechniciensByProbleme(@PathVariable Long idProbleme) {
        return changementTechService.findAllTechniciensByChangement(idProbleme);
    }

    @DeleteMapping("/{idProbleme}/{idTechnicien}")
    public ResponseEntity<?> deleteProblemeTechnicien(@PathVariable Long idProbleme, @PathVariable Long idTechnicien) {
        return changementTechService.deleteChangementTechnicien(idProbleme,idTechnicien);
    }
    @Autowired
    public changementTechnicienController(changementTechnicienImpl changementTechService) {
        this.changementTechService = changementTechService;
    }
}
