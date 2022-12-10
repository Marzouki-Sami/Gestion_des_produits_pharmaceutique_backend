package com.example.gestion_des_produits_pharmaceutique.Repository;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Long> {
}
