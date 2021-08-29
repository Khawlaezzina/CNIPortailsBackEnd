package com.example.stage.Services;

import com.example.stage.Entities.tache;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("tacheService")
@Transactional
public class tacheServiceImpl implements tacheService{
    @Autowired
    private com.example.stage.Repositories.tacheRepository tacheRepository;
    @Override
    public tache saveTache(tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public tache updateTache(Long tacheId, tache tache) {
        return tacheRepository.findById(tacheId).map(ticket -> {
            ticket.setNumero(tache.getNumero());
            ticket.setDetails(tache.getDetails());
            ticket.setStatut(tache.getStatut());
            return tacheRepository.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " + tacheId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteTache(Long tacheId) {
        return tacheRepository.findById(tacheId).map(tache -> {
            tacheRepository.delete(tache);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("tacheId " +
                tacheId + " not found"));
    }

    @Override
    public Optional<tache> findById(Long id) {
        return tacheRepository.findById(id);
    }

    @Override
    public List<tache> getAll() {
        return tacheRepository.findAll();
    }

    @Override
    public List<tache> findtacheByChangement(Long idChangement) {
        return tacheRepository.findtacheByChangement(idChangement);
    }

    @Override
    public tache updateTache(Long idChangement, int numero) {
        return tacheRepository.updateTache(idChangement, numero);
    }

    @Override
    public int findNombreDeTachePourChangement(Long idChangement) {
        return tacheRepository.findNombreDetachePourChangement(idChangement);
    }
}
