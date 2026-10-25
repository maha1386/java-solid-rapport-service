package com.example;
import com.example.Exceptions.MediathequeException;
import com.example.Exceptions.DocumentIntrouvableException;
import com.example.Exceptions.DocumentIndisponibleException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    @Test
    void empruntDocumentInconnu() {
        EmpruntManager m = new EmpruntManager(new Catalogue<>());

        DocumentIntrouvableException ex = assertThrows(
            DocumentIntrouvableException.class,
            () -> m.emprunter("Fantome")
        );

        assertTrue(ex.getMessage().contains("Fantome"));
    }

    @Test
    void doubleEmprunt() throws MediathequeException {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre("Clean Code", 2008, "R. Martin", 464));

        EmpruntManager m = new EmpruntManager(c);
        m.emprunter("Clean Code");

        DocumentIndisponibleException ex = assertThrows(
            DocumentIndisponibleException.class,
            () -> m.emprunter("Clean Code")
        );

        assertTrue(ex.getMessage().contains("Clean Code"));
    }

    @Test
    void revueNonEmpruntable() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Revue("Science", 2026, 412));

        EmpruntManager m = new EmpruntManager(c);

        DocumentIndisponibleException ex = assertThrows(
            DocumentIndisponibleException.class,
            () -> m.emprunter("Science")
        );

        assertTrue(ex.getMessage().contains("Science"));
    }

    @Test
    void empruntRetourNouvelEmprunt() throws MediathequeException {
        Livre l = new Livre("Dune", 1965, "F. Herbert", 612);
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(l);

        EmpruntManager m = new EmpruntManager(c);
        m.emprunter("Dune");

        assertFalse(l.estDisponible());

        l.rendre();

        assertDoesNotThrow(() -> m.emprunter("Dune"));
    }
}