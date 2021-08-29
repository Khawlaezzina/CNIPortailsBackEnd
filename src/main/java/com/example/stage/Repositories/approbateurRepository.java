package com.example.stage.Repositories;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.approbateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface approbateurRepository extends JpaRepository<approbateur,Long> {

    Optional<approbateur> findByEmail(String approbateurEmail);

    @Query("SELECT approbateur from approbateur approbateur WHERE approbateur.departement=?1")
    public List<approbateur> findApprobateurByDepartement(String departement);
    @Query("SELECT count(appro) from approbateur appro")
    public int countApprobateurs();

}
