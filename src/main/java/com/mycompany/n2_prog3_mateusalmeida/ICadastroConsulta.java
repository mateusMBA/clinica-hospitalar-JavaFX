package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ICadastroConsulta {

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
    ComboBox<Medico> cbMedico2;
    
    @FXML
    private void switchToTelaPrincipal() throws IOException {
        App.setRoot("TelaPrincipal");
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
            //TelaPrincipal.arrayConsultas.add(consulta);
            //Insere a nova consulta no historico de consultas do paciente
            //Paciente.findById(TelaPrincipal.arrayPacientes, idPaciente).getHistoricoConsultasMedicas().add(consulta);
            //javax.swing.JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso"); ALERTA
            resetarCampos();
        }catch(NumberFormatException e){
            //javax.swing.JOptionPane.showMessageDialog(null, "Preencha os campos corretamente"); ALERTA
        }catch(Exception e){
            //javax.swing.JOptionPane.showMessageDialog(null, "Tente Novamente"); ALERTA
        }
    }
    
    @FXML
    private void resetarCampos() throws IOException {
        textFieldQueixa.setText("");
        textAreaDiagnostico.setText("");
        textAreaPrescricao.setText("");
        radioBtnSim.setSelected(true);
        radioBtnSim.setSelected(false);
    }
}