/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.models;


import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipalController;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mateu
 */
public class ConsultaMedica {
    private static long geradorID = 1;
    private long idPaciente;
    private long idConsulta;
    private long idMedico;
    private String exameQueixa;
    private String diagnostico;
    private String prescricao;
    private boolean indicacaoCirurgica;

    public ConsultaMedica() {
    }
      
    public ConsultaMedica(long idPaciente, long idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        this.idConsulta = this.geradorID;
        geradorID++;
    }
    
    public ConsultaMedica(long idConsulta, long idPaciente, long idMedico, String exameQueixa, String diagnostico, String prescricao, boolean indicacaoCirurgica) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.exameQueixa = exameQueixa;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.indicacaoCirurgica = indicacaoCirurgica;
        geradorID = idConsulta + 1;
    }

    
    
    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }
    

    public long getIdMedico() {
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
                Paciente.removerConsultaHistorico(TelaPrincipalController.arrayPacientes, consulta);
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
        return idConsulta + " - " + Paciente.findById(TelaPrincipalController.arrayPacientes, this.idPaciente).getNomeCompleto();
    }
    
    
    
}
