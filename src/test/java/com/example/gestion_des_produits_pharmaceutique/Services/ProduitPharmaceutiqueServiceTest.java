package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Entities.ProduitPharmaceutique;
import com.example.gestion_des_produits_pharmaceutique.Repository.ProduitPharmaceutiqueRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProduitPharmaceutiqueService.class})
@ExtendWith(SpringExtension.class)
class ProduitPharmaceutiqueServiceTest {
    @MockBean
    private ProduitPharmaceutiqueRepository produitPharmaceutiqueRepository;

    @Autowired
    private ProduitPharmaceutiqueService produitPharmaceutiqueService;

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findAllProduitPharmaceutique()}
     */
    @Test
    void testFindAllProduitPharmaceutique() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        when(produitPharmaceutiqueRepository.findAll()).thenReturn(produitPharmaceutiqueList);
        List<ProduitPharmaceutique> actualFindAllProduitPharmaceutiqueResult = produitPharmaceutiqueService
                .findAllProduitPharmaceutique();
        assertSame(produitPharmaceutiqueList, actualFindAllProduitPharmaceutiqueResult);
        assertTrue(actualFindAllProduitPharmaceutiqueResult.isEmpty());
        verify(produitPharmaceutiqueRepository).findAll();
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueById(Long)}
     */
    @Test
    void testFindProduitPharmaceutiqueById() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);
        Optional<ProduitPharmaceutique> ofResult = Optional.of(produitPharmaceutique);
        when(produitPharmaceutiqueRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(produitPharmaceutique, produitPharmaceutiqueService.findProduitPharmaceutiqueById(123L));
        verify(produitPharmaceutiqueRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindProduitPharmaceutiqueById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.ProduitPharmaceutiqueService.findProduitPharmaceutiqueById(ProduitPharmaceutiqueService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        when(produitPharmaceutiqueRepository.findById((Long) any())).thenReturn(Optional.empty());
        produitPharmaceutiqueService.findProduitPharmaceutiqueById(123L);
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#saveProduitPharmaceutique(ProduitPharmaceutique)}
     */
    @Test
    void testSaveProduitPharmaceutique() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);
        when(produitPharmaceutiqueRepository.save((ProduitPharmaceutique) any())).thenReturn(produitPharmaceutique);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique1.setDateAjout_prd(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique1.setDescription_prd("Description prd");
        produitPharmaceutique1.setFactureAchats(new ArrayList<>());
        produitPharmaceutique1.setFamille(famille1);
        produitPharmaceutique1.setFournisseurs(new ArrayList<>());
        produitPharmaceutique1.setId_prd(1L);
        produitPharmaceutique1.setLaboratoire(laboratoire1);
        produitPharmaceutique1.setLib_prd("Lib prd");
        produitPharmaceutique1.setPrix_livr(10.0f);
        produitPharmaceutique1.setPrix_prd(10.0d);
        assertSame(produitPharmaceutique, produitPharmaceutiqueService.saveProduitPharmaceutique(produitPharmaceutique1));
        verify(produitPharmaceutiqueRepository).save((ProduitPharmaceutique) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#deleteProduitPharmaceutique(Long)}
     */
    @Test
    void testDeleteProduitPharmaceutique() {
        doNothing().when(produitPharmaceutiqueRepository).deleteById((Long) any());
        produitPharmaceutiqueService.deleteProduitPharmaceutique(123L);
        verify(produitPharmaceutiqueRepository).deleteById((Long) any());
        assertTrue(produitPharmaceutiqueService.findAllProduitPharmaceutique().isEmpty());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#updateProduitPharmaceutique(Long, ProduitPharmaceutique)}
     */
    @Test
    void testUpdateProduitPharmaceutique() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);
        Optional<ProduitPharmaceutique> ofResult = Optional.of(produitPharmaceutique);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique1.setDateAjout_prd(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique1.setDescription_prd("Description prd");
        produitPharmaceutique1.setFactureAchats(new ArrayList<>());
        produitPharmaceutique1.setFamille(famille1);
        produitPharmaceutique1.setFournisseurs(new ArrayList<>());
        produitPharmaceutique1.setId_prd(1L);
        produitPharmaceutique1.setLaboratoire(laboratoire1);
        produitPharmaceutique1.setLib_prd("Lib prd");
        produitPharmaceutique1.setPrix_livr(10.0f);
        produitPharmaceutique1.setPrix_prd(10.0d);
        when(produitPharmaceutiqueRepository.save((ProduitPharmaceutique) any())).thenReturn(produitPharmaceutique1);
        when(produitPharmaceutiqueRepository.findById((Long) any())).thenReturn(ofResult);

        Famille famille2 = new Famille();
        famille2.setId_famille(1L);
        famille2.setLib_famille("Lib famille");
        famille2.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire2 = new Laboratoire();
        laboratoire2.setId_labo(1L);
        laboratoire2.setLib_labo("Lib labo");
        laboratoire2.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique2 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique2.setDateAjout_prd(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique2.setDescription_prd("Description prd");
        produitPharmaceutique2.setFactureAchats(new ArrayList<>());
        produitPharmaceutique2.setFamille(famille2);
        produitPharmaceutique2.setFournisseurs(new ArrayList<>());
        produitPharmaceutique2.setId_prd(1L);
        produitPharmaceutique2.setLaboratoire(laboratoire2);
        produitPharmaceutique2.setLib_prd("Lib prd");
        produitPharmaceutique2.setPrix_livr(10.0f);
        produitPharmaceutique2.setPrix_prd(10.0d);
        assertSame(produitPharmaceutique1,
                produitPharmaceutiqueService.updateProduitPharmaceutique(123L, produitPharmaceutique2));
        verify(produitPharmaceutiqueRepository).save((ProduitPharmaceutique) any());
        verify(produitPharmaceutiqueRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#updateProduitPharmaceutique(Long, ProduitPharmaceutique)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateProduitPharmaceutique2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.ProduitPharmaceutiqueService.updateProduitPharmaceutique(ProduitPharmaceutiqueService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);
        when(produitPharmaceutiqueRepository.save((ProduitPharmaceutique) any())).thenReturn(produitPharmaceutique);
        when(produitPharmaceutiqueRepository.findById((Long) any())).thenReturn(Optional.empty());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique1.setDateAjout_prd(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique1.setDescription_prd("Description prd");
        produitPharmaceutique1.setFactureAchats(new ArrayList<>());
        produitPharmaceutique1.setFamille(famille1);
        produitPharmaceutique1.setFournisseurs(new ArrayList<>());
        produitPharmaceutique1.setId_prd(1L);
        produitPharmaceutique1.setLaboratoire(laboratoire1);
        produitPharmaceutique1.setLib_prd("Lib prd");
        produitPharmaceutique1.setPrix_livr(10.0f);
        produitPharmaceutique1.setPrix_prd(10.0d);
        produitPharmaceutiqueService.updateProduitPharmaceutique(123L, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#produitExist(Long)}
     */
    @Test
    void testProduitExist() {
        when(produitPharmaceutiqueRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(produitPharmaceutiqueService.produitExist(123L));
        verify(produitPharmaceutiqueRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#produitExist(Long)}
     */
    @Test
    void testProduitExist2() {
        when(produitPharmaceutiqueRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(produitPharmaceutiqueService.produitExist(123L));
        verify(produitPharmaceutiqueRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueByFamille(Long)}
     */
    @Test
    void testFindProduitPharmaceutiqueByFamille() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        when(produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFamille((Long) any()))
                .thenReturn(produitPharmaceutiqueList);
        List<ProduitPharmaceutique> actualFindProduitPharmaceutiqueByFamilleResult = produitPharmaceutiqueService
                .findProduitPharmaceutiqueByFamille(1L);
        assertSame(produitPharmaceutiqueList, actualFindProduitPharmaceutiqueByFamilleResult);
        assertTrue(actualFindProduitPharmaceutiqueByFamilleResult.isEmpty());
        verify(produitPharmaceutiqueRepository).findProduitPharmaceutiqueByFamille((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueByLabo(Long)}
     */
    @Test
    void testFindProduitPharmaceutiqueByLabo() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        when(produitPharmaceutiqueRepository.findProduitPharmaceutiqueByLabo((Long) any()))
                .thenReturn(produitPharmaceutiqueList);
        List<ProduitPharmaceutique> actualFindProduitPharmaceutiqueByLaboResult = produitPharmaceutiqueService
                .findProduitPharmaceutiqueByLabo(1L);
        assertSame(produitPharmaceutiqueList, actualFindProduitPharmaceutiqueByLaboResult);
        assertTrue(actualFindProduitPharmaceutiqueByLaboResult.isEmpty());
        verify(produitPharmaceutiqueRepository).findProduitPharmaceutiqueByLabo((Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueByFamilleAndLabo(Long, Long)}
     */
    @Test
    void testFindProduitPharmaceutiqueByFamilleAndLabo() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        when(produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFamilleAndLabo((Long) any(), (Long) any()))
                .thenReturn(produitPharmaceutiqueList);
        List<ProduitPharmaceutique> actualFindProduitPharmaceutiqueByFamilleAndLaboResult = produitPharmaceutiqueService
                .findProduitPharmaceutiqueByFamilleAndLabo(1L, 1L);
        assertSame(produitPharmaceutiqueList, actualFindProduitPharmaceutiqueByFamilleAndLaboResult);
        assertTrue(actualFindProduitPharmaceutiqueByFamilleAndLaboResult.isEmpty());
        verify(produitPharmaceutiqueRepository).findProduitPharmaceutiqueByFamilleAndLabo((Long) any(), (Long) any());
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueService#findProduitPharmaceutiqueByFournisseur(Long)}
     */
    @Test
    void testFindProduitPharmaceutiqueByFournisseur() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        when(produitPharmaceutiqueRepository.findProduitPharmaceutiqueByFournisseur((Long) any()))
                .thenReturn(produitPharmaceutiqueList);
        List<ProduitPharmaceutique> actualFindProduitPharmaceutiqueByFournisseurResult = produitPharmaceutiqueService
                .findProduitPharmaceutiqueByFournisseur(1L);
        assertSame(produitPharmaceutiqueList, actualFindProduitPharmaceutiqueByFournisseurResult);
        assertTrue(actualFindProduitPharmaceutiqueByFournisseurResult.isEmpty());
        verify(produitPharmaceutiqueRepository).findProduitPharmaceutiqueByFournisseur((Long) any());
    }
}

