package com.example.gestion_des_produits_pharmaceutique.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_Fournisseur")
public class Fournisseur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_four;

    private String nom_four;
    private String adresse_four;
    private String email_four;
    private int tel_four;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_util")
    private Utilisateur utilisateur;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FactureAchat> factureAchats;

    @ManyToMany(mappedBy = "fournisseurs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<ProduitPharmaceutique> produitPharmaceutiques;
}
