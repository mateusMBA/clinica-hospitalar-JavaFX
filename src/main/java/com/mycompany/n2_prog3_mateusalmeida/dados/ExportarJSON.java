/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.n2_prog3_mateusalmeida.dados;

import com.mycompany.n2_prog3_mateusalmeida.TelaPrincipalController;
import com.mycompany.n2_prog3_mateusalmeida.models.ConsultaMedica;
import com.mycompany.n2_prog3_mateusalmeida.models.ContatoTelEmail;
import com.mycompany.n2_prog3_mateusalmeida.models.Paciente;
import java.io.FileWriter;
import com.mycompany.n2_prog3_mateusalmeida.models.Enfermeiro;
import com.mycompany.n2_prog3_mateusalmeida.models.Medico;
import com.mycompany.n2_prog3_mateusalmeida.models.Responsavel;
import com.mycompany.n2_prog3_mateusalmeida.utils.ErrorHandler;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.json.*;

/**
 *
 * @author mateu
 */
public class ExportarJSON {
    
    public static void exportarXML() throws IOException{
        JSONObject dados = new JSONObject();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        JSONArray pacientesArray = new JSONArray();
        JSONArray medicosArray = new JSONArray();
        JSONArray enfermeirosArray = new JSONArray();
        JSONArray consultasArray = new JSONArray();
        
        
        
        //Loop through the pacientes ArrayList and convert each Paciente to JSONObject
        for (Paciente paciente : TelaPrincipalController.arrayPacientes){
            JSONObject pacienteObject = new JSONObject();
            pacienteObject.put("nomeCompleto", paciente.getNomeCompleto());
            pacienteObject.put("dataNascimento", dateFormat.format(paciente.getDataNascimento()));
            JSONObject enderecoObject = new JSONObject();
            enderecoObject.put("rua", paciente.getEndereco().getRua());
            enderecoObject.put("numero", String.format("%d", paciente.getEndereco().getNumero()));
            enderecoObject.put("bairro", paciente.getEndereco().getBairro());
            enderecoObject.put("cidade", paciente.getEndereco().getCidade());
            enderecoObject.put("estado", paciente.getEndereco().getEstado());
            enderecoObject.put("CEP", String.format("%d", paciente.getEndereco().getCep()));
            pacienteObject.put("endereco", enderecoObject);
            JSONObject contatoObject = new JSONObject();
            contatoObject.put("celular", paciente.getContato().getCelular());
            contatoObject.put("telefone", paciente.getContato().getTelefone());
            contatoObject.put("email", paciente.getContato().getEmail());
            pacienteObject.put("contato", contatoObject);
            pacienteObject.put("genero", paciente.getGenero());
            pacienteObject.put("idPaciente", paciente.getIdPaciente());
            pacienteObject.put("idade", paciente.getIdade());
            pacienteObject.put("dataCadastro", dateFormat.format(paciente.getDataCadastro()));
            pacienteObject.put("obsGeral", paciente.getObsGeral());
            JSONArray historicoConsulta = new JSONArray();
            for(ConsultaMedica consulta : paciente.getHistoricoConsultasMedicas()){
                JSONObject historicoConsultaObj = new JSONObject();
                historicoConsultaObj.put("ID", consulta.getIdConsulta());
                historicoConsulta.put(historicoConsultaObj);
            }
            pacienteObject.put("historicoConsultasMedicas", historicoConsulta);
            JSONArray contatoResponsaveis = new JSONArray();
            for(Responsavel contato : paciente.getContatoResponsavel()){
                JSONObject contatoResponsavelObject = new JSONObject();
                contatoResponsavelObject.put("nomeResp", contato.getNomeResponsavel());
                contatoResponsavelObject.put("celularResp", contato.getCelular());
                contatoResponsavelObject.put("telefoneResp", contato.getTelefone());
                contatoResponsavelObject.put("emailResp", contato.getEmail());
                contatoResponsaveis.put(contatoResponsavelObject);
            }
            pacienteObject.put("contatoResponsavel", contatoResponsaveis);
            pacientesArray.put(pacienteObject);
        }
        dados.put("pacientes",pacientesArray);
        
        for(Medico medico: TelaPrincipalController.arrayMedicos) {
            //Preencher informacoes de medico na aba Medico
            JSONObject medicoObject = new JSONObject();          
            medicoObject.put("idMedico", medico.getIdMedico());
            medicoObject.put("dataNascimento", dateFormat.format(medico.getDataNascimento()));         
            medicoObject.put("crm", medico.getNumeroCRM());          
            medicoObject.put("genero", medico.getGenero());          
            medicoObject.put("setor", medico.getSetor());          
            medicoObject.put("cargaHoraria", medico.getChSemanal());
            medicoObject.put("nomeCompleto", medico.getNomeCompleto());
            medicoObject.put("cirurgiao", medico.isCirurgiao());
            JSONObject enderecoObject = new JSONObject();
            enderecoObject.put("rua", medico.getEndereco().getRua());
            enderecoObject.put("numero", String.format("%d", medico.getEndereco().getNumero()));
            enderecoObject.put("bairro", medico.getEndereco().getBairro());
            enderecoObject.put("cidade", medico.getEndereco().getCidade());
            enderecoObject.put("estado", medico.getEndereco().getEstado());
            enderecoObject.put("CEP", String.format("%d", medico.getEndereco().getCep()));
            medicoObject.put("endereco", enderecoObject);
            JSONObject contatoObject = new JSONObject();
            contatoObject.put("celular", medico.getContato().getCelular());
            contatoObject.put("telefone", medico.getContato().getTelefone());
            contatoObject.put("email", medico.getContato().getEmail());
            medicoObject.put("contato", contatoObject);
            //Array de string criado para guardas as especialidades, separadas por ","
            String especialidadesAux = "";
            for(String especialidade : medico.getAreasEspecialidade()){
                especialidadesAux += especialidade + ",";
            }
            if(especialidadesAux.length()>0)
                medicoObject.put("especialidades",especialidadesAux.substring(0, especialidadesAux.length()-1));
            medicosArray.put(medicoObject);
        }
        dados.put("medicos",medicosArray);
        
        for(Enfermeiro enfermeiro: TelaPrincipalController.arrayEnfermeiros) {
            //Preencher informacoes de medico na aba Medico
            JSONObject enfermeiroObject = new JSONObject();          
            enfermeiroObject.put("idEnfermeiro", enfermeiro.getIdEnfermeiro());
            enfermeiroObject.put("dataNascimento", dateFormat.format(enfermeiro.getDataNascimento()));                   
            enfermeiroObject.put("genero", enfermeiro.getGenero());          
            enfermeiroObject.put("setor", enfermeiro.getSetor());          
            enfermeiroObject.put("cargaHoraria", enfermeiro.getChSemanal());
            enfermeiroObject.put("nomeCompleto", enfermeiro.getNomeCompleto());
            enfermeiroObject.put("raioX", enfermeiro.isTreinadoOpRX());
            JSONObject enderecoObject = new JSONObject();
            enderecoObject.put("rua", enfermeiro.getEndereco().getRua());
            enderecoObject.put("numero", String.format("%d", enfermeiro.getEndereco().getNumero()));
            enderecoObject.put("bairro", enfermeiro.getEndereco().getBairro());
            enderecoObject.put("cidade", enfermeiro.getEndereco().getCidade());
            enderecoObject.put("estado", enfermeiro.getEndereco().getEstado());
            enderecoObject.put("CEP", String.format("%d", enfermeiro.getEndereco().getCep()));
            enfermeiroObject.put("endereco", enderecoObject);
            JSONObject contatoObject = new JSONObject();
            contatoObject.put("celular", enfermeiro.getContato().getCelular());
            contatoObject.put("telefone", enfermeiro.getContato().getTelefone());
            contatoObject.put("email", enfermeiro.getContato().getEmail());
            enfermeiroObject.put("contato", contatoObject);
            enfermeirosArray.put(enfermeiroObject);
        }
        dados.put("enfermeiros",enfermeirosArray);
        
        for(ConsultaMedica consulta: TelaPrincipalController.arrayConsultas) {
            //Preencher informacoes de medico na aba Medico
            JSONObject consultaObject = new JSONObject();          
            consultaObject.put("idConsulta", consulta.getIdConsulta());
            consultaObject.put("idMedico", consulta.getIdMedico());
            consultaObject.put("idPaciente", consulta.getIdPaciente());
            consultaObject.put("queixa", consulta.getExameQueixa());         
            consultaObject.put("diagnostico", consulta.getDiagnostico());
            consultaObject.put("prescricao", consulta.getPrescricao());
            consultaObject.put("cirurgia", consulta.isIndicacaoCirurgica());
            consultasArray.put(consultaObject);
        }
        dados.put("consultas",consultasArray);
        
        // Write the JSONArray to a file;
        try{
        FileWriter writer = new FileWriter("C:/Users/mateu/Desktop/Estudos/Femass/Prog 3/N2_Prog3_MateusAlmeida/src/main/java/com/mycompany/n2_prog3_mateusalmeida/dados/DadosClinicaHospitalar.json");
        writer.write(dados.toString());
        ErrorHandler.exibirMsgInfo("Exportação Realizada com Sucesso", "Exportar JSON");
        writer.close();
        }catch(Exception ex){
            ErrorHandler.exibirMsgErro("Tente Novamente", "Exportar JSON");
        }
    }
    
}
