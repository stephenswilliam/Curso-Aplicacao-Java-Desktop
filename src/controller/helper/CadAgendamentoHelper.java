
package controller.helper;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Medico;
import model.Paciente;
import view.CadAgendamento;


public class CadAgendamentoHelper {
    
    CadAgendamento view;

    public CadAgendamentoHelper(CadAgendamento view) {
        this.view = view;
        view.getjTablePaciente().getColumnModel().getColumn(0).setPreferredWidth(220);
        view.getjTablePaciente().getColumnModel().getColumn(1).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(2).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(3).setPreferredWidth(100);
        view.getjTableMedico().getColumnModel().getColumn(0).setPreferredWidth(220);
        view.getjTableMedico().getColumnModel().getColumn(1).setPreferredWidth(100);
        view.getjTableMedico().getColumnModel().getColumn(2).setPreferredWidth(60);
    }
    
    
    public void limpaCadAgendamento(){
        view.getjTextFieldPaciente().setText("");
        view.getjTextFieldMedico().setText("");
        view.getjTextAreaSintomas().setText("");
        view.getjTextFieldMedico().setText("");
        view.getjComboBoxPeriodo().setSelectedIndex(0);
        view.getjDateChooserAgendamento().setCalendar(null);
        DefaultTableModel tableModelPaciente = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModelPaciente.setNumRows(0);
        DefaultTableModel tableModelMedico = (DefaultTableModel) view.getjTableMedico().getModel();
        tableModelMedico.setNumRows(0);
    }
    
    public void preencherTabelaMedicos(ArrayList<Medico> medicos){
        //Monta tabela de medicos
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTableMedico().getModel();
        tableModel.setNumRows(0);
        for (Medico medico : medicos) {
            tableModel.addRow(new Object[]{
                medico.getNomeMedico(),
                medico.getEspecialidadeMedico(),
                medico.getCrmMedico()
              });
        }
    }

    public void preencherTabelaPacientes(ArrayList<Paciente> pacientes) {
         //Monta tabela de pacientes
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModel.setNumRows(0);
        for (Paciente paciente : pacientes) {
            tableModel.addRow(new Object[]{
                paciente.getNome(),
                paciente.getDataNascimento(),
                paciente.getRg(),
                paciente.getTelefone()
              });
        }
    }

    public Agendamento obtemDadosAgendamento() {
        Agendamento agendamento = new Agendamento();
        agendamento.setCodAgendamento(0);
        agendamento.setCodPaciente(0);
        agendamento.setCodMedico(0);
        agendamento.setSintomasAgendamento(view.getjTextAreaSintomas().getText());
        agendamento.setPeriodoAgendamento((String) view.getjComboBoxPeriodo().getSelectedItem());
        try {
        agendamento.setDataAgendamento(new java.sql.Date(view.getjDateChooserAgendamento().getDate().getTime()));
        }catch (Exception e){
            agendamento.setDataAgendamento(null);
        }
        agendamento.setStatusAgendamento("Agendado");
        return agendamento;
    }
    
    
}
