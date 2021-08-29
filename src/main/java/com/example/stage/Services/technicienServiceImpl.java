package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.technicien;
import com.example.stage.Repositories.technicienRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("technicienService")
@Transactional
public class technicienServiceImpl implements technicienService{

    @Autowired
    private technicienRepository technicienRepository;
    @Override
    public technicien saveTechnicien(technicien technicien) {
        return technicienRepository.save(technicien);
    }

    @Override
    public technicien updateTechnicien(Long technicienId,technicien technicienRequest) {
        return technicienRepository.findById(technicienId).map(admin -> {
            admin.setNom(technicienRequest.getNom());
            admin.setPrenom(technicienRequest.getPrenom());
            admin.setEmail(technicienRequest.getEmail());
            return technicienRepository.save(admin);
        }).orElseThrow(() -> new ResourceNotFoundException("technicien Id " + technicienId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteTechnicien(Long technicienId) {
        return technicienRepository.findById(technicienId).map(technicien -> {
            technicienRepository.delete(technicien);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("technicienId " +
                technicienId + " not found"));
    }

    @Override
    public Optional<technicien> findTechnicienByEmail(String email) {
        return technicienRepository.findByEmail(email);
    }

    @Override
    public List<technicien> findTechnicienByDepartement(String departement) {
        return technicienRepository.findTechnicienByDepartement(departement);
    }

    @Override
    public Optional<technicien> findById(Long id) {
        return technicienRepository.findById(id);
    }

    @Override
    public List<technicien> getAll() {
        return technicienRepository.findAll();
    }

    @Autowired

    public technicienServiceImpl(com.example.stage.Repositories.technicienRepository technicienRepository) {
        this.technicienRepository = technicienRepository;
    }
}
