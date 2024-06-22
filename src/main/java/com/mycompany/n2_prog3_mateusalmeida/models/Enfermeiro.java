/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

import java.util.Date;

/**
 *
 * @author mateu
 */
public class Enfermeiro extends AtendenteHospitalar{
    private static long geradorID = 1;
    private long idEnfermeiro;
    private boolean treinadoOpRX;

    public Enfermeiro() {
    }

    public Enfermeiro(boolean treinadoOpRX, String setor, int chSemanal, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.treinadoOpRX = treinadoOpRX;
        this.idEnfermeiro = geradorID;
        geradorID++;
    }

    public Enfermeiro(long idEnfermeiro, boolean treinadoOpRX, String setor, int chSemanal, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.idEnfermeiro = idEnfermeiro;
        this.treinadoOpRX = treinadoOpRX;
        geradorID = idEnfermeiro + 1;
    }
    
    
    
    public Long getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(Long idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public boolean isTreinadoOpRX() {
        return treinadoOpRX;
    }

    public void setTreinadoOpRX(boolean treinadoOpRX) {
        this.treinadoOpRX = treinadoOpRX;
    }    

    @Override
    public String toString() {
        return idEnfermeiro + " - " + this.getNomeCompleto();
    }
    
    
}
