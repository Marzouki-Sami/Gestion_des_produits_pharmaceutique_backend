package com.example.gestion_des_produits_pharmaceutique.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProduitPharmaceutiqueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProduitPharmaceutique#ProduitPharmaceutique()}
     *   <li>{@link ProduitPharmaceutique#setDateAjout_prd(Date)}
     *   <li>{@link ProduitPharmaceutique#setDescription_prd(String)}
     *   <li>{@link ProduitPharmaceutique#setFactureAchats(List)}
     *   <li>{@link ProduitPharmaceutique#setFamille(Famille)}
     *   <li>{@link ProduitPharmaceutique#setFournisseurs(List)}
     *   <li>{@link ProduitPharmaceutique#setId_prd(Long)}
     *   <li>{@link ProduitPharmaceutique#setLaboratoire(Laboratoire)}
     *   <li>{@link ProduitPharmaceutique#setLib_prd(String)}
     *   <li>{@link ProduitPharmaceutique#setPrix_livr(float)}
     *   <li>{@link ProduitPharmaceutique#setPrix_prd(Double)}
     *   <li>{@link ProduitPharmaceutique#toString()}
     *   <li>{@link ProduitPharmaceutique#getDateAjout_prd()}
     *   <li>{@link ProduitPharmaceutique#getDescription_prd()}
     *   <li>{@link ProduitPharmaceutique#getFactureAchats()}
     *   <li>{@link ProduitPharmaceutique#getFournisseurs()}
     *   <li>{@link ProduitPharmaceutique#getFamille()}
     *   <li>{@link ProduitPharmaceutique#getId_prd()}
     *   <li>{@link ProduitPharmaceutique#getLaboratoire()}
     *   <li>{@link ProduitPharmaceutique#getLib_prd()}
     *   <li>{@link ProduitPharmaceutique#getPrix_livr()}
     *   <li>{@link ProduitPharmaceutique#getPrix_prd()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ProduitPharmaceutique actualProduitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualProduitPharmaceutique.setDateAjout_prd(fromResult);
        actualProduitPharmaceutique.setDescription_prd("Description prd");
        ArrayList<FactureAchat> factureAchatList = new ArrayList<>();
        actualProduitPharmaceutique.setFactureAchats(factureAchatList);
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        famille.setProduitPharmaceutiques(produitPharmaceutiqueList);
        actualProduitPharmaceutique.setFamille(famille);
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        actualProduitPharmaceutique.setFournisseurs(fournisseurList);
        actualProduitPharmaceutique.setId_prd(1L);
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        laboratoire.setProduitPharmaceutiques(produitPharmaceutiqueList1);
        actualProduitPharmaceutique.setLaboratoire(laboratoire);
        actualProduitPharmaceutique.setLib_prd("Lib prd");
        actualProduitPharmaceutique.setPrix_livr(10.0f);
        actualProduitPharmaceutique.setPrix_prd(10.0d);
        actualProduitPharmaceutique.toString();
        assertSame(fromResult, actualProduitPharmaceutique.getDateAjout_prd());
        assertEquals("Description prd", actualProduitPharmaceutique.getDescription_prd());
        List<FactureAchat> factureAchats = actualProduitPharmaceutique.getFactureAchats();
        assertSame(factureAchatList, factureAchats);
        assertEquals(produitPharmaceutiqueList, factureAchats);
        assertEquals(produitPharmaceutiqueList1, factureAchats);
        List<Fournisseur> fournisseurs = actualProduitPharmaceutique.getFournisseurs();
        assertEquals(fournisseurs, factureAchats);
        assertSame(famille, actualProduitPharmaceutique.getFamille());
        assertSame(fournisseurList, fournisseurs);
        assertEquals(factureAchatList, fournisseurs);
        assertEquals(produitPharmaceutiqueList, fournisseurs);
        assertEquals(produitPharmaceutiqueList1, fournisseurs);
        assertEquals(1L, actualProduitPharmaceutique.getId_prd().longValue());
        assertSame(laboratoire, actualProduitPharmaceutique.getLaboratoire());
        assertEquals("Lib prd", actualProduitPharmaceutique.getLib_prd());
        assertEquals(10.0f, actualProduitPharmaceutique.getPrix_livr());
        assertEquals(10.0d, actualProduitPharmaceutique.getPrix_prd().doubleValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProduitPharmaceutique#ProduitPharmaceutique(Long, String, String, Double, Date, float, Famille, Laboratoire, List, List)}
     *   <li>{@link ProduitPharmaceutique#setDateAjout_prd(Date)}
     *   <li>{@link ProduitPharmaceutique#setDescription_prd(String)}
     *   <li>{@link ProduitPharmaceutique#setFactureAchats(List)}
     *   <li>{@link ProduitPharmaceutique#setFamille(Famille)}
     *   <li>{@link ProduitPharmaceutique#setFournisseurs(List)}
     *   <li>{@link ProduitPharmaceutique#setId_prd(Long)}
     *   <li>{@link ProduitPharmaceutique#setLaboratoire(Laboratoire)}
     *   <li>{@link ProduitPharmaceutique#setLib_prd(String)}
     *   <li>{@link ProduitPharmaceutique#setPrix_livr(float)}
     *   <li>{@link ProduitPharmaceutique#setPrix_prd(Double)}
     *   <li>{@link ProduitPharmaceutique#toString()}
     *   <li>{@link ProduitPharmaceutique#getDateAjout_prd()}
     *   <li>{@link ProduitPharmaceutique#getDescription_prd()}
     *   <li>{@link ProduitPharmaceutique#getFactureAchats()}
     *   <li>{@link ProduitPharmaceutique#getFournisseurs()}
     *   <li>{@link ProduitPharmaceutique#getFamille()}
     *   <li>{@link ProduitPharmaceutique#getId_prd()}
     *   <li>{@link ProduitPharmaceutique#getLaboratoire()}
     *   <li>{@link ProduitPharmaceutique#getLib_prd()}
     *   <li>{@link ProduitPharmaceutique#getPrix_livr()}
     *   <li>{@link ProduitPharmaceutique#getPrix_prd()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date dateAjout_prd = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        famille.setProduitPharmaceutiques(produitPharmaceutiqueList);

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        laboratoire.setProduitPharmaceutiques(produitPharmaceutiqueList1);
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        ArrayList<FactureAchat> factureAchatList = new ArrayList<>();
        ProduitPharmaceutique actualProduitPharmaceutique = new ProduitPharmaceutique(1L, "Lib prd", "Description prd",
                10.0d, dateAjout_prd, 10.0f, famille, laboratoire, fournisseurList, factureAchatList);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualProduitPharmaceutique.setDateAjout_prd(fromResult);
        actualProduitPharmaceutique.setDescription_prd("Description prd");
        ArrayList<FactureAchat> factureAchatList1 = new ArrayList<>();
        actualProduitPharmaceutique.setFactureAchats(factureAchatList1);
        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList2 = new ArrayList<>();
        famille1.setProduitPharmaceutiques(produitPharmaceutiqueList2);
        actualProduitPharmaceutique.setFamille(famille1);
        ArrayList<Fournisseur> fournisseurList1 = new ArrayList<>();
        actualProduitPharmaceutique.setFournisseurs(fournisseurList1);
        actualProduitPharmaceutique.setId_prd(1L);
        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList3 = new ArrayList<>();
        laboratoire1.setProduitPharmaceutiques(produitPharmaceutiqueList3);
        actualProduitPharmaceutique.setLaboratoire(laboratoire1);
        actualProduitPharmaceutique.setLib_prd("Lib prd");
        actualProduitPharmaceutique.setPrix_livr(10.0f);
        actualProduitPharmaceutique.setPrix_prd(10.0d);
        actualProduitPharmaceutique.toString();
        assertSame(fromResult, actualProduitPharmaceutique.getDateAjout_prd());
        assertEquals("Description prd", actualProduitPharmaceutique.getDescription_prd());
        List<FactureAchat> factureAchats = actualProduitPharmaceutique.getFactureAchats();
        assertSame(factureAchatList1, factureAchats);
        assertEquals(produitPharmaceutiqueList, factureAchats);
        assertEquals(produitPharmaceutiqueList1, factureAchats);
        assertEquals(fournisseurList, factureAchats);
        assertEquals(factureAchatList, factureAchats);
        assertEquals(produitPharmaceutiqueList2, factureAchats);
        assertEquals(produitPharmaceutiqueList3, factureAchats);
        List<Fournisseur> fournisseurs = actualProduitPharmaceutique.getFournisseurs();
        assertEquals(fournisseurs, factureAchats);
        Famille famille2 = actualProduitPharmaceutique.getFamille();
        assertSame(famille1, famille2);
        assertEquals(famille, famille2);
        assertSame(fournisseurList1, fournisseurs);
        assertEquals(produitPharmaceutiqueList, fournisseurs);
        assertEquals(produitPharmaceutiqueList1, fournisseurs);
        assertEquals(fournisseurList, fournisseurs);
        assertEquals(factureAchatList, fournisseurs);
        assertEquals(factureAchatList1, fournisseurs);
        assertEquals(produitPharmaceutiqueList2, fournisseurs);
        assertEquals(produitPharmaceutiqueList3, fournisseurs);
        assertEquals(1L, actualProduitPharmaceutique.getId_prd().longValue());
        Laboratoire laboratoire2 = actualProduitPharmaceutique.getLaboratoire();
        assertSame(laboratoire1, laboratoire2);
        assertEquals(laboratoire, laboratoire2);
        assertEquals("Lib prd", actualProduitPharmaceutique.getLib_prd());
        assertEquals(10.0f, actualProduitPharmaceutique.getPrix_livr());
        assertEquals(10.0d, actualProduitPharmaceutique.getPrix_prd().doubleValue());
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(produitPharmaceutique, null);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(produitPharmaceutique, "Different type to ProduitPharmaceutique");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProduitPharmaceutique#equals(Object)}
     *   <li>{@link ProduitPharmaceutique#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(produitPharmaceutique, produitPharmaceutique);
        int expectedHashCodeResult = produitPharmaceutique.hashCode();
        assertEquals(expectedHashCodeResult, produitPharmaceutique.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProduitPharmaceutique#equals(Object)}
     *   <li>{@link ProduitPharmaceutique#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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
        assertEquals(produitPharmaceutique, produitPharmaceutique1);
        int expectedHashCodeResult = produitPharmaceutique.hashCode();
        assertEquals(expectedHashCodeResult, produitPharmaceutique1.hashCode());
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals5() {
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
        produitPharmaceutique
                .setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals6() {
        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        produitPharmaceutique.setDateAjout_prd(null);
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique1.setDateAjout_prd(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique1.setDescription_prd("Description prd");
        produitPharmaceutique1.setFactureAchats(new ArrayList<>());
        produitPharmaceutique1.setFamille(famille1);
        produitPharmaceutique1.setFournisseurs(new ArrayList<>());
        produitPharmaceutique1.setId_prd(1L);
        produitPharmaceutique1.setLaboratoire(laboratoire1);
        produitPharmaceutique1.setLib_prd("Lib prd");
        produitPharmaceutique1.setPrix_livr(10.0f);
        produitPharmaceutique1.setPrix_prd(10.0d);
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals7() {
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
        produitPharmaceutique.setDescription_prd("Lib prd");
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals8() {
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
        produitPharmaceutique.setDescription_prd(null);
        produitPharmaceutique.setFactureAchats(new ArrayList<>());
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals9() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Lib prd");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Lib prd");
        utilisateur.setPrenom_util("Lib prd");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Lib prd");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Lib prd");
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

        ArrayList<FactureAchat> factureAchatList = new ArrayList<>();
        factureAchatList.add(factureAchat);

        Famille famille = new Famille();
        famille.setId_famille(1L);
        famille.setLib_famille("Lib famille");
        famille.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setId_labo(1L);
        laboratoire.setLib_labo("Lib labo");
        laboratoire.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique.setDateAjout_prd(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique.setDescription_prd("Description prd");
        produitPharmaceutique.setFactureAchats(factureAchatList);
        produitPharmaceutique.setFamille(famille);
        produitPharmaceutique.setFournisseurs(new ArrayList<>());
        produitPharmaceutique.setId_prd(1L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

        Famille famille1 = new Famille();
        famille1.setId_famille(1L);
        famille1.setLib_famille("Lib famille");
        famille1.setProduitPharmaceutiques(new ArrayList<>());

        Laboratoire laboratoire1 = new Laboratoire();
        laboratoire1.setId_labo(1L);
        laboratoire1.setLib_labo("Lib labo");
        laboratoire1.setProduitPharmaceutiques(new ArrayList<>());

        ProduitPharmaceutique produitPharmaceutique1 = new ProduitPharmaceutique();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produitPharmaceutique1.setDateAjout_prd(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        produitPharmaceutique1.setDescription_prd("Description prd");
        produitPharmaceutique1.setFactureAchats(new ArrayList<>());
        produitPharmaceutique1.setFamille(famille1);
        produitPharmaceutique1.setFournisseurs(new ArrayList<>());
        produitPharmaceutique1.setId_prd(1L);
        produitPharmaceutique1.setLaboratoire(laboratoire1);
        produitPharmaceutique1.setLib_prd("Lib prd");
        produitPharmaceutique1.setPrix_livr(10.0f);
        produitPharmaceutique1.setPrix_prd(10.0d);
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals10() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals11() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setId_prd(3L);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals12() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setId_prd(null);
        produitPharmaceutique.setLaboratoire(laboratoire);
        produitPharmaceutique.setLib_prd("Lib prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals13() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setLib_prd("Description prd");
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals14() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setLib_prd(null);
        produitPharmaceutique.setPrix_livr(10.0f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals15() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setPrix_livr(0.5f);
        produitPharmaceutique.setPrix_prd(10.0d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals16() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setPrix_prd(null);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }

    /**
     * Method under test: {@link ProduitPharmaceutique#equals(Object)}
     */
    @Test
    void testEquals17() {
        Famille famille = mock(Famille.class);
        doNothing().when(famille).setId_famille((Long) any());
        doNothing().when(famille).setLib_famille((String) any());
        doNothing().when(famille).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
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
        produitPharmaceutique.setPrix_prd(0.5d);

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
        assertNotEquals(produitPharmaceutique, produitPharmaceutique1);
    }
}

