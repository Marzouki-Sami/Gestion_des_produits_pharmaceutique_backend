package com.example.gestion_des_produits_pharmaceutique.Services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.FactureAchat;
import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Repository.FactureAchatRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FactureAchatService.class})
@ExtendWith(SpringExtension.class)
class FactureAchatServiceTest {
    @MockBean
    private FactureAchatRepository factureAchatRepository;

    @Autowired
    private FactureAchatService factureAchatService;

    /**
     * Method under test: {@link FactureAchatService#addFactureAchat(FactureAchat)}
     */
    @Test
    void testAddFactureAchat() {
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

        FactureAchat factureAchat = new FactureAchat();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        factureAchat.setDate_facture_Achat(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        factureAchat.setFournisseur(fournisseur);
        factureAchat.setId_facture_Achat(1L);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);
        when(factureAchatRepository.save((FactureAchat) any())).thenReturn(factureAchat);

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
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

        FactureAchat factureAchat1 = new FactureAchat();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        factureAchat1.setDate_facture_Achat(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        factureAchat1.setFournisseur(fournisseur1);
        factureAchat1.setId_facture_Achat(1L);
        factureAchat1.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat1.setTotal_HT(10.0d);
        factureAchat1.setTotal_TTC(10.0d);
        factureAchat1.setTotal_TVA(10.0d);
        assertSame(factureAchat, factureAchatService.addFactureAchat(factureAchat1));
        verify(factureAchatRepository).save((FactureAchat) any());
    }

    /**
     * Method under test: {@link FactureAchatService#ImprimerFactureAchat(Long)}
     */
    @Test
    void testImprimerFactureAchat() {
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

        FactureAchat factureAchat = new FactureAchat();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        factureAchat.setDate_facture_Achat(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        factureAchat.setFournisseur(fournisseur);
        factureAchat.setId_facture_Achat(1L);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);
        Optional<FactureAchat> ofResult = Optional.of(factureAchat);
        when(factureAchatRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(factureAchat, factureAchatService.ImprimerFactureAchat(123L));
        verify(factureAchatRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link FactureAchatService#ImprimerFactureAchat(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testImprimerFactureAchat2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at com.example.gestion_des_produits_pharmaceutique.Services.FactureAchatService.ImprimerFactureAchat(FactureAchatService.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        when(factureAchatRepository.findById((Long) any())).thenReturn(Optional.empty());
        factureAchatService.ImprimerFactureAchat(123L);
    }

    /**
     * Method under test: {@link FactureAchatService#existeFactureAchat(Long)}
     */
    @Test
    void testExisteFactureAchat() {
        when(factureAchatRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(factureAchatService.existeFactureAchat(123L));
        verify(factureAchatRepository).existsById((Long) any());
    }

    /**
     * Method under test: {@link FactureAchatService#existeFactureAchat(Long)}
     */
    @Test
    void testExisteFactureAchat2() {
        when(factureAchatRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(factureAchatService.existeFactureAchat(123L));
        verify(factureAchatRepository).existsById((Long) any());
    }
}

