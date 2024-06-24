/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author mateu
 */
@XmlRootElement(name = "dados")
public class XMLParser {
    
    private Paciente[] pacientes;
    private Medico[] medicos;
    private ConsultaMedica[] consultas;
    private Enfermeiro[] enfermeiros;

    public XMLParser() {
    }

    public XMLParser(Paciente[] pacientes, Medico[] medicos, ConsultaMedica[] consultas, Enfermeiro[] enfermeiros) {
        this.pacientes = pacientes;
        this.medicos = medicos;
        this.consultas = consultas;
        this.enfermeiros = enfermeiros;
    }

    public Paciente[] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }

    public Medico[] getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico[] medicos) {
        this.medicos = medicos;
    }

    public ConsultaMedica[] getConsultas() {
        return consultas;
    }

    public void setConsultas(ConsultaMedica[] consultas) {
        this.consultas = consultas;
    }

    public Enfermeiro[] getEnfermeiros() {
        return enfermeiros;
    }

    public void setEnfermeiros(Enfermeiro[] enfermeiros) {
        this.enfermeiros = enfermeiros;
    }
    
    
    
}
