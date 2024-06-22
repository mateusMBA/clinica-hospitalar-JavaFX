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
public class AtendenteHospitalar extends DadoPessoal{
    private String setor;
    private int chSemanal;

    public AtendenteHospitalar() {
        super();
    }

    public AtendenteHospitalar(String setor, int chSemanal,String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(nomeCompleto, dataNascimento, endereco, contato,genero);
        this.setor = setor;
        this.chSemanal = chSemanal;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getChSemanal() {
        return chSemanal;
    }

    public void setChSemanal(int chSemanal) {
        this.chSemanal = chSemanal;
    }

    @Override
    public String toString() {
        return "AtendenteHospitalar{" + "setor=" + setor + ", chSemanal=" + chSemanal + '}';
    }
    
    
    
}
