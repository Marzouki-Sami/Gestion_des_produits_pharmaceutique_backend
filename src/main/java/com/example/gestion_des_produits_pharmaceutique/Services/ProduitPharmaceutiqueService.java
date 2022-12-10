package com.example.gestion_des_produits_pharmaceutique.Services;

import com.example.gestion_des_produits_pharmaceutique.Entities.ProduitPharmaceutique;
import com.example.gestion_des_produits_pharmaceutique.Repository.ProduitPharmaceutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitPharmaceutiqueService {

    @Autowired
    private ProduitPharmaceutiqueRepository produitPharmaceutiqueRepository;

    public List<ProduitPharmaceutique> findAllProduitPharmaceutique() {
        return produitPharmaceutiqueRepository.findAll();
    }

    public ProduitPharmaceutique findProduitPharmaceutiqueById(Long id) {
        return produitPharmaceutiqueRepository.findById(id).get();
    }

    public ProduitPharmaceutique saveProduitPharmaceutique(ProduitPharmaceutique produitPharmaceutique) {
        return produitPharmaceutiqueRepository.save(produitPharmaceutique);
    }

    public void deleteProduitPharmaceutique(Long id) {
        produitPharmaceutiqueRepository.deleteById(id);
    }

    public ProduitPharmaceutique updateProduitPharmaceutique(Long id, ProduitPharmaceutique produitPharmaceutique) {
        ProduitPharmaceutique produitPharmaceutique1 = produitPharmaceutiqueRepository.findById(id).get();
        produitPharmaceutique1.setLib_prd(produitPharmaceutique.getLib_prd());
        produitPharmaceutique1.setDescription_prd(produitPharmaceutique.getDescription_prd());
        produitPharmaceutique1.setPrix_prd(produitPharmaceutique.getPrix_prd());
        produitPharmaceutique1.setDateAjout_prd(produitPharmaceutique.getDateAjout_prd());
        produitPharmaceutique1.setPrix_livr(produitPharmaceutique.getPrix_livr());

        produitPharmaceutique1.setFamille(produitPharmaceutique.getFamille());
        produitPharmaceutique1.setLaboratoire(produitPharmaceutique.getLaboratoire());
        produitPharmaceutique1.setFournisseurs(produitPharmaceutique.getFournisseurs());
        produitPharmaceutique1.setFactureAchats(produitPharmaceutique.getFactureAchats());

        return produitPharmaceutiqueRepository.save(produitPharmaceutique1);
    }

    public Boolean produitExist(Long id) {
        return produitPharmaceutiqueRepository.existsById(id);
    }

    public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFamille(Long idFamille) {
        return produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFamille(idFamille);
    }

    public List<ProduitPharmaceutique> findProduitPharmaceutiqueByLabo(Long idLabo) {
        return produitPharmaceutiqueRepository.findProduitPharmaceutiqueByLabo(idLabo);
    }

    public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFamilleAndLabo(Long idFamille,Long idLabo) {
        return produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFamilleAndLabo(idFamille,idLabo);
    }

    public List<ProduitPharmaceutique> findProduitPharmaceutiqueByFournisseur(Long idFournisseur) {
        return produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFournisseur(idFournisseur);
    }
}
