package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Repository.LaboratoireRepository;

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

@ContextConfiguration(classes = {LaboratoireService.class})
@ExtendWith(SpringExtension.class)
class LaboratoireServiceTest {
    @MockBean
    private LaboratoireRepository laboratoireRepository;

    @Autowired
    private LaboratoireService laboratoireService;

    /**
     * Method under test: {@link LaboratoireService#saveLaboratoire(Laboratoire)}
     */
    @Test
    void testSaveLaboratoire() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireRepository.save((Laboratoire) any())).thenReturn(laboratoire);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertSame(laboratoire, laboratoireService.saveLaboratoire(laboratoire1));
        verify(laboratoireRepository).save((Laboratoire) any());
    }

    /**
     * Method under test: {@link LaboratoireService#updateLaboratoireById(Long, String)}
     */
    @Test
    void testUpdateLaboratoireById() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        Optional<Laboratoire> ofResult = Optional.of(laboratoire);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireRepository.save((Laboratoire) any())).thenReturn(laboratoire1);
        when(laboratoireRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(laboratoire1, laboratoireService.updateLaboratoireById(123L, "Lib labo"));
        verify(laboratoireRepository).save((Laboratoire) any());
        verify(laboratoireRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link LaboratoireService#updateLaboratoireById(Long, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateLaboratoireById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.LaboratoireService.updateLaboratoireById(LaboratoireService.java:22)
        //   See https://diff.blue/R013 to resolve this issue.

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireRepository.save((Laboratoire) any())).thenReturn(laboratoire);
        when(laboratoireRepository.findById((Long) any())).thenReturn(Optional.empty());
        laboratoireService.updateLaboratoireById(123L, "Lib labo");
    }

    /**
     * Method under test: {@link LaboratoireService#deleteLaboratoireById(Long)}
     */
    @Test
    void testDeleteLaboratoireById() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        Optional<Laboratoire> ofResult = Optional.of(laboratoire);
        doNothing().when(laboratoireRepository).delete((Laboratoire) any());
        when(laboratoireRepository.findById((Long) any())).thenReturn(ofResult);
        laboratoireService.deleteLaboratoireById(123L);
        verify(laboratoireRepository).findById((Long) any());
        verify(laboratoireRepository).delete((Laboratoire) any());
        assertTrue(laboratoireService.findAllLab().isEmpty());
    }

    /**
     * Method under test: {@link LaboratoireService#deleteLaboratoireById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteLaboratoireById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.LaboratoireService.deleteLaboratoireById(LaboratoireService.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(laboratoireRepository).delete((Laboratoire) any());
        when(laboratoireRepository.findById((Long) any())).thenReturn(Optional.empty());
        laboratoireService.deleteLaboratoireById(123L);
    }

    /**
     * Method under test: {@link LaboratoireService#findAllLab()}
     */
    @Test
    void testFindAllLab() {
        ArrayList<Laboratoire> laboratoireList = new ArrayList<>();
        when(laboratoireRepository.findAll()).thenReturn(laboratoireList);
        List<Laboratoire> actualFindAllLabResult = laboratoireService.findAllLab();
        assertSame(laboratoireList, actualFindAllLabResult);
        assertTrue(actualFindAllLabResult.isEmpty());
        verify(laboratoireRepository).findAll();
    }

    /**
     * Method under test: {@link LaboratoireService#findLaboratoireById(Long)}
     */
    @Test
    void testFindLaboratoireById() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        Optional<Laboratoire> ofResult = Optional.of(laboratoire);
        when(laboratoireRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(laboratoire, laboratoireService.findLaboratoireById(123L));
        verify(laboratoireRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link LaboratoireService#findLaboratoireById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindLaboratoireById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.LaboratoireService.findLaboratoireById(LaboratoireService.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        when(laboratoireRepository.findById((Long) any())).thenReturn(Optional.empty());
        laboratoireService.findLaboratoireById(123L);
    }

    /**
     * Method under test: {@link LaboratoireService#LabExiste(Long)}
     */
    @Test
    void testLabExiste() {
        when(laboratoireRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(laboratoireService.LabExiste(123L));
        verify(laboratoireRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link LaboratoireService#LabExiste(Long)}
     */
    @Test
    void testLabExiste2() {
        when(laboratoireRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(laboratoireService.LabExiste(123L));
        verify(laboratoireRepository).existsById((Long) any());
    }
}

