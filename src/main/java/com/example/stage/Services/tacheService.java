package com.example.stage.Services;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.tache;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface tacheService {

    public tache saveTache(tache tache);

    public tache updateTache(Long tacheId,tache tache);

    public ResponseEntity<Object> deleteTache (Long tacheId);

    public Optional<tache> findById(Long id);

    public List<tache> getAll();
    List<tache> findtacheByChangement(Long idChangement);
    tache updateTache(Long idChangement,int numero);
    int findNombreDeTachePourChangement(Long idChangement);
}
