package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findFournisseurById(Long id) {
        return fournisseurRepository.findById(id).get();
    }

    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public void deleteFournisseurById(Long id) {
        fournisseurRepository.deleteById(id);
    }

    public Fournisseur updateFournisseurById(Long id, Fournisseur fournisseur) {
        Fournisseur fournisseur1 = fournisseurRepository.findById(id).get();
        fournisseur1.setNom_four(fournisseur.getNom_four());
        fournisseur1.setAdresse_four(fournisseur.getAdresse_four());
        fournisseur1.setEmail_four(fournisseur.getEmail_four());
        fournisseur1.setTel_four(fournisseur.getTel_four());
        return fournisseurRepository.save(fournisseur1);
    }

    public Boolean existsFournisseurById(Long id) {
        return fournisseurRepository.existsById(id);
    }
}
