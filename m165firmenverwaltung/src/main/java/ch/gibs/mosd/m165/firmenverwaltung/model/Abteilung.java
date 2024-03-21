package ch.gibs.mosd.m165.firmenverwaltung.model;

/**
 * Datenstruktur zur Speicherung einer Abteilung
 * @author Daniel Mosimann
 */
public class Abteilung {
    private int aid;
    private String abteilung;

    public Abteilung(int aid, String abteilung) {
        this.aid = aid;
        this.abteilung = abteilung;
    }

    public int getAid() {
        return aid;
    }

    public String getAbteilung() {
        return abteilung;
    }
    
    
}
