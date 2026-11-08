package com.example;
import com.example.Exceptions.MediathequeException;
import com.example.Exceptions.DocumentIntrouvableException;
import com.example.Exceptions.DocumentIndisponibleException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    @Test
    void empruntDocumentInconnu() {

        Catalogue<Document> catalogue = new Catalogue<>();

        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        EmpruntManager m =
                new EmpruntManager(catalogue, config);

        assertThrows(
                DocumentIntrouvableException.class,
                () -> m.emprunter("Inconnu")
        );
    }

    @Test
    void empruntDocumentNonEmpruntable() {

        Catalogue<Document> catalogue = new Catalogue<>();

        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        EmpruntManager m =
                new EmpruntManager(catalogue, config);

        Document document =
                new Document("Document test", 2024) {
                    @Override
                    public String descriptionCourte() {
                        return "Document test";
                    }
                };

        catalogue.ajouter(document);

        assertThrows(
                DocumentIndisponibleException.class,
                () -> m.emprunter("Document test")
        );
    }

    @Test
    void empruntDocumentDisponible() throws MediathequeException {

        Catalogue<Document> catalogue = new Catalogue<>();

        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        EmpruntManager m =
                new EmpruntManager(catalogue, config);

        Livre livre = new Livre(
                "Clean Code", 2008, "Robert Martin", 464
        );

        catalogue.ajouter(livre);

        assertDoesNotThrow(() -> m.emprunter("Clean Code"));
    }

    @Test
    void empruntDocumentDejaEmprunte() throws MediathequeException {

        Catalogue<Document> catalogue = new Catalogue<>();

        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        EmpruntManager m =
                new EmpruntManager(catalogue, config);

        Livre livre = new Livre(
                "Java", 2024, "Ahmed", 350
        );

        catalogue.ajouter(livre);

        m.emprunter("Java");

        assertThrows(
                DocumentIndisponibleException.class,
                () -> m.emprunter("Java")
        );
    }
}