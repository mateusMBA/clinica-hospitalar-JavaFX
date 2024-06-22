///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.n2_prog3_mateusalmeida.dados;
//
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.interfaces.TelaPrincipal;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.ConsultaMedica;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.ContatoTelEmail;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Endereco;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Enfermeiro;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Genero;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Medico;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Paciente;
//import com.mycompany.projeto_clinicahospitalar_mateusalmeida.models.Responsavel;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.Date;
//import javax.swing.JOptionPane;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author mateu
// */
//public class ImportarExcel {
//    
//    public static void lerExcel() {
//		
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/Projeto_ClinicaHospitalar_MateusAlmeida/src/main/java/com/mycompany/projeto_clinicahospitalar_mateusalmeida/dados/DadosClinicaHospitalar.xlsx"); 
//			
//            TelaPrincipal.arrayConsultas = new ArrayList<>();
//            TelaPrincipal.arrayMedicos = new ArrayList<>();
//            TelaPrincipal.arrayPacientes = new ArrayList<>();
//            TelaPrincipal.arrayEnfermeiros = new ArrayList<>();
//            
//            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");            
//            
//            //Atribuir abas aos objetos do tipo Sheet
//            Sheet sheetPaciente = workbook.getSheet("Paciente");
//            Sheet sheetMedico = workbook.getSheet("Médico");
//            Sheet sheetEnfermeiro = workbook.getSheet("Enfermeiro");
//            Sheet sheetConsulta = workbook.getSheet("Consulta Médica");
//            Sheet sheetResponsavel = workbook.getSheet("Responsavel");
//            //Atribuir o numero de registros em cada aba a uma variavel
//            int rowCountPaciente = sheetPaciente.getLastRowNum()-sheetPaciente.getFirstRowNum();
//            int rowCountMedico = sheetMedico.getLastRowNum()-sheetMedico.getFirstRowNum();
//            int rowCountEnfermeiro = sheetEnfermeiro.getLastRowNum()-sheetEnfermeiro.getFirstRowNum();
//            int rowCountConsulta = sheetConsulta.getLastRowNum()-sheetConsulta.getFirstRowNum();
//            int rowCountResponsavel = sheetResponsavel.getLastRowNum()-sheetResponsavel.getFirstRowNum();
//            
//            //Preencher o array estatico de consultas com as informacoes da aba Consulta Medica do excel
//            for (int i=1; i<=rowCountConsulta; i++){
//                Row rowConsulta = sheetConsulta.getRow(i);
//                long idConsulta = (long)rowConsulta.getCell(0).getNumericCellValue();
//                long idPaciente = (long)rowConsulta.getCell(1).getNumericCellValue();
//                long idMedico = (long)rowConsulta.getCell(2).getNumericCellValue();
//                String queixa = rowConsulta.getCell(3).getStringCellValue();
//                String diagnostico = rowConsulta.getCell(4).getStringCellValue();
//                String prescricao = rowConsulta.getCell(5).getStringCellValue();
//                boolean indicacaoCirurgia = rowConsulta.getCell(6).getBooleanCellValue();
//                ConsultaMedica consulta = new ConsultaMedica(idConsulta, idPaciente, idMedico, queixa, diagnostico, prescricao, indicacaoCirurgia);
//                TelaPrincipal.arrayConsultas.add(consulta);
//            }
//            
//            //Preencher o array estatico de pacientes com as informacoes da aba Paciente do excel
//            for (int i=1; i<=rowCountPaciente; i++) {
//                Row row = sheetPaciente.getRow(i);
//                long idPaciente = (long)row.getCell(0).getNumericCellValue();
//                String nomeCompleto = row.getCell(1).getStringCellValue();
//                Date dataNascimento = Date.from(Instant.now()), dataCadastro = Date.from(Instant.now());
//                try{
//                    dataNascimento = formato.parse(row.getCell(2).getStringCellValue());
//                    dataCadastro = formato.parse(row.getCell(5).getStringCellValue());
//                } catch (ParseException ex) {
//                System.out.println("Formato de data invalido");
//                }
//                int idade = (int)row.getCell(3).getNumericCellValue();
//                String genero = row.getCell(4).getStringCellValue();
//                String rua = row.getCell(6).getStringCellValue();
//                int numero = (int)row.getCell(7).getNumericCellValue();
//                String bairro = row.getCell(8).getStringCellValue();
//                String cidade = row.getCell(9).getStringCellValue();
//                String estado = row.getCell(10).getStringCellValue();
//                int cep = (int)row.getCell(11).getNumericCellValue();
//                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
//                String celular = row.getCell(12).getStringCellValue();
//                String telefone = row.getCell(13).getStringCellValue();
//                String email = row.getCell(14).getStringCellValue();
//                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
//                String obsGeral = row.getCell(15).getStringCellValue();
//                String[] idConsultas = row.getCell(16).getStringCellValue().split(",");
//                String[] idResponsaveis = row.getCell(17).getStringCellValue().split(",");
//                ArrayList<ConsultaMedica> historicoConsultas =  new ArrayList<>();
//                ArrayList<Responsavel> contatoResponsavel = new ArrayList<>();
//                //Varrer a string com as ids de consulta
//                for(String id : idConsultas){
//                    //Acessar a consulta no vetor estatico de consultas utilizando o idd
//                    ConsultaMedica consulta = ConsultaMedica.findById(TelaPrincipal.arrayConsultas, Long.parseLong(id));
//                    if(consulta != null)
//                        //se existir consulta adicionar ao historico
//                        historicoConsultas.add(consulta);
//                }
//                //Varrer a string com as ids dos responsaveis
//                for(String id : idResponsaveis){
//                    for (int j=1; j<=rowCountResponsavel; j++){
//                        Row rowResponsavel = sheetResponsavel.getRow(j);
//                        long idResponsavel = (long)rowResponsavel.getCell(0).getNumericCellValue();
//                        //acessar os registros da tabela Responsavel e verificar o registro que possui o id
//                        if(Long.parseLong(id) == idResponsavel){                           
//                            String nomeResponsavel = rowResponsavel.getCell(1).getStringCellValue();
//                            String celularResponsavel = rowResponsavel.getCell(2).getStringCellValue();
//                            String telefoneResponsavel = rowResponsavel.getCell(3).getStringCellValue();
//                            String emailResponsavel = rowResponsavel.getCell(4).getStringCellValue();
//                            Responsavel responsavel = new Responsavel(nomeResponsavel, telefoneResponsavel, celularResponsavel, emailResponsavel);
//                            //criar um objeto responsavel e adicionar no arraylist de contato responsavel
//                            contatoResponsavel.add(responsavel);
//                        }
//                    }
//                }
//                Paciente paciente = new Paciente(idPaciente, idade, dataCadastro, obsGeral, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
//                paciente.setContatoResponsavel(contatoResponsavel);
//                paciente.setHistoricoConsultasMedicas(historicoConsultas);
//                //adicionar as informacoes ao array de paciente
//                TelaPrincipal.arrayPacientes.add(paciente);
//            }
//            
//            //Preencher o array estatico de medicos com as informacoes da aba Medico do excel
//            for (int i=1; i<=rowCountMedico; i++) {
//                Row row = sheetMedico.getRow(i);
//                long idMedico = (long)row.getCell(0).getNumericCellValue();
//                String nomeCompleto = row.getCell(1).getStringCellValue();
//                Date dataNascimento = Date.from(Instant.now());
//                try{
//                    dataNascimento = formato.parse(row.getCell(2).getStringCellValue());
//                } catch (ParseException ex) {
//                System.out.println("Formato de data invalido");
//                }
//                int CRM = (int)row.getCell(3).getNumericCellValue();
//                String genero = row.getCell(4).getStringCellValue();
//                String setor = row.getCell(5).getStringCellValue();
//                int cargaHoraria = (int)row.getCell(6).getNumericCellValue();
//                ArrayList<String> especialidades = new ArrayList<>();
//                String[] especialidadesArray = row.getCell(7).getStringCellValue().split(",");
//                //varrer as especialidade na string e adicionar ao array de especialidades
//                for(String especialidade : especialidadesArray)
//                    especialidades.add(especialidade);
//                boolean cirurgiao = row.getCell(8).getBooleanCellValue();
//                String rua = row.getCell(9).getStringCellValue();
//                int numero = (int)row.getCell(10).getNumericCellValue();
//                String bairro = row.getCell(11).getStringCellValue();
//                String cidade = row.getCell(12).getStringCellValue();
//                String estado = row.getCell(13).getStringCellValue();
//                int cep = (int)row.getCell(14).getNumericCellValue();
//                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
//                String celular = row.getCell(15).getStringCellValue();
//                String telefone = row.getCell(16).getStringCellValue();
//                String email = row.getCell(17).getStringCellValue();
//                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
//                Medico medico = new Medico(idMedico, numero, especialidades, cirurgiao, setor, cargaHoraria, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
//                //adicionar as informacoes ao array de medicos
//                TelaPrincipal.arrayMedicos.add(medico);
//            }
//            //Preencher o array estatico de medicos com as informacoes da aba Enfermeiro do excel
//            for (int i=1; i<=rowCountEnfermeiro; i++) {
//                Row row = sheetEnfermeiro.getRow(i);
//                long idMedico = (long)row.getCell(0).getNumericCellValue();
//                String nomeCompleto = row.getCell(1).getStringCellValue();
//                Date dataNascimento = Date.from(Instant.now());
//                try{
//                    dataNascimento = formato.parse(row.getCell(2).getStringCellValue());
//                } catch (ParseException ex) {
//                System.out.println("Formato de data invalido");
//                }
//                String genero = row.getCell(3).getStringCellValue();
//                String setor = row.getCell(4).getStringCellValue();
//                int cargaHoraria = (int)row.getCell(5).getNumericCellValue();
//                boolean treinadoOpRaioX = row.getCell(6).getBooleanCellValue();
//                String rua = row.getCell(7).getStringCellValue();
//                int numero = (int)row.getCell(8).getNumericCellValue();
//                String bairro = row.getCell(9).getStringCellValue();
//                String cidade = row.getCell(10).getStringCellValue();
//                String estado = row.getCell(11).getStringCellValue();
//                int cep = (int)row.getCell(12).getNumericCellValue();
//                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
//                String celular = row.getCell(13).getStringCellValue();
//                String telefone = row.getCell(14).getStringCellValue();
//                String email = row.getCell(15).getStringCellValue();
//                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
//                Enfermeiro enfermeiro = new Enfermeiro(idMedico, treinadoOpRaioX, setor, cargaHoraria, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
//                //adicionar as informacoes ao array de enfermeiros
//                TelaPrincipal.arrayEnfermeiros.add(enfermeiro);
//            }
//            
//            JOptionPane.showMessageDialog(null, "Importação Realizada com Sucesso");
//            }catch (IOException e) {
//                    e.printStackTrace();
//		}
//	
//		
//		
//	}
//}
