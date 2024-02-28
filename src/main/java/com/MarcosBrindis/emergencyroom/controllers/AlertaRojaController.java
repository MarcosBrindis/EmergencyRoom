package com.MarcosBrindis.emergencyroom.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class AlertaRojaController {

    @FXML
    private Label lblIdAlerta;

    @FXML
    private Label lblNameAlerta;

    @FXML
    private Label lblTipoAlerta;
    @FXML
    private Button btnCerrar;

    public void setTipoEmergencia(String tipoEmergencia) {
        lblTipoAlerta.setText(tipoEmergencia);
    }

    public void setLblNameAlerta(String nombre) {
        lblNameAlerta.setText(nombre);
    }

    public void setLblIdAlerta(int id) {
        lblIdAlerta.setText(String.valueOf(id));
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }


}
