package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Fournisseur;
import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Services.FournisseurService;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {FournisseurController.class})
@ExtendWith(SpringExtension.class)
class FournisseurControllerTest {
    @Autowired
    private FournisseurController fournisseurController;

    @MockBean
    private FournisseurService fournisseurService;

    /**
     * Method under test: {@link FournisseurController#getAllFournisseur()}
     */
    @Test
    void testGetAllFournisseur() throws Exception {
        when(fournisseurService.getAllFournisseur()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fournisseur/all");
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FournisseurController#getAllFournisseur()}
     */
    @Test
    void testGetAllFournisseur2() throws Exception {
        when(fournisseurService.getAllFournisseur()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/fournisseur/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FournisseurController#saveFournisseur(Fournisseur)}
     */
    @Test
    void testSaveFournisseur() throws Exception {
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
        when(fournisseurService.saveFournisseur((Fournisseur) any())).thenReturn(fournisseur);

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
        String content = (new ObjectMapper()).writeValueAsString(fournisseur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fournisseur/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_four\":1,\"nom_four\":\"Nom four\",\"adresse_four\":\"Adresse four\",\"email_four\":\"jane.doe@example.org\""
                                        + ",\"tel_four\":1,\"utilisateur\":{\"id_util\":1,\"nom_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse"
                                        + "_util\":\"Adresse util\",\"email_util\":\"jane.doe@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0"
                                        + "},\"produitPharmaceutiques\":[]}"));
    }

    /**
     * Method under test: {@link FournisseurController#deleteFournisseurById(Long)}
     */
    @Test
    void testDeleteFournisseurById() throws Exception {
        doNothing().when(fournisseurService).deleteFournisseurById((Long) any());
        when(fournisseurService.existsFournisseurById((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/fournisseur/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Fournisseur deleted"));
    }

    /**
     * Method under test: {@link FournisseurController#deleteFournisseurById(Long)}
     */
    @Test
    void testDeleteFournisseurById2() throws Exception {
        doNothing().when(fournisseurService).deleteFournisseurById((Long) any());
        when(fournisseurService.existsFournisseurById((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/fournisseur/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Fournisseur not found"));
    }

    /**
     * Method under test: {@link FournisseurController#deleteFournisseurById(Long)}
     */
    @Test
    void testDeleteFournisseurById3() throws Exception {
        doNothing().when(fournisseurService).deleteFournisseurById((Long) any());
        when(fournisseurService.existsFournisseurById((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/fournisseur/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Fournisseur deleted"));
    }

    /**
     * Method under test: {@link FournisseurController#findFournisseurById(Long)}
     */
    @Test
    void testFindFournisseurById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/fournisseur/fournisseurbyid");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link FournisseurController#updateFournisseur(Long, Fournisseur)}
     */
    @Test
    void testUpdateFournisseur() throws Exception {
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
        when(fournisseurService.updateFournisseurById((Long) any(), (Fournisseur) any())).thenReturn(fournisseur);
        when(fournisseurService.existsFournisseurById((Long) any())).thenReturn(true);

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
        String content = (new ObjectMapper()).writeValueAsString(fournisseur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/fournisseur/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_four\":1,\"nom_four\":\"Nom four\",\"adresse_four\":\"Adresse four\",\"email_four\":\"jane.doe@example.org\""
                                        + ",\"tel_four\":1,\"utilisateur\":{\"id_util\":1,\"nom_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse"
                                        + "_util\":\"Adresse util\",\"email_util\":\"jane.doe@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0"
                                        + "},\"produitPharmaceutiques\":[]}"));
    }

    /**
     * Method under test: {@link FournisseurController#updateFournisseur(Long, Fournisseur)}
     */
    @Test
    void testUpdateFournisseur2() throws Exception {
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
        when(fournisseurService.updateFournisseurById((Long) any(), (Fournisseur) any())).thenReturn(fournisseur);
        when(fournisseurService.existsFournisseurById((Long) any())).thenReturn(false);

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
        String content = (new ObjectMapper()).writeValueAsString(fournisseur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/fournisseur/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(fournisseurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Fournisseur not found"));
    }
}

