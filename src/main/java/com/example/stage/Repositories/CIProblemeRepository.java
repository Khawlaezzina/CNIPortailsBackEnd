package com.example.stage.Repositories;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIProbleme;
import com.example.stage.Entities.CIProblemeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CIProblemeRepository extends JpaRepository<CIProbleme, CIProblemeId> {

    @Query("select ci from CI ci " +
            "where ci.id in (select ciChang.id.idCI from CIProbleme ciChang where ciChang.id.idProbleme=?2)")
    List<CI> getCIsByProbleme(Long idProbleme);
}
