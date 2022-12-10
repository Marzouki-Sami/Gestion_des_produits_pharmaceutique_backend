package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Repository.FournisseurRepository;

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

@ContextConfiguration(classes = {FournisseurService.class})
@ExtendWith(SpringExtension.class)
class FournisseurServiceTest {
    @MockBean
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FournisseurService fournisseurService;

    /**
     * Method under test: {@link FournisseurService#getAllFournisseur()}
     */
    @Test
    void testGetAllFournisseur() {
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> actualAllFournisseur = fournisseurService.getAllFournisseur();
        assertSame(fournisseurList, actualAllFournisseur);
        assertTrue(actualAllFournisseur.isEmpty());
        verify(fournisseurRepository).findAll();
    }

    /**
     * Method under test: {@link FournisseurService#findFournisseurById(Long)}
     */
    @Test
    void testFindFournisseurById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        Optional<Fournisseur> ofResult = Optional.of(fournisseur);
        when(fournisseurRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(fournisseur, fournisseurService.findFournisseurById(123L));
        verify(fournisseurRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link FournisseurService#findFournisseurById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindFournisseurById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.FournisseurService.findFournisseurById(FournisseurService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        when(fournisseurRepository.findById((Long) any())).thenReturn(Optional.empty());
        fournisseurService.findFournisseurById(123L);
    }

    /**
     * Method under test: {@link FournisseurService#saveFournisseur(Fournisseur)}
     */
    @Test
    void testSaveFournisseur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        when(fournisseurRepository.save((Fournisseur) any())).thenReturn(fournisseur);

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(new ArrayList<>());
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");

        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setAdresse_four("Adresse four");
        fournisseur1.setEmail_four("jane.doe@example.org");
        fournisseur1.setFactureAchats(new ArrayList<>());
        fournisseur1.setId_four(1L);
        fournisseur1.setNom_four("Nom four");
        fournisseur1.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur1.setTel_four(1);
        fournisseur1.setUtilisateur(utilisateur1);
        assertSame(fournisseur, fournisseurService.saveFournisseur(fournisseur1));
        verify(fournisseurRepository).save((Fournisseur) any());
    }

    /**
     * Method under test: {@link FournisseurService#deleteFournisseurById(Long)}
     */
    @Test
    void testDeleteFournisseurById() {
        doNothing().when(fournisseurRepository).deleteById((Long) any());
        fournisseurService.deleteFournisseurById(123L);
        verify(fournisseurRepository).deleteById((Long) any());
        assertTrue(fournisseurService.getAllFournisseur().isEmpty());
    }

    /**
     * Method under test: {@link FournisseurService#updateFournisseurById(Long, Fournisseur)}
     */
    @Test
    void testUpdateFournisseurById() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        Optional<Fournisseur> ofResult = Optional.of(fournisseur);

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(new ArrayList<>());
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");

        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setAdresse_four("Adresse four");
        fournisseur1.setEmail_four("jane.doe@example.org");
        fournisseur1.setFactureAchats(new ArrayList<>());
        fournisseur1.setId_four(1L);
        fournisseur1.setNom_four("Nom four");
        fournisseur1.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur1.setTel_four(1);
        fournisseur1.setUtilisateur(utilisateur1);
        when(fournisseurRepository.save((Fournisseur) any())).thenReturn(fournisseur1);
        when(fournisseurRepository.findById((Long) any())).thenReturn(ofResult);

        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setAdresse_util("Adresse util");
        utilisateur2.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur2.setDateNaissance_util(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur2.setEmail_util("jane.doe@example.org");
        utilisateur2.setFournisseurs(new ArrayList<>());
        utilisateur2.setId_util(1L);
        utilisateur2.setNom_util("Nom util");
        utilisateur2.setPrenom_util("Prenom util");

        Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setAdresse_four("Adresse four");
        fournisseur2.setEmail_four("jane.doe@example.org");
        fournisseur2.setFactureAchats(new ArrayList<>());
        fournisseur2.setId_four(1L);
        fournisseur2.setNom_four("Nom four");
        fournisseur2.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur2.setTel_four(1);
        fournisseur2.setUtilisateur(utilisateur2);
        assertSame(fournisseur1, fournisseurService.updateFournisseurById(123L, fournisseur2));
        verify(fournisseurRepository).save((Fournisseur) any());
        verify(fournisseurRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link FournisseurService#updateFournisseurById(Long, Fournisseur)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateFournisseurById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.FournisseurService.updateFournisseurById(FournisseurService.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        when(fournisseurRepository.save((Fournisseur) any())).thenReturn(fournisseur);
        when(fournisseurRepository.findById((Long) any())).thenReturn(Optional.empty());

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(new ArrayList<>());
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");

        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setAdresse_four("Adresse four");
        fournisseur1.setEmail_four("jane.doe@example.org");
        fournisseur1.setFactureAchats(new ArrayList<>());
        fournisseur1.setId_four(1L);
        fournisseur1.setNom_four("Nom four");
        fournisseur1.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur1.setTel_four(1);
        fournisseur1.setUtilisateur(utilisateur1);
        fournisseurService.updateFournisseurById(123L, fournisseur1);
    }

    /**
     * Method under test: {@link FournisseurService#existsFournisseurById(Long)}
     */
    @Test
    void testExistsFournisseurById() {
        when(fournisseurRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(fournisseurService.existsFournisseurById(123L));
        verify(fournisseurRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link FournisseurService#existsFournisseurById(Long)}
     */
    @Test
    void testExistsFournisseurById2() {
        when(fournisseurRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(fournisseurService.existsFournisseurById(123L));
        verify(fournisseurRepository).existsById((Long) any());
    }
}

