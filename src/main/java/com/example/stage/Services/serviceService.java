package com.example.stage.Services;

import com.example.stage.Entities.service;
import com.example.stage.Entities.ticket;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface serviceService {

    public service saveService(service service);

    public service updateService(Long serviceId,service service);

    public ResponseEntity<Object> deleteService (Long adminId);

    public Optional<service> findById(Long id);

    public List<service> getAll();

    List<service> findServiceByDepartementAndStatut(String departement,String statut);

    List<service> findServiceByStatut(String statut);

    List<service>  findServiceByUser(Long idUser);

    List<service> findServiceByUserAndStatut(Long idUser, String statut);

    List<service> findServiceByDate(String date);

    List<service> findServiceByUrgenceDegree(String urgence);

    List<service> findServiceByImpactDegree(String impact);

    List<service>  findServiceByApprobateur(Long idApprobateur);

    List<service> findServiceByApprobateurAndStatut(Long idApprobateur, String statut);
    service updatePriorite(Long idService,Long priorite);
    List<String> findAllSujets();
}
