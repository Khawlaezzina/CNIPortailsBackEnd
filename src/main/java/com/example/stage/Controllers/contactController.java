package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.contact;
import com.example.stage.Services.administrateurServiceImpl;
import com.example.stage.Services.contactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin("http://localhost:4200")
public class contactController {
    @Autowired
    private contactServiceImpl adminService;

    @Autowired
    public contactController(contactServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public contact createContact(@Valid @RequestBody contact admin) {

        return adminService.saveContact(admin);
    }

    @GetMapping("/list")
    public List<contact> getAllContact()
    {
        return adminService.getAll();
    }

    @GetMapping("/{adminId}")
    public java.util.Optional<contact> getContact(@PathVariable Long adminId) {

        return  adminService.findById(adminId);
    }
    @PutMapping("/{adminId}")
    public contact updateContact(@PathVariable Long adminId, @Valid @RequestBody contact adminRequest) {
        return adminService.updateContact(adminId,adminRequest);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteContact(@PathVariable Long adminId) {
        return adminService.deleteContact(adminId);
    }
}
