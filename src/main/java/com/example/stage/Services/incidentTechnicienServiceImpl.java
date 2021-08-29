package com.example.stage.Services;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.incidentTechnicien;
import com.example.stage.Entities.incidentTechnicienId;
import com.example.stage.Entities.technicien;
import com.example.stage.Repositories.incidentRepository;
import com.example.stage.Repositories.incidentTechnicienRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("incidentTechnicienService")
@Transactional
public class incidentTechnicienServiceImpl implements incidentTechnicienService{
    @Autowired
    private com.example.stage.Repositories.incidentTechnicienRepository incidentTechRepository;
    @Override
    public incidentTechnicien saveIncidentTechnicienService(incidentTechnicien incidentTechnicien) {
        return incidentTechRepository.save(incidentTechnicien);
    }


    @Override
    public ResponseEntity<Object> deleteIncidentTechnicien(Long idIncident, Long idTechnicien) {
        return incidentTechRepository.findById(new incidentTechnicienId(idIncident,idTechnicien)).map(certified->{
            incidentTechRepository.delete(certified);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Erreur ce lien nexiste pas"));
    }

    @Override
    public Optional<incidentTechnicien> findById(incidentTechnicienId ticketId) {
        return incidentTechRepository.findById(ticketId);
    }

    @Override
    public List<incidentTechnicien> getAll() {
        return incidentTechRepository.findAll();
    }

    @Override
    public Optional<incidentTechnicien> findByIdIncidentAndIdTechnicien(Long idIncident, Long idTechnicien) {
        return incidentTechRepository.findByIdIncidentAndIdTechnicien(idIncident,idTechnicien);
    }

    @Override
    public List<incident> findAllIncidentByTechnicien(Long idTechnicien) {
        return incidentTechRepository.findAllIncidentByTechnicien(idTechnicien);
    }

    @Override
    public List<technicien> findAllTechniciensByIncident(Long idIncident) {
        return incidentTechRepository.findAllTechniciensByIncident(idIncident);
    }

    public incidentTechnicienServiceImpl(incidentTechnicienRepository incidentTechRepository) {
        this.incidentTechRepository = incidentTechRepository;
    }
}
