/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class ICadastroMedico {
    
    @FXML
    TextField textFieldNomeMedico;
    
    @FXML
    DatePicker dataNascimento;
    
    @FXML
    TextField textFieldCRM;
    
    @FXML
    TextField textFieldSetor;
    
    @FXML
    TextField textFieldCargaHoraria;
    
    @FXML
    CheckBox checkBoxCardiologia;
    
    @FXML
    CheckBox checkBoxPediatria;
    
    @FXML
    CheckBox checkBoxOncologia;
    
    @FXML
    CheckBox checkBoxGinecologia;
    
    @FXML
    CheckBox checkBoxGastroenterologia;
    
    @FXML
    CheckBox checkBoxUrologia;
    
    @FXML
    CheckBox checkBoxOftamologia;
    
    @FXML
    CheckBox checkBoxPsiquiatra;
    
    @FXML
    CheckBox checkBoxReumatologia;
    
    @FXML
    CheckBox checkBoxNeurologia;
    
    @FXML
    CheckBox checkBoxOrtopedia;
    
    @FXML
    CheckBox checkBoxAngiologia ;
    
    @FXML
    TextField textFieldRua;
    
    @FXML
    TextField textFieldNumero;
    
    @FXML
    TextField textFieldBairro;
    
    @FXML
    TextField textFieldCidade;
    
    @FXML
    TextField textFieldEstado;
    
    @FXML
    TextField textFieldCEP;
    
    @FXML
    TextField textFieldCelular;
    
    @FXML
    TextField textFieldTelefone;
    
    @FXML
    TextField textFieldEmail;
    
    @FXML
    RadioButton radioBtnM;
    
    @FXML
    RadioButton radioBtnF;
    
    @FXML
    RadioButton radioBtnSim;
    
    @FXML
    RadioButton radioBtnNao;
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
}
