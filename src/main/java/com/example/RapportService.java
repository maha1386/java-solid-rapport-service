package com.example;

import java.io.IOException;
import java.util.List;

public class RapportService {

    private final FormatRapport format;
    private final SortieRapport sortie;
    private final Notificateur notificateur;

    public RapportService(
            FormatRapport format,
            SortieRapport sortie,
            Notificateur notificateur) {

        this.format = format;
        this.sortie = sortie;
        this.notificateur = notificateur;
    }

    public void generer(List<Document> docs)
            throws IOException {

        String contenu = format.formater(docs);

        sortie.ecrire(contenu);

        // La notification est envoyée seulement
        // si l'écriture a réussi.
        notificateur.notifier("Rapport généré");
    }
}