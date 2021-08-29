package com.example.stage.Repositories;

import com.example.stage.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface serviceTechnicienRepository extends JpaRepository<serviceTechnicien, serviceTechnicienId> {

    @Query("select serviceTech from serviceTechnicien serviceTech where serviceTech.id.idService=?1 and serviceTech.id.idTechnicien=?2")
    Optional<serviceTechnicien> findByIdServiceAndIdTechnicien(Long idService, Long idTechnicien);
    @Query("select service from service service where service.id in (select serviceTech.id.idService from serviceTechnicien serviceTech where serviceTech.id.idTechnicien=?1)")
    List<service> findAllServiceByTechnicien(Long idTechnicien);

    @Query("select t from technicien t where t.id in (select serviceTech.id.idTechnicien from serviceTechnicien serviceTech where serviceTech.id.idService=?1)")
    List<technicien> findAllTechniciensByService(Long idService);
}
