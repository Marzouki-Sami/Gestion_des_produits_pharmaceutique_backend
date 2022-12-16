package com.example.gestion_des_produits_pharmaceutique;

import com.example.gestion_des_produits_pharmaceutique.Entities.*;
import com.example.gestion_des_produits_pharmaceutique.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.gestion_des_produits_pharmaceutique.Entities"})
public class GestionDesProduitsPharmaceutiqueApplication implements CommandLineRunner {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    @Autowired
    private ProduitPharmaceutiqueRepository produitPharmaceutiqueRepository;

    @Autowired
    private FamilleRepository familleRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FactureAchatRepository factureAchatRepository;


    public static void main(String[] args) {
        SpringApplication.run(GestionDesProduitsPharmaceutiqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Laboratoire laboratoire1 = new Laboratoire(null, "Laboratoire 1", null);
        Laboratoire laboratoire2 = new Laboratoire(null, "Laboratoire 2", null);

        Famille famille1 = new Famille(null, "Famille 1", null);
        Famille famille2 = new Famille(null, "Famille 2", null);
        Famille famille3 = new Famille(null, "Famille 3", null);

        Utilisateur utilisateur1 = new Utilisateur(null, "Utilisateur 1", "Utilisateur 1", "Address 1", "Email 1", 11111, null, null);

        Fournisseur fournisseur1 = new Fournisseur(null, "Fournisseur 1", "Address 1", "Email 1", 12345678, utilisateur1, null, null);
        Fournisseur fournisseur2 = new Fournisseur(null, "Fournisseur 2", "Address 2", "Email 2", 12345678, utilisateur1, null, null);

        List<Fournisseur> listFournisseurs = List.of(fournisseur1, fournisseur2);

        Utilisateur utilisateur2 = new Utilisateur(null, "Utilisateur 2", "Utilisateur 2", "Address 2", "Email 2", 22222, null, listFournisseurs);


        Date date11 = new Date(2022,10,20);
        Date date22 = new Date(2022,10,20);
        Date date33 = new Date(2022,10,20);

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique(null, "Produit 1", "Description 1", 100.0, date11, 100, famille1, laboratoire1, null, null);
        ProduitPharmaceutique produitPharmaceutique2 = new ProduitPharmaceutique(null, "Produit 2", "Description 2", 200.0, date22, 200, famille2, laboratoire2, null, null);
        ProduitPharmaceutique produitPharmaceutique3 = new ProduitPharmaceutique(null, "Produit 3", "Description 3", 300.0, date33, 300, famille3, laboratoire1, null, null);
        ProduitPharmaceutique produitPharmaceutique4 = new ProduitPharmaceutique(null, "Produit 4", "Description 4", 400.0, date11, 400, famille1, laboratoire2, null, null);
        ProduitPharmaceutique produitPharmaceutique5 = new ProduitPharmaceutique(null, "Produit 5", "Description 5", 500.0, date22, 500, famille2, laboratoire1, null, null);
        ProduitPharmaceutique produitPharmaceutique6 = new ProduitPharmaceutique(null, "Produit 6", "Description 6", 600.0, date33, 600, famille3, laboratoire2, null, null);

        List<ProduitPharmaceutique> listProduitPharmaceutiques1234 = List.of(produitPharmaceutique1, produitPharmaceutique2, produitPharmaceutique3, produitPharmaceutique4);
        List<ProduitPharmaceutique> listProduitPharmaceutiques56 = List.of(produitPharmaceutique5, produitPharmaceutique6);
        List<ProduitPharmaceutique> listProduitPharmaceutiques123456 = List.of(produitPharmaceutique1, produitPharmaceutique2, produitPharmaceutique3, produitPharmaceutique4, produitPharmaceutique5, produitPharmaceutique6);

        Date date1 = new Date(2022,10,20);
        Date date2 = new Date(2022,10,20);
        Date date3 = new Date(2022,10,20);

        FactureAchat factureAchat1 = new FactureAchat(null, date1, 1000.0, 100.0, 1100.0, fournisseur1, listProduitPharmaceutiques56);
        FactureAchat factureAchat2 = new FactureAchat(null, date2, 2000.0, 200.0, 2200.0, fournisseur2, listProduitPharmaceutiques1234);
        FactureAchat factureAchat3 = new FactureAchat(null, date3, 3000.0, 300.0, 3300.0, fournisseur1, listProduitPharmaceutiques123456);


        laboratoireRepository.save(laboratoire1);
        laboratoireRepository.save(laboratoire2);

        familleRepository.save(famille1);
        familleRepository.save(famille2);
        familleRepository.save(famille3);

        utilisateurRepository.save(utilisateur1);
        utilisateurRepository.save(utilisateur2);

        fournisseurRepository.save(fournisseur1);
        fournisseurRepository.save(fournisseur2);

        produitPharmaceutiqueRepository.save(produitPharmaceutique1);
        produitPharmaceutiqueRepository.save(produitPharmaceutique2);
        produitPharmaceutiqueRepository.save(produitPharmaceutique3);
        produitPharmaceutiqueRepository.save(produitPharmaceutique4);
        produitPharmaceutiqueRepository.save(produitPharmaceutique5);
        produitPharmaceutiqueRepository.save(produitPharmaceutique6);

        factureAchatRepository.save(factureAchat1);
        factureAchatRepository.save(factureAchat2);
        factureAchatRepository.save(factureAchat3);

    }
}
