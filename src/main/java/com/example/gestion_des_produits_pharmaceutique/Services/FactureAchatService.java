package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.FactureAchat;
import com.example.gestion_des_produits_pharmaceutique.Repository.FactureAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureAchatService {

    @Autowired
    private FactureAchatRepository factureAchatRepository;

    public FactureAchat addFactureAchat(FactureAchat factureAchat){
        return factureAchatRepository.save(factureAchat);
    }

    public FactureAchat ImprimerFactureAchat(Long id){
        return factureAchatRepository.findById(id).get();
    }

    public Boolean existeFactureAchat(Long id){
        return factureAchatRepository.existsById(id);
    }
}
