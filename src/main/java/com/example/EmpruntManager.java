package com.example;
import com.example.Exceptions.MediathequeException;
import com.example.Exceptions.DocumentIntrouvableException;
import com.example.Exceptions.DocumentIndisponibleException;

public class EmpruntManager {

    private final Catalogue<Document> catalogue;
    private final ConfigurationMediatheque configuration;

    public EmpruntManager(
            Catalogue<Document> catalogue,
            ConfigurationMediatheque configuration) {

        this.catalogue = catalogue;
        this.configuration = configuration;
    }

    public void emprunter(String titre) throws MediathequeException {

        Document d = catalogue.rechercherParTitre(titre)
            .orElseThrow(() -> new DocumentIntrouvableException(titre));

        if (!(d instanceof Empruntable e)) {
            throw new DocumentIndisponibleException(
                titre, "consultation sur place uniquement");
        }

        e.emprunter();
    }
}