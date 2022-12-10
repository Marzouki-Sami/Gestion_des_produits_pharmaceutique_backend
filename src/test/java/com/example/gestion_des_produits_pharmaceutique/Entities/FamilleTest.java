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

class FamilleTest {
    /**
     * Method under test: {@link Famille#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Famille()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Famille#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Famille famille = new Famille();

        Famille famille1 = new Famille();
        famille1.setId_famille(3L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertTrue(famille.canEqual(famille1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Famille#Famille()}
     *   <li>{@link Famille#setId_famille(Long)}
     *   <li>{@link Famille#setLib_famille(String)}
     *   <li>{@link Famille#setProduitPharmaceutiques(List)}
     *   <li>{@link Famille#toString()}
     *   <li>{@link Famille#getId_famille()}
     *   <li>{@link Famille#getLib_famille()}
     *   <li>{@link Famille#getProduitPharmaceutiques()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Famille actualFamille = new Famille();
        actualFamille.setId_famille(1L);
        actualFamille.setLib_famille("Lib famille");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        actualFamille.setProduitPharmaceutiques(produitPharmaceutiqueList);
        String actualToStringResult = actualFamille.toString();
        assertEquals(1L, actualFamille.getId_famille().longValue());
        assertEquals("Lib famille", actualFamille.getLib_famille());
        assertSame(produitPharmaceutiqueList, actualFamille.getProduitPharmaceutiques());
        assertEquals("Famille(id_famille=1, lib_famille=Lib famille, produitPharmaceutiques=[])", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Famille#Famille(Long, String, List)}
     *   <li>{@link Famille#setId_famille(Long)}
     *   <li>{@link Famille#setLib_famille(String)}
     *   <li>{@link Famille#setProduitPharmaceutiques(List)}
     *   <li>{@link Famille#toString()}
     *   <li>{@link Famille#getId_famille()}
     *   <li>{@link Famille#getLib_famille()}
     *   <li>{@link Famille#getProduitPharmaceutiques()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        Famille actualFamille = new Famille(1L, "Lib famille", produitPharmaceutiqueList);
        actualFamille.setId_famille(1L);
        actualFamille.setLib_famille("Lib famille");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        actualFamille.setProduitPharmaceutiques(produitPharmaceutiqueList1);
        String actualToStringResult = actualFamille.toString();
        assertEquals(1L, actualFamille.getId_famille().longValue());
        assertEquals("Lib famille", actualFamille.getLib_famille());
        List<ProduitPharmaceutique> produitPharmaceutiques = actualFamille.getProduitPharmaceutiques();
        assertSame(produitPharmaceutiqueList1, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList, produitPharmaceutiques);
        assertEquals("Famille(id_famille=1, lib_famille=Lib famille, produitPharmaceutiques=[])", actualToStringResult);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, null);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals2() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, "Different type to Famille");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Famille#equals(Object)}
     *   <li>{@link Famille#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());
        assertEquals(famille, famille);
        int expectedHashCodeResult = famille.hashCode();
        assertEquals(expectedHashCodeResult, famille.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Famille#equals(Object)}
     *   <li>{@link Famille#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertEquals(famille, famille1);
        int expectedHashCodeResult = famille.hashCode();
        assertEquals(expectedHashCodeResult, famille1.hashCode());
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals5() {
        Famille famille = new Famille();
        famille.setId_famille(3L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, famille1);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals6() {
        Famille famille = new Famille();
        famille.setId_famille(null);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, famille1);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals7() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille(null);
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, famille1);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals8() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("com.example.gestion_des_produits_pharmaceutique.Entities.Famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille, famille1);
    }

    /**
     * Method under test: {@link Famille#equals(Object)}
     */
    @Test
    void testEquals9() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib famille");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Lib famille");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib famille");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        produitPharmaceutiqueList.add(produitPharmaceutique);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(produitPharmaceutiqueList);

        Famille famille2 = new Famille();
        famille2.setId_famille(1L);
        famille2.setLib_famille("Lib famille");
        famille2.setProduitPharmaceutiques(new ArrayList<>());
        assertNotEquals(famille1, famille2);
    }
}

