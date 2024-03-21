package ch.gibs.mosd.m165.firmenverwaltung.model;

/**
 * Datenstruktur zur Speicherung einer Ortschaft
 * @author Daniel Mosimann
 */
public class Ort {
    private int oid;
    private int plz;
    private String ort;

    public Ort(int oid, int plz, String ort) {
        this.oid = oid;
        this.plz = plz;
        this.ort = ort;
    }

    public int getOid() {
        return oid;
    }

    public int getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }
    
    
    
}
