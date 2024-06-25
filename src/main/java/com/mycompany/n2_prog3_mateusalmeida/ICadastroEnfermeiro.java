/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Endereco;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Date;

/**
 *
 * @author mateu
 */
public class ICadastroEnfermeiro implements Initializable{
    
    @FXML
    TextField textFieldNomeEnfermeiro;
    
    @FXML
    DatePicker dataNascimento;
    
    @FXML
    TextField textFieldSetor;
    
    @FXML
    TextField textFieldCargaHoraria;
    
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
        textFieldNomeEnfermeiro.setText("");
        dataNascimento.setValue(null);
        radioBtnSim.setSelected(true);
        radioBtnNao.setSelected(false);
        radioBtnM.setSelected(true);
        radioBtnF.setSelected(false);
        textFieldSetor.setText("");
        textFieldCargaHoraria.setText("");
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
    private void salvarEnfermeiro() throws IOException{
        //Preenche as variaveis com as informacoes dos campos para criar um objeto do tipo Medico
       try{
            String nome = textFieldNomeEnfermeiro.getText();
            Date data = null;
            Date dataNascimento = Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC));
            boolean raioX;
            if(radioBtnSim.isSelected())
                raioX = true;
            else
                raioX = false;
            Genero genero;
            if(radioBtnM.isSelected())
                genero = Genero.M;
            else
                genero = Genero.F;
            String setor = textFieldSetor.getText();
            int cargaHoraria = Integer.parseInt(textFieldCargaHoraria.getText());
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
            Enfermeiro enfermeiro = new Enfermeiro(raioX, setor, cargaHoraria, nome, dataNascimento, endereco, contato, genero);
            TelaPrincipal.arrayEnfermeiros.add(enfermeiro);
            ErrorHandler.exibirMsgInfo("Enfermeiro cadastrado com sucesso", "Cadastro Enfermeiro");
            limparCampos();
       }catch(NumberFormatException e){
            ErrorHandler.exibirMsgAlerta("Preencha os campos corretamente", "Cadastro Enfermeiro");
       }catch(Exception e){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Cadastro Enfermeiro");
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
    private void selecionarRaioXNao() throws IOException{
        if(radioBtnNao.isSelected())
            radioBtnSim.setSelected(false);
        else
            radioBtnSim.setSelected(true);
    }
    
    @FXML
    private void selecionarRaioXSim() throws IOException{
        if(radioBtnSim.isSelected())
            radioBtnNao.setSelected(false);
        else
            radioBtnNao.setSelected(true);
    }
    
}
