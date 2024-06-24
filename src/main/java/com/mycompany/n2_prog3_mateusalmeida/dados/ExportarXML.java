/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLParser;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author mateu
 */
public class ExportarXML {
    
    public static void exportarXML(){
        
        try{

            JAXBContext jaxbContextDados = JAXBContext.newInstance(XMLParser.class);
            Marshaller marshallerConsulta = jaxbContextDados.createMarshaller();
            marshallerConsulta.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fDados = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.xml");
            ConsultaMedica[] consultas = new ConsultaMedica[TelaPrincipal.arrayConsultas.size()];
            for(int i = 0; i < TelaPrincipal.arrayConsultas.size(); i++){
                consultas[i] = TelaPrincipal.arrayConsultas.get(i);
            }
            Enfermeiro[] enfermeiros = new Enfermeiro[TelaPrincipal.arrayEnfermeiros.size()];
            for(int i = 0; i < TelaPrincipal.arrayEnfermeiros.size(); i++)
                enfermeiros[i] = TelaPrincipal.arrayEnfermeiros.get(i);
            Medico[] medicos = new Medico[TelaPrincipal.arrayMedicos.size()];
            for(int i = 0; i < TelaPrincipal.arrayMedicos.size(); i++)
                medicos[i] = TelaPrincipal.arrayMedicos.get(i);
            Paciente[] pacientes = new Paciente[TelaPrincipal.arrayPacientes.size()];
            for(int i = 0; i < TelaPrincipal.arrayPacientes.size(); i++)
                pacientes[i] = TelaPrincipal.arrayPacientes.get(i);
            XMLParser dadosXML = new XMLParser(pacientes, medicos, consultas, enfermeiros);
            marshallerConsulta.marshal(dadosXML, fDados);
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
