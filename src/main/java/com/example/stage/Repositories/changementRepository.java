package com.example.stage.Repositories;

import com.example.stage.Entities.changement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface changementRepository extends JpaRepository<changement,Long> {
    @Query("select c from changement c where c.statut=?1")
    public List<changement> getChangementByStatut(String statut);
}
