package com.example;

public class ImporteurLignesLivresAudio extends Importeur {
    @Override
    protected Document creerDocument(String ligne) {
        String[] c = ligne.split(";");
        if (!c[0].trim().equalsIgnoreCase("livre-audio")) {
            throw new IllegalArgumentException("Type de document incorrect : " + c[0]);
        }
        return new LivreAudio(c[1], Integer.parseInt(c[2]), c[3], Integer.parseInt(c[4]), Integer.parseInt(c[5]) );
    }
}