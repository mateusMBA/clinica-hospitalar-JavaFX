/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipal;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Endereco;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Genero;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import com.mycompany.n2_prog3_mateusalmeida.models.Responsavel;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author mateu
 */
public class ImportarJSON {
    
    public static void importarJSON() throws IOException{
        TelaPrincipal.arrayConsultas = new ArrayList<>();
        TelaPrincipal.arrayMedicos = new ArrayList<>();
        TelaPrincipal.arrayPacientes = new ArrayList<>();
        TelaPrincipal.arrayEnfermeiros = new ArrayList<>();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY"); 
        
         try {
            
            // Specify path to your JSON file
            String content = new String(Files.readAllBytes(Paths.get("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.json")));
            
            // Read JSON from file and map to object
            JSONObject dados = new JSONObject(content);
            JSONArray arrayPacientes = dados.getJSONArray("pacientes");
            JSONArray arrayMedicos = dados.getJSONArray("medicos");
            JSONArray arrayEnfermeiros = dados.getJSONArray("enfermeiros");
            JSONArray arrayConsultas = dados.getJSONArray("consultas");
            
            for(int i = 0; i < arrayConsultas.length(); i++){
                JSONObject jsonObject = arrayConsultas.getJSONObject(i);
                long idConsulta = jsonObject.getLong("idConsulta");
                long idPaciente = jsonObject.getLong("idPaciente");
                long idMedico = jsonObject.getLong("idMedico");
                String queixa = jsonObject.getString("queixa");
                String diagnostico = jsonObject.getString("diagnostico");
                String prescricao = jsonObject.getString("prescricao");
                boolean indicacaoCirurgia = jsonObject.getBoolean("cirurgia");
                ConsultaMedica consulta = new ConsultaMedica(idConsulta, idPaciente, idMedico, queixa, diagnostico, prescricao, indicacaoCirurgia);
                TelaPrincipal.arrayConsultas.add(consulta);
            }
            
            for (int i = 0; i < arrayPacientes.length(); i++) {
                // Get individual JSON object from array
                JSONObject jsonObject = arrayPacientes.getJSONObject(i);
                long idPaciente = jsonObject.getLong("idPaciente");
                String nomeCompleto = jsonObject.getString("nomeCompleto");
                Date dataNascimento = Date.from(Instant.now()), dataCadastro = Date.from(Instant.now());
                try{
                    dataNascimento = formato.parse(jsonObject.getString("dataNascimento"));
                    dataCadastro = formato.parse(jsonObject.getString("dataCadastro"));
                }catch(ParseException ex){
                System.out.println("Formato de data invalido");
                }
                int idade = jsonObject.getInt("idade");
                String genero = jsonObject.getString("genero");
                String rua = jsonObject.getJSONObject("endereco").getString("rua");
                int numero = jsonObject.getJSONObject("endereco").getInt("numero");
                String bairro = jsonObject.getJSONObject("endereco").getString("bairro");
                String cidade = jsonObject.getJSONObject("endereco").getString("cidade");
                String estado = jsonObject.getJSONObject("endereco").getString("estado");
                int cep = jsonObject.getJSONObject("endereco").getInt("CEP");
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                String celular = jsonObject.getJSONObject("contato").getString("celular");
                String telefone = jsonObject.getJSONObject("contato").getString("telefone");
                String email = jsonObject.getJSONObject("contato").getString("email");
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                String obsGeral = jsonObject.getString("obsGeral");
                JSONArray arrayHistorico = jsonObject.getJSONArray("historicoConsultasMedicas");
                ArrayList<ConsultaMedica> historicoConsultas =  new ArrayList<>();;
                
                for(int j = 0; j < arrayHistorico.length(); j++){
                    JSONObject jsonObjectConsulta = arrayHistorico.getJSONObject(j);
                    long idConsulta = jsonObjectConsulta.getLong("ID");
                    historicoConsultas.add(ConsultaMedica.findById(TelaPrincipal.arrayConsultas, idConsulta));
                }
                
                JSONArray arrayResponsaveis = jsonObject.getJSONArray("contatoResponsavel");
                ArrayList<Responsavel> contatoResponsavel = new ArrayList<>();
                for(int j = 0; j < arrayResponsaveis.length(); j++){
                    JSONObject jsonObjectResponsavel = arrayResponsaveis.getJSONObject(j);
                    String nomeResp = jsonObjectResponsavel.getString("nomeResp");
                    String celularResp = jsonObjectResponsavel.getString("celularResp");
                    String telefoneResp = jsonObjectResponsavel.getString("telefoneResp");
                    String emailResp = jsonObjectResponsavel.getString("emailResp");
                    contatoResponsavel.add(new Responsavel(nomeResp, telefoneResp, celularResp, emailResp)); 
                }
                
                
                Paciente paciente = new Paciente(idPaciente, idade, dataCadastro, obsGeral, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
                paciente.setContatoResponsavel(contatoResponsavel);
                paciente.setHistoricoConsultasMedicas(historicoConsultas);
                TelaPrincipal.arrayPacientes.add(paciente);
            }
            
            for (int i = 0; i < arrayMedicos.length(); i++) {
                // Get individual JSON object from array
                JSONObject jsonObject = arrayMedicos.getJSONObject(i);
               
                long idMedico = jsonObject.getLong("idMedico");
                String nomeCompleto = jsonObject.getString("nomeCompleto");
                Date dataNascimento = Date.from(Instant.now());
                try{
                    dataNascimento = formato.parse(jsonObject.getString("dataNascimento"));
                }catch(ParseException ex){
                System.out.println("Formato de data invalido");
                }
                int CRM = jsonObject.getInt("crm");
                String genero = jsonObject.getString("genero");
                String setor = jsonObject.getString("setor");
                int cargaHoraria = jsonObject.getInt("cargaHoraria");
                ArrayList<String> especialidades = new ArrayList<>();
                String[] especialidadesArray = jsonObject.getString("especialidades").split(",");
                //varrer as especialidade na string e adicionar ao array de especialidades
                for(String especialidade : especialidadesArray)
                    especialidades.add(especialidade);
                boolean cirurgiao = jsonObject.getBoolean("cirurgiao");
                String rua = jsonObject.getJSONObject("endereco").getString("rua");
                int numero = jsonObject.getJSONObject("endereco").getInt("numero");
                String bairro = jsonObject.getJSONObject("endereco").getString("bairro");
                String cidade = jsonObject.getJSONObject("endereco").getString("cidade");
                String estado = jsonObject.getJSONObject("endereco").getString("estado");
                int cep = jsonObject.getJSONObject("endereco").getInt("CEP");
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                String celular = jsonObject.getJSONObject("contato").getString("celular");
                String telefone = jsonObject.getJSONObject("contato").getString("telefone");
                String email = jsonObject.getJSONObject("contato").getString("email");
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                Medico medico = new Medico(idMedico, numero, especialidades, cirurgiao, setor, cargaHoraria, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
                //adicionar as informacoes ao array de medicos
                TelaPrincipal.arrayMedicos.add(medico);
            }
            
            for (int i = 0; i < arrayEnfermeiros.length(); i++) {
                // Get individual JSON object from array
                JSONObject jsonObject = arrayEnfermeiros.getJSONObject(i);
               
                long idEnfermeiro = jsonObject.getLong("idEnfermeiro");
                String nomeCompleto = jsonObject.getString("nomeCompleto");
                Date dataNascimento = Date.from(Instant.now());
                try{
                    dataNascimento = formato.parse(jsonObject.getString("dataNascimento"));
                }catch(ParseException ex){
                System.out.println("Formato de data invalido");
                }
                String genero = jsonObject.getString("genero");
                String setor = jsonObject.getString("setor");
                int cargaHoraria = jsonObject.getInt("cargaHoraria");
                boolean raioX = jsonObject.getBoolean("raioX");
                String rua = jsonObject.getJSONObject("endereco").getString("rua");
                int numero = jsonObject.getJSONObject("endereco").getInt("numero");
                String bairro = jsonObject.getJSONObject("endereco").getString("bairro");
                String cidade = jsonObject.getJSONObject("endereco").getString("cidade");
                String estado = jsonObject.getJSONObject("endereco").getString("estado");
                int cep = jsonObject.getJSONObject("endereco").getInt("CEP");
                Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
                String celular = jsonObject.getJSONObject("contato").getString("celular");
                String telefone = jsonObject.getJSONObject("contato").getString("telefone");
                String email = jsonObject.getJSONObject("contato").getString("email");
                ContatoTelEmail contato = new ContatoTelEmail(telefone, celular, email);
                Enfermeiro enfermeiro = new Enfermeiro(idEnfermeiro, raioX, setor, cargaHoraria, nomeCompleto, dataNascimento, endereco, contato, Genero.valueOf(genero));
                //adicionar as informacoes ao array de medicos
                TelaPrincipal.arrayEnfermeiros.add(enfermeiro);
            }
            ErrorHandler.exibirMsgInfo("Importação Realizada com Sucesso", "Importar JSON");
        } catch (IOException e) {
            ErrorHandler.exibirMsgErro("Tente Novamente", "Importar JSON");
        }
    }
    
}
