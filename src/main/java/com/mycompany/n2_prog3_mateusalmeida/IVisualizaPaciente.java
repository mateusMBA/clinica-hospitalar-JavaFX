/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.Responsavel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class IVisualizaPaciente implements Initializable{
    
    public static int idPaciente;
    
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
    ComboBox<Paciente> cbPaciente;
    
    @FXML
    ComboBox<Responsavel> cbResponsavel;
    
    @FXML
    Button btnRespDeletar;
    
    @FXML
    Button btnRespAlterar;
            
    @FXML
    Button btnRespInserir;
    
    @FXML
    Button btnDeletar;
    
    @FXML
    Button btnSalvar;
    
    @FXML
    Button btnEditar;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbPaciente.getItems().addAll(TelaPrincipal.arrayPacientes);
        if(TelaPrincipal.arrayPacientes.size()>0){
            cbPaciente.setValue(TelaPrincipal.arrayPacientes.get(0));
            this.idPaciente = cbPaciente.getSelectionModel().getSelectedIndex();
            preencherInformacoes(TelaPrincipal.arrayPacientes.get(0));
            cbResponsavel.getItems().addAll(TelaPrincipal.arrayPacientes.get(0).getContatoResponsavel());
            if(TelaPrincipal.arrayPacientes.get(0).getContatoResponsavel().size() > 0){
            cbResponsavel.setValue(TelaPrincipal.arrayPacientes.get(0).getContatoResponsavel().get(0));
            preencherResponsavel(TelaPrincipal.arrayPacientes.get(0).getContatoResponsavel().get(0));
            }
        }else{
            btnDeletar.setDisable(true);
        }
        bloquearBotoes();
    }
        
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
    @FXML
    private void switchToHistoricoConsulta() throws IOException {
        App.setRoot("iVisualizaHistoricoConsulta");
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
    
    private void bloquearBotoes(){
        textFieldNomePaciente.setDisable(true);
        dataNascimento.setDisable(true);
        radioBtnM.setDisable(true);
        radioBtnF.setDisable(true);
        textFieldRua.setDisable(true);
        textFieldNumero.setDisable(true);
        textFieldBairro.setDisable(true);
        textFieldCidade.setDisable(true);
        textFieldEstado.setDisable(true);
        textFieldCEP.setDisable(true);
        textFieldTelefone.setDisable(true);
        textFieldCelular.setDisable(true);
        textFieldEmail.setDisable(true);
        textFieldRespNome.setDisable(true);
        textFieldRespCelular.setDisable(true);
        textFieldRespEmail.setDisable(true);
        textFieldRespTelefone.setDisable(true);
        textFieldIdade.setDisable(true);
        textAreaObs.setDisable(true);
        btnRespAlterar.setDisable(true);
        btnRespDeletar.setDisable(true);
        btnRespInserir.setDisable(true);
    }
    
    private void desbloquearBotoes(){
        textFieldNomePaciente.setDisable(false);
        dataNascimento.setDisable(false);
        radioBtnM.setDisable(false);
        radioBtnF.setDisable(false);
        textFieldRua.setDisable(false);
        textFieldNumero.setDisable(false);
        textFieldBairro.setDisable(false);
        textFieldCidade.setDisable(false);
        textFieldEstado.setDisable(false);
        textFieldCEP.setDisable(false);
        textFieldTelefone.setDisable(false);
        textFieldCelular.setDisable(false);
        textFieldEmail.setDisable(false);
        textFieldRespNome.setDisable(false);
        textFieldRespCelular.setDisable(false);
        textFieldRespEmail.setDisable(false);
        textFieldRespTelefone.setDisable(false);
        textFieldIdade.setDisable(false);
        textAreaObs.setDisable(false);
        btnRespAlterar.setDisable(false);
        btnRespDeletar.setDisable(false);
        btnRespInserir.setDisable(false);
    }
   
    private void preencherInformacoes(Paciente paciente){
       textFieldNomePaciente.setText(paciente.getNomeCompleto());
       dataNascimento.setValue(paciente.getDataNascimento().toInstant().atZone(ZoneOffset.UTC).toLocalDate());
       if(paciente.getGenero() == Genero.M){
           radioBtnM.setSelected(true);
           radioBtnF.setSelected(false);
       }
       else{
           radioBtnM.setSelected(false);
           radioBtnF.setSelected(true);
       }
       textFieldIdade.setText(String.format("%d",paciente.getIdade()));
       textFieldRua.setText(paciente.getEndereco().getRua());
       textFieldNumero.setText(String.format("%d",paciente.getEndereco().getNumero()));
       textFieldBairro.setText(paciente.getEndereco().getBairro());
       textFieldCidade.setText(paciente.getEndereco().getCidade());
       textFieldEstado.setText(paciente.getEndereco().getEstado());
       textFieldCEP.setText(String.format("%d",paciente.getEndereco().getCep()));
       textFieldTelefone.setText(paciente.getContato().getTelefone());
       textFieldCelular.setText(paciente.getContato().getCelular());
       textFieldEmail.setText(paciente.getContato().getEmail());
       textAreaObs.setText(paciente.getObsGeral());
    }
    
    private void preencherResponsavel(Responsavel responsavel){
       textFieldRespEmail.setText(responsavel.getEmail());
       textFieldRespTelefone.setText(responsavel.getTelefone());
       textFieldRespNome.setText(responsavel.getNomeResponsavel());
       textFieldRespCelular.setText(responsavel.getCelular());
    } 
    
    @FXML
    private void salvarInformacoes() throws IOException{
       //editar o paciente no array estaticos com os valores preenchidos nos campos
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        Paciente paciente = TelaPrincipal.arrayPacientes.get(id);
        try{
            paciente.setNomeCompleto((String)textFieldNomePaciente.getText());
            paciente.setDataNascimento(Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC)));
            paciente.setIdade((int)Integer.parseInt(textFieldIdade.getText()));
            paciente.getEndereco().setRua((String)textFieldRua.getText());
            paciente.getEndereco().setNumero((int)Integer.parseInt(textFieldNumero.getText()));
            paciente.getEndereco().setBairro((String)textFieldBairro.getText());
            paciente.getEndereco().setCidade((String)textFieldCidade.getText());
            paciente.getEndereco().setEstado((String)textFieldEstado.getText());
            paciente.getEndereco().setCep((int)Integer.parseInt(textFieldCEP.getText()));
            paciente.getContato().setCelular((String) textFieldCelular.getText());
            paciente.getContato().setTelefone((String) textFieldTelefone.getText());
            paciente.getContato().setEmail((String) textFieldEmail.getText());
            int idResponsavel = cbResponsavel.getSelectionModel().getSelectedIndex();
            paciente.getContatoResponsavel().get(idResponsavel).setCelular(textFieldRespCelular.getText());
            paciente.getContatoResponsavel().get(idResponsavel).setTelefone(textFieldRespTelefone.getText());
            paciente.getContatoResponsavel().get(idResponsavel).setEmail(textFieldRespEmail.getText());
            paciente.getContatoResponsavel().get(idResponsavel).setNomeResponsavel(textFieldRespNome.getText());
            btnEditar.setDisable(false);
            btnDeletar.setDisable(false);
            btnSalvar.setDisable(true);
            cbPaciente.setDisable(false);
            bloquearBotoes();
            //JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso");
        }catch(NumberFormatException e){
            //JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Tente Novamente");
        }
    }
    
    @FXML
    private void editarInformacoes() throws IOException{
        if(TelaPrincipal.arrayPacientes.size() > 0){
            desbloquearBotoes();
            btnSalvar.setDisable(false);
            btnEditar.setDisable(true);
            btnDeletar.setDisable(true);
            cbPaciente.setDisable(true);
        }else{
            //JOptionPane.showMessageDialog(null, "Nao existe paciente cadastrado");
        }
    }
    
    @FXML
    private void deletarInformacoes() throws IOException{
        //deletar o paciente selecionado da base e preencher o combobox com os remanescentes
        if(TelaPrincipal.arrayPacientes.size() > 0){
            int id = cbPaciente.getSelectionModel().getSelectedIndex();
            long idPaciente = TelaPrincipal.arrayPacientes.get(id).getIdPaciente();
            //apagar consultas do array estatico de consulta que tiverem o paciente deletado
            ConsultaMedica.removerConsultaPorIdPaciente(TelaPrincipal.arrayConsultas, idPaciente);
            TelaPrincipal.arrayPacientes.remove(id);
            //JOptionPane.showMessageDialog(null, "Paciente deletado com sucesso");
        }
        if(TelaPrincipal.arrayPacientes.size() != 0){
            ObservableList<Paciente> pacientes = FXCollections.observableArrayList(TelaPrincipal.arrayPacientes);
            cbPaciente.setItems(pacientes);
            cbPaciente.setValue(TelaPrincipal.arrayPacientes.get(0));
        }else{
            limparCampos();
            cbPaciente.setItems(null);
        }
    }
    
    @FXML
    private void onChangeChoiceBoxPaciente() throws IOException{
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        this.idPaciente = id;
        if(TelaPrincipal.arrayPacientes.size()> 0){
            preencherInformacoes(TelaPrincipal.arrayPacientes.get(id));
            ObservableList<Responsavel> responsaveis = FXCollections.observableArrayList(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel());
            cbResponsavel.setItems(responsaveis);
            cbResponsavel.setValue(TelaPrincipal.arrayPacientes.get(id ).getContatoResponsavel().get(0));
            if(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().size() > 0){
                int idResponsavel = 0;
                preencherResponsavel(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel));
            }
        }
        else{
            cbResponsavel.setItems(null);
            btnRespDeletar.setDisable(true);
        }
    }
    
    @FXML
    private void onChangeChoiceBoxResponsavel() throws IOException{
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        if(id >=0){
            if(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().size() > 0){
                int idResponsavel = cbResponsavel.getSelectionModel().getSelectedIndex();
                if(idResponsavel < 0)
                    idResponsavel = 0;
                preencherResponsavel(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel));
                }else{
                textFieldRespNome.setText("");
                textFieldRespCelular.setText("");
                textFieldRespTelefone.setText("");
                textFieldRespEmail.setText("");
                
            }
        }
    }
    
    @FXML
    private void alterarResponsavel() throws IOException{
        //alterar responsavel selecionado no arraylist de contatoResponsavel do paciente selecionado
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        int idResponsavel = cbResponsavel.getSelectionModel().getSelectedIndex();
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel).setCelular(textFieldRespCelular.getText());
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel).setTelefone(textFieldRespCelular.getText());
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel).setEmail(textFieldRespEmail.getText());
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().get(idResponsavel).setNomeResponsavel(textFieldRespNome.getText());
        ObservableList<Responsavel> responsaveis = FXCollections.observableArrayList(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel());
        cbResponsavel.setItems(responsaveis);
        cbResponsavel.setValue(TelaPrincipal.arrayPacientes.get(id ).getContatoResponsavel().get(idResponsavel));
    }
    
    @FXML
    private void inserirResponsavel() throws IOException{
                                                       
        //inserir novo responsavel no arraylist de contatoResponsavel do paciente selecionado
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        String nomeResp = textFieldRespNome.getText();
        String celularResp = textFieldRespCelular.getText();
        String telefoneResp = textFieldRespTelefone.getText();
        String emailResp = textFieldRespEmail.getText();
        int idResponsavel = cbResponsavel.getSelectionModel().getSelectedIndex();
        Responsavel responsavel = new Responsavel(nomeResp,telefoneResp,celularResp,emailResp);
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().add(responsavel);      
        ObservableList<Responsavel> responsaveis = FXCollections.observableArrayList(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel());
        cbResponsavel.setItems(responsaveis);
        cbResponsavel.setValue(TelaPrincipal.arrayPacientes.get(id ).getContatoResponsavel().get(idResponsavel));
        btnDeletar.setDisable(false);
    }                                                  
       
    @FXML
    private void deletarResponsavel() throws IOException {                                                   
        //deletar responsavel selecionado no arraylist de contatoResponsavel do paciente selecionado
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        int idResponsavel = cbResponsavel.getSelectionModel().getSelectedIndex();
        TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel().remove(idResponsavel);
        //preencher combobox de contato responsavel com todos os valores do arraylist
        ObservableList<Responsavel> responsaveis = FXCollections.observableArrayList(TelaPrincipal.arrayPacientes.get(id).getContatoResponsavel());
        cbResponsavel.setItems(responsaveis);
        if(responsaveis.size() > 0)
            cbResponsavel.setValue(TelaPrincipal.arrayPacientes.get(id ).getContatoResponsavel().get(0));
        else
            btnRespDeletar.setDisable(true);
        
    }
}
