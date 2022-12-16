package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratoire")
@CrossOrigin(origins = "http://localhost:4200")
public class LaboratoireController {

    @Autowired
    private LaboratoireService laboratoireService;

    @GetMapping("/all")
    public List<Laboratoire> findAllLab(){
        return laboratoireService.findAllLab();
    }

    @GetMapping("/find/{id}")
    public Laboratoire findLaboratoireById(@PathVariable Long id){
        return laboratoireService.findLaboratoireById(id);
    }

    @PostMapping("/add")
    public Laboratoire saveLaboratoire(@Validated @RequestBody Laboratoire laboratoire){
        laboratoireService.saveLaboratoire(laboratoire);
        return laboratoire;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLaboratoireById(@PathVariable Long id, @RequestBody Laboratoire laboratoire){
        if (laboratoireService.LabExiste(id)){
            laboratoireService.updateLaboratoireById(id,laboratoire.getLib_labo());
            return ResponseEntity.ok().body(laboratoire);
        }else{
            System.out.println("il n y a aucun laboratoire existant avec l'id "+id);
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLaboratoireById(@PathVariable Long id){
        if (laboratoireService.LabExiste(id)){
            laboratoireService.deleteLaboratoireById(id);
            return ResponseEntity.ok().body("laboratoire supprimé avec succés");
        }else{
            return ResponseEntity.ok().body("il n y a aucun laboratoire existant avec l'id "+id);
        }
    }
}
