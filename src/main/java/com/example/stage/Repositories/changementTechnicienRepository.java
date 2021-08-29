package com.example.stage.Repositories;

import com.example.stage.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface changementTechnicienRepository extends JpaRepository<changementTechnicien, changementTechnicienId> {
    @Query("select changementTech from changementTechnicien changementTech  where changementTech .id.idChangement=?1 and changementTech .id.idTechnicien=?2")
    Optional<changementTechnicien> findByIdChangementAndIdTechnicien(Long idChangement, Long idTechnicien);
    @Query("select c from changement c where c.id in (select changementTech.id.idChangement from changementTechnicien changementTech where changementTech.id.idTechnicien=?1)")
    List<changement> findAllChangementByTechnicien(Long idTechnicien);

    @Query("select t from technicien t where t.id in (select changementTech.id.idTechnicien from changementTechnicien changementTech where changementTech.id.idChangement=?1)")
    List<technicien> findAllTechniciensByChangement(Long idChangement);
}
