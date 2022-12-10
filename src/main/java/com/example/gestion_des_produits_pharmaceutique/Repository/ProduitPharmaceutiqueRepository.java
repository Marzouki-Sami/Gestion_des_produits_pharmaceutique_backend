package com.example.gestion_des_produits_pharmaceutique.Repository;

import com.example.gestion_des_produits_pharmaceutique.Entities.ProduitPharmaceutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitPharmaceutiqueRepository extends JpaRepository<ProduitPharmaceutique, Long> {

        @Query(value = "select * from t_Produit_Pharmaceutique where id_famille=:idFamille",nativeQuery = true)
        public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFamille(@Param("idFamille") Long idFamille);

        @Query(value = "select * from t_Produit_Pharmaceutique where id_labo=:idLabo",nativeQuery = true)
        public List<ProduitPharmaceutique> findProduitPharmaceutiqueByLabo(@Param("idLabo") Long idLabo);

        @Query(value = "select * from t_Produit_Pharmaceutique where id_famille=:idFamille and id_labo=:idLabo",nativeQuery = true)
        public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFamilleAndLabo(@Param("idFamille") Long idFamille,@Param("idLabo") Long idLabo);

        @Query(value = "select * from t_Produit_Pharmaceutique where id_fournisseur=:idFournisseur",nativeQuery = true)
        public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFournisseur(@Param("idFournisseur") Long idFournisseur);
}
