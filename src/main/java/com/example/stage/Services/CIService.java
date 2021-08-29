package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.incident;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CIService {

    public CI saveCI(CI CI);

    public CI updateCI(Long CIid,CI CI);

    public ResponseEntity<Object> deleteCI (Long CIId);

    public Optional<CI> findById(Long id);

    public List<CI> getAll();
    List<String> findAllEmplacement();

    List<CI> findByEmplacement(String emplacement);

    int countCIByEmplacement(String emplacement);
    List<CI> findByEmplacementAndName(String emplacement,String nom);
    List<CI> findByOrganisation(String organisation);
}
