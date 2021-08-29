package com.example.stage.Services;

import com.example.stage.Entities.contact;
import com.example.stage.Repositories.contactRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("ContactService")
@Transactional
public class contactServiceImpl implements contactService{
    @Autowired
    private contactRepository contactRepository;
    @Override
    public contact saveContact(contact admin) {
        return contactRepository.save(admin);
    }
    @Autowired
    public contactServiceImpl(com.example.stage.Repositories.contactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public contact updateContact(Long adminId, contact adminRequest) {
        return contactRepository.findById(adminId).map(admin -> {
            admin.setNom(adminRequest.getNom());
            admin.setPrenom(adminRequest.getPrenom());
            admin.setEmail(adminRequest.getEmail());
            admin.setFonction(adminRequest.getFonction());
            admin.setAdresse(adminRequest.getAdresse());
            admin.setStatut(adminRequest.getStatut());
            admin.setNumeroTelephone((adminRequest.getNumeroTelephone()));
            admin.setOrganisation(adminRequest.getOrganisation());
            return contactRepository.save(admin);
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " + adminId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteContact(Long adminId) {
        return contactRepository.findById(adminId).map(admin -> {
            contactRepository.delete(admin);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " +
                adminId + " not found"));
    }

    @Override
    public Optional<contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<contact> getAll() {
        return contactRepository.findAll();
    }
}
