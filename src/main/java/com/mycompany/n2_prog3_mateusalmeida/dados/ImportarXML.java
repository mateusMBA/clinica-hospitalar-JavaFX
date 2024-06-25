/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipalController;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.XMLParser;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static void importarXML() throws IOException{
        
        TelaPrincipalController.arrayConsultas = new ArrayList<>();
        TelaPrincipalController.arrayMedicos = new ArrayList<>();
        TelaPrincipalController.arrayPacientes = new ArrayList<>();
        TelaPrincipalController.arrayEnfermeiros = new ArrayList<>();
        
        try{
        JAXBContext jaxbContextDados = JAXBContext.newInstance(XMLParser.class);
        Unmarshaller unMarshallerPaciente = jaxbContextDados.createUnmarshaller();
        XMLParser dados = (XMLParser)unMarshallerPaciente.unmarshal(new FileReader("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.xml"));
        for(Paciente paciente : dados.getPacientes()){
            TelaPrincipalController.arrayPacientes.add(paciente);
        }
        for(Medico medico : dados.getMedicos()){
            TelaPrincipalController.arrayMedicos.add(medico);
        }
        for(Enfermeiro enfermeiro : dados.getEnfermeiros()){
            TelaPrincipalController.arrayEnfermeiros.add(enfermeiro);
        }
        for(ConsultaMedica consulta : dados.getConsultas()){
            TelaPrincipalController.arrayConsultas.add(consulta);
        }
        ErrorHandler.exibirMsgInfo("Importação Realizada com Sucesso", "Importar XML");
        }catch(Exception ex){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Importar XML");
        }
    }
    
}
