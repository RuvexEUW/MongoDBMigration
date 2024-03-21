package ch.gibs.mosd.m165.firmenverwaltung.gui;

import ch.gibs.mosd.m165.firmenverwaltung.model.Person;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import ch.gibs.mosd.m165.firmenverwaltung.model.Projekt;
import ch.gibs.mosd.m165.firmenverwaltung.io.db;

public class TabPersonenProjekt {
    public static ObservableList<Person> ProjektList;
    public static ObservableList<Person> PersonenList;
    
    @FXML
    private ListView<Person> PersonenListe;

    @FXML
    private ListView<Person> PersonenProjektListe;

    @FXML
    private Button links;

    @FXML
    private ComboBox<Projekt> projekte;

    @FXML
    private Button rechts;

    @FXML
    void linksAction(ActionEvent event) {
        if (PersonenProjektListe.getSelectionModel().getSelectedItem() == null) return;
        Person p = PersonenProjektListe.getSelectionModel().getSelectedItem();
        PersonenList.add(p);
        ProjektList.remove(p);
        db.deletePersonenProjekt(p.getPid(), projekte.getSelectionModel().getSelectedItem().getPrid());
    }

    @FXML
    void projekteAction(ActionEvent event) {
        populateLists();
    }

    @FXML
    void rechtsAction(ActionEvent event) {
        if (PersonenListe.getSelectionModel().getSelectedItem() == null) return;
        Person p = PersonenListe.getSelectionModel().getSelectedItem();
        ProjektList.add(p);
        PersonenList.remove(p);
        db.insertPersonProjekt(p.getPid(), projekte.getSelectionModel().getSelectedItem().getPrid());
    }
    
    @FXML
    public void initialize() {
        populateProjekte(db.readProjekte());
        populateLists();
    }
    
    public void populateProjekte(ArrayList<Projekt> al) {
        if (al.isEmpty()) return;
        ObservableList<Projekt> pList = FXCollections.observableArrayList(al);
        projekte.setItems(pList);  
        projekte.getSelectionModel().select(0);
    }
    
    public void populateLists() {
        if (projekte.getSelectionModel().isEmpty()) return;
        ArrayList<Person> pl = db.readPersonen(projekte.getSelectionModel().getSelectedItem().getPrid());
        ProjektList = FXCollections.observableArrayList(pl);
        PersonenProjektListe.setItems(ProjektList);
        ArrayList<Person> al = db.readPersonen();
        al.removeAll(pl);
        PersonenList = FXCollections.observableArrayList(al);
        PersonenListe.setItems(PersonenList);
    }

}

