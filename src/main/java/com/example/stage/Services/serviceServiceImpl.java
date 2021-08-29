package com.example.stage.Services;

import com.example.stage.Entities.service;
import com.example.stage.Entities.ticket;
import com.example.stage.Repositories.ticketRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("serviceService")
@Transactional
public class serviceServiceImpl implements serviceService{

    @Autowired
    private com.example.stage.Repositories.serviceRepository serviceRepository;
    @Override
    public service saveService(service service) {
        return serviceRepository.save(service);
    }

    @Override
    public service updateService(Long ticketId, service ticketRequest) {
        return serviceRepository.findById(ticketId).map(ticket -> {
            ticket.setTicketStatut(ticketRequest.getTicketStatut());
            ticket.setImpact(ticketRequest.getImpact());
            ticket.setUrgence(ticketRequest.getUrgence());
            ticket.setIdApprobateur(ticketRequest.getIdApprobateur());
            ticket.setDescription(ticketRequest.getDescription());
            ticket.setSujet(ticketRequest.getSujet());
            return serviceRepository.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("ticketId " + ticketId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteService(Long ticketId) {
        return serviceRepository.findById(ticketId).map(ticket -> {
            serviceRepository.delete(ticket);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("serviceId " +
                ticketId + " not found"));
    }

    @Override
    public Optional<service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<service> getAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<service> findServiceByDepartementAndStatut(String departement, String statut) {
        return serviceRepository.findServiceByDepartementAndStatut(departement, statut);
    }

    @Override
    public List<service> findServiceByStatut(String statut) {
        return serviceRepository.findServiceByStatut(statut);
    }

    @Override
    public List<service> findServiceByUser(Long idUser) {
        return serviceRepository.findServiceByUser(idUser);
    }

    @Override
    public List<service> findServiceByUserAndStatut(Long idUser, String statut) {
        return serviceRepository.findServiceByUserAndStatut(idUser, statut);
    }

    @Override
    public List<service> findServiceByDate(String date) {
        return serviceRepository.findServiceByDate(date);
    }

    @Override
    public List<service> findServiceByUrgenceDegree(String urgence) {
        return serviceRepository.findServiceByUrgenceDegree(urgence);
    }

    @Override
    public List<service> findServiceByImpactDegree(String impact) {
        return serviceRepository.findServiceByImpactDegree(impact);
    }

    @Override
    public List<service> findServiceByApprobateur(Long idApprobateur) {
        return serviceRepository.findServiceByApprobateur(idApprobateur);
    }

    @Override
    public List<service> findServiceByApprobateurAndStatut(Long idApprobateur, String statut) {
        return serviceRepository.findServiceByApprobateurAndStatut(idApprobateur, statut);
    }

    @Override
    public service updatePriorite(Long idService, Long priorite) {
        return serviceRepository.updatePriorite(idService, priorite);
    }

    @Override
    public List<String> findAllSujets() {
        return serviceRepository.findAllSujets();
    }
}
