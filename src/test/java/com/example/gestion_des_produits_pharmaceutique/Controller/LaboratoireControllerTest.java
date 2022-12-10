package com.example.gestion_des_produits_pharmaceutique.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire;
import com.example.gestion_des_produits_pharmaceutique.Services.LaboratoireService;
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

@ContextConfiguration(classes = {LaboratoireController.class})
@ExtendWith(SpringExtension.class)
class LaboratoireControllerTest {
    @Autowired
    private LaboratoireController laboratoireController;

    @MockBean
    private LaboratoireService laboratoireService;

    /**
     * Method under test: {@link LaboratoireController#findAllLab()}
     */
    @Test
    void testFindAllLab() throws Exception {
        when(laboratoireService.findAllLab()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/laboratoire/all");
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link LaboratoireController#findAllLab()}
     */
    @Test
    void testFindAllLab2() throws Exception {
        when(laboratoireService.findAllLab()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/laboratoire/all");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link LaboratoireController#findLaboratoireById(Long)}
     */
    @Test
    void testFindLaboratoireById() throws Exception {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireService.findLaboratoireById((Long) any())).thenReturn(laboratoire);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/laboratoire/find/{id}", 123L);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_labo\":1,\"lib_labo\":\"Lib labo\"}"));
    }

    /**
     * Method under test: {@link LaboratoireController#saveLaboratoire(Laboratoire)}
     */
    @Test
    void testSaveLaboratoire() throws Exception {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireService.saveLaboratoire((Laboratoire) any())).thenReturn(laboratoire);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(laboratoire1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/laboratoire/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_labo\":1,\"lib_labo\":\"Lib labo\"}"));
    }

    /**
     * Method under test: {@link LaboratoireController#updateLaboratoireById(Long, Laboratoire)}
     */
    @Test
    void testUpdateLaboratoireById() throws Exception {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireService.updateLaboratoireById((Long) any(), (String) any())).thenReturn(laboratoire);
        when(laboratoireService.LabExiste((Long) any())).thenReturn(true);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(laboratoire1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/laboratoire/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id_labo\":1,\"lib_labo\":\"Lib labo\"}"));
    }

    /**
     * Method under test: {@link LaboratoireController#updateLaboratoireById(Long, Laboratoire)}
     */
    @Test
    void testUpdateLaboratoireById2() throws Exception {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        when(laboratoireService.updateLaboratoireById((Long) any(), (String) any())).thenReturn(laboratoire);
        when(laboratoireService.LabExiste((Long) any())).thenReturn(false);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(laboratoire1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/laboratoire/update/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link LaboratoireController#deleteLaboratoireById(Long)}
     */
    @Test
    void testDeleteLaboratoireById() throws Exception {
        doNothing().when(laboratoireService).deleteLaboratoireById((Long) any());
        when(laboratoireService.LabExiste((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/laboratoire/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("laboratoire supprimé avec succés"));
    }

    /**
     * Method under test: {@link LaboratoireController#deleteLaboratoireById(Long)}
     */
    @Test
    void testDeleteLaboratoireById2() throws Exception {
        doNothing().when(laboratoireService).deleteLaboratoireById((Long) any());
        when(laboratoireService.LabExiste((Long) any())).thenReturn(false);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/laboratoire/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("il n y a aucun laboratoire existant avec l'id 123"));
    }

    /**
     * Method under test: {@link LaboratoireController#deleteLaboratoireById(Long)}
     */
    @Test
    void testDeleteLaboratoireById3() throws Exception {
        doNothing().when(laboratoireService).deleteLaboratoireById((Long) any());
        when(laboratoireService.LabExiste((Long) any())).thenReturn(true);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/laboratoire/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(laboratoireController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("laboratoire supprimé avec succés"));
    }
}

