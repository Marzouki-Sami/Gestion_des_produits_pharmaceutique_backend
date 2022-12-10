package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoireService {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    public Laboratoire saveLaboratoire(Laboratoire laboratoire){
        return laboratoireRepository.save(laboratoire);
    }

    public Laboratoire updateLaboratoireById(Long id, String lib_labo){
        Laboratoire laboratoire = laboratoireRepository.findById(id).get();
        laboratoire.setLib_labo(lib_labo);
        return laboratoireRepository.save(laboratoire);
    }

    public void deleteLaboratoireById(Long id){
        laboratoireRepository.delete(laboratoireRepository.findById(id).get());
    }

    public List<Laboratoire> findAllLab(){
        return laboratoireRepository.findAll();
    }

    public Laboratoire findLaboratoireById(Long id){
        return laboratoireRepository.findById(id).get();
    }
    public Boolean LabExiste(Long id){
        return laboratoireRepository.existsById(id);
    }
}
