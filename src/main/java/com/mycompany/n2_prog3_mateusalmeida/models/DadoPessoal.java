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
public class DadoPessoal {
    private String nomeCompleto;
    private Date dataNascimento;
    private Endereco endereco;
    private ContatoTelEmail contato;
    private Genero genero;

    public DadoPessoal() {
    }

    public DadoPessoal(String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contato = contato;
        this.genero = genero;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContatoTelEmail getContato() {
        return contato;
    }

    public void setContato(ContatoTelEmail contato) {
        this.contato = contato;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }    

    @Override
    public String toString() {
        return "DadoPessoal{" + "nomeCompleto=" + nomeCompleto + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", contato=" + contato + ", genero=" + genero + '}';
    }
    
    
}
