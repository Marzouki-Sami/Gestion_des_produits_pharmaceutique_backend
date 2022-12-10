package com.example.gestion_des_produits_pharmaceutique.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_Famille")
public class Famille {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_famille;
    private String lib_famille;

    @JsonIgnore
    @OneToMany(mappedBy = "famille", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProduitPharmaceutique> produitPharmaceutiques;

}
