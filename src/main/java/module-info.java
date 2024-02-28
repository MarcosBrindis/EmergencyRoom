module com.mercosbrindis.emergencyroom {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.MarcosBrindis.emergencyroom to javafx.fxml;
    exports com.MarcosBrindis.emergencyroom;
    exports com.MarcosBrindis.emergencyroom.controllers;
    opens com.MarcosBrindis.emergencyroom.controllers to javafx.fxml;
}