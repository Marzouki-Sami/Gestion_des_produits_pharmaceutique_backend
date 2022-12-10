package com.example.gestion_des_produits_pharmaceutique.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commande_prd")
public class Commande_Prd {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commande;

    private Date date_fourni;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "id_four")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_prd")
    private ProduitPharmaceutique produitPharmaceutique;

}
