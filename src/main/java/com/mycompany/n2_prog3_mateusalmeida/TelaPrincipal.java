 package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.dados.ImportarExcel;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;

public class TelaPrincipal {
    
    //arraylists estaticos que serao utilizados como fonte de dados para o aplicativo, poderao ser acessados em todas o programa
    public static ArrayList<Medico> arrayMedicos = new ArrayList<Medico>();
    public static ArrayList<Enfermeiro> arrayEnfermeiros = new ArrayList<Enfermeiro>();
    public static ArrayList<Paciente> arrayPacientes = new ArrayList<Paciente>();
    public static ArrayList<ConsultaMedica> arrayConsultas = new ArrayList<ConsultaMedica>();

    @FXML
    private void switchToNovoPaciente() throws IOException {
        App.setRoot("iCadastroPaciente");
    }
    
    @FXML
    private void switchToEditarPaciente() throws IOException {
        App.setRoot("iVisualizaPaciente");
    }
    
    @FXML
    private void switchToNovoEnfermeiro() throws IOException {
        App.setRoot("iCadastroEnfermeiro");
    }
    
    @FXML
    private void switchToEditarEnfermeiro() throws IOException {
        App.setRoot("iVisualizaEnfermeiro");
    }
    
    @FXML
    private void switchToNovoMedico() throws IOException {
        App.setRoot("iCadastroMedico");
    }
    
    @FXML
    private void switchToEditarMedico() throws IOException {
        App.setRoot("iVisualizaMedico");
    }
    
    @FXML
    private void switchToNovoConsulta() throws IOException {
        App.setRoot("iCadastroConsulta");
    }
    
    @FXML
    private void switchToEditarConsulta() throws IOException {
        App.setRoot("iVisualizaConsulta");
    }
    
    @FXML
    private void importarExcel() throws IOException{
        ImportarExcel.lerExcel();
    }
}
