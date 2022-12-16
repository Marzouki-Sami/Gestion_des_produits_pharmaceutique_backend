package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin(origins = "http://localhost:4200")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/all")
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurService.getAllFournisseur();
    }

    @GetMapping("/fournisseurbyid/{id}")
    public Fournisseur findFournisseurById(@PathVariable Long id) {
        return fournisseurService.findFournisseurById(id);
    }

    @PostMapping("/add")
    public Fournisseur saveFournisseur(@Validated @RequestBody Fournisseur fournisseur) {
        return fournisseurService.saveFournisseur(fournisseur);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
        if (fournisseurService.existsFournisseurById(id)) {
            fournisseurService.updateFournisseurById(id, fournisseur);
            return ResponseEntity.ok().body(fournisseur);
        }
        else {
            return ResponseEntity.ok().body("Fournisseur not found");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFournisseurById(@PathVariable Long id) {
        if (fournisseurService.existsFournisseurById(id)) {
            fournisseurService.deleteFournisseurById(id);
            return ResponseEntity.ok().body("Fournisseur deleted");
        }
        else {
            return ResponseEntity.ok().body("Fournisseur not found");
        }
    }
}
