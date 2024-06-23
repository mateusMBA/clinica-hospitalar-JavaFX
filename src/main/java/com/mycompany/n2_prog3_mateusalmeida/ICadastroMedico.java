/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Endereco;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class ICadastroMedico implements Initializable{
    
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
    CheckBox checkBoxPsiquiatria;
    
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioBtnM.setSelected(true);
        radioBtnSim.setSelected(true);
    }
    
    private void limparCampos(){
        textFieldNomeMedico.setText("");
        dataNascimento.setValue(null);
        textFieldCRM.setText("");
        radioBtnSim.setSelected(true);
        radioBtnNao.setSelected(false);
        radioBtnM.setSelected(true);
        radioBtnF.setSelected(false);
        textFieldSetor.setText("");
        textFieldCargaHoraria.setText("");
        checkBoxCardiologia.setSelected(false);
        checkBoxGinecologia.setSelected(false);
        checkBoxOftamologia.setSelected(false);
        checkBoxNeurologia.setSelected(false);
        checkBoxPediatria.setSelected(false);
        checkBoxGastroenterologia.setSelected(false);
        checkBoxPsiquiatria.setSelected(false);
        checkBoxOrtopedia.setSelected(false);
        checkBoxOncologia.setSelected(false);
        checkBoxUrologia.setSelected(false);
        checkBoxReumatologia.setSelected(false);
        checkBoxAngiologia.setSelected(false);
        textFieldRua.setText("");
        textFieldNumero.setText("");
        textFieldBairro.setText("");
        textFieldCidade.setText("");
        textFieldEstado.setText("");
        textFieldCEP.setText("");
        textFieldTelefone.setText("");
        textFieldCelular.setText("");
        textFieldEmail.setText("");
    }
    
    @FXML
    private void salvarMedico() throws IOException{
        //Preenche as variaveis com as informacoes dos campos para criar um objeto do tipo Medico
       try{
            String nome = textFieldNomeMedico.getText();
            Date dataNascimento = Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC));
            int CRM = Integer.parseInt(textFieldCRM.getText());
            boolean cirurgiao;
            if(radioBtnSim.isSelected())
                cirurgiao = true;
            else
                cirurgiao = false;
            Genero genero;
            if(radioBtnM.isSelected())
                genero = Genero.M;
            else
                genero = Genero.F;
            String setor = textFieldSetor.getText();
            int cargaHoraria = Integer.parseInt(textFieldCargaHoraria.getText());
            ArrayList<String> especialidades = new ArrayList<>();
            if(checkBoxCardiologia.isSelected())
                especialidades.add("Cardiologia");
            if(checkBoxGinecologia.isSelected())
                especialidades.add("Ginecologia");
            if(checkBoxOftamologia.isSelected())
                especialidades.add("Oftamologia");
            if(checkBoxNeurologia.isSelected())
                especialidades.add("Neurologia");
            if(checkBoxPediatria.isSelected())
                especialidades.add("Pediatria");
            if(checkBoxGastroenterologia.isSelected())
                especialidades.add("Gastroenterologia");
            if(checkBoxPsiquiatria.isSelected())
                especialidades.add("Psiquiatria");
            if(checkBoxOrtopedia.isSelected())
                especialidades.add("Ortopedia");
            if(checkBoxOncologia.isSelected())
                especialidades.add("Oncologia");
            if(checkBoxUrologia.isSelected())
                especialidades.add("Urologia");
            if(checkBoxReumatologia.isSelected())
                especialidades.add("Reumatologia");
            if(checkBoxAngiologia.isSelected())
                especialidades.add("Angiologia");
            String rua = textFieldRua.getText();
            int numero = Integer.parseInt(textFieldNumero.getText());
            String bairro = textFieldBairro.getText();
            String cidade = textFieldCidade.getText();
            String estado = textFieldEstado.getText();
            int cep = Integer.parseInt(textFieldCEP.getText());
            String telefone = textFieldTelefone.getText();
            String celular = textFieldCelular.getText();
            String email = textFieldEmail.getText();
            Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
            ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
            Medico medico = new Medico(CRM, especialidades, cirurgiao, setor, cargaHoraria, nome, dataNascimento, endereco, contato, genero);
            TelaPrincipal.arrayMedicos.add(medico);
            //JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso");
            limparCampos();
       }catch(NumberFormatException e){
            //JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
       }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Tente Novamente");
       }
    }
    
    @FXML
    private void selecionarGeneroF() throws IOException{
        if(radioBtnF.isSelected())
            radioBtnM.setSelected(false);
        else
            radioBtnM.setSelected(true);
    }
    
    @FXML
    private void selecionarGeneroM() throws IOException{
        if(radioBtnM.isSelected())
            radioBtnF.setSelected(false);
        else
            radioBtnF.setSelected(true);
    }
    
    @FXML
    private void selecionarCirurgiaoNao() throws IOException{
        if(radioBtnNao.isSelected())
            radioBtnSim.setSelected(false);
        else
            radioBtnSim.setSelected(true);
    }
    
    @FXML
    private void selecionarCirurgiaoSim() throws IOException{
        if(radioBtnSim.isSelected())
            radioBtnNao.setSelected(false);
        else
            radioBtnNao.setSelected(true);
    }
    
}
