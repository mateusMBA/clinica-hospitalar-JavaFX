/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Endereco;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
public class IVisualizaMedico implements Initializable{
    
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
    ComboBox<Medico> cbMedico;
    
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
        cbMedico.getItems().addAll(TelaPrincipal.arrayMedicos);
        if(TelaPrincipal.arrayMedicos.size()>0){
            cbMedico.setValue(TelaPrincipal.arrayMedicos.get(0));
            preencherInformacoes(TelaPrincipal.arrayMedicos.get(0));
        }else{
            btnDeletar.setDisable(true);
        }
        bloquearBotoes();
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
    
    private void bloquearBotoes(){
        textFieldNomeMedico.setDisable(true);
        dataNascimento.setDisable(true);
        textFieldCRM.setDisable(true);
        radioBtnSim.setDisable(true);
        radioBtnNao.setDisable(true);
        radioBtnM.setDisable(true);
        radioBtnF.setDisable(true);
        textFieldSetor.setDisable(true);
        textFieldCargaHoraria.setDisable(true);
        checkBoxCardiologia.setDisable(true);
        checkBoxGinecologia.setDisable(true);
        checkBoxOftamologia.setDisable(true);
        checkBoxNeurologia.setDisable(true);
        checkBoxPediatria.setDisable(true);
        checkBoxGastroenterologia.setDisable(true);
        checkBoxPsiquiatria.setDisable(true);
        checkBoxOrtopedia.setDisable(true);
        checkBoxOncologia.setDisable(true);
        checkBoxUrologia.setDisable(true);
        checkBoxReumatologia.setDisable(true);
        checkBoxAngiologia.setDisable(true);
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
        textFieldNomeMedico.setDisable(false);
        dataNascimento.setDisable(false);
        textFieldCRM.setDisable(false);
        radioBtnSim.setDisable(false);
        radioBtnNao.setDisable(false);
        radioBtnM.setDisable(false);
        radioBtnF.setDisable(false);
        textFieldSetor.setDisable(false);
        textFieldCargaHoraria.setDisable(false);
        checkBoxCardiologia.setDisable(false);
        checkBoxGinecologia.setDisable(false);
        checkBoxOftamologia.setDisable(false);
        checkBoxNeurologia.setDisable(false);
        checkBoxPediatria.setDisable(false);
        checkBoxGastroenterologia.setDisable(false);
        checkBoxPsiquiatria.setDisable(false);
        checkBoxOrtopedia.setDisable(false);
        checkBoxOncologia.setDisable(false);
        checkBoxUrologia.setDisable(false);
        checkBoxReumatologia.setDisable(false);
        checkBoxAngiologia.setDisable(false);
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
    private void alterarMedico() throws IOException{
       Medico medico = cbMedico.getSelectionModel().getSelectedItem();
       try{
       medico.setNomeCompleto((String)textFieldNomeMedico.getText());
       medico.setDataNascimento(Date.from(this.dataNascimento.getValue().atStartOfDay().toInstant(ZoneOffset.UTC)));
       medico.setNumeroCRM(Integer.parseInt(textFieldCRM.getText()));
       if(radioBtnSim.isSelected()){
           medico.setCirurgiao(true);
       }
       else{
           medico.setCirurgiao(false);
       }
       if(radioBtnM.isSelected()){
           medico.setGenero(Genero.M);
       }
       else{
           medico.setGenero(Genero.F);
       }
       medico.setSetor((String)textFieldSetor.getText());
       medico.setChSemanal((int)Integer.parseInt(textFieldCargaHoraria.getText()));
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
       if(checkBoxOncologia.isSelected())
           especialidades.add("Urologia");
       if(checkBoxReumatologia.isSelected())
           especialidades.add("Reumatologia");
       if(checkBoxAngiologia.isSelected())
           especialidades.add("Angiologia");
       medico.setAreasEspecialidade(especialidades);
       medico.getEndereco().setRua((String)textFieldRua.getText());
       medico.getEndereco().setNumero((int)Integer.parseInt(textFieldNumero.getText()));
       medico.getEndereco().setBairro((String)textFieldBairro.getText());
       medico.getEndereco().setCidade((String)textFieldCidade.getText());
       medico.getEndereco().setEstado((String)textFieldEstado.getText());
       medico.getEndereco().setCep((int)Integer.parseInt(textFieldCEP.getText()));
       medico.getContato().setCelular((String) textFieldCelular.getText());
       medico.getContato().setTelefone((String) textFieldTelefone.getText());
       medico.getContato().setEmail((String) textFieldEmail.getText());
       ObservableList<Medico> medicos = FXCollections.observableArrayList(TelaPrincipal.arrayMedicos);
       cbMedico.setItems(medicos);
       ErrorHandler.exibirMsgInfo("Médico alterado com sucesso", "Cadastro Médico");
       btnEditar.setDisable(false);
       btnDeletar.setDisable(false);
       btnSalvar.setDisable(true);
       cbMedico.setDisable(false);
        bloquearBotoes();
       }catch(NumberFormatException e){
            ErrorHandler.exibirMsgAlerta("Preencha os campos corretamente", "Cadastro Médico");
       }catch(Exception e){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Cadastro Médico");
       }
    }
    
    @FXML
    private void editarMedico() throws IOException{
        if(TelaPrincipal.arrayMedicos.size() > 0){
            desbloquearBotoes();
            btnSalvar.setDisable(false);
            btnEditar.setDisable(true);
            btnDeletar.setDisable(true);
            cbMedico.setDisable(true);
        }else{
            ErrorHandler.exibirMsgAlerta("Nao existe Médico cadastrado", "Cadastro Paciente");
        }
    }
    
    @FXML
    private void deletarMedico() throws IOException{
        //deletar o medico selecionado da base e preencher o combobox com os remanescentes
        if(TelaPrincipal.arrayMedicos.size() > 0){
            int id = cbMedico.getSelectionModel().getSelectedIndex();
            long idMedico = TelaPrincipal.arrayMedicos.get(id).getIdMedico();
            TelaPrincipal.arrayMedicos.remove(id);
            ConsultaMedica.removerConsultaPorIdMedico(TelaPrincipal.arrayConsultas, idMedico);
            ErrorHandler.exibirMsgInfo("Medico deletado com sucesso", "Cadastro Médico");
        }
        if(TelaPrincipal.arrayMedicos.size() != 0){
            ObservableList<Medico> medicos = FXCollections.observableArrayList(TelaPrincipal.arrayMedicos);
            cbMedico.setItems(medicos);
            cbMedico.setValue(TelaPrincipal.arrayMedicos.get(0));
        }else{
            limparCampos();
            cbMedico.setItems(null);
        }
    }
    
    @FXML
    private void onChangeChoiceBoxMedico() throws IOException{
        int id = cbMedico.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayMedicos.size()> 0){
            preencherInformacoes(TelaPrincipal.arrayMedicos.get(id));
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
    
    private void preencherInformacoes(Medico medico){
       textFieldNomeMedico.setText(medico.getNomeCompleto());
       dataNascimento.setValue(medico.getDataNascimento().toInstant().atZone(ZoneOffset.UTC).toLocalDate());
       textFieldCRM.setText(String.format("%d", medico.getNumeroCRM()));
       if(medico.isCirurgiao()){
           radioBtnSim.setSelected(true);
           radioBtnNao.setSelected(false);
       }
       else{
           radioBtnSim.setSelected(false);
           radioBtnNao.setSelected(true);
       }
       if(medico.getGenero() == Genero.M){
           radioBtnM.setSelected(true);
           radioBtnF.setSelected(false);
       }
       else{
           radioBtnM.setSelected(false);
           radioBtnF.setSelected(true);
       }
       textFieldSetor.setText(medico.getSetor());
       textFieldCargaHoraria.setText(String.format("%d", medico.getChSemanal()));
       ArrayList<String> especialidades = new ArrayList<>();
       if(medico.getAreasEspecialidade().contains("Cardiologia"))
           checkBoxCardiologia.setSelected(true);
       else
           checkBoxCardiologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Ginecologia"))
           checkBoxGinecologia.setSelected(true);
       else
           checkBoxGinecologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Oftamologia"))
           checkBoxOftamologia.setSelected(true);
       else
           checkBoxOftamologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Neurologia"))
           checkBoxNeurologia.setSelected(true);
       else
           checkBoxNeurologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Pediatria"))
           checkBoxPediatria.setSelected(true);
       else
           checkBoxPediatria.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Gastroenterologia"))
           checkBoxGastroenterologia.setSelected(true);
       else
           checkBoxGastroenterologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Psiquiatria"))
           checkBoxPsiquiatria.setSelected(true);
       else
           checkBoxPsiquiatria.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Ortopedia"))
           checkBoxOrtopedia.setSelected(true);
       else
           checkBoxOrtopedia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Oncologia"))
           checkBoxOncologia.setSelected(true);
       else
           checkBoxOncologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Urologia"))
           checkBoxUrologia.setSelected(true);
       else
           checkBoxUrologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Reumatologia"))
           checkBoxReumatologia.setSelected(true);
       else
           checkBoxReumatologia.setSelected(false);
       if(medico.getAreasEspecialidade().contains("Angiologia"))
           checkBoxAngiologia.setSelected(true);
       else
           checkBoxAngiologia.setSelected(false);
       textFieldRua.setText(medico.getEndereco().getRua());
       textFieldNumero.setText(String.format("%d",medico.getEndereco().getNumero()));
       textFieldBairro.setText(medico.getEndereco().getBairro());
       textFieldCidade.setText(medico.getEndereco().getCidade());
       textFieldEstado.setText(medico.getEndereco().getEstado());
       textFieldCEP.setText(String.format("%d",medico.getEndereco().getCep()));
       textFieldTelefone.setText(medico.getContato().getTelefone());
       textFieldCelular.setText(medico.getContato().getCelular());
       textFieldEmail.setText(medico.getContato().getEmail());  
    }
    
}
