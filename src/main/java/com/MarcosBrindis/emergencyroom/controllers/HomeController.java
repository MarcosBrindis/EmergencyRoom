package com.MarcosBrindis.emergencyroom.controllers;

import com.MarcosBrindis.emergencyroom.App;
import com.MarcosBrindis.emergencyroom.models.PatientRegistry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.layout.Pane;

public class HomeController {
    private PatientRegistry patientRegistry = new PatientRegistry();

    @FXML
    public void abrirFormularioView(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("formulario-view.fxml"));
            Pane root = fxmlLoader.load();

            FormularioController formularioController = fxmlLoader.getController();
            formularioController.setPatientRegistry(patientRegistry);

            Scene scene = new Scene(root, 900, 570);
            stage.setTitle("Emergencias");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirMedicoView(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Medico-view.fxml"));
            Pane root = fxmlLoader.load();

            MedicoController medicoController = fxmlLoader.getController();
            medicoController.setPatientRegistry(patientRegistry);
            fxmlLoader.<MedicoController>getController().initialize();

            //System.out.println("PatientRegistry en HomeController: " + patientRegistry);

            Scene scene = new Scene(root, 900, 570);
            stage.setTitle("Bienvenido Doctor");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}