/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipalController;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLParser;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author mateu
 */
public class ExportarXML {
    
    public static void exportarXML() throws IOException{
        
        try{

            JAXBContext jaxbContextDados = JAXBContext.newInstance(XMLParser.class);
            Marshaller marshallerConsulta = jaxbContextDados.createMarshaller();
            marshallerConsulta.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fDados = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.xml");
            ConsultaMedica[] consultas = new ConsultaMedica[TelaPrincipalController.arrayConsultas.size()];
            for(int i = 0; i < TelaPrincipalController.arrayConsultas.size(); i++){
                consultas[i] = TelaPrincipalController.arrayConsultas.get(i);
            }
            Enfermeiro[] enfermeiros = new Enfermeiro[TelaPrincipalController.arrayEnfermeiros.size()];
            for(int i = 0; i < TelaPrincipalController.arrayEnfermeiros.size(); i++)
                enfermeiros[i] = TelaPrincipalController.arrayEnfermeiros.get(i);
            Medico[] medicos = new Medico[TelaPrincipalController.arrayMedicos.size()];
            for(int i = 0; i < TelaPrincipalController.arrayMedicos.size(); i++)
                medicos[i] = TelaPrincipalController.arrayMedicos.get(i);
            Paciente[] pacientes = new Paciente[TelaPrincipalController.arrayPacientes.size()];
            for(int i = 0; i < TelaPrincipalController.arrayPacientes.size(); i++)
                pacientes[i] = TelaPrincipalController.arrayPacientes.get(i);
            XMLParser dadosXML = new XMLParser(pacientes, medicos, consultas, enfermeiros);
            marshallerConsulta.marshal(dadosXML, fDados);
            ErrorHandler.exibirMsgInfo("Exportação Realizada com Sucesso", "Exportar XML");
            
        }catch(Exception ex){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Exportar XML");
        }
    }
    
}
