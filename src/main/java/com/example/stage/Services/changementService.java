package com.example.stage.Services;

import com.example.stage.Entities.changement;
import com.example.stage.Entities.probleme;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface changementService {

    public changement saveChangement(changement changement);

    public changement updateChangement(Long ticketId,changement changement);

    public ResponseEntity<Object> deleteChangement (Long problemeId);

    public Optional<changement> findById(Long id);

    public List<changement> getAll();
    public List<changement> getChangementByStatut(String statut);
}
