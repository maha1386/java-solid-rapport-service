package com.example;

public class LivreAudio extends Livre {
    private int dureeAudio;
    public LivreAudio(String titre, int id, String auteur, int nombrePages, int dureeAudio) {
        super(titre, id, auteur, nombrePages);
        this.dureeAudio = dureeAudio;
    }

    public int getDureeAudio() {
        return dureeAudio;
    }

    public void setDureeAudio(int dureeAudio) {
        this.dureeAudio = dureeAudio;
    }
}