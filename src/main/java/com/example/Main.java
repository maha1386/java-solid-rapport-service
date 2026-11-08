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
        ConfigurationMediatheque config =
                new ConfigurationMediatheque(21, 5);

        Catalogue<Document> catalogue = new Catalogue<>();

        EmpruntManager manager =    new EmpruntManager(catalogue, config);

        System.out.println("Durée emprunt : "
                + config.getDureeEmprunt());

        System.out.println("Nombre maximum d'emprunts : "
                + config.getNombreMaxEmprunts());
    ImporteurCsv importeur = new ImporteurCsv();

        List<String> lignes = List.of(
                "livre;Java;2024;Ahmed;350",
                "dvd;Inception;2010;148",
                "revue;Science;2023;12"
        );

        List<Document> documents = importeur.importer(lignes);

        System.out.println("\nDocuments importés :");

        for (Document d : documents) {
            System.out.println(d.descriptionCourte());
        }


        // =====================================
        // 4. PARTIE FACTORY METHOD : LIVRE AUDIO
        // =====================================

        ImporteurLignesLivresAudio importeurAudio =
                new ImporteurLignesLivresAudio();

        List<String> lignesAudio = List.of(
                "livre-audio;Java avance;2025;Ahmed;300;180"
        );

        List<Document> livresAudio =
                importeurAudio.importer(lignesAudio);

        System.out.println("\nLivres audio importés :");

        for (Document d : livresAudio) {
            System.out.println(d.descriptionCourte());
        }

    }


}
