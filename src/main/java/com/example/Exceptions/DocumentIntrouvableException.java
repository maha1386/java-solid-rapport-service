package com.example.Exceptions;

public class DocumentIntrouvableException extends MediathequeException {
    public DocumentIntrouvableException(String titre) {
        super("Document introuvable : " + titre);
    }
}