package com.example.gestion_des_produits_pharmaceutique.Controller;

import com.example.gestion_des_produits_pharmaceutique.Entities.FactureAchat;
import com.example.gestion_des_produits_pharmaceutique.Services.FactureAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factureAchat")
public class FactureAchatController {

    @Autowired
    private FactureAchatService factureAchatService;

    @PostMapping("/addFactureAchat")
    public FactureAchat addFactureAchat(@RequestBody FactureAchat factureAchat){
        return factureAchatService.addFactureAchat(factureAchat);
    }

    @GetMapping("/ImprimerFactureAchat/{id}")
    public ResponseEntity<?> ImprimerFactureAchat(@PathVariable Long id){
        if (factureAchatService.existeFactureAchat(id)){
            return ResponseEntity.ok().body(factureAchatService.ImprimerFactureAchat(id));
        }
        else {
            return ResponseEntity.ok().body("Facture Achat n'existe pas");
        }
    }
}
