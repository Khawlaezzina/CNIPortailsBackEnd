package com.example.stage.Services;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.contact;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface contactService {

    public contact saveContact(contact admin);

    public contact updateContact(Long adminId,contact admin);

    public ResponseEntity<Object> deleteContact(Long adminId);


    public Optional<contact> findById(Long id);

    public List<contact> getAll();
}
