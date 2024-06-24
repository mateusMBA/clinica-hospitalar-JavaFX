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
import com.mycompany.n2_prog3_mateusalmeida.models.XMLConsultas;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLEnfermeiros;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLMedicos;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLPacientes;
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
            JAXBContext jaxbContextPaciente = JAXBContext.newInstance(XMLPacientes.class);
            Marshaller marshallerPaciente = jaxbContextPaciente.createMarshaller();
            marshallerPaciente.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fPacientes = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Pacientes.xml");
            Paciente[] pacientes = new Paciente[TelaPrincipal.arrayPacientes.size()];
            for(int i = 0; i < TelaPrincipal.arrayPacientes.size(); i++)
                pacientes[i] = TelaPrincipal.arrayPacientes.get(i);
            XMLPacientes pacientesXML = new XMLPacientes(pacientes);
            marshallerPaciente.marshal(pacientesXML, fPacientes);
            
            JAXBContext jaxbContextMedico = JAXBContext.newInstance(XMLMedicos.class);
            Marshaller marshallerMedico = jaxbContextMedico.createMarshaller();
            marshallerMedico.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fMedicos = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Medicos.xml");
            Medico[] medicos = new Medico[TelaPrincipal.arrayMedicos.size()];
            for(int i = 0; i < TelaPrincipal.arrayMedicos.size(); i++)
                medicos[i] = TelaPrincipal.arrayMedicos.get(i);
            XMLMedicos medicosXML = new XMLMedicos(medicos);
            marshallerMedico.marshal(medicosXML, fMedicos);
            
            JAXBContext jaxbContextEnfermeiro = JAXBContext.newInstance(XMLEnfermeiros.class);
            Marshaller marshallerEnfermeiro = jaxbContextEnfermeiro.createMarshaller();
            marshallerEnfermeiro.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fEnfermeiros = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Enfermeiros.xml");
            Enfermeiro[] enfermeiros = new Enfermeiro[TelaPrincipal.arrayEnfermeiros.size()];
            for(int i = 0; i < TelaPrincipal.arrayEnfermeiros.size(); i++)
                enfermeiros[i] = TelaPrincipal.arrayEnfermeiros.get(i);
            XMLEnfermeiros enfermeirosXML = new XMLEnfermeiros(enfermeiros);
            marshallerEnfermeiro.marshal(enfermeirosXML, fEnfermeiros);
            
            JAXBContext jaxbContextConsulta = JAXBContext.newInstance(XMLConsultas.class);
            Marshaller marshallerConsulta = jaxbContextConsulta.createMarshaller();
            marshallerConsulta.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            FileWriter fConsultas = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Consultas.xml");
            ConsultaMedica[] consultas = new ConsultaMedica[TelaPrincipal.arrayConsultas.size()];
            for(int i = 0; i < TelaPrincipal.arrayConsultas.size(); i++){
                consultas[i] = TelaPrincipal.arrayConsultas.get(i);
                System.out.println(consultas[i].getIdConsulta());
            }
            XMLConsultas consultasXML = new XMLConsultas(consultas);
            marshallerConsulta.marshal(consultasXML, fConsultas);
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
