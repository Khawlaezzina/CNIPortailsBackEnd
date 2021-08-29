package com.example.stage.Controllers;

import com.example.stage.Entities.*;
import com.example.stage.Services.administrateurServiceImpl;
import com.example.stage.Services.problemeTechnicienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/problemeTechnicien")
@CrossOrigin("http://localhost:4200")
public class problemeTechnicienController {
    @Autowired
    private problemeTechnicienServiceImpl problemeTechService;

    @PostMapping("/add")
    public problemeTechnicien createServiceTechnicien(@Valid @RequestBody problemeTechnicien problemeTechnicien) {
        return problemeTechService.saveProblemeTechnicienService(problemeTechnicien);
    }

    @GetMapping("/list")
    public List<problemeTechnicien> getAllProblemeTechnicien()
    {
        return problemeTechService.getAll();
    }

    @GetMapping("/{idProbleme}/{idTechnicien}")
    public problemeTechnicien getProblemeTechnicien(@PathVariable Long idProbleme,@PathVariable Long idTechnicien) {

        return  problemeTechService.findById(new problemeTechnicienId(idProbleme,idTechnicien)).get();
    }

    @GetMapping("/getByIdProblemeAndIdTechnicien/{idProbleme}/{idTechnicien}")
    public problemeTechnicien getByIdProblemeAndIdTechnicien(@PathVariable Long idProbleme,@PathVariable Long idTechnicien) {
        return problemeTechService.findByIdProblemeAndIdTechnicien(idProbleme, idTechnicien).get();
    }
    @GetMapping("/getAllProblemesByTechnicien/{idTechnicien}")
    public List<probleme> getAllProblemesByTechnicien(@PathVariable Long idTechnicien) {
        return problemeTechService.findAllProblemeByTechnicien(idTechnicien);
    }
    @GetMapping("/getAllTechniciensByProbleme/{idProbleme}")
    public List<technicien> getAllTechniciensByProbleme(@PathVariable Long idProbleme) {
        return problemeTechService.findAllTechniciensByProbleme(idProbleme);
    }

    @DeleteMapping("/{idProbleme}/{idTechnicien}")
    public ResponseEntity<?> deleteProblemeTechnicien(@PathVariable Long idProbleme, @PathVariable Long idTechnicien) {
        return problemeTechService.deleteProblemeTechnicien(idProbleme,idTechnicien);
    }

    @Autowired
    public problemeTechnicienController(problemeTechnicienServiceImpl problemeTechService) {
        this.problemeTechService = problemeTechService;
    }
}
