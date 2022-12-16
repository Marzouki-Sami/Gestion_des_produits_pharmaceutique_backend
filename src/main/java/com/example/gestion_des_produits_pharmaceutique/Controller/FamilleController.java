package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/famille")
@CrossOrigin(origins = "http://localhost:4200")
public class FamilleController {

    @Autowired
    private FamilleService familleService;

    @GetMapping("/all")
    public List<Famille> getAllFamille(){
        return familleService.findAll();
    }

    @GetMapping("/find/{id}")
    public Famille findFamilleById(@PathVariable Long id){
        return familleService.findFamilleById(id);
    }

    @PostMapping("/add")
    public Famille saveFamille(@Validated @RequestBody Famille famille){
        return familleService.saveFamille(famille);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFamilleById(@PathVariable Long id, @RequestBody Famille famille){
        if (familleService.existFamille(id)){
            familleService.updateFamilleById(id,famille);
            return ResponseEntity.ok().body(famille);
        }else{
            System.out.println("il n y a aucun famille existant avec l'id "+id);
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFamilleById(@PathVariable Long id){
        if (familleService.existFamille(id)){
            familleService.deleteFamilleById(id);
            return ResponseEntity.ok().body("famille supprimé avec succés");
        }else{
            System.out.println("il n y a aucun famille existant avec l'id "+id);
            return ResponseEntity.ok().body(null);
        }
    }
}
