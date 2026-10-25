package com.example;

import com.example.Exceptions.CatalogueCorrompuException;
import com.example.Exceptions.MediathequeException;

import java.nio.file.Path;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CauseEtRessourcesTest {

    @Test
    void causeIOExceptionConservee() {
        CatalogueCorrompuException ex = assertThrows(
            CatalogueCorrompuException.class,
            () -> ChargeurCatalogue.chargerTitres(
                Path.of("fichier_inexistant.txt"))
        );

        assertInstanceOf(IOException.class, ex.getCause());
    }

    @Test
    void rapportFermeSiEmpruntEchoue() {
        RapportEmprunt rapport = new RapportEmprunt();
        EmpruntManager manager =
            new EmpruntManager(new Catalogue<>());

        assertThrows(MediathequeException.class, () -> {
            try (rapport) {
                manager.emprunter("Fantome");
            }
        });

        assertTrue(rapport.estFerme());
    }
}
