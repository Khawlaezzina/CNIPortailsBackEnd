package com.example.stage.Repositories;

import com.example.stage.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface problemeTechnicienRepository extends JpaRepository<problemeTechnicien, problemeTechnicienId> {
    @Query("select problemeTech from problemeTechnicien problemeTech where problemeTech.id.idProbleme=?1 and problemeTech.id.idTechnicien=?2")
    Optional<problemeTechnicien> findByIdProblemeAndIdTechnicien(Long idProbleme, Long idTechnicien);
    @Query("select probleme from probleme probleme where probleme.id in (select problemeTech.id.idProbleme from problemeTechnicien problemeTech where problemeTech.id.idTechnicien=?1)")
    List<probleme> findAllProblemeByTechnicien(Long idTechnicien);

    @Query("select technicien from technicien technicien where technicien.id in (select problemeTech.id.idTechnicien from problemeTechnicien problemeTech where problemeTech.id.idProbleme=?1)")
    List<technicien> findAllTechniciensByProbleme(Long idProbleme);
}
