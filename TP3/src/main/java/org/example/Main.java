package org.example;

public class Main {
    public static void main(String[] args) {
        PGM image = new PGM();
        image.chargePGM("/Users/antoinefrigout/Centrale/INFOSI/COURS/MEDEV/TP3/tp-pgm-frigout/fic/baboon.pgm");


        image.seuillage(50);
        image.exportPGM("/Users/antoinefrigout/Centrale/INFOSI/COURS/MEDEV/TP3/tp-pgm-frigout/fic/baboon50.pgm");
    }
}