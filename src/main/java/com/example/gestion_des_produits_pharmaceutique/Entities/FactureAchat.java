package com.example.gestion_des_produits_pharmaceutique.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_FactureAchat")
public class FactureAchat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_facture_Achat;
    private Date date_facture_Achat;
    private Double Total_HT;
    private Double Total_TVA;
    private Double Total_TTC;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_four" , referencedColumnName = "id_four")
    private Fournisseur fournisseur;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_FactureAchat_ProduitPharmaceutique",
            joinColumns = @JoinColumn(name = "id_facture_Achat"),
            inverseJoinColumns = @JoinColumn(name = "id_prd"))
    private List<ProduitPharmaceutique> produitPharmaceutiques;
}
