package com.example.stage.Controllers;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import com.example.stage.Entities.CIProbleme;
import com.example.stage.Services.CIChangementServiceImpl;
import com.example.stage.Services.CIProblemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/CIProbleme")
@CrossOrigin("http://localhost:4200")
public class CIProblemeController {

    @Autowired
    private CIProblemeServiceImpl CIProblemeService;

    @Autowired
    public CIProblemeController(CIProblemeServiceImpl CIProblemeService) {
        this.CIProblemeService = CIProblemeService;
    }

    @PostMapping("/add")
    public CIProbleme createCIProbleme(@Valid @RequestBody CIProbleme ticket) {

        return CIProblemeService .saveCIProbleme(ticket);
    }

    @GetMapping("/listCIsByProbleme/{tacheId}")
    public List<CI> getTache(@PathVariable Long tacheId) {

        return  CIProblemeService .getCIsByProbleme(tacheId);
    }
}
