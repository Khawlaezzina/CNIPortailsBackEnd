package com.example.stage.Services;

import com.example.stage.Entities.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface problemeTechnicienService {
    public problemeTechnicien saveProblemeTechnicienService(problemeTechnicien problemeTechnicien);


    public ResponseEntity<Object> deleteProblemeTechnicien (Long idProbleme, Long idTechnicien);

    public Optional<problemeTechnicien> findById(problemeTechnicienId ticketId);

    public List<problemeTechnicien> getAll();
    Optional<problemeTechnicien> findByIdProblemeAndIdTechnicien(Long idProbleme,Long idTechnicien);
    List<probleme> findAllProblemeByTechnicien(Long idTechnicien);
    List<technicien> findAllTechniciensByProbleme(Long idProbleme);
}
