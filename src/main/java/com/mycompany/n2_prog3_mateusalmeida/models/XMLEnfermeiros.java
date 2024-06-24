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
@XmlRootElement(name = "enfermeiros")
public class XMLEnfermeiros {
    
    private Enfermeiro[] enfermeiros;

    public XMLEnfermeiros() {
    }

    public XMLEnfermeiros(Enfermeiro[] enfermeiros) {
        this.enfermeiros = enfermeiros;
    }
    
    
    
    @XmlElement(name = "enfermeiro")
    public Enfermeiro[] getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(Enfermeiro[] enfermeiros) {
        this.enfermeiros = enfermeiros;
    }
    
    
    
}
