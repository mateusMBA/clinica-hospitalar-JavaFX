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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author mateu
 */
public class IVisualizaHistoricoConsulta implements Initializable{
    
    public static class MyDataModel {
        private final SimpleStringProperty property1;
        private final SimpleStringProperty property2;
        private final SimpleStringProperty property3;
        private final SimpleStringProperty property4;
        private final SimpleStringProperty property5;
        private final SimpleStringProperty property6;

        public MyDataModel(String property1, String property2, String property3, String property4, String property5, String property6) {
            this.property1 = new SimpleStringProperty(property1);
            this.property2 = new SimpleStringProperty(property2);
            this.property3 = new SimpleStringProperty(property3);
            this.property4 = new SimpleStringProperty(property4);
            this.property5 = new SimpleStringProperty(property5);
            this.property6 = new SimpleStringProperty(property6);
        }

        public String getProperty1() {
            return property1.get();
        }

        public void setProperty1(String value) {
            property1.set(value);
        }

        public String getProperty2() {
            return property2.get();
        }

        public void setProperty2(String value) {
            property2.set(value);
        }
        
        public String getProperty3() {
            return property3.get();
        }

        public void setProperty3(String value) {
            property3.set(value);
        }

        public String getProperty4() {
            return property4.get();
        }

        public void setProperty4(String value) {
            property4.set(value);
        }
        
        public String getProperty5() {
            return property5.get();
        }

        public void setProperty5(String value) {
            property5.set(value);
        }

        public String getProperty6() {
            return property6.get();
        }

        public void setProperty6(String value) {
            property2.set(value);
        }
    }
    
    @FXML
    TableView<MyDataModel> tabelaConsultas;
    
    @FXML
    TableColumn<ConsultaMedica, String> colNomePaciente;
    
    @FXML
    TableColumn<ConsultaMedica, String> colNomeMedico;
    
    @FXML
    TableColumn<ConsultaMedica, String> colQueixa;
    
    @FXML
    TableColumn<ConsultaMedica, String> colDiagnostico;
    
    @FXML
    TableColumn<ConsultaMedica, String> colPrescricao;
    
    @FXML
    TableColumn<ConsultaMedica, String> colCirurgia;
    
    @FXML
    private void switchToVisualizaPaciente() throws IOException {
        App.setRoot("IVisualizaPaciente");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNomePaciente.setCellValueFactory(new PropertyValueFactory<>("property1"));
        colNomeMedico.setCellValueFactory(new PropertyValueFactory<>("property2"));
        colQueixa.setCellValueFactory(new PropertyValueFactory<>("property3"));
        colDiagnostico.setCellValueFactory(new PropertyValueFactory<>("property4"));
        colPrescricao.setCellValueFactory(new PropertyValueFactory<>("property5"));
        colCirurgia.setCellValueFactory(new PropertyValueFactory<>("property6"));
        
        ArrayList<MyDataModel> dataArray = new ArrayList<>();
        
        if(TelaPrincipal.arrayConsultas.size() > 0 && IVisualizaPaciente.idPaciente >= 0){
            for(ConsultaMedica consulta : TelaPrincipal.arrayPacientes.get(IVisualizaPaciente.idPaciente).getHistoricoConsultasMedicas()){
                String nomePaciente = Paciente.findById(TelaPrincipal.arrayPacientes, consulta.getIdPaciente()).getNomeCompleto();
                String nomeMedico = Medico.findById(TelaPrincipal.arrayMedicos, consulta.getIdMedico()).getNomeCompleto();
                dataArray.add(new MyDataModel(nomePaciente, nomeMedico, consulta.getExameQueixa(), consulta.getDiagnostico(), consulta.getPrescricao(), String.valueOf(consulta.isIndicacaoCirurgica())));
            }
        ObservableList<MyDataModel> dataList = FXCollections.observableArrayList(dataArray);
        tabelaConsultas.setItems(dataList);
        }
    
    }
    
}
