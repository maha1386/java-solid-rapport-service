package com.example;

import com.example.Exceptions.DocumentIndisponibleException;

public interface Empruntable {
    void emprunter () throws DocumentIndisponibleException;
    void rendre ();
    boolean estDisponible ();
}
