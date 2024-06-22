/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class IVisualizaConsulta {
    
    @FXML
    TextField textFieldNomeMedico;
    
    @FXML
    TextField textFieldCRM;
    
    @FXML
    TextField textFieldNomePaciente;
    
    @FXML
    TextField textFieldIdade;
    
    @FXML
    TextField textFieldQueixa;
    
    @FXML
    TextArea textAreaDiagnostico;
    
    @FXML
    TextArea textAreaPrescricao;
    
    @FXML
    RadioButton radioBtnSim;
    
    @FXML
    RadioButton radioBtnNao;
    
    @FXML
    ChoiceBox<Medico> cbMedico;
    
    @FXML
    ChoiceBox<Paciente> cbPaciente;
    
    @FXML
    ChoiceBox<ConsultaMedica> cbConsulta;
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
}
