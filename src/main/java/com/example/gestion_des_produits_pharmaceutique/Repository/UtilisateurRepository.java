package com.example.gestion_des_produits_pharmaceutique.Repository;

import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
