package com.example.stage.Repositories;

import com.example.stage.Entities.CI;
import com.example.stage.Entities.CIChangement;
import com.example.stage.Entities.CIChangementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CIChangementRepository extends JpaRepository<CIChangement, CIChangementId> {

    @Query("select ci from CI ci " +
            "where ci.id in (select ciChang.id.idCI from CIChangement ciChang where ciChang.id.idChangement=?2)")
    List<CI> getCIsByChangement(Long idChangement);
}
