package com.example.stage.Services;


import com.example.stage.Entities.technicien;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface technicienService {

    public technicien saveTechnicien(technicien technicien);

    public technicien updateTechnicien(Long technicienId,technicien admin);

    public ResponseEntity<Object> deleteTechnicien(Long technicienId);

    public Optional<technicien> findTechnicienByEmail(String email);


    public List<technicien> findTechnicienByDepartement(String departement);

    public Optional<technicien> findById(Long id);

    public List<technicien> getAll();

}
