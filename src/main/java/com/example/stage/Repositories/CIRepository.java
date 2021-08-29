package com.example.stage.Repositories;

import com.example.stage.Entities.CI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CIRepository extends JpaRepository<CI,Long> {

    @Query("select distinct(emplacement) from CI")
    List<String> findAllEmplacement();

    @Query("select ci from CI ci where ci.emplacement=?1")
    List<CI> findByEmplacement(String emplacement);

    @Query("select count(ci) from CI ci where ci.emplacement=?1")
    int countCIByEmplacement(String emplacement);
    @Query("select ci from CI ci where ci.emplacement=?1 and ci.nom=?2")
    List<CI> findByEmplacementAndName(String emplacement,String nom);

    @Query("select ci from CI ci where ci.organisation=?1")
    List<CI> findByOrganisation(String organisation);
    @Query("SELECT count(ci) from CI ci ")
    public int countCI();
}
