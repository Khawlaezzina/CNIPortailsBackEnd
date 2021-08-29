package com.example.stage.Services;

import com.example.stage.Entities.*;
import com.example.stage.Repositories.problemeTechnicienRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("problemeTechnicienService")
@Transactional
public class problemeTechnicienServiceImpl implements problemeTechnicienService{
    @Autowired
    private com.example.stage.Repositories.problemeTechnicienRepository problemeTechRepository;

    @Override
    public problemeTechnicien saveProblemeTechnicienService(problemeTechnicien problemeTechnicien) {
        return problemeTechRepository.save(problemeTechnicien);
    }

    @Override
    public ResponseEntity<Object> deleteProblemeTechnicien(Long idProbleme, Long idTechnicien) {
        return problemeTechRepository.findById(new problemeTechnicienId(idProbleme,idTechnicien)).map(certified->{
            problemeTechRepository.delete(certified);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Erreur ce lien nexiste pas"));
    }

    @Override
    public Optional<problemeTechnicien> findById(problemeTechnicienId ticketId) {
        return problemeTechRepository.findById(ticketId);
    }

    @Override
    public List<problemeTechnicien> getAll() {
        return problemeTechRepository.findAll();
    }

    @Override
    public Optional<problemeTechnicien> findByIdProblemeAndIdTechnicien(Long idProbleme, Long idTechnicien) {
        return problemeTechRepository.findByIdProblemeAndIdTechnicien(idProbleme, idTechnicien);
    }

    @Override
    public List<probleme> findAllProblemeByTechnicien(Long idTechnicien) {
        return problemeTechRepository.findAllProblemeByTechnicien(idTechnicien);
    }

    @Override
    public List<technicien> findAllTechniciensByProbleme(Long idProbleme) {
        return problemeTechRepository.findAllTechniciensByProbleme(idProbleme);
    }

    public problemeTechnicienServiceImpl(problemeTechnicienRepository problemeTechRepository) {
        this.problemeTechRepository = problemeTechRepository;
    }
}
