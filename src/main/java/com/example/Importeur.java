package com.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Importeur {
    public final List<Document> importer(List<String> lignes) {
        List<Document> documents = new ArrayList<>();
        for (String ligne : lignes) {
            if (!ligne.isBlank()) {
                documents.add(creerDocument(ligne));
            }
        }
        return documents;
    }

    protected abstract Document creerDocument(String ligne);
}