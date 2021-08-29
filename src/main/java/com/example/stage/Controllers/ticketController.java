package com.example.stage.Controllers;

import com.example.stage.Controllers.encryptDecrypt.AES;
import com.example.stage.Entities.approbateur;
import com.example.stage.Entities.ticket;
import com.example.stage.Services.ticketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("http://localhost:4200")
public class ticketController {
    @Autowired
    private ticketServiceImpl ticketService;
    @PostMapping("/add")
    public ticket createTicket(@Valid @RequestBody ticket ticket) {

        return ticketService.saveTicket(ticket);
    }

    @GetMapping("/list")
    public List<ticket> getAllTickets()
    {
        return ticketService.getAll();
    }

    @GetMapping("/{ticketId}")
    public java.util.Optional<ticket> getTicket(@PathVariable Long ticketId) {

        return  ticketService.findById(ticketId);
    }
    @PutMapping("/{ticketId}")
    public ticket updateTicket(@PathVariable Long ticketId, @Valid @RequestBody ticket ticketRequest) {
        return ticketService.updateTicket(ticketId,ticketRequest);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long ticketId) {
        return ticketService.deleteTicket(ticketId);
    }
    @GetMapping("/listTicketsByDepartement/{departement}/{statut}")
    public List<ticket> getTicketsByDepartementAndStatut(@PathVariable String departement,@PathVariable String statut)
    {
        return ticketService.findTicketByDepartementAndStatut(departement,statut);
    }
    @GetMapping("/listTicketsByStatut/{statut}")
    public List<ticket> getTicketByStatut(@PathVariable String statut)
    {
        return ticketService.findTicketByStatut(statut);
    }
    @GetMapping("listTicketByDate/{date}")
    public List<ticket> getTicketByDate(@PathVariable Date date)
    {
        return ticketService.findTicketByDate(date);
    }
    @GetMapping("/listTicketsByUser/{idUser}")
    public List<ticket> getTicketByUser(@PathVariable Long idUser)
    {
        return ticketService.findTicketByUser(idUser);
    }
    @GetMapping("/listTicketsByUserAndStatut/{idUser}/{statut}")
    public List<ticket> getTicketByUserAndStatut(@PathVariable Long idUser,@PathVariable String statut)
    {
        return ticketService.findTicketByUserAndStatut(idUser, statut);
    }

    @GetMapping("/listTicketByImpact/{impact}")
    public List<ticket> getTicketByImpactDegree(@PathVariable String impact)
    {
        return ticketService.findTicketByImpactDegree(impact);
    }

    @GetMapping("/listTicketByUrgence/{urgence}")
    public List<ticket> getTicketByUrgenceDegree(@PathVariable String urgence)
    {
        return ticketService.findTicketByUrgenceDegree(urgence);
    }

    @GetMapping("/listTicketsByApprobateur/{idApprobateur}")
    public List<ticket> getTicketByApprobateur(@PathVariable Long idApprobateur)
    {
        return ticketService.findTicketByApprobateur(idApprobateur);
    }

    @GetMapping("/listTicketsByApprobateurAndStatut/{idApprobateur}/{statut}")
    public List<ticket> getTicketByApprobateurAndStatut(@PathVariable Long idApprobateur,@PathVariable String statut)
    {
        return ticketService.findTicketByApprobateurAndStatut(idApprobateur, statut);
    }

    public ticketController() {

    }
}
