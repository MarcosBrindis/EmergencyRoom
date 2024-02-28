package com.MarcosBrindis.emergencyroom.controllers;

import com.MarcosBrindis.emergencyroom.App;
import com.MarcosBrindis.emergencyroom.models.Emergency;
import com.MarcosBrindis.emergencyroom.models.PatientRegistry;
import com.MarcosBrindis.emergencyroom.models.TraumaEmergency;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class MedicoController {

    @FXML
    private Label lblName;
    @FXML
    private Label lblEdad;
    @FXML
    private Label lblTelefono;
    @FXML
    private Label lblGenero;
    @FXML
    private Label lblAlergias;
    @FXML
    private Label lblAntecedentes;
    @FXML
    private Label lblTipo;
    @FXML
    private Label lblGravedad;
    @FXML
    private Label lblSintomas;
    @FXML
    private Label lblObservaciones;
    @FXML
    private Label lblCausa;
    @FXML
    private Label lblUbiLesion;
    @FXML
    private Label lblGravedadLesion;
    @FXML
    private ListView<Emergency> lstPacienteDoc;

    private PatientRegistry patientRegistry;
    private Stage stage;

    public void setPatientRegistry(PatientRegistry patientRegistry) {
        this.patientRegistry = patientRegistry;
        checkData();
    }

    private void checkData() {
        if (patientRegistry != null) {
            lstPacienteDoc.setItems(FXCollections.observableArrayList(patientRegistry.getFormulario()));
        }
    }

    @FXML
    public void actualizarDatos() {
        lstPacienteDoc.getItems().setAll(patientRegistry.getFormulario());
    }

    @FXML
    public void initialize() {
        lstPacienteDoc.setCellFactory(param -> new ListCell<Emergency>() {
            @Override
            protected void updateItem(Emergency item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText("Id: " + item.getPatient().getId() + " " + "Nombre " + item.getPatient().getName() + " " + "Tipo: " + item.getTipodeEmergencia() + ", Gravedad: " + item.getGravedadDeEmergencia());
                    lblName.setText(" " + item.getPatient().getName());
                    lblEdad.setText(" " + item.getPatient().getAge());
                    lblTelefono.setText(item.getPatient().getPhoneNumber());
                    lblGenero.setText(" " + item.getPatient().getGender());
                    lblAlergias.setText(" " + item.getPatient().getAlergia());
                    lblAntecedentes.setText(" " + item.getPatient().getAntecedentes());
                    lblTipo.setText(" " + item.getTipodeEmergencia());
                    lblGravedad.setText(" " + item.getGravedadDeEmergencia());
                    lblSintomas.setText(" " + item.getSintomas());
                    lblObservaciones.setText(" " + item.getDetalles());
                    lblCausa.setText(" ");
                    lblUbiLesion.setText(" ");
                    lblGravedadLesion.setText(" ");
                    if (item instanceof TraumaEmergency) {
                        TraumaEmergency traumaEmergency = (TraumaEmergency) item;
                        lblCausa.setText(" " + traumaEmergency.getCausa());
                        lblGravedadLesion.setText(" " + traumaEmergency.getGravedadLesion());
                        lblUbiLesion.setText(" " + traumaEmergency.getUbicacionLesion());
                    } else {
                        lblCausa.setText(" ");
                        lblGravedadLesion.setText(" ");
                        lblUbiLesion.setText(" ");
                    }

                }
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void abrirAlertaRoja(ActionEvent event) {
        for (Emergency emergency : patientRegistry.getFormulario()) {
            if (emergency.isEsRoja()) {
                try {
                    Stage stage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("alertaRoja.fxml"));
                    Pane root = fxmlLoader.load();
                    Scene scene = new Scene(root, 450, 200);
                    stage.setTitle("ALERTA");
                    stage.setScene(scene);
                    stage.show();
                    AlertaRojaController alertaRojaController = fxmlLoader.getController();
                    alertaRojaController.setTipoEmergencia(emergency.getTipodeEmergencia());
                    alertaRojaController.setLblNameAlerta(emergency.getPatient().getName());
                    alertaRojaController.setLblIdAlerta(emergency.getPatient().getId());
                    emergency.setEsRoja(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private FormularioController formularioController;

    public void setFormularioController(FormularioController formularioController) {
        this.formularioController = formularioController;
    }
}