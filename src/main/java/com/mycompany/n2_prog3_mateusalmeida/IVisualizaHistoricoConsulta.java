/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida;

import com.mycompany.n2_prog3_mateusalmeida.App;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 *
 * @author mateu
 */
public class IVisualizaHistoricoConsulta {
    
    @FXML
    TableView<ConsultaMedica> tabelaConsultas;
    
    @FXML
    private void switchToVisualizaPaciente() throws IOException {
        App.setRoot("IVisualizaPaciente");
    }
    
}
