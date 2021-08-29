package com.example.stage.Repositories;

import com.example.stage.Entities.approbateur;
import com.example.stage.Entities.technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface technicienRepository extends JpaRepository<technicien,Long> {

    Optional<technicien> findByEmail(String technicienEmail);

    @Query("SELECT t from technicien t WHERE t.departement=?1")
    public List<technicien> findTechnicienByDepartement(String departement);
}
