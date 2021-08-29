package com.example.stage.Services;

import com.example.stage.Entities.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface changementTechnicienService {
    public changementTechnicien saveChangementTechnicienService(changementTechnicien problemeTechnicien);


    public ResponseEntity<Object> deleteChangementTechnicien (Long idProbleme, Long idTechnicien);

    public Optional<changementTechnicien> findById(changementTechnicienId ticketId);

    public List<changementTechnicien> getAll();
    Optional<changementTechnicien> findByIdChangementAndIdTechnicien(Long idProbleme,Long idTechnicien);
    List<changement> findAllChangementByTechnicien(Long idTechnicien);
    List<technicien> findAllTechniciensByChangement(Long idProbleme);
}
