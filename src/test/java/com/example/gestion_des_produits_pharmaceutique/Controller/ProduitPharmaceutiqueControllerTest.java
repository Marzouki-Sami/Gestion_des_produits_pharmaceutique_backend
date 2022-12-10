package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Entities.ProduitPharmaceutique;
import com.example.gestion_des_produits_pharmaceutique.Services.ProduitPharmaceutiqueService;
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

@ContextConfiguration(classes = {ProduitPharmaceutiqueController.class})
@ExtendWith(SpringExtension.class)
class ProduitPharmaceutiqueControllerTest {
    @Autowired
    private ProduitPharmaceutiqueController produitPharmaceutiqueController;

    @MockBean
    private ProduitPharmaceutiqueService produitPharmaceutiqueService;

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#addProduitPharmaceutique(ProduitPharmaceutique)}
     */
    @Test
    void testAddProduitPharmaceutique() throws Exception {
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
        when(produitPharmaceutiqueService.saveProduitPharmaceutique((ProduitPharmaceutique) any()))
                .thenReturn(produitPharmaceutique);

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
        String content = (new ObjectMapper()).writeValueAsString(produitPharmaceutique1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/ProduitPharmaceutique/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_prd\":1,\"prix_prd\":10.0,\"dateAjout_prd\":0,\"prix_livr\":10.0,\"famille\":{\"id_famille\":1,\"lib_famille\":\"Lib"
                                        + " famille\"},\"laboratoire\":{\"id_labo\":1,\"lib_labo\":\"Lib labo\"},\"fournisseurs\":[],\"factureAchats\":[],\"lib"
                                        + "_prd\":\"Lib prd\",\"description_prd\":\"Description prd\"}"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#deleteProduitPharmaceutique(Long)}
     */
    @Test
    void testDeleteProduitPharmaceutique() throws Exception {
        doNothing().when(produitPharmaceutiqueService).deleteProduitPharmaceutique((Long) any());
        when(produitPharmaceutiqueService.produitExist((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/ProduitPharmaceutique/delete/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ProduitPharmaceutique deleted successfully"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#deleteProduitPharmaceutique(Long)}
     */
    @Test
    void testDeleteProduitPharmaceutique2() throws Exception {
        doNothing().when(produitPharmaceutiqueService).deleteProduitPharmaceutique((Long) any());
        when(produitPharmaceutiqueService.produitExist((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/ProduitPharmaceutique/delete/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ProduitPharmaceutique not found"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#deleteProduitPharmaceutique(Long)}
     */
    @Test
    void testDeleteProduitPharmaceutique3() throws Exception {
        doNothing().when(produitPharmaceutiqueService).deleteProduitPharmaceutique((Long) any());
        when(produitPharmaceutiqueService.produitExist((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/ProduitPharmaceutique/delete/{id}",
                123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ProduitPharmaceutique deleted successfully"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#updateProduitPharmaceutique(Long, ProduitPharmaceutique)}
     */
    @Test
    void testUpdateProduitPharmaceutique() throws Exception {
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
        when(produitPharmaceutiqueService.updateProduitPharmaceutique((Long) any(), (ProduitPharmaceutique) any()))
                .thenReturn(produitPharmaceutique);
        when(produitPharmaceutiqueService.produitExist((Long) any())).thenReturn(true);

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
        String content = (new ObjectMapper()).writeValueAsString(produitPharmaceutique1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/ProduitPharmaceutique/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_prd\":1,\"prix_prd\":10.0,\"dateAjout_prd\":0,\"prix_livr\":10.0,\"famille\":{\"id_famille\":1,\"lib_famille\":\"Lib"
                                        + " famille\"},\"laboratoire\":{\"id_labo\":1,\"lib_labo\":\"Lib labo\"},\"fournisseurs\":[],\"factureAchats\":[],\"lib"
                                        + "_prd\":\"Lib prd\",\"description_prd\":\"Description prd\"}"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#updateProduitPharmaceutique(Long, ProduitPharmaceutique)}
     */
    @Test
    void testUpdateProduitPharmaceutique2() throws Exception {
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
        when(produitPharmaceutiqueService.updateProduitPharmaceutique((Long) any(), (ProduitPharmaceutique) any()))
                .thenReturn(produitPharmaceutique);
        when(produitPharmaceutiqueService.produitExist((Long) any())).thenReturn(false);

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
        String content = (new ObjectMapper()).writeValueAsString(produitPharmaceutique1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/ProduitPharmaceutique/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ProduitPharmaceutique not found"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getAllProduitPharmaceutique()}
     */
    @Test
    void testGetAllProduitPharmaceutique() throws Exception {
        when(produitPharmaceutiqueService.findAllProduitPharmaceutique()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ProduitPharmaceutique/all");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getAllProduitPharmaceutique()}
     */
    @Test
    void testGetAllProduitPharmaceutique2() throws Exception {
        when(produitPharmaceutiqueService.findAllProduitPharmaceutique()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/ProduitPharmaceutique/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFamille(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFamille() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFamille((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfamille/{idFamille}", 1L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFamille(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFamille2() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFamille((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfamille/{idFamille}", 1L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFamilleAndLabo(Long, Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFamilleAndLabo() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFamilleAndLabo((Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfamilleandlabo/{idFamille}/{idLabo}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFamilleAndLabo(Long, Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFamilleAndLabo2() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFamilleAndLabo((Long) any(), (Long) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfamilleandlabo/{idFamille}/{idLabo}", 1L, 1L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFournisseur(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFournisseur() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFournisseur((Long) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfournisseur/{idFournisseur}", 1L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByFournisseur(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByFournisseur2() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByFournisseur((Long) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbyfournisseur/{idFournisseur}", 1L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueById(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueById() throws Exception {
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
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueById((Long) any())).thenReturn(produitPharmaceutique);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/ProduitPharmaceutique/find/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_prd\":1,\"prix_prd\":10.0,\"dateAjout_prd\":0,\"prix_livr\":10.0,\"famille\":{\"id_famille\":1,\"lib_famille\":\"Lib"
                                        + " famille\"},\"laboratoire\":{\"id_labo\":1,\"lib_labo\":\"Lib labo\"},\"fournisseurs\":[],\"factureAchats\":[],\"lib"
                                        + "_prd\":\"Lib prd\",\"description_prd\":\"Description prd\"}"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByLabo(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByLabo() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByLabo((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/ProduitPharmaceutique/findbylabo/{idLabo}", 1L);
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ProduitPharmaceutiqueController#getProduitPharmaceutiqueByLabo(Long)}
     */
    @Test
    void testGetProduitPharmaceutiqueByLabo2() throws Exception {
        when(produitPharmaceutiqueService.findProduitPharmaceutiqueByLabo((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/ProduitPharmaceutique/findbylabo/{idLabo}",
                1L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(produitPharmaceutiqueController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

