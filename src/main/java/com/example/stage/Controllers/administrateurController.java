package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.administrateur;
import com.example.stage.Services.administrateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/administrateur")
@CrossOrigin("http://localhost:4200")
public class administrateurController {

    @Autowired
    private administrateurServiceImpl adminService;

    @PostMapping("/add")
    public administrateur createAdmin(@Valid @RequestBody administrateur admin) {
        admin.setPassword(AES.encrypt(admin.getPassword(),AES.getPersonalkey()));
        return adminService.saveAdministrateur(admin);
    }

    @GetMapping("/list")
    public List<administrateur> getAllAdmins()
    {
        return adminService.getAll();
    }

    @GetMapping("/{adminId}")
    public java.util.Optional<administrateur> getAdministrateur(@PathVariable Long adminId) {

        return  adminService.findById(adminId);
    }

    @GetMapping("/getAdminByEmail/{adminEmail}")
    public administrateur getAdminByEmail(@PathVariable String adminEmail) {
        administrateur admin = adminService.findAdministrateurByEmail(adminEmail).get();
        admin.setPassword(AES.decrypt(admin.getPassword(),AES.getPersonalkey()));
        return admin;
    }

    @PutMapping("/{adminId}")
    public administrateur updateAdmin(@PathVariable Long adminId, @Valid @RequestBody administrateur adminRequest) {
        return adminService.updateAdministrateur(adminId,adminRequest);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long adminId) {
        return adminService.deleteAdministrateur(adminId);
    }

    public administrateurController(administrateurServiceImpl adminService) {
        this.adminService = adminService;
    }
}
