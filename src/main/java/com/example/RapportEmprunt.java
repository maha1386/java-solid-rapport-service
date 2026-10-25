package com.example;

import java.util.ArrayList;
import java.util.List;
public class RapportEmprunt implements AutoCloseable {

    private final List<String> titres = new ArrayList<>();
    private boolean ferme = false;

    public void ajouterTitre(String titre) {
        if (ferme) {
            throw new IllegalStateException("Rapport fermé");
        }
        titres.add(titre);
    }

    public List<String> getTitres() {
        return List.copyOf(titres);
    }

    public boolean estFerme() {
        return ferme;
    }

    @Override
    public void close() {
        ferme = true;
    }
}