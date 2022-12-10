package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/all")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/findutilisateur/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping("/saveutilisateur")
    public Utilisateur saveUtilisateur(@Validated @RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @PutMapping("/updateutilisateur/{id}")
    public ResponseEntity<?> updateUtilisateurById(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        if (utilisateurService.existeUtilisateur(id)) {
            Utilisateur utilisateur1 = utilisateurService.updateUtilisateurById(id, utilisateur);
            return ResponseEntity.ok().body(utilisateur1);
        } else {
            return ResponseEntity.ok().body("Utilisateur n'existe pas");
        }
    }

    @DeleteMapping("/deleteutilisateur/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable Long id) {
        if (utilisateurService.existeUtilisateur(id)) {
            utilisateurService.deleteUtilisateur(id);
            return ResponseEntity.ok().body("Utilisateur supprimé");
        } else {
            return ResponseEntity.ok().body("Utilisateur n'existe pas");
        }
    }
}
