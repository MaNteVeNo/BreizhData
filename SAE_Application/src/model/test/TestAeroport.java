package model.test;

import model.data.Aeroport;
import model.data.Departement;
import model.data.Commune;

import java.util.ArrayList;

/**
 * Classe de test pour la classe Aéroport du package model
 * @author Matéo Nouvion
 */
public class TestAeroport {
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_ERROR = "\u001B[31m";
    public static final String COLOR_OK = "\u001B[32m";

    public static int nbTest = 0;
    public static int nbError = 0;

    public static void main(String[] args) {
        System.out.println("------ TestAeroport ------");
        testConstructor();
        testSettersAndGetters();
        testToString();
        testFindCommune();

        System.out.println();
        if (nbError == 0) {
            printOk("Test réussi ! : " + nbTest + " / " + nbTest);
        } else {
            printError("Echec du test : " + (nbTest - nbError) + " / " + nbTest);
        }
    }

    public static void testConstructor() {
        System.out.println("\nTest des constructeurs");
        
        // Test constructeur par défaut
        try {
            Aeroport a = new Aeroport();
            if (!a.getNom().isEmpty() || !a.getAdresse().isEmpty()) {
                printError("\tECHEC : constructeur par défaut");
            } else {
                printOk("\tOK : constructeur par défaut");
            }
        } catch (Exception e) {
            printError("\tECHEC : constructeur par défaut : " + e.getMessage());
        }
    
        // Test constructeur avec paramètres
        try {
            Departement d = new Departement(29, "FINISTERE", 500000);
            Aeroport a = new Aeroport("BREST-BRETAGNE", "GUIPAVAS 29490", d);
            if (!a.getNom().equals("BREST-BRETAGNE") || !a.getAdresse().equals("GUIPAVAS 29490") || a.getLeDepartement() != d) {
                printError("\tECHEC : constructeur avec paramètres");
            } else {
                printOk("\tOK : constructeur avec paramètres");
            }
        } catch (Exception e) {
            printError("\tECHEC : constructeur avec paramètres : " + e.getMessage());
        }
    
        // Test constructeur avec nom null
        try {
            new Aeroport(null, "GUIPAVAS 29490", new Departement(29, "Finistère", 500000));
            printError("\tECHEC : constructeur avec nom null");
        } catch (IllegalArgumentException e) {
            printOk("\tOK : constructeur avec nom null");
        }
    
        // Test constructeur avec adresse null
        try {
            new Aeroport("BREST-BRETAGNE", null, new Departement(29, "Finistère", 500000));
            printError("\tECHEC : constructeur avec adresse null");
        } catch (IllegalArgumentException e) {
            printOk("\tOK : constructeur avec adresse null");
        }
    }
    

    public static void testSettersAndGetters() {
        System.out.println("\nTest des setters et getters");
        Departement d = new Departement(29, "Finistère", 500000);
        Aeroport a = new Aeroport("BREST-BRETAGNE", "GUIPAVAS 29490", d);

        try {
            a.setNom("RENNES-ST-JACQUES");
            if (!a.getNom().equals("RENNES-ST-JACQUES")) {
                printError("\tECHEC : setNom/getNom");
            } else {
                printOk("\tOK : setNom/getNom");
            }
        } catch (Exception e) {
            printError("\tECHEC : setNom/getNom : " + e.getMessage());
        }

        try {
            a.setAdresse("Avenue Joseph Le Brix - B.P. 29155 RENNES 35091");
            if (!a.getAdresse().equals("Avenue Joseph Le Brix - B.P. 29155 RENNES 35091")) {
                printError("\tECHEC : setAdresse/getAdresse");
            } else {
                printOk("\tOK : setAdresse/getAdresse");
            }
        } catch (Exception e) {
            printError("\tECHEC : setAdresse/getAdresse : " + e.getMessage());
        }

        try {
            Departement d2 = new Departement(35, "Ille-et-Vilaine", 1000000);
            a.setLeDepartement(d2);
            if (a.getLeDepartement() != d2) {
                printError("\tECHEC : setLeDepartement/getLeDepartement");
            } else {
                printOk("\tOK : setLeDepartement/getLeDepartement");
            }
        } catch (Exception e) {
            printError("\tECHEC : setLeDepartement/getLeDepartement : " + e.getMessage());
        }
    }

    public static void testToString() {
        System.out.println("\nTest de toString");
        Departement d = new Departement(29, "Finistère", 500000);
        Aeroport a = new Aeroport("QUIMPER-PLUGUFFAN", "PLUGUFFAN 29700", d);

        String expected = "Nom : QUIMPER-PLUGUFFAN\nAdresse : PLUGUFFAN 29700\n";
        String actual = a.toString();

        if (!expected.equals(actual)) {
            printError("\tECHEC : toString");
            printError("\t\tExpected : " + expected);
            printError("\t\tActual : " + actual);
        } else {
            printOk("\tOK : toString");
        }
    }

    public static void testFindCommune() {
        System.out.println("\nTest de findCommune");



        Departement d = new Departement(29, "Finistère", 500000);
        Aeroport a = new Aeroport("BREST-BRETAGNE","GUIPAVAS 29490", d);
        Aeroport a1 = new Aeroport("QUIMPER-PLUGUFFAN", "PLUGUFFAN 29700", d);
        

        ArrayList<Commune> communes = new ArrayList<>();
        communes.add(new Commune(29019,"GUIPAVAS",d));
        communes.add(new Commune(35238,"RENNES",d));
        communes.add(new Commune(29216,"PLUGUFFAN",d));

        try {
            Commune found = a.findCommune(communes);
            if (found == null || !found.getNomCommune().equals("GUIPAVAS")) {
                printError("\tECHEC : findCommune");
            } else {
                printOk("\tOK : findCommune");
            }
        } catch (Exception e) {
            printError("\tECHEC : findCommune : " + e.getMessage());
        }

        try {
            Commune found = a1.findCommune(communes);
            if (found == null || !found.getNomCommune().equals("PLUGUFFAN")) {
                printError("\tECHEC : findCommune");
            } else {
                printOk("\tOK : findCommune");
            }
        } catch (Exception e) {
            printError("\tECHEC : findCommune : " + e.getMessage());
        }

        try {
            a.setAdresse("Inconnue, Finistère");
            Commune found = a.findCommune(communes);
            if (found != null) {
                printError("\tECHEC : findCommune avec adresse inconnue");
            } else {
                printOk("\tOK : findCommune avec adresse inconnue");
            }
        } catch (Exception e) {
            printError("\tECHEC : findCommune avec adresse inconnue : " + e.getMessage());
        }
    }

    public static void printOk(String message) {
        System.out.println(COLOR_OK + message + COLOR_RESET);
        nbTest++;
    }

    public static void printError(String message) {
        System.out.println(COLOR_ERROR + message + COLOR_RESET);
        nbTest++;
        nbError++;
    }
}