package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur updateUtilisateurById(Long id, Utilisateur utilisateur) {
        Utilisateur utilisateur1 = utilisateurRepository.findById(id).get();
        utilisateur1.setNom_util(utilisateur.getNom_util());
        utilisateur1.setPrenom_util(utilisateur.getPrenom_util());
        utilisateur1.setAdresse_util(utilisateur.getAdresse_util());
        utilisateur1.setEmail_util(utilisateur.getEmail_util());
        utilisateur1.setCodePostal_util(utilisateur.getCodePostal_util());
        utilisateur1.setDateNaissance_util(utilisateur.getDateNaissance_util());
        return utilisateurRepository.save(utilisateur1);
    }

    public Boolean existeUtilisateur(Long id) {
        return utilisateurRepository.existsById(id);
    }
}
