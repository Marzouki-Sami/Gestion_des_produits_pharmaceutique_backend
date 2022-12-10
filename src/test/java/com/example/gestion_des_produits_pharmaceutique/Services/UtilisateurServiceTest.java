package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Repository.UtilisateurRepository;

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

@ContextConfiguration(classes = {UtilisateurService.class})
@ExtendWith(SpringExtension.class)
class UtilisateurServiceTest {
    @MockBean
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    /**
     * Method under test: {@link UtilisateurService#getAllUtilisateurs()}
     */
    @Test
    void testGetAllUtilisateurs() {
        ArrayList<Utilisateur> utilisateurList = new ArrayList<>();
        when(utilisateurRepository.findAll()).thenReturn(utilisateurList);
        List<Utilisateur> actualAllUtilisateurs = utilisateurService.getAllUtilisateurs();
        assertSame(utilisateurList, actualAllUtilisateurs);
        assertTrue(actualAllUtilisateurs.isEmpty());
        verify(utilisateurRepository).findAll();
    }

    /**
     * Method under test: {@link UtilisateurService#getUtilisateurById(Long)}
     */
    @Test
    void testGetUtilisateurById() {
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
        Optional<Utilisateur> ofResult = Optional.of(utilisateur);
        when(utilisateurRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(utilisateur, utilisateurService.getUtilisateurById(123L));
        verify(utilisateurRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UtilisateurService#getUtilisateurById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUtilisateurById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.UtilisateurService.getUtilisateurById(UtilisateurService.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        when(utilisateurRepository.findById((Long) any())).thenReturn(Optional.empty());
        utilisateurService.getUtilisateurById(123L);
    }

    /**
     * Method under test: {@link UtilisateurService#saveUtilisateur(Utilisateur)}
     */
    @Test
    void testSaveUtilisateur() {
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
        when(utilisateurRepository.save((Utilisateur) any())).thenReturn(utilisateur);

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
        assertSame(utilisateur, utilisateurService.saveUtilisateur(utilisateur1));
        verify(utilisateurRepository).save((Utilisateur) any());
    }

    /**
     * Method under test: {@link UtilisateurService#deleteUtilisateur(Long)}
     */
    @Test
    void testDeleteUtilisateur() {
        doNothing().when(utilisateurRepository).deleteById((Long) any());
        utilisateurService.deleteUtilisateur(123L);
        verify(utilisateurRepository).deleteById((Long) any());
        assertTrue(utilisateurService.getAllUtilisateurs().isEmpty());
    }

    /**
     * Method under test: {@link UtilisateurService#updateUtilisateurById(Long, Utilisateur)}
     */
    @Test
    void testUpdateUtilisateurById() {
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
        Optional<Utilisateur> ofResult = Optional.of(utilisateur);

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
        when(utilisateurRepository.save((Utilisateur) any())).thenReturn(utilisateur1);
        when(utilisateurRepository.findById((Long) any())).thenReturn(ofResult);

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
        assertSame(utilisateur1, utilisateurService.updateUtilisateurById(123L, utilisateur2));
        verify(utilisateurRepository).save((Utilisateur) any());
        verify(utilisateurRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UtilisateurService#updateUtilisateurById(Long, Utilisateur)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUtilisateurById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.UtilisateurService.updateUtilisateurById(UtilisateurService.java:33)
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
        when(utilisateurRepository.save((Utilisateur) any())).thenReturn(utilisateur);
        when(utilisateurRepository.findById((Long) any())).thenReturn(Optional.empty());

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
        utilisateurService.updateUtilisateurById(123L, utilisateur1);
    }

    /**
     * Method under test: {@link UtilisateurService#existeUtilisateur(Long)}
     */
    @Test
    void testExisteUtilisateur() {
        when(utilisateurRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(utilisateurService.existeUtilisateur(123L));
        verify(utilisateurRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link UtilisateurService#existeUtilisateur(Long)}
     */
    @Test
    void testExisteUtilisateur2() {
        when(utilisateurRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(utilisateurService.existeUtilisateur(123L));
        verify(utilisateurRepository).existsById((Long) any());
    }
}

