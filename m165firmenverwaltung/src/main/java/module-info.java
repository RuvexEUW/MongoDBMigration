module ch.gibs.mosd.m165.firmenverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires org.mongodb.driver.core;

    opens ch.gibs.mosd.m165.firmenverwaltung.gui to javafx.fxml;
    exports ch.gibs.mosd.m165.firmenverwaltung.gui;
    exports ch.gibs.mosd.m165.firmenverwaltung.io;
}
