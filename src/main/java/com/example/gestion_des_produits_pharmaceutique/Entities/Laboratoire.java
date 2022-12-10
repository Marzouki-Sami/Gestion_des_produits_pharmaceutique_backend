package com.example.gestion_des_produits_pharmaceutique.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_Laboratoire")
public class Laboratoire {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_labo;

    @Column(name = "lib_labo")
    private String lib_labo;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratoire", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProduitPharmaceutique> produitPharmaceutiques;
}
