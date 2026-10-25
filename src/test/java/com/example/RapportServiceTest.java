package com.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RapportServiceTest {

    @Test
    void genereEtNotifie() throws IOException {
        StringBuilder disque = new StringBuilder();
        List<String> notifs = new ArrayList<>();

        RapportService service = new RapportService(
                docs -> "contenu-teste",
                contenu -> disque.append(contenu),
                message -> notifs.add(message)
        );

        service.generer(List.of());

        assertEquals("contenu-teste", disque.toString());
        assertEquals(1, notifs.size());
        assertEquals("Rapport généré", notifs.get(0));
    }

    @Test
    void pasDeNotificationSiEcritureEchoue() {
        List<String> notifs = new ArrayList<>();

        RapportService service = new RapportService(
                docs -> "x",
                contenu -> {
                    throw new IOException("disque plein");
                },
                message -> notifs.add(message)
        );

        assertThrows(
                IOException.class,
                () -> service.generer(List.of())
        );

        assertTrue(notifs.isEmpty());
    }
}