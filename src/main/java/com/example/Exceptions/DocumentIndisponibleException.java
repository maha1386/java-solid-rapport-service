package com.example.Exceptions;

public class DocumentIndisponibleException extends MediathequeException {

    public DocumentIndisponibleException(String titre) {
        super("Document indisponible : " + titre);
    }

    public DocumentIndisponibleException(String titre, String motif) {
        super("Document indisponible : " + titre + " - " + motif);
    }
}