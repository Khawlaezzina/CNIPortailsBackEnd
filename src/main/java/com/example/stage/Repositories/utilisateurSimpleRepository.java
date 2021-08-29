package com.example.stage.Repositories;

import com.example.stage.Entities.administrateur;
import com.example.stage.Entities.utilisateurSimple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface utilisateurSimpleRepository extends JpaRepository<utilisateurSimple,Long> {

    Optional<utilisateurSimple> findByEmail(String userEmail);

    @Query("SELECT user from utilisateurSimple user WHERE user.departement=?1")
    public List<utilisateurSimple> findUtilisateurSimpleByDepartement(String departement);

    @Query("SELECT count(user) from utilisateurSimple user ")
    public int countUsers();
}
