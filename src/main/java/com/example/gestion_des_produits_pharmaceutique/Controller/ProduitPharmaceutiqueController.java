package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Entities.ProduitPharmaceutique;
import com.example.gestion_des_produits_pharmaceutique.Services.ProduitPharmaceutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProduitPharmaceutique")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitPharmaceutiqueController {

    @Autowired
    private ProduitPharmaceutiqueService produitPharmaceutiqueService;

    @GetMapping("/all")
    public List<ProduitPharmaceutique> getAllProduitPharmaceutique(){
        return produitPharmaceutiqueService.findAllProduitPharmaceutique();
    }

    @GetMapping("/find/{id}")
    public ProduitPharmaceutique getProduitPharmaceutiqueById(@PathVariable Long id){
        return produitPharmaceutiqueService.findProduitPharmaceutiqueById(id);
    }

    @PostMapping("/add")
    public ProduitPharmaceutique addProduitPharmaceutique(@Validated @RequestBody ProduitPharmaceutique produitPharmaceutique){
       System.out.println(produitPharmaceutique.getLib_prd());
        return produitPharmaceutiqueService.saveProduitPharmaceutique(produitPharmaceutique);
    }

    @PutMapping("/assignFamille/{id}")
    public void assignFamille(@PathVariable Long id, @RequestBody Long id_famille){
        produitPharmaceutiqueService.assignFamille(id,id_famille);
    }

    @PutMapping("/assignLabo/{id}")
    public void assignLabo(@PathVariable Long id, @RequestBody Long id_labo){
        produitPharmaceutiqueService.assignLabo(id,id_labo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduitPharmaceutique(@PathVariable Long id){
        if (produitPharmaceutiqueService.produitExist(id)) {
            System.out.println("ProduitPharmaceutique in progress");
            produitPharmaceutiqueService.deleteProduitPharmaceutique(id);
            System.out.println("ProduitPharmaceutique deleted successfully");

            return ResponseEntity.ok().body("ProduitPharmaceutique deleted successfully");
        } else {
            return ResponseEntity.ok().body("ProduitPharmaceutique not found");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduitPharmaceutique(@PathVariable Long id, @RequestBody ProduitPharmaceutique produitPharmaceutique){
        if (produitPharmaceutiqueService.produitExist(id)) {
            produitPharmaceutiqueService.updateProduitPharmaceutique(id, produitPharmaceutique);
            return ResponseEntity.ok().body(produitPharmaceutique);
        } else {
            return ResponseEntity.ok().body("ProduitPharmaceutique not found");
        }
    }

    @GetMapping("/findbyfamille/{idFamille}")
    public List<ProduitPharmaceutique> getProduitPharmaceutiqueByFamille(@PathVariable Long idFamille){
        return produitPharmaceutiqueService.findProduitPharmaceutiqueByFamille(idFamille);
    }

    @GetMapping("/findbylabo/{idLabo}")
    public List<ProduitPharmaceutique> getProduitPharmaceutiqueByLabo(@PathVariable Long idLabo){
        return produitPharmaceutiqueService.findProduitPharmaceutiqueByLabo(idLabo);
    }

    @GetMapping("/findbyfamilleandlabo/{idFamille}/{idLabo}")
    public List<ProduitPharmaceutique> getProduitPharmaceutiqueByFamilleAndLabo(@PathVariable Long idFamille,@PathVariable Long idLabo){
        return produitPharmaceutiqueService.findProduitPharmaceutiqueByFamilleAndLabo(idFamille,idLabo);
    }

    @GetMapping("/findbyfournisseur/{idFournisseur}")
    public List<ProduitPharmaceutique> getProduitPharmaceutiqueByFournisseur(@PathVariable Long idFournisseur){
        return produitPharmaceutiqueService.findProduitPharmaceutiqueByFournisseur(idFournisseur);
    }
}
