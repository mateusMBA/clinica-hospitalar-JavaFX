/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLPacientes;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLConsultas;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLEnfermeiros;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLMedicos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mateu
 */
public class ImportarXML {
    
    public static void importarXML(){
        
        TelaPrincipal.arrayPacientes = new ArrayList<>();
        
        try{
        JAXBContext jaxbContextPaciente = JAXBContext.newInstance(XMLPacientes.class);
        Unmarshaller unMarshallerPaciente = jaxbContextPaciente.createUnmarshaller();
        XMLPacientes pacientes = (XMLPacientes)unMarshallerPaciente.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Pacientes.xml"));
        for(Paciente paciente : pacientes.getPacientes()){
            TelaPrincipal.arrayPacientes.add(paciente);
        }
        
        JAXBContext jaxbContextMedico = JAXBContext.newInstance(XMLMedicos.class);
        Unmarshaller unMarshallerMedico = jaxbContextMedico.createUnmarshaller();
        XMLMedicos medicos = (XMLMedicos)unMarshallerMedico.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Medicos.xml"));
        for(Medico medico : medicos.getMedicos()){
            TelaPrincipal.arrayMedicos.add(medico);
        }
        
        JAXBContext jaxbContextEnfermeiro = JAXBContext.newInstance(XMLEnfermeiros.class);
        Unmarshaller unMarshallerEnfermeiro = jaxbContextEnfermeiro.createUnmarshaller();
        XMLEnfermeiros enfermeiros = (XMLEnfermeiros)unMarshallerEnfermeiro.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Enfermeiros.xml"));
        for(Enfermeiro enfermeiro : enfermeiros.getEnfermeiros()){
            TelaPrincipal.arrayEnfermeiros.add(enfermeiro);
        }
        
        JAXBContext jaxbContextConsulta = JAXBContext.newInstance(XMLConsultas.class);
        Unmarshaller unMarshallerConsulta = jaxbContextConsulta.createUnmarshaller();
        XMLConsultas consultas = (XMLConsultas)unMarshallerConsulta.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/Consultas.xml"));
        for(ConsultaMedica consulta : consultas.getConsultas()){
            TelaPrincipal.arrayConsultas.add(consulta);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
