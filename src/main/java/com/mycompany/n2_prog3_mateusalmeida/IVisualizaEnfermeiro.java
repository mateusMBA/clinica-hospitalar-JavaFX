/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
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
public class IVisualizaEnfermeiro implements Initializable{
    
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
    ComboBox<Enfermeiro> cbEnfermeiro;
    
    @FXML
    Button btnDeletar;
    
    @FXML
    Button btnSalvar;
    
    @FXML
    Button btnEditar;
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbEnfermeiro.getItems().addAll(TelaPrincipal.arrayEnfermeiros);
        if(TelaPrincipal.arrayEnfermeiros.size()>0){
            cbEnfermeiro.setValue(TelaPrincipal.arrayEnfermeiros.get(0));
            preencherInformacoes(TelaPrincipal.arrayEnfermeiros.get(0));
        }else{
            btnDeletar.setDisable(true);
        }
        bloquearBotoes();
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
    
    private void bloquearBotoes(){
        textFieldNomeEnfermeiro.setDisable(true);
        dataNascimento.setDisable(true);
        radioBtnSim.setDisable(true);
        radioBtnNao.setDisable(true);
        radioBtnM.setDisable(true);
        radioBtnF.setDisable(true);
        textFieldSetor.setDisable(true);
        textFieldCargaHoraria.setDisable(true);
        textFieldRua.setDisable(true);
        textFieldNumero.setDisable(true);
        textFieldBairro.setDisable(true);
        textFieldCidade.setDisable(true);
        textFieldEstado.setDisable(true);
        textFieldCEP.setDisable(true);
        textFieldTelefone.setDisable(true);
        textFieldCelular.setDisable(true);
        textFieldEmail.setDisable(true);
    }
    
    private void desbloquearBotoes(){
        textFieldNomeEnfermeiro.setDisable(false);
        dataNascimento.setDisable(false);
        radioBtnSim.setDisable(false);
        radioBtnNao.setDisable(false);
        radioBtnM.setDisable(false);
        radioBtnF.setDisable(false);
        textFieldSetor.setDisable(false);
        textFieldCargaHoraria.setDisable(false);
        textFieldRua.setDisable(false);
        textFieldNumero.setDisable(false);
        textFieldBairro.setDisable(false);
        textFieldCidade.setDisable(false);
        textFieldEstado.setDisable(false);
        textFieldCEP.setDisable(false);
        textFieldTelefone.setDisable(false);
        textFieldCelular.setDisable(false);
        textFieldEmail.setDisable(false);
    }
    
