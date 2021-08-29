package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import com.example.stage.Repositories.administrateurRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("AdministrateurService")
@Transactional
public class administrateurServiceImpl implements administrateurService{

    @Autowired
    private administrateurRepository adminRepository;
    @Override
    public administrateur saveAdministrateur(administrateur admin) {
        return adminRepository.save(admin);
    }

    @Override
    public administrateur updateAdministrateur(Long adminId,administrateur adminRequest) {
        return adminRepository.findById(adminId).map(admin -> {
            admin.setNom(adminRequest.getNom());
            admin.setPrenom(adminRequest.getPrenom());
            admin.setEmail(adminRequest.getEmail());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " + adminId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteAdministrateur(Long adminId) {
        return adminRepository.findById(adminId).map(admin -> {
            adminRepository.delete(admin);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("AdminId " +
                adminId + " not found"));
    }

    @Override
    public Optional<administrateur> findAdministrateurByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<administrateur> findAdministrateurByDepartement(String departement) {
        return adminRepository.findAdministrateurByDepartement(departement);
    }

    @Override
    public Optional<administrateur> findById(Long id) {
       return adminRepository.findById(id);
    }

    @Override
    public List<administrateur> getAll() {
        return adminRepository.findAll();
    }
}
