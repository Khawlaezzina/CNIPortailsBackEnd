package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.approbateur;
import com.example.stage.Repositories.approbateurRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service("ApprobateurService")
@Transactional
public class approbateurServiceImpl implements approbateurService{

    @Autowired
    private approbateurRepository approbateurRepository;

    @Override
    public approbateur saveApprobateur(approbateur approbateur) {
        return approbateurRepository.save(approbateur);
    }

    @Override
    public approbateur updateApprobateur(Long approbateurId,approbateur approbateurRequest) {
        return approbateurRepository.findById(approbateurId).map(approbateur -> {
            approbateur.setNom(approbateurRequest.getNom());
            approbateur.setPrenom(approbateurRequest.getPrenom());
            approbateur.setEmail(approbateurRequest.getEmail());
            return approbateurRepository.save(approbateur);
        }).orElseThrow(() -> new ResourceNotFoundException("ApprobateurId " + approbateurId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteApprobateur(Long approbateurId) {
        return approbateurRepository.findById(approbateurId).map(approbateur -> {
            approbateurRepository.delete(approbateur);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ApprobateurId " +
                approbateurId + " not found"));
    }

    @Override
    public Optional<approbateur> findApprobateurByEmail(String email) {
        return approbateurRepository.findByEmail(email);
    }

    public List<approbateur> findApprobateurByDepartement(String departement) {
        return approbateurRepository.findApprobateurByDepartement(departement);
    }

    @Override
    public Optional<approbateur> findById(Long id) {
        return approbateurRepository.findById(id);
    }

    @Override
    public List<approbateur> getAll() {
        return approbateurRepository.findAll();
    }
}
