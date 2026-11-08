package com.example;

public class ConfigurationMediatheque {
    private int dureeEmprunt;
    private int nombreMaxEmprunts;
    
    public ConfigurationMediatheque(int dureeEmprunt,int nombreMaxEmprunts) {
        this.dureeEmprunt = dureeEmprunt;
        this.nombreMaxEmprunts = nombreMaxEmprunts;
    }

    public int getDureeEmprunt() {
        return dureeEmprunt;
    }

    public int getNombreMaxEmprunts() {
        return nombreMaxEmprunts;
    }

    public void setDureeEmprunt(int dureeEmprunt) {
        this.dureeEmprunt = dureeEmprunt;
    }

    public void setNombreMaxEmprunts(int nombreMaxEmprunts) {
        this.nombreMaxEmprunts = nombreMaxEmprunts;
    }
}
