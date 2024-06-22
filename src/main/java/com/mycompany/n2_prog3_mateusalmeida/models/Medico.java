/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mateu
 */
public class Medico extends AtendenteHospitalar{
    private static long geradorID = 1;
    private long idMedico;
    private int numeroCRM;
    private ArrayList<String> areasEspecialidade;
    private boolean cirurgiao;

    public Medico() {
    }

    public Medico(int numeroCRM, ArrayList<String> areasEspecialidade, boolean cirurgiao, String setor, int chSemanal, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.numeroCRM = numeroCRM;
        this.areasEspecialidade = areasEspecialidade;
        this.cirurgiao = cirurgiao;
        this.idMedico = this.geradorID;
        geradorID++;
    }

    public Medico(long idMedico, int numeroCRM, ArrayList<String> areasEspecialidade, boolean cirurgiao, String setor, int chSemanal, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(setor, chSemanal, nomeCompleto, dataNascimento, endereco, contato, genero);
        this.idMedico = idMedico;
        this.numeroCRM = numeroCRM;
        this.areasEspecialidade = areasEspecialidade;
        this.cirurgiao = cirurgiao;
        geradorID = idMedico + 1;
    }
    
    

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public int getNumeroCRM() {
        return numeroCRM;
    }

    public void setNumeroCRM(int numeroCRM) {
        this.numeroCRM = numeroCRM;
    }

    public ArrayList<String> getAreasEspecialidade() {
        return areasEspecialidade;
    }

    public void setAreasEspecialidade(ArrayList<String> areasEspecialidade) {
        this.areasEspecialidade = areasEspecialidade;
    }

    public boolean isCirurgiao() {
        return cirurgiao;
    }

    public void setCirurgiao(boolean cirurgiao) {
        this.cirurgiao = cirurgiao;
    }
    
    //Método para retornar o objeto utilizando o id do medico
    public static Medico findById(ArrayList<Medico> array,long id){
        for(Medico medico : array){
            if(medico.getIdMedico()== id)
                return medico;
        }
        return null;
    }

    @Override
    public String toString() {
        return idMedico + " - " + this.getNomeCompleto();
    }
    
    
    
}
