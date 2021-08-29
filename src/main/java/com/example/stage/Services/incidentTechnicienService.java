package com.example.stage.Services;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.incidentTechnicien;
import com.example.stage.Entities.incidentTechnicienId;
import com.example.stage.Entities.technicien;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface incidentTechnicienService {
    public incidentTechnicien saveIncidentTechnicienService(incidentTechnicien incidentTechnicien);


    public ResponseEntity<Object> deleteIncidentTechnicien (Long idIncident, Long idTechnicien);

    public Optional<incidentTechnicien> findById(incidentTechnicienId ticketId);

    public List<incidentTechnicien> getAll();
    Optional<incidentTechnicien> findByIdIncidentAndIdTechnicien(Long idIncident,Long idTechnicien);
    List<incident> findAllIncidentByTechnicien(Long idTechnicien);
    List<technicien> findAllTechniciensByIncident(Long idIncident);
}
