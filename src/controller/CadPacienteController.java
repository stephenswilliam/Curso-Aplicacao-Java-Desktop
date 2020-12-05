
package controller;

import controller.helper.CadPacienteHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bairro;
import model.DAO.BairroDAO;
import model.DAO.PacienteDAO;
import model.Paciente;
import view.CadPaciente;

public class CadPacienteController {
    
    CadPaciente view;
    CadPacienteHelper helper;
    ArrayList<Bairro> bairros;
    Paciente paciente = new Paciente();
    ArrayList<Paciente> pacientesPesquisados;

    public CadPacienteController(CadPaciente view) {
        this.view = view;
        helper = new CadPacienteHelper(view);
        BairroDAO bairroDAO = new BairroDAO();
        bairros = bairroDAO.obtemBairros();
        helper.iniciaTabelaBairros(bairros);
        helper.iniciaCadPaciente();
              
    }
 public void pesquisaPaciente(){
        //limpa tabela
        view.getjTablePaciente().getColumnModel().getColumn(0).setPreferredWidth(220);
        view.getjTablePaciente().getColumnModel().getColumn(1).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(2).setPreferredWidth(100);
        view.getjTablePaciente().getColumnModel().getColumn(3).setPreferredWidth(100);
        DefaultTableModel tableModel = (DefaultTableModel) view.getjTablePaciente().getModel();
        tableModel.setNumRows(0);
        //
        this.paciente = helper.obterPacientePesquisa();
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacientesPesquisados = pacienteDAO.pesquisaPaciente(this.paciente);
        if (!pacientesPesquisados.isEmpty()){
            helper.preencherTabelaPacientes(pacientesPesquisados);
            }
    } 
    public void novoPaciente() {
        helper.iniciaCadPaciente();
        helper.preparaNovoPaciente();
    }

    public void cancelaPaciente() {
        helper.iniciaCadPaciente();
    }

    public void salvaPaciente() {
        helper.obtemPaciente(paciente);
        boolean pacienteValido = this.validarPaciente();
        if (pacienteValido){
            PacienteDAO pacienteDAO = new PacienteDAO();
            if (paciente.getCod() == 0) {
                pacienteDAO.inserirPaciente(paciente);
            } else {
                pacienteDAO.alterarPaciente(paciente);
            }
            helper.iniciaCadPaciente();
        }
    }

    private boolean validarPaciente() {
        if (paciente.getNome().isEmpty()){
           view.mostraMensagem("Nome do paciente invalido!");
           view.getjTextFieldNome().requestFocus();
           return (false);
        }else{
        if (paciente.getTelefone().isEmpty() ){
            view.mostraMensagem("Telefone do paciente invalido!");
            view.getjTextTelefone().requestFocus();
            return (false);
        }
        }
        return(true);
    }

    private boolean validarPacientePesquisa() {
         if ("".equals(paciente.getNome())){
           view.mostraMensagem("Paciente não encontrado!");
           return (false);
        }else{
           return (true);
        }
    }

    public void pacienteSelecionado() {
        helper.montaPacienteSelecionado(pacientesPesquisados, bairros);
    }
    public void editaPaciente(){
        helper.prepararEditarPaciente();
    }

    public void excluiPaciente() {
        helper.obtemPaciente(paciente);
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.excluiPaciente(paciente);
        helper.iniciaCadPaciente();
    }
    
}
