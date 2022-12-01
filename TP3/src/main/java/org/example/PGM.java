package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe représentant un fichier PGM.
 *
 * @author AFR
 * @version 0.1
 */
public class PGM {

    // Attributs de classe
    private String entete;
    private int hauteur;
    private int largeur;
    private int maxGris;
    private ArrayList<String> contenu;

    public PGM() {
        this.entete = "P2";
        this.hauteur = 0;
        this.largeur = 0;
        this.maxGris = 255;
        this.contenu = new ArrayList<>();
    }

    /**
     * Méthode utilisée pour la lecture du fichier JSON.
     *
     * @param path     Chemin du fichier
     * @param encoding Encodage du fichier
     * @return Le contenu du fichier
     * @throws IOException Si le fichier à lire n'existe pas
     */
    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Méthode pour obtenir le contenu d'un fichier sous forme d'une liste de chaine de caractère.
     *
     * @return La liste des lignes contenues dans le fichier sous forme de chaine de caractère.
     * @author AFR
     */
    public static ArrayList<String> fichier2ListeString(String cheminFichier) {
        ArrayList<String> raw = new ArrayList<>();
        try {
            String contenu = PGM.readFile(cheminFichier, Charset.defaultCharset());
            String[] contenuParsee = contenu.split("\n");
            for(int i = 0; i < contenuParsee.length; i++){
                raw.add(contenuParsee[i]);
            }
        } catch (IOException ex) {
            System.out.println("Impossible de lire le fichier...");
        }
        return raw;
    }

    /**
     * Méthode pour charger un fichier PGM.
     *
     * @param cheminFichier La localisation du fichier.
     * @author AFR
     */
    public void chargePGM(String cheminFichier){
        ArrayList<String> contenu = PGM.fichier2ListeString(cheminFichier);

        // Mise à jour du contenu
        this.entete = contenu.get(0);
        this.hauteur = Integer.parseInt(contenu.get(2).split(" ")[0]);
        this.largeur = Integer.parseInt(contenu.get(2).split(" ")[1]);

        this.maxGris = Integer.parseInt(contenu.get(3));

        // Suppression des données plus utiles
        contenu.remove(0);
        contenu.remove(1);
        contenu.remove(2);
        contenu.remove(3);
        this.contenu = new ArrayList<>(contenu);
    }
}
