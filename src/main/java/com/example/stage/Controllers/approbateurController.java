package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;

import com.example.stage.Entities.approbateur;
import com.example.stage.Services.approbateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/approbateur")
@CrossOrigin("http://localhost:4200")
public class approbateurController {
    @Autowired
    private approbateurServiceImpl approbateurService;

    @PostMapping("/add")
    public approbateur createApprobateur(@Valid @RequestBody approbateur approbateur) {
        approbateur.setPassword(AES.encrypt(approbateur.getPassword(),AES.getPersonalkey()));
        return approbateurService.saveApprobateur(approbateur);
    }

    @GetMapping("/list")
    public List<approbateur> getAllApprobateurs()
    {
        return approbateurService.getAll();
    }

    @GetMapping("/{approbateurId}")
    public java.util.Optional<approbateur> getApprobateur(@PathVariable Long approbateurId) {

        return  approbateurService.findById(approbateurId);
    }

    @GetMapping("/getApprobateurByEmail/{approbateurEmail}")
    public approbateur getApprobateurByEmail(@PathVariable String approbateurEmail) {
        approbateur approbateur = approbateurService.findApprobateurByEmail(approbateurEmail).get();
        approbateur.setPassword(AES.decrypt(approbateur.getPassword(),AES.getPersonalkey()));
        return approbateur;
    }

    @PutMapping("/{approbateurId}")
    public approbateur updateApprobateur(@PathVariable Long approbateurId, @Valid @RequestBody approbateur approbateurRequest) {
        return approbateurService.updateApprobateur(approbateurId,approbateurRequest);
    }


    @DeleteMapping("/{approbateurId}")
    public ResponseEntity<?> deleteApprobateur(@PathVariable Long approbateurId) {
        return approbateurService.deleteApprobateur(approbateurId);
    }

    public approbateurController() {
    }
}
