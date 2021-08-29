package com.example.stage.Services;

import com.example.stage.Entities.*;
import com.example.stage.Repositories.serviceTechnicienRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("serviceTechnicienService")
@Transactional
public class serviceTechnicienServiceImpl implements serviceTechnicienService{
    @Autowired
    private com.example.stage.Repositories.serviceTechnicienRepository serviceTechRepository;

    @Override
    public serviceTechnicien saveServiceTechnicienService(serviceTechnicien serviceTechnicien) {
        return serviceTechRepository.save(serviceTechnicien);
    }

    @Override
    public ResponseEntity<Object> deleteServiceTechnicien(Long idService, Long idTechnicien) {
        return serviceTechRepository.findById(new serviceTechnicienId(idService,idTechnicien)).map(certified->{
            serviceTechRepository.delete(certified);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Erreur ce lien nexiste pas"));
    }

    @Override
    public Optional<serviceTechnicien> findById(serviceTechnicienId ticketId) {
        return serviceTechRepository.findById(ticketId);
    }

    @Override
    public List<serviceTechnicien> getAll() {
        return serviceTechRepository.findAll();
    }

    @Override
    public Optional<serviceTechnicien> findByIdServiceAndIdTechnicien(Long idService, Long idTechnicien) {
        return serviceTechRepository.findByIdServiceAndIdTechnicien(idService,idTechnicien);
    }

    @Override
    public List<service> findAllServiceByTechnicien(Long idTechnicien) {
        return serviceTechRepository.findAllServiceByTechnicien(idTechnicien);
    }

    @Override
    public List<technicien> findAllTechniciensByService(Long idService) {
        return serviceTechRepository.findAllTechniciensByService(idService);
    }

    public serviceTechnicienServiceImpl(serviceTechnicienRepository serviceTechRepository) {
        this.serviceTechRepository = serviceTechRepository;
    }
}
