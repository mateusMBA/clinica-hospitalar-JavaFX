/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author mateu
 */
public class Paciente extends DadoPessoal{
    private static long geradorID = 1;
    private long idPaciente;
    private int idade;
    private Date dataCadastro;
    private String obsGeral;
    private ArrayList<ConsultaMedica> historicoConsultasMedicas = new ArrayList<>();
    private ArrayList<Responsavel> contatoResponsavel = new ArrayList<>();

    public Paciente() {
    }

    public Paciente(String obsGeral, ArrayList<Responsavel> contatoResponsavel, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero);
        this.obsGeral = obsGeral;
        this.contatoResponsavel = contatoResponsavel;
        this.dataCadastro = Date.from(Instant.now());
        long millisecondsDifference = this.dataCadastro.getTime() - dataNascimento.getTime();
        this.idade = (int)(millisecondsDifference / (1000 * 60 * 60 * 24 * 365.25));
        this.idPaciente = geradorID;
        geradorID++;
    }

    public Paciente(long idPaciente, int idade, Date dataCadastro, String obsGeral, String nomeCompleto, Date dataNascimento, Endereco endereco, ContatoTelEmail contato, Genero genero) {
        super(nomeCompleto, dataNascimento, endereco, contato, genero);
        this.idPaciente = idPaciente;
        this.idade = idade;
        this.dataCadastro = dataCadastro;
        this.obsGeral = obsGeral;
        geradorID = idPaciente + 1;
    }
    
    

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObsGeral() {
        return obsGeral;
    }

    public void setObsGeral(String obsGeral) {
        this.obsGeral = obsGeral;
    }

    public ArrayList<ConsultaMedica> getHistoricoConsultasMedicas() {
        return historicoConsultasMedicas;
    }

    public void setHistoricoConsultasMedicas(ArrayList<ConsultaMedica> historicoConsultasMedicas) {
        this.historicoConsultasMedicas = historicoConsultasMedicas;
    }

    public ArrayList<Responsavel> getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(ArrayList<Responsavel> contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }
    
    public static Paciente findById(ArrayList<Paciente> array,long id){
        for(Paciente paciente : array){
            if(paciente.getIdPaciente() == id)
                return paciente;
        }
        return null;
    }
    
    public void removerConsultaHistorico(ConsultaMedica consulta){
        this.historicoConsultasMedicas.remove(consulta);
    }
    
    //metodo para remover consulta do historico de consultas
    public static void removerConsultaHistorico(ArrayList<Paciente> array,ConsultaMedica consulta){
        for(Paciente paciente : array){
            Iterator<ConsultaMedica> consultas = paciente.getHistoricoConsultasMedicas().iterator();
            while(consultas.hasNext()){
                ConsultaMedica consultaAux = consultas.next();
                if(consultaAux.equals(consulta))
                    consultas.remove();
            }
        }
    }

    @Override
    public String toString() {
        return idPaciente + " - " + this.getNomeCompleto();
    }
    
    
    
}
