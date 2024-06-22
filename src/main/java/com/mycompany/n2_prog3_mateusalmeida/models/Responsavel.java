/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

/**
 *
 * @author mateu
 */
public class Responsavel extends ContatoTelEmail{
    private static long geradorID = 1;
    private long idResponsavel;
    private String nomeResponsavel;

    public Responsavel() {
    }

    public Responsavel(String nomeResponsavel, String telefone, String celular, String email) {
        super(telefone, celular, email);
        this.nomeResponsavel = nomeResponsavel;
        this.idResponsavel = this.geradorID;
        geradorID++;
    }
    
    
    
    public long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    @Override
    public String toString() {
        return this.getNomeResponsavel();
    }
    
    
    
}
