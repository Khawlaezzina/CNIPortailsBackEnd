package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface administrateurService {

    public administrateur saveAdministrateur(administrateur admin);

    public administrateur updateAdministrateur(Long adminId,administrateur admin);

    public ResponseEntity<Object> deleteAdministrateur(Long adminId);

    public Optional<administrateur> findAdministrateurByEmail(String email);


    public List<administrateur> findAdministrateurByDepartement(String departement);

    public Optional<administrateur> findById(Long id);

    public List<administrateur> getAll();


}
