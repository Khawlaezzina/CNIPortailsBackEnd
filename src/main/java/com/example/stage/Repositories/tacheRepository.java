package com.example.stage.Repositories;

import com.example.stage.Entities.tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tacheRepository extends JpaRepository<tache,Long> {

    @Query("select t from tache t where t.idChangement.id=?1 order by t.numero asc ")
    List<tache> findtacheByChangement(Long idChangement);

    @Query("update tache set statut='Done' where idChangement=?1 and numero=?2")
    tache updateTache(Long idChangement,int numero);

    @Query("select max(numero) from tache where idChangement.id=?1")
    int findNombreDetachePourChangement(Long idChangement);


}
