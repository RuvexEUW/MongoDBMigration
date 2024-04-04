package ch.gibs.mosd.m165.firmenverwaltung.io;

import ch.gibs.mosd.m165.firmenverwaltung.model.Abteilung;
import ch.gibs.mosd.m165.firmenverwaltung.model.Ort;
import ch.gibs.mosd.m165.firmenverwaltung.model.Person;
import ch.gibs.mosd.m165.firmenverwaltung.model.Projekt;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Datenbankfunktionen
 * @author Daniel Mosimann
 */
public class db {
    private static Connection c=null;

    private static void connect() {
        try {
            String uri = "mongodb://localhost:27017";
            MongoClient mongoClient = MongoClients.create(uri);
            
            if ( db.c == null ) db.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/m165firma","root", "");
	}
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);           
        }
    }   
    
    public static ArrayList<Person> readPersonen() {
        ArrayList<Person> PersonenListe = new ArrayList();
	db.connect();
        
	try {
            Statement stmt = c.createStatement();
            String query = "select * from personen order by name, vorname";
            ResultSet rs = stmt.executeQuery( query );
            while ( rs.next() ) {
                PersonenListe.add(new Person( rs.getInt("pid"), 
                                            rs.getString("name"),
                                            rs.getString("vorname"),
                                            rs.getString("strasse"),
                                            readOrt(rs.getInt("oid")),
                                            readAbteilung(rs.getInt("aid"))));
            }
	}
	catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}
        
        return PersonenListe;
    }
    
    public static ArrayList<Person> readPersonen(int prid) {
        ArrayList<Person> PersonenListe = new ArrayList();
	db.connect();
        
	try {
            Statement stmt = c.createStatement();
            String query = "select * from personen inner join `personen-projekt`  on personen.pid=`personen-projekt`.pid where prid='"+prid+"' order by name, vorname";
            ResultSet rs = stmt.executeQuery( query );
            while ( rs.next() ) {
                PersonenListe.add(new Person( rs.getInt("pid"), 
                                            rs.getString("name"),
                                            rs.getString("vorname"),
                                            rs.getString("strasse"),
                                            readOrt(rs.getInt("oid")),
                                            readAbteilung(rs.getInt("aid"))));
            }
	}
	catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}
        
        return PersonenListe;
    }
    
    public static Ort readOrt( int oid ) {
        try {
            Statement stmt = c.createStatement();
            String query = "select * from ort where oid='"+oid+"'";
            ResultSet rs = stmt.executeQuery( query );
            rs.next();
            return new Ort(rs.getInt("oid"), rs.getInt("plz"), rs.getString("ort"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}        
        return null;
    } 
    
    public static ArrayList<Abteilung> readAbteilungen() {
        ArrayList<Abteilung> al = new ArrayList();
        try {
            Statement stmt = c.createStatement();
            String query = "select * from abteilung";
            ResultSet rs = stmt.executeQuery( query );
            while ( rs.next() ) {
                al.add(new Abteilung(rs.getInt("aid"),rs.getString("abteilung")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}        
        return null;
    } 
    
    public static Abteilung readAbteilung( int aid ) {
        try {
            Statement stmt = c.createStatement();
            String query = "select * from abteilung where aid='"+aid+"'";
            ResultSet rs = stmt.executeQuery( query );
            rs.next();
            return new Abteilung(rs.getInt("aid"), rs.getString("abteilung"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}        
        return null;
    } 
    
    public static ArrayList<Projekt> readProjekte() {
        ArrayList<Projekt> ProjektListe = new ArrayList();
	db.connect();
        
	try {
            Statement stmt = c.createStatement();
            String query = "select * from projekt order by projekt";
            ResultSet rs = stmt.executeQuery( query );
            while ( rs.next() ) {
                ProjektListe.add(new Projekt( rs.getInt("prid"), 
                                            rs.getString("projekt")));
            }
	}
	catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
	}
        
        return ProjektListe;       
    }
    
    public static void insertPersonProjekt( int pid, int prid ){
        db.connect();
        String sql = "INSERT INTO `personen-projekt` (pid, prid) VALUES ('"+pid+"','"+prid+"')";
         try {
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void deletePersonenProjekt( int pid, int prid ) {
        String sql = "delete from `personen-projekt` where pid='"+pid+"' and prid='"+prid+"'";
        try {
            Statement stmt = c.createStatement();
            stmt.executeUpdate(sql);              
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
