module towerDefense {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    opens sample;
    opens map;
    opens grid;
    opens graphics;
    opens mapSaves;
}