package ch.gibs.mosd.m165.firmenverwaltung.model;

/**
 * Datenstruktur zur Speicherung einer Person
 * @author Daniel Mosimann
 */
public class Person {
    private int pid;
    private String name;
    private String vorname;
    private String strasse;
    private Ort ort;
    private Abteilung abteilung;

    public Person(int pid, String name, String vorname, String strasse, Ort ort, Abteilung abteilung) {
        this.pid = pid;
        this.name = name;
        this.vorname = vorname;
        this.strasse = strasse;
        this.ort = ort;
        this.abteilung = abteilung;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getStrasse() {
        return strasse;
    }

    public Ort getOrt() {
        return ort;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }
    
    public String getAbtName() {
        return abteilung.getAbteilung();
    }
    
    public int getPlz() {
        return ort.getPlz();
    }
    
    public String getOrtname() {
        return ort.getOrt();
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }
    
    @Override
    public String toString() {
        return getName()+" "+getVorname();
    }
   
    @Override
    public boolean equals(Object obj) {
        if ( obj == null) return false;
        Person p = (Person) obj;
        if (this.pid == p.getPid()) return true;
        else return false;
    }
    
 }