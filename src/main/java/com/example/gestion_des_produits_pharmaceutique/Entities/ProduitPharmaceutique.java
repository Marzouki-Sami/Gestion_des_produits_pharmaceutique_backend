package com.example.gestion_des_produits_pharmaceutique.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_ProduitPharmaceutique")
public class ProduitPharmaceutique {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prd;

    private String Lib_prd;
    private String Description_prd;
    private Double prix_prd;
    private Date dateAjout_prd;
    private float prix_livr;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_famille" , referencedColumnName = "id_famille")
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Famille famille;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_labo" , referencedColumnName = "id_labo")
    @OnDelete(action = OnDeleteAction.CASCADE)

    private Laboratoire laboratoire;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_ProduitPharmaceutique_Fournisseur",
            joinColumns = @JoinColumn(name = "id_prd"),
            inverseJoinColumns = @JoinColumn(name = "id_four"))
    private List<Fournisseur> fournisseurs;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_ProduitPharmaceutique_FactureAchat",
            joinColumns = @JoinColumn(name = "id_prd"),
            inverseJoinColumns = @JoinColumn(name = "id_facture_Achat"))
    private List<FactureAchat> factureAchats;
}
