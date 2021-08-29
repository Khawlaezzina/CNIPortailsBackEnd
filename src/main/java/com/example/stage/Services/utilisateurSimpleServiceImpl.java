package com.example.stage.Services;

import com.example.stage.Entities.approbateur;
import com.example.stage.Entities.utilisateurSimple;
import com.example.stage.Repositories.approbateurRepository;
import com.example.stage.Repositories.utilisateurSimpleRepository;
import com.example.stage.Services.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("TechnicienService")
@Transactional
public class utilisateurSimpleServiceImpl implements utilisateurSimpleService{

    @Autowired
    private utilisateurSimpleRepository userRepository;

    @Override
    public utilisateurSimple saveUtilisateurSimple(utilisateurSimple user) {
        return userRepository.save(user);
    }

    @Override
    public utilisateurSimple updateUtilisateurSimple(Long userId,utilisateurSimple userRequest) {
        return userRepository.findById(userId).map(user -> {
            user.setNom(userRequest.getNom());
            user.setPrenom(userRequest.getPrenom());
            user.setEmail(userRequest.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("userId " + userId + " not found"));
    }

    @Override
    public ResponseEntity<Object> deleteUtilisateurSimple(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("userId " +
                userId + " not found"));
    }

    @Override
    public Optional<utilisateurSimple> findUtilisateurSimpleByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<utilisateurSimple> findUtilisateurSimpleByDepartement(String departement) {
        return userRepository.findUtilisateurSimpleByDepartement(departement);
    }

    @Override
    public Optional<utilisateurSimple> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<utilisateurSimple> getAll() {
        return userRepository.findAll();
    }
}
