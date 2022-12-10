package com.example.gestion_des_produits_pharmaceutique.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilisateurTest {
    /**
     * Method under test: {@link Utilisateur#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Utilisateur()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Utilisateur#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Utilisateur utilisateur = new Utilisateur();

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(3);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(new ArrayList<>());
        utilisateur1.setId_util(3L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");
        assertTrue(utilisateur.canEqual(utilisateur1));
    }

    /**
     * Method under test: {@link Utilisateur#canEqual(Object)}
     */
    @Test
    void testCanEqual3() {
        java.sql.Date dateNaissance_util = mock(java.sql.Date.class);
        assertFalse((new Utilisateur(3L, "Nom util", "Prenom util", "Adresse util", "jane.doe@example.org", 3,
                dateNaissance_util, new ArrayList<>())).canEqual("Other"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Utilisateur#Utilisateur()}
     *   <li>{@link Utilisateur#setAdresse_util(String)}
     *   <li>{@link Utilisateur#setCodePostal_util(int)}
     *   <li>{@link Utilisateur#setDateNaissance_util(Date)}
     *   <li>{@link Utilisateur#setEmail_util(String)}
     *   <li>{@link Utilisateur#setFournisseurs(List)}
     *   <li>{@link Utilisateur#setId_util(Long)}
     *   <li>{@link Utilisateur#setNom_util(String)}
     *   <li>{@link Utilisateur#setPrenom_util(String)}
     *   <li>{@link Utilisateur#toString()}
     *   <li>{@link Utilisateur#getAdresse_util()}
     *   <li>{@link Utilisateur#getCodePostal_util()}
     *   <li>{@link Utilisateur#getDateNaissance_util()}
     *   <li>{@link Utilisateur#getEmail_util()}
     *   <li>{@link Utilisateur#getFournisseurs()}
     *   <li>{@link Utilisateur#getId_util()}
     *   <li>{@link Utilisateur#getNom_util()}
     *   <li>{@link Utilisateur#getPrenom_util()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Utilisateur actualUtilisateur = new Utilisateur();
        actualUtilisateur.setAdresse_util("Adresse util");
        actualUtilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualUtilisateur.setDateNaissance_util(fromResult);
        actualUtilisateur.setEmail_util("jane.doe@example.org");
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        actualUtilisateur.setFournisseurs(fournisseurList);
        actualUtilisateur.setId_util(1L);
        actualUtilisateur.setNom_util("Nom util");
        actualUtilisateur.setPrenom_util("Prenom util");
        actualUtilisateur.toString();
        assertEquals("Adresse util", actualUtilisateur.getAdresse_util());
        assertEquals(1, actualUtilisateur.getCodePostal_util());
        assertSame(fromResult, actualUtilisateur.getDateNaissance_util());
        assertEquals("jane.doe@example.org", actualUtilisateur.getEmail_util());
        assertSame(fournisseurList, actualUtilisateur.getFournisseurs());
        assertEquals(1L, actualUtilisateur.getId_util().longValue());
        assertEquals("Nom util", actualUtilisateur.getNom_util());
        assertEquals("Prenom util", actualUtilisateur.getPrenom_util());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Utilisateur#Utilisateur(Long, String, String, String, String, int, Date, List)}
     *   <li>{@link Utilisateur#setAdresse_util(String)}
     *   <li>{@link Utilisateur#setCodePostal_util(int)}
     *   <li>{@link Utilisateur#setDateNaissance_util(Date)}
     *   <li>{@link Utilisateur#setEmail_util(String)}
     *   <li>{@link Utilisateur#setFournisseurs(List)}
     *   <li>{@link Utilisateur#setId_util(Long)}
     *   <li>{@link Utilisateur#setNom_util(String)}
     *   <li>{@link Utilisateur#setPrenom_util(String)}
     *   <li>{@link Utilisateur#toString()}
     *   <li>{@link Utilisateur#getAdresse_util()}
     *   <li>{@link Utilisateur#getCodePostal_util()}
     *   <li>{@link Utilisateur#getDateNaissance_util()}
     *   <li>{@link Utilisateur#getEmail_util()}
     *   <li>{@link Utilisateur#getFournisseurs()}
     *   <li>{@link Utilisateur#getId_util()}
     *   <li>{@link Utilisateur#getNom_util()}
     *   <li>{@link Utilisateur#getPrenom_util()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date dateNaissance_util = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        Utilisateur actualUtilisateur = new Utilisateur(1L, "Nom util", "Prenom util", "Adresse util",
                "jane.doe@example.org", 1, dateNaissance_util, fournisseurList);
        actualUtilisateur.setAdresse_util("Adresse util");
        actualUtilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualUtilisateur.setDateNaissance_util(fromResult);
        actualUtilisateur.setEmail_util("jane.doe@example.org");
        ArrayList<Fournisseur> fournisseurList1 = new ArrayList<>();
        actualUtilisateur.setFournisseurs(fournisseurList1);
        actualUtilisateur.setId_util(1L);
        actualUtilisateur.setNom_util("Nom util");
        actualUtilisateur.setPrenom_util("Prenom util");
        actualUtilisateur.toString();
        assertEquals("Adresse util", actualUtilisateur.getAdresse_util());
        assertEquals(1, actualUtilisateur.getCodePostal_util());
        assertSame(fromResult, actualUtilisateur.getDateNaissance_util());
        assertEquals("jane.doe@example.org", actualUtilisateur.getEmail_util());
        List<Fournisseur> fournisseurs = actualUtilisateur.getFournisseurs();
        assertSame(fournisseurList1, fournisseurs);
        assertEquals(fournisseurList, fournisseurs);
        assertEquals(1L, actualUtilisateur.getId_util().longValue());
        assertEquals("Nom util", actualUtilisateur.getNom_util());
        assertEquals("Prenom util", actualUtilisateur.getPrenom_util());
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(utilisateur, null);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(utilisateur, "Different type to Utilisateur");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Utilisateur#equals(Object)}
     *   <li>{@link Utilisateur#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(utilisateur, utilisateur);
        int expectedHashCodeResult = utilisateur.hashCode();
        assertEquals(expectedHashCodeResult, utilisateur.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Utilisateur#equals(Object)}
     *   <li>{@link Utilisateur#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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
        assertEquals(utilisateur, utilisateur1);
        int expectedHashCodeResult = utilisateur.hashCode();
        assertEquals(expectedHashCodeResult, utilisateur1.hashCode());
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals5() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Nom util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals6() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util(null);
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals7() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(3);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals8() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals9() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        utilisateur.setDateNaissance_util(null);
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(new ArrayList<>());
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals10() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("Nom util");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals11() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util(null);
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals12() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Nom util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Nom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Nom util");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom util");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);

        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        fournisseurList.add(fournisseur);

        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        utilisateur1.setFournisseurs(fournisseurList);
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");

        Utilisateur utilisateur2 = new Utilisateur();
        utilisateur2.setAdresse_util("Adresse util");
        utilisateur2.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur2.setDateNaissance_util(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur2.setEmail_util("jane.doe@example.org");
        utilisateur2.setFournisseurs(new ArrayList<>());
        utilisateur2.setId_util(1L);
        utilisateur2.setNom_util("Nom util");
        utilisateur2.setPrenom_util("Prenom util");
        assertNotEquals(utilisateur1, utilisateur2);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals13() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(3L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals14() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(null);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals15() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Prenom util");
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals16() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util(null);
        utilisateur.setPrenom_util("Prenom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals17() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Nom util");

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
        assertNotEquals(utilisateur, utilisateur1);
    }

    /**
     * Method under test: {@link Utilisateur#equals(Object)}
     */
    @Test
    void testEquals18() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util(null);

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
        assertNotEquals(utilisateur, utilisateur1);
    }
}

