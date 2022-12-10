package com.example.gestion_des_produits_pharmaceutique.Entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
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

class FactureAchatTest {
    /**
     * Method under test: {@link FactureAchat#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new FactureAchat()).canEqual("Other"));
    }

    /**
     * Method under test: {@link FactureAchat#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        FactureAchat factureAchat = new FactureAchat();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(3);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        utilisateur.setFournisseurs(new ArrayList<>());
        utilisateur.setId_util(3L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        fournisseur.setFactureAchats(new ArrayList<>());
        fournisseur.setId_four(3L);
        fournisseur.setNom_four("Nom four");
        fournisseur.setProduitPharmaceutiques(new ArrayList<>());
        fournisseur.setTel_four(3);
        fournisseur.setUtilisateur(utilisateur);

        FactureAchat factureAchat1 = new FactureAchat();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        factureAchat1.setDate_facture_Achat(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        factureAchat1.setFournisseur(fournisseur);
        factureAchat1.setId_facture_Achat(3L);
        factureAchat1.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat1.setTotal_HT(10.0d);
        factureAchat1.setTotal_TTC(10.0d);
        factureAchat1.setTotal_TVA(10.0d);
        assertTrue(factureAchat.canEqual(factureAchat1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FactureAchat#FactureAchat()}
     *   <li>{@link FactureAchat#setDate_facture_Achat(Date)}
     *   <li>{@link FactureAchat#setFournisseur(Fournisseur)}
     *   <li>{@link FactureAchat#setId_facture_Achat(Long)}
     *   <li>{@link FactureAchat#setProduitPharmaceutiques(List)}
     *   <li>{@link FactureAchat#setTotal_HT(Double)}
     *   <li>{@link FactureAchat#setTotal_TTC(Double)}
     *   <li>{@link FactureAchat#setTotal_TVA(Double)}
     *   <li>{@link FactureAchat#toString()}
     *   <li>{@link FactureAchat#getDate_facture_Achat()}
     *   <li>{@link FactureAchat#getFournisseur()}
     *   <li>{@link FactureAchat#getId_facture_Achat()}
     *   <li>{@link FactureAchat#getProduitPharmaceutiques()}
     *   <li>{@link FactureAchat#getTotal_HT()}
     *   <li>{@link FactureAchat#getTotal_TTC()}
     *   <li>{@link FactureAchat#getTotal_TVA()}
     * </ul>
     */
    @Test
    void testConstructor() {
        FactureAchat actualFactureAchat = new FactureAchat();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualFactureAchat.setDate_facture_Achat(fromResult);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        utilisateur.setFournisseurs(fournisseurList);
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        ArrayList<FactureAchat> factureAchatList = new ArrayList<>();
        fournisseur.setFactureAchats(factureAchatList);
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        fournisseur.setProduitPharmaceutiques(produitPharmaceutiqueList);
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        actualFactureAchat.setFournisseur(fournisseur);
        actualFactureAchat.setId_facture_Achat(1L);
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        actualFactureAchat.setProduitPharmaceutiques(produitPharmaceutiqueList1);
        actualFactureAchat.setTotal_HT(10.0d);
        actualFactureAchat.setTotal_TTC(10.0d);
        actualFactureAchat.setTotal_TVA(10.0d);
        actualFactureAchat.toString();
        assertSame(fromResult, actualFactureAchat.getDate_facture_Achat());
        assertSame(fournisseur, actualFactureAchat.getFournisseur());
        assertEquals(1L, actualFactureAchat.getId_facture_Achat().longValue());
        List<ProduitPharmaceutique> produitPharmaceutiques = actualFactureAchat.getProduitPharmaceutiques();
        assertSame(produitPharmaceutiqueList1, produitPharmaceutiques);
        assertEquals(factureAchatList, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList, produitPharmaceutiques);
        assertEquals(fournisseurList, produitPharmaceutiques);
        assertEquals(10.0d, actualFactureAchat.getTotal_HT().doubleValue());
        assertEquals(10.0d, actualFactureAchat.getTotal_TTC().doubleValue());
        assertEquals(10.0d, actualFactureAchat.getTotal_TVA().doubleValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FactureAchat#FactureAchat(Long, Date, Double, Double, Double, Fournisseur, List)}
     *   <li>{@link FactureAchat#setDate_facture_Achat(Date)}
     *   <li>{@link FactureAchat#setFournisseur(Fournisseur)}
     *   <li>{@link FactureAchat#setId_facture_Achat(Long)}
     *   <li>{@link FactureAchat#setProduitPharmaceutiques(List)}
     *   <li>{@link FactureAchat#setTotal_HT(Double)}
     *   <li>{@link FactureAchat#setTotal_TTC(Double)}
     *   <li>{@link FactureAchat#setTotal_TVA(Double)}
     *   <li>{@link FactureAchat#toString()}
     *   <li>{@link FactureAchat#getDate_facture_Achat()}
     *   <li>{@link FactureAchat#getFournisseur()}
     *   <li>{@link FactureAchat#getId_facture_Achat()}
     *   <li>{@link FactureAchat#getProduitPharmaceutiques()}
     *   <li>{@link FactureAchat#getTotal_HT()}
     *   <li>{@link FactureAchat#getTotal_TTC()}
     *   <li>{@link FactureAchat#getTotal_TVA()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date date_facture_Achat = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setAdresse_util("Adresse util");
        utilisateur.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur.setDateNaissance_util(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur.setEmail_util("jane.doe@example.org");
        ArrayList<Fournisseur> fournisseurList = new ArrayList<>();
        utilisateur.setFournisseurs(fournisseurList);
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setAdresse_four("Adresse four");
        fournisseur.setEmail_four("jane.doe@example.org");
        ArrayList<FactureAchat> factureAchatList = new ArrayList<>();
        fournisseur.setFactureAchats(factureAchatList);
        fournisseur.setId_four(1L);
        fournisseur.setNom_four("Nom four");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList = new ArrayList<>();
        fournisseur.setProduitPharmaceutiques(produitPharmaceutiqueList);
        fournisseur.setTel_four(1);
        fournisseur.setUtilisateur(utilisateur);
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList1 = new ArrayList<>();
        FactureAchat actualFactureAchat = new FactureAchat(1L, date_facture_Achat, 10.0d, 10.0d, 10.0d, fournisseur,
                produitPharmaceutiqueList1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        actualFactureAchat.setDate_facture_Achat(fromResult);
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setAdresse_util("Adresse util");
        utilisateur1.setCodePostal_util(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        utilisateur1.setDateNaissance_util(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        utilisateur1.setEmail_util("jane.doe@example.org");
        ArrayList<Fournisseur> fournisseurList1 = new ArrayList<>();
        utilisateur1.setFournisseurs(fournisseurList1);
        utilisateur1.setId_util(1L);
        utilisateur1.setNom_util("Nom util");
        utilisateur1.setPrenom_util("Prenom util");
        Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setAdresse_four("Adresse four");
        fournisseur1.setEmail_four("jane.doe@example.org");
        ArrayList<FactureAchat> factureAchatList1 = new ArrayList<>();
        fournisseur1.setFactureAchats(factureAchatList1);
        fournisseur1.setId_four(1L);
        fournisseur1.setNom_four("Nom four");
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList2 = new ArrayList<>();
        fournisseur1.setProduitPharmaceutiques(produitPharmaceutiqueList2);
        fournisseur1.setTel_four(1);
        fournisseur1.setUtilisateur(utilisateur1);
        actualFactureAchat.setFournisseur(fournisseur1);
        actualFactureAchat.setId_facture_Achat(1L);
        ArrayList<ProduitPharmaceutique> produitPharmaceutiqueList3 = new ArrayList<>();
        actualFactureAchat.setProduitPharmaceutiques(produitPharmaceutiqueList3);
        actualFactureAchat.setTotal_HT(10.0d);
        actualFactureAchat.setTotal_TTC(10.0d);
        actualFactureAchat.setTotal_TVA(10.0d);
        actualFactureAchat.toString();
        assertSame(fromResult, actualFactureAchat.getDate_facture_Achat());
        Fournisseur fournisseur2 = actualFactureAchat.getFournisseur();
        assertSame(fournisseur1, fournisseur2);
        assertEquals(fournisseur, fournisseur2);
        assertEquals(1L, actualFactureAchat.getId_facture_Achat().longValue());
        List<ProduitPharmaceutique> produitPharmaceutiques = actualFactureAchat.getProduitPharmaceutiques();
        assertSame(produitPharmaceutiqueList3, produitPharmaceutiques);
        assertEquals(factureAchatList, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList, produitPharmaceutiques);
        assertEquals(fournisseurList, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList1, produitPharmaceutiques);
        assertEquals(factureAchatList1, produitPharmaceutiques);
        assertEquals(produitPharmaceutiqueList2, produitPharmaceutiques);
        assertEquals(fournisseurList1, produitPharmaceutiques);
        assertEquals(10.0d, actualFactureAchat.getTotal_HT().doubleValue());
        assertEquals(10.0d, actualFactureAchat.getTotal_TTC().doubleValue());
        assertEquals(10.0d, actualFactureAchat.getTotal_TVA().doubleValue());
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
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
        assertNotEquals(factureAchat, null);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
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
        assertNotEquals(factureAchat, "Different type to FactureAchat");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FactureAchat#equals(Object)}
     *   <li>{@link FactureAchat#hashCode()}
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
        assertEquals(factureAchat, factureAchat);
        int expectedHashCodeResult = factureAchat.hashCode();
        assertEquals(expectedHashCodeResult, factureAchat.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link FactureAchat#equals(Object)}
     *   <li>{@link FactureAchat#hashCode()}
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
        assertEquals(factureAchat, factureAchat1);
        int expectedHashCodeResult = factureAchat.hashCode();
        assertEquals(expectedHashCodeResult, factureAchat1.hashCode());
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals5() {
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
        factureAchat
                .setDate_facture_Achat(Date.from(atStartOfDayResult1.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant()));
        factureAchat.setFournisseur(fournisseur);
        factureAchat.setId_facture_Achat(1L);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals6() {
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
        factureAchat.setDate_facture_Achat(null);
        factureAchat.setFournisseur(fournisseur);
        factureAchat.setId_facture_Achat(1L);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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

        FactureAchat factureAchat1 = new FactureAchat();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        factureAchat1.setDate_facture_Achat(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        factureAchat1.setFournisseur(fournisseur1);
        factureAchat1.setId_facture_Achat(1L);
        factureAchat1.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat1.setTotal_HT(10.0d);
        factureAchat1.setTotal_TTC(10.0d);
        factureAchat1.setTotal_TVA(10.0d);
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals7() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals8() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setId_facture_Achat(3L);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals9() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setId_facture_Achat(null);
        factureAchat.setProduitPharmaceutiques(new ArrayList<>());
        factureAchat.setTotal_HT(10.0d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals10() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_HT(null);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals11() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_HT(0.5d);
        factureAchat.setTotal_TTC(10.0d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
     */
    @Test
    void testEquals12() {
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
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_TTC(null);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
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
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_TTC(0.5d);
        factureAchat.setTotal_TVA(10.0d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
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
        utilisateur.setId_util(1L);
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_TVA(null);

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
        assertNotEquals(factureAchat, factureAchat1);
    }

    /**
     * Method under test: {@link FactureAchat#equals(Object)}
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
        utilisateur.setNom_util("Nom util");
        utilisateur.setPrenom_util("Prenom util");
        Fournisseur fournisseur = mock(Fournisseur.class);
        doNothing().when(fournisseur).setAdresse_four((String) any());
        doNothing().when(fournisseur).setEmail_four((String) any());
        doNothing().when(fournisseur).setFactureAchats((List<FactureAchat>) any());
        doNothing().when(fournisseur).setId_four((Long) any());
        doNothing().when(fournisseur).setNom_four((String) any());
        doNothing().when(fournisseur).setProduitPharmaceutiques((List<ProduitPharmaceutique>) any());
        doNothing().when(fournisseur).setTel_four(anyInt());
        doNothing().when(fournisseur).setUtilisateur((Utilisateur) any());
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
        factureAchat.setTotal_TVA(0.5d);

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
        assertNotEquals(factureAchat, factureAchat1);
    }
}

