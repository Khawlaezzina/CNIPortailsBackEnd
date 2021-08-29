package com.example.stage.Services;

import com.example.stage.Entities.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface serviceTechnicienService {
    public serviceTechnicien saveServiceTechnicienService(serviceTechnicien serviceTechnicien);


    public ResponseEntity<Object> deleteServiceTechnicien (Long idService, Long idTechnicien);

    public Optional<serviceTechnicien> findById(serviceTechnicienId ticketId);

    public List<serviceTechnicien> getAll();
    Optional<serviceTechnicien> findByIdServiceAndIdTechnicien(Long idService,Long idTechnicien);
    List<service> findAllServiceByTechnicien(Long idTechnicien);
    List<technicien> findAllTechniciensByService(Long idService);
}
