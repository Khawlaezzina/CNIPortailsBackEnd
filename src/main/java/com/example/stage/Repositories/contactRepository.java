package com.example.stage.Repositories;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends JpaRepository<contact,Long> {
}
