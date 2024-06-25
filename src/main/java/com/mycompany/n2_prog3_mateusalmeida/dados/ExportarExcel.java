/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.Responsavel;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author mateu
 */
public class ExportarExcel {
    
    public static void escreverExcel() throws IOException{
        
        //C:\Users\mateu\Desktop\Estudos\Femass\Prog 3\Projeto_ClinicaHospitalar_MateusAlmeida\src\main\java\com\mycompany\projeto_clinicahospitalar_mateusalmeida\dados
        XSSFWorkbook workbook = new XSSFWorkbook();
        
       SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                        
        //criar cabecalho da aba Paciente
        String[] pacienteHeader = {"id Paciente","Nome Completo","Data de Nascimento", "Idade",
            "Genero","Data de Cadastro","Rua","Numero","Bairro","Cidade","Estado","CEP",
            "Celular","Telefone","Email","obsGeral","Historico Consulta","contatoResponsavel"};
        
        XSSFSheet abaPaciente = workbook.createSheet( "Paciente");
        Row headerRow = abaPaciente.createRow(0);
        
        for (int i = 0; i < pacienteHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(pacienteHeader[i]);
	}
        
        //criar cabecalho da aba Medico
        String[] medicoHeader = {"id Medico","Nome Completo","Data de Nascimento",
            "CRM","Genero","Setor","Carga Horária","Especialidades","Cirurgião",
            "Rua","Numero","Bairro","Cidade","Estado","CEP",
            "Celular","Telefone","Email"};
        
        XSSFSheet abaMedico = workbook.createSheet( "Médico");
        headerRow = abaMedico.createRow(0);
        
        for (int i = 0; i < medicoHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(medicoHeader[i]);
	}
        
        //criar cabecalho da aba Enfermeiro
        String[] enfermeiroHeader = {"id Enfermeiro","Nome Completo","Data de Nascimento",
            "Genero","Setor","Carga Horária","Treinado p/ RaioX?",
            "Rua","Numero","Bairro","Cidade","Estado","CEP",
            "Celular","Telefone","Email"};
        
        XSSFSheet abaEnfermeiro = workbook.createSheet( "Enfermeiro");
        headerRow = abaEnfermeiro.createRow(0);
        
        for (int i = 0; i < enfermeiroHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(enfermeiroHeader[i]);
	}
        
        //criar cabecalho da aba Consulta Medica
        String[] consultaHeader = {"id Consulta","id Paciente","id Médico",
            "Queixa","Diagnóstico","Prescrição","Indicação p/ Cirurgia?"};
        
        XSSFSheet abaConsulta = workbook.createSheet( "Consulta Médica");
        headerRow = abaConsulta.createRow(0);
        
        for (int i = 0; i < consultaHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(consultaHeader[i]);
	}
        
        //criar cabecalho da aba Responsavel
        //Foi utilizada aba Responsavel para conseguir construir o vetor de contato Responsavel ao importar do excel
        String[] responsavelHeader = {"id Responsavel","Nome Completo","Celular","Telefone","Email"};
        
        XSSFSheet abaResponsavel = workbook.createSheet( "Responsavel");
        headerRow = abaResponsavel.createRow(0);
        
        for (int i = 0; i < responsavelHeader.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(responsavelHeader[i]);
	}
        //Contador utilizado para criar o id Responsavel que sera usado como PK para correlacionar com paciente
        int contador = 0;
        //Preencher informacoes de paciente na aba paciente
        for(int i = 0; i < TelaPrincipal.arrayPacientes.size(); i++) {
            Row dataRow = abaPaciente.createRow(i + 1);            
            dataRow.createCell(0).setCellValue(TelaPrincipal.arrayPacientes.get(i).getIdPaciente());
            dataRow.createCell(1).setCellValue(TelaPrincipal.arrayPacientes.get(i).getNomeCompleto());
            dataRow.createCell(2).setCellValue(formatoData.format(TelaPrincipal.arrayPacientes.get(i).getDataNascimento()));
            dataRow.createCell(3).setCellValue(TelaPrincipal.arrayPacientes.get(i).getIdade());
            dataRow.createCell(4).setCellValue(TelaPrincipal.arrayPacientes.get(i).getGenero().toString());
            dataRow.createCell(5).setCellValue(formatoData.format(TelaPrincipal.arrayPacientes.get(i).getDataCadastro()));
            dataRow.createCell(6).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getRua());
            dataRow.createCell(7).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getNumero());
            dataRow.createCell(8).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getBairro());
            dataRow.createCell(9).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getCidade());
            dataRow.createCell(10).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getEstado());
            dataRow.createCell(11).setCellValue(TelaPrincipal.arrayPacientes.get(i).getEndereco().getCep());
            dataRow.createCell(12).setCellValue(TelaPrincipal.arrayPacientes.get(i).getContato().getCelular());
            dataRow.createCell(13).setCellValue(TelaPrincipal.arrayPacientes.get(i).getContato().getTelefone());
            dataRow.createCell(14).setCellValue(TelaPrincipal.arrayPacientes.get(i).getContato().getEmail());
            dataRow.createCell(15).setCellValue(TelaPrincipal.arrayPacientes.get(i).getObsGeral());
            String consultasAux = "";
            //Array criado com os ids de todas as consultas, separados por ","
            for(ConsultaMedica consulta : TelaPrincipal.arrayPacientes.get(i).getHistoricoConsultasMedicas()){
                consultasAux += consulta.getIdConsulta() + ",";
            }
            if(consultasAux.length()>0)
            //Metodo para remover a ultima ","
            dataRow.createCell(16).setCellValue(consultasAux.substring(0, consultasAux.length()-1));
            //Array criado com os ids de todas os responsaveis, separados por ","
            String responsavelAux = "";
            for(Responsavel responsavel : TelaPrincipal.arrayPacientes.get(i).getContatoResponsavel()){
                //Criando registro de Responsavel a partir do arraylist de contato Responsavel de cada paciente
                //Foi feito dessa forma para linkar o id gravado na tabela Paciente com o id Responsavel da tabela Responsavel
                Row dataRowResponsavel = abaResponsavel.createRow(contador + 1);
                dataRowResponsavel.createCell(0).setCellValue(contador+1);
                dataRowResponsavel.createCell(1).setCellValue(responsavel.getNomeResponsavel());
                dataRowResponsavel.createCell(2).setCellValue(responsavel.getCelular());
                dataRowResponsavel.createCell(3).setCellValue(responsavel.getTelefone());
                dataRowResponsavel.createCell(4).setCellValue(responsavel.getEmail());
                responsavelAux += (contador+1) + ",";
                contador++;    
            }
            //Metodo para remover a ultima ","
            if(responsavelAux.length()>0)
                dataRow.createCell(17).setCellValue(responsavelAux.substring(0, responsavelAux.length()-1));
        }
             
        for(int i = 0; i < TelaPrincipal.arrayMedicos.size(); i++) {
            //Preencher informacoes de medico na aba Medico
            Row dataRow = abaMedico.createRow(i + 1);            
            dataRow.createCell(0).setCellValue(TelaPrincipal.arrayMedicos.get(i).getIdMedico());
            dataRow.createCell(1).setCellValue(TelaPrincipal.arrayMedicos.get(i).getNomeCompleto());
            dataRow.createCell(2).setCellValue(formatoData.format(TelaPrincipal.arrayMedicos.get(i).getDataNascimento()));
            dataRow.createCell(3).setCellValue(TelaPrincipal.arrayMedicos.get(i).getNumeroCRM());
            dataRow.createCell(4).setCellValue(TelaPrincipal.arrayMedicos.get(i).getGenero().toString());
            dataRow.createCell(5).setCellValue(TelaPrincipal.arrayMedicos.get(i).getSetor());
            dataRow.createCell(6).setCellValue(TelaPrincipal.arrayMedicos.get(i).getChSemanal());
            //Array de string criado para guardas as especialidades, separadas por ","
            String especialidadesAux = "";
            for(String especialidade : TelaPrincipal.arrayMedicos.get(i).getAreasEspecialidade()){
                especialidadesAux += especialidade + ",";
            }
            if(especialidadesAux.length()>0)
                dataRow.createCell(7).setCellValue(especialidadesAux.substring(0, especialidadesAux.length()-1));
            dataRow.createCell(8).setCellValue(TelaPrincipal.arrayMedicos.get(i).isCirurgiao());
            dataRow.createCell(9).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getRua());
            dataRow.createCell(10).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getNumero());
            dataRow.createCell(11).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getBairro());
            dataRow.createCell(12).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getCidade());
            dataRow.createCell(13).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getEstado());
            dataRow.createCell(14).setCellValue(TelaPrincipal.arrayMedicos.get(i).getEndereco().getCep());
            dataRow.createCell(15).setCellValue(TelaPrincipal.arrayMedicos.get(i).getContato().getCelular());
            dataRow.createCell(16).setCellValue(TelaPrincipal.arrayMedicos.get(i).getContato().getTelefone());
            dataRow.createCell(17).setCellValue(TelaPrincipal.arrayMedicos.get(i).getContato().getEmail());
        }
        
        for(int i = 0; i < TelaPrincipal.arrayEnfermeiros.size(); i++) {
            //Preencher informacoes de enfermeiro na aba Enfermeiro
            Row dataRow = abaEnfermeiro.createRow(i + 1);            
            dataRow.createCell(0).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getIdEnfermeiro());
            dataRow.createCell(1).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getNomeCompleto());
            dataRow.createCell(2).setCellValue(formatoData.format(TelaPrincipal.arrayEnfermeiros.get(i).getDataNascimento()));
            dataRow.createCell(3).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getGenero().toString());
            dataRow.createCell(4).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getSetor());
            dataRow.createCell(5).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getChSemanal());
            dataRow.createCell(6).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).isTreinadoOpRX());
            dataRow.createCell(7).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getRua());
            dataRow.createCell(8).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getNumero());
            dataRow.createCell(9).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getBairro());
            dataRow.createCell(10).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getCidade());
            dataRow.createCell(11).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getEstado());
            dataRow.createCell(12).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getEndereco().getCep());
            dataRow.createCell(13).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getContato().getCelular());
            dataRow.createCell(14).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getContato().getTelefone());
            dataRow.createCell(15).setCellValue(TelaPrincipal.arrayEnfermeiros.get(i).getContato().getEmail());
        }
        
        for(int i = 0; i < TelaPrincipal.arrayConsultas.size(); i++) {
            //Preencher informacoes de consulta na aba Consulta
            Row dataRow = abaConsulta.createRow(i + 1);            
            dataRow.createCell(0).setCellValue(TelaPrincipal.arrayConsultas.get(i).getIdConsulta());
            dataRow.createCell(1).setCellValue(TelaPrincipal.arrayConsultas.get(i).getIdPaciente());
            dataRow.createCell(2).setCellValue(TelaPrincipal.arrayConsultas.get(i).getIdMedico());
            dataRow.createCell(3).setCellValue(TelaPrincipal.arrayConsultas.get(i).getExameQueixa());
            dataRow.createCell(4).setCellValue(TelaPrincipal.arrayConsultas.get(i).getDiagnostico());
            dataRow.createCell(5).setCellValue(TelaPrincipal.arrayConsultas.get(i).getPrescricao());
            dataRow.createCell(6).setCellValue(TelaPrincipal.arrayConsultas.get(i).isIndicacaoCirurgica());
        }
        
        FileOutputStream out;
            try {
                    out = new FileOutputStream( new File("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.xlsx"));

            workbook.write(out);
            out.close();
            ErrorHandler.exibirMsgInfo("Exportação Realizada com Sucesso", "Exportar Excel");
            } catch (FileNotFoundException e) {
                    ErrorHandler.exibirMsgAlerta("Arquivo não encontrado", "Exportar Excel");
            } catch (Exception e) {
                    ErrorHandler.exibirMsgErro("Tente Novamente", "Exportar Excel");
            }
    }
    
}
