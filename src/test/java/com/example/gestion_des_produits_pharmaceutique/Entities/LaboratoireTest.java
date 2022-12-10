package com.example.gestion_des_produits_pharmaceutique.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

class LaboratoireTest {
    /**
     * Method under test: {@link Laboratoire#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Laboratoire()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Laboratoire#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Laboratoire laboratoire = new Laboratoire();

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(3L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertTrue(laboratoire.canEqual(laboratoire1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Laboratoire#Laboratoire()}
     *   <li>{@link Laboratoire#setId_labo(Long)}
     *   <li>{@link Laboratoire#setLib_labo(String)}
     *   <li>{@link Laboratoire#setProduitPharmaceutiques(List)}
     *   <li>{@link Laboratoire#toString()}
     *   <li>{@link Laboratoire#getId_labo()}
     *   <li>{@link Laboratoire#getLib_labo()}
     *   <li>{@link Laboratoire#getProduitPharmaceutiques()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Laboratoire actualLaboratoire = new Laboratoire();
        actualLaboratoire.setId_labo(1L);
        actualLaboratoire.setLib_labo("Lib labo");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        actualLaboratoire.setProduitPharmaceutiques(produitPharmaceutiqueList);
        String actualToStringResult = actualLaboratoire.toString();
        assertEquals(1L, actualLaboratoire.getId_labo().longValue());
        assertEquals("Lib labo", actualLaboratoire.getLib_labo());
        assertSame(produitPharmaceutiqueList, actualLaboratoire.getProduitPharmaceutiques());
        assertEquals("Laboratoire(id_labo=1, lib_labo=Lib labo, produitPharmaceutiques=[])", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Laboratoire#Laboratoire(Long, String, List)}
     *   <li>{@link Laboratoire#setId_labo(Long)}
     *   <li>{@link Laboratoire#setLib_labo(String)}
     *   <li>{@link Laboratoire#setProduitPharmaceutiques(List)}
     *   <li>{@link Laboratoire#toString()}
     *   <li>{@link Laboratoire#getId_labo()}
     *   <li>{@link Laboratoire#getLib_labo()}
     *   <li>{@link Laboratoire#getProduitPharmaceutiques()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        Laboratoire actualLaboratoire = new Laboratoire(1L, "Lib labo", produitPharmaceutiqueList);
        actualLaboratoire.setId_labo(1L);
        actualLaboratoire.setLib_labo("Lib labo");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        actualLaboratoire.setProduitPharmaceutiques(produitPharmaceutiqueList1);
        String actualToStringResult = actualLaboratoire.toString();
        assertEquals(1L, actualLaboratoire.getId_labo().longValue());
        assertEquals("Lib labo", actualLaboratoire.getLib_labo());
        List<ProduitPharmaceutique> produitPharmaceutiques = actualLaboratoire.getProduitPharmaceutiques();
        assertSame(produitPharmaceutiqueList1, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList, produitPharmaceutiques);
        assertEquals("Laboratoire(id_labo=1, lib_labo=Lib labo, produitPharmaceutiques=[])", actualToStringResult);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, null);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals2() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, "Different type to Laboratoire");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Laboratoire#equals(Object)}
     *   <li>{@link Laboratoire#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());
        assertEquals(laboratoire, laboratoire);
        int expectedHashCodeResult = laboratoire.hashCode();
        assertEquals(expectedHashCodeResult, laboratoire.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Laboratoire#equals(Object)}
     *   <li>{@link Laboratoire#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertEquals(laboratoire, laboratoire1);
        int expectedHashCodeResult = laboratoire.hashCode();
        assertEquals(expectedHashCodeResult, laboratoire1.hashCode());
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals5() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(3L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, laboratoire1);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals6() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(null);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, laboratoire1);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals7() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo(null);
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, laboratoire1);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals8() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("com.example.gestion_des_produits_pharmaceutique.Entities.Laboratoire");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire, laboratoire1);
    }

    /**
     * Method under test: {@link Laboratoire#equals(Object)}
     */
    @Test
    void testEquals9() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib labo");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Lib labo");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib labo");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        produitPharmaceutiqueList.add(produitPharmaceutique);

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(produitPharmaceutiqueList);

        Laboratoire laboratoire2 = new Laboratoire();
        laboratoire2.setId_labo(1L);
        laboratoire2.setLib_labo("Lib labo");
        laboratoire2.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(laboratoire1, laboratoire2);
    }
}

