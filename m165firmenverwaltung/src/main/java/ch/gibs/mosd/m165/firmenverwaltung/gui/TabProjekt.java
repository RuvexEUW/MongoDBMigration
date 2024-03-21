package ch.gibs.mosd.m165.firmenverwaltung.gui;

import ch.gibs.mosd.m165.firmenverwaltung.io.db;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.gibs.mosd.m165.firmenverwaltung.model.Projekt;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TabProjekt {
    public static ObservableList<Projekt> pList;

    @FXML
    private TableView<Projekt> TabelleProjekte;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Projekt, String> colId;

    @FXML
    private TableColumn<Projekt, String> colProjekt;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void deleteAction(ActionEvent event) {

    }

    @FXML
    void editAction(ActionEvent event) {

    }
    
 @FXML
    public void initialize() {
        setupTable();
    }
    
    private void setupTable() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrid())));
        colProjekt.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getProjekt())));
        
        pList = FXCollections.observableArrayList(db.readProjekte());
        TabelleProjekte.setItems(pList);
    }

}
