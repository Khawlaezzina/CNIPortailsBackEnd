package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Repositories.incidentRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("CIService")
@Transactional
public class CIServiceImpl implements CIService{
    @Autowired
    private com.example.stage.Repositories.CIRepository CIRepository;
    @Override
    public CI saveCI(CI CI) {
        return CIRepository.save(CI);
    }

    @Override
    public CI updateCI(Long CIId, CI CIRequest) {
        return CIRepository.findById(CIId).map(ticket -> {
            ticket.setNom(CIRequest.getNom());
            ticket.setEmplacement(CIRequest.getEmplacement());
            ticket.setStatut(CIRequest.getStatut());
            ticket.setCriticite(CIRequest.getCriticite());
            ticket.setDescription(CIRequest.getDescription());
            ticket.setOrganisation(CIRequest.getOrganisation());
            return CIRepository.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " + CIId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteCI(Long CIId) {
        return CIRepository.findById(CIId).map(incident -> {
            CIRepository.delete(incident);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("incidentId " +
                    CIId + " not found"));
    }

    @Override
    public Optional<CI> findById(Long id) {
        return CIRepository.findById(id);
    }

    @Override
    public List<CI> getAll() {
        return CIRepository.findAll();
    }

    @Override
    public List<String> findAllEmplacement() {
        return CIRepository.findAllEmplacement();
    }

    @Override
    public List<CI> findByEmplacement(String emplacement) {
        return CIRepository.findByEmplacement(emplacement);
    }

    @Override
    public int countCIByEmplacement(String emplacement) {
        return CIRepository.countCIByEmplacement(emplacement);
    }

    @Override
    public List<CI> findByEmplacementAndName(String emplacement, String nom) {
        return CIRepository.findByEmplacementAndName(emplacement, nom);
    }

    @Override
    public List<CI> findByOrganisation(String organisation) {
        return CIRepository.findByOrganisation(organisation);
    }
}
