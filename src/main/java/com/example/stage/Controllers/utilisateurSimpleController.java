package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.utilisateurSimple;
import com.example.stage.Services.utilisateurSimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/UtilisateurSimple")
@CrossOrigin(origins = "http://localhost:4200")
public class utilisateurSimpleController {

    @Autowired
    private utilisateurSimpleServiceImpl userService;

    @PostMapping("/add")
    public utilisateurSimple createUtilisateurSimple(@Valid @RequestBody utilisateurSimple user) {
        user.setPassword(AES.encrypt(user.getPassword(),AES.getPersonalkey()));
        return userService.saveUtilisateurSimple(user);
    }

    @GetMapping("/list")
    public List<utilisateurSimple> getAllUsers()
    {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public java.util.Optional<utilisateurSimple> getUser(@PathVariable Long userId) {

        return  userService.findById(userId);
    }

    @GetMapping("/getUserByEmail/{userEmail}")
    public utilisateurSimple getUserByEmail(@PathVariable String userEmail) {
        utilisateurSimple admin = userService.findUtilisateurSimpleByEmail(userEmail).get();
        admin.setPassword(AES.decrypt(admin.getPassword(),AES.getPersonalkey()));
        return admin;
    }

    @PutMapping("/{userId}")
    public utilisateurSimple updateUser(@PathVariable Long userId, @Valid @RequestBody utilisateurSimple adminRequest) {
        return userService.updateUtilisateurSimple(userId,adminRequest);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUtilisateurSimple(userId);
    }

    public utilisateurSimpleController() {
    }
}
