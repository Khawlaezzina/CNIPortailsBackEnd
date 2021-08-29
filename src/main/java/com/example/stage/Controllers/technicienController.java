package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.technicien;
import com.example.stage.Services.administrateurServiceImpl;
import com.example.stage.Services.technicienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/technicien")
@CrossOrigin(origins="http://localhost:4200")
public class technicienController {

    @Autowired
    private technicienServiceImpl adminService;

    @PostMapping("/add")
    public technicien createTechnicien(@Valid @RequestBody technicien admin) {
        admin.setPassword(AES.encrypt(admin.getPassword(),AES.getPersonalkey()));
        return adminService.saveTechnicien(admin);
    }

    @GetMapping("/list")
    public List<technicien> getAllTechniciens()
    {
        return adminService.getAll();
    }

    @GetMapping("/{adminId}")
    public java.util.Optional<technicien> getTechnicien(@PathVariable Long adminId) {

        return  adminService.findById(adminId);
    }
    @GetMapping("listTechniciensByDepartement/{departement}")
    public List<technicien> getTechnicienByDepartement(@PathVariable String departement) {

        return  adminService.findTechnicienByDepartement(departement);
    }
    @GetMapping("/getTechnicienByEmail/{adminEmail}")
    public technicien getTechnicienByEmail(@PathVariable String adminEmail) {
        technicien admin = adminService.findTechnicienByEmail(adminEmail).get();
        admin.setPassword(AES.decrypt(admin.getPassword(),AES.getPersonalkey()));
        return admin;
    }

    @PutMapping("/{adminId}")
    public technicien updateTechnicien(@PathVariable Long adminId, @Valid @RequestBody technicien adminRequest) {
        return adminService.updateTechnicien(adminId,adminRequest);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteTechnicien(@PathVariable Long adminId) {
        return adminService.deleteTechnicien(adminId);
    }

    public technicienController(technicienServiceImpl adminService) {
        this.adminService = adminService;
    }
}