    @FXML
    private void alterarEnfermeiro() throws IOException{
        Enfermeiro enfermeiro = cbEnfermeiro.getSelectionModel().getSelectedItem();
        try{
        enfermeiro.setNomeCompleto((String)textFieldNomeEnfermeiro.getText());
        enfermeiro.setDataNascimento(Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC)));
        if(radioBtnSim.isSelected()){
            enfermeiro.setTreinadoOpRX(true);
        }
        else{
            enfermeiro.setTreinadoOpRX(false);
        }
        if(radioBtnM.isSelected()){
            enfermeiro.setGenero(Genero.M);
        }
        else{
            enfermeiro.setGenero(Genero.F);
        }
        enfermeiro.setSetor((String)textFieldSetor.getText());
        enfermeiro.setChSemanal((int)Integer.parseInt(textFieldCargaHoraria.getText()));
        enfermeiro.getEndereco().setRua((String)textFieldRua.getText());
        enfermeiro.getEndereco().setNumero((int)Integer.parseInt(textFieldNumero.getText()));
        enfermeiro.getEndereco().setBairro((String)textFieldBairro.getText());
        enfermeiro.getEndereco().setCidade((String)textFieldCidade.getText());
        enfermeiro.getEndereco().setEstado((String)textFieldEstado.getText());
        enfermeiro.getEndereco().setCep((int)Integer.parseInt(textFieldCEP.getText()));
        enfermeiro.getContato().setCelular((String) textFieldCelular.getText());
        enfermeiro.getContato().setTelefone((String) textFieldTelefone.getText());
        enfermeiro.getContato().setEmail((String) textFieldEmail.getText());
        ErrorHandler.exibirMsgInfo("Enfermeiro alterado com sucesso", "Cadastro Enfermeiro");
        ObservableList<Enfermeiro> enfermeiros = FXCollections.observableArrayList(TelaPrincipal.arrayEnfermeiros);
        cbEnfermeiro.setItems(enfermeiros);
        btnEditar.setDisable(false);
        btnDeletar.setDisable(false);
        btnSalvar.setDisable(true);
        cbEnfermeiro.setDisable(false);
        bloquearBotoes();
        }catch(NumberFormatException e){
           ErrorHandler.exibirMsgAlerta("Preencha os campos corretamente", "Cadastro Enfermeiro");
        }catch(Exception e){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Cadastro Enfermeiro");
       }
    }
    
    @FXML
    private void editarEnfermeiro() throws IOException{
        if(TelaPrincipal.arrayEnfermeiros.size() > 0){
            desbloquearBotoes();
            btnSalvar.setDisable(false);
            btnEditar.setDisable(true);
            btnDeletar.setDisable(true);
            cbEnfermeiro.setDisable(true);
        }else{
            ErrorHandler.exibirMsgAlerta("Nao existe enfermeiro cadastrado", "Cadastro Enfermeiro");
        }
    }
    
    @FXML
    private void deletarEnfermeiro() throws IOException{
        //deletar o enfermeiro selecionado da base e preencher o combobox com os remanescentes
        if(TelaPrincipal.arrayEnfermeiros.size() > 0){
            int id = cbEnfermeiro.getSelectionModel().getSelectedIndex();
            TelaPrincipal.arrayEnfermeiros.remove(id);
            ErrorHandler.exibirMsgInfo("Enfermeiro deletado com sucesso", "Cadastro Enfermeiro");
        }
        if(TelaPrincipal.arrayEnfermeiros.size() != 0){
            ObservableList<Enfermeiro> enfermeiros = FXCollections.observableArrayList(TelaPrincipal.arrayEnfermeiros);
            cbEnfermeiro.setItems(enfermeiros);
            cbEnfermeiro.setValue(TelaPrincipal.arrayEnfermeiros.get(0));
        }else{
            limparCampos();
            cbEnfermeiro.setItems(null);
        }
    }
    
    @FXML
    private void onChangeChoiceBoxEnfermeiro() throws IOException{
        int id = cbEnfermeiro.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayEnfermeiros.size()> 0){
            preencherInformacoes(TelaPrincipal.arrayEnfermeiros.get(id));
        }
        else{
            btnDeletar.setDisable(true);
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
    
    private void preencherInformacoes(Enfermeiro enfermeiro){
       textFieldNomeEnfermeiro.setText(enfermeiro.getNomeCompleto());
       dataNascimento.setValue(enfermeiro.getDataNascimento().toInstant().atZone(ZoneOffset.UTC).toLocalDate());
       if(enfermeiro.isTreinadoOpRX()){
           radioBtnSim.setSelected(true);
           radioBtnNao.setSelected(false);
       }
       else{
           radioBtnSim.setSelected(false);
           radioBtnNao.setSelected(true);
       }
       if(enfermeiro.getGenero() == Genero.M){
           radioBtnM.setSelected(true);
           radioBtnF.setSelected(false);
       }
       else{
           radioBtnM.setSelected(false);
           radioBtnF.setSelected(true);
       }
       textFieldSetor.setText(enfermeiro.getSetor());
       textFieldCargaHoraria.setText(String.format("%d", enfermeiro.getChSemanal()));
       textFieldRua.setText(enfermeiro.getEndereco().getRua());
       textFieldNumero.setText(String.format("%d",enfermeiro.getEndereco().getNumero()));
       textFieldBairro.setText(enfermeiro.getEndereco().getBairro());
       textFieldCidade.setText(enfermeiro.getEndereco().getCidade());
       textFieldEstado.setText(enfermeiro.getEndereco().getEstado());
       textFieldCEP.setText(String.format("%d",enfermeiro.getEndereco().getCep()));
       textFieldTelefone.setText(enfermeiro.getContato().getTelefone());
       textFieldCelular.setText(enfermeiro.getContato().getCelular());
       textFieldEmail.setText(enfermeiro.getContato().getEmail());    
    }
    
}
