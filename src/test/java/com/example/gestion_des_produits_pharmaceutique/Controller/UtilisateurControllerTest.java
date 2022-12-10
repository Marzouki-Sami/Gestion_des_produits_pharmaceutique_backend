package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Utilisateur;
import com.example.gestion_des_produits_pharmaceutique.Services.UtilisateurService;
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

@ContextConfiguration(classes = {UtilisateurController.class})
@ExtendWith(SpringExtension.class)
class UtilisateurControllerTest {
    @Autowired
    private UtilisateurController utilisateurController;

    @MockBean
    private UtilisateurService utilisateurService;

    /**
     * Method under test: {@link UtilisateurController#getAllUtilisateurs()}
     */
    @Test
    void testGetAllUtilisateurs() throws Exception {
        when(utilisateurService.getAllUtilisateurs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/utilisateur/all");
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UtilisateurController#getAllUtilisateurs()}
     */
    @Test
    void testGetAllUtilisateurs2() throws Exception {
        when(utilisateurService.getAllUtilisateurs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/utilisateur/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UtilisateurController#getUtilisateurById(Long)}
     */
    @Test
    void testGetUtilisateurById() throws Exception {
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
        when(utilisateurService.getUtilisateurById((Long) any())).thenReturn(utilisateur);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/utilisateur/findutilisateur/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_util\":1,\"nom_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse_util\":\"Adresse util\",\"email"
                                        + "_util\":\"jane.doe@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0}"));
    }

    /**
     * Method under test: {@link UtilisateurController#saveUtilisateur(Utilisateur)}
     */
    @Test
    void testSaveUtilisateur() throws Exception {
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
        when(utilisateurService.saveUtilisateur((Utilisateur) any())).thenReturn(utilisateur);

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
        String content = (new ObjectMapper()).writeValueAsString(utilisateur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/utilisateur/saveutilisateur")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_util\":1,\"nom_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse_util\":\"Adresse util\",\"email"
                                        + "_util\":\"jane.doe@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0}"));
    }

    /**
     * Method under test: {@link UtilisateurController#updateUtilisateurById(Long, Utilisateur)}
     */
    @Test
    void testUpdateUtilisateurById() throws Exception {
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
        when(utilisateurService.updateUtilisateurById((Long) any(), (Utilisateur) any())).thenReturn(utilisateur);
        when(utilisateurService.existeUtilisateur((Long) any())).thenReturn(true);

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
        String content = (new ObjectMapper()).writeValueAsString(utilisateur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/utilisateur/updateutilisateur/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_util\":1,\"nom_util\":\"Nom util\",\"prenom_util\":\"Prenom util\",\"adresse_util\":\"Adresse util\",\"email"
                                        + "_util\":\"jane.doe@example.org\",\"codePostal_util\":1,\"dateNaissance_util\":0}"));
    }

    /**
     * Method under test: {@link UtilisateurController#updateUtilisateurById(Long, Utilisateur)}
     */
    @Test
    void testUpdateUtilisateurById2() throws Exception {
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
        when(utilisateurService.updateUtilisateurById((Long) any(), (Utilisateur) any())).thenReturn(utilisateur);
        when(utilisateurService.existeUtilisateur((Long) any())).thenReturn(false);

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
        String content = (new ObjectMapper()).writeValueAsString(utilisateur1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/utilisateur/updateutilisateur/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Utilisateur n'existe pas"));
    }

    /**
     * Method under test: {@link UtilisateurController#deleteUtilisateur(Long)}
     */
    @Test
    void testDeleteUtilisateur() throws Exception {
        doNothing().when(utilisateurService).deleteUtilisateur((Long) any());
        when(utilisateurService.existeUtilisateur((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/utilisateur/deleteutilisateur/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Utilisateur supprimé"));
    }

    /**
     * Method under test: {@link UtilisateurController#deleteUtilisateur(Long)}
     */
    @Test
    void testDeleteUtilisateur2() throws Exception {
        doNothing().when(utilisateurService).deleteUtilisateur((Long) any());
        when(utilisateurService.existeUtilisateur((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/utilisateur/deleteutilisateur/{id}", 123L);
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Utilisateur n'existe pas"));
    }

    /**
     * Method under test: {@link UtilisateurController#deleteUtilisateur(Long)}
     */
    @Test
    void testDeleteUtilisateur3() throws Exception {
        doNothing().when(utilisateurService).deleteUtilisateur((Long) any());
        when(utilisateurService.existeUtilisateur((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/utilisateur/deleteutilisateur/{id}",
                123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(utilisateurController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Utilisateur supprimé"));
    }
}

