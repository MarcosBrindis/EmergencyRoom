package com.MarcosBrindis.emergencyroom.controllers;

import com.MarcosBrindis.emergencyroom.models.Emergency;
import com.MarcosBrindis.emergencyroom.models.Patient;
import com.MarcosBrindis.emergencyroom.models.PatientRegistry;
import com.MarcosBrindis.emergencyroom.models.TraumaEmergency;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FormularioController {
    private int selectedIndex = -1;
    @FXML
    private ComboBox<String> cboTipo;
    @FXML
    private ComboBox<String> cboGrabe;
    @FXML
    private ListView<Emergency> lstPaciente;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtAlergia;
    @FXML
    private TextField txtSintomas;
    @FXML
    private TextField txtObsevaciones;
    @FXML
    private TextField txtCausa;
    @FXML
    private TextField txtUbicacionLesion;
    @FXML
    private TextField txtGravedadLesion;
    @FXML
    private ToggleGroup genero;

    @FXML
    private RadioButton rbDiabetes;
    @FXML
    private RadioButton rbHipertension;
    @FXML
    private RadioButton rbEnfermedadesCardiacas;
    @FXML
    private RadioButton rbOtras;
    ///////////////////////////////////////////////////////////
    @FXML
    private TextField txtName1;
    @FXML
    private TextField txtEdad1;
    @FXML
    private TextField txtTelefono1;
    @FXML
    private TextField txtAlergia1;
    @FXML
    private RadioButton rbDiabetes1;
    @FXML
    private RadioButton rbHipertension1;
    @FXML
    private RadioButton rbEnfermedadesCardiacas1;
    @FXML
    private RadioButton rbOtras1;
    @FXML
    private ComboBox<String> cboGrabe1;
    @FXML
    private TextField txtSintomas1;
    @FXML
    private TextField txtObsevaciones1;
    private PatientRegistry patientRegistry;


    public FormularioController() {
    }

    public void setPatientRegistry(PatientRegistry patientRegistry) {
        this.patientRegistry = patientRegistry;
    }

    @FXML
    private void initialize() {
        ArrayList<String> tiposEmergencia = new ArrayList<>();
        tiposEmergencia.add("Medica");
        tiposEmergencia.add("Traumatologica");

        ArrayList<String> gravedadEmergencia = new ArrayList<>();
        gravedadEmergencia.add("Verde");
        gravedadEmergencia.add("Amarillo");
        gravedadEmergencia.add("Rojo");
        cboTipo.getItems().addAll(tiposEmergencia);
        cboGrabe.getItems().addAll(gravedadEmergencia);
        cboGrabe1.getItems().addAll(gravedadEmergencia);
//////////////////////////////////////////////////////////////////////
        patientRegistry = new PatientRegistry();

        lstPaciente.setCellFactory(param -> new ListCell<Emergency>() {
            @Override
            protected void updateItem(Emergency item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
        });

        lstPaciente.getItems().setAll(patientRegistry.getFormulario());

        lstPaciente.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    selectedIndex = newValue.intValue();
                    Emergency selectedEmergency = lstPaciente.getItems().get(selectedIndex);
                    mostrarDatos(selectedEmergency);
                }
        );
        /////////////////////////////////////////////////////////////////////
        lstPaciente.getSelectionModel().selectedIndexProperty().addListener(
                (observable, oldValue, newValue) -> {
                    selectedIndex = newValue.intValue();
                    Emergency selectedEmergency = lstPaciente.getItems().get(selectedIndex);
                    mostrarDatos(selectedEmergency);
                }
        );

    }


    @FXML
    public void guardar() {
        boolean esRoja;
        String tipoEmergencia = cboTipo.getValue();
        String gravedadEmergencia = cboGrabe.getValue();
        if (tipoEmergencia != null && gravedadEmergencia != null) {
            Patient patient = new Patient(
                    txtName.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    txtTelefono.getText(),
                    ((RadioButton) genero.getSelectedToggle()).getText(),
                    txtAlergia.getText(),
                    getAntecedentesSeleccionados());
            Emergency emergency;
            esRoja = gravedadEmergencia.contains("Rojo");
            if (tipoEmergencia.equals("Medica")) {
                emergency = new Emergency(
                        tipoEmergencia,
                        gravedadEmergencia,
                        esRoja,
                        txtSintomas.getText(),
                        LocalDate.now(),
                        LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
                        txtObsevaciones.getText(),
                        patient);
            } else {
                emergency = new TraumaEmergency(
                        tipoEmergencia,
                        gravedadEmergencia,
                        esRoja,
                        txtSintomas.getText(),
                        LocalDate.now(),
                        LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.MINUTES),
                        txtObsevaciones.getText(),
                        patient,
                        txtCausa.getText(),
                        txtUbicacionLesion.getText(),
                        txtGravedadLesion.getText());
            }
            patientRegistry.addEmergency(emergency);
            lstPaciente.getItems().setAll(patientRegistry.getFormulario());

            //System.out.println("Tamaño del formulario en PatientRegistry: " + patientRegistry.getFormulario().size());
        }
    }
    //MedicoController medicoController = new MedicoController();

    public void actualizarDatos() {
        lstPaciente.getItems().setAll(patientRegistry.getFormulario());
    }


    public void mostrarDatos(Emergency emergency) {
        txtName1.setText(emergency.getPatient().getName());
        txtEdad1.setText(String.valueOf(emergency.getPatient().getAge()));
        txtTelefono1.setText(emergency.getPatient().getPhoneNumber());
        txtAlergia1.setText(emergency.getPatient().getAlergia());
        LimpiarAntecedentes1();
        for (String antecedente : emergency.getPatient().getAntecedentes()) {
            switch (antecedente) {
                case "Diabetes":
                    rbDiabetes1.setSelected(true);
                    break;
                case "Hipertensión arterial":
                    rbHipertension1.setSelected(true);
                    break;
                case "Enfermedades Cardiacas":
                    rbEnfermedadesCardiacas1.setSelected(true);
                    break;
                case "Otras":
                    rbOtras1.setSelected(true);
                    break;
            }
        }
        cboGrabe1.setValue(emergency.getGravedadDeEmergencia());
        txtSintomas1.setText(emergency.getSintomas());
        txtObsevaciones1.setText(emergency.getDetalles());
    }

    public void modificardatos() {
        Emergency selectedEmergency = lstPaciente.getSelectionModel().getSelectedItem();
        if (selectedEmergency != null) {
            selectedEmergency.getPatient().setName(txtName1.getText());
            selectedEmergency.getPatient().setAge(Integer.parseInt(txtEdad1.getText()));
            selectedEmergency.getPatient().setPhoneNumber(txtTelefono1.getText());
            selectedEmergency.getPatient().setAlergia(txtAlergia1.getText());
            selectedEmergency.getPatient().getAntecedentes().clear();
            if (rbDiabetes1.isSelected()) {
                selectedEmergency.getPatient().getAntecedentes().add(rbDiabetes1.getText());
            }
            if (rbHipertension1.isSelected()) {
                selectedEmergency.getPatient().getAntecedentes().add(rbHipertension1.getText());
            }
            if (rbEnfermedadesCardiacas1.isSelected()) {
                selectedEmergency.getPatient().getAntecedentes().add(rbEnfermedadesCardiacas1.getText());
            }
            if (rbOtras1.isSelected()) {
                selectedEmergency.getPatient().getAntecedentes().add(rbOtras1.getText());
            }
            selectedEmergency.setGravedadDeEmergencia(cboGrabe1.getValue());
            selectedEmergency.setSintomas(txtSintomas1.getText());
            selectedEmergency.setDetalles(txtObsevaciones1.getText());
            lstPaciente.getItems().setAll(patientRegistry.getFormulario());
        }
    }

    private void LimpiarAntecedentes1() {
        rbDiabetes1.setSelected(false);
        rbHipertension1.setSelected(false);
        rbEnfermedadesCardiacas1.setSelected(false);
        rbOtras1.setSelected(false);
    }

    public void limpiar() {
        txtName.setText(null);
        txtEdad.setText(null);
        txtTelefono.setText(null);
        genero.selectToggle(null);
        txtAlergia.setText(null);
        LimpiarAntecedentes();
        cboTipo.setValue(null);
        cboGrabe.setValue(null);
        txtSintomas.setText(null);
        txtObsevaciones.setText(null);
        txtCausa.setText(null);
        txtUbicacionLesion.setText(null);
        txtGravedadLesion.setText(null);
    }

    private void LimpiarAntecedentes() {
        rbDiabetes.setSelected(false);
        rbHipertension.setSelected(false);
        rbEnfermedadesCardiacas.setSelected(false);
        rbOtras.setSelected(false);
    }

    private ArrayList<String> getAntecedentesSeleccionados() {
        ArrayList<String> antecedentesSeleccionados = new ArrayList<>();
        if (rbDiabetes.isSelected()) {
            antecedentesSeleccionados.add(rbDiabetes.getText());
        }
        if (rbHipertension.isSelected()) {
            antecedentesSeleccionados.add(rbHipertension.getText());
        }
        if (rbEnfermedadesCardiacas.isSelected()) {
            antecedentesSeleccionados.add(rbEnfermedadesCardiacas.getText());
        }
        if (rbOtras.isSelected()) {
            antecedentesSeleccionados.add(rbOtras.getText());
        }
        return antecedentesSeleccionados;
    }
}

