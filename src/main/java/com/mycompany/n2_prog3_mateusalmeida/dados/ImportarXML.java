/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLParser;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
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
        
        TelaPrincipal.arrayConsultas = new ArrayList<>();
        TelaPrincipal.arrayMedicos = new ArrayList<>();
        TelaPrincipal.arrayPacientes = new ArrayList<>();
        TelaPrincipal.arrayEnfermeiros = new ArrayList<>();
        
        try{
        JAXBContext jaxbContextDados = JAXBContext.newInstance(XMLParser.class);
        Unmarshaller unMarshallerPaciente = jaxbContextDados.createUnmarshaller();
        XMLParser dados = (XMLParser)unMarshallerPaciente.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.xml"));
        for(Paciente paciente : dados.getPacientes()){
            TelaPrincipal.arrayPacientes.add(paciente);
        }
        for(Medico medico : dados.getMedicos()){
            TelaPrincipal.arrayMedicos.add(medico);
        }
        for(Enfermeiro enfermeiro : dados.getEnfermeiros()){
            TelaPrincipal.arrayEnfermeiros.add(enfermeiro);
        }
        for(ConsultaMedica consulta : dados.getConsultas()){
            TelaPrincipal.arrayConsultas.add(consulta);
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
