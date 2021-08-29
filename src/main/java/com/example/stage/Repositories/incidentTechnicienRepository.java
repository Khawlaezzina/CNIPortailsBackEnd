package com.example.stage.Repositories;

import com.example.stage.Entities.incident;
import com.example.stage.Entities.incidentTechnicien;
import com.example.stage.Entities.incidentTechnicienId;
import com.example.stage.Entities.technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface
incidentTechnicienRepository extends JpaRepository<incidentTechnicien, incidentTechnicienId> {

    @Query("select incidentTech from incidentTechnicien incidentTech where incidentTech.id.idIncident=?1 and incidentTech.id.idTechnicien=?2")
    Optional<incidentTechnicien> findByIdIncidentAndIdTechnicien(Long idIncident,Long idTechnicien);
    @Query("select incident from incident incident where incident.id in (select incidentTech.id.idIncident from incidentTechnicien incidentTech where incidentTech.id.idTechnicien=?1)")
    List<incident> findAllIncidentByTechnicien(Long idTechnicien);

    @Query("select t from technicien t where t.id in (select incidentTech.id.idTechnicien from incidentTechnicien incidentTech where incidentTech.id.idIncident=?1)")
    List<technicien> findAllTechniciensByIncident(Long idIncident);

}
