package com.example.stage.Services;

import com.example.stage.Entities.*;
import com.example.stage.Repositories.changementTechnicienRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service("changementechnicienService")
@Transactional
public class changementTechnicienImpl implements changementTechnicienService{

    @Autowired
    private changementTechnicienRepository changementTechnicienRepository;

    @Autowired
    public changementTechnicienImpl(com.example.stage.Repositories.changementTechnicienRepository changementTechnicienRepository) {
        this.changementTechnicienRepository = changementTechnicienRepository;
    }



    @Override
    public changementTechnicien saveChangementTechnicienService(changementTechnicien problemeTechnicien) {
        return changementTechnicienRepository.save(problemeTechnicien);
    }

    @Override
    public ResponseEntity<Object> deleteChangementTechnicien(Long idProbleme, Long idTechnicien) {
        return changementTechnicienRepository.findById(new changementTechnicienId(idProbleme,idTechnicien)).map(certified->{
            changementTechnicienRepository.delete(certified);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Erreur ce lien nexiste pas"));
    }

    @Override
    public Optional<changementTechnicien> findById(changementTechnicienId ticketId) {
        return changementTechnicienRepository.findById(ticketId);
    }

    @Override
    public List<changementTechnicien> getAll() {
        return changementTechnicienRepository.findAll();
    }

    @Override
    public Optional<changementTechnicien> findByIdChangementAndIdTechnicien(Long idProbleme, Long idTechnicien) {
        return changementTechnicienRepository.findByIdChangementAndIdTechnicien(idProbleme,idTechnicien);
    }

    @Override
    public List<changement> findAllChangementByTechnicien(Long idTechnicien) {
        return changementTechnicienRepository.findAllChangementByTechnicien(idTechnicien);
    }

    @Override
    public List<technicien> findAllTechniciensByChangement(Long idProbleme) {
        return changementTechnicienRepository.findAllTechniciensByChangement(idProbleme);
    }
}
