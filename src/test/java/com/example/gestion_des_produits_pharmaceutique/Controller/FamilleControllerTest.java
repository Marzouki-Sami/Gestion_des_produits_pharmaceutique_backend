package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Famille;
import com.example.gestion_des_produits_pharmaceutique.Services.FamilleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {FamilleController.class})
@ExtendWith(SpringExtension.class)
class FamilleControllerTest {
    @Autowired
    private FamilleController familleController;

    @MockBean
    private FamilleService familleService;

    /**
     * Method under test: {@link FamilleController#findFamilleById(Long)}
     */
    @Test
    void testFindFamilleById() throws Exception {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleService.findFamilleById((Long) any())).thenReturn(famille);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/famille/find/{id}", 123L);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_famille\":1,\"lib_famille\":\"Lib famille\"}"));
    }

    /**
     * Method under test: {@link FamilleController#saveFamille(Famille)}
     */
    @Test
    void testSaveFamille() throws Exception {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleService.saveFamille((Famille) any())).thenReturn(famille);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(famille1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/famille/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_famille\":1,\"lib_famille\":\"Lib famille\"}"));
    }

    /**
     * Method under test: {@link FamilleController#updateFamilleById(Long, Famille)}
     */
    @Test
    void testUpdateFamilleById() throws Exception {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleService.updateFamilleById((Long) any(), (Famille) any())).thenReturn(famille);
        when(familleService.existFamille((Long) any())).thenReturn(true);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(famille1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/famille/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_famille\":1,\"lib_famille\":\"Lib famille\"}"));
    }

    /**
     * Method under test: {@link FamilleController#updateFamilleById(Long, Famille)}
     */
    @Test
    void testUpdateFamilleById2() throws Exception {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        when(familleService.updateFamilleById((Long) any(), (Famille) any())).thenReturn(famille);
        when(familleService.existFamille((Long) any())).thenReturn(false);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(famille1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/famille/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FamilleController#deleteFamilleById(Long)}
     */
    @Test
    void testDeleteFamilleById() throws Exception {
        doNothing().when(familleService).deleteFamilleById((Long) any());
        when(familleService.existFamille((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/famille/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("famille supprimé avec succés"));
    }

    /**
     * Method under test: {@link FamilleController#deleteFamilleById(Long)}
     */
    @Test
    void testDeleteFamilleById2() throws Exception {
        doNothing().when(familleService).deleteFamilleById((Long) any());
        when(familleService.existFamille((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/famille/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link FamilleController#deleteFamilleById(Long)}
     */
    @Test
    void testDeleteFamilleById3() throws Exception {
        doNothing().when(familleService).deleteFamilleById((Long) any());
        when(familleService.existFamille((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/famille/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("famille supprimé avec succés"));
    }

    /**
     * Method under test: {@link FamilleController#getAllFamille()}
     */
    @Test
    void testGetAllFamille() throws Exception {
        when(familleService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/famille/all");
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link FamilleController#getAllFamille()}
     */
    @Test
    void testGetAllFamille2() throws Exception {
        when(familleService.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/famille/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(familleController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

