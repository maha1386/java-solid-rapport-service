package com.example;

public class ImporteurCsv extends Importeur {
    @Override
    protected Document creerDocument(String ligne) {
        String[] c = ligne.split(";");
        return switch (c[0].trim().toLowerCase()) {
            case "livre" -> new Livre(c[1], Integer.parseInt(c[2]), c[3],Integer.parseInt(c[4]));
            case "dvd" ->new Dvd(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]));
            case "revue" ->new Revue(c[1],Integer.parseInt(c[2]),Integer.parseInt(c[3]));
            default ->throw new IllegalArgumentException("Type de document inconnu : " + c[0]);
        };
    }
}