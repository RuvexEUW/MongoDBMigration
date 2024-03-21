package ch.gibs.mosd.m165.firmenverwaltung.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.gibs.mosd.m165.firmenverwaltung.io.db;
import ch.gibs.mosd.m165.firmenverwaltung.model.Person;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TabPersonen {
    public static ObservableList<Person> pList;

    @FXML
    private Button add;

    @FXML
    private TableColumn<Person, String> colPlz;

    @FXML
    private TableView<Person> TabellePersonen;

    @FXML
    private TableColumn<Person, String> colName;

    @FXML
    private Button edit;

    @FXML
    private TableColumn<Person, String> colStrasse;

    @FXML
    private TableColumn<Person, String> colVorname;

    @FXML
    private TableColumn<Person, String> colAbteilung;

    @FXML
    private TableColumn<Person, String> colId;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<Person, String> colOrt;

    @FXML
    void addAction(ActionEvent event) {
    }

    @FXML
    void editAction(ActionEvent event) {

    }

    @FXML
    void deleteAction(ActionEvent event) {
        
    }
    
    @FXML
    public void initialize() {
        setupTable();
    }
    
    private void setupTable() {
        colId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPid())));
        colName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));
        colVorname.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getVorname())));
        colStrasse.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getStrasse())));
        colPlz.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPlz())));
        colOrt.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getOrtname())));
        colAbteilung.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAbtName())));
        pList = FXCollections.observableArrayList(db.readPersonen());
        TabellePersonen.setItems(pList);
    }
}
