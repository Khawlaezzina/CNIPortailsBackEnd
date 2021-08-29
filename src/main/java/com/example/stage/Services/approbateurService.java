package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.approbateur;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface approbateurService {

    public approbateur saveApprobateur(approbateur approbateur);

    public approbateur updateApprobateur(Long approbateurId,approbateur approbateur);

    public ResponseEntity<Object> deleteApprobateur(Long approbateurId);

    public Optional<approbateur> findApprobateurByEmail(String email);


    public List<approbateur> findApprobateurByDepartement(String departement);

    public Optional<approbateur> findById(Long id);

    public List<approbateur> getAll();
}
