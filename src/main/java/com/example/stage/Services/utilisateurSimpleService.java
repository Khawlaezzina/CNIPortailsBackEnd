package com.example.stage.Services;

import com.example.stage.Entities.approbateur;
import com.example.stage.Entities.utilisateurSimple;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface utilisateurSimpleService {

    public utilisateurSimple saveUtilisateurSimple(utilisateurSimple user);

    public utilisateurSimple updateUtilisateurSimple(Long userId,utilisateurSimple user);

    public ResponseEntity<Object> deleteUtilisateurSimple(Long utilisateurSimpleId);

    public Optional<utilisateurSimple> findUtilisateurSimpleByEmail(String email);


    public List<utilisateurSimple> findUtilisateurSimpleByDepartement(String departement);

    public Optional<utilisateurSimple> findById(Long id);

    public List<utilisateurSimple> getAll();
}
