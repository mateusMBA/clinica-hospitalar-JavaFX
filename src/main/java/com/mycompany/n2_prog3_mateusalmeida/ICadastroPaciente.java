/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Endereco;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.Responsavel;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class ICadastroPaciente implements Initializable{
    
    ArrayList<Responsavel> contatosResp = new ArrayList<>();
    
    @FXML
    TextField textFieldNomePaciente;
    
    @FXML
    DatePicker dataNascimento;
    
    @FXML
    TextField textFieldIdade;
    
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
    TextField textFieldRespNome;
    
    @FXML
    TextField textFieldRespCelular;
    
    @FXML
    TextField textFieldRespTelefone;
    
    @FXML
    TextField textFieldRespEmail;
    
    @FXML
    RadioButton radioBtnM;
    
    @FXML
    RadioButton radioBtnF;
    
    @FXML
    TextArea textAreaObs;
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioBtnM.setSelected(true);
    }
    
    @FXML
    private void salvarPaciente() throws IOException{
        //Preenche as variaveis com as informacoes dos campos para criar um objeto do tipo Paciente
       try{
            String nome = textFieldNomePaciente.getText();
            Date dataNascimento = Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC));
            Genero genero;
            if(radioBtnM.isSelected())
                genero = Genero.M;
            else
                genero = Genero.F;
            String rua = textFieldRua.getText();
            int numero = Integer.parseInt(textFieldNumero.getText());
            String bairro = textFieldBairro.getText();
            String cidade = textFieldCidade.getText();
            String estado = textFieldEstado.getText();
            int cep = Integer.parseInt(textFieldCEP.getText());
            String telefone = textFieldTelefone.getText();
            String celular = textFieldCelular.getText();
            String email = textFieldEmail.getText();
            String nomeResponsavel = textFieldRespNome.getText();
            String telefoneResponsavel = textFieldRespTelefone.getText();
            String celularResponsavel = textFieldRespCelular.getText();
            String emailResponsavel = textFieldRespEmail.getText();
            String obsGeral = textAreaObs.getText();
            Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
            ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
            //Cria um objeto do tipo Responsavel com os valores dos campos na tela e adiciona no array de responsaveis
            contatosResp.add(new Responsavel(nomeResponsavel, telefoneResponsavel, celularResponsavel, emailResponsavel));
            Paciente paciente = new Paciente(obsGeral, new ArrayList<Responsavel>(contatosResp), nome, dataNascimento, endereco, contato,genero);
            TelaPrincipal.arrayPacientes.add(paciente);
            System.out.println(TelaPrincipal.arrayPacientes.get(0).getNomeCompleto());
            contatosResp = new ArrayList<Responsavel>();
            ErrorHandler.exibirMsgInfo("Paciente cadastrado com sucesso", "Cadastro Paciente");
            limparCampos();
       }catch(NumberFormatException e){
            ErrorHandler.exibirMsgAlerta("Preencha os campos corretamente", "Cadastro Paciente");
       }catch(Exception e){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Cadastro Paciente");
       }
    }
    
    @FXML
    private void inserirResponsavel() throws IOException{                                                   
        String nomeResp = textFieldRespNome.getText();
        String celularResp = textFieldRespCelular.getText();
        String telefoneResp = textFieldRespTelefone.getText();
        String emailResp = textFieldRespEmail.getText();
        contatosResp.add(new Responsavel(nomeResp,celularResp,telefoneResp,emailResp));
        textFieldRespCelular.setText("");
        textFieldRespTelefone.setText("");
        textFieldRespEmail.setText("");
        textFieldRespNome.setText(""); 
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
    
    private void limparCampos()throws IOException{
        textFieldNomePaciente.setText("");
        dataNascimento.setValue(null);
        radioBtnM.setSelected(true);
        radioBtnF.setSelected(false);
        textFieldRua.setText("");
        textFieldNumero.setText("");
        textFieldBairro.setText("");
        textFieldCidade.setText("");
        textFieldEstado.setText("");
        textFieldCEP.setText("");
        textFieldTelefone.setText("");
        textFieldCelular.setText("");
        textFieldEmail.setText("");
        textFieldRespNome.setText("");
        textFieldRespCelular.setText("");
        textFieldRespEmail.setText("");
        textFieldRespTelefone.setText("");
        textAreaObs.setText("");
    }
    
}
