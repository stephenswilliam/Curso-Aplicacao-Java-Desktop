
package controller;

import controller.helper.CadAgendamentoHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.DAO.AgendamentoDAO;
import model.DAO.MedicoDAO;
import model.DAO.PacienteDAO;
import model.Medico;
import model.Paciente;
import view.CadAgendamento;

public class CadAgendamentoController {
    
    CadAgendamento view;
    CadAgendamentoHelper helper; 
    Agendamento agendamento;
    Medico medico = new Medico();
    Paciente paciente = new Paciente();
    ArrayList<Medico> medicosPesquisados;
    ArrayList<Paciente> pacientesPesquisados;
    
    
    public CadAgendamentoController(CadAgendamento view) {
        this.view = view;
        this.helper = new CadAgendamentoHelper(view);
        this.helper.limpaCadAgendamento();
    }

    public void buscaPaciente() {
        paciente.setNome(view.getjTextFieldPaciente().getText());
        //limpa tabela
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacientesPesquisados = pacienteDAO.pesquisaPaciente(this.paciente);
        if (!pacientesPesquisados.isEmpty()){
            helper.preencherTabelaPacientes(pacientesPesquisados);
        }
    }

    public void buscaMedico() {
        //limpa tabela
        medico.setNomeMedico(view.getjTextFieldMedico().getText());
        MedicoDAO medicoDAO = new MedicoDAO();
        medicosPesquisados = medicoDAO.pesquisaMedico(this.medico);
        if (!medicosPesquisados.isEmpty()){
            helper.preencherTabelaMedicos(medicosPesquisados);
        }
    }

    public void medicoSelecionado() {
        int indice;
        indice = view.getjTableMedico().getSelectedRow();
        view.getjTextFieldMedico().setText((String) view.getjTableMedico().getValueAt(indice, 0));
        
        
    }

    public void pacienteSelecionado() {
        int indice;
        indice = view.getjTablePaciente().getSelectedRow();
        view.getjTextFieldPaciente().setText((String) view.getjTablePaciente().getValueAt(indice, 0));
    }

    public void cancelaAgendamento() {
        helper.limpaCadAgendamento();
    }

    public void salvaAgendamento() {
        agendamento = helper.obtemDadosAgendamento();
        paciente.setNome(view.getjTextFieldPaciente().getText());
        //Valida Paciente
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacientesPesquisados = pacienteDAO.pesquisaPaciente(this.paciente);
        if (("".equals(paciente.getNome()))  || (pacientesPesquisados.isEmpty())){
            view.mostraMensagem("Paciente não cadastrado!");
        }else{
            agendamento.setCodPaciente(pacientesPesquisados.get(0).getCod());
            //Valida Sintomas
            if (agendamento.getSintomasAgendamento().isEmpty()){
                view.mostraMensagem("Informe os sintomas!");
            }else{
                //Valida Medico
                medico.setNomeMedico(view.getjTextFieldMedico().getText());
                MedicoDAO medicoDAO = new MedicoDAO();
                medicosPesquisados = medicoDAO.pesquisaMedico(this.medico);
                if(("".equals(medico.getNomeMedico()))  || (medicosPesquisados.isEmpty())){
                    view.mostraMensagem("Medico não cadastrado!");
                }else{
                    agendamento.setCodMedico(medicosPesquisados.get(0).getCodMedico());
                    //Valida a data
                    if (agendamento.getDataAgendamento()==null){
                        view.mostraMensagem("Data não informada!");
                    }else{
                        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
                        agendamentoDAO.insertAgendamento(agendamento);
                        helper.limpaCadAgendamento();
                    }
                }
            }
        }
    }

    private void procuraPaciente() {
        paciente.setNome(view.getjTextFieldPaciente().getText());
        //Obtem codigo Paciente
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacientesPesquisados = pacienteDAO.pesquisaPaciente(this.paciente);
        if (pacientesPesquisados.isEmpty()){
            view.mostraMensagem("Paciente invalido");
        }else{
            agendamento.setCodPaciente(pacientesPesquisados.get(0).getCod());
        }
         //Obtem codigo Medico
        medico.setNomeMedico(view.getjTextFieldMedico().getText());
        MedicoDAO medicoDAO = new MedicoDAO();
        medicosPesquisados = medicoDAO.pesquisaMedico(this.medico);
        if (medicosPesquisados.isEmpty()){
            view.mostraMensagem("Medico Invalido");
        }else{
            agendamento.setCodPaciente(pacientesPesquisados.get(0).getCod());
        }
    }
    
    

 
    
    
    
}
