package com.example.stage.Services;

import com.example.stage.Entities.changement;
import com.example.stage.Repositories.changementRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service("changementService")
@Transactional
public class changementServiceImpl implements changementService{
    @Autowired
    private final changementRepository changementRepository;
    @Autowired
    public changementServiceImpl(com.example.stage.Repositories.changementRepository changementRepository) {
        this.changementRepository = changementRepository;
    }

    @Override
    public changement saveChangement(changement changement) {
        return changementRepository.save(changement);
    }

    @Override
    public changement updateChangement(Long ticketId, changement changementRequest) {
        return changementRepository.findById(ticketId).map(incident -> {
            incident.setStatut(changementRequest.getStatut());
            incident.setDateFin(changementRequest.getDateFin());
            incident.setType(changementRequest.getType());

            return changementRepository.save(incident);
        }).orElseThrow(() -> new ResourceNotFoundException("problemId " + ticketId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteChangement(Long problemeId) {
        return changementRepository.findById(problemeId).map(incident -> {
            changementRepository.delete(incident);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("incidentId " +
                problemeId + " not found"));
    }

    @Override
    public Optional<changement> findById(Long id) {
        return changementRepository.findById(id);
    }

    @Override
    public List<changement> getAll() {
        return changementRepository.findAll();
    }

    @Override
    public List<changement> getChangementByStatut(String statut) {
        return changementRepository.getChangementByStatut(statut);
    }
}
