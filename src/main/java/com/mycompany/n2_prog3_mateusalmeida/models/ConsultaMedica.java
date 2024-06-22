/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;


import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mateu
 */
public class ConsultaMedica {
    private static long geradorID = 1;
    private Long idConsulta;
    private Long idPaciente;
    private Long idMedico;
    private String exameQueixa;
    private String diagnostico;
    private String prescricao;
    private boolean indicacaoCirurgica;

    public ConsultaMedica() {
    }
    
    public ConsultaMedica( Long idPaciente, Long idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        this.idConsulta = geradorID;
        geradorID++;
    }

    public ConsultaMedica(Long idConsulta, Long idPaciente, Long idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        geradorID = idConsulta + 1;
    }
    
    
    
    public Long getIdConsulta() {
        return idConsulta;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
    

    public Long getIdMedico() {
        return idMedico;
    }

    public String getExameQueixa() {
        return exameQueixa;
    }

    public void setExameQueixa(String exameQueixa) {
        this.exameQueixa = exameQueixa;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public boolean isIndicacaoCirurgica() {
        return indicacaoCirurgica;
    }

    public void setIndicacaoCirurgica(boolean indicacaoCirurgica) {
        this.indicacaoCirurgica = indicacaoCirurgica;
    }
    
    //Metodo para excluir consulta da base de consultas e do historico de consultas ao excluir medico
    public static void removerConsultaPorIdMedico(ArrayList<ConsultaMedica> array, long idMedico){;
        Iterator<ConsultaMedica> consultas = array.iterator();
        while(consultas.hasNext()){
            ConsultaMedica consulta = consultas.next();
            if(consulta.getIdMedico()== idMedico){
                Paciente.removerConsultaHistorico(TelaPrincipal.arrayPacientes, consulta);
                consultas.remove();
            }
        }
    }
    
    //Metodo para excluir consulta da base de consultas ao excluir o paciente
    public static void removerConsultaPorIdPaciente(ArrayList<ConsultaMedica> array, long idPaciente){
        Iterator<ConsultaMedica> consultas = array.iterator();
        while(consultas.hasNext()){
            ConsultaMedica consulta = consultas.next();
            if(consulta.getIdPaciente()== idPaciente)
                consultas.remove();
        }
    }
    
    public static ConsultaMedica findById(ArrayList<ConsultaMedica> array,long id){
        for(ConsultaMedica consulta : array){
            if(consulta.getIdConsulta()== id)
                return consulta;
        }
        return null;
    }

    @Override
    public String toString() {
        return idConsulta + " - " + Paciente.findById(TelaPrincipal.arrayPacientes, this.idPaciente).getNomeCompleto();
    }
    
    
    
}
