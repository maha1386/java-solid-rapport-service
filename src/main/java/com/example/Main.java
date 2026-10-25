package com.example;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FormatRapport format = new FormatCsv();

        SortieRapport sortie =
                new SortieFichier(Path.of("rapport.csv"));

        Notificateur notificateur =
                new NotificateurSmtp(
                        new ServeurSmtp(),
                        "direction@itbs.tn"
                );

        RapportService service =
                new RapportService(format, sortie, notificateur);

        List<Document> docs = List.of(
                new Livre("Clean Code", 2008, "R. Martin", 464)
        );

        service.generer(docs);

        System.out.println("Rapport terminé.");
    }
}
