package org.example;

public class Main {
    public static void main(String[] args) {
        PGM image = new PGM();
        image.chargePGM("/Users/antoinefrigout/Centrale/INFOSI/COURS/MEDEV/TP3/tp-pgm-frigout/fic/baboon.pgm");
        System.out.println(image.toString());
    }
}