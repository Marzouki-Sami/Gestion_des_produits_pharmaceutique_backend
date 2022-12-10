package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Repository.FamilleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FamilleService.class})
@ExtendWith(SpringExtension.class)
class FamilleServiceTest {
    @MockBean
    private FamilleRepository familleRepository;

    @Autowired
    private FamilleService familleService;

    /**
     * Method under test: {@link FamilleService#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Famille> familleList = new ArrayList<>();
        when(familleRepository.findAll()).thenReturn(familleList);
        List<Famille> actualFindAllResult = familleService.findAll();
        assertSame(familleList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(familleRepository).findAll();
    }

    /**
     * Method under test: {@link FamilleService#saveFamille(Famille)}
     */
    @Test
    void testSaveFamille() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleRepository.save((Famille) any())).thenReturn(famille);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertSame(famille, familleService.saveFamille(famille1));
        verify(familleRepository).save((Famille) any());
    }

    /**
     * Method under test: {@link FamilleService#updateFamilleById(Long, Famille)}
     */
    @Test
    void testUpdateFamilleById() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        Optional<Famille> ofResult = Optional.of(famille);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        when(familleRepository.save((Famille) any())).thenReturn(famille1);
        when(familleRepository.findById((Long) any())).thenReturn(ofResult);

        Famille famille2 = new Famille();
        famille2.setId_famille(1L);
        famille2.setLib_famille("Lib famille");
        famille2.setProduitPharmaceutiques(new ArrayList<>());
        assertSame(famille1, familleService.updateFamilleById(123L, famille2));
        verify(familleRepository).save((Famille) any());
        verify(familleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link FamilleService#updateFamilleById(Long, Famille)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateFamilleById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.FamilleService.updateFamilleById(FamilleService.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleRepository.save((Famille) any())).thenReturn(famille);
        when(familleRepository.findById((Long) any())).thenReturn(Optional.empty());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        familleService.updateFamilleById(123L, famille1);
    }

    /**
     * Method under test: {@link FamilleService#deleteFamilleById(Long)}
     */
    @Test
    void testDeleteFamilleById() {
        doNothing().when(familleRepository).deleteById((Long) any());
        familleService.deleteFamilleById(123L);
        verify(familleRepository).deleteById((Long) any());
        assertTrue(familleService.findAll().isEmpty());
    }

    /**
     * Method under test: {@link FamilleService#findFamilleById(Long)}
     */
    @Test
    void testFindFamilleById() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        Optional<Famille> ofResult = Optional.of(famille);
        when(familleRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(famille, familleService.findFamilleById(123L));
        verify(familleRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link FamilleService#findFamilleById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFamilleById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.FamilleService.findFamilleById(FamilleService.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        when(familleRepository.findById((Long) any())).thenReturn(Optional.empty());
        familleService.findFamilleById(123L);
    }

    /**
     * Method under test: {@link FamilleService#existFamille(Long)}
     */
    @Test
    void testExistFamille() {
        when(familleRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(familleService.existFamille(123L));
        verify(familleRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link FamilleService#existFamille(Long)}
     */
    @Test
    void testExistFamille2() {
        when(familleRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(familleService.existFamille(123L));
        verify(familleRepository).existsById((Long) any());
    }
}

