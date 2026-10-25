package com.example;

public class ServeurSmtp {

    public void envoyer(String destinataire, String message) {
        System.out.println(
            "Notification destinée à " + destinataire
            + " : " + message
        );
    }
}