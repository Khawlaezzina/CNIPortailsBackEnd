package com.example.stage.Controllers;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import com.example.stage.Entities.tache;
import com.example.stage.Services.CIChangementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/CIChangement")
@CrossOrigin("http://localhost:4200")
public class CIChangementController {

    @Autowired
    private CIChangementServiceImpl CIChangementService;

    @Autowired
    public CIChangementController(CIChangementServiceImpl CIChangementService) {
        this.CIChangementService = CIChangementService;
    }

    @PostMapping("/add")
    public CIChangement createCIChangement(@Valid @RequestBody CIChangement ticket) {

        return CIChangementService.saveCIChangement(ticket);
    }

    @GetMapping("/listCIsByChangement/{tacheId}")
    public List<CI> getTache(@PathVariable Long tacheId) {

        return  CIChangementService.getCIsByChangement(tacheId);
    }
}
