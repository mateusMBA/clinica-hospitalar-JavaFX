/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.utils;
import javafx.scene.control.Alert;
import java.io.IOException;

/**
 *
 * @author mateu
 */
public class ErrorHandler {
    
    public static void exibirMsgInfo(String msg, String titulo) throws IOException{
        Alert msg_alerta = new Alert(Alert.AlertType.INFORMATION);
        msg_alerta.setTitle(titulo);
        msg_alerta.setContentText(msg);
        msg_alerta.showAndWait();
    }
    
    public static void exibirMsgAlerta(String msg, String titulo) throws IOException{
        Alert msg_alerta = new Alert(Alert.AlertType.WARNING);
        msg_alerta.setTitle(titulo);
        msg_alerta.setContentText(msg);
        msg_alerta.showAndWait();
    }
    
    public static void exibirMsgErro(String msg, String titulo) throws IOException{
        Alert msg_alerta = new Alert(Alert.AlertType.ERROR);
        msg_alerta.setTitle(titulo);
        msg_alerta.setContentText(msg);
        msg_alerta.showAndWait();
    }
}
