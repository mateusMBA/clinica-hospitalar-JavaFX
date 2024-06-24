/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mateu
 */
@XmlRootElement(name = "consultas")
public class XMLConsultas {
    
    private ConsultaMedica[] consultas;

    public XMLConsultas() {
    }

    public XMLConsultas(ConsultaMedica[] consultas) {
        this.consultas = consultas;
    }

    @XmlElement(name = "consulta")
    public ConsultaMedica[] getConsultas() {
        return consultas;
    }

    public void setConsultas(ConsultaMedica[] consultas) {
        this.consultas = consultas;
    }
    
    
    
    
    
}
