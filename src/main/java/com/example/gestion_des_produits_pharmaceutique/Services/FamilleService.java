package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Repository.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilleService {

    @Autowired
    FamilleRepository familleRepository;

    public List<Famille> findAll(){
        return familleRepository.findAll();
    }

    public Famille saveFamille(Famille famille){
        return familleRepository.save(famille);
    }

    public Famille updateFamilleById(Long id, Famille famille){
        Famille famille1 = familleRepository.findById(id).get();
        famille1.setLib_famille(famille.getLib_famille());
        return familleRepository.save(famille1);
    }

    public void deleteFamilleById(Long id){
        familleRepository.deleteById(id);
    }

    public Famille findFamilleById(Long id){
        return familleRepository.findById(id).get();
    }

    public Boolean existFamille(Long id){
        return familleRepository.existsById(id);
    }

}
