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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author mateu
 */
public class IVisualizaConsulta implements Initializable{
    
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
    ComboBox<Medico> cbMedico;
    
    @FXML
    ComboBox<Paciente> cbPaciente;
    
    @FXML
    ComboBox<ConsultaMedica> cbConsulta;
    
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
        cbConsulta.getItems().addAll(TelaPrincipal.arrayConsultas);
        cbMedico.getItems().addAll(TelaPrincipal.arrayMedicos);
        cbPaciente.getItems().addAll(TelaPrincipal.arrayPacientes);
        if(TelaPrincipal.arrayConsultas.size()>0){
            cbConsulta.setValue(TelaPrincipal.arrayConsultas.get(0));
            preencherInformacoes(TelaPrincipal.arrayConsultas.get(0));
            Paciente paciente = TelaPrincipal.arrayPacientes.get(cbPaciente.getSelectionModel().getSelectedIndex());
            textFieldNomePaciente.setText(paciente.getNomeCompleto());
            textFieldIdade.setText(String.format("%d", paciente.getIdade()));
            Medico medico = TelaPrincipal.arrayMedicos.get(cbMedico.getSelectionModel().getSelectedIndex());
            textFieldNomeMedico.setText(medico.getNomeCompleto());
            textFieldCRM.setText(String.format("%d", medico.getNumeroCRM()));
        }else{
            btnDeletar.setDisable(true);
        }
        bloquearBotoes();
    }
    
    @FXML
    private void limparCampos() throws IOException {
        textFieldQueixa.setText("");
        textAreaDiagnostico.setText("");
        textAreaPrescricao.setText("");
        radioBtnSim.setSelected(true);
        radioBtnSim.setSelected(false);
        textFieldCRM.setText("");
        textFieldIdade.setText("");
        textFieldNomeMedico.setText("");
        textFieldNomePaciente.setText("");
        cbPaciente.setValue(null);
        cbMedico.setValue(null);
    }
    
    @FXML
    private void salvarConsulta() throws IOException{
       //alterar a consulta no array estatico com os valores preenchidos nos campos
        try{
            int id = cbConsulta.getSelectionModel().getSelectedIndex();
            ConsultaMedica consulta = TelaPrincipal.arrayConsultas.get(id);
            long idPacienteAntigo = TelaPrincipal.arrayConsultas.get(id).getIdPaciente();
            consulta.setExameQueixa(textFieldQueixa.getText());
            consulta.setPrescricao(textAreaPrescricao.getText());
            consulta.setDiagnostico(textAreaDiagnostico.getText());
            if(radioBtnSim.isSelected())
                consulta.setIndicacaoCirurgica(true);
            else
               consulta.setIndicacaoCirurgica(false);
            long idMedico = TelaPrincipal.arrayMedicos.get(cbMedico.getSelectionModel().getSelectedIndex()).getIdMedico();
            long idPaciente = TelaPrincipal.arrayPacientes.get(cbPaciente.getSelectionModel().getSelectedIndex()).getIdPaciente();
            consulta.setIdMedico(idMedico);
            consulta.setIdPaciente(idPaciente);
            if(idPaciente != idPacienteAntigo){
                Paciente.findById(TelaPrincipal.arrayPacientes, idPaciente).getHistoricoConsultasMedicas().add(consulta);
                Paciente.findById(TelaPrincipal.arrayPacientes, idPacienteAntigo).removerConsultaHistorico(consulta);
            }

            btnEditar.setDisable(false);
            btnDeletar.setDisable(false);
            btnSalvar.setDisable(true);
            cbConsulta.setDisable(false);
            bloquearBotoes();
            //JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso");
       
        }catch(NumberFormatException e){
            //JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Tente Novamente");
        }
    }
    
    @FXML
    private void deletarConsulta() throws IOException {                                               
        int id = 1;
        //caso existam itens no array de consultas, exclui o item selecionado
        if(TelaPrincipal.arrayConsultas.size() > 0){
            id = cbConsulta.getSelectionModel().getSelectedIndex();
            long idPaciente = (long) TelaPrincipal.arrayPacientes.get(cbPaciente.getSelectionModel().getSelectedIndex()).getIdPaciente();
            ConsultaMedica consulta = TelaPrincipal.arrayConsultas.get(id);
            //busca o paciente atraves do id e realiza a exclusao da consulta em seu historico
            Paciente.findById(TelaPrincipal.arrayPacientes, idPaciente).removerConsultaHistorico(consulta);
            TelaPrincipal.arrayConsultas.remove(id);
            if(TelaPrincipal.arrayConsultas.size() > 0){
                ObservableList<ConsultaMedica> consultas = FXCollections.observableArrayList(TelaPrincipal.arrayConsultas);
                cbConsulta.setItems(consultas);
                cbConsulta.setValue(TelaPrincipal.arrayConsultas.get(0));
            //JOptionPane.showMessageDialog(null, "Consulta deletada com sucesso");
            }else{
                cbConsulta.setItems(null);
                limparCampos();
                btnDeletar.setDisable(true);
            }
        }         
    }
    
    @FXML
    private void editarConsulta() {                                              
        //Ao clicar em Editar, habilitar todos os campos e o botao de salvar, desabilitar deletar.
        if(TelaPrincipal.arrayConsultas.size() > 0){
            desbloquearBotoes();
            btnSalvar.setDisable(false);
            btnDeletar.setDisable(true);
            cbConsulta.setDisable(true);
            btnEditar.setDisable(true);
        }else{
            //JOptionPane.showMessageDialog(null, "Nao existe consulta cadastrado");
        }
    }  
    
    private void bloquearBotoes(){
        cbMedico.setDisable(true);
        cbPaciente.setDisable(true);
        textFieldNomeMedico.setDisable(true);
        textFieldNomePaciente.setDisable(true);
        textFieldCRM.setDisable(true);
        textFieldIdade.setDisable(true);
        textAreaDiagnostico.setDisable(true);
        textAreaPrescricao.setDisable(true);
        textFieldQueixa.setDisable(true);
        radioBtnSim.setDisable(true);
        radioBtnNao.setDisable(true);
    }
    
    private void desbloquearBotoes(){
        cbMedico.setDisable(false);
        cbPaciente.setDisable(false);
        textAreaDiagnostico.setDisable(false);
        textAreaPrescricao.setDisable(false);
        textFieldQueixa.setDisable(false);
        radioBtnSim.setDisable(false);
        radioBtnNao.setDisable(false);
    }
    
    @FXML
    private void onChangeComboBoxConsulta() throws IOException {                                                  
        int id = cbConsulta.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayConsultas.size()> 0){
            preencherInformacoes(TelaPrincipal.arrayConsultas.get(id));
        }
        else{
            btnDeletar.setDisable(true);
        }
    } 
    
    @FXML
    private void onChangeComboBoxMedico() throws IOException {                                                  
        //preencher as informacoes do medico selecionado
        int id = cbMedico.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayMedicos.size() > 0){
            Medico medico = TelaPrincipal.arrayMedicos.get(id);
            textFieldNomeMedico.setText(medico.getNomeCompleto());
            textFieldCRM.setText(String.format("%d", medico.getNumeroCRM()));
        }
    }                                               

    @FXML
    private void onChangeComboBoxPaciente() throws IOException {                                                  
        //preencher as informacoes do medico selecionado
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayPacientes.size() > 0){
            Paciente paciente = TelaPrincipal.arrayPacientes.get(id);
            textFieldNomePaciente.setText(paciente.getNomeCompleto());
            textFieldIdade.setText(String.format("%d", paciente.getIdade()));
        }
    }
    
    private void preencherInformacoes(ConsultaMedica consultaMedica){
        cbMedico.setValue(Medico.findById(TelaPrincipal.arrayMedicos, consultaMedica.getIdMedico()));
        cbPaciente.setValue(Paciente.findById(TelaPrincipal.arrayPacientes, consultaMedica.getIdPaciente()));
        textFieldQueixa.setText(consultaMedica.getExameQueixa());
        textAreaDiagnostico.setText(consultaMedica.getDiagnostico());
        textAreaPrescricao.setText(consultaMedica.getPrescricao());
        if(consultaMedica.isIndicacaoCirurgica()){
            radioBtnSim.setSelected(true);
            radioBtnNao.setSelected(false);
        }else{
            radioBtnSim.setSelected(false);
            radioBtnNao.setSelected(true);
        }
    }
    
    @FXML
    private void selecionarCirurgiaNao() throws IOException{
        if(radioBtnNao.isSelected())
            radioBtnSim.setSelected(false);
        else
            radioBtnSim.setSelected(true);
    }
    
    @FXML
    private void selecionarCirurgiaSim() throws IOException{
        if(radioBtnSim.isSelected())
            radioBtnNao.setSelected(false);
        else
            radioBtnNao.setSelected(true);
    }
    
}
