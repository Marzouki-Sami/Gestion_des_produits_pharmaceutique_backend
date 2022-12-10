package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.FactureAchat;
import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Services.FactureAchatService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FactureAchatController.class})
@ExtendWith(SpringExtension.class)
class FactureAchatControllerTest {
    @Autowired
    private FactureAchatController factureAchatController;

    @MockBean
    private FactureAchatService factureAchatService;

    /**
     * Method under test: {@link FactureAchatController#addFactureAchat(FactureAchat)}
     */
    @Test
    void testAddFactureAchat() throws Exception {
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
        when(factureAchatService.addFactureAchat((FactureAchat) any())).thenReturn(factureAchat);

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
        String content = (new ObjectMapper()).writeValueAsString(factureAchat1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/factureAchat/addFactureAchat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(factureAchatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_facture_Achat\":1,\"date_facture_Achat\":0,\"fournisseur\":{\"id_four\":1,\"nom_four\":\"Nom four\",\"adresse"
                                        + "_four\":\"Adresse four\",\"email_four\":\"jane.doe@example.org\",\"tel_four\":1,\"utilisateur\":{\"id_util\":1,\"nom"
                                        + "_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse_util\":\"Adresse util\",\"email_util\":\"jane.doe"
                                        + "@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0},\"produitPharmaceutiques\":[]},\"produitPharm"
                                        + "aceutiques\":[],\"total_TVA\":10.0,\"total_HT\":10.0,\"total_TTC\":10.0}"));
    }

    /**
     * Method under test: {@link FactureAchatController#ImprimerFactureAchat(Long)}
     */
    @Test
    void testImprimerFactureAchat() throws Exception {
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
        when(factureAchatService.ImprimerFactureAchat((Long) any())).thenReturn(factureAchat);
        when(factureAchatService.existeFactureAchat((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/factureAchat/ImprimerFactureAchat/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(factureAchatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_facture_Achat\":1,\"date_facture_Achat\":0,\"fournisseur\":{\"id_four\":1,\"nom_four\":\"Nom four\",\"adresse"
                                        + "_four\":\"Adresse four\",\"email_four\":\"jane.doe@example.org\",\"tel_four\":1,\"utilisateur\":{\"id_util\":1,\"nom"
                                        + "_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse_util\":\"Adresse util\",\"email_util\":\"jane.doe"
                                        + "@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0},\"produitPharmaceutiques\":[]},\"produitPharm"
                                        + "aceutiques\":[],\"total_TVA\":10.0,\"total_HT\":10.0,\"total_TTC\":10.0}"));
    }

    /**
     * Method under test: {@link FactureAchatController#ImprimerFactureAchat(Long)}
     */
    @Test
    void testImprimerFactureAchat2() throws Exception {
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
        when(factureAchatService.ImprimerFactureAchat((Long) any())).thenReturn(factureAchat);
        when(factureAchatService.existeFactureAchat((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/factureAchat/ImprimerFactureAchat/{id}", 123L);
        MockMvcBuilders.standaloneSetup(factureAchatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Facture Achat n'existe pas"));
    }
}

