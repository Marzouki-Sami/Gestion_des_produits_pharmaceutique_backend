package com.example.gestion_des_produits_pharmaceutique.Repository;

import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
