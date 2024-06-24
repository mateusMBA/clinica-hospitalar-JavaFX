/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mateu
 */
@XmlRootElement(name = "pacientes")
public class XMLPacientes {
    private Paciente[] pacientes;

    public XMLPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    public XMLPacientes() {
    }
    
    @XmlElement(name = "paciente")
    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }
    
    
    
}
