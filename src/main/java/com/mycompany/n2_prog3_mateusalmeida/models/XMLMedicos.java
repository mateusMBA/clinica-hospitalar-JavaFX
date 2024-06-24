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
@XmlRootElement(name = "medicos")
public class XMLMedicos {
    
    private Medico[] medicos;

    public XMLMedicos() {
    }

    public XMLMedicos(Medico[] medicos) {
        this.medicos = medicos;
    }
    
    @XmlElement(name = "medico")
    public Medico[] getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico[] medicos) {
        this.medicos = medicos;
    }
    
    
    
}
