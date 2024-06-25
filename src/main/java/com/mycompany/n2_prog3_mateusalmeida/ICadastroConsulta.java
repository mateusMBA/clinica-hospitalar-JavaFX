package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ICadastroConsulta implements Initializable{

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
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        radioBtnSim.setSelected(true);
        cbMedico.getItems().addAll(TelaPrincipal.arrayMedicos);
        if(TelaPrincipal.arrayMedicos.size()>0){
            cbMedico.setValue(TelaPrincipal.arrayMedicos.get(0));
            Medico medico = TelaPrincipal.arrayMedicos.get(0);
            textFieldNomeMedico.setText(medico.getNomeCompleto());
            textFieldCRM.setText(String.format("%d", medico.getNumeroCRM()));
        cbPaciente.getItems().addAll(TelaPrincipal.arrayPacientes);
        }
        if(TelaPrincipal.arrayPacientes.size()>0){
            cbPaciente.setValue(TelaPrincipal.arrayPacientes.get(0));
            Paciente paciente = TelaPrincipal.arrayPacientes.get(0);
            textFieldNomePaciente.setText(paciente.getNomeCompleto());
            textFieldIdade.setText(String.format("%d", paciente.getIdade()));   
        }
    }
    
    @FXML
    private void salvarConsulta() throws IOException {
        try{   
            long idMedico = (long) TelaPrincipal.arrayMedicos.get(cbMedico.getSelectionModel().getSelectedIndex()).getIdMedico();
            long idPaciente = (long) TelaPrincipal.arrayPacientes.get(cbPaciente.getSelectionModel().getSelectedIndex()).getIdPaciente();
            String exameQueixa = textFieldQueixa.getText();
            String diagnostico = textAreaDiagnostico.getText();
            String prescricao = textAreaPrescricao.getText();
            boolean indicacaoCirurgia;
            if(radioBtnSim.isSelected())
                indicacaoCirurgia = true;
            else
                indicacaoCirurgia = false;
            ConsultaMedica consulta = new ConsultaMedica(idPaciente, idMedico,exameQueixa, diagnostico, prescricao, indicacaoCirurgia);
            TelaPrincipal.arrayConsultas.add(consulta);
            //Insere a nova consulta no historico de consultas do paciente
            Paciente.findById(TelaPrincipal.arrayPacientes, idPaciente).getHistoricoConsultasMedicas().add(consulta);
            ErrorHandler.exibirMsgInfo("Consulta cadastrada com sucesso", "Cadastro Consulta");
            limparCampos();
        }catch(NumberFormatException e){
            ErrorHandler.exibirMsgAlerta("Preencha os campos corretamente", "Cadastro Consulta");
        }catch(Exception e){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Cadastro Consulta");
        }
    }
    
    @FXML
    private void limparCampos() throws IOException {
        textFieldQueixa.setText("");
        textAreaDiagnostico.setText("");
        textAreaPrescricao.setText("");
        radioBtnSim.setSelected(true);
        radioBtnSim.setSelected(false);
    }
    
    @FXML
    private void onChangeComboboxPaciente() throws IOException{
        int id = cbPaciente.getSelectionModel().getSelectedIndex();
        Paciente paciente;
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayPacientes.size()> 0){
            paciente = (TelaPrincipal.arrayPacientes.get(id));
            textFieldNomePaciente.setText(paciente.getNomeCompleto());
            textFieldIdade.setText(String.format("%d",paciente.getIdade()));
        }
    }
    
    @FXML
    private void onChangeComboboxMedico() throws IOException{
        int id = cbMedico.getSelectionModel().getSelectedIndex();
        Medico medico;
        if(id < 0)
          id = 0;
        if(TelaPrincipal.arrayMedicos.size()> 0){
            medico = (TelaPrincipal.arrayMedicos.get(id));
            textFieldNomeMedico.setText(medico.getNomeCompleto());
            textFieldCRM.setText(String.format("%d",medico.getNumeroCRM()));
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