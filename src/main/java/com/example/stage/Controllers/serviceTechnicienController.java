package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.*;
import com.example.stage.Services.administrateurServiceImpl;
import com.example.stage.Services.serviceTechnicienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/serviceTechnicien")
@CrossOrigin("http://localhost:4200")
public class serviceTechnicienController {
    @Autowired
    private serviceTechnicienServiceImpl serviceTechService;

    public serviceTechnicienController(serviceTechnicienServiceImpl serviceTechService) {
        this.serviceTechService = serviceTechService;
    }

    @PostMapping("/add")
    public serviceTechnicien createServiceTechnicien(@Valid @RequestBody serviceTechnicien serviceTechnicien) {
       return serviceTechService.saveServiceTechnicienService(serviceTechnicien);
    }

    @GetMapping("/list")
    public List<serviceTechnicien> getAllServiceTechnicien()
    {
        return serviceTechService.getAll();
    }

    @GetMapping("/{idService}/{idTechnicien}")
    public serviceTechnicien getServiceTechnicien(@PathVariable Long idService,@PathVariable Long idTechnicien) {

        return  serviceTechService.findById(new serviceTechnicienId(idService,idTechnicien)).get();
    }

    @GetMapping("/getByIdServiceAndIdTechnicien/{idService}/{idTechnicien}")
    public serviceTechnicien getByIdServiceAndIdTechnicien(@PathVariable Long idService,@PathVariable Long idTechnicien) {
       return serviceTechService.findByIdServiceAndIdTechnicien(idService, idTechnicien).get();
    }
    @GetMapping("/getAllServicesByTechnicien/{idTechnicien}")
    public List<service> getAllServicesByTechnicien(@PathVariable Long idTechnicien) {
        return serviceTechService.findAllServiceByTechnicien(idTechnicien);
    }
    @GetMapping("/getAllTechniciensByService/{idService}")
    public List<technicien> getAllTechniciensByService(@PathVariable Long idService) {
        return serviceTechService.findAllTechniciensByService(idService);
    }

    @DeleteMapping("/{idService}/{idTechnicien}")
    public ResponseEntity<?> deleteServiceTechnicien(@PathVariable Long idService,@PathVariable Long idTechnicien) {
        return serviceTechService.deleteServiceTechnicien(idService,idTechnicien);
    }
}
