package com.example.stage.Controllers;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.service;
import com.example.stage.Entities.ticket;
import com.example.stage.Services.serviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin("http://localhost:4200")
public class serviceController {
    @Autowired
    private serviceServiceImpl serviceService;
    @PostMapping("/add")
    public service createService(@Valid @RequestBody service service) {

        return serviceService.saveService(service);
    }

    @GetMapping("/list")
    public List<service> getAllServices()
    {
        return serviceService.getAll();
    }

    @GetMapping("/{ticketId}")
    public java.util.Optional<service> getTicket(@PathVariable Long ticketId) {

        return  serviceService.findById(ticketId);
    }
    @PutMapping("/{ticketId}")
    public service updateService(@PathVariable Long ticketId, @Valid @RequestBody service ticketRequest) {
        return serviceService.updateService(ticketId,ticketRequest);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteService(@PathVariable Long ticketId) {
        return serviceService.deleteService(ticketId);
    }
    @GetMapping("/listServicesByDepartement/{departement}/{statut}")
    public List<service> getServiceByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return serviceService.findServiceByDepartementAndStatut(departement,statut);
    }
    @GetMapping("/listServicessByStatut/{statut}")
    public List<service> getServiceByStatut(@PathVariable String statut)
    {
        return serviceService.findServiceByStatut(statut);
    }
    @GetMapping("listServiceByDate/{date}")
    public List<service> getServiceByDate(@PathVariable String date)
    {
        return serviceService.findServiceByDate(date);
    }
    @GetMapping("/listServicesByUser/{idUser}")
    public List<service> getServiceByUser(@PathVariable Long idUser)
    {
        return serviceService.findServiceByUser(idUser);
    }
    @GetMapping("/listServicesByUserAndStatut/{idUser}/{statut}")
    public List<service> getServiceByUserAndStatut(@PathVariable Long idUser,@PathVariable String statut)
    {
        return serviceService.findServiceByUserAndStatut(idUser, statut);
    }

    @GetMapping("/listServiceByImpact/{impact}")
    public List<service> getServiceByImpactDegree(@PathVariable String impact)
    {
        return serviceService.findServiceByImpactDegree(impact);
    }

    @GetMapping("/listServiceByUrgence/{impact}")
    public List<service> getServiceByUrgenceDegree(@PathVariable String urgence)
    {
        return serviceService.findServiceByUrgenceDegree(urgence);
    }

    @GetMapping("/listServicesByApprobateur/{idApprobateur}")
    public List<service> getServiceByApprobateur(@PathVariable Long idApprobateur)
    {
        return serviceService.findServiceByApprobateur(idApprobateur);
    }

    @GetMapping("/listServicesByApprobateurAndStatut/{idApprobateur}/{statut}")
    public List<service> getServiceByApprobateurAndStatut(@PathVariable Long idApprobateur,@PathVariable String statut)
    {
        return serviceService.findServiceByApprobateurAndStatut(idApprobateur, statut);
    }
    @PutMapping("/updatePriority/{idProblem}/{priorite}")
    public service upadateServicePriority(@PathVariable Long idProblem, @PathVariable Long priorite)
    {
        return serviceService.updatePriorite(idProblem,priorite);
    }
    @GetMapping("/listServicesSubject/")
    public List<String> getServicesSubject()
    {
        return serviceService.findAllSujets();
    }

    public serviceController(serviceServiceImpl serviceService) {
        this.serviceService = serviceService;
    }
}
