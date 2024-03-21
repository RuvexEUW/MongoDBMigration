package ch.gibs.mosd.m165.firmenverwaltung.model;

/**
 * Datenstruktur zur Speicherung von Projekten
 * @author Daniel Mosimann
 */
public class Projekt {
    private int prid;
    private String projekt;

    public Projekt(int prid, String projekt) {
        this.prid = prid;
        this.projekt = projekt;
    }

    public int getPrid() {
        return prid;
    }

    public String getProjekt() {
        return projekt;
    }
    
    @Override
    public String toString() {
        return getProjekt();
    }
}
