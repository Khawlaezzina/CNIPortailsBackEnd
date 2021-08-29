package com.example.stage.Repositories;

import com.example.stage.Entities.administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface administrateurRepository extends JpaRepository<administrateur,Long> {

    Optional<administrateur> findByEmail(String adminEmail);

    @Query("SELECT admin from administrateur admin WHERE admin.departement=?1")
    public List<administrateur> findAdministrateurByDepartement(String departement);


}
